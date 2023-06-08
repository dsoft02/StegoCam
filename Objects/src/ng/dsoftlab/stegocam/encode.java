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
public static anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _lastpicture = null;
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
public ng.dsoftlab.stegocam.b4ximageview _imgcover = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _btncamera = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.decode _decode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.stegopreview _stegopreview = null;
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
 //BA.debugLineNum = 63;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 65;BA.debugLine="Activity.LoadLayout(\"encode\")";
mostCurrent._activity.LoadLayout("encode",mostCurrent.activityBA);
 //BA.debugLineNum = 66;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 67;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 68;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 69;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 71;BA.debugLine="clearForm";
_clearform();
 //BA.debugLineNum = 72;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
if (_lastpicture.IsInitialized()) { 
mostCurrent._imgcover._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_lastpicture);};
 //BA.debugLineNum = 73;BA.debugLine="FileHandler1.Initialize";
_filehandler1._initialize /*String*/ (processBA);
 //BA.debugLineNum = 74;BA.debugLine="stegoHandler.Initialize";
_stegohandler._initialize /*String*/ (processBA);
 //BA.debugLineNum = 75;BA.debugLine="Dialog.Initialize(Activity)";
mostCurrent._dialog._initialize /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())));
 //BA.debugLineNum = 76;BA.debugLine="Dialog.Title = \"Stego Image View\"";
mostCurrent._dialog._title /*Object*/  = (Object)("Stego Image View");
 //BA.debugLineNum = 77;BA.debugLine="getPermissions";
_getpermissions();
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 94;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 95;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 96;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 97;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 99;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 89;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 90;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 204;BA.debugLine="Dim xui As XUI";
parent.mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 205;BA.debugLine="Wait For (FileHandler1.LoadCoverImage) Complete (";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, parent._filehandler1._loadcoverimage /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (ng.dsoftlab.stegocam.filehandler._loadresult) result[0];
;
 //BA.debugLineNum = 206;BA.debugLine="If Result.Success Then";
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
 //BA.debugLineNum = 207;BA.debugLine="Try";
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
 //BA.debugLineNum = 208;BA.debugLine="imgCover.load(Result.Dir,Result.FileName)";
parent.mostCurrent._imgcover._load /*String*/ (_result.Dir /*String*/ ,_result.FileName /*String*/ );
 //BA.debugLineNum = 210;BA.debugLine="imgCover.Tag= Result.FileName 'Result.Dir & \"/\"";
parent.mostCurrent._imgcover._tag /*Object*/  = (Object)(_result.FileName /*String*/ );
 //BA.debugLineNum = 211;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 //BA.debugLineNum = 213;BA.debugLine="imgCover.Bitmap=Null";
parent.mostCurrent._imgcover._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 214;BA.debugLine="imgCover.Tag=\"\"";
parent.mostCurrent._imgcover._tag /*Object*/  = (Object)("");
 //BA.debugLineNum = 215;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("33997708",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 216;BA.debugLine="lblErrorMsg.Text=LastException.Message";
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
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
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
public static void  _btncamera_click() throws Exception{
ResumableSub_btnCamera_Click rsub = new ResumableSub_btnCamera_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnCamera_Click extends BA.ResumableSub {
public ResumableSub_btnCamera_Click(ng.dsoftlab.stegocam.encode parent) {
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
 //BA.debugLineNum = 176;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 177;BA.debugLine="bmp.Initialize(File.DirAssets, \"question.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"question.png");
 //BA.debugLineNum = 178;BA.debugLine="Msgbox2Async(\"Click on Yes to take picture from c";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Click on Yes to take picture from camera, or No to browse from a file?"),BA.ObjectToCharSequence("Browse Cover Image"),"Yes","Cancel","No",_bmp,processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 179;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 180;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 181;BA.debugLine="TakePicture";
_takepicture();
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 183;BA.debugLine="BrowseCoverImage";
_browsecoverimage();
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _btncancel_click() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Private Sub btnCancel_Click";
 //BA.debugLineNum = 105;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 106;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public static void  _btnencode_click() throws Exception{
ResumableSub_btnEncode_Click rsub = new ResumableSub_btnEncode_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnEncode_Click extends BA.ResumableSub {
public ResumableSub_btnEncode_Click(ng.dsoftlab.stegocam.encode parent) {
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
 //BA.debugLineNum = 110;BA.debugLine="If imgCover.Bitmap=Null Then";
if (true) break;

case 1:
//if
this.state = 28;
if (parent.mostCurrent._imgcover._getbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ ()== null) { 
this.state = 3;
}else if((parent.mostCurrent._txtmessage.getText()).equals("")) { 
this.state = 5;
}else if((parent.mostCurrent._txtkey.getText()).equals("")) { 
this.state = 7;
}else if(parent.mostCurrent._txtkey.getText().length()<4) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 28;
 //BA.debugLineNum = 111;BA.debugLine="lblErrorMsg.Text=\"Please select cover Image\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please select cover Image"));
 //BA.debugLineNum = 112;BA.debugLine="ToastMessageShow(\"Please select cover Image\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please select cover Image"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 5:
//C
this.state = 28;
 //BA.debugLineNum = 114;BA.debugLine="lblErrorMsg.Text=\"Please enter your secret messa";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter your secret message"));
 //BA.debugLineNum = 115;BA.debugLine="ToastMessageShow(\"Please enter your secret messa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your secret message"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 116;BA.debugLine="txtMessage.RequestFocus";
parent.mostCurrent._txtmessage.RequestFocus();
 if (true) break;

case 7:
//C
this.state = 28;
 //BA.debugLineNum = 118;BA.debugLine="lblErrorMsg.Text=\"Please enter your encryption k";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter your encryption key"));
 //BA.debugLineNum = 119;BA.debugLine="ToastMessageShow(\"Please enter your encryption k";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your encryption key"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 120;BA.debugLine="txtKey.RequestFocus";
parent.mostCurrent._txtkey.RequestFocus();
 if (true) break;

case 9:
//C
this.state = 28;
 //BA.debugLineNum = 122;BA.debugLine="lblErrorMsg.Text=\"Encryption key must be 4 or mo";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Encryption key must be 4 or more letters"));
 //BA.debugLineNum = 123;BA.debugLine="ToastMessageShow(\"Encryption key must be 4 or mo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Encryption key must be 4 or more letters"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 124;BA.debugLine="txtKey.RequestFocus";
parent.mostCurrent._txtkey.RequestFocus();
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 126;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 127;BA.debugLine="stegoHandler.createTempCoverImage(imgCover)";
parent._stegohandler._createtempcoverimage /*String*/ (parent.mostCurrent._imgcover);
 //BA.debugLineNum = 128;BA.debugLine="If stegoHandler.isCoverImage Then";
if (true) break;

case 12:
//if
this.state = 27;
if (parent._stegohandler._iscoverimage /*boolean*/ ()) { 
this.state = 14;
}else {
this.state = 26;
}if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 129;BA.debugLine="stegoHandler.EmbedText(txtMessage.Text,txtKey.T";
parent._stegohandler._embedtext /*String*/ (parent.mostCurrent._txtmessage.getText(),parent.mostCurrent._txtkey.getText());
 //BA.debugLineNum = 130;BA.debugLine="If stegoHandler.embeddingSuccessful=True Then";
if (true) break;

case 15:
//if
this.state = 24;
if (parent._stegohandler._embeddingsuccessful /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 17;
}else {
this.state = 23;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 131;BA.debugLine="ToastMessageShow(\"Secret has been hidden succe";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Secret has been hidden successfully!"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 132;BA.debugLine="sClipboard.setText(txtKey.Text)";
parent.mostCurrent._sclipboard.setText(mostCurrent.activityBA,parent.mostCurrent._txtkey.getText());
 //BA.debugLineNum = 133;BA.debugLine="ToastMessageShow(\"Encryption Key has been copi";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Encryption Key has been copied to clipboard"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 134;BA.debugLine="Msgbox2Async(\"Encryption Key has been copied t";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Encryption Key has been copied to clipboard"),BA.ObjectToCharSequence("Encryption Key Copied"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 135;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 29;
return;
case 29:
//C
this.state = 18;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 136;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 18:
//if
this.state = 21;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 20;
}if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 137;BA.debugLine="showCompleteDialog(File.Combine(config.stegoI";
_showcompletedialog(anywheresoftware.b4a.keywords.Common.File.Combine(parent.mostCurrent._config._stegoimagepath /*String*/ ,parent._stegohandler._curfilename /*String*/ ));
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 140;BA.debugLine="lblErrorMsg.Text=stegoHandler.lastErrorMessage";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(parent._stegohandler._lasterrormessage /*String*/ ));
 if (true) break;

case 24:
//C
this.state = 27;
;
 if (true) break;

case 26:
//C
this.state = 27;
 //BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(\"An error has occured please T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("An error has occured please Try Again!"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 27:
//C
this.state = 28;
;
 if (true) break;

case 28:
//C
this.state = -1;
;
 //BA.debugLineNum = 146;BA.debugLine="stegoHandler.deleteTempResources(\"stegocover\")";
parent._stegohandler._deletetempresources /*String*/ ("stegocover");
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _clearform() throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Private Sub clearForm";
 //BA.debugLineNum = 165;BA.debugLine="lastPicture=Null";
_lastpicture = (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 166;BA.debugLine="If imgCover.Bitmap.IsInitialized Then imgCover.Bi";
if (mostCurrent._imgcover._getbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ ().IsInitialized()) { 
mostCurrent._imgcover._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));};
 //BA.debugLineNum = 167;BA.debugLine="txtMessage.Text=\"\"";
mostCurrent._txtmessage.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 168;BA.debugLine="imgCover.Tag=\"\"";
mostCurrent._imgcover._tag /*Object*/  = (Object)("");
 //BA.debugLineNum = 169;BA.debugLine="txtKey.Text=\"\"";
mostCurrent._txtkey.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 170;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 171;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public static Object  _getba() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
String _cls = "";
 //BA.debugLineNum = 264;BA.debugLine="Sub GetBA As Object";
 //BA.debugLineNum = 265;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 266;BA.debugLine="Dim cls As String = Me";
_cls = BA.ObjectToString(encode.getObject());
 //BA.debugLineNum = 267;BA.debugLine="cls = cls.SubString(\"class \".Length)";
_cls = _cls.substring("class ".length());
 //BA.debugLineNum = 268;BA.debugLine="jo.InitializeStatic(cls)";
_jo.InitializeStatic(_cls);
 //BA.debugLineNum = 269;BA.debugLine="Return jo.GetField(\"processBA\")";
if (true) return _jo.GetField("processBA");
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 284;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
 //BA.debugLineNum = 285;BA.debugLine="If UriString.StartsWith(\"/\") Then Return UriStrin";
if (_uristring.startsWith("/")) { 
if (true) return _uristring;};
 //BA.debugLineNum = 286;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 287;BA.debugLine="Dim Uri1 As Uri";
_uri1 = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 288;BA.debugLine="Dim Proj() As String = Array As String(\"_data\")";
_proj = new String[]{"_data"};
 //BA.debugLineNum = 289;BA.debugLine="Dim cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
 //BA.debugLineNum = 290;BA.debugLine="cr.Initialize(\"\")";
_cr.Initialize("");
 //BA.debugLineNum = 291;BA.debugLine="If UriString.StartsWith(\"content://com.android.pr";
if (_uristring.startsWith("content://com.android.providers.media.documents")) { 
 //BA.debugLineNum = 292;BA.debugLine="Dim i As Int = UriString.IndexOf(\"%3A\")";
_i = _uristring.indexOf("%3A");
 //BA.debugLineNum = 293;BA.debugLine="Dim id As String = UriString.SubString(i + 3)";
_id = _uristring.substring((int) (_i+3));
 //BA.debugLineNum = 294;BA.debugLine="Uri1.Parse(\"content://media/external/images/medi";
_uri1.Parse("content://media/external/images/media");
 //BA.debugLineNum = 295;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"_id = ?\", Array";
_cursor1 = _cr.Query(_uri1,_proj,"_id = ?",new String[]{_id},"");
 }else {
 //BA.debugLineNum = 297;BA.debugLine="Uri1.Parse(UriString)";
_uri1.Parse(_uristring);
 //BA.debugLineNum = 298;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"\", Null, \"\")";
_cursor1 = _cr.Query(_uri1,_proj,"",(String[])(anywheresoftware.b4a.keywords.Common.Null),"");
 };
 //BA.debugLineNum = 300;BA.debugLine="Cursor1.Position = 0";
_cursor1.setPosition((int) (0));
 //BA.debugLineNum = 301;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 302;BA.debugLine="res = Cursor1.GetString(\"_data\")";
_res = _cursor1.GetString("_data");
 //BA.debugLineNum = 303;BA.debugLine="Cursor1.Close";
_cursor1.Close();
 //BA.debugLineNum = 304;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 190;BA.debugLine="For Each permission As String In Array(Starter.rp";
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
 //BA.debugLineNum = 191;BA.debugLine="Starter.rp.CheckAndRequest(permission)";
parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,_permission);
 //BA.debugLineNum = 192;BA.debugLine="Wait For Activity_PermissionResult (permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 193;BA.debugLine="If Result = False Then";
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
 //BA.debugLineNum = 194;BA.debugLine="MsgboxAsync(\"Please grant the neccessary permis";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please grant the neccessary permission to continue"),BA.ObjectToCharSequence("No Permission granted"),processBA);
 //BA.debugLineNum = 196;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 197;BA.debugLine="Return";
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
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 39;BA.debugLine="Private pnlCoverImage As Panel";
mostCurrent._pnlcoverimage = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private cboEncryption As B4XComboBox";
mostCurrent._cboencryption = new ng.dsoftlab.stegocam.b4xcombobox();
 //BA.debugLineNum = 41;BA.debugLine="Dim toast As BCToast";
mostCurrent._toast = new ng.dsoftlab.stegocam.bctoast();
 //BA.debugLineNum = 42;BA.debugLine="Private btnBrowse As ImageView";
mostCurrent._btnbrowse = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lblShowPassword As Label";
mostCurrent._lblshowpassword = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private imgPreview As ImageView";
mostCurrent._imgpreview = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private btnExtract As Button";
mostCurrent._btnextract = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private btnShare As Button";
mostCurrent._btnshare = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lblImgLocation As Label";
mostCurrent._lblimglocation = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private pnlPreview As Panel";
mostCurrent._pnlpreview = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private imgDelete As ImageView";
mostCurrent._imgdelete = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private imgExtract As ImageView";
mostCurrent._imgextract = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private imgShare As ImageView";
mostCurrent._imgshare = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private pnlDelete As Panel";
mostCurrent._pnldelete = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private pnlExtract As Panel";
mostCurrent._pnlextract = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private pnlShare As Panel";
mostCurrent._pnlshare = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Dim sClipboard As BClipboard";
mostCurrent._sclipboard = new b4a.util.BClipboard();
 //BA.debugLineNum = 59;BA.debugLine="Private imgCover As B4XImageView";
mostCurrent._imgcover = new ng.dsoftlab.stegocam.b4ximageview();
 //BA.debugLineNum = 60;BA.debugLine="Private btnCamera As ImageView";
mostCurrent._btncamera = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static Object  _ion_event(String _methodname,Object[] _args) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 237;BA.debugLine="Sub ion_Event (MethodName As String, Args() As Obj";
 //BA.debugLineNum = 238;BA.debugLine="Dim xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 239;BA.debugLine="If Args(0) = -1 Then";
if ((_args[(int) (0)]).equals((Object)(-1))) { 
 //BA.debugLineNum = 240;BA.debugLine="Try";
try { //BA.debugLineNum = 241;BA.debugLine="Dim in As Intent = Args(1)";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_args[(int) (1)]));
 //BA.debugLineNum = 242;BA.debugLine="If File.Exists(Starter.provider.SharedFolder, t";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile)) { 
 //BA.debugLineNum = 243;BA.debugLine="lastPicture =xui.LoadBitmapResize(Starter.prov";
_lastpicture = mostCurrent._xui.LoadBitmapResize(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile,mostCurrent._imgcover._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),mostCurrent._imgcover._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight(),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 244;BA.debugLine="imgCover.Bitmap = lastPicture";
mostCurrent._imgcover._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_lastpicture);
 }else if(_in.HasExtra("data")) { 
 //BA.debugLineNum = 246;BA.debugLine="Dim jo As JavaObject = in";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_in.getObject()));
 //BA.debugLineNum = 247;BA.debugLine="lastPicture = jo.RunMethodJO(\"getExtras\", Null";
_lastpicture = (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(_jo.RunMethodJO("getExtras",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethod("get",new Object[]{(Object)("data")})));
 };
 } 
       catch (Exception e13) {
			processBA.setLastException(e13); //BA.debugLineNum = 250;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("34128781",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
 //BA.debugLineNum = 253;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
if (_lastpicture.IsInitialized()) { 
mostCurrent._imgcover._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_lastpicture);};
 //BA.debugLineNum = 254;BA.debugLine="Return Null";
if (true) return anywheresoftware.b4a.keywords.Common.Null;
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return null;
}
public static String  _lblshowpassword_click() throws Exception{
 //BA.debugLineNum = 272;BA.debugLine="Private Sub lblShowPassword_Click";
 //BA.debugLineNum = 273;BA.debugLine="If lblShowPassword.Text=config.hide Then";
if ((mostCurrent._lblshowpassword.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
 //BA.debugLineNum = 274;BA.debugLine="lblShowPassword.Text=config.show";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
 //BA.debugLineNum = 275;BA.debugLine="txtKey.PasswordMode=False";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 277;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 278;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 280;BA.debugLine="txtKey.SelectionStart=txtKey.Text.Length";
mostCurrent._txtkey.setSelectionStart(mostCurrent._txtkey.getText().length());
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private ion As Object";
_ion = new Object();
 //BA.debugLineNum = 11;BA.debugLine="Private const tempImageFile As String = \"stegocam";
_tempimagefile = "stegocam_coverimage.jpg";
 //BA.debugLineNum = 12;BA.debugLine="Private lastPicture As B4XBitmap";
_lastpicture = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private imageChooser As ContentChooser";
_imagechooser = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 14;BA.debugLine="Private FileHandler1 As FileHandler";
_filehandler1 = new ng.dsoftlab.stegocam.filehandler();
 //BA.debugLineNum = 15;BA.debugLine="Private stegoHandler As StegocamHandler";
_stegohandler = new ng.dsoftlab.stegocam.stegocamhandler();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _showcompletedialog(String _img) throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Sub showCompleteDialog(img As String)";
 //BA.debugLineNum = 151;BA.debugLine="Try";
try { //BA.debugLineNum = 152;BA.debugLine="stegopreview.stegoimage= LoadBitmap(\"\",img)";
mostCurrent._stegopreview._stegoimage /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap("",_img).getObject()));
 //BA.debugLineNum = 153;BA.debugLine="stegopreview.stegoImagePath=img";
mostCurrent._stegopreview._stegoimagepath /*String*/  = _img;
 //BA.debugLineNum = 154;BA.debugLine="stegopreview.fromActivity=\"encode\"";
mostCurrent._stegopreview._fromactivity /*String*/  = "encode";
 //BA.debugLineNum = 155;BA.debugLine="StartActivity(stegopreview)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._stegopreview.getObject()));
 //BA.debugLineNum = 156;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 158;BA.debugLine="ToastMessageShow(LastException.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 159;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("33735561",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public static String  _startactivityforresult(anywheresoftware.b4a.objects.IntentWrapper _i) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 258;BA.debugLine="Sub StartActivityForResult(i As Intent)";
 //BA.debugLineNum = 259;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_getba()));
 //BA.debugLineNum = 260;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
_ion = _jo.CreateEvent(processBA,"anywheresoftware.b4a.IOnActivityResult","ion",anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 261;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
_jo.RunMethod("startActivityForResult",new Object[]{_ion,(Object)(_i.getObject())});
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return "";
}
public static String  _takepicture() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
Object _u = null;
 //BA.debugLineNum = 222;BA.debugLine="Sub TakePicture";
 //BA.debugLineNum = 223;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 224;BA.debugLine="i.Initialize(\"android.media.action.IMAGE_CAPTURE\"";
_i.Initialize("android.media.action.IMAGE_CAPTURE","");
 //BA.debugLineNum = 225;BA.debugLine="File.Delete(Starter.provider.SharedFolder, tempIm";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile);
 //BA.debugLineNum = 226;BA.debugLine="Dim u As Object = Starter.provider.GetFileUri(tem";
_u = mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._getfileuri /*Object*/ (_tempimagefile);
 //BA.debugLineNum = 227;BA.debugLine="i.PutExtra(\"output\", u) 'the image will be saved";
_i.PutExtra("output",_u);
 //BA.debugLineNum = 228;BA.debugLine="Try";
try { //BA.debugLineNum = 229;BA.debugLine="StartActivityForResult(i)";
_startactivityforresult(_i);
 } 
       catch (Exception e9) {
			processBA.setLastException(e9); //BA.debugLineNum = 231;BA.debugLine="ToastMessageShow(\"Camera is not available.\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Camera is not available."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 232;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("34063242",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
}
