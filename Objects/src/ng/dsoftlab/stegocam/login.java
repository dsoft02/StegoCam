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

public class login extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static login mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.login");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (login).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.login");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.login", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (login) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (login) Resume **");
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
		return login.class;
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
            BA.LogInfo("** Activity (login) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (login) Pause event (activity is not paused). **");
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
            login mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (login) Resume **");
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
public static ng.dsoftlab.stegocam.biometricmanager _biometric = null;
public anywheresoftware.b4a.objects.LabelWrapper _btnresetpin = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnsignin = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _imgfingerprint = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _imgicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblshowpassword = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtpin = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _label3 = null;
public static String _userpin = "";
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblerrormsg = null;
public anywheresoftware.b4a.objects.IME _ime = null;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.encode _encode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _res = "";
RDebugUtils.currentLine=44892160;
 //BA.debugLineNum = 44892160;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=44892162;
 //BA.debugLineNum = 44892162;BA.debugLine="Activity.LoadLayout(\"login\")";
mostCurrent._activity.LoadLayout("login",mostCurrent.activityBA);
RDebugUtils.currentLine=44892163;
 //BA.debugLineNum = 44892163;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=44892164;
 //BA.debugLineNum = 44892164;BA.debugLine="txtPin.InputType=Bit.Or(txtPin.InputType, 2)";
mostCurrent._txtpin.setInputType(anywheresoftware.b4a.keywords.Common.Bit.Or(mostCurrent._txtpin.getInputType(),(int) (2)));
RDebugUtils.currentLine=44892165;
 //BA.debugLineNum = 44892165;BA.debugLine="IME.Initialize(\"IME\")";
mostCurrent._ime.Initialize("IME");
RDebugUtils.currentLine=44892166;
 //BA.debugLineNum = 44892166;BA.debugLine="IME.SetLengthFilter(txtPin,4)";
mostCurrent._ime.SetLengthFilter((android.widget.EditText)(mostCurrent._txtpin.getObject()),(int) (4));
RDebugUtils.currentLine=44892167;
 //BA.debugLineNum = 44892167;BA.debugLine="clearForm";
_clearform();
RDebugUtils.currentLine=44892168;
 //BA.debugLineNum = 44892168;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=44892169;
 //BA.debugLineNum = 44892169;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=44892170;
 //BA.debugLineNum = 44892170;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=44892171;
 //BA.debugLineNum = 44892171;BA.debugLine="txtPin.Text=\"\"";
mostCurrent._txtpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=44892172;
 //BA.debugLineNum = 44892172;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=44892174;
 //BA.debugLineNum = 44892174;BA.debugLine="Biometric.Initialize(Me, \"Authenticate\")";
_biometric._initialize /*String*/ (null,processBA,login.getObject(),"Authenticate");
RDebugUtils.currentLine=44892175;
 //BA.debugLineNum = 44892175;BA.debugLine="Dim res As String = Biometric.CanAuthenticate";
_res = _biometric._canauthenticate /*String*/ (null);
RDebugUtils.currentLine=44892176;
 //BA.debugLineNum = 44892176;BA.debugLine="If res = \"SUCCESS\" Then";
if ((_res).equals("SUCCESS")) { 
RDebugUtils.currentLine=44892177;
 //BA.debugLineNum = 44892177;BA.debugLine="Label3.Visible=True";
mostCurrent._label3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=44892178;
 //BA.debugLineNum = 44892178;BA.debugLine="imgFingerprint.Visible=True";
mostCurrent._imgfingerprint.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=44892180;
 //BA.debugLineNum = 44892180;BA.debugLine="Label3.Visible=False";
mostCurrent._label3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=44892181;
 //BA.debugLineNum = 44892181;BA.debugLine="imgFingerprint.Visible=False";
mostCurrent._imgfingerprint.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=44892184;
 //BA.debugLineNum = 44892184;BA.debugLine="End Sub";
return "";
}
public static String  _clearform() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clearform", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clearform", null));}
RDebugUtils.currentLine=44957696;
 //BA.debugLineNum = 44957696;BA.debugLine="Private Sub clearForm";
RDebugUtils.currentLine=44957697;
 //BA.debugLineNum = 44957697;BA.debugLine="txtPin.Text=\"\"";
mostCurrent._txtpin.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=44957698;
 //BA.debugLineNum = 44957698;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=44957699;
 //BA.debugLineNum = 44957699;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=44957700;
 //BA.debugLineNum = 44957700;BA.debugLine="txtPin.RequestFocus";
mostCurrent._txtpin.RequestFocus();
RDebugUtils.currentLine=44957701;
 //BA.debugLineNum = 44957701;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=45219840;
 //BA.debugLineNum = 45219840;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=45219841;
 //BA.debugLineNum = 45219841;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=45219843;
 //BA.debugLineNum = 45219843;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=45219845;
 //BA.debugLineNum = 45219845;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=45219846;
 //BA.debugLineNum = 45219846;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="login";
RDebugUtils.currentLine=45088768;
 //BA.debugLineNum = 45088768;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=45088770;
 //BA.debugLineNum = 45088770;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=45023232;
 //BA.debugLineNum = 45023232;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=45023234;
 //BA.debugLineNum = 45023234;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=45154304;
 //BA.debugLineNum = 45154304;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=45154306;
 //BA.debugLineNum = 45154306;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=45154307;
 //BA.debugLineNum = 45154307;BA.debugLine="End Sub";
return "";
}
public static String  _btnresetpin_click() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnresetpin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnresetpin_click", null));}
RDebugUtils.currentLine=45547520;
 //BA.debugLineNum = 45547520;BA.debugLine="Private Sub btnResetPin_Click";
RDebugUtils.currentLine=45547521;
 //BA.debugLineNum = 45547521;BA.debugLine="StartActivity(forgotpin)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._forgotpin.getObject()));
RDebugUtils.currentLine=45547522;
 //BA.debugLineNum = 45547522;BA.debugLine="End Sub";
return "";
}
public static String  _btnsignin_click() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsignin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsignin_click", null));}
String _curpin = "";
RDebugUtils.currentLine=45350912;
 //BA.debugLineNum = 45350912;BA.debugLine="Private Sub btnSignin_Click";
RDebugUtils.currentLine=45350915;
 //BA.debugLineNum = 45350915;BA.debugLine="userPin = config.getUserPin";
mostCurrent._userpin = mostCurrent._config._getuserpin /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=45350917;
 //BA.debugLineNum = 45350917;BA.debugLine="Dim curPIN As String = txtPin.Text";
_curpin = mostCurrent._txtpin.getText();
RDebugUtils.currentLine=45350918;
 //BA.debugLineNum = 45350918;BA.debugLine="If curPIN=\"\" Or curPIN.Length<4 Then";
if ((_curpin).equals("") || _curpin.length()<4) { 
RDebugUtils.currentLine=45350919;
 //BA.debugLineNum = 45350919;BA.debugLine="lblErrorMsg.Text=\"Please enter 4 digits PIN\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter 4 digits PIN"));
 }else 
{RDebugUtils.currentLine=45350920;
 //BA.debugLineNum = 45350920;BA.debugLine="Else if curPIN=userPin Then";
if ((_curpin).equals(mostCurrent._userpin)) { 
RDebugUtils.currentLine=45350921;
 //BA.debugLineNum = 45350921;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=45350922;
 //BA.debugLineNum = 45350922;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 }else {
RDebugUtils.currentLine=45350924;
 //BA.debugLineNum = 45350924;BA.debugLine="lblErrorMsg.Text=\"Invalid PIN\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Invalid PIN"));
 }}
;
RDebugUtils.currentLine=45350926;
 //BA.debugLineNum = 45350926;BA.debugLine="End Sub";
return "";
}
public static void  _imgfingerprint_click() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgfingerprint_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "imgfingerprint_click", null); return;}
ResumableSub_imgFingerprint_Click rsub = new ResumableSub_imgFingerprint_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_imgFingerprint_Click extends BA.ResumableSub {
public ResumableSub_imgFingerprint_Click(ng.dsoftlab.stegocam.login parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.login parent;
boolean _fingerprintenabled = false;
boolean _success = false;
String _errormessage = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="login";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=45285377;
 //BA.debugLineNum = 45285377;BA.debugLine="Dim fingerPrintEnabled As Boolean=config.getBiome";
_fingerprintenabled = parent.mostCurrent._config._getbiometric /*boolean*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=45285379;
 //BA.debugLineNum = 45285379;BA.debugLine="If fingerPrintEnabled=True Then";
if (true) break;

case 1:
//if
this.state = 12;
if (_fingerprintenabled==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 3;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=45285380;
 //BA.debugLineNum = 45285380;BA.debugLine="Biometric.Show(\"Verifying Finegerprint\")";
parent._biometric._show /*String*/ (null,"Verifying Finegerprint");
RDebugUtils.currentLine=45285381;
 //BA.debugLineNum = 45285381;BA.debugLine="Wait For Authenticate_Complete (Success As Boole";
anywheresoftware.b4a.keywords.Common.WaitFor("authenticate_complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "login", "imgfingerprint_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 4;
_success = (Boolean) result[0];
_errormessage = (String) result[1];
;
RDebugUtils.currentLine=45285382;
 //BA.debugLineNum = 45285382;BA.debugLine="If Success Then";
if (true) break;

case 4:
//if
this.state = 9;
if (_success) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
RDebugUtils.currentLine=45285383;
 //BA.debugLineNum = 45285383;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
RDebugUtils.currentLine=45285384;
 //BA.debugLineNum = 45285384;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._mainmenu.getObject()));
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=45285387;
 //BA.debugLineNum = 45285387;BA.debugLine="ToastMessageShow(\"Error: \" & ErrorMessage,False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_errormessage),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 9:
//C
this.state = 12;
;
 if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=45285390;
 //BA.debugLineNum = 45285390;BA.debugLine="Msgbox2Async(\"Fingerprint login is not available";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Fingerprint login is not available for this account. You can change this in the settings page after login"),BA.ObjectToCharSequence("Notice"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=45285392;
 //BA.debugLineNum = 45285392;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _lblshowpassword_click() throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword_click", null));}
RDebugUtils.currentLine=45416448;
 //BA.debugLineNum = 45416448;BA.debugLine="Private Sub lblShowPassword_Click";
RDebugUtils.currentLine=45416449;
 //BA.debugLineNum = 45416449;BA.debugLine="If lblShowPassword.Text=config.hide Then";
if ((mostCurrent._lblshowpassword.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=45416450;
 //BA.debugLineNum = 45416450;BA.debugLine="lblShowPassword.Text=config.show";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=45416451;
 //BA.debugLineNum = 45416451;BA.debugLine="txtPin.PasswordMode=False";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=45416453;
 //BA.debugLineNum = 45416453;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=45416454;
 //BA.debugLineNum = 45416454;BA.debugLine="txtPin.PasswordMode=True";
mostCurrent._txtpin.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=45416456;
 //BA.debugLineNum = 45416456;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
mostCurrent._txtpin.setSelectionStart(mostCurrent._txtpin.getText().length());
RDebugUtils.currentLine=45416457;
 //BA.debugLineNum = 45416457;BA.debugLine="End Sub";
return "";
}
public static String  _txtpin_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="login";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtpin_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtpin_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=45481984;
 //BA.debugLineNum = 45481984;BA.debugLine="Private Sub txtPin_TextChanged (Old As String, New";
RDebugUtils.currentLine=45481985;
 //BA.debugLineNum = 45481985;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=45481986;
 //BA.debugLineNum = 45481986;BA.debugLine="End Sub";
return "";
}
}