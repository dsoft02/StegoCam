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

public class mainmenu extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static mainmenu mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.mainmenu");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (mainmenu).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.mainmenu");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.mainmenu", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (mainmenu) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (mainmenu) Resume **");
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
		return mainmenu.class;
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
            BA.LogInfo("** Activity (mainmenu) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (mainmenu) Pause event (activity is not paused). **");
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
            mainmenu mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (mainmenu) Resume **");
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
public static ng.dsoftlab.stegocam.biometricmanager _biometric = null;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public ng.dsoftlab.stegocam.b4xdrawer _drawer = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb1menu = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb2menu = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb3menu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ic1menu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ic2menu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ic3menu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ic4menu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ic5menu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ic6menu = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public ng.dsoftlab.stegocam.simplescale _myscale = null;
public anywheresoftware.b4a.objects.PanelWrapper _container = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgabout = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgdecode = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgencode = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgexit = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imghistory = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgsettings = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblabout = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldecode = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblencode = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexit = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblhistory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblsettings = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlabout = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldecode = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlencode = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlexit = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlhistory = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsettings = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
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
 //BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 59;BA.debugLine="Try";
try { //BA.debugLineNum = 60;BA.debugLine="Drawer.Initialize(Me, \"Drawer\", Activity, 300dip";
mostCurrent._drawer._initialize /*String*/ (mostCurrent.activityBA,mainmenu.getObject(),"Drawer",(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 //BA.debugLineNum = 61;BA.debugLine="Drawer.CenterPanel.LoadLayout(\"mainmenu\")";
mostCurrent._drawer._getcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().LoadLayout("mainmenu",mostCurrent.activityBA);
 //BA.debugLineNum = 62;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 63;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to tru";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 64;BA.debugLine="ToolbarHelper.UpIndicatorDrawable = config.Bitma";
mostCurrent._toolbarhelper.setUpIndicatorDrawable((android.graphics.drawable.Drawable)(mostCurrent._config._bitmaptobitmapdrawable /*anywheresoftware.b4a.objects.drawable.BitmapDrawable*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"hamburger.png")).getObject()));
 //BA.debugLineNum = 65;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 66;BA.debugLine="Drawer.LeftPanel.LoadLayout(\"leftmenu\")";
mostCurrent._drawer._getleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().LoadLayout("leftmenu",mostCurrent.activityBA);
 //BA.debugLineNum = 67;BA.debugLine="load_Images";
_load_images();
 } 
       catch (Exception e11) {
			processBA.setLastException(e11); //BA.debugLineNum = 71;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("437945358",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 90;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And Drawer.Lef";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
 //BA.debugLineNum = 91;BA.debugLine="Drawer.LeftOpen = False";
mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 92;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else if(_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._drawer._getleftopen /*boolean*/ ()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 94;BA.debugLine="pnlExit_Click";
_pnlexit_click();
 //BA.debugLineNum = 95;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 97;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_menuitemclick(de.amberhome.objects.appcompat.ACMenuItemWrapper _item) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Private Sub ACToolBarLight1_MenuItemClick (Item As";
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 86;BA.debugLine="Drawer.LeftOpen = Not(Drawer.LeftOpen)";
mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.Not(mostCurrent._drawer._getleftopen /*boolean*/ ()));
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mostCurrent._actoolbarlight1 = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private ToolbarHelper As ACActionBar";
mostCurrent._toolbarhelper = new de.amberhome.objects.appcompat.ACActionBar();
 //BA.debugLineNum = 19;BA.debugLine="Private Drawer As B4XDrawer";
mostCurrent._drawer = new ng.dsoftlab.stegocam.b4xdrawer();
 //BA.debugLineNum = 21;BA.debugLine="Private lb1Menu As Label";
mostCurrent._lb1menu = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lb2Menu As Label";
mostCurrent._lb2menu = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lb3Menu As Label";
mostCurrent._lb3menu = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ic1Menu As ImageView";
mostCurrent._ic1menu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ic2Menu As ImageView";
mostCurrent._ic2menu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private ic3Menu As ImageView";
mostCurrent._ic3menu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private ic4Menu As ImageView";
mostCurrent._ic4menu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private ic5Menu As ImageView";
mostCurrent._ic5menu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private ic6Menu As ImageView";
mostCurrent._ic6menu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private EditText1 As EditText";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private Button1 As Button";
mostCurrent._button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim myScale As SimpleScale";
mostCurrent._myscale = new ng.dsoftlab.stegocam.simplescale();
 //BA.debugLineNum = 34;BA.debugLine="Dim container As Panel";
mostCurrent._container = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private imgAbout As ImageView";
mostCurrent._imgabout = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private imgDecode As ImageView";
mostCurrent._imgdecode = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private imgEncode As ImageView";
mostCurrent._imgencode = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private imgExit As ImageView";
mostCurrent._imgexit = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private imgHistory As ImageView";
mostCurrent._imghistory = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private imgSettings As ImageView";
mostCurrent._imgsettings = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lblAbout As Label";
mostCurrent._lblabout = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private lblDecode As Label";
mostCurrent._lbldecode = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lblEncode As Label";
mostCurrent._lblencode = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lblExit As Label";
mostCurrent._lblexit = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private lblHistory As Label";
mostCurrent._lblhistory = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private lblSettings As Label";
mostCurrent._lblsettings = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private pnlAbout As Panel";
mostCurrent._pnlabout = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private pnlDecode As Panel";
mostCurrent._pnldecode = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private pnlEncode As Panel";
mostCurrent._pnlencode = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private pnlExit As Panel";
mostCurrent._pnlexit = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private pnlHistory As Panel";
mostCurrent._pnlhistory = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private pnlSettings As Panel";
mostCurrent._pnlsettings = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static void  _lb1menu_click() throws Exception{
ResumableSub_lb1Menu_Click rsub = new ResumableSub_lb1Menu_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lb1Menu_Click extends BA.ResumableSub {
public ResumableSub_lb1Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 116;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 117;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 118;BA.debugLine="StartActivity(encode)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._encode.getObject()));
 //BA.debugLineNum = 119;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb2menu_click() throws Exception{
ResumableSub_lb2Menu_Click rsub = new ResumableSub_lb2Menu_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lb2Menu_Click extends BA.ResumableSub {
public ResumableSub_lb2Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 123;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 124;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 125;BA.debugLine="StartActivity(decode)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._decode.getObject()));
 //BA.debugLineNum = 126;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb3menu_click() throws Exception{
ResumableSub_lb3Menu_Click rsub = new ResumableSub_lb3Menu_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lb3Menu_Click extends BA.ResumableSub {
public ResumableSub_lb3Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 130;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 131;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 132;BA.debugLine="StartActivity(history)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._history.getObject()));
 //BA.debugLineNum = 133;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb4menu_click() throws Exception{
ResumableSub_lb4Menu_Click rsub = new ResumableSub_lb4Menu_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lb4Menu_Click extends BA.ResumableSub {
public ResumableSub_lb4Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 137;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 138;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 139;BA.debugLine="MsgboxAsync(\"Application developed by Ebenezer Og";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Application developed by Ebenezer Ogidiolu in the scope of Alx Software Engineering Project."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"The stegocam application allows users to hide secret messages or files within images, providing a secure and confidential communication method."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Users can take new photos or select existing ones from their device. They have the option to hide a secret message or file within the image using various encryption methods, such as AES or DES."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"To extract hidden data, users can view their modified photos within the app and decrypt the hidden message or extract the hidden file."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"For any inquiries or support, please contact: ogidioluebenezer@gmail.com | +2349169442847"+anywheresoftware.b4a.keywords.Common.CRLF),BA.ObjectToCharSequence("About the stegocam application"),processBA);
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb5menu_click() throws Exception{
ResumableSub_lb5Menu_Click rsub = new ResumableSub_lb5Menu_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lb5Menu_Click extends BA.ResumableSub {
public ResumableSub_lb5Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 144;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 145;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 146;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._settings.getObject()));
 //BA.debugLineNum = 147;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb6menu_click() throws Exception{
ResumableSub_lb6Menu_Click rsub = new ResumableSub_lb6Menu_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lb6Menu_Click extends BA.ResumableSub {
public ResumableSub_lb6Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 151;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 152;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 153;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent.mostCurrent._settings.getObject()));
 //BA.debugLineNum = 154;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _load_images() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Sub load_Images";
 //BA.debugLineNum = 106;BA.debugLine="config.AjustImageView(ic1Menu,File.DirAssets,\"loc";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic1menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"lock_color.png");
 //BA.debugLineNum = 107;BA.debugLine="config.AjustImageView(ic2Menu,File.DirAssets,\"unl";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic2menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"unlock_color.png");
 //BA.debugLineNum = 108;BA.debugLine="config.AjustImageView(ic3Menu,File.DirAssets,\"his";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic3menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"history_color.png");
 //BA.debugLineNum = 109;BA.debugLine="config.AjustImageView(ic4Menu,File.DirAssets,\"abo";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic4menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"about_color.png");
 //BA.debugLineNum = 110;BA.debugLine="config.AjustImageView(ic5Menu,File.DirAssets,\"pin";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic5menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pin.png");
 //BA.debugLineNum = 111;BA.debugLine="config.AjustImageView(ic6Menu,File.DirAssets,\"sec";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic6menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"sec_quest.png");
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _pnlabout_click() throws Exception{
 //BA.debugLineNum = 186;BA.debugLine="Private Sub pnlAbout_Click";
 //BA.debugLineNum = 187;BA.debugLine="lb4Menu_Click";
_lb4menu_click();
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return "";
}
public static String  _pnldecode_click() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Private Sub pnlDecode_Click";
 //BA.debugLineNum = 182;BA.debugLine="StartActivity(decode)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._decode.getObject()));
 //BA.debugLineNum = 183;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static String  _pnlencode_click() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Private Sub pnlEncode_Click";
 //BA.debugLineNum = 177;BA.debugLine="StartActivity(encode)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._encode.getObject()));
 //BA.debugLineNum = 178;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static void  _pnlexit_click() throws Exception{
ResumableSub_pnlExit_Click rsub = new ResumableSub_pnlExit_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_pnlExit_Click extends BA.ResumableSub {
public ResumableSub_pnlExit_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.mainmenu parent;
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
 //BA.debugLineNum = 168;BA.debugLine="Msgbox2Async(\"Are you sure you want to exit?\",\"Ex";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to exit?"),BA.ObjectToCharSequence("Exit Application"),"Yes","No","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 169;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 170;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 171;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _pnlhistory_click() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Private Sub pnlHistory_Click";
 //BA.debugLineNum = 163;BA.debugLine="StartActivity(history)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._history.getObject()));
 //BA.debugLineNum = 164;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static String  _pnlsettings_click() throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Private Sub pnlSettings_Click";
 //BA.debugLineNum = 158;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
 //BA.debugLineNum = 159;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private Biometric As BiometricManager";
_biometric = new ng.dsoftlab.stegocam.biometricmanager();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
}
