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

public class pinreset extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static pinreset mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.pinreset");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (pinreset).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.pinreset");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.pinreset", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (pinreset) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (pinreset) Resume **");
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
		return pinreset.class;
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
            BA.LogInfo("** Activity (pinreset) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (pinreset) Pause event (activity is not paused). **");
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
            pinreset mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (pinreset) Resume **");
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
public anywheresoftware.b4a.objects.IME _ime = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsave = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerrormsg = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerrormsg2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblshowpswd = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblshowpswd2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfirmnewpin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnewpin = null;
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
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=47120384;
 //BA.debugLineNum = 47120384;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=47120386;
 //BA.debugLineNum = 47120386;BA.debugLine="Activity.LoadLayout(\"pinreset\")";
mostCurrent._activity.LoadLayout("pinreset",mostCurrent.activityBA);
RDebugUtils.currentLine=47120388;
 //BA.debugLineNum = 47120388;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=47120389;
 //BA.debugLineNum = 47120389;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=47120390;
 //BA.debugLineNum = 47120390;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=47120391;
 //BA.debugLineNum = 47120391;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=47120392;
 //BA.debugLineNum = 47120392;BA.debugLine="txtNewPin.InputType=Bit.Or(txtNewPin.InputType, 2";
mostCurrent._txtnewpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtnewpin.getInputType(),(int) (2)));
RDebugUtils.currentLine=47120393;
 //BA.debugLineNum = 47120393;BA.debugLine="txtConfirmNewPIN.InputType=Bit.Or(txtConfirmNewPI";
mostCurrent._txtconfirmnewpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtconfirmnewpin.getInputType(),(int) (2)));
RDebugUtils.currentLine=47120394;
 //BA.debugLineNum = 47120394;BA.debugLine="IME.SetLengthFilter(txtNewPin,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtnewpin.getObject()),(int) (4));
RDebugUtils.currentLine=47120395;
 //BA.debugLineNum = 47120395;BA.debugLine="IME.SetLengthFilter(txtConfirmNewPIN,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtconfirmnewpin.getObject()),(int) (4));
RDebugUtils.currentLine=47120396;
 //BA.debugLineNum = 47120396;BA.debugLine="clearForm";
_clearform();
RDebugUtils.currentLine=47120398;
 //BA.debugLineNum = 47120398;BA.debugLine="End Sub";
return "";
}
public static String  _clearform() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clearform", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clearform", null));}
RDebugUtils.currentLine=47316992;
 //BA.debugLineNum = 47316992;BA.debugLine="Private Sub clearForm";
RDebugUtils.currentLine=47316993;
 //BA.debugLineNum = 47316993;BA.debugLine="txtNewPin.Text=\"\"";
mostCurrent._txtnewpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=47316994;
 //BA.debugLineNum = 47316994;BA.debugLine="txtConfirmNewPIN.Text=\"\"";
mostCurrent._txtconfirmnewpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=47316995;
 //BA.debugLineNum = 47316995;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=47316996;
 //BA.debugLineNum = 47316996;BA.debugLine="lblErrorMsg2.Text=\"\"";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=47316997;
 //BA.debugLineNum = 47316997;BA.debugLine="lblShowPswd.Text  = config.hide";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=47316998;
 //BA.debugLineNum = 47316998;BA.debugLine="lblShowPswd2.Text = config.hide";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=47316999;
 //BA.debugLineNum = 47316999;BA.debugLine="txtNewPin.PasswordMode=True";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=47317000;
 //BA.debugLineNum = 47317000;BA.debugLine="txtNewPin.RequestFocus";
mostCurrent._txtnewpin.RequestFocus();
RDebugUtils.currentLine=47317002;
 //BA.debugLineNum = 47317002;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=47579136;
 //BA.debugLineNum = 47579136;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=47579137;
 //BA.debugLineNum = 47579137;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=47579138;
 //BA.debugLineNum = 47579138;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
RDebugUtils.currentLine=47579139;
 //BA.debugLineNum = 47579139;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=47579140;
 //BA.debugLineNum = 47579140;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=47579142;
 //BA.debugLineNum = 47579142;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=47579143;
 //BA.debugLineNum = 47579143;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="pinreset";
RDebugUtils.currentLine=47251456;
 //BA.debugLineNum = 47251456;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=47251458;
 //BA.debugLineNum = 47251458;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=47185920;
 //BA.debugLineNum = 47185920;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=47185922;
 //BA.debugLineNum = 47185922;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=47513600;
 //BA.debugLineNum = 47513600;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=47513601;
 //BA.debugLineNum = 47513601;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
RDebugUtils.currentLine=47513602;
 //BA.debugLineNum = 47513602;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=47513603;
 //BA.debugLineNum = 47513603;BA.debugLine="End Sub";
return "";
}
public static String  _btncancel_click() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncancel_click", null));}
RDebugUtils.currentLine=47972352;
 //BA.debugLineNum = 47972352;BA.debugLine="Private Sub btnCancel_Click";
RDebugUtils.currentLine=47972353;
 //BA.debugLineNum = 47972353;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=47972354;
 //BA.debugLineNum = 47972354;BA.debugLine="End Sub";
return "";
}
public static void  _btnsave_click() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsave_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnsave_click", null); return;}
ResumableSub_btnSave_Click rsub = new ResumableSub_btnSave_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnSave_Click extends BA.ResumableSub {
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.pinreset parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.pinreset parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="pinreset";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=47644673;
 //BA.debugLineNum = 47644673;BA.debugLine="If txtNewPin.Text.Length<4 Then";
if (true) break;

case 1:
//if
this.state = 12;
if (parent.mostCurrent._txtnewpin.getText().length()<4) { 
this.state = 3;
}else 
{RDebugUtils.currentLine=47644676;
 //BA.debugLineNum = 47644676;BA.debugLine="else if txtConfirmNewPIN.Text <> txtConfirmNewPIN";
if ((parent.mostCurrent._txtconfirmnewpin.getText()).equals(parent.mostCurrent._txtconfirmnewpin.getText()) == false) { 
this.state = 5;
}else {
this.state = 7;
}}
if (true) break;

case 3:
//C
this.state = 12;
RDebugUtils.currentLine=47644674;
 //BA.debugLineNum = 47644674;BA.debugLine="lblErrorMsg.Text=\"Please enter new PIN of 4 digi";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter new PIN of 4 digits"));
RDebugUtils.currentLine=47644675;
 //BA.debugLineNum = 47644675;BA.debugLine="txtNewPin.RequestFocus";
parent.mostCurrent._txtnewpin.RequestFocus();
 if (true) break;

case 5:
//C
this.state = 12;
RDebugUtils.currentLine=47644677;
 //BA.debugLineNum = 47644677;BA.debugLine="lblErrorMsg2.Text =\"New PIN and confirm PIN mism";
parent.mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
RDebugUtils.currentLine=47644678;
 //BA.debugLineNum = 47644678;BA.debugLine="txtConfirmNewPIN.RequestFocus";
parent.mostCurrent._txtconfirmnewpin.RequestFocus();
 if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=47644680;
 //BA.debugLineNum = 47644680;BA.debugLine="config.setUserPin(txtNewPin.Text)";
parent.mostCurrent._config._setuserpin /*String*/ (mostCurrent.activityBA,parent.mostCurrent._txtnewpin.getText());
RDebugUtils.currentLine=47644681;
 //BA.debugLineNum = 47644681;BA.debugLine="Msgbox2Async(\"PIN updated successfully!\",\"PIN up";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("PIN updated successfully!"),BA.ObjectToCharSequence("PIN updated"),"OK","","",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"icons8-success-100.png"),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=47644682;
 //BA.debugLineNum = 47644682;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "pinreset", "btnsave_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 8;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=47644683;
 //BA.debugLineNum = 47644683;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 8:
//if
this.state = 11;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=47644684;
 //BA.debugLineNum = 47644684;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 11:
//C
this.state = 12;
;
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=47644687;
 //BA.debugLineNum = 47644687;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lblshowpassword_click() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword_click", null));}
RDebugUtils.currentLine=47382528;
 //BA.debugLineNum = 47382528;BA.debugLine="Private Sub lblShowPassword_Click";
RDebugUtils.currentLine=47382529;
 //BA.debugLineNum = 47382529;BA.debugLine="If lblShowPswd.Text=config.hide Then";
if ((mostCurrent._lblshowpswd.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=47382530;
 //BA.debugLineNum = 47382530;BA.debugLine="lblShowPswd.Text=config.show";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=47382531;
 //BA.debugLineNum = 47382531;BA.debugLine="txtNewPin.PasswordMode=False";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=47382533;
 //BA.debugLineNum = 47382533;BA.debugLine="lblShowPswd.Text=config.hide";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=47382534;
 //BA.debugLineNum = 47382534;BA.debugLine="txtNewPin.PasswordMode=True";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=47382536;
 //BA.debugLineNum = 47382536;BA.debugLine="txtNewPin.SelectionStart=txtNewPin.Text.Length";
mostCurrent._txtnewpin.setSelectionStart(mostCurrent._txtnewpin.getText().length());
RDebugUtils.currentLine=47382537;
 //BA.debugLineNum = 47382537;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpassword2_click() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword2_click", null));}
RDebugUtils.currentLine=47448064;
 //BA.debugLineNum = 47448064;BA.debugLine="Private Sub lblShowPassword2_Click";
RDebugUtils.currentLine=47448065;
 //BA.debugLineNum = 47448065;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
if ((mostCurrent._lblshowpswd2.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=47448066;
 //BA.debugLineNum = 47448066;BA.debugLine="lblShowPswd2.Text=config.show";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=47448067;
 //BA.debugLineNum = 47448067;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=47448069;
 //BA.debugLineNum = 47448069;BA.debugLine="lblShowPswd2.Text=config.hide";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=47448070;
 //BA.debugLineNum = 47448070;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=47448072;
 //BA.debugLineNum = 47448072;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
mostCurrent._txtconfirmnewpin.setSelectionStart(mostCurrent._txtconfirmnewpin.getText().length());
RDebugUtils.currentLine=47448073;
 //BA.debugLineNum = 47448073;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpswd_click() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpswd_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpswd_click", null));}
RDebugUtils.currentLine=47841280;
 //BA.debugLineNum = 47841280;BA.debugLine="Private Sub lblShowPswd_Click";
RDebugUtils.currentLine=47841281;
 //BA.debugLineNum = 47841281;BA.debugLine="If lblShowPswd.Text=config.hide Then";
if ((mostCurrent._lblshowpswd.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=47841282;
 //BA.debugLineNum = 47841282;BA.debugLine="lblShowPswd.Text=config.show";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=47841283;
 //BA.debugLineNum = 47841283;BA.debugLine="txtNewPin.PasswordMode=False";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=47841285;
 //BA.debugLineNum = 47841285;BA.debugLine="lblShowPswd.Text=config.hide";
mostCurrent._lblshowpswd.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=47841286;
 //BA.debugLineNum = 47841286;BA.debugLine="txtNewPin.PasswordMode=True";
mostCurrent._txtnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=47841288;
 //BA.debugLineNum = 47841288;BA.debugLine="txtNewPin.SelectionStart=txtNewPin.Text.Length";
mostCurrent._txtnewpin.setSelectionStart(mostCurrent._txtnewpin.getText().length());
RDebugUtils.currentLine=47841289;
 //BA.debugLineNum = 47841289;BA.debugLine="End Sub";
return "";
}
public static String  _lblshowpswd2_click() throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpswd2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpswd2_click", null));}
RDebugUtils.currentLine=47906816;
 //BA.debugLineNum = 47906816;BA.debugLine="Private Sub lblShowPswd2_Click";
RDebugUtils.currentLine=47906817;
 //BA.debugLineNum = 47906817;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
if ((mostCurrent._lblshowpswd2.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=47906818;
 //BA.debugLineNum = 47906818;BA.debugLine="lblShowPswd2.Text=config.show";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=47906819;
 //BA.debugLineNum = 47906819;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=47906821;
 //BA.debugLineNum = 47906821;BA.debugLine="lblShowPswd2.Text=config.hide";
mostCurrent._lblshowpswd2.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=47906822;
 //BA.debugLineNum = 47906822;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
mostCurrent._txtconfirmnewpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=47906824;
 //BA.debugLineNum = 47906824;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
mostCurrent._txtconfirmnewpin.setSelectionStart(mostCurrent._txtconfirmnewpin.getText().length());
RDebugUtils.currentLine=47906825;
 //BA.debugLineNum = 47906825;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfirmnewpin_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfirmnewpin_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfirmnewpin_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=47775744;
 //BA.debugLineNum = 47775744;BA.debugLine="Private Sub txtConfirmNewPIN_TextChanged (Old As S";
RDebugUtils.currentLine=47775745;
 //BA.debugLineNum = 47775745;BA.debugLine="If txtNewPin.Text <> txtConfirmNewPIN.Text Then";
if ((mostCurrent._txtnewpin.getText()).equals(mostCurrent._txtconfirmnewpin.getText()) == false) { 
RDebugUtils.currentLine=47775746;
 //BA.debugLineNum = 47775746;BA.debugLine="lblErrorMsg2.Text=\"New PIN and confirm PIN misma";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
 }else {
RDebugUtils.currentLine=47775748;
 //BA.debugLineNum = 47775748;BA.debugLine="lblErrorMsg2.Text=\"\"";
mostCurrent._lblerrormsg2.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=47775751;
 //BA.debugLineNum = 47775751;BA.debugLine="End Sub";
return "";
}
public static String  _txtnewpin_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pinreset";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnewpin_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnewpin_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=47710208;
 //BA.debugLineNum = 47710208;BA.debugLine="Private Sub txtNewPIN_TextChanged (Old As String,";
RDebugUtils.currentLine=47710209;
 //BA.debugLineNum = 47710209;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=47710210;
 //BA.debugLineNum = 47710210;BA.debugLine="End Sub";
return "";
}
}