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

public class pinsetup extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static pinsetup mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.pinsetup");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (pinsetup).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.pinsetup");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.pinsetup", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (pinsetup) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (pinsetup) Resume **");
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
		return pinsetup.class;
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
            BA.LogInfo("** Activity (pinsetup) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (pinsetup) Pause event (activity is not paused). **");
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
            pinsetup mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (pinsetup) Resume **");
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
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _imgicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblerrormsg = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblerrormsg2 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblerrormsg3 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblshowpassword = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlcontainer = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtanswer = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtpin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtquestion = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnsave = null;
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public de.donmanfred.SweetAlertDialogWrapper _sweet = null;
public anywheresoftware.b4a.objects.IME _ime = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.encode _encode = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.decode _decode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
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
 //BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"pinsetup\")";
mostCurrent._activity.LoadLayout("pinsetup",mostCurrent.activityBA);
 //BA.debugLineNum = 41;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 42;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 43;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 44;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 45;BA.debugLine="txtPin.InputType=Bit.Or(txtPin.InputType, 2)";
mostCurrent._txtpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtpin.getInputType(),(int) (2)));
 //BA.debugLineNum = 46;BA.debugLine="IME.Initialize(\"IME\")";
mostCurrent._ime.Initialize("IME");
 //BA.debugLineNum = 47;BA.debugLine="IME.SetLengthFilter(txtPin,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtpin.getObject()),(int) (4));
 //BA.debugLineNum = 48;BA.debugLine="clearForm";
_clearform();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 90;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 92;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 93;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 95;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 85;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _alert_oncancel() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub Alert_onCancel()";
 //BA.debugLineNum = 126;BA.debugLine="Log($\"Alert_onCancel()\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("314221313",("Alert_onCancel()"),0);
 //BA.debugLineNum = 127;BA.debugLine="sweet.AlertType = sweet.TypeError";
mostCurrent._sweet.setAlertType(mostCurrent._sweet.getTypeError());
 //BA.debugLineNum = 129;BA.debugLine="sweet.dismissWithAnimation";
mostCurrent._sweet.dismissWithAnimation();
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public static String  _alert_onconfirm() throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Sub Alert_onConfirm()";
 //BA.debugLineNum = 132;BA.debugLine="Log($\"Alert_onConfirm()\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("314286849",("Alert_onConfirm()"),0);
 //BA.debugLineNum = 134;BA.debugLine="sweet.dismissWithAnimation";
mostCurrent._sweet.dismissWithAnimation();
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public static void  _btnsave_click() throws Exception{
ResumableSub_btnSave_Click rsub = new ResumableSub_btnSave_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnSave_Click extends BA.ResumableSub {
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.pinsetup parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.pinsetup parent;
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
 //BA.debugLineNum = 100;BA.debugLine="sweet.Initialize(\"Alert\")";
parent.mostCurrent._sweet.Initialize(mostCurrent.activityBA,"Alert");
 //BA.debugLineNum = 101;BA.debugLine="If txtPin.Text.Length<4 Then";
if (true) break;

case 1:
//if
this.state = 14;
if (parent.mostCurrent._txtpin.getText().length()<4) { 
this.state = 3;
}else if((parent.mostCurrent._txtquestion.getText()).equals("")) { 
this.state = 5;
}else if((parent.mostCurrent._txtanswer.getText()).equals("")) { 
this.state = 7;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 14;
 //BA.debugLineNum = 102;BA.debugLine="lblErrorMsg.Text=\"Please enter 4 digits\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter 4 digits"));
 if (true) break;

case 5:
//C
this.state = 14;
 //BA.debugLineNum = 104;BA.debugLine="lblErrorMsg2.Text=\"Please enter security questio";
parent.mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence("Please enter security question"));
 if (true) break;

case 7:
//C
this.state = 14;
 //BA.debugLineNum = 106;BA.debugLine="lblErrorMsg3.Text =\"Please enter security answer";
parent.mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence("Please enter security answer"));
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 108;BA.debugLine="config.setUserPin(txtPin.Text)";
parent.mostCurrent._config._setuserpin /*String*/ (mostCurrent.activityBA,parent.mostCurrent._txtpin.getText());
 //BA.debugLineNum = 109;BA.debugLine="config.saveSecurityQA(txtQuestion.Text,txtAnswer";
parent.mostCurrent._config._savesecurityqa /*String*/ (mostCurrent.activityBA,parent.mostCurrent._txtquestion.getText(),parent.mostCurrent._txtanswer.getText());
 //BA.debugLineNum = 110;BA.debugLine="Msgbox2Async(\"PIN updated successfully!\",\"PIN up";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("PIN updated successfully!"),BA.ObjectToCharSequence("PIN updated"),"OK","","",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"icons8-success-100.png"),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 111;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 15;
return;
case 15:
//C
this.state = 10;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 112;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 113;BA.debugLine="StartActivity(Login)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._login.getObject()));
 //BA.debugLineNum = 114;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
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
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _clearform() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub clearForm";
 //BA.debugLineNum = 61;BA.debugLine="txtPin.Text=\"\"";
mostCurrent._txtpin.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 62;BA.debugLine="txtQuestion.Text=\"\"";
mostCurrent._txtquestion.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 63;BA.debugLine="txtAnswer.Text=\"\"";
mostCurrent._txtanswer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 64;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 65;BA.debugLine="lblErrorMsg2.Text=\"\"";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 66;BA.debugLine="lblErrorMsg3.Text=\"\"";
mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 67;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 68;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 69;BA.debugLine="txtPin.RequestFocus";
mostCurrent._txtpin.RequestFocus();
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mostCurrent._actoolbarlight1 = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private ToolbarHelper As ACActionBar";
mostCurrent._toolbarhelper = new de.amberhome.objects.appcompat.ACActionBar();
 //BA.debugLineNum = 19;BA.debugLine="Private imgIcon As B4XView";
mostCurrent._imgicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lblErrorMsg As B4XView";
mostCurrent._lblerrormsg = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lblErrorMsg2 As B4XView";
mostCurrent._lblerrormsg2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lblErrorMsg3 As B4XView";
mostCurrent._lblerrormsg3 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lblShowPassword As B4XView";
mostCurrent._lblshowpassword = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pnlContainer As B4XView";
mostCurrent._pnlcontainer = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private txtAnswer As EditText";
mostCurrent._txtanswer = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private txtPin As EditText";
mostCurrent._txtpin = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private txtQuestion As EditText";
mostCurrent._txtquestion = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private btnSave As B4XView";
mostCurrent._btnsave = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim SharedPrefs As SharedPreferences";
mostCurrent._sharedprefs = new com.b4x.sharedpreferences.SharedPreferences();
 //BA.debugLineNum = 31;BA.debugLine="Dim sweet As SweetAlertDialog";
mostCurrent._sweet = new de.donmanfred.SweetAlertDialogWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim IME As IME";
mostCurrent._ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpassword_click() throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub lblShowPassword_Click";
 //BA.debugLineNum = 73;BA.debugLine="If lblShowPassword.Text=config.hide Then";
if ((mostCurrent._lblshowpassword.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
 //BA.debugLineNum = 74;BA.debugLine="lblShowPassword.Text=config.show";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
 //BA.debugLineNum = 75;BA.debugLine="txtPin.PasswordMode=False";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 77;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
 //BA.debugLineNum = 78;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 80;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
mostCurrent._txtpin.setSelectionStart(mostCurrent._txtpin.getText().length());
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _txtanswer_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Private Sub txtAnswer_TextChanged (Old As String,";
 //BA.debugLineNum = 146;BA.debugLine="lblErrorMsg3.Text=\"\"";
mostCurrent._lblerrormsg3.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _txtpin_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Private Sub txtPin_TextChanged (Old As String, New";
 //BA.debugLineNum = 138;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _txtquestion_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Private Sub txtQuestion_TextChanged (Old As String";
 //BA.debugLineNum = 142;BA.debugLine="lblErrorMsg2.Text=\"\"";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
}
