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

public class decode extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static decode mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.decode");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (decode).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.decode");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.decode", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (decode) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (decode) Resume **");
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
		return decode.class;
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
            BA.LogInfo("** Activity (decode) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (decode) Pause event (activity is not paused). **");
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
            decode mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (decode) Resume **");
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
public static anywheresoftware.b4a.phone.Phone.ContentChooser _imagechooser = null;
public static ng.dsoftlab.stegocam.filehandler _filehandler1 = null;
public static ng.dsoftlab.stegocam.stegocamhandler _stegohandler = null;
public static String _stegoimage = "";
public static boolean _fromfile = false;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public anywheresoftware.b4a.objects.IME _ime = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public ng.dsoftlab.stegocam.b4xdialog _dialog = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndecode = null;
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
public anywheresoftware.b4a.objects.EditTextWrapper _txtfilename = null;
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
public ng.dsoftlab.stegocam.history _history = null;
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
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 61;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 63;BA.debugLine="Activity.LoadLayout(\"decode\")";
mostCurrent._activity.LoadLayout("decode",mostCurrent.activityBA);
 //BA.debugLineNum = 64;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 65;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 66;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 67;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 68;BA.debugLine="Dim jo As JavaObject = txtMessage";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._txtmessage.getObject()));
 //BA.debugLineNum = 69;BA.debugLine="txtMessage.InputType=txtMessage.INPUT_TYPE_NONE";
mostCurrent._txtmessage.setInputType(mostCurrent._txtmessage.INPUT_TYPE_NONE);
 //BA.debugLineNum = 70;BA.debugLine="jo.RunMethod(\"setTextIsSelectable\", Array(True))";
_jo.RunMethod("setTextIsSelectable",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
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
 //BA.debugLineNum = 76;BA.debugLine="If fromfile=False And stegoimage <>\"\" Then";
if (_fromfile==anywheresoftware.b4a.keywords.Common.False && (_stegoimage).equals("") == false) { 
 //BA.debugLineNum = 77;BA.debugLine="txtFileName.Text=stegoimage";
mostCurrent._txtfilename.setText(BA.ObjectToCharSequence(_stegoimage));
 //BA.debugLineNum = 78;BA.debugLine="txtFileName.Tag=\"\"";
mostCurrent._txtfilename.setTag((Object)(""));
 //BA.debugLineNum = 79;BA.debugLine="imgCover.Bitmap =xui.LoadBitmapResize(stegoimage";
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(mostCurrent._xui.LoadBitmapResize(_stegoimage,"",mostCurrent._imgcover.getWidth(),mostCurrent._imgcover.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
 //BA.debugLineNum = 81;BA.debugLine="clearForm";
_clearform();
 };
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 100;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 101;BA.debugLine="clearForm";
_clearform();
 //BA.debugLineNum = 102;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 103;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 104;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 106;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 94;BA.debugLine="clearForm";
_clearform();
 //BA.debugLineNum = 95;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 96;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static void  _browsestegoimage() throws Exception{
ResumableSub_BrowseStegoImage rsub = new ResumableSub_BrowseStegoImage(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_BrowseStegoImage extends BA.ResumableSub {
public ResumableSub_BrowseStegoImage(ng.dsoftlab.stegocam.decode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.decode parent;
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
 //BA.debugLineNum = 208;BA.debugLine="Dim xui As XUI";
parent.mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 209;BA.debugLine="Wait For (FileHandler1.LoadCoverImage) Complete (";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, parent._filehandler1._loadcoverimage /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (ng.dsoftlab.stegocam.filehandler._loadresult) result[0];
;
 //BA.debugLineNum = 210;BA.debugLine="If Result.Success Then";
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
 //BA.debugLineNum = 211;BA.debugLine="Try";
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
 //BA.debugLineNum = 213;BA.debugLine="imgCover.Bitmap =xui.LoadBitmapResize(Result.Di";
parent.mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._xui.LoadBitmapResize(_result.Dir /*String*/ ,_result.FileName /*String*/ ,parent.mostCurrent._imgcover.getWidth(),parent.mostCurrent._imgcover.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 214;BA.debugLine="imgCover.Tag= Result.RealName 'Result.Dir & \"/\"";
parent.mostCurrent._imgcover.setTag((Object)(_result.RealName /*String*/ ));
 //BA.debugLineNum = 215;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 216;BA.debugLine="txtFileName.Text=Result.FileName";
parent.mostCurrent._txtfilename.setText(BA.ObjectToCharSequence(_result.FileName /*String*/ ));
 //BA.debugLineNum = 217;BA.debugLine="txtFileName.Tag=\"fromfile\"";
parent.mostCurrent._txtfilename.setTag((Object)("fromfile"));
 //BA.debugLineNum = 218;BA.debugLine="fromfile=True";
parent._fromfile = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 //BA.debugLineNum = 220;BA.debugLine="imgCover.Bitmap=Null";
parent.mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 221;BA.debugLine="imgCover.Tag=\"\"";
parent.mostCurrent._imgcover.setTag((Object)(""));
 //BA.debugLineNum = 222;BA.debugLine="txtFileName.Text=\"\"";
parent.mostCurrent._txtfilename.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 223;BA.debugLine="txtFileName.Tag=\"\"";
parent.mostCurrent._txtfilename.setTag((Object)(""));
 //BA.debugLineNum = 224;BA.debugLine="fromfile=False";
parent._fromfile = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 225;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("469271570",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 227;BA.debugLine="config.displayMessage(LastException.Message,lbl";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.False);
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
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 111;BA.debugLine="Private Sub btnCancel_Click";
 //BA.debugLineNum = 112;BA.debugLine="clearForm";
_clearform();
 //BA.debugLineNum = 113;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 114;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static void  _btndecode_click() throws Exception{
ResumableSub_btnDecode_Click rsub = new ResumableSub_btnDecode_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnDecode_Click extends BA.ResumableSub {
public ResumableSub_btnDecode_Click(ng.dsoftlab.stegocam.decode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.decode parent;
String _stegoimagefile = "";
String _stegoimagefilename = "";
String _newstegofile = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 119;BA.debugLine="If imgCover.Bitmap=Null Then";
if (true) break;

case 1:
//if
this.state = 26;
if (parent.mostCurrent._imgcover.getBitmap()== null) { 
this.state = 3;
}else if((parent.mostCurrent._txtkey.getText()).equals("")) { 
this.state = 5;
}else if(parent.mostCurrent._txtkey.getText().length()<4) { 
this.state = 7;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 26;
 //BA.debugLineNum = 121;BA.debugLine="config.displayMessage(\"Please select stego Image";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,"Please select stego Image",parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 122;BA.debugLine="ToastMessageShow(\"Please select stego Image\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please select stego Image"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 5:
//C
this.state = 26;
 //BA.debugLineNum = 125;BA.debugLine="config.displayMessage(\"Please enter your decrypt";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,"Please enter your decryption key",parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 126;BA.debugLine="ToastMessageShow(\"Please enter your decryption k";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your decryption key"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 127;BA.debugLine="txtKey.RequestFocus";
parent.mostCurrent._txtkey.RequestFocus();
 if (true) break;

case 7:
//C
this.state = 26;
 //BA.debugLineNum = 129;BA.debugLine="config.displayMessage(\"Decryption key must be 4";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,"Decryption key must be 4 or more letters",parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 130;BA.debugLine="ToastMessageShow(\"Decryption key must be 4 or mo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Decryption key must be 4 or more letters"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 131;BA.debugLine="txtKey.RequestFocus";
parent.mostCurrent._txtkey.RequestFocus();
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 133;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 134;BA.debugLine="Dim stegoImageFile As String=txtFileName.Text";
_stegoimagefile = parent.mostCurrent._txtfilename.getText();
 //BA.debugLineNum = 135;BA.debugLine="Dim stegoImageFileName As String=\"stegoimage.\" &";
_stegoimagefilename = "stegoimage."+BA.ObjectToString((((parent.mostCurrent._txtfilename.getTag()).equals((Object)("fromfile"))) ? ((Object)(parent.mostCurrent._config._getfileextension /*String*/ (mostCurrent.activityBA,BA.ObjectToString(parent.mostCurrent._imgcover.getTag())))) : ((Object)(parent.mostCurrent._config._getfileextension /*String*/ (mostCurrent.activityBA,parent.mostCurrent._txtfilename.getText())))));
 //BA.debugLineNum = 137;BA.debugLine="If fromfile=True Or txtFileName.Tag=\"fromfile\" T";
if (true) break;

case 10:
//if
this.state = 13;
if (parent._fromfile==anywheresoftware.b4a.keywords.Common.True || (parent.mostCurrent._txtfilename.getTag()).equals((Object)("fromfile"))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 138;BA.debugLine="stegoImageFile =stegoHandler.copyFiletoTemp(txt";
_stegoimagefile = parent._stegohandler._copyfiletotemp /*String*/ (parent.mostCurrent._txtfilename.getText(),_stegoimagefilename);
 if (true) break;

case 13:
//C
this.state = 14;
;
 //BA.debugLineNum = 144;BA.debugLine="Dim newstegofile As String =stegoImageFile 'ste";
_newstegofile = _stegoimagefile;
 //BA.debugLineNum = 145;BA.debugLine="If File.Exists(newstegofile,\"\") Then";
if (true) break;

case 14:
//if
this.state = 25;
if (anywheresoftware.b4a.keywords.Common.File.Exists(_newstegofile,"")) { 
this.state = 16;
}else {
this.state = 24;
}if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 146;BA.debugLine="stegoHandler.ExtractText(newstegofile,txtKey.T";
parent._stegohandler._extracttext /*String*/ (_newstegofile,parent.mostCurrent._txtkey.getText());
 //BA.debugLineNum = 148;BA.debugLine="Sleep(5)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (5));
this.state = 27;
return;
case 27:
//C
this.state = 17;
;
 //BA.debugLineNum = 149;BA.debugLine="If stegoHandler.extractionSuccessful Then";
if (true) break;

case 17:
//if
this.state = 22;
if (parent._stegohandler._extractionsuccessful /*boolean*/ ) { 
this.state = 19;
}else if(parent._stegohandler._extractionsuccessful /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False && (parent._stegohandler._lasterrormessage /*String*/ ).equals("") == false) { 
this.state = 21;
}if (true) break;

case 19:
//C
this.state = 22;
 //BA.debugLineNum = 150;BA.debugLine="txtMessage.Text=stegoHandler.extractedString";
parent.mostCurrent._txtmessage.setText(BA.ObjectToCharSequence(parent._stegohandler._extractedstring /*String*/ ));
 //BA.debugLineNum = 151;BA.debugLine="config.displayMessage(stegoHandler.lastErrorM";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,parent._stegohandler._lasterrormessage /*String*/ ,parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 152;BA.debugLine="ToastMessageShow(stegoHandler.lastErrorMessag";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(parent._stegohandler._lasterrormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 154;BA.debugLine="config.displayMessage(stegoHandler.lastErrorM";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,parent._stegohandler._lasterrormessage /*String*/ ,parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 155;BA.debugLine="ToastMessageShow(stegoHandler.lastErrorMessag";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(parent._stegohandler._lasterrormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 22:
//C
this.state = 25;
;
 //BA.debugLineNum = 157;BA.debugLine="stegoHandler.lastErrorMessage=\"\"";
parent._stegohandler._lasterrormessage /*String*/  = "";
 //BA.debugLineNum = 158;BA.debugLine="stegoHandler.extractionSuccessful = False";
parent._stegohandler._extractionsuccessful /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 159;BA.debugLine="stegoHandler.extractedString=\"\"";
parent._stegohandler._extractedstring /*String*/  = "";
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 161;BA.debugLine="config.displayMessage(\"An error has occured pl";
parent.mostCurrent._config._displaymessage /*String*/ (mostCurrent.activityBA,"An error has occured please Try Again!",parent.mostCurrent._lblerrormsg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 162;BA.debugLine="ToastMessageShow(\"An error has occured please";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("An error has occured please Try Again!"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 25:
//C
this.state = 26;
;
 if (true) break;

case 26:
//C
this.state = -1;
;
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _clearform() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Private Sub clearForm";
 //BA.debugLineNum = 176;BA.debugLine="imgCover.Bitmap=Null";
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 177;BA.debugLine="txtMessage.Text=\"\"";
mostCurrent._txtmessage.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 178;BA.debugLine="imgCover.Tag=\"\"";
mostCurrent._imgcover.setTag((Object)(""));
 //BA.debugLineNum = 179;BA.debugLine="txtKey.Text=\"\"";
mostCurrent._txtkey.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 180;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 181;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 182;BA.debugLine="stegoimage=\"\"";
_stegoimage = "";
 //BA.debugLineNum = 183;BA.debugLine="fromfile=False";
_fromfile = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 184;BA.debugLine="txtFileName.Text=\"\"";
mostCurrent._txtfilename.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 185;BA.debugLine="txtFileName.Tag=\"\"";
mostCurrent._txtfilename.setTag((Object)(""));
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public static void  _getpermissions() throws Exception{
ResumableSub_getPermissions rsub = new ResumableSub_getPermissions(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_getPermissions extends BA.ResumableSub {
public ResumableSub_getPermissions(ng.dsoftlab.stegocam.decode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.decode parent;
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
 //BA.debugLineNum = 194;BA.debugLine="For Each permission As String In Array(Starter.rp";
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
 //BA.debugLineNum = 195;BA.debugLine="Starter.rp.CheckAndRequest(permission)";
parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,_permission);
 //BA.debugLineNum = 196;BA.debugLine="Wait For Activity_PermissionResult (permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 197;BA.debugLine="If Result = False Then";
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
 //BA.debugLineNum = 198;BA.debugLine="MsgboxAsync(\"Please grant the neccessary permis";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please grant the neccessary permission to continue"),BA.ObjectToCharSequence("No Permission granted"),processBA);
 //BA.debugLineNum = 200;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 201;BA.debugLine="Return";
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
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 29;BA.debugLine="Private btnDecode As Button";
mostCurrent._btndecode = new anywheresoftware.b4a.objects.ButtonWrapper();
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
 //BA.debugLineNum = 58;BA.debugLine="Private txtFileName As EditText";
mostCurrent._txtfilename = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _imgcover_click() throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Private Sub imgCover_Click";
 //BA.debugLineNum = 190;BA.debugLine="BrowseStegoImage";
_browsestegoimage();
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpassword_click() throws Exception{
 //BA.debugLineNum = 233;BA.debugLine="Private Sub lblShowPassword_Click";
 //BA.debugLineNum = 234;BA.debugLine="If lblShowPassword.Text=config.hide Then";
if ((mostCurrent._lblshowpassword.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
 //BA.debugLineNum = 235;BA.debugLine="lblShowPassword.Text=config.show";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
 //BA.debugLineNum = 236;BA.debugLine="txtKey.PasswordMode=False";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 238;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 239;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 241;BA.debugLine="txtKey.SelectionStart=txtKey.Text.Length";
mostCurrent._txtkey.setSelectionStart(mostCurrent._txtkey.getText().length());
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private ion As Object";
_ion = new Object();
 //BA.debugLineNum = 11;BA.debugLine="Private imageChooser As ContentChooser";
_imagechooser = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 12;BA.debugLine="Private FileHandler1 As FileHandler";
_filehandler1 = new ng.dsoftlab.stegocam.filehandler();
 //BA.debugLineNum = 13;BA.debugLine="Private stegoHandler As StegocamHandler";
_stegohandler = new ng.dsoftlab.stegocam.stegocamhandler();
 //BA.debugLineNum = 14;BA.debugLine="Public stegoimage As String";
_stegoimage = "";
 //BA.debugLineNum = 15;BA.debugLine="Public fromfile As Boolean=False";
_fromfile = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
}
