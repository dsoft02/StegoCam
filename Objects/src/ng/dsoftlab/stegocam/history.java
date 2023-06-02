package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class history extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static history mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.history");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (history).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.history");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.history", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (history) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (history) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return history.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (history) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (history) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            history mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (history) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static int _numberofcolumns = 0;
public static int _currow = 0;
public static int _curcol = 0;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public ng.dsoftlab.stegocam.b4xtable _b4xtable1 = null;
public ng.dsoftlab.stegocam.b4xdialog _dialog = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnprev = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnextract = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshare = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgpreview = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpreview = null;
public static float _startx = 0f;
public static float _starty = 0f;
public anywheresoftware.b4a.objects.LabelWrapper _lblimglocation = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgdelete = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgextract = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgshare = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldelete = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlextract = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlshare = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.encode _encode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=56557568;
 //BA.debugLineNum = 56557568;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=56557570;
 //BA.debugLineNum = 56557570;BA.debugLine="Activity.LoadLayout(\"history\")";
mostCurrent._activity.LoadLayout("history",mostCurrent.activityBA);
RDebugUtils.currentLine=56557571;
 //BA.debugLineNum = 56557571;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=56557572;
 //BA.debugLineNum = 56557572;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=56557573;
 //BA.debugLineNum = 56557573;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=56557574;
 //BA.debugLineNum = 56557574;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=56557575;
 //BA.debugLineNum = 56557575;BA.debugLine="Dialog.Initialize(Activity)";
mostCurrent._dialog._initialize /*String*/ (null,mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())));
RDebugUtils.currentLine=56557576;
 //BA.debugLineNum = 56557576;BA.debugLine="Dialog.Title = \"Stego Image View\"";
mostCurrent._dialog._title /*Object*/  = (Object)("Stego Image View");
RDebugUtils.currentLine=56557577;
 //BA.debugLineNum = 56557577;BA.debugLine="FindPictures";
_findpictures();
RDebugUtils.currentLine=56557578;
 //BA.debugLineNum = 56557578;BA.debugLine="End Sub";
return "";
}
public static void  _findpictures() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "findpictures", false))
	 {Debug.delegate(mostCurrent.activityBA, "findpictures", null); return;}
ResumableSub_FindPictures rsub = new ResumableSub_FindPictures(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_FindPictures extends BA.ResumableSub {
public ResumableSub_FindPictures(ng.dsoftlab.stegocam.history parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.history parent;
anywheresoftware.b4a.objects.collections.List _allpictures = null;
String _picturesfolder = "";
boolean _success = false;
anywheresoftware.b4a.objects.collections.List _files = null;
String _f = "";
anywheresoftware.b4a.BA.IterableList group7;
int index7;
int groupLen7;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="history";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=61407233;
 //BA.debugLineNum = 61407233;BA.debugLine="Dim AllPictures As List";
_allpictures = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=61407234;
 //BA.debugLineNum = 61407234;BA.debugLine="AllPictures.Initialize";
_allpictures.Initialize();
RDebugUtils.currentLine=61407235;
 //BA.debugLineNum = 61407235;BA.debugLine="Dim PicturesFolder As String = config.stegoImageP";
_picturesfolder = parent.mostCurrent._config._stegoimagepath /*String*/ ;
RDebugUtils.currentLine=61407236;
 //BA.debugLineNum = 61407236;BA.debugLine="If File.Exists(PicturesFolder, \"\") = False Then C";
if (true) break;

case 1:
//if
this.state = 6;
if (anywheresoftware.b4a.keywords.Common.File.Exists(_picturesfolder,"")==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
this.state = -1;
if (true) break;;
if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=61407237;
 //BA.debugLineNum = 61407237;BA.debugLine="Wait For (File.ListFilesAsync(PicturesFolder)) Co";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "history", "findpictures"), anywheresoftware.b4a.keywords.Common.File.ListFilesAsync(processBA,_picturesfolder));
this.state = 15;
return;
case 15:
//C
this.state = 7;
_success = (Boolean) result[0];
_files = (anywheresoftware.b4a.objects.collections.List) result[1];
;
RDebugUtils.currentLine=61407238;
 //BA.debugLineNum = 61407238;BA.debugLine="If Success Then";
if (true) break;

case 7:
//if
this.state = 14;
if (_success) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=61407239;
 //BA.debugLineNum = 61407239;BA.debugLine="For Each f As String In Files";
if (true) break;

case 10:
//for
this.state = 13;
group7 = _files;
index7 = 0;
groupLen7 = group7.getSize();
this.state = 16;
if (true) break;

case 16:
//C
this.state = 13;
if (index7 < groupLen7) {
this.state = 12;
_f = BA.ObjectToString(group7.Get(index7));}
if (true) break;

case 17:
//C
this.state = 16;
index7++;
if (true) break;

case 12:
//C
this.state = 17;
RDebugUtils.currentLine=61407240;
 //BA.debugLineNum = 61407240;BA.debugLine="AllPictures.Add(File.Combine(PicturesFolder, f)";
_allpictures.Add((Object)(anywheresoftware.b4a.keywords.Common.File.Combine(_picturesfolder,_f)));
 if (true) break;
if (true) break;

case 13:
//C
this.state = 14;
;
 if (true) break;

case 14:
//C
this.state = -1;
;
RDebugUtils.currentLine=61407244;
 //BA.debugLineNum = 61407244;BA.debugLine="CreateTable(AllPictures)";
_createtable(_allpictures);
RDebugUtils.currentLine=61407245;
 //BA.debugLineNum = 61407245;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=56819712;
 //BA.debugLineNum = 56819712;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=56819713;
 //BA.debugLineNum = 56819713;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And Dialog.Clo";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._dialog._close /*boolean*/ (null,mostCurrent._xui.DialogResponse_Cancel)) { 
RDebugUtils.currentLine=56819714;
 //BA.debugLineNum = 56819714;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=56819716;
 //BA.debugLineNum = 56819716;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=56819717;
 //BA.debugLineNum = 56819717;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
RDebugUtils.currentLine=56819718;
 //BA.debugLineNum = 56819718;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=56819719;
 //BA.debugLineNum = 56819719;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=56819723;
 //BA.debugLineNum = 56819723;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=56819724;
 //BA.debugLineNum = 56819724;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="history";
RDebugUtils.currentLine=56688640;
 //BA.debugLineNum = 56688640;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=56688642;
 //BA.debugLineNum = 56688642;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=56623104;
 //BA.debugLineNum = 56623104;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=56623106;
 //BA.debugLineNum = 56623106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=61997056;
 //BA.debugLineNum = 61997056;BA.debugLine="Sub Activity_Touch (Action As Int, X As Float, Y A";
RDebugUtils.currentLine=61997057;
 //BA.debugLineNum = 61997057;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_UP)) {
case 0: {
RDebugUtils.currentLine=61997059;
 //BA.debugLineNum = 61997059;BA.debugLine="startX = X";
_startx = _x;
RDebugUtils.currentLine=61997060;
 //BA.debugLineNum = 61997060;BA.debugLine="startY = Y";
_starty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=61997062;
 //BA.debugLineNum = 61997062;BA.debugLine="If Abs(y - startY) > 20%y Then Return";
if (anywheresoftware.b4a.keywords.Common.Abs(_y-_starty)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA)) { 
if (true) return "";};
RDebugUtils.currentLine=61997063;
 //BA.debugLineNum = 61997063;BA.debugLine="If X - startX > 30%x Then";
if (_x-_startx>anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA)) { 
RDebugUtils.currentLine=61997064;
 //BA.debugLineNum = 61997064;BA.debugLine="If btnPrev.Enabled=True Then CallSub(\"\",btnPre";
if (mostCurrent._btnprev.getEnabled()==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(""),_btnprev_click());};
 }else 
{RDebugUtils.currentLine=61997065;
 //BA.debugLineNum = 61997065;BA.debugLine="Else If startX - x > 30%x Then";
if (_startx-_x>anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA)) { 
RDebugUtils.currentLine=61997066;
 //BA.debugLineNum = 61997066;BA.debugLine="If btnNext.Enabled=True Then CallSub(\"\",btnNex";
if (mostCurrent._btnnext.getEnabled()==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(""),_btnnext_click());};
 }}
;
 break; }
}
;
RDebugUtils.currentLine=61997070;
 //BA.debugLineNum = 61997070;BA.debugLine="End Sub";
return "";
}
public static String  _btnprev_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnprev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnprev_click", null));}
RDebugUtils.currentLine=61800448;
 //BA.debugLineNum = 61800448;BA.debugLine="Sub btnPrev_Click";
RDebugUtils.currentLine=61800449;
 //BA.debugLineNum = 61800449;BA.debugLine="B4XTable1.CurrentPage = B4XTable1.CurrentPage - 1";
mostCurrent._b4xtable1._setcurrentpage /*int*/ (null,(int) (mostCurrent._b4xtable1._getcurrentpage /*int*/ (null)-1));
RDebugUtils.currentLine=61800450;
 //BA.debugLineNum = 61800450;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=56754176;
 //BA.debugLineNum = 56754176;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=56754177;
 //BA.debugLineNum = 56754177;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
RDebugUtils.currentLine=56754178;
 //BA.debugLineNum = 56754178;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=56754179;
 //BA.debugLineNum = 56754179;BA.debugLine="End Sub";
return "";
}
public static String  _b4xtable1_dataupdated() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "b4xtable1_dataupdated", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "b4xtable1_dataupdated", null));}
anywheresoftware.b4a.objects.collections.Map _row = null;
int _i = 0;
long _rowid = 0L;
ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn _column = null;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _iv = null;
RDebugUtils.currentLine=61603840;
 //BA.debugLineNum = 61603840;BA.debugLine="Sub B4XTable1_DataUpdated";
RDebugUtils.currentLine=61603841;
 //BA.debugLineNum = 61603841;BA.debugLine="Dim row As Map";
_row = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=61603842;
 //BA.debugLineNum = 61603842;BA.debugLine="For i = 0 To B4XTable1.VisibleRowIds.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._b4xtable1._visiblerowids /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=61603843;
 //BA.debugLineNum = 61603843;BA.debugLine="Dim RowId As Long = B4XTable1.VisibleRowIds.Get(";
_rowid = BA.ObjectToLongNumber(mostCurrent._b4xtable1._visiblerowids /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=61603844;
 //BA.debugLineNum = 61603844;BA.debugLine="If RowId > 0 Then";
if (_rowid>0) { 
RDebugUtils.currentLine=61603845;
 //BA.debugLineNum = 61603845;BA.debugLine="row = B4XTable1.GetRow(RowId)";
_row = mostCurrent._b4xtable1._getrow /*anywheresoftware.b4a.objects.collections.Map*/ (null,_rowid);
 }else {
RDebugUtils.currentLine=61603847;
 //BA.debugLineNum = 61603847;BA.debugLine="row = CreateMap()";
_row = anywheresoftware.b4a.keywords.Common.createMap(new Object[] {});
 };
RDebugUtils.currentLine=61603849;
 //BA.debugLineNum = 61603849;BA.debugLine="For Each column As B4XTableColumn In B4XTable1.C";
{
final anywheresoftware.b4a.BA.IterableList group9 = mostCurrent._b4xtable1._columns /*anywheresoftware.b4a.objects.collections.List*/ ;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_column = (ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn)(group9.Get(index9));
RDebugUtils.currentLine=61603850;
 //BA.debugLineNum = 61603850;BA.debugLine="Dim pnl As B4XView = column.CellsLayouts.Get(i";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_column.CellsLayouts /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (_i+1))));
RDebugUtils.currentLine=61603851;
 //BA.debugLineNum = 61603851;BA.debugLine="Dim iv As B4XView = pnl.GetView(1) 'ImageView w";
_iv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_iv = _pnl.GetView((int) (1));
RDebugUtils.currentLine=61603852;
 //BA.debugLineNum = 61603852;BA.debugLine="If row.GetDefault(column.Id, \"\") <> \"\" Then";
if ((_row.GetDefault((Object)(_column.Id /*String*/ ),(Object)(""))).equals((Object)("")) == false) { 
RDebugUtils.currentLine=61603853;
 //BA.debugLineNum = 61603853;BA.debugLine="iv.SetBitmap(xui.LoadBitmapResize(\"\", row.Get(";
_iv.SetBitmap((android.graphics.Bitmap)(mostCurrent._xui.LoadBitmapResize("",BA.ObjectToString(_row.Get((Object)(_column.Id /*String*/ ))),_iv.getWidth(),_iv.getHeight(),anywheresoftware.b4a.keywords.Common.False).getObject()));
 }else {
RDebugUtils.currentLine=61603855;
 //BA.debugLineNum = 61603855;BA.debugLine="iv.SetBitmap(Null)";
_iv.SetBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 };
 }
};
 }
};
RDebugUtils.currentLine=61603859;
 //BA.debugLineNum = 61603859;BA.debugLine="btnNext.Enabled = B4XTable1.lblNext.Tag";
mostCurrent._btnnext.setEnabled(BA.ObjectToBoolean(mostCurrent._b4xtable1._lblnext /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag()));
RDebugUtils.currentLine=61603860;
 //BA.debugLineNum = 61603860;BA.debugLine="btnPrev.Enabled = B4XTable1.lblBack.Tag";
mostCurrent._btnprev.setEnabled(BA.ObjectToBoolean(mostCurrent._b4xtable1._lblback /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag()));
RDebugUtils.currentLine=61603861;
 //BA.debugLineNum = 61603861;BA.debugLine="End Sub";
return "";
}
public static String  _btncancel_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncancel_click", null));}
RDebugUtils.currentLine=56885248;
 //BA.debugLineNum = 56885248;BA.debugLine="Private Sub btnCancel_Click";
RDebugUtils.currentLine=56885250;
 //BA.debugLineNum = 56885250;BA.debugLine="End Sub";
return "";
}
public static String  _btnnext_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnext_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnext_click", null));}
RDebugUtils.currentLine=61734912;
 //BA.debugLineNum = 61734912;BA.debugLine="Sub btnNext_Click";
RDebugUtils.currentLine=61734913;
 //BA.debugLineNum = 61734913;BA.debugLine="B4XTable1.CurrentPage = B4XTable1.CurrentPage + 1";
mostCurrent._b4xtable1._setcurrentpage /*int*/ (null,(int) (mostCurrent._b4xtable1._getcurrentpage /*int*/ (null)+1));
RDebugUtils.currentLine=61734914;
 //BA.debugLineNum = 61734914;BA.debugLine="End Sub";
return "";
}
public static String  _btnshare_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnshare_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnshare_click", null));}
RDebugUtils.currentLine=61865984;
 //BA.debugLineNum = 61865984;BA.debugLine="Private Sub btnShare_Click";
RDebugUtils.currentLine=61865986;
 //BA.debugLineNum = 61865986;BA.debugLine="End Sub";
return "";
}
public static void  _imgdelete_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgdelete_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "imgdelete_click", null); return;}
ResumableSub_imgDelete_Click rsub = new ResumableSub_imgDelete_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_imgDelete_Click extends BA.ResumableSub {
public ResumableSub_imgDelete_Click(ng.dsoftlab.stegocam.history parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.history parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="history";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=64815105;
 //BA.debugLineNum = 64815105;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete fil";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete file?"),BA.ObjectToCharSequence("Delete Image"),"Yes","No","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=64815106;
 //BA.debugLineNum = 64815106;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "history", "imgdelete_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=64815107;
 //BA.debugLineNum = 64815107;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=64815108;
 //BA.debugLineNum = 64815108;BA.debugLine="File.Delete(lblImgLocation.Text,\"\")";
anywheresoftware.b4a.keywords.Common.File.Delete(parent.mostCurrent._lblimglocation.getText(),"");
RDebugUtils.currentLine=64815109;
 //BA.debugLineNum = 64815109;BA.debugLine="FindPictures";
_findpictures();
RDebugUtils.currentLine=64815110;
 //BA.debugLineNum = 64815110;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
parent.mostCurrent._dialog._close /*boolean*/ (null,parent.mostCurrent._xui.DialogResponse_Cancel);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=64815112;
 //BA.debugLineNum = 64815112;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _imgextract_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgextract_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgextract_click", null));}
RDebugUtils.currentLine=64749568;
 //BA.debugLineNum = 64749568;BA.debugLine="Private Sub imgExtract_Click";
RDebugUtils.currentLine=64749570;
 //BA.debugLineNum = 64749570;BA.debugLine="End Sub";
return "";
}
public static String  _imgshare_click() throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgshare_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgshare_click", null));}
String _filename = "";
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
anywheresoftware.b4a.objects.IntentWrapper _inten = null;
String _tmpt = "";
RDebugUtils.currentLine=64684032;
 //BA.debugLineNum = 64684032;BA.debugLine="Private Sub imgShare_Click";
RDebugUtils.currentLine=64684033;
 //BA.debugLineNum = 64684033;BA.debugLine="Try";
try {RDebugUtils.currentLine=64684034;
 //BA.debugLineNum = 64684034;BA.debugLine="Dim filename As String=lblImgLocation.Text.SubSt";
_filename = mostCurrent._lblimglocation.getText().substring((int) (mostCurrent._lblimglocation.getText().lastIndexOf("/")+1));
RDebugUtils.currentLine=64684035;
 //BA.debugLineNum = 64684035;BA.debugLine="File.Copy(lblImgLocation.Text,\"\", Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._lblimglocation.getText(),"",mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
RDebugUtils.currentLine=64684036;
 //BA.debugLineNum = 64684036;BA.debugLine="Dim u As Uri 'ContentResolver library";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=64684037;
 //BA.debugLineNum = 64684037;BA.debugLine="u.Parse(Starter.Provider.GetFileUri(filename))";
_u.Parse(BA.ObjectToString(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._getfileuri /*Object*/ (null,_filename)));
RDebugUtils.currentLine=64684038;
 //BA.debugLineNum = 64684038;BA.debugLine="Dim inten As Intent";
_inten = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=64684039;
 //BA.debugLineNum = 64684039;BA.debugLine="Dim tmpt As String = \"\"";
_tmpt = "";
RDebugUtils.currentLine=64684040;
 //BA.debugLineNum = 64684040;BA.debugLine="inten.Initialize(inten.ACTION_SEND,\"\")";
_inten.Initialize(_inten.ACTION_SEND,"");
RDebugUtils.currentLine=64684041;
 //BA.debugLineNum = 64684041;BA.debugLine="inten.SetType(\"image/*\")";
_inten.SetType("image/*");
RDebugUtils.currentLine=64684042;
 //BA.debugLineNum = 64684042;BA.debugLine="inten.PutExtra(\"android.intent.extra.STREAM\",u)";
_inten.PutExtra("android.intent.extra.STREAM",(Object)(_u.getObject()));
RDebugUtils.currentLine=64684045;
 //BA.debugLineNum = 64684045;BA.debugLine="StartActivity(inten)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_inten.getObject()));
 } 
       catch (Exception e13) {
			processBA.setLastException(e13);RDebugUtils.currentLine=64684047;
 //BA.debugLineNum = 64684047;BA.debugLine="ToastMessageShow(LastException.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=64684049;
 //BA.debugLineNum = 64684049;BA.debugLine="End Sub";
return "";
}
public static String  _b4xtable1_cellclicked(String _columnid,long _rowid) throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "b4xtable1_cellclicked", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "b4xtable1_cellclicked", new Object[] {_columnid,_rowid}));}
String _img = "";
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
int _panelwidth = 0;
int _panelspacing = 0;
RDebugUtils.currentLine=61669376;
 //BA.debugLineNum = 61669376;BA.debugLine="Sub B4XTable1_CellClicked (ColumnId As String, Row";
RDebugUtils.currentLine=61669377;
 //BA.debugLineNum = 61669377;BA.debugLine="Dim img As String = B4XTable1.GetRow(RowId).Get(C";
_img = BA.ObjectToString(mostCurrent._b4xtable1._getrow /*anywheresoftware.b4a.objects.collections.Map*/ (null,_rowid).Get((Object)(_columnid)));
RDebugUtils.currentLine=61669378;
 //BA.debugLineNum = 61669378;BA.debugLine="curCol=ColumnId";
_curcol = (int)(Double.parseDouble(_columnid));
RDebugUtils.currentLine=61669379;
 //BA.debugLineNum = 61669379;BA.debugLine="curRow = RowId";
_currow = (int) (_rowid);
RDebugUtils.currentLine=61669380;
 //BA.debugLineNum = 61669380;BA.debugLine="If img <> \"\" Then";
if ((_img).equals("") == false) { 
RDebugUtils.currentLine=61669381;
 //BA.debugLineNum = 61669381;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=61669384;
 //BA.debugLineNum = 61669384;BA.debugLine="pnl.SetLayoutAnimated(0, 0, 0, 90%x, 80%y)";
_pnl.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
RDebugUtils.currentLine=61669385;
 //BA.debugLineNum = 61669385;BA.debugLine="pnl.LoadLayout(\"embedDialog\")";
_pnl.LoadLayout("embedDialog",mostCurrent.activityBA);
RDebugUtils.currentLine=61669389;
 //BA.debugLineNum = 61669389;BA.debugLine="imgPreview.Width=pnlPreview.Width-20";
mostCurrent._imgpreview.setWidth((int) (mostCurrent._pnlpreview.getWidth()-20));
RDebugUtils.currentLine=61669390;
 //BA.debugLineNum = 61669390;BA.debugLine="imgPreview.Height=imgPreview.Width";
mostCurrent._imgpreview.setHeight(mostCurrent._imgpreview.getWidth());
RDebugUtils.currentLine=61669391;
 //BA.debugLineNum = 61669391;BA.debugLine="imgPreview.Left=pnlPreview.Width/2 - imgPreview.";
mostCurrent._imgpreview.setLeft((int) (mostCurrent._pnlpreview.getWidth()/(double)2-mostCurrent._imgpreview.getWidth()/(double)2));
RDebugUtils.currentLine=61669392;
 //BA.debugLineNum = 61669392;BA.debugLine="imgPreview.Bitmap = xui.LoadBitmapResize(\"\", img";
mostCurrent._imgpreview.setBitmap((android.graphics.Bitmap)(mostCurrent._xui.LoadBitmapResize("",_img,mostCurrent._imgpreview.getWidth(),mostCurrent._imgpreview.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=61669394;
 //BA.debugLineNum = 61669394;BA.debugLine="pnlExtract.Top=imgPreview.Top+imgPreview.Height+";
mostCurrent._pnlextract.setTop((int) (mostCurrent._imgpreview.getTop()+mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=61669395;
 //BA.debugLineNum = 61669395;BA.debugLine="pnlDelete.Top=imgPreview.Top+imgPreview.Height+1";
mostCurrent._pnldelete.setTop((int) (mostCurrent._imgpreview.getTop()+mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=61669396;
 //BA.debugLineNum = 61669396;BA.debugLine="pnlShare.Top=imgPreview.Top+imgPreview.Height+10";
mostCurrent._pnlshare.setTop((int) (mostCurrent._imgpreview.getTop()+mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=61669398;
 //BA.debugLineNum = 61669398;BA.debugLine="Dim panelWidth, panelSpacing As Int";
_panelwidth = 0;
_panelspacing = 0;
RDebugUtils.currentLine=61669399;
 //BA.debugLineNum = 61669399;BA.debugLine="panelSpacing = 5dip";
_panelspacing = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5));
RDebugUtils.currentLine=61669400;
 //BA.debugLineNum = 61669400;BA.debugLine="panelWidth = (pnlPreview.Width / 3)";
_panelwidth = (int) ((mostCurrent._pnlpreview.getWidth()/(double)3));
RDebugUtils.currentLine=61669402;
 //BA.debugLineNum = 61669402;BA.debugLine="pnlExtract.Width  = panelWidth";
mostCurrent._pnlextract.setWidth(_panelwidth);
RDebugUtils.currentLine=61669403;
 //BA.debugLineNum = 61669403;BA.debugLine="pnlDelete.Width   = panelWidth";
mostCurrent._pnldelete.setWidth(_panelwidth);
RDebugUtils.currentLine=61669404;
 //BA.debugLineNum = 61669404;BA.debugLine="pnlShare.Width    = panelWidth";
mostCurrent._pnlshare.setWidth(_panelwidth);
RDebugUtils.currentLine=61669406;
 //BA.debugLineNum = 61669406;BA.debugLine="pnlExtract.Left=0";
mostCurrent._pnlextract.setLeft((int) (0));
RDebugUtils.currentLine=61669407;
 //BA.debugLineNum = 61669407;BA.debugLine="pnlDelete.Left=panelWidth";
mostCurrent._pnldelete.setLeft(_panelwidth);
RDebugUtils.currentLine=61669408;
 //BA.debugLineNum = 61669408;BA.debugLine="pnlShare.Left=(panelWidth * 2)";
mostCurrent._pnlshare.setLeft((int) ((_panelwidth*2)));
RDebugUtils.currentLine=61669413;
 //BA.debugLineNum = 61669413;BA.debugLine="imgExtract.Left=pnlExtract.Width/2-imgExtract.Wi";
mostCurrent._imgextract.setLeft((int) (mostCurrent._pnlextract.getWidth()/(double)2-mostCurrent._imgextract.getWidth()/(double)2));
RDebugUtils.currentLine=61669414;
 //BA.debugLineNum = 61669414;BA.debugLine="imgDelete.Left=pnlDelete.Width/2-imgDelete.Width";
mostCurrent._imgdelete.setLeft((int) (mostCurrent._pnldelete.getWidth()/(double)2-mostCurrent._imgdelete.getWidth()/(double)2));
RDebugUtils.currentLine=61669415;
 //BA.debugLineNum = 61669415;BA.debugLine="imgShare.Left=pnlShare.Width/2-imgShare.Width/2";
mostCurrent._imgshare.setLeft((int) (mostCurrent._pnlshare.getWidth()/(double)2-mostCurrent._imgshare.getWidth()/(double)2));
RDebugUtils.currentLine=61669417;
 //BA.debugLineNum = 61669417;BA.debugLine="Label1.Left=0";
mostCurrent._label1.setLeft((int) (0));
RDebugUtils.currentLine=61669418;
 //BA.debugLineNum = 61669418;BA.debugLine="Label1.Width=pnlExtract.Width";
mostCurrent._label1.setWidth(mostCurrent._pnlextract.getWidth());
RDebugUtils.currentLine=61669420;
 //BA.debugLineNum = 61669420;BA.debugLine="Label4.Left=0";
mostCurrent._label4.setLeft((int) (0));
RDebugUtils.currentLine=61669421;
 //BA.debugLineNum = 61669421;BA.debugLine="Label4.Width=pnlDelete.Width";
mostCurrent._label4.setWidth(mostCurrent._pnldelete.getWidth());
RDebugUtils.currentLine=61669423;
 //BA.debugLineNum = 61669423;BA.debugLine="Label2.Left=0";
mostCurrent._label2.setLeft((int) (0));
RDebugUtils.currentLine=61669424;
 //BA.debugLineNum = 61669424;BA.debugLine="Label2.Width=pnlShare.Width";
mostCurrent._label2.setWidth(mostCurrent._pnlshare.getWidth());
RDebugUtils.currentLine=61669427;
 //BA.debugLineNum = 61669427;BA.debugLine="lblImgLocation.Text=img";
mostCurrent._lblimglocation.setText(BA.ObjectToCharSequence(_img));
RDebugUtils.currentLine=61669428;
 //BA.debugLineNum = 61669428;BA.debugLine="Dialog.ShowCustom(pnl, \"Close\", \"\", \"\")";
mostCurrent._dialog._showcustom /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,_pnl,(Object)("Close"),(Object)(""),(Object)(""));
 };
RDebugUtils.currentLine=61669430;
 //BA.debugLineNum = 61669430;BA.debugLine="End Sub";
return "";
}
public static String  _createtable(anywheresoftware.b4a.objects.collections.List _files) throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createtable", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createtable", new Object[] {_files}));}
int _i = 0;
ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn _col = null;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
RDebugUtils.currentLine=61472768;
 //BA.debugLineNum = 61472768;BA.debugLine="Sub CreateTable (Files As List)";
RDebugUtils.currentLine=61472769;
 //BA.debugLineNum = 61472769;BA.debugLine="B4XTable1.Clear";
mostCurrent._b4xtable1._clear /*void*/ (null);
RDebugUtils.currentLine=61472770;
 //BA.debugLineNum = 61472770;BA.debugLine="B4XTable1.AllowSmallRowHeightModifications = Fals";
mostCurrent._b4xtable1._allowsmallrowheightmodifications /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=61472771;
 //BA.debugLineNum = 61472771;BA.debugLine="B4XTable1.RowHeight = 100dip";
mostCurrent._b4xtable1._rowheight /*int*/  = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=61472772;
 //BA.debugLineNum = 61472772;BA.debugLine="B4XTable1.SearchField.TextField.Enabled = False";
mostCurrent._b4xtable1._searchfield /*ng.dsoftlab.stegocam.b4xfloattextfield*/ ._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (null).setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61472773;
 //BA.debugLineNum = 61472773;BA.debugLine="B4XTable1.SearchField.TextField.Visible=False";
mostCurrent._b4xtable1._searchfield /*ng.dsoftlab.stegocam.b4xfloattextfield*/ ._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (null).setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61472774;
 //BA.debugLineNum = 61472774;BA.debugLine="B4XTable1.SearchField.mBase.Visible=False";
mostCurrent._b4xtable1._searchfield /*ng.dsoftlab.stegocam.b4xfloattextfield*/ ._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61472775;
 //BA.debugLineNum = 61472775;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=61472776;
 //BA.debugLineNum = 61472776;BA.debugLine="B4XTable1.AddColumn(i, B4XTable1.COLUMN_TYPE_TEX";
mostCurrent._b4xtable1._addcolumn /*ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn*/ (null,BA.NumberToString(_i),mostCurrent._b4xtable1._column_type_text /*int*/ );
 }
};
RDebugUtils.currentLine=61472779;
 //BA.debugLineNum = 61472779;BA.debugLine="B4XTable1.MaximumRowsPerPage = 20";
mostCurrent._b4xtable1._maximumrowsperpage /*int*/  = (int) (20);
RDebugUtils.currentLine=61472780;
 //BA.debugLineNum = 61472780;BA.debugLine="B4XTable1.BuildLayoutsCache(B4XTable1.MaximumRows";
mostCurrent._b4xtable1._buildlayoutscache /*String*/ (null,mostCurrent._b4xtable1._maximumrowsperpage /*int*/ );
RDebugUtils.currentLine=61472781;
 //BA.debugLineNum = 61472781;BA.debugLine="For Each col As B4XTableColumn In B4XTable1.Colum";
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._b4xtable1._columns /*anywheresoftware.b4a.objects.collections.List*/ ;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_col = (ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn)(group12.Get(index12));
RDebugUtils.currentLine=61472782;
 //BA.debugLineNum = 61472782;BA.debugLine="col.Sortable = False";
_col.Sortable /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=61472783;
 //BA.debugLineNum = 61472783;BA.debugLine="col.Width = 100%x / NumberOfColumns";
_col.Width /*int*/  = (int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)_numberofcolumns);
RDebugUtils.currentLine=61472784;
 //BA.debugLineNum = 61472784;BA.debugLine="For i = 0 To col.CellsLayouts.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (_col.CellsLayouts /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=61472785;
 //BA.debugLineNum = 61472785;BA.debugLine="Dim pnl As B4XView = col.CellsLayouts.Get(i)";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_col.CellsLayouts /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i)));
RDebugUtils.currentLine=61472786;
 //BA.debugLineNum = 61472786;BA.debugLine="pnl.GetView(0).Visible = False 'hide the label";
_pnl.GetView((int) (0)).setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=61472787;
 //BA.debugLineNum = 61472787;BA.debugLine="If i > 0 Then 'i = 0 is the header";
if (_i>0) { 
RDebugUtils.currentLine=61472788;
 //BA.debugLineNum = 61472788;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=61472789;
 //BA.debugLineNum = 61472789;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=61472790;
 //BA.debugLineNum = 61472790;BA.debugLine="pnl.AddView(iv, 2dip, 2dip, col.Width - 4dip,";
_pnl.AddView((android.view.View)(_iv.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_col.Width /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),(int) (mostCurrent._b4xtable1._rowheight /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 };
 }
};
 }
};
RDebugUtils.currentLine=61472794;
 //BA.debugLineNum = 61472794;BA.debugLine="LoadData(Files)";
_loaddata(_files);
RDebugUtils.currentLine=61472795;
 //BA.debugLineNum = 61472795;BA.debugLine="B4XTable1.mBase.Visible = True";
mostCurrent._b4xtable1._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=61472796;
 //BA.debugLineNum = 61472796;BA.debugLine="End Sub";
return "";
}
public static String  _loaddata(anywheresoftware.b4a.objects.collections.List _files) throws Exception{
RDebugUtils.currentModule="history";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loaddata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loaddata", new Object[] {_files}));}
anywheresoftware.b4a.objects.collections.List _data = null;
Object[] _row = null;
int _index = 0;
String _f = "";
int _i = 0;
RDebugUtils.currentLine=61538304;
 //BA.debugLineNum = 61538304;BA.debugLine="Private Sub LoadData (Files As List)";
RDebugUtils.currentLine=61538305;
 //BA.debugLineNum = 61538305;BA.debugLine="Dim Data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=61538306;
 //BA.debugLineNum = 61538306;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=61538307;
 //BA.debugLineNum = 61538307;BA.debugLine="Dim row(NumberOfColumns) As Object";
_row = new Object[_numberofcolumns];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
RDebugUtils.currentLine=61538308;
 //BA.debugLineNum = 61538308;BA.debugLine="Dim index As Int = -1";
_index = (int) (-1);
RDebugUtils.currentLine=61538309;
 //BA.debugLineNum = 61538309;BA.debugLine="For Each f As String In Files";
{
final anywheresoftware.b4a.BA.IterableList group5 = _files;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_f = BA.ObjectToString(group5.Get(index5));
RDebugUtils.currentLine=61538310;
 //BA.debugLineNum = 61538310;BA.debugLine="If f.EndsWith(\".jpg\") Or f.EndsWith(\".png\") Then";
if (_f.endsWith(".jpg") || _f.endsWith(".png")) { 
RDebugUtils.currentLine=61538311;
 //BA.debugLineNum = 61538311;BA.debugLine="index = (index + 1) Mod NumberOfColumns";
_index = (int) ((_index+1)%_numberofcolumns);
RDebugUtils.currentLine=61538312;
 //BA.debugLineNum = 61538312;BA.debugLine="row(index) = f";
_row[_index] = (Object)(_f);
RDebugUtils.currentLine=61538313;
 //BA.debugLineNum = 61538313;BA.debugLine="If index = NumberOfColumns - 1 Then";
if (_index==_numberofcolumns-1) { 
RDebugUtils.currentLine=61538314;
 //BA.debugLineNum = 61538314;BA.debugLine="Data.Add(row)";
_data.Add((Object)(_row));
RDebugUtils.currentLine=61538315;
 //BA.debugLineNum = 61538315;BA.debugLine="Dim row(NumberOfColumns) As Object";
_row = new Object[_numberofcolumns];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
 };
 };
 }
};
RDebugUtils.currentLine=61538319;
 //BA.debugLineNum = 61538319;BA.debugLine="If index < NumberOfColumns - 1 Then";
if (_index<_numberofcolumns-1) { 
RDebugUtils.currentLine=61538321;
 //BA.debugLineNum = 61538321;BA.debugLine="For i = index + 1 To NumberOfColumns - 1";
{
final int step16 = 1;
final int limit16 = (int) (_numberofcolumns-1);
_i = (int) (_index+1) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=61538322;
 //BA.debugLineNum = 61538322;BA.debugLine="row(i) = \"\"";
_row[_i] = (Object)("");
 }
};
RDebugUtils.currentLine=61538324;
 //BA.debugLineNum = 61538324;BA.debugLine="Data.Add(row)";
_data.Add((Object)(_row));
 };
RDebugUtils.currentLine=61538326;
 //BA.debugLineNum = 61538326;BA.debugLine="B4XTable1.SetData(Data)";
mostCurrent._b4xtable1._setdata /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,_data);
RDebugUtils.currentLine=61538327;
 //BA.debugLineNum = 61538327;BA.debugLine="End Sub";
return "";
}
}