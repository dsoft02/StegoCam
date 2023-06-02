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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.mainmenu");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=37945344;
 //BA.debugLineNum = 37945344;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=37945346;
 //BA.debugLineNum = 37945346;BA.debugLine="Try";
try {RDebugUtils.currentLine=37945347;
 //BA.debugLineNum = 37945347;BA.debugLine="Drawer.Initialize(Me, \"Drawer\", Activity, 300dip";
mostCurrent._drawer._initialize /*String*/ (null,mostCurrent.activityBA,mainmenu.getObject(),"Drawer",(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=37945348;
 //BA.debugLineNum = 37945348;BA.debugLine="Drawer.CenterPanel.LoadLayout(\"mainmenu\")";
mostCurrent._drawer._getcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (null).LoadLayout("mainmenu",mostCurrent.activityBA);
RDebugUtils.currentLine=37945349;
 //BA.debugLineNum = 37945349;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=37945350;
 //BA.debugLineNum = 37945350;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to tru";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=37945351;
 //BA.debugLineNum = 37945351;BA.debugLine="ToolbarHelper.UpIndicatorDrawable = config.Bitma";
mostCurrent._toolbarhelper.setUpIndicatorDrawable((android.graphics.drawable.Drawable)(mostCurrent._config._bitmaptobitmapdrawable /*anywheresoftware.b4a.objects.drawable.BitmapDrawable*/ (mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"hamburger.png")).getObject()));
RDebugUtils.currentLine=37945352;
 //BA.debugLineNum = 37945352;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=37945353;
 //BA.debugLineNum = 37945353;BA.debugLine="Drawer.LeftPanel.LoadLayout(\"leftmenu\")";
mostCurrent._drawer._getleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (null).LoadLayout("leftmenu",mostCurrent.activityBA);
RDebugUtils.currentLine=37945354;
 //BA.debugLineNum = 37945354;BA.debugLine="load_Images";
_load_images();
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=37945358;
 //BA.debugLineNum = 37945358;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("737945358",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=37945361;
 //BA.debugLineNum = 37945361;BA.debugLine="End Sub";
return "";
}
public static String  _load_images() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "load_images", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "load_images", null));}
RDebugUtils.currentLine=38338560;
 //BA.debugLineNum = 38338560;BA.debugLine="Sub load_Images";
RDebugUtils.currentLine=38338561;
 //BA.debugLineNum = 38338561;BA.debugLine="config.AjustImageView(ic1Menu,File.DirAssets,\"loc";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic1menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"lock_color.png");
RDebugUtils.currentLine=38338562;
 //BA.debugLineNum = 38338562;BA.debugLine="config.AjustImageView(ic2Menu,File.DirAssets,\"unl";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic2menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"unlock_color.png");
RDebugUtils.currentLine=38338563;
 //BA.debugLineNum = 38338563;BA.debugLine="config.AjustImageView(ic3Menu,File.DirAssets,\"his";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic3menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"history_color.png");
RDebugUtils.currentLine=38338564;
 //BA.debugLineNum = 38338564;BA.debugLine="config.AjustImageView(ic4Menu,File.DirAssets,\"abo";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic4menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"about_color.png");
RDebugUtils.currentLine=38338565;
 //BA.debugLineNum = 38338565;BA.debugLine="config.AjustImageView(ic5Menu,File.DirAssets,\"pin";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic5menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pin.png");
RDebugUtils.currentLine=38338566;
 //BA.debugLineNum = 38338566;BA.debugLine="config.AjustImageView(ic6Menu,File.DirAssets,\"sec";
mostCurrent._config._ajustimageview /*String*/ (mostCurrent.activityBA,mostCurrent._ic6menu,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"sec_quest.png");
RDebugUtils.currentLine=38338567;
 //BA.debugLineNum = 38338567;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=38207488;
 //BA.debugLineNum = 38207488;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=38207489;
 //BA.debugLineNum = 38207489;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And Drawer.Lef";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._drawer._getleftopen /*boolean*/ (null)) { 
RDebugUtils.currentLine=38207490;
 //BA.debugLineNum = 38207490;BA.debugLine="Drawer.LeftOpen = False";
mostCurrent._drawer._setleftopen /*boolean*/ (null,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=38207491;
 //BA.debugLineNum = 38207491;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=38207492;
 //BA.debugLineNum = 38207492;BA.debugLine="Else If KeyCode = KeyCodes.KEYCODE_BACK And Drawe";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._drawer._getleftopen /*boolean*/ (null)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=38207493;
 //BA.debugLineNum = 38207493;BA.debugLine="pnlExit_Click";
_pnlexit_click();
RDebugUtils.currentLine=38207494;
 //BA.debugLineNum = 38207494;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=38207496;
 //BA.debugLineNum = 38207496;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=38207497;
 //BA.debugLineNum = 38207497;BA.debugLine="End Sub";
return false;
}
public static void  _pnlexit_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlexit_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "pnlexit_click", null); return;}
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
RDebugUtils.currentModule="mainmenu";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=38731777;
 //BA.debugLineNum = 38731777;BA.debugLine="Msgbox2Async(\"Are you sure you want to exit?\",\"Ex";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to exit?"),BA.ObjectToCharSequence("Exit Application"),"Yes","No","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=38731778;
 //BA.debugLineNum = 38731778;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainmenu", "pnlexit_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=38731779;
 //BA.debugLineNum = 38731779;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=38731780;
 //BA.debugLineNum = 38731780;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=38731783;
 //BA.debugLineNum = 38731783;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="mainmenu";
RDebugUtils.currentLine=38076416;
 //BA.debugLineNum = 38076416;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=38076418;
 //BA.debugLineNum = 38076418;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=38010880;
 //BA.debugLineNum = 38010880;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=38010882;
 //BA.debugLineNum = 38010882;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_menuitemclick(de.amberhome.objects.appcompat.ACMenuItemWrapper _item) throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_menuitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_menuitemclick", new Object[] {_item}));}
RDebugUtils.currentLine=38273024;
 //BA.debugLineNum = 38273024;BA.debugLine="Private Sub ACToolBarLight1_MenuItemClick (Item As";
RDebugUtils.currentLine=38273026;
 //BA.debugLineNum = 38273026;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=38141952;
 //BA.debugLineNum = 38141952;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=38141953;
 //BA.debugLineNum = 38141953;BA.debugLine="Drawer.LeftOpen = Not(Drawer.LeftOpen)";
mostCurrent._drawer._setleftopen /*boolean*/ (null,anywheresoftware.b4a.keywords.Common.Not(mostCurrent._drawer._getleftopen /*boolean*/ (null)));
RDebugUtils.currentLine=38141954;
 //BA.debugLineNum = 38141954;BA.debugLine="End Sub";
return "";
}
public static void  _lb1menu_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lb1menu_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lb1menu_click", null); return;}
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
RDebugUtils.currentModule="mainmenu";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=38469633;
 //BA.debugLineNum = 38469633;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ (null)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (null,anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=38469634;
 //BA.debugLineNum = 38469634;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainmenu", "lb1menu_click"),(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
RDebugUtils.currentLine=38469635;
 //BA.debugLineNum = 38469635;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb2menu_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lb2menu_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lb2menu_click", null); return;}
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
RDebugUtils.currentModule="mainmenu";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=38404097;
 //BA.debugLineNum = 38404097;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ (null)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (null,anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=38404098;
 //BA.debugLineNum = 38404098;BA.debugLine="Sleep(150)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainmenu", "lb2menu_click"),(int) (150));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
RDebugUtils.currentLine=38404099;
 //BA.debugLineNum = 38404099;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _lb4menu_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lb4menu_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lb4menu_click", null); return;}
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
RDebugUtils.currentModule="mainmenu";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=38535169;
 //BA.debugLineNum = 38535169;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer._getleftopen /*boolean*/ (null)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer._setleftopen /*boolean*/ (null,anywheresoftware.b4a.keywords.Common.False);
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=38535170;
 //BA.debugLineNum = 38535170;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainmenu", "lb4menu_click"),(int) (10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
RDebugUtils.currentLine=38535171;
 //BA.debugLineNum = 38535171;BA.debugLine="MsgboxAsync(\"Application developed by Ebenezer Og";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Application developed by Ebenezer Ogidiolu in the scope of Alx Software Engineering Project."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"The stegocam application allows users to hide secret messages or files within images, providing a secure and confidential communication method."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Users can take new photos or select existing ones from their device. They have the option to hide a secret message or file within the image using various encryption methods, such as AES or DES."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"To extract hidden data, users can view their modified photos within the app and decrypt the hidden message or extract the hidden file."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"For any inquiries or support, please contact: ogidioluebenezer@gmail.com | +2349169442847"+anywheresoftware.b4a.keywords.Common.CRLF),BA.ObjectToCharSequence("About the stegocam application"),processBA);
RDebugUtils.currentLine=38535172;
 //BA.debugLineNum = 38535172;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _pnlabout_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlabout_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlabout_click", null));}
RDebugUtils.currentLine=38928384;
 //BA.debugLineNum = 38928384;BA.debugLine="Private Sub pnlAbout_Click";
RDebugUtils.currentLine=38928385;
 //BA.debugLineNum = 38928385;BA.debugLine="lb4Menu_Click";
_lb4menu_click();
RDebugUtils.currentLine=38928386;
 //BA.debugLineNum = 38928386;BA.debugLine="End Sub";
return "";
}
public static String  _pnldecode_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnldecode_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnldecode_click", null));}
RDebugUtils.currentLine=38862848;
 //BA.debugLineNum = 38862848;BA.debugLine="Private Sub pnlDecode_Click";
RDebugUtils.currentLine=38862850;
 //BA.debugLineNum = 38862850;BA.debugLine="End Sub";
return "";
}
public static String  _pnlencode_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlencode_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlencode_click", null));}
RDebugUtils.currentLine=38797312;
 //BA.debugLineNum = 38797312;BA.debugLine="Private Sub pnlEncode_Click";
RDebugUtils.currentLine=38797313;
 //BA.debugLineNum = 38797313;BA.debugLine="StartActivity(encode)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._encode.getObject()));
RDebugUtils.currentLine=38797314;
 //BA.debugLineNum = 38797314;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=38797315;
 //BA.debugLineNum = 38797315;BA.debugLine="End Sub";
return "";
}
public static String  _pnlhistory_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlhistory_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlhistory_click", null));}
RDebugUtils.currentLine=38666240;
 //BA.debugLineNum = 38666240;BA.debugLine="Private Sub pnlHistory_Click";
RDebugUtils.currentLine=38666241;
 //BA.debugLineNum = 38666241;BA.debugLine="StartActivity(history)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._history.getObject()));
RDebugUtils.currentLine=38666242;
 //BA.debugLineNum = 38666242;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=38666243;
 //BA.debugLineNum = 38666243;BA.debugLine="End Sub";
return "";
}
public static String  _pnlsettings_click() throws Exception{
RDebugUtils.currentModule="mainmenu";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlsettings_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlsettings_click", null));}
RDebugUtils.currentLine=38600704;
 //BA.debugLineNum = 38600704;BA.debugLine="Private Sub pnlSettings_Click";
RDebugUtils.currentLine=38600705;
 //BA.debugLineNum = 38600705;BA.debugLine="StartActivity(settings)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._settings.getObject()));
RDebugUtils.currentLine=38600706;
 //BA.debugLineNum = 38600706;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=38600707;
 //BA.debugLineNum = 38600707;BA.debugLine="End Sub";
return "";
}
}