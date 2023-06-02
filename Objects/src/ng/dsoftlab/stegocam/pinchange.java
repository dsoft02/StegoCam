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

public class pinchange extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static pinchange mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.pinchange");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (pinchange).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.pinchange");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.pinchange", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (pinchange) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (pinchange) Resume **");
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
		return pinchange.class;
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
            BA.LogInfo("** Activity (pinchange) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (pinchange) Pause event (activity is not paused). **");
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
            pinchange mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (pinchange) Resume **");
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
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgicon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerrormsg = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerrormsg2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerrormsg3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontainer = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtpin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsave = null;
public de.donmanfred.SweetAlertDialogWrapper _sweet = null;
public anywheresoftware.b4a.objects.IME _ime = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblshowpswd = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblshowpswd2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblshowpswd3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfirmnewpin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnewpin = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _user_img = null;
public anywheresoftware.b4a.objects.PanelWrapper _user_panel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
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
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=45744128;
 //BA.debugLineNum = 45744128;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=45744130;
 //BA.debugLineNum = 45744130;BA.debugLine="Activity.LoadLayout(\"pinchange\")";
mostCurrent._activity.LoadLayout("pinchange",mostCurrent.activityBA);
RDebugUtils.currentLine=45744132;
 //BA.debugLineNum = 45744132;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=45744133;
 //BA.debugLineNum = 45744133;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=45744134;
 //BA.debugLineNum = 45744134;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45744135;
 //BA.debugLineNum = 45744135;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=45744136;
 //BA.debugLineNum = 45744136;BA.debugLine="txtPin.InputType=Bit.Or(txtPin.InputType, 2)";
mostCurrent._txtpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtpin.getInputType(),(int) (2)));
RDebugUtils.currentLine=45744137;
 //BA.debugLineNum = 45744137;BA.debugLine="txtNewPIN.InputType=Bit.Or(txtNewPIN.InputType, 2";
mostCurrent._txtnewpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtnewpin.getInputType(),(int) (2)));
RDebugUtils.currentLine=45744138;
 //BA.debugLineNum = 45744138;BA.debugLine="txtConfirmNewPIN.InputType=Bit.Or(txtConfirmNewPI";
mostCurrent._txtconfirmnewpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtconfirmnewpin.getInputType(),(int) (2)));
RDebugUtils.currentLine=45744139;
 //BA.debugLineNum = 45744139;BA.debugLine="IME.Initialize(\"IME\")";
mostCurrent._ime.Initialize("IME");
RDebugUtils.currentLine=45744140;
 //BA.debugLineNum = 45744140;BA.debugLine="IME.SetLengthFilter(txtPin,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtpin.getObject()),(int) (4));
RDebugUtils.currentLine=45744141;
 //BA.debugLineNum = 45744141;BA.debugLine="IME.SetLengthFilter(txtNewPIN,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtnewpin.getObject()),(int) (4));
RDebugUtils.currentLine=45744142;
 //BA.debugLineNum = 45744142;BA.debugLine="IME.SetLengthFilter(txtConfirmNewPIN,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtconfirmnewpin.getObject()),(int) (4));
RDebugUtils.currentLine=45744143;
 //BA.debugLineNum = 45744143;BA.debugLine="clearForm";
_clearform();
RDebugUtils.currentLine=45744145;
 //BA.debugLineNum = 45744145;BA.debugLine="End Sub";
return "";
}
public static String  _clearform() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clearform", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clearform", null));}
RDebugUtils.currentLine=45940736;
 //BA.debugLineNum = 45940736;BA.debugLine="Private Sub clearForm";
RDebugUtils.currentLine=45940737;
 //BA.debugLineNum = 45940737;BA.debugLine="txtPin.Text=\"\"";
mostCurrent._txtpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45940738;
 //BA.debugLineNum = 45940738;BA.debugLine="txtNewPIN.Text=\"\"";
mostCurrent._txtnewpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45940739;
 //BA.debugLineNum = 45940739;BA.debugLine="txtConfirmNewPIN.Text=\"\"";
mostCurrent._txtconfirmnewpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45940740;
 //BA.debugLineNum = 45940740;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45940741;
 //BA.debugLineNum = 45940741;BA.debugLine="lblErrorMsg2.Text=\"\"";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45940742;
 //BA.debugLineNum = 45940742;BA.debugLine="lblErrorMsg3.Text=\"\"";
mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45940743;
 //BA.debugLineNum = 45940743;BA.debugLine="lblShowPswd.Text  = config.hide";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=45940744;
 //BA.debugLineNum = 45940744;BA.debugLine="lblShowPswd2.Text = config.hide";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=45940745;
 //BA.debugLineNum = 45940745;BA.debugLine="lblShowPswd3.Text = config.hide";
mostCurrent._lblshowpswd3.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=45940746;
 //BA.debugLineNum = 45940746;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=45940747;
 //BA.debugLineNum = 45940747;BA.debugLine="txtPin.RequestFocus";
mostCurrent._txtpin.RequestFocus();
RDebugUtils.currentLine=45940749;
 //BA.debugLineNum = 45940749;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=46268416;
 //BA.debugLineNum = 46268416;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=46268417;
 //BA.debugLineNum = 46268417;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=46268418;
 //BA.debugLineNum = 46268418;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
RDebugUtils.currentLine=46268419;
 //BA.debugLineNum = 46268419;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=46268420;
 //BA.debugLineNum = 46268420;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=46268422;
 //BA.debugLineNum = 46268422;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=46268423;
 //BA.debugLineNum = 46268423;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="pinchange";
RDebugUtils.currentLine=45875200;
 //BA.debugLineNum = 45875200;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=45875202;
 //BA.debugLineNum = 45875202;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=45809664;
 //BA.debugLineNum = 45809664;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=45809666;
 //BA.debugLineNum = 45809666;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=46202880;
 //BA.debugLineNum = 46202880;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=46202881;
 //BA.debugLineNum = 46202881;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
RDebugUtils.currentLine=46202882;
 //BA.debugLineNum = 46202882;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=46202883;
 //BA.debugLineNum = 46202883;BA.debugLine="End Sub";
return "";
}
public static String  _alert_oncancel() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "alert_oncancel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "alert_oncancel", null));}
RDebugUtils.currentLine=46399488;
 //BA.debugLineNum = 46399488;BA.debugLine="Sub Alert_onCancel()";
RDebugUtils.currentLine=46399489;
 //BA.debugLineNum = 46399489;BA.debugLine="Log($\"Alert_onCancel()\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("746399489",("Alert_onCancel()"),0);
RDebugUtils.currentLine=46399490;
 //BA.debugLineNum = 46399490;BA.debugLine="sweet.AlertType = sweet.TypeError";
mostCurrent._sweet.setAlertType(mostCurrent._sweet.getTypeError());
RDebugUtils.currentLine=46399492;
 //BA.debugLineNum = 46399492;BA.debugLine="sweet.dismissWithAnimation";
mostCurrent._sweet.dismissWithAnimation();
RDebugUtils.currentLine=46399493;
 //BA.debugLineNum = 46399493;BA.debugLine="End Sub";
return "";
}
public static String  _alert_onconfirm() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "alert_onconfirm", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "alert_onconfirm", null));}
RDebugUtils.currentLine=46465024;
 //BA.debugLineNum = 46465024;BA.debugLine="Sub Alert_onConfirm()";
RDebugUtils.currentLine=46465025;
 //BA.debugLineNum = 46465025;BA.debugLine="Log($\"Alert_onConfirm()\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("746465025",("Alert_onConfirm()"),0);
RDebugUtils.currentLine=46465027;
 //BA.debugLineNum = 46465027;BA.debugLine="sweet.dismissWithAnimation";
mostCurrent._sweet.dismissWithAnimation();
RDebugUtils.currentLine=46465028;
 //BA.debugLineNum = 46465028;BA.debugLine="End Sub";
return "";
}
public static String  _btncancel_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncancel_click", null));}
RDebugUtils.currentLine=46923776;
 //BA.debugLineNum = 46923776;BA.debugLine="Private Sub btnCancel_Click";
RDebugUtils.currentLine=46923777;
 //BA.debugLineNum = 46923777;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
RDebugUtils.currentLine=46923778;
 //BA.debugLineNum = 46923778;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=46923779;
 //BA.debugLineNum = 46923779;BA.debugLine="End Sub";
return "";
}
public static void  _btnsave_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsave_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnsave_click", null); return;}
ResumableSub_btnSave_Click rsub = new ResumableSub_btnSave_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnSave_Click extends BA.ResumableSub {
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.pinchange parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.pinchange parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="pinchange";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=46333953;
 //BA.debugLineNum = 46333953;BA.debugLine="sweet.Initialize(\"Alert\")";
parent.mostCurrent._sweet.Initialize(mostCurrent.activityBA,"Alert");
RDebugUtils.currentLine=46333954;
 //BA.debugLineNum = 46333954;BA.debugLine="If txtPin.Text.Length<4 Then";
if (true) break;

case 1:
//if
this.state = 16;
if (parent.mostCurrent._txtpin.getText().length()<4) { 
this.state = 3;
}else 
{RDebugUtils.currentLine=46333956;
 //BA.debugLineNum = 46333956;BA.debugLine="else if txtPin.Text <>config.getUserPin Then";
if ((parent.mostCurrent._txtpin.getText()).equals(parent.mostCurrent._config._getuserpin /*String*/ (mostCurrent.activityBA)) == false) { 
this.state = 5;
}else 
{RDebugUtils.currentLine=46333960;
 //BA.debugLineNum = 46333960;BA.debugLine="Else If txtNewPIN.Text.Length<4 Then";
if (parent.mostCurrent._txtnewpin.getText().length()<4) { 
this.state = 7;
}else 
{RDebugUtils.currentLine=46333963;
 //BA.debugLineNum = 46333963;BA.debugLine="else if txtNewPIN.Text <> txtConfirmNewPIN.Text T";
if ((parent.mostCurrent._txtnewpin.getText()).equals(parent.mostCurrent._txtconfirmnewpin.getText()) == false) { 
this.state = 9;
}else {
this.state = 11;
}}}}
if (true) break;

case 3:
//C
this.state = 16;
RDebugUtils.currentLine=46333955;
 //BA.debugLineNum = 46333955;BA.debugLine="lblErrorMsg.Text=\"Please enter current PIN of 4";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter current PIN of 4 digits"));
 if (true) break;

case 5:
//C
this.state = 16;
RDebugUtils.currentLine=46333957;
 //BA.debugLineNum = 46333957;BA.debugLine="lblErrorMsg.Text=\"current PIN is invalid\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("current PIN is invalid"));
RDebugUtils.currentLine=46333958;
 //BA.debugLineNum = 46333958;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
parent.mostCurrent._txtpin.setSelectionStart(parent.mostCurrent._txtpin.getText().length());
RDebugUtils.currentLine=46333959;
 //BA.debugLineNum = 46333959;BA.debugLine="txtPin.RequestFocus";
parent.mostCurrent._txtpin.RequestFocus();
 if (true) break;

case 7:
//C
this.state = 16;
RDebugUtils.currentLine=46333961;
 //BA.debugLineNum = 46333961;BA.debugLine="lblErrorMsg2.Text=\"Please enter new PIN of 4 dig";
parent.mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence("Please enter new PIN of 4 digits"));
RDebugUtils.currentLine=46333962;
 //BA.debugLineNum = 46333962;BA.debugLine="txtNewPIN.RequestFocus";
parent.mostCurrent._txtnewpin.RequestFocus();
 if (true) break;

case 9:
//C
this.state = 16;
RDebugUtils.currentLine=46333964;
 //BA.debugLineNum = 46333964;BA.debugLine="lblErrorMsg3.Text =\"New PIN and confirm PIN mism";
parent.mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
RDebugUtils.currentLine=46333965;
 //BA.debugLineNum = 46333965;BA.debugLine="txtConfirmNewPIN.RequestFocus";
parent.mostCurrent._txtconfirmnewpin.RequestFocus();
 if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=46333967;
 //BA.debugLineNum = 46333967;BA.debugLine="config.setUserPin(txtNewPIN.Text)";
parent.mostCurrent._config._setuserpin /*String*/ (mostCurrent.activityBA,parent.mostCurrent._txtnewpin.getText());
RDebugUtils.currentLine=46333968;
 //BA.debugLineNum = 46333968;BA.debugLine="Msgbox2Async(\"PIN updated successfully!\",\"PIN up";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("PIN updated successfully!"),BA.ObjectToCharSequence("PIN updated"),"OK","","",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"icons8-success-100.png"),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=46333969;
 //BA.debugLineNum = 46333969;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "pinchange", "btnsave_click"), null);
this.state = 17;
return;
case 17:
//C
this.state = 12;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=46333970;
 //BA.debugLineNum = 46333970;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 12:
//if
this.state = 15;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=46333971;
 //BA.debugLineNum = 46333971;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._settings.getObject()));
RDebugUtils.currentLine=46333972;
 //BA.debugLineNum = 46333972;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = -1;
;
RDebugUtils.currentLine=46333977;
 //BA.debugLineNum = 46333977;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lblshowpassword_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword_click", null));}
RDebugUtils.currentLine=46006272;
 //BA.debugLineNum = 46006272;BA.debugLine="Private Sub lblShowPassword_Click";
RDebugUtils.currentLine=46006273;
 //BA.debugLineNum = 46006273;BA.debugLine="If lblShowPswd.Text=config.hide Then";
if ((mostCurrent._lblshowpswd.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=46006274;
 //BA.debugLineNum = 46006274;BA.debugLine="lblShowPswd.Text=config.show";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=46006275;
 //BA.debugLineNum = 46006275;BA.debugLine="txtPin.PasswordMode=False";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46006277;
 //BA.debugLineNum = 46006277;BA.debugLine="lblShowPswd.Text=config.hide";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=46006278;
 //BA.debugLineNum = 46006278;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=46006280;
 //BA.debugLineNum = 46006280;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
mostCurrent._txtpin.setSelectionStart(mostCurrent._txtpin.getText().length());
RDebugUtils.currentLine=46006281;
 //BA.debugLineNum = 46006281;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpassword2_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword2_click", null));}
RDebugUtils.currentLine=46071808;
 //BA.debugLineNum = 46071808;BA.debugLine="Private Sub lblShowPassword2_Click";
RDebugUtils.currentLine=46071809;
 //BA.debugLineNum = 46071809;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
if ((mostCurrent._lblshowpswd2.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=46071810;
 //BA.debugLineNum = 46071810;BA.debugLine="lblShowPswd2.Text=config.show";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=46071811;
 //BA.debugLineNum = 46071811;BA.debugLine="txtNewPIN.PasswordMode=False";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46071813;
 //BA.debugLineNum = 46071813;BA.debugLine="lblShowPswd2.Text=config.hide";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=46071814;
 //BA.debugLineNum = 46071814;BA.debugLine="txtNewPIN.PasswordMode=True";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=46071816;
 //BA.debugLineNum = 46071816;BA.debugLine="txtNewPIN.SelectionStart=txtNewPIN.Text.Length";
mostCurrent._txtnewpin.setSelectionStart(mostCurrent._txtnewpin.getText().length());
RDebugUtils.currentLine=46071817;
 //BA.debugLineNum = 46071817;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpassword3_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword3_click", null));}
RDebugUtils.currentLine=46137344;
 //BA.debugLineNum = 46137344;BA.debugLine="Private Sub lblShowPassword3_Click";
RDebugUtils.currentLine=46137345;
 //BA.debugLineNum = 46137345;BA.debugLine="If lblShowPswd3.Text=config.hide Then";
if ((mostCurrent._lblshowpswd3.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=46137346;
 //BA.debugLineNum = 46137346;BA.debugLine="lblShowPswd3.Text=config.show";
mostCurrent._lblshowpswd3.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=46137347;
 //BA.debugLineNum = 46137347;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46137349;
 //BA.debugLineNum = 46137349;BA.debugLine="lblShowPswd3.Text=config.hide";
mostCurrent._lblshowpswd3.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=46137350;
 //BA.debugLineNum = 46137350;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=46137352;
 //BA.debugLineNum = 46137352;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
mostCurrent._txtconfirmnewpin.setSelectionStart(mostCurrent._txtconfirmnewpin.getText().length());
RDebugUtils.currentLine=46137353;
 //BA.debugLineNum = 46137353;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpswd_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpswd_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpswd_click", null));}
RDebugUtils.currentLine=46727168;
 //BA.debugLineNum = 46727168;BA.debugLine="Private Sub lblShowPswd_Click";
RDebugUtils.currentLine=46727169;
 //BA.debugLineNum = 46727169;BA.debugLine="If lblShowPswd.Text=config.hide Then";
if ((mostCurrent._lblshowpswd.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=46727170;
 //BA.debugLineNum = 46727170;BA.debugLine="lblShowPswd.Text=config.show";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=46727171;
 //BA.debugLineNum = 46727171;BA.debugLine="txtPin.PasswordMode=False";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46727173;
 //BA.debugLineNum = 46727173;BA.debugLine="lblShowPswd.Text=config.hide";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=46727174;
 //BA.debugLineNum = 46727174;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=46727176;
 //BA.debugLineNum = 46727176;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
mostCurrent._txtpin.setSelectionStart(mostCurrent._txtpin.getText().length());
RDebugUtils.currentLine=46727177;
 //BA.debugLineNum = 46727177;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpswd2_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpswd2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpswd2_click", null));}
RDebugUtils.currentLine=46792704;
 //BA.debugLineNum = 46792704;BA.debugLine="Private Sub lblShowPswd2_Click";
RDebugUtils.currentLine=46792705;
 //BA.debugLineNum = 46792705;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
if ((mostCurrent._lblshowpswd2.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=46792706;
 //BA.debugLineNum = 46792706;BA.debugLine="lblShowPswd2.Text=config.show";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=46792707;
 //BA.debugLineNum = 46792707;BA.debugLine="txtNewPIN.PasswordMode=False";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46792709;
 //BA.debugLineNum = 46792709;BA.debugLine="lblShowPswd2.Text=config.hide";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=46792710;
 //BA.debugLineNum = 46792710;BA.debugLine="txtNewPIN.PasswordMode=True";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=46792712;
 //BA.debugLineNum = 46792712;BA.debugLine="txtNewPIN.SelectionStart=txtNewPIN.Text.Length";
mostCurrent._txtnewpin.setSelectionStart(mostCurrent._txtnewpin.getText().length());
RDebugUtils.currentLine=46792713;
 //BA.debugLineNum = 46792713;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpswd3_click() throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpswd3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpswd3_click", null));}
RDebugUtils.currentLine=46858240;
 //BA.debugLineNum = 46858240;BA.debugLine="Private Sub lblShowPswd3_Click";
RDebugUtils.currentLine=46858241;
 //BA.debugLineNum = 46858241;BA.debugLine="If lblShowPswd3.Text=config.hide Then";
if ((mostCurrent._lblshowpswd3.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=46858242;
 //BA.debugLineNum = 46858242;BA.debugLine="lblShowPswd3.Text=config.show";
mostCurrent._lblshowpswd3.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=46858243;
 //BA.debugLineNum = 46858243;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=46858245;
 //BA.debugLineNum = 46858245;BA.debugLine="lblShowPswd3.Text=config.hide";
mostCurrent._lblshowpswd3.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=46858246;
 //BA.debugLineNum = 46858246;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=46858248;
 //BA.debugLineNum = 46858248;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
mostCurrent._txtconfirmnewpin.setSelectionStart(mostCurrent._txtconfirmnewpin.getText().length());
RDebugUtils.currentLine=46858249;
 //BA.debugLineNum = 46858249;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfirmnewpin_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfirmnewpin_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfirmnewpin_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=46661632;
 //BA.debugLineNum = 46661632;BA.debugLine="Private Sub txtConfirmNewPIN_TextChanged (Old As S";
RDebugUtils.currentLine=46661633;
 //BA.debugLineNum = 46661633;BA.debugLine="If txtNewPIN.Text <> txtConfirmNewPIN.Text Then";
if ((mostCurrent._txtnewpin.getText()).equals(mostCurrent._txtconfirmnewpin.getText()) == false) { 
RDebugUtils.currentLine=46661634;
 //BA.debugLineNum = 46661634;BA.debugLine="lblErrorMsg3.Text=\"New PIN and confirm PIN misma";
mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
 }else {
RDebugUtils.currentLine=46661636;
 //BA.debugLineNum = 46661636;BA.debugLine="lblErrorMsg3.Text=\"\"";
mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=46661639;
 //BA.debugLineNum = 46661639;BA.debugLine="End Sub";
return "";
}
public static String  _txtnewpin_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnewpin_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnewpin_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=46596096;
 //BA.debugLineNum = 46596096;BA.debugLine="Private Sub txtNewPIN_TextChanged (Old As String,";
RDebugUtils.currentLine=46596097;
 //BA.debugLineNum = 46596097;BA.debugLine="lblErrorMsg2.Text=\"\"";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=46596098;
 //BA.debugLineNum = 46596098;BA.debugLine="End Sub";
return "";
}
public static String  _txtpin_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pinchange";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtpin_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtpin_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=46530560;
 //BA.debugLineNum = 46530560;BA.debugLine="Private Sub txtPin_TextChanged (Old As String, New";
RDebugUtils.currentLine=46530561;
 //BA.debugLineNum = 46530561;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=46530562;
 //BA.debugLineNum = 46530562;BA.debugLine="End Sub";
return "";
}
}