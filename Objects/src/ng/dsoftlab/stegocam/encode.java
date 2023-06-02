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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.encode");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public anywheresoftware.b4a.objects.PanelWrapper _pnlfile = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlkey = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmessage = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rboxencodefile = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rboxencodetext = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtfilename = null;
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
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=39911424;
 //BA.debugLineNum = 39911424;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=39911426;
 //BA.debugLineNum = 39911426;BA.debugLine="Activity.LoadLayout(\"encode\")";
mostCurrent._activity.LoadLayout("encode",mostCurrent.activityBA);
RDebugUtils.currentLine=39911427;
 //BA.debugLineNum = 39911427;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39911428;
 //BA.debugLineNum = 39911428;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=39911429;
 //BA.debugLineNum = 39911429;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39911430;
 //BA.debugLineNum = 39911430;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
RDebugUtils.currentLine=39911431;
 //BA.debugLineNum = 39911431;BA.debugLine="clearForm";
_clearform();
RDebugUtils.currentLine=39911432;
 //BA.debugLineNum = 39911432;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
if (_lastpicture.IsInitialized()) { 
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(_lastpicture.getObject()));};
RDebugUtils.currentLine=39911433;
 //BA.debugLineNum = 39911433;BA.debugLine="FileHandler1.Initialize";
_filehandler1._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=39911434;
 //BA.debugLineNum = 39911434;BA.debugLine="stegoHandler.Initialize";
_stegohandler._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=39911435;
 //BA.debugLineNum = 39911435;BA.debugLine="Dialog.Initialize(Activity)";
mostCurrent._dialog._initialize /*String*/ (null,mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())));
RDebugUtils.currentLine=39911436;
 //BA.debugLineNum = 39911436;BA.debugLine="Dialog.Title = \"Stego Image View\"";
mostCurrent._dialog._title /*Object*/  = (Object)("Stego Image View");
RDebugUtils.currentLine=39911437;
 //BA.debugLineNum = 39911437;BA.debugLine="getPermissions";
_getpermissions();
RDebugUtils.currentLine=39911438;
 //BA.debugLineNum = 39911438;BA.debugLine="End Sub";
return "";
}
public static String  _clearform() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clearform", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clearform", null));}
anywheresoftware.b4a.objects.collections.List _encryptiontypes = null;
RDebugUtils.currentLine=40370176;
 //BA.debugLineNum = 40370176;BA.debugLine="Private Sub clearForm";
RDebugUtils.currentLine=40370177;
 //BA.debugLineNum = 40370177;BA.debugLine="Dim encryptionTypes As List";
_encryptiontypes = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=40370178;
 //BA.debugLineNum = 40370178;BA.debugLine="encryptionTypes.Initialize";
_encryptiontypes.Initialize();
RDebugUtils.currentLine=40370179;
 //BA.debugLineNum = 40370179;BA.debugLine="encryptionTypes.AddAll(Array As String(\"AES\", \"DE";
_encryptiontypes.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"AES","DES"}));
RDebugUtils.currentLine=40370180;
 //BA.debugLineNum = 40370180;BA.debugLine="cboEncryption.SetItems(encryptionTypes)";
mostCurrent._cboencryption._setitems /*String*/ (null,_encryptiontypes);
RDebugUtils.currentLine=40370181;
 //BA.debugLineNum = 40370181;BA.debugLine="cboEncryption.SelectedIndex=0";
mostCurrent._cboencryption._setselectedindex /*int*/ (null,(int) (0));
RDebugUtils.currentLine=40370182;
 //BA.debugLineNum = 40370182;BA.debugLine="lastPicture=Null";
_lastpicture = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=40370183;
 //BA.debugLineNum = 40370183;BA.debugLine="imgCover.Bitmap=Null";
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=40370184;
 //BA.debugLineNum = 40370184;BA.debugLine="txtFilename.Text=\"\"";
mostCurrent._txtfilename.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=40370185;
 //BA.debugLineNum = 40370185;BA.debugLine="txtMessage.Text=\"\"";
mostCurrent._txtmessage.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=40370186;
 //BA.debugLineNum = 40370186;BA.debugLine="imgCover.Tag=\"\"";
mostCurrent._imgcover.setTag((Object)(""));
RDebugUtils.currentLine=40370187;
 //BA.debugLineNum = 40370187;BA.debugLine="txtFilename.Tag=\"\"";
mostCurrent._txtfilename.setTag((Object)(""));
RDebugUtils.currentLine=40370188;
 //BA.debugLineNum = 40370188;BA.debugLine="txtKey.Text=\"\"";
mostCurrent._txtkey.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=40370189;
 //BA.debugLineNum = 40370189;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=40370190;
 //BA.debugLineNum = 40370190;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40370191;
 //BA.debugLineNum = 40370191;BA.debugLine="End Sub";
return "";
}
public static void  _getpermissions() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getpermissions", false))
	 {Debug.delegate(mostCurrent.activityBA, "getpermissions", null); return;}
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
RDebugUtils.currentModule="encode";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=40697857;
 //BA.debugLineNum = 40697857;BA.debugLine="For Each permission As String In Array(Starter.rp";
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
RDebugUtils.currentLine=40697858;
 //BA.debugLineNum = 40697858;BA.debugLine="Starter.rp.CheckAndRequest(permission)";
parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,_permission);
RDebugUtils.currentLine=40697859;
 //BA.debugLineNum = 40697859;BA.debugLine="Wait For Activity_PermissionResult (permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "encode", "getpermissions"), null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=40697860;
 //BA.debugLineNum = 40697860;BA.debugLine="If Result = False Then";
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
RDebugUtils.currentLine=40697861;
 //BA.debugLineNum = 40697861;BA.debugLine="MsgboxAsync(\"Please grant the neccessary permis";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please grant the neccessary permission to continue"),BA.ObjectToCharSequence("No Permission granted"),processBA);
RDebugUtils.currentLine=40697863;
 //BA.debugLineNum = 40697863;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
RDebugUtils.currentLine=40697864;
 //BA.debugLineNum = 40697864;BA.debugLine="Return";
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
RDebugUtils.currentLine=40697868;
 //BA.debugLineNum = 40697868;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=40173568;
 //BA.debugLineNum = 40173568;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=40173569;
 //BA.debugLineNum = 40173569;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
RDebugUtils.currentLine=40173570;
 //BA.debugLineNum = 40173570;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
RDebugUtils.currentLine=40173571;
 //BA.debugLineNum = 40173571;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=40173572;
 //BA.debugLineNum = 40173572;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=40173574;
 //BA.debugLineNum = 40173574;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=40173575;
 //BA.debugLineNum = 40173575;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="encode";
RDebugUtils.currentLine=40042496;
 //BA.debugLineNum = 40042496;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=40042498;
 //BA.debugLineNum = 40042498;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=39976960;
 //BA.debugLineNum = 39976960;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=39976962;
 //BA.debugLineNum = 39976962;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actoolbarlight1_navigationitemclick", null));}
RDebugUtils.currentLine=40108032;
 //BA.debugLineNum = 40108032;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
RDebugUtils.currentLine=40108033;
 //BA.debugLineNum = 40108033;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
RDebugUtils.currentLine=40108034;
 //BA.debugLineNum = 40108034;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=40108035;
 //BA.debugLineNum = 40108035;BA.debugLine="End Sub";
return "";
}
public static void  _browsecoverimage() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "browsecoverimage", false))
	 {Debug.delegate(mostCurrent.activityBA, "browsecoverimage", null); return;}
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
RDebugUtils.currentModule="encode";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=40763393;
 //BA.debugLineNum = 40763393;BA.debugLine="Dim xui As XUI";
parent.mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=40763394;
 //BA.debugLineNum = 40763394;BA.debugLine="Wait For (FileHandler1.LoadCoverImage) Complete (";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "encode", "browsecoverimage"), parent._filehandler1._loadcoverimage /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (ng.dsoftlab.stegocam.filehandler._loadresult) result[0];
;
RDebugUtils.currentLine=40763395;
 //BA.debugLineNum = 40763395;BA.debugLine="If Result.Success Then";
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
RDebugUtils.currentLine=40763396;
 //BA.debugLineNum = 40763396;BA.debugLine="Try";
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
RDebugUtils.currentLine=40763398;
 //BA.debugLineNum = 40763398;BA.debugLine="imgCover.Bitmap =xui.LoadBitmapResize(Result.Di";
parent.mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._xui.LoadBitmapResize(_result.Dir /*String*/ ,_result.FileName /*String*/ ,parent.mostCurrent._imgcover.getWidth(),parent.mostCurrent._imgcover.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=40763399;
 //BA.debugLineNum = 40763399;BA.debugLine="imgCover.Tag= GetPathFromContentResult(Result.F";
parent.mostCurrent._imgcover.setTag((Object)(_getpathfromcontentresult(_result.FileName /*String*/ )));
RDebugUtils.currentLine=40763400;
 //BA.debugLineNum = 40763400;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
RDebugUtils.currentLine=40763402;
 //BA.debugLineNum = 40763402;BA.debugLine="imgCover.Bitmap=Null";
parent.mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=40763403;
 //BA.debugLineNum = 40763403;BA.debugLine="imgCover.Tag=\"\"";
parent.mostCurrent._imgcover.setTag((Object)(""));
RDebugUtils.currentLine=40763404;
 //BA.debugLineNum = 40763404;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("740763404",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=40763405;
 //BA.debugLineNum = 40763405;BA.debugLine="lblErrorMsg.Text=LastException.Message";
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
RDebugUtils.currentLine=40763408;
 //BA.debugLineNum = 40763408;BA.debugLine="End Sub";
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
public static String  _getpathfromcontentresult(String _uristring) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getpathfromcontentresult", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getpathfromcontentresult", new Object[] {_uristring}));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri1 = null;
String[] _proj = null;
anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
int _i = 0;
String _id = "";
String _res = "";
RDebugUtils.currentLine=66060288;
 //BA.debugLineNum = 66060288;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
RDebugUtils.currentLine=66060289;
 //BA.debugLineNum = 66060289;BA.debugLine="If UriString.StartsWith(\"/\") Then Return UriStrin";
if (_uristring.startsWith("/")) { 
if (true) return _uristring;};
RDebugUtils.currentLine=66060290;
 //BA.debugLineNum = 66060290;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=66060291;
 //BA.debugLineNum = 66060291;BA.debugLine="Dim Uri1 As Uri";
_uri1 = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=66060292;
 //BA.debugLineNum = 66060292;BA.debugLine="Dim Proj() As String = Array As String(\"_data\")";
_proj = new String[]{"_data"};
RDebugUtils.currentLine=66060293;
 //BA.debugLineNum = 66060293;BA.debugLine="Dim cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
RDebugUtils.currentLine=66060294;
 //BA.debugLineNum = 66060294;BA.debugLine="cr.Initialize(\"\")";
_cr.Initialize("");
RDebugUtils.currentLine=66060295;
 //BA.debugLineNum = 66060295;BA.debugLine="If UriString.StartsWith(\"content://com.android.pr";
if (_uristring.startsWith("content://com.android.providers.media.documents")) { 
RDebugUtils.currentLine=66060296;
 //BA.debugLineNum = 66060296;BA.debugLine="Dim i As Int = UriString.IndexOf(\"%3A\")";
_i = _uristring.indexOf("%3A");
RDebugUtils.currentLine=66060297;
 //BA.debugLineNum = 66060297;BA.debugLine="Dim id As String = UriString.SubString(i + 3)";
_id = _uristring.substring((int) (_i+3));
RDebugUtils.currentLine=66060298;
 //BA.debugLineNum = 66060298;BA.debugLine="Uri1.Parse(\"content://media/external/images/medi";
_uri1.Parse("content://media/external/images/media");
RDebugUtils.currentLine=66060299;
 //BA.debugLineNum = 66060299;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"_id = ?\", Array";
_cursor1 = _cr.Query(_uri1,_proj,"_id = ?",new String[]{_id},"");
 }else {
RDebugUtils.currentLine=66060301;
 //BA.debugLineNum = 66060301;BA.debugLine="Uri1.Parse(UriString)";
_uri1.Parse(_uristring);
RDebugUtils.currentLine=66060302;
 //BA.debugLineNum = 66060302;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"\", Null, \"\")";
_cursor1 = _cr.Query(_uri1,_proj,"",(String[])(anywheresoftware.b4a.keywords.Common.Null),"");
 };
RDebugUtils.currentLine=66060304;
 //BA.debugLineNum = 66060304;BA.debugLine="Cursor1.Position = 0";
_cursor1.setPosition((int) (0));
RDebugUtils.currentLine=66060305;
 //BA.debugLineNum = 66060305;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=66060306;
 //BA.debugLineNum = 66060306;BA.debugLine="res = Cursor1.GetString(\"_data\")";
_res = _cursor1.GetString("_data");
RDebugUtils.currentLine=66060307;
 //BA.debugLineNum = 66060307;BA.debugLine="Cursor1.Close";
_cursor1.Close();
RDebugUtils.currentLine=66060308;
 //BA.debugLineNum = 66060308;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=66060309;
 //BA.debugLineNum = 66060309;BA.debugLine="End Sub";
return "";
}
public static void  _browsefile() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "browsefile", false))
	 {Debug.delegate(mostCurrent.activityBA, "browsefile", null); return;}
ResumableSub_BrowseFile rsub = new ResumableSub_BrowseFile(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_BrowseFile extends BA.ResumableSub {
public ResumableSub_BrowseFile(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.encode parent;
ng.dsoftlab.stegocam.filehandler._loadresult _result = null;
String _fpath = "";
String _fname = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="encode";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=40828929;
 //BA.debugLineNum = 40828929;BA.debugLine="Wait For (FileHandler1.Load) Complete (Result As";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "encode", "browsefile"), parent._filehandler1._load /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (ng.dsoftlab.stegocam.filehandler._loadresult) result[0];
;
RDebugUtils.currentLine=40828930;
 //BA.debugLineNum = 40828930;BA.debugLine="If Result.Success Then";
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
RDebugUtils.currentLine=40828931;
 //BA.debugLineNum = 40828931;BA.debugLine="Dim fpath As String=\"\"";
_fpath = "";
RDebugUtils.currentLine=40828932;
 //BA.debugLineNum = 40828932;BA.debugLine="Dim fname As String=\"\"";
_fname = "";
RDebugUtils.currentLine=40828933;
 //BA.debugLineNum = 40828933;BA.debugLine="Try";
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
RDebugUtils.currentLine=40828934;
 //BA.debugLineNum = 40828934;BA.debugLine="fpath=Result.FileName 'Result.Dir & \"/\" &  GetP";
_fpath = _result.FileName /*String*/ ;
RDebugUtils.currentLine=40828936;
 //BA.debugLineNum = 40828936;BA.debugLine="fname=Result.RealName";
_fname = _result.RealName /*String*/ ;
RDebugUtils.currentLine=40828937;
 //BA.debugLineNum = 40828937;BA.debugLine="lblErrorMsg.Text=\"\"";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
RDebugUtils.currentLine=40828939;
 //BA.debugLineNum = 40828939;BA.debugLine="fpath=\"\"";
_fpath = "";
RDebugUtils.currentLine=40828940;
 //BA.debugLineNum = 40828940;BA.debugLine="fname=\"\"";
_fname = "";
RDebugUtils.currentLine=40828941;
 //BA.debugLineNum = 40828941;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("740828941",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=40828942;
 //BA.debugLineNum = 40828942;BA.debugLine="lblErrorMsg.Text=LastException.Message";
parent.mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()));
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
RDebugUtils.currentLine=40828944;
 //BA.debugLineNum = 40828944;BA.debugLine="txtFilename.Text=fname";
parent.mostCurrent._txtfilename.setText(BA.ObjectToCharSequence(_fname));
RDebugUtils.currentLine=40828945;
 //BA.debugLineNum = 40828945;BA.debugLine="txtFilename.Tag=fpath";
parent.mostCurrent._txtfilename.setTag((Object)(_fpath));
RDebugUtils.currentLine=40828946;
 //BA.debugLineNum = 40828946;BA.debugLine="imgCover.Tag=fpath";
parent.mostCurrent._imgcover.setTag((Object)(_fpath));
RDebugUtils.currentLine=40828947;
 //BA.debugLineNum = 40828947;BA.debugLine="Log(fpath)";
anywheresoftware.b4a.keywords.Common.LogImpl("740828947",_fpath,0);
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=40828949;
 //BA.debugLineNum = 40828949;BA.debugLine="End Sub";
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
public static String  _btnbrowse_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnbrowse_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnbrowse_click", null));}
RDebugUtils.currentLine=41156608;
 //BA.debugLineNum = 41156608;BA.debugLine="Private Sub btnBrowse_Click";
RDebugUtils.currentLine=41156609;
 //BA.debugLineNum = 41156609;BA.debugLine="BrowseFile";
_browsefile();
RDebugUtils.currentLine=41156610;
 //BA.debugLineNum = 41156610;BA.debugLine="End Sub";
return "";
}
public static String  _btncancel_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncancel_click", null));}
RDebugUtils.currentLine=40239104;
 //BA.debugLineNum = 40239104;BA.debugLine="Private Sub btnCancel_Click";
RDebugUtils.currentLine=40239105;
 //BA.debugLineNum = 40239105;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
RDebugUtils.currentLine=40239106;
 //BA.debugLineNum = 40239106;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=40239107;
 //BA.debugLineNum = 40239107;BA.debugLine="End Sub";
return "";
}
public static String  _btnencode_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnencode_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnencode_click", null));}
RDebugUtils.currentLine=40304640;
 //BA.debugLineNum = 40304640;BA.debugLine="Private Sub btnEncode_Click";
RDebugUtils.currentLine=40304641;
 //BA.debugLineNum = 40304641;BA.debugLine="If imgCover.Bitmap=Null Then";
if (mostCurrent._imgcover.getBitmap()== null) { 
RDebugUtils.currentLine=40304642;
 //BA.debugLineNum = 40304642;BA.debugLine="lblErrorMsg.Text=\"Please select cover Image\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please select cover Image"));
RDebugUtils.currentLine=40304643;
 //BA.debugLineNum = 40304643;BA.debugLine="ToastMessageShow(\"Please select cover Image\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please select cover Image"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=40304644;
 //BA.debugLineNum = 40304644;BA.debugLine="Else If rboxEncodeText.Checked And txtMessage.Tex";
if (mostCurrent._rboxencodetext.getChecked() && (mostCurrent._txtmessage.getText()).equals("")) { 
RDebugUtils.currentLine=40304645;
 //BA.debugLineNum = 40304645;BA.debugLine="lblErrorMsg.Text=\"Please enter your secret messa";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter your secret message"));
RDebugUtils.currentLine=40304646;
 //BA.debugLineNum = 40304646;BA.debugLine="ToastMessageShow(\"Please enter your secret messa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your secret message"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40304647;
 //BA.debugLineNum = 40304647;BA.debugLine="txtMessage.RequestFocus";
mostCurrent._txtmessage.RequestFocus();
 }else 
{RDebugUtils.currentLine=40304648;
 //BA.debugLineNum = 40304648;BA.debugLine="Else If rboxEncodeFile.Checked And txtFilename.Te";
if (mostCurrent._rboxencodefile.getChecked() && (mostCurrent._txtfilename.getText()).equals("")) { 
RDebugUtils.currentLine=40304649;
 //BA.debugLineNum = 40304649;BA.debugLine="lblErrorMsg.Text=\"Please select your secret file";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please select your secret file"));
RDebugUtils.currentLine=40304650;
 //BA.debugLineNum = 40304650;BA.debugLine="ToastMessageShow(\"Please select your secret file";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please select your secret file"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40304651;
 //BA.debugLineNum = 40304651;BA.debugLine="BrowseFile";
_browsefile();
 }else 
{RDebugUtils.currentLine=40304652;
 //BA.debugLineNum = 40304652;BA.debugLine="else if txtKey.Text=\"\" Then";
if ((mostCurrent._txtkey.getText()).equals("")) { 
RDebugUtils.currentLine=40304653;
 //BA.debugLineNum = 40304653;BA.debugLine="lblErrorMsg.Text=\"Please enter your encryption k";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence("Please enter your encryption key"));
RDebugUtils.currentLine=40304654;
 //BA.debugLineNum = 40304654;BA.debugLine="ToastMessageShow(\"Please enter your encryption k";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter your encryption key"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40304655;
 //BA.debugLineNum = 40304655;BA.debugLine="txtKey.RequestFocus";
mostCurrent._txtkey.RequestFocus();
 }else {
RDebugUtils.currentLine=40304658;
 //BA.debugLineNum = 40304658;BA.debugLine="lblErrorMsg.Text=\"\"";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=40304659;
 //BA.debugLineNum = 40304659;BA.debugLine="stegoHandler.createTempCoverImage(imgCover)";
_stegohandler._createtempcoverimage /*String*/ (null,mostCurrent._imgcover);
RDebugUtils.currentLine=40304660;
 //BA.debugLineNum = 40304660;BA.debugLine="If stegoHandler.isCoverImage Then";
if (_stegohandler._iscoverimage /*boolean*/ (null)) { 
RDebugUtils.currentLine=40304661;
 //BA.debugLineNum = 40304661;BA.debugLine="If rboxEncodeText.Checked Then";
if (mostCurrent._rboxencodetext.getChecked()) { 
RDebugUtils.currentLine=40304662;
 //BA.debugLineNum = 40304662;BA.debugLine="stegoHandler.EmbedText(txtMessage.Text,txtKey.";
_stegohandler._embedtext /*String*/ (null,mostCurrent._txtmessage.getText(),mostCurrent._txtkey.getText());
RDebugUtils.currentLine=40304663;
 //BA.debugLineNum = 40304663;BA.debugLine="If stegoHandler.embeddingSuccessful=True Then";
if (_stegohandler._embeddingsuccessful /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=40304664;
 //BA.debugLineNum = 40304664;BA.debugLine="ToastMessageShow(\"Secret has been hidden succ";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Secret has been hidden successfully!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40304665;
 //BA.debugLineNum = 40304665;BA.debugLine="showCompleteDialog(File.Combine(config.stegoI";
_showcompletedialog(anywheresoftware.b4a.keywords.Common.File.Combine(mostCurrent._config._stegoimagepath /*String*/ ,_stegohandler._curfilename /*String*/ ));
 }else {
RDebugUtils.currentLine=40304667;
 //BA.debugLineNum = 40304667;BA.debugLine="lblErrorMsg.Text=stegoHandler.lastErrorMessag";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(_stegohandler._lasterrormessage /*String*/ ));
 };
 }else 
{RDebugUtils.currentLine=40304669;
 //BA.debugLineNum = 40304669;BA.debugLine="Else if rboxEncodeFile.Checked Then";
if (mostCurrent._rboxencodefile.getChecked()) { 
RDebugUtils.currentLine=40304670;
 //BA.debugLineNum = 40304670;BA.debugLine="stegoHandler.EmbedFile(txtFilename.Tag,txtKey.";
_stegohandler._embedfile /*String*/ (null,BA.ObjectToString(mostCurrent._txtfilename.getTag()),mostCurrent._txtkey.getText());
RDebugUtils.currentLine=40304671;
 //BA.debugLineNum = 40304671;BA.debugLine="If stegoHandler.embeddingSuccessful=True Then";
if (_stegohandler._embeddingsuccessful /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=40304672;
 //BA.debugLineNum = 40304672;BA.debugLine="ToastMessageShow(\"Secret File has been hidden";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Secret File has been hidden successfully!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40304673;
 //BA.debugLineNum = 40304673;BA.debugLine="showCompleteDialog(File.Combine(config.stegoI";
_showcompletedialog(anywheresoftware.b4a.keywords.Common.File.Combine(mostCurrent._config._stegoimagepath /*String*/ ,_stegohandler._curfilename /*String*/ ));
 }else {
RDebugUtils.currentLine=40304675;
 //BA.debugLineNum = 40304675;BA.debugLine="lblErrorMsg.Text=stegoHandler.lastErrorMessag";
mostCurrent._lblerrormsg.setText(BA.ObjectToCharSequence(_stegohandler._lasterrormessage /*String*/ ));
 };
 }}
;
 }else {
RDebugUtils.currentLine=40304679;
 //BA.debugLineNum = 40304679;BA.debugLine="ToastMessageShow(\"An error has occured please T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("An error has occured please Try Again!"),anywheresoftware.b4a.keywords.Common.True);
 };
 }}}}
;
RDebugUtils.currentLine=40304682;
 //BA.debugLineNum = 40304682;BA.debugLine="stegoHandler.deleteTempResources(\"stegocover\")";
_stegohandler._deletetempresources /*String*/ (null,"stegocover");
RDebugUtils.currentLine=40304683;
 //BA.debugLineNum = 40304683;BA.debugLine="End Sub";
return "";
}
public static void  _showcompletedialog(String _img) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showcompletedialog", false))
	 {Debug.delegate(mostCurrent.activityBA, "showcompletedialog", new Object[] {_img}); return;}
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
RDebugUtils.currentModule="encode";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=63307777;
 //BA.debugLineNum = 63307777;BA.debugLine="Try";
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
RDebugUtils.currentLine=63307778;
 //BA.debugLineNum = 63307778;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = parent.mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=63307781;
 //BA.debugLineNum = 63307781;BA.debugLine="pnl.SetLayoutAnimated(0, 0, 0, 90%x, 80%y)";
_pnl.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
RDebugUtils.currentLine=63307782;
 //BA.debugLineNum = 63307782;BA.debugLine="pnl.LoadLayout(\"embedDialog\")";
_pnl.LoadLayout("embedDialog",mostCurrent.activityBA);
RDebugUtils.currentLine=63307786;
 //BA.debugLineNum = 63307786;BA.debugLine="imgPreview.Width=pnlPreview.Width-20";
parent.mostCurrent._imgpreview.setWidth((int) (parent.mostCurrent._pnlpreview.getWidth()-20));
RDebugUtils.currentLine=63307787;
 //BA.debugLineNum = 63307787;BA.debugLine="imgPreview.Height=imgPreview.Width";
parent.mostCurrent._imgpreview.setHeight(parent.mostCurrent._imgpreview.getWidth());
RDebugUtils.currentLine=63307788;
 //BA.debugLineNum = 63307788;BA.debugLine="imgPreview.Left=pnlPreview.Width/2 - imgPreview.";
parent.mostCurrent._imgpreview.setLeft((int) (parent.mostCurrent._pnlpreview.getWidth()/(double)2-parent.mostCurrent._imgpreview.getWidth()/(double)2));
RDebugUtils.currentLine=63307789;
 //BA.debugLineNum = 63307789;BA.debugLine="imgPreview.Bitmap = xui.LoadBitmapResize(\"\", img";
parent.mostCurrent._imgpreview.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._xui.LoadBitmapResize("",_img,parent.mostCurrent._imgpreview.getWidth(),parent.mostCurrent._imgpreview.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=63307791;
 //BA.debugLineNum = 63307791;BA.debugLine="pnlExtract.Top=imgPreview.Top+imgPreview.Height+";
parent.mostCurrent._pnlextract.setTop((int) (parent.mostCurrent._imgpreview.getTop()+parent.mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=63307792;
 //BA.debugLineNum = 63307792;BA.debugLine="pnlDelete.Top=imgPreview.Top+imgPreview.Height+1";
parent.mostCurrent._pnldelete.setTop((int) (parent.mostCurrent._imgpreview.getTop()+parent.mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=63307793;
 //BA.debugLineNum = 63307793;BA.debugLine="pnlShare.Top=imgPreview.Top+imgPreview.Height+10";
parent.mostCurrent._pnlshare.setTop((int) (parent.mostCurrent._imgpreview.getTop()+parent.mostCurrent._imgpreview.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=63307795;
 //BA.debugLineNum = 63307795;BA.debugLine="Dim panelWidth, panelSpacing As Int";
_panelwidth = 0;
_panelspacing = 0;
RDebugUtils.currentLine=63307796;
 //BA.debugLineNum = 63307796;BA.debugLine="panelSpacing = 5dip";
_panelspacing = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5));
RDebugUtils.currentLine=63307797;
 //BA.debugLineNum = 63307797;BA.debugLine="panelWidth = (pnlPreview.Width / 3)";
_panelwidth = (int) ((parent.mostCurrent._pnlpreview.getWidth()/(double)3));
RDebugUtils.currentLine=63307799;
 //BA.debugLineNum = 63307799;BA.debugLine="pnlExtract.Width  = panelWidth";
parent.mostCurrent._pnlextract.setWidth(_panelwidth);
RDebugUtils.currentLine=63307800;
 //BA.debugLineNum = 63307800;BA.debugLine="pnlDelete.Width   = panelWidth";
parent.mostCurrent._pnldelete.setWidth(_panelwidth);
RDebugUtils.currentLine=63307801;
 //BA.debugLineNum = 63307801;BA.debugLine="pnlShare.Width    = panelWidth";
parent.mostCurrent._pnlshare.setWidth(_panelwidth);
RDebugUtils.currentLine=63307803;
 //BA.debugLineNum = 63307803;BA.debugLine="pnlExtract.Left=0";
parent.mostCurrent._pnlextract.setLeft((int) (0));
RDebugUtils.currentLine=63307804;
 //BA.debugLineNum = 63307804;BA.debugLine="pnlDelete.Left=panelWidth";
parent.mostCurrent._pnldelete.setLeft(_panelwidth);
RDebugUtils.currentLine=63307805;
 //BA.debugLineNum = 63307805;BA.debugLine="pnlShare.Left=(panelWidth * 2)";
parent.mostCurrent._pnlshare.setLeft((int) ((_panelwidth*2)));
RDebugUtils.currentLine=63307810;
 //BA.debugLineNum = 63307810;BA.debugLine="imgExtract.Left=pnlExtract.Width/2-imgExtract.Wi";
parent.mostCurrent._imgextract.setLeft((int) (parent.mostCurrent._pnlextract.getWidth()/(double)2-parent.mostCurrent._imgextract.getWidth()/(double)2));
RDebugUtils.currentLine=63307811;
 //BA.debugLineNum = 63307811;BA.debugLine="imgDelete.Left=pnlDelete.Width/2-imgDelete.Width";
parent.mostCurrent._imgdelete.setLeft((int) (parent.mostCurrent._pnldelete.getWidth()/(double)2-parent.mostCurrent._imgdelete.getWidth()/(double)2));
RDebugUtils.currentLine=63307812;
 //BA.debugLineNum = 63307812;BA.debugLine="imgShare.Left=pnlShare.Width/2-imgShare.Width/2";
parent.mostCurrent._imgshare.setLeft((int) (parent.mostCurrent._pnlshare.getWidth()/(double)2-parent.mostCurrent._imgshare.getWidth()/(double)2));
RDebugUtils.currentLine=63307814;
 //BA.debugLineNum = 63307814;BA.debugLine="Label1.Left=0";
parent.mostCurrent._label1.setLeft((int) (0));
RDebugUtils.currentLine=63307815;
 //BA.debugLineNum = 63307815;BA.debugLine="Label1.Width=pnlExtract.Width";
parent.mostCurrent._label1.setWidth(parent.mostCurrent._pnlextract.getWidth());
RDebugUtils.currentLine=63307817;
 //BA.debugLineNum = 63307817;BA.debugLine="Label4.Left=0";
parent.mostCurrent._label4.setLeft((int) (0));
RDebugUtils.currentLine=63307818;
 //BA.debugLineNum = 63307818;BA.debugLine="Label4.Width=pnlDelete.Width";
parent.mostCurrent._label4.setWidth(parent.mostCurrent._pnldelete.getWidth());
RDebugUtils.currentLine=63307820;
 //BA.debugLineNum = 63307820;BA.debugLine="Label2.Left=0";
parent.mostCurrent._label2.setLeft((int) (0));
RDebugUtils.currentLine=63307821;
 //BA.debugLineNum = 63307821;BA.debugLine="Label2.Width=pnlShare.Width";
parent.mostCurrent._label2.setWidth(parent.mostCurrent._pnlshare.getWidth());
RDebugUtils.currentLine=63307824;
 //BA.debugLineNum = 63307824;BA.debugLine="lblImgLocation.Text=img";
parent.mostCurrent._lblimglocation.setText(BA.ObjectToCharSequence(_img));
RDebugUtils.currentLine=63307826;
 //BA.debugLineNum = 63307826;BA.debugLine="Dim rs As ResumableSub = Dialog.ShowCustom(pnl,";
_rs = new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper();
_rs = parent.mostCurrent._dialog._showcustom /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,_pnl,(Object)("Ok"),(Object)(""),(Object)("Cancel"));
RDebugUtils.currentLine=63307827;
 //BA.debugLineNum = 63307827;BA.debugLine="Wait For (rs) Complete (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "encode", "showcompletedialog"), _rs);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=63307828;
 //BA.debugLineNum = 63307828;BA.debugLine="If Result = xui.DialogResponse_Positive Or Resul";
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
RDebugUtils.currentLine=63307830;
 //BA.debugLineNum = 63307830;BA.debugLine="clearForm";
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
RDebugUtils.currentLine=63307833;
 //BA.debugLineNum = 63307833;BA.debugLine="ToastMessageShow(LastException.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=63307834;
 //BA.debugLineNum = 63307834;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("763307834",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=63307836;
 //BA.debugLineNum = 63307836;BA.debugLine="End Sub";
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
public static Object  _getba() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getba", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "getba", null));}
anywheresoftware.b4j.object.JavaObject _jo = null;
String _cls = "";
RDebugUtils.currentLine=41091072;
 //BA.debugLineNum = 41091072;BA.debugLine="Sub GetBA As Object";
RDebugUtils.currentLine=41091073;
 //BA.debugLineNum = 41091073;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=41091074;
 //BA.debugLineNum = 41091074;BA.debugLine="Dim cls As String = Me";
_cls = BA.ObjectToString(encode.getObject());
RDebugUtils.currentLine=41091075;
 //BA.debugLineNum = 41091075;BA.debugLine="cls = cls.SubString(\"class \".Length)";
_cls = _cls.substring("class ".length());
RDebugUtils.currentLine=41091076;
 //BA.debugLineNum = 41091076;BA.debugLine="jo.InitializeStatic(cls)";
_jo.InitializeStatic(_cls);
RDebugUtils.currentLine=41091077;
 //BA.debugLineNum = 41091077;BA.debugLine="Return jo.GetField(\"processBA\")";
if (true) return _jo.GetField("processBA");
RDebugUtils.currentLine=41091078;
 //BA.debugLineNum = 41091078;BA.debugLine="End Sub";
return null;
}
public static void  _imgcover_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgcover_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "imgcover_click", null); return;}
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
RDebugUtils.currentModule="encode";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=40632321;
 //BA.debugLineNum = 40632321;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=40632322;
 //BA.debugLineNum = 40632322;BA.debugLine="bmp.Initialize(File.DirAssets, \"question.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"question.png");
RDebugUtils.currentLine=40632323;
 //BA.debugLineNum = 40632323;BA.debugLine="Msgbox2Async(\"Click on Yes to take picture from c";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Click on Yes to take picture from camera, or No to browse from a file?"),BA.ObjectToCharSequence("Browse Cover Image"),"Yes","Cancel","No",_bmp,processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40632324;
 //BA.debugLineNum = 40632324;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "encode", "imgcover_click"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=40632325;
 //BA.debugLineNum = 40632325;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}else 
{RDebugUtils.currentLine=40632327;
 //BA.debugLineNum = 40632327;BA.debugLine="Else if Result = DialogResponse.NEGATIVE Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 5;
}}
if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=40632326;
 //BA.debugLineNum = 40632326;BA.debugLine="TakePicture";
_takepicture();
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=40632328;
 //BA.debugLineNum = 40632328;BA.debugLine="BrowseCoverImage";
_browsecoverimage();
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=40632330;
 //BA.debugLineNum = 40632330;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _takepicture() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "takepicture", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "takepicture", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
Object _u = null;
RDebugUtils.currentLine=40894464;
 //BA.debugLineNum = 40894464;BA.debugLine="Sub TakePicture";
RDebugUtils.currentLine=40894465;
 //BA.debugLineNum = 40894465;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=40894466;
 //BA.debugLineNum = 40894466;BA.debugLine="i.Initialize(\"android.media.action.IMAGE_CAPTURE\"";
_i.Initialize("android.media.action.IMAGE_CAPTURE","");
RDebugUtils.currentLine=40894467;
 //BA.debugLineNum = 40894467;BA.debugLine="File.Delete(Starter.provider.SharedFolder, tempIm";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile);
RDebugUtils.currentLine=40894468;
 //BA.debugLineNum = 40894468;BA.debugLine="Dim u As Object = Starter.provider.GetFileUri(tem";
_u = mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._getfileuri /*Object*/ (null,_tempimagefile);
RDebugUtils.currentLine=40894469;
 //BA.debugLineNum = 40894469;BA.debugLine="i.PutExtra(\"output\", u) 'the image will be saved";
_i.PutExtra("output",_u);
RDebugUtils.currentLine=40894470;
 //BA.debugLineNum = 40894470;BA.debugLine="Try";
try {RDebugUtils.currentLine=40894471;
 //BA.debugLineNum = 40894471;BA.debugLine="StartActivityForResult(i)";
_startactivityforresult(_i);
 } 
       catch (Exception e9) {
			processBA.setLastException(e9);RDebugUtils.currentLine=40894473;
 //BA.debugLineNum = 40894473;BA.debugLine="ToastMessageShow(\"Camera is not available.\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Camera is not available."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40894474;
 //BA.debugLineNum = 40894474;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("740894474",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=40894476;
 //BA.debugLineNum = 40894476;BA.debugLine="End Sub";
return "";
}
public static void  _imgdelete_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgdelete_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "imgdelete_click", null); return;}
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
RDebugUtils.currentModule="encode";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=65011713;
 //BA.debugLineNum = 65011713;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete fil";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete file?"),BA.ObjectToCharSequence("Delete Image"),"Yes","No","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=65011714;
 //BA.debugLineNum = 65011714;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "encode", "imgdelete_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=65011715;
 //BA.debugLineNum = 65011715;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=65011716;
 //BA.debugLineNum = 65011716;BA.debugLine="File.Delete(lblImgLocation.Text,\"\")";
anywheresoftware.b4a.keywords.Common.File.Delete(parent.mostCurrent._lblimglocation.getText(),"");
RDebugUtils.currentLine=65011717;
 //BA.debugLineNum = 65011717;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
parent.mostCurrent._dialog._close /*boolean*/ (null,parent.mostCurrent._xui.DialogResponse_Cancel);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=65011719;
 //BA.debugLineNum = 65011719;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _imgextract_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgextract_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgextract_click", null));}
RDebugUtils.currentLine=64946176;
 //BA.debugLineNum = 64946176;BA.debugLine="Private Sub imgExtract_Click";
RDebugUtils.currentLine=64946178;
 //BA.debugLineNum = 64946178;BA.debugLine="End Sub";
return "";
}
public static String  _imgshare_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgshare_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgshare_click", null));}
String _filename = "";
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
anywheresoftware.b4a.objects.IntentWrapper _inten = null;
String _tmpt = "";
RDebugUtils.currentLine=64880640;
 //BA.debugLineNum = 64880640;BA.debugLine="Private Sub imgShare_Click";
RDebugUtils.currentLine=64880641;
 //BA.debugLineNum = 64880641;BA.debugLine="Try";
try {RDebugUtils.currentLine=64880642;
 //BA.debugLineNum = 64880642;BA.debugLine="Dim filename As String=lblImgLocation.Text.SubSt";
_filename = mostCurrent._lblimglocation.getText().substring((int) (mostCurrent._lblimglocation.getText().lastIndexOf("/")+1));
RDebugUtils.currentLine=64880643;
 //BA.debugLineNum = 64880643;BA.debugLine="File.Copy(lblImgLocation.Text,\"\", Starter.Provid";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._lblimglocation.getText(),"",mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_filename);
RDebugUtils.currentLine=64880644;
 //BA.debugLineNum = 64880644;BA.debugLine="Dim u As Uri 'ContentResolver library";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=64880645;
 //BA.debugLineNum = 64880645;BA.debugLine="u.Parse(Starter.Provider.GetFileUri(filename))";
_u.Parse(BA.ObjectToString(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._getfileuri /*Object*/ (null,_filename)));
RDebugUtils.currentLine=64880646;
 //BA.debugLineNum = 64880646;BA.debugLine="Dim inten As Intent";
_inten = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=64880647;
 //BA.debugLineNum = 64880647;BA.debugLine="Dim tmpt As String = \"\"";
_tmpt = "";
RDebugUtils.currentLine=64880648;
 //BA.debugLineNum = 64880648;BA.debugLine="inten.Initialize(inten.ACTION_SEND,\"\")";
_inten.Initialize(_inten.ACTION_SEND,"");
RDebugUtils.currentLine=64880649;
 //BA.debugLineNum = 64880649;BA.debugLine="inten.SetType(\"image/*\")";
_inten.SetType("image/*");
RDebugUtils.currentLine=64880650;
 //BA.debugLineNum = 64880650;BA.debugLine="inten.PutExtra(\"android.intent.extra.STREAM\",u)";
_inten.PutExtra("android.intent.extra.STREAM",(Object)(_u.getObject()));
RDebugUtils.currentLine=64880653;
 //BA.debugLineNum = 64880653;BA.debugLine="StartActivity(inten)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_inten.getObject()));
 } 
       catch (Exception e13) {
			processBA.setLastException(e13);RDebugUtils.currentLine=64880655;
 //BA.debugLineNum = 64880655;BA.debugLine="ToastMessageShow(LastException.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=64880657;
 //BA.debugLineNum = 64880657;BA.debugLine="End Sub";
return "";
}
public static Object  _ion_event(String _methodname,Object[] _args) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ion_event", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "ion_event", new Object[] {_methodname,_args}));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=40960000;
 //BA.debugLineNum = 40960000;BA.debugLine="Sub ion_Event (MethodName As String, Args() As Obj";
RDebugUtils.currentLine=40960001;
 //BA.debugLineNum = 40960001;BA.debugLine="Dim xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=40960002;
 //BA.debugLineNum = 40960002;BA.debugLine="If Args(0) = -1 Then";
if ((_args[(int) (0)]).equals((Object)(-1))) { 
RDebugUtils.currentLine=40960003;
 //BA.debugLineNum = 40960003;BA.debugLine="Try";
try {RDebugUtils.currentLine=40960004;
 //BA.debugLineNum = 40960004;BA.debugLine="Dim in As Intent = Args(1)";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_args[(int) (1)]));
RDebugUtils.currentLine=40960005;
 //BA.debugLineNum = 40960005;BA.debugLine="If File.Exists(Starter.provider.SharedFolder, t";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile)) { 
RDebugUtils.currentLine=40960006;
 //BA.debugLineNum = 40960006;BA.debugLine="lastPicture = LoadBitmapSample(Starter.provide";
_lastpicture = anywheresoftware.b4a.keywords.Common.LoadBitmapSample(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile,mostCurrent._imgcover.getWidth(),mostCurrent._imgcover.getHeight());
RDebugUtils.currentLine=40960007;
 //BA.debugLineNum = 40960007;BA.debugLine="lastPicture =xui.LoadBitmapResize(Starter.prov";
_lastpicture = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(mostCurrent._xui.LoadBitmapResize(mostCurrent._starter._provider /*ng.dsoftlab.stegocam.fileprovider*/ ._sharedfolder /*String*/ ,_tempimagefile,mostCurrent._imgcover.getWidth(),mostCurrent._imgcover.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=40960008;
 //BA.debugLineNum = 40960008;BA.debugLine="imgCover.Bitmap = lastPicture";
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(_lastpicture.getObject()));
 }else 
{RDebugUtils.currentLine=40960009;
 //BA.debugLineNum = 40960009;BA.debugLine="Else If in.HasExtra(\"data\") Then 'try to get th";
if (_in.HasExtra("data")) { 
RDebugUtils.currentLine=40960010;
 //BA.debugLineNum = 40960010;BA.debugLine="Dim jo As JavaObject = in";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_in.getObject()));
RDebugUtils.currentLine=40960011;
 //BA.debugLineNum = 40960011;BA.debugLine="lastPicture = jo.RunMethodJO(\"getExtras\", Null";
_lastpicture = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_jo.RunMethodJO("getExtras",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethod("get",new Object[]{(Object)("data")})));
 }}
;
 } 
       catch (Exception e14) {
			processBA.setLastException(e14);RDebugUtils.currentLine=40960014;
 //BA.debugLineNum = 40960014;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("740960014",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=40960017;
 //BA.debugLineNum = 40960017;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
if (_lastpicture.IsInitialized()) { 
mostCurrent._imgcover.setBitmap((android.graphics.Bitmap)(_lastpicture.getObject()));};
RDebugUtils.currentLine=40960018;
 //BA.debugLineNum = 40960018;BA.debugLine="Return Null";
if (true) return anywheresoftware.b4a.keywords.Common.Null;
RDebugUtils.currentLine=40960019;
 //BA.debugLineNum = 40960019;BA.debugLine="End Sub";
return null;
}
public static String  _lblshowpassword_click() throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblshowpassword_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblshowpassword_click", null));}
RDebugUtils.currentLine=41222144;
 //BA.debugLineNum = 41222144;BA.debugLine="Private Sub lblShowPassword_Click";
RDebugUtils.currentLine=41222145;
 //BA.debugLineNum = 41222145;BA.debugLine="If lblShowPassword.Text=config.hide Then";
if ((mostCurrent._lblshowpassword.getText()).equals(BA.ObjectToString(mostCurrent._config._hide /*char*/ ))) { 
RDebugUtils.currentLine=41222146;
 //BA.debugLineNum = 41222146;BA.debugLine="lblShowPassword.Text=config.show";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._show /*char*/ ));
RDebugUtils.currentLine=41222147;
 //BA.debugLineNum = 41222147;BA.debugLine="txtKey.PasswordMode=False";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=41222149;
 //BA.debugLineNum = 41222149;BA.debugLine="lblShowPassword.Text=config.hide";
mostCurrent._lblshowpassword.setText(BA.ObjectToCharSequence(mostCurrent._config._hide /*char*/ ));
RDebugUtils.currentLine=41222150;
 //BA.debugLineNum = 41222150;BA.debugLine="txtKey.PasswordMode=True";
mostCurrent._txtkey.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=41222152;
 //BA.debugLineNum = 41222152;BA.debugLine="txtKey.SelectionStart=txtKey.Text.Length";
mostCurrent._txtkey.setSelectionStart(mostCurrent._txtkey.getText().length());
RDebugUtils.currentLine=41222153;
 //BA.debugLineNum = 41222153;BA.debugLine="End Sub";
return "";
}
public static String  _rboxencodefile_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rboxencodefile_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rboxencodefile_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=40501248;
 //BA.debugLineNum = 40501248;BA.debugLine="Private Sub rboxEncodeFile_CheckedChange(Checked A";
RDebugUtils.currentLine=40501249;
 //BA.debugLineNum = 40501249;BA.debugLine="If rboxEncodeFile.Checked Then";
if (mostCurrent._rboxencodefile.getChecked()) { 
RDebugUtils.currentLine=40501250;
 //BA.debugLineNum = 40501250;BA.debugLine="pnlMessage.Visible=False";
mostCurrent._pnlmessage.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40501251;
 //BA.debugLineNum = 40501251;BA.debugLine="pnlFile.Visible=True";
mostCurrent._pnlfile.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40501254;
 //BA.debugLineNum = 40501254;BA.debugLine="pnlKey.Top=pnlFile.Top+pnlFile.Height+15dip";
mostCurrent._pnlkey.setTop((int) (mostCurrent._pnlfile.getTop()+mostCurrent._pnlfile.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))));
RDebugUtils.currentLine=40501255;
 //BA.debugLineNum = 40501255;BA.debugLine="lblErrorMsg.Top=pnlKey.Top+pnlKey.Height+15dip";
mostCurrent._lblerrormsg.setTop((int) (mostCurrent._pnlkey.getTop()+mostCurrent._pnlkey.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))));
RDebugUtils.currentLine=40501256;
 //BA.debugLineNum = 40501256;BA.debugLine="btnCancel.Top=lblErrorMsg.Top+lblErrorMsg.Height";
mostCurrent._btncancel.setTop((int) (mostCurrent._lblerrormsg.getTop()+mostCurrent._lblerrormsg.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=40501257;
 //BA.debugLineNum = 40501257;BA.debugLine="btnEncode.Top=lblErrorMsg.Top+lblErrorMsg.Height";
mostCurrent._btnencode.setTop((int) (mostCurrent._lblerrormsg.getTop()+mostCurrent._lblerrormsg.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 };
RDebugUtils.currentLine=40501259;
 //BA.debugLineNum = 40501259;BA.debugLine="End Sub";
return "";
}
public static String  _rboxencodetext_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rboxencodetext_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rboxencodetext_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=40435712;
 //BA.debugLineNum = 40435712;BA.debugLine="Private Sub rboxEncodeText_CheckedChange(Checked A";
RDebugUtils.currentLine=40435713;
 //BA.debugLineNum = 40435713;BA.debugLine="If rboxEncodeText.Checked Then";
if (mostCurrent._rboxencodetext.getChecked()) { 
RDebugUtils.currentLine=40435714;
 //BA.debugLineNum = 40435714;BA.debugLine="pnlFile.Visible=False";
mostCurrent._pnlfile.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=40435715;
 //BA.debugLineNum = 40435715;BA.debugLine="pnlMessage.Visible=True";
mostCurrent._pnlmessage.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=40435718;
 //BA.debugLineNum = 40435718;BA.debugLine="pnlKey.Top=pnlMessage.Top+pnlMessage.Height+10di";
mostCurrent._pnlkey.setTop((int) (mostCurrent._pnlmessage.getTop()+mostCurrent._pnlmessage.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=40435719;
 //BA.debugLineNum = 40435719;BA.debugLine="lblErrorMsg.Top=pnlKey.Top+pnlKey.Height+10dip";
mostCurrent._lblerrormsg.setTop((int) (mostCurrent._pnlkey.getTop()+mostCurrent._pnlkey.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=40435720;
 //BA.debugLineNum = 40435720;BA.debugLine="btnCancel.Top=lblErrorMsg.Top+lblErrorMsg.Height";
mostCurrent._btncancel.setTop((int) (mostCurrent._lblerrormsg.getTop()+mostCurrent._lblerrormsg.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=40435721;
 //BA.debugLineNum = 40435721;BA.debugLine="btnEncode.Top=lblErrorMsg.Top+lblErrorMsg.Height";
mostCurrent._btnencode.setTop((int) (mostCurrent._lblerrormsg.getTop()+mostCurrent._lblerrormsg.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 };
RDebugUtils.currentLine=40435723;
 //BA.debugLineNum = 40435723;BA.debugLine="End Sub";
return "";
}
public static String  _startactivityforresult(anywheresoftware.b4a.objects.IntentWrapper _i) throws Exception{
RDebugUtils.currentModule="encode";
if (Debug.shouldDelegate(mostCurrent.activityBA, "startactivityforresult", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "startactivityforresult", new Object[] {_i}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=41025536;
 //BA.debugLineNum = 41025536;BA.debugLine="Sub StartActivityForResult(i As Intent)";
RDebugUtils.currentLine=41025537;
 //BA.debugLineNum = 41025537;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_getba()));
RDebugUtils.currentLine=41025538;
 //BA.debugLineNum = 41025538;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
_ion = _jo.CreateEvent(processBA,"anywheresoftware.b4a.IOnActivityResult","ion",anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=41025539;
 //BA.debugLineNum = 41025539;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
_jo.RunMethod("startActivityForResult",new Object[]{_ion,(Object)(_i.getObject())});
RDebugUtils.currentLine=41025540;
 //BA.debugLineNum = 41025540;BA.debugLine="End Sub";
return "";
}
}