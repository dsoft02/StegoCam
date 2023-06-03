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

public class encode extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static encode mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.encode");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (encode).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.encode");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.encode", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (encode) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (encode) Resume **");
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
		return encode.class;
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
            BA.LogInfo("** Activity (encode) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (encode) Pause event (activity is not paused). **");
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
            encode mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (encode) Resume **");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static Object _ion = null;
public static String _tempimagefile = "";
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _lastpicture = null;
public static anywheresoftware.b4a.phone.Phone.ContentChooser _imagechooser = null;
public static ng.dsoftlab.stegocam.filehandler _filehandler1 = null;
public static ng.dsoftlab.stegocam.stegocamhandler _stegohandler = null;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public anywheresoftware.b4a.objects.IME _ime = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public ng.dsoftlab.stegocam.b4xdialog _dialog = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnencode = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerrormsg = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlencryption = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlkey = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmessage = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtkey = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmessage = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgcover = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcoverimage = null;
public ng.dsoftlab.stegocam.b4xcombobox _cboencryption = null;
public ng.dsoftlab.stegocam.bctoast _toast = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _btnbrowse = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblshowpassword = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgpreview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnextract = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshare = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblimglocation = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpreview = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgdelete = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgextract = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgshare = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldelete = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlextract = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlshare = null;
public b4a.util.BClipboard _sclipboard = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.decode _decode = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 64;BA.debugLine="Activity.LoadLayout(\"encode\")";
mostCurrent._activity.LoadLayout("encode",mostCurrent.activityBA);
 //BA.debugLineNum = 65;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 66;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 67;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 68;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 69;BA.debugLine="clearForm";
_clearform();
 //BA.debugLineNum = 70;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
if (_lastpicture.IsInitialized()) { 
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(_lastpicture.getObject()));};
 //BA.debugLineNum = 71;BA.debugLine="FileHandler1.Initialize";
_filehandler1._initialize /*String*/ (processBA);
 //BA.debugLineNum = 72;BA.debugLine="stegoHandler.Initialize";
_stegohandler._initialize /*String*/ (processBA);
 //BA.debugLineNum = 73;BA.debugLine="Dialog.Initialize(Activity)";
mostCurrent._dialog._initialize /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())));
 //BA.debugLineNum = 74;BA.debugLine="Dialog.Title = \"Stego Image View\"";
mostCurrent._dialog._title /*Object*/  = (Object)("Stego Image View");
 //BA.debugLineNum = 75;BA.debugLine="getPermissions";
_getpermissions();
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 92;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 93;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 94;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 95;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 97;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 87;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 88;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static void  _browsecoverimage() throws Exception{
ResumableSub_BrowseCoverImage rsub = new ResumableSub_BrowseCoverImage(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_BrowseCoverImage extends BA.ResumableSub {
public ResumableSub_BrowseCoverImage(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.encode parent;
ng.dsoftlab.stegocam.filehandler._loadresult _result = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 245;BA.debugLine="Dim xui As XUI";
parent.mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 246;BA.debugLine="Wait For (FileHandler1.LoadCoverImage) Complete (";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, parent._filehandler1._loadcoverimage /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (ng.dsoftlab.stegocam.filehandler._loadresult) result[0];
;
 //BA.debugLineNum = 247;BA.debugLine="If Result.Success Then";
if (true) break;

case 1:
//if
this.state = 10;
if (_result.Success /*boolean*/ ) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 248;BA.debugLine="Try";
if (true) break;

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
 //BA.debugLineNum = 250;BA.debugLine="imgCover.Bitmap =xui.LoadBitmapResize(Result.Di";
parent.mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._xui.LoadBitmapResize(_result.Dir /*String*/ ,_result.FileName /*String*/ ,parent.mostCurrent._imgcover.getWidth(),parent.mostCurrent._imgcover.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 251;BA.debugLine="imgCover.Tag= Result.FileName 'Result.Dir & \"/\"";
parent.mostCurrent._imgcover.setTag((Object)(_result.FileName /*String*/ ));
 //BA.debugLineNum = 252;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 //BA.debugLineNum = 254;BA.debugLine="imgCover.Bitmap=Null";
parent.mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 255;BA.debugLine="imgCover.Tag=\"\"";
parent.mostCurrent._imgcover.setTag((Object)(""));
 //BA.debugLineNum = 256;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("440763404",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 257;BA.debugLine="lblErrorMsg.Text=LastException.Message";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()));
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _complete(ng.dsoftlab.stegocam.filehandler._loadresult _result) throws Exception{
}
public static String  _btncancel_click() throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Private Sub btnCancel_Click";
 //BA.debugLineNum = 103;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 104;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _btnencode_click() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub btnEncode_Click";
 //BA.debugLineNum = 108;BA.debugLine="If imgCover.Bitmap=Null Then";
if (mostCurrent._imgcover.getBitmap()== null) { 
 //BA.debugLineNum = 109;BA.debugLine="lblErrorMsg.Text=\"Please select cover Image\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please select cover Image"));
 //BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"Please select cover Image\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please select cover Image"),anywheresoftware.b4a.keywords.Common.False);
 }else if((mostCurrent._txtmessage.getText()).equals("")) { 
 //BA.debugLineNum = 112;BA.debugLine="lblErrorMsg.Text=\"Please enter your secret messa";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter your secret message"));
 //BA.debugLineNum = 113;BA.debugLine="ToastMessageShow(\"Please enter your secret messa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your secret message"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 114;BA.debugLine="txtMessage.RequestFocus";
mostCurrent._txtmessage.RequestFocus();
 }else if((mostCurrent._txtkey.getText()).equals("")) { 
 //BA.debugLineNum = 116;BA.debugLine="lblErrorMsg.Text=\"Please enter your encryption k";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter your encryption key"));
 //BA.debugLineNum = 117;BA.debugLine="ToastMessageShow(\"Please enter your encryption k";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your encryption key"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 118;BA.debugLine="txtKey.RequestFocus";
mostCurrent._txtkey.RequestFocus();
 }else if(mostCurrent._txtkey.getText().length()<4) { 
 //BA.debugLineNum = 120;BA.debugLine="lblErrorMsg.Text=\"Encryption key must be 4 or mo";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Encryption key must be 4 or more letters"));
 //BA.debugLineNum = 121;BA.debugLine="ToastMessageShow(\"Encryption key must be 4 or mo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Encryption key must be 4 or more letters"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 122;BA.debugLine="txtKey.RequestFocus";
mostCurrent._txtkey.RequestFocus();
 }else {
 //BA.debugLineNum = 124;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 125;BA.debugLine="stegoHandler.createTempCoverImage(imgCover)";
_stegohandler._createtempcoverimage /*String*/ (mostCurrent._imgcover);
 //BA.debugLineNum = 126;BA.debugLine="If stegoHandler.isCoverImage Then";
if (_stegohandler._iscoverimage /*boolean*/ ()) { 
 //BA.debugLineNum = 127;BA.debugLine="stegoHandler.EmbedText(txtMessage.Text,txtKey.T";
_stegohandler._embedtext /*String*/ (mostCurrent._txtmessage.getText(),mostCurrent._txtkey.getText());
 //BA.debugLineNum = 128;BA.debugLine="If stegoHandler.embeddingSuccessful=True Then";
if (_stegohandler._embeddingsuccessful /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 129;BA.debugLine="ToastMessageShow(\"Secret has been hidden succe";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Secret has been hidden successfully!"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 130;BA.debugLine="showCompleteDialog(File.Combine(config.stegoIm";
_showcompletedialog(anywheresoftware.b4a.keywords.Common.File.Combine(mostCurrent._config._stegoimagepath /*String*/ ,_stegohandler._curfilename /*String*/ ));
 //BA.debugLineNum = 131;BA.debugLine="sClipboard.setText(txtKey.Text)";
mostCurrent._sclipboard.setText(mostCurrent.activityBA,mostCurrent._txtkey.getText());
 //BA.debugLineNum = 132;BA.debugLine="ToastMessageShow(\"Encryption Key has been copi";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Encryption Key has been copied to clipboard"),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 134;BA.debugLine="lblErrorMsg.Text=stegoHandler.lastErrorMessage";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(_stegohandler._lasterrormessage /*String*/ ));
 };
 }else {
 //BA.debugLineNum = 137;BA.debugLine="ToastMessageShow(\"An error has occured please T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("An error has occured please Try Again!"),anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 140;BA.debugLine="stegoHandler.deleteTempResources(\"stegocover\")";
_stegohandler._deletetempresources /*String*/ ("stegocover");
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static String  _clearform() throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Private Sub clearForm";
 //BA.debugLineNum = 208;BA.debugLine="lastPicture=Null";
_lastpicture = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 209;BA.debugLine="imgCover.Bitmap=Null";
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 210;BA.debugLine="txtMessage.Text=\"\"";
mostCurrent._txtmessage.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 211;BA.debugLine="imgCover.Tag=\"\"";
mostCurrent._imgcover.setTag((Object)(""));
 //BA.debugLineNum = 212;BA.debugLine="txtKey.Text=\"\"";
mostCurrent._txtkey.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 213;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 214;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public static Object  _getba() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
String _cls = "";
 //BA.debugLineNum = 306;BA.debugLine="Sub GetBA As Object";
 //BA.debugLineNum = 307;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 308;BA.debugLine="Dim cls As String = Me";
_cls = BA.ObjectToString(encode.getObject());
 //BA.debugLineNum = 309;BA.debugLine="cls = cls.SubString(\"class \".Length)";
_cls = _cls.substring("class ".length());
 //BA.debugLineNum = 310;BA.debugLine="jo.InitializeStatic(cls)";
_jo.InitializeStatic(_cls);
 //BA.debugLineNum = 311;BA.debugLine="Return jo.GetField(\"processBA\")";
if (true) return _jo.GetField("processBA");
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return null;
}
public static String  _getpathfromcontentresult(String _uristring) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri1 = null;
String[] _proj = null;
anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
int _i = 0;
String _id = "";
String _res = "";
 //BA.debugLineNum = 358;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
 //BA.debugLineNum = 359;BA.debugLine="If UriString.StartsWith(\"/\") Then Return UriStrin";
if (_uristring.startsWith("/")) { 
if (true) return _uristring;};
 //BA.debugLineNum = 360;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 361;BA.debugLine="Dim Uri1 As Uri";
_uri1 = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 362;BA.debugLine="Dim Proj() As String = Array As String(\"_data\")";
_proj = new String[]{"_data"};
 //BA.debugLineNum = 363;BA.debugLine="Dim cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
 //BA.debugLineNum = 364;BA.debugLine="cr.Initialize(\"\")";
_cr.Initialize("");
 //BA.debugLineNum = 365;BA.debugLine="If UriString.StartsWith(\"content://com.android.pr";
if (_uristring.startsWith("content://com.android.providers.media.documents")) { 
 //BA.debugLineNum = 366;BA.debugLine="Dim i As Int = UriString.IndexOf(\"%3A\")";
_i = _uristring.indexOf("%3A");
 //BA.debugLineNum = 367;BA.debugLine="Dim id As String = UriString.SubString(i + 3)";
_id = _uristring.substring((int) (_i+3));
 //BA.debugLineNum = 368;BA.debugLine="Uri1.Parse(\"content://media/external/images/medi";
_uri1.Parse("content://media/external/images/media");
 //BA.debugLineNum = 369;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"_id = ?\", Array";
_cursor1 = _cr.Query(_uri1,_proj,"_id = ?",new String[]{_id},"");
 }else {
 //BA.debugLineNum = 371;BA.debugLine="Uri1.Parse(UriString)";
_uri1.Parse(_uristring);
 //BA.debugLineNum = 372;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"\", Null, \"\")";
_cursor1 = _cr.Query(_uri1,_proj,"",(String[])(anywheresoftware.b4a.keywords.Common.Null),"");
 };
 //BA.debugLineNum = 374;BA.debugLine="Cursor1.Position = 0";
_cursor1.setPosition((int) (0));
 //BA.debugLineNum = 375;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 376;BA.debugLine="res = Cursor1.GetString(\"_data\")";
_res = _cursor1.GetString("_data");
 //BA.debugLineNum = 377;BA.debugLine="Cursor1.Close";
_cursor1.Close();
 //BA.debugLineNum = 378;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public static void  _getpermissions() throws Exception{
ResumableSub_getPermissions rsub = new ResumableSub_getPermissions(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_getPermissions extends BA.ResumableSub {
public ResumableSub_getPermissions(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.encode parent;
String _permission = "";
boolean _result = false;
Object[] group1;
int index1;
int groupLen1;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 231;BA.debugLine="For Each permission As String In Array(Starter.rp";
if (true) break;

case 1:
//for
this.state = 8;
group1 = new Object[]{(Object)(parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_CAMERA),(Object)(parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_READ_EXTERNAL_STORAGE),(Object)(parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_WRITE_EXTERNAL_STORAGE)};
index1 = 0;
groupLen1 = group1.length;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 8;
if (index1 < groupLen1) {
this.state = 3;
_permission = BA.ObjectToString(group1[index1]);}
if (true) break;

case 10:
//C
this.state = 9;
index1++;
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 232;BA.debugLine="Starter.rp.CheckAndRequest(permission)";
parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,_permission);
 //BA.debugLineNum = 233;BA.debugLine="Wait For Activity_PermissionResult (permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 234;BA.debugLine="If Result = False Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 235;BA.debugLine="MsgboxAsync(\"Please grant the neccessary permis";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please grant the neccessary permission to continue"),BA.ObjectToCharSequence("No Permission granted"),processBA);
 //BA.debugLineNum = 237;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 238;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;
if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mostCurrent._actoolbarlight1 = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private ToolbarHelper As ACActionBar";
mostCurrent._toolbarhelper = new de.amberhome.objects.appcompat.ACActionBar();
 //BA.debugLineNum = 23;BA.debugLine="Dim SharedPrefs As SharedPreferences";
mostCurrent._sharedprefs = new com.b4x.sharedpreferences.SharedPreferences();
 //BA.debugLineNum = 24;BA.debugLine="Dim IME As IME";
mostCurrent._ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 25;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 26;BA.debugLine="Private Dialog As B4XDialog";
mostCurrent._dialog = new ng.dsoftlab.stegocam.b4xdialog();
 //BA.debugLineNum = 28;BA.debugLine="Private btnCancel As Button";
mostCurrent._btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private btnEncode As Button";
mostCurrent._btnencode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private ImageView3 As ImageView";
mostCurrent._imageview3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private ImageView4 As ImageView";
mostCurrent._imageview4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private lblErrorMsg As Label";
mostCurrent._lblerrormsg = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private pnlEncryption As Panel";
mostCurrent._pnlencryption = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private pnlKey As Panel";
mostCurrent._pnlkey = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private pnlMessage As Panel";
mostCurrent._pnlmessage = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private txtKey As EditText";
mostCurrent._txtkey = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private txtMessage As EditText";
mostCurrent._txtmessage = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private imgCover As ImageView";
mostCurrent._imgcover = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private pnlCoverImage As Panel";
mostCurrent._pnlcoverimage = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private cboEncryption As B4XComboBox";
mostCurrent._cboencryption = new ng.dsoftlab.stegocam.b4xcombobox();
 //BA.debugLineNum = 42;BA.debugLine="Dim toast As BCToast";
mostCurrent._toast = new ng.dsoftlab.stegocam.bctoast();
 //BA.debugLineNum = 43;BA.debugLine="Private btnBrowse As ImageView";
mostCurrent._btnbrowse = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lblShowPassword As Label";
mostCurrent._lblshowpassword = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private imgPreview As ImageView";
mostCurrent._imgpreview = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private btnExtract As Button";
mostCurrent._btnextract = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private btnShare As Button";
mostCurrent._btnshare = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private lblImgLocation As Label";
mostCurrent._lblimglocation = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private pnlPreview As Panel";
mostCurrent._pnlpreview = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private imgDelete As ImageView";
mostCurrent._imgdelete = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private imgExtract As ImageView";
mostCurrent._imgextract = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private imgShare As ImageView";
mostCurrent._imgshare = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private pnlDelete As Panel";
mostCurrent._pnldelete = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private pnlExtract As Panel";
mostCurrent._pnlextract = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private pnlShare As Panel";
mostCurrent._pnlshare = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Dim sClipboard As BClipboard";
mostCurrent._sclipboard = new b4a.util.BClipboard();
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static void  _imgcover_click() throws Exception{
ResumableSub_imgCover_Click rsub = new ResumableSub_imgCover_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_imgCover_Click extends BA.ResumableSub {
public ResumableSub_imgCover_Click(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.encode parent;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 219;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 220;BA.debugLine="bmp.Initialize(File.DirAssets, \"question.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"question.png");
 //BA.debugLineNum = 221;BA.debugLine="Msgbox2Async(\"Click on Yes to take picture from c";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Click on Yes to take picture from camera, or No to browse from a file?"),BA.ObjectToCharSequence("Browse Cover Image"),"Yes","Cancel","No",_bmp,processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 222;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 223;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}else if(_result==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 224;BA.debugLine="TakePicture";
_takepicture();
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 226;BA.debugLine="BrowseCoverImage";
_browsecoverimage();
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static void  _imgdelete_click() throws Exception{
ResumableSub_imgDelete_Click rsub = new ResumableSub_imgDelete_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_imgDelete_Click extends BA.ResumableSub {
public ResumableSub_imgDelete_Click(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.encode parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 347;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete fil";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete file?"),BA.ObjectToCharSequence("Delete Image"),"Yes","No","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 348;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 349;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 350;BA.debugLine="File.Delete(lblImgLocation.Text,\"\")";
anywheresoftware.b4a.keywords.Common.File.Delete(parent.mostCurrent._lblimglocation.getText(),"");
 //BA.debugLineNum = 351;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
parent.mostCurrent._dialog._close /*boolean*/ (parent.mostCurrent._xui.DialogResponse_Cancel);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 353;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _imgextract_click() throws Exception{
 //BA.debugLineNum = 382;BA.debugLine="Private Sub imgExtract_Click";
 //BA.debugLineNum = 383;BA.debugLine="decode.fromfile=False";
mostCurrent._decode._fromfile /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 384;BA.debugLine="decode.stegoimage=lblImgLocation.Text";
mostCurrent._decode._stegoimage /*String*/  = mostCurrent._lblimglocation.getText();
 //BA.debugLineNum = 385;BA.debugLine="StartActivity(decode)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._decode.getObject()));
 //BA.debugLineNum = 386;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 387;BA.debugLine="End Sub";
return "";
}
public static String  _imgshare_click() throws Exception{
String _filename = "";
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
anywheresoftware.b4a.objects.IntentWrapper _inten = null;
String _tmpt = "";
 //BA.debugLineNum = 327;BA.debugLine="Private Sub imgShare_Click";
 //BA.debugLineNum = 328;BA.debugLine="Try";
try { //BA.debugLineNum = 329;BA.debugLine="Dim filename As String=lblImgLocation.Text.SubSt";
_filename = mostCurrent._lblimglocation.getText().substring((int) (mostCurrent._lblimglocation.getText().lastIndexOf("/")+1));
 //BA.debugLineNum = 330;BA.debugLine="File.Copy(lblImgLocation.Text,\"\", Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._lblimglocation.getText(),"",mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
 //BA.debugLineNum = 331;BA.debugLine="Dim u As Uri 'ContentResolver library";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 332;BA.debugLine="u.Parse(Starter.Provider.GetFileUri(filename))";
_u.Parse(BA.ObjectToString(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._getfileuri /*Object*/ (_filename)));
 //BA.debugLineNum = 333;BA.debugLine="Dim inten As Intent";
_inten = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 334;BA.debugLine="Dim tmpt As String = \"\"";
_tmpt = "";
 //BA.debugLineNum = 335;BA.debugLine="inten.Initialize(inten.ACTION_SEND,\"\")";
_inten.Initialize(_inten.ACTION_SEND,"");
 //BA.debugLineNum = 336;BA.debugLine="inten.SetType(\"image/*\")";
_inten.SetType("image/*");
 //BA.debugLineNum = 337;BA.debugLine="inten.PutExtra(\"android.intent.extra.STREAM\",u)";
_inten.PutExtra("android.intent.extra.STREAM",(Object)(_u.getObject()));
 //BA.debugLineNum = 340;BA.debugLine="StartActivity(inten)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_inten.getObject()));
 } 
       catch (Exception e13) {
			processBA.setLastException(e13); //BA.debugLineNum = 342;BA.debugLine="ToastMessageShow(LastException.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public static Object  _ion_event(String _methodname,Object[] _args) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 278;BA.debugLine="Sub ion_Event (MethodName As String, Args() As Obj";
 //BA.debugLineNum = 279;BA.debugLine="Dim xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 280;BA.debugLine="If Args(0) = -1 Then";
if ((_args[(int) (0)]).equals((Object)(-1))) { 
 //BA.debugLineNum = 281;BA.debugLine="Try";
try { //BA.debugLineNum = 282;BA.debugLine="Dim in As Intent = Args(1)";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_args[(int) (1)]));
 //BA.debugLineNum = 283;BA.debugLine="If File.Exists(Starter.provider.SharedFolder, t";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile)) { 
 //BA.debugLineNum = 284;BA.debugLine="lastPicture = LoadBitmapSample(Starter.provide";
_lastpicture = anywheresoftware.b4a.keywords.Common.LoadBitmapSample(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile,mostCurrent._imgcover.getWidth(),mostCurrent._imgcover.getHeight());
 //BA.debugLineNum = 285;BA.debugLine="lastPicture =xui.LoadBitmapResize(Starter.prov";
_lastpicture = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(mostCurrent._xui.LoadBitmapResize(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile,mostCurrent._imgcover.getWidth(),mostCurrent._imgcover.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 286;BA.debugLine="imgCover.Bitmap = lastPicture";
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(_lastpicture.getObject()));
 }else if(_in.HasExtra("data")) { 
 //BA.debugLineNum = 288;BA.debugLine="Dim jo As JavaObject = in";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_in.getObject()));
 //BA.debugLineNum = 289;BA.debugLine="lastPicture = jo.RunMethodJO(\"getExtras\", Null";
_lastpicture = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_jo.RunMethodJO("getExtras",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethod("get",new Object[]{(Object)("data")})));
 };
 } 
       catch (Exception e14) {
			processBA.setLastException(e14); //BA.debugLineNum = 292;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("440960014",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 //BA.debugLineNum = 295;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
if (_lastpicture.IsInitialized()) { 
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(_lastpicture.getObject()));};
 //BA.debugLineNum = 296;BA.debugLine="Return Null";
if (true) return anywheresoftware.b4a.keywords.Common.Null;
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return null;
}
public static String  _lblshowpassword_click() throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Private Sub lblShowPassword_Click";
 //BA.debugLineNum = 315;BA.debugLine="If lblShowPassword.Text=config.hide Then";
if ((mostCurrent._lblshowpassword.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
 //BA.debugLineNum = 316;BA.debugLine="lblShowPassword.Text=config.show";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
 //BA.debugLineNum = 317;BA.debugLine="txtKey.PasswordMode=False";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 319;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 320;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 322;BA.debugLine="txtKey.SelectionStart=txtKey.Text.Length";
mostCurrent._txtkey.setSelectionStart(mostCurrent._txtkey.getText().length());
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private ion As Object";
_ion = new Object();
 //BA.debugLineNum = 11;BA.debugLine="Private const tempImageFile As String = \"stegocam";
_tempimagefile = "stegocam_coverimage.jpg";
 //BA.debugLineNum = 12;BA.debugLine="Private lastPicture As Bitmap";
_lastpicture = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private imageChooser As ContentChooser";
_imagechooser = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 14;BA.debugLine="Private FileHandler1 As FileHandler";
_filehandler1 = new ng.dsoftlab.stegocam.filehandler();
 //BA.debugLineNum = 15;BA.debugLine="Private stegoHandler As StegocamHandler";
_stegohandler = new ng.dsoftlab.stegocam.stegocamhandler();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static void  _showcompletedialog(String _img) throws Exception{
ResumableSub_showCompleteDialog rsub = new ResumableSub_showCompleteDialog(null,_img);
rsub.resume(processBA, null);
}
public static class ResumableSub_showCompleteDialog extends BA.ResumableSub {
public ResumableSub_showCompleteDialog(ng.dsoftlab.stegocam.encode parent,String _img) {
this.parent = parent;
this._img = _img;
}
ng.dsoftlab.stegocam.encode parent;
String _img;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
int _panelwidth = 0;
int _panelspacing = 0;
anywheresoftware.b4a.keywords.Common.ResumableSubWrapper _rs = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 145;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 10;
this.catchState = 9;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 9;
 //BA.debugLineNum = 146;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = parent.mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 149;BA.debugLine="pnl.SetLayoutAnimated(0, 0, 0, 90%x, 80%y)";
_pnl.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
 //BA.debugLineNum = 150;BA.debugLine="pnl.LoadLayout(\"embedDialog\")";
_pnl.LoadLayout("embedDialog",mostCurrent.activityBA);
 //BA.debugLineNum = 154;BA.debugLine="imgPreview.Width=pnlPreview.Width-20";
parent.mostCurrent._imgpreview.setWidth((int) (parent.mostCurrent._pnlpreview.getWidth()-20));
 //BA.debugLineNum = 155;BA.debugLine="imgPreview.Height=imgPreview.Width";
parent.mostCurrent._imgpreview.setHeight(parent.mostCurrent._imgpreview.getWidth());
 //BA.debugLineNum = 156;BA.debugLine="imgPreview.Left=pnlPreview.Width/2 - imgPreview.";
parent.mostCurrent._imgpreview.setLeft((int) (parent.mostCurrent._pnlpreview.getWidth()/(double)2-parent.mostCurrent._imgpreview.getWidth()/(double)2));
 //BA.debugLineNum = 157;BA.debugLine="imgPreview.Bitmap = xui.LoadBitmapResize(\"\", img";
parent.mostCurrent._imgpreview.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._xui.LoadBitmapResize("",_img,parent.mostCurrent._imgpreview.getWidth(),parent.mostCurrent._imgpreview.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 159;BA.debugLine="pnlExtract.Top=imgPreview.Top+imgPreview.Height+";
parent.mostCurrent._pnlextract.setTop((int) (parent.mostCurrent._imgpreview.getTop()+parent.mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 160;BA.debugLine="pnlDelete.Top=imgPreview.Top+imgPreview.Height+1";
parent.mostCurrent._pnldelete.setTop((int) (parent.mostCurrent._imgpreview.getTop()+parent.mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 161;BA.debugLine="pnlShare.Top=imgPreview.Top+imgPreview.Height+10";
parent.mostCurrent._pnlshare.setTop((int) (parent.mostCurrent._imgpreview.getTop()+parent.mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 163;BA.debugLine="Dim panelWidth, panelSpacing As Int";
_panelwidth = 0;
_panelspacing = 0;
 //BA.debugLineNum = 164;BA.debugLine="panelSpacing = 5dip";
_panelspacing = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5));
 //BA.debugLineNum = 165;BA.debugLine="panelWidth = (pnlPreview.Width / 3)";
_panelwidth = (int) ((parent.mostCurrent._pnlpreview.getWidth()/(double)3));
 //BA.debugLineNum = 167;BA.debugLine="pnlExtract.Width  = panelWidth";
parent.mostCurrent._pnlextract.setWidth(_panelwidth);
 //BA.debugLineNum = 168;BA.debugLine="pnlDelete.Width   = panelWidth";
parent.mostCurrent._pnldelete.setWidth(_panelwidth);
 //BA.debugLineNum = 169;BA.debugLine="pnlShare.Width    = panelWidth";
parent.mostCurrent._pnlshare.setWidth(_panelwidth);
 //BA.debugLineNum = 171;BA.debugLine="pnlExtract.Left=0";
parent.mostCurrent._pnlextract.setLeft((int) (0));
 //BA.debugLineNum = 172;BA.debugLine="pnlDelete.Left=panelWidth";
parent.mostCurrent._pnldelete.setLeft(_panelwidth);
 //BA.debugLineNum = 173;BA.debugLine="pnlShare.Left=(panelWidth * 2)";
parent.mostCurrent._pnlshare.setLeft((int) ((_panelwidth*2)));
 //BA.debugLineNum = 178;BA.debugLine="imgExtract.Left=pnlExtract.Width/2-imgExtract.Wi";
parent.mostCurrent._imgextract.setLeft((int) (parent.mostCurrent._pnlextract.getWidth()/(double)2-parent.mostCurrent._imgextract.getWidth()/(double)2));
 //BA.debugLineNum = 179;BA.debugLine="imgDelete.Left=pnlDelete.Width/2-imgDelete.Width";
parent.mostCurrent._imgdelete.setLeft((int) (parent.mostCurrent._pnldelete.getWidth()/(double)2-parent.mostCurrent._imgdelete.getWidth()/(double)2));
 //BA.debugLineNum = 180;BA.debugLine="imgShare.Left=pnlShare.Width/2-imgShare.Width/2";
parent.mostCurrent._imgshare.setLeft((int) (parent.mostCurrent._pnlshare.getWidth()/(double)2-parent.mostCurrent._imgshare.getWidth()/(double)2));
 //BA.debugLineNum = 182;BA.debugLine="Label1.Left=0";
parent.mostCurrent._label1.setLeft((int) (0));
 //BA.debugLineNum = 183;BA.debugLine="Label1.Width=pnlExtract.Width";
parent.mostCurrent._label1.setWidth(parent.mostCurrent._pnlextract.getWidth());
 //BA.debugLineNum = 185;BA.debugLine="Label4.Left=0";
parent.mostCurrent._label4.setLeft((int) (0));
 //BA.debugLineNum = 186;BA.debugLine="Label4.Width=pnlDelete.Width";
parent.mostCurrent._label4.setWidth(parent.mostCurrent._pnldelete.getWidth());
 //BA.debugLineNum = 188;BA.debugLine="Label2.Left=0";
parent.mostCurrent._label2.setLeft((int) (0));
 //BA.debugLineNum = 189;BA.debugLine="Label2.Width=pnlShare.Width";
parent.mostCurrent._label2.setWidth(parent.mostCurrent._pnlshare.getWidth());
 //BA.debugLineNum = 192;BA.debugLine="lblImgLocation.Text=img";
parent.mostCurrent._lblimglocation.setText(BA.ObjectToCharSequence(_img));
 //BA.debugLineNum = 194;BA.debugLine="Dim rs As ResumableSub = Dialog.ShowCustom(pnl,";
_rs = new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper();
_rs = parent.mostCurrent._dialog._showcustom /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (_pnl,(Object)("Ok"),(Object)(""),(Object)("Cancel"));
 //BA.debugLineNum = 195;BA.debugLine="Wait For (rs) Complete (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, _rs);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 196;BA.debugLine="If Result = xui.DialogResponse_Positive Or Resul";
if (true) break;

case 4:
//if
this.state = 7;
if (_result==parent.mostCurrent._xui.DialogResponse_Positive || _result==parent.mostCurrent._xui.DialogResponse_Cancel) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 198;BA.debugLine="clearForm";
_clearform();
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 //BA.debugLineNum = 201;BA.debugLine="ToastMessageShow(LastException.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 202;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("463307834",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _startactivityforresult(anywheresoftware.b4a.objects.IntentWrapper _i) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 300;BA.debugLine="Sub StartActivityForResult(i As Intent)";
 //BA.debugLineNum = 301;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_getba()));
 //BA.debugLineNum = 302;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
_ion = _jo.CreateEvent(processBA,"anywheresoftware.b4a.IOnActivityResult","ion",anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 303;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
_jo.RunMethod("startActivityForResult",new Object[]{_ion,(Object)(_i.getObject())});
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
public static String  _takepicture() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
Object _u = null;
 //BA.debugLineNum = 263;BA.debugLine="Sub TakePicture";
 //BA.debugLineNum = 264;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 265;BA.debugLine="i.Initialize(\"android.media.action.IMAGE_CAPTURE\"";
_i.Initialize("android.media.action.IMAGE_CAPTURE","");
 //BA.debugLineNum = 266;BA.debugLine="File.Delete(Starter.provider.SharedFolder, tempIm";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile);
 //BA.debugLineNum = 267;BA.debugLine="Dim u As Object = Starter.provider.GetFileUri(tem";
_u = mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._getfileuri /*Object*/ (_tempimagefile);
 //BA.debugLineNum = 268;BA.debugLine="i.PutExtra(\"output\", u) 'the image will be saved";
_i.PutExtra("output",_u);
 //BA.debugLineNum = 269;BA.debugLine="Try";
try { //BA.debugLineNum = 270;BA.debugLine="StartActivityForResult(i)";
_startactivityforresult(_i);
 } 
       catch (Exception e9) {
			processBA.setLastException(e9); //BA.debugLineNum = 272;BA.debugLine="ToastMessageShow(\"Camera is not available.\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Camera is not available."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 273;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("440894474",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
}
