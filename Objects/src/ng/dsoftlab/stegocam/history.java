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

public class history extends androidx.appcompat.app.AppCompatActivity implements B4AActivity{
	public static history mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.history");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (history).");
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
		activityBA = new BA(this, layout, processBA, "ng.dsoftlab.stegocam", "ng.dsoftlab.stegocam.history");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ng.dsoftlab.stegocam.history", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (history) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (history) Resume **");
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
		return history.class;
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
            BA.LogInfo("** Activity (history) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (history) Pause event (activity is not paused). **");
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
            history mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (history) Resume **");
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
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static int _numberofcolumns = 0;
public static int _currow = 0;
public static int _curcol = 0;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public ng.dsoftlab.stegocam.b4xtable _b4xtable1 = null;
public ng.dsoftlab.stegocam.b4xdialog _dialog = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnprev = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnextract = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshare = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgpreview = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpreview = null;
public static float _startx = 0f;
public static float _starty = 0f;
public anywheresoftware.b4a.objects.LabelWrapper _lblimglocation = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgdelete = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgextract = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgshare = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldelete = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlextract = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlshare = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.encode _encode = null;
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
 //BA.debugLineNum = 46;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"history\")";
mostCurrent._activity.LoadLayout("history",mostCurrent.activityBA);
 //BA.debugLineNum = 49;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
mostCurrent._sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 50;BA.debugLine="ToolbarHelper.Initialize";
mostCurrent._toolbarhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 51;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
mostCurrent._toolbarhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 52;BA.debugLine="ACToolBarLight1.InitMenuListener";
mostCurrent._actoolbarlight1.InitMenuListener();
 //BA.debugLineNum = 53;BA.debugLine="Dialog.Initialize(Activity)";
mostCurrent._dialog._initialize /*String*/ (mostCurrent.activityBA,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())));
 //BA.debugLineNum = 54;BA.debugLine="Dialog.Title = \"Stego Image View\"";
mostCurrent._dialog._title /*Object*/  = (Object)("Stego Image View");
 //BA.debugLineNum = 55;BA.debugLine="FindPictures";
_findpictures();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 72;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And Dialog.Clo";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._dialog._close /*boolean*/ (mostCurrent._xui.DialogResponse_Cancel)) { 
 //BA.debugLineNum = 73;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 75;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 76;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 77;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 78;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 82;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static String  _activity_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Sub Activity_Touch (Action As Int, X As Float, Y A";
 //BA.debugLineNum = 194;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_UP)) {
case 0: {
 //BA.debugLineNum = 196;BA.debugLine="startX = X";
_startx = _x;
 //BA.debugLineNum = 197;BA.debugLine="startY = Y";
_starty = _y;
 break; }
case 1: {
 //BA.debugLineNum = 199;BA.debugLine="If Abs(y - startY) > 20%y Then Return";
if (anywheresoftware.b4a.keywords.Common.Abs(_y-_starty)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA)) { 
if (true) return "";};
 //BA.debugLineNum = 200;BA.debugLine="If X - startX > 30%x Then";
if (_x-_startx>anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA)) { 
 //BA.debugLineNum = 201;BA.debugLine="If btnPrev.Enabled=True Then CallSub(\"\",btnPre";
if (mostCurrent._btnprev.getEnabled()==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(""),_btnprev_click());};
 }else if(_startx-_x>anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA)) { 
 //BA.debugLineNum = 203;BA.debugLine="If btnNext.Enabled=True Then CallSub(\"\",btnNex";
if (mostCurrent._btnnext.getEnabled()==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(""),_btnnext_click());};
 };
 break; }
}
;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 67;BA.debugLine="StartActivity(mainmenu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._mainmenu.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public static String  _b4xtable1_cellclicked(String _columnid,long _rowid) throws Exception{
String _img = "";
 //BA.debugLineNum = 179;BA.debugLine="Sub B4XTable1_CellClicked (ColumnId As String, Row";
 //BA.debugLineNum = 180;BA.debugLine="Dim img As String = B4XTable1.GetRow(RowId).Get(C";
_img = BA.ObjectToString(mostCurrent._b4xtable1._getrow /*anywheresoftware.b4a.objects.collections.Map*/ (_rowid).Get((Object)(_columnid)));
 //BA.debugLineNum = 181;BA.debugLine="curCol=ColumnId";
_curcol = (int)(Double.parseDouble(_columnid));
 //BA.debugLineNum = 182;BA.debugLine="curRow = RowId";
_currow = (int) (_rowid);
 //BA.debugLineNum = 183;BA.debugLine="If img <> \"\" Then";
if ((_img).equals("") == false) { 
 //BA.debugLineNum = 184;BA.debugLine="stegopreview.stegoimage= LoadBitmap(\"\",img)";
mostCurrent._stegopreview._stegoimage /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap("",_img).getObject()));
 //BA.debugLineNum = 185;BA.debugLine="stegopreview.stegoImagePath=img";
mostCurrent._stegopreview._stegoimagepath /*String*/  = _img;
 //BA.debugLineNum = 186;BA.debugLine="stegopreview.fromActivity=\"history\"";
mostCurrent._stegopreview._fromactivity /*String*/  = "history";
 //BA.debugLineNum = 187;BA.debugLine="StartActivity(stegopreview)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._stegopreview.getObject()));
 //BA.debugLineNum = 188;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _b4xtable1_dataupdated() throws Exception{
anywheresoftware.b4a.objects.collections.Map _row = null;
int _i = 0;
long _rowid = 0L;
ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn _column = null;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _iv = null;
 //BA.debugLineNum = 156;BA.debugLine="Sub B4XTable1_DataUpdated";
 //BA.debugLineNum = 157;BA.debugLine="Dim row As Map";
_row = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 158;BA.debugLine="For i = 0 To B4XTable1.VisibleRowIds.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._b4xtable1._visiblerowids /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 159;BA.debugLine="Dim RowId As Long = B4XTable1.VisibleRowIds.Get(";
_rowid = BA.ObjectToLongNumber(mostCurrent._b4xtable1._visiblerowids /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
 //BA.debugLineNum = 160;BA.debugLine="If RowId > 0 Then";
if (_rowid>0) { 
 //BA.debugLineNum = 161;BA.debugLine="row = B4XTable1.GetRow(RowId)";
_row = mostCurrent._b4xtable1._getrow /*anywheresoftware.b4a.objects.collections.Map*/ (_rowid);
 }else {
 //BA.debugLineNum = 163;BA.debugLine="row = CreateMap()";
_row = anywheresoftware.b4a.keywords.Common.createMap(new Object[] {});
 };
 //BA.debugLineNum = 165;BA.debugLine="For Each column As B4XTableColumn In B4XTable1.C";
{
final anywheresoftware.b4a.BA.IterableList group9 = mostCurrent._b4xtable1._columns /*anywheresoftware.b4a.objects.collections.List*/ ;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_column = (ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn)(group9.Get(index9));
 //BA.debugLineNum = 166;BA.debugLine="Dim pnl As B4XView = column.CellsLayouts.Get(i";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_column.CellsLayouts /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (_i+1))));
 //BA.debugLineNum = 167;BA.debugLine="Dim iv As B4XView = pnl.GetView(1) 'ImageView w";
_iv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_iv = _pnl.GetView((int) (1));
 //BA.debugLineNum = 168;BA.debugLine="If row.GetDefault(column.Id, \"\") <> \"\" Then";
if ((_row.GetDefault((Object)(_column.Id /*String*/ ),(Object)(""))).equals((Object)("")) == false) { 
 //BA.debugLineNum = 169;BA.debugLine="iv.SetBitmap(xui.LoadBitmapResize(\"\", row.Get(";
_iv.SetBitmap((android.graphics.Bitmap)(mostCurrent._xui.LoadBitmapResize("",BA.ObjectToString(_row.Get((Object)(_column.Id /*String*/ ))),_iv.getWidth(),_iv.getHeight(),anywheresoftware.b4a.keywords.Common.False).getObject()));
 }else {
 //BA.debugLineNum = 171;BA.debugLine="iv.SetBitmap(Null)";
_iv.SetBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 };
 }
};
 }
};
 //BA.debugLineNum = 175;BA.debugLine="btnNext.Enabled = B4XTable1.lblNext.Tag";
mostCurrent._btnnext.setEnabled(BA.ObjectToBoolean(mostCurrent._b4xtable1._lblnext /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag()));
 //BA.debugLineNum = 176;BA.debugLine="btnPrev.Enabled = B4XTable1.lblBack.Tag";
mostCurrent._btnprev.setEnabled(BA.ObjectToBoolean(mostCurrent._b4xtable1._lblback /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag()));
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _btnnext_click() throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Sub btnNext_Click";
 //BA.debugLineNum = 210;BA.debugLine="B4XTable1.CurrentPage = B4XTable1.CurrentPage + 1";
mostCurrent._b4xtable1._setcurrentpage /*int*/ ((int) (mostCurrent._b4xtable1._getcurrentpage /*int*/ ()+1));
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public static String  _btnprev_click() throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Sub btnPrev_Click";
 //BA.debugLineNum = 214;BA.debugLine="B4XTable1.CurrentPage = B4XTable1.CurrentPage - 1";
mostCurrent._b4xtable1._setcurrentpage /*int*/ ((int) (mostCurrent._b4xtable1._getcurrentpage /*int*/ ()-1));
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public static String  _createtable(anywheresoftware.b4a.objects.collections.List _files) throws Exception{
int _i = 0;
ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn _col = null;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
 //BA.debugLineNum = 101;BA.debugLine="Sub CreateTable (Files As List)";
 //BA.debugLineNum = 102;BA.debugLine="B4XTable1.Clear";
mostCurrent._b4xtable1._clear /*void*/ ();
 //BA.debugLineNum = 103;BA.debugLine="B4XTable1.AllowSmallRowHeightModifications = Fals";
mostCurrent._b4xtable1._allowsmallrowheightmodifications /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 104;BA.debugLine="B4XTable1.RowHeight = 100dip";
mostCurrent._b4xtable1._rowheight /*int*/  = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 //BA.debugLineNum = 105;BA.debugLine="B4XTable1.SearchField.TextField.Enabled = False";
mostCurrent._b4xtable1._searchfield /*ng.dsoftlab.stegocam.b4xfloattextfield*/ ._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 106;BA.debugLine="B4XTable1.SearchField.TextField.Visible=False";
mostCurrent._b4xtable1._searchfield /*ng.dsoftlab.stegocam.b4xfloattextfield*/ ._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 107;BA.debugLine="B4XTable1.SearchField.mBase.Visible=False";
mostCurrent._b4xtable1._searchfield /*ng.dsoftlab.stegocam.b4xfloattextfield*/ ._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 108;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 109;BA.debugLine="B4XTable1.AddColumn(i, B4XTable1.COLUMN_TYPE_TEX";
mostCurrent._b4xtable1._addcolumn /*ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn*/ (BA.NumberToString(_i),mostCurrent._b4xtable1._column_type_text /*int*/ );
 }
};
 //BA.debugLineNum = 112;BA.debugLine="B4XTable1.MaximumRowsPerPage = 20";
mostCurrent._b4xtable1._maximumrowsperpage /*int*/  = (int) (20);
 //BA.debugLineNum = 113;BA.debugLine="B4XTable1.BuildLayoutsCache(B4XTable1.MaximumRows";
mostCurrent._b4xtable1._buildlayoutscache /*String*/ (mostCurrent._b4xtable1._maximumrowsperpage /*int*/ );
 //BA.debugLineNum = 114;BA.debugLine="For Each col As B4XTableColumn In B4XTable1.Colum";
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._b4xtable1._columns /*anywheresoftware.b4a.objects.collections.List*/ ;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_col = (ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn)(group12.Get(index12));
 //BA.debugLineNum = 115;BA.debugLine="col.Sortable = False";
_col.Sortable /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 116;BA.debugLine="col.Width = 100%x / NumberOfColumns";
_col.Width /*int*/  = (int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)_numberofcolumns);
 //BA.debugLineNum = 117;BA.debugLine="For i = 0 To col.CellsLayouts.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (_col.CellsLayouts /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
 //BA.debugLineNum = 118;BA.debugLine="Dim pnl As B4XView = col.CellsLayouts.Get(i)";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_col.CellsLayouts /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i)));
 //BA.debugLineNum = 119;BA.debugLine="pnl.GetView(0).Visible = False 'hide the label";
_pnl.GetView((int) (0)).setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 120;BA.debugLine="If i > 0 Then 'i = 0 is the header";
if (_i>0) { 
 //BA.debugLineNum = 121;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 122;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 123;BA.debugLine="pnl.AddView(iv, 2dip, 2dip, col.Width - 4dip,";
_pnl.AddView((android.view.View)(_iv.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_col.Width /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),(int) (mostCurrent._b4xtable1._rowheight /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 };
 }
};
 }
};
 //BA.debugLineNum = 127;BA.debugLine="LoadData(Files)";
_loaddata(_files);
 //BA.debugLineNum = 128;BA.debugLine="B4XTable1.mBase.Visible = True";
mostCurrent._b4xtable1._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static void  _findpictures() throws Exception{
ResumableSub_FindPictures rsub = new ResumableSub_FindPictures(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_FindPictures extends BA.ResumableSub {
public ResumableSub_FindPictures(ng.dsoftlab.stegocam.history parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.history parent;
anywheresoftware.b4a.objects.collections.List _allpictures = null;
String _picturesfolder = "";
boolean _success = false;
anywheresoftware.b4a.objects.collections.List _files = null;
String _f = "";
anywheresoftware.b4a.BA.IterableList group7;
int index7;
int groupLen7;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 87;BA.debugLine="Dim AllPictures As List";
_allpictures = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 88;BA.debugLine="AllPictures.Initialize";
_allpictures.Initialize();
 //BA.debugLineNum = 89;BA.debugLine="Dim PicturesFolder As String = config.stegoImageP";
_picturesfolder = parent.mostCurrent._config._stegoimagepath /*String*/ ;
 //BA.debugLineNum = 90;BA.debugLine="If File.Exists(PicturesFolder, \"\") = False Then C";
if (true) break;

case 1:
//if
this.state = 6;
if (anywheresoftware.b4a.keywords.Common.File.Exists(_picturesfolder,"")==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
this.state = -1;
if (true) break;;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 91;BA.debugLine="Wait For (File.ListFilesAsync(PicturesFolder)) Co";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, anywheresoftware.b4a.keywords.Common.File.ListFilesAsync(processBA,_picturesfolder));
this.state = 15;
return;
case 15:
//C
this.state = 7;
_success = (Boolean) result[0];
_files = (anywheresoftware.b4a.objects.collections.List) result[1];
;
 //BA.debugLineNum = 92;BA.debugLine="If Success Then";
if (true) break;

case 7:
//if
this.state = 14;
if (_success) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 93;BA.debugLine="For Each f As String In Files";
if (true) break;

case 10:
//for
this.state = 13;
group7 = _files;
index7 = 0;
groupLen7 = group7.getSize();
this.state = 16;
if (true) break;

case 16:
//C
this.state = 13;
if (index7 < groupLen7) {
this.state = 12;
_f = BA.ObjectToString(group7.Get(index7));}
if (true) break;

case 17:
//C
this.state = 16;
index7++;
if (true) break;

case 12:
//C
this.state = 17;
 //BA.debugLineNum = 94;BA.debugLine="AllPictures.Add(File.Combine(PicturesFolder, f)";
_allpictures.Add((Object)(anywheresoftware.b4a.keywords.Common.File.Combine(_picturesfolder,_f)));
 if (true) break;
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
 //BA.debugLineNum = 97;BA.debugLine="AllPictures.Sort(False)";
_allpictures.Sort(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 98;BA.debugLine="CreateTable(AllPictures)";
_createtable(_allpictures);
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _complete(boolean _success,anywheresoftware.b4a.objects.collections.List _files) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mostCurrent._actoolbarlight1 = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private ToolbarHelper As ACActionBar";
mostCurrent._toolbarhelper = new de.amberhome.objects.appcompat.ACActionBar();
 //BA.debugLineNum = 21;BA.debugLine="Dim SharedPrefs As SharedPreferences";
mostCurrent._sharedprefs = new com.b4x.sharedpreferences.SharedPreferences();
 //BA.debugLineNum = 22;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 23;BA.debugLine="Private B4XTable1 As B4XTable";
mostCurrent._b4xtable1 = new ng.dsoftlab.stegocam.b4xtable();
 //BA.debugLineNum = 24;BA.debugLine="Private Dialog As B4XDialog";
mostCurrent._dialog = new ng.dsoftlab.stegocam.b4xdialog();
 //BA.debugLineNum = 25;BA.debugLine="Private btnPrev As Button";
mostCurrent._btnprev = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private btnNext As Button";
mostCurrent._btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private btnCancel As Button";
mostCurrent._btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private btnExtract As Button";
mostCurrent._btnextract = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private btnShare As Button";
mostCurrent._btnshare = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private imgPreview As ImageView";
mostCurrent._imgpreview = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private pnlPreview As Panel";
mostCurrent._pnlpreview = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim startX, startY As Float";
_startx = 0f;
_starty = 0f;
 //BA.debugLineNum = 34;BA.debugLine="Private lblImgLocation As Label";
mostCurrent._lblimglocation = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private imgDelete As ImageView";
mostCurrent._imgdelete = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private imgExtract As ImageView";
mostCurrent._imgextract = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private imgShare As ImageView";
mostCurrent._imgshare = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private pnlDelete As Panel";
mostCurrent._pnldelete = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private pnlExtract As Panel";
mostCurrent._pnlextract = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private pnlShare As Panel";
mostCurrent._pnlshare = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _loaddata(anywheresoftware.b4a.objects.collections.List _files) throws Exception{
anywheresoftware.b4a.objects.collections.List _data = null;
Object[] _row = null;
int _index = 0;
String _f = "";
int _i = 0;
 //BA.debugLineNum = 131;BA.debugLine="Private Sub LoadData (Files As List)";
 //BA.debugLineNum = 132;BA.debugLine="Dim Data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 133;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 134;BA.debugLine="Dim row(NumberOfColumns) As Object";
_row = new Object[_numberofcolumns];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
 //BA.debugLineNum = 135;BA.debugLine="Dim index As Int = -1";
_index = (int) (-1);
 //BA.debugLineNum = 136;BA.debugLine="For Each f As String In Files";
{
final anywheresoftware.b4a.BA.IterableList group5 = _files;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_f = BA.ObjectToString(group5.Get(index5));
 //BA.debugLineNum = 137;BA.debugLine="If f.EndsWith(\".jpg\") Or f.EndsWith(\".png\") Then";
if (_f.endsWith(".jpg") || _f.endsWith(".png")) { 
 //BA.debugLineNum = 138;BA.debugLine="index = (index + 1) Mod NumberOfColumns";
_index = (int) ((_index+1)%_numberofcolumns);
 //BA.debugLineNum = 139;BA.debugLine="row(index) = f";
_row[_index] = (Object)(_f);
 //BA.debugLineNum = 140;BA.debugLine="If index = NumberOfColumns - 1 Then";
if (_index==_numberofcolumns-1) { 
 //BA.debugLineNum = 141;BA.debugLine="Data.Add(row)";
_data.Add((Object)(_row));
 //BA.debugLineNum = 142;BA.debugLine="Dim row(NumberOfColumns) As Object";
_row = new Object[_numberofcolumns];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
 };
 };
 }
};
 //BA.debugLineNum = 146;BA.debugLine="If index < NumberOfColumns - 1 Then";
if (_index<_numberofcolumns-1) { 
 //BA.debugLineNum = 148;BA.debugLine="For i = index + 1 To NumberOfColumns - 1";
{
final int step16 = 1;
final int limit16 = (int) (_numberofcolumns-1);
_i = (int) (_index+1) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
 //BA.debugLineNum = 149;BA.debugLine="row(i) = \"\"";
_row[_i] = (Object)("");
 }
};
 //BA.debugLineNum = 151;BA.debugLine="Data.Add(row)";
_data.Add((Object)(_row));
 };
 //BA.debugLineNum = 153;BA.debugLine="B4XTable1.SetData(Data)";
mostCurrent._b4xtable1._setdata /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (_data);
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 11;BA.debugLine="Private NumberOfColumns As Int = 3";
_numberofcolumns = (int) (3);
 //BA.debugLineNum = 12;BA.debugLine="Dim curRow As Int";
_currow = 0;
 //BA.debugLineNum = 13;BA.debugLine="Dim curCol As Int";
_curcol = 0;
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
}
