package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class mainmenu_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,57);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 60;BA.debugLine="Drawer.Initialize(Me, \"Drawer\", Activity, 300dip";
Debug.ShouldStop(134217728);
mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_initialize" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.getObject()),(Object)(BA.ObjectToString("Drawer")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), mainmenu.mostCurrent._activity.getObject()),(Object)(mainmenu.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 BA.debugLineNum = 61;BA.debugLine="Drawer.CenterPanel.LoadLayout(\"mainmenu\")";
Debug.ShouldStop(268435456);
mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getcenterpanel" /*RemoteObject*/ ).runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("mainmenu")),mainmenu.mostCurrent.activityBA);
 BA.debugLineNum = 62;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(536870912);
mainmenu.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",mainmenu.mostCurrent.activityBA);
 BA.debugLineNum = 63;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to tru";
Debug.ShouldStop(1073741824);
mainmenu.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",mainmenu.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 64;BA.debugLine="ToolbarHelper.UpIndicatorDrawable = config.Bitma";
Debug.ShouldStop(-2147483648);
mainmenu.mostCurrent._toolbarhelper.runVoidMethod ("setUpIndicatorDrawable",(mainmenu.mostCurrent._config.runMethod(false,"_bitmaptobitmapdrawable" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("hamburger.png"))))).getObject()));
 BA.debugLineNum = 65;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(1);
mainmenu.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 66;BA.debugLine="Drawer.LeftPanel.LoadLayout(\"leftmenu\")";
Debug.ShouldStop(2);
mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftpanel" /*RemoteObject*/ ).runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("leftmenu")),mainmenu.mostCurrent.activityBA);
 BA.debugLineNum = 67;BA.debugLine="load_Images";
Debug.ShouldStop(4);
_load_images();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",mainmenu.processBA, e11.toString()); BA.debugLineNum = 71;BA.debugLine="Log(LastException)";
Debug.ShouldStop(64);
mainmenu.mostCurrent.__c.runVoidMethod ("LogImpl","737945358",BA.ObjectToString(mainmenu.mostCurrent.__c.runMethod(false,"LastException",mainmenu.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,89);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 89;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And Drawer.Lef";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, mainmenu.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) && RemoteObject.solveBoolean(".",mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftopen" /*RemoteObject*/ ))) { 
 BA.debugLineNum = 91;BA.debugLine="Drawer.LeftOpen = False";
Debug.ShouldStop(67108864);
mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_setleftopen" /*RemoteObject*/ ,mainmenu.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 92;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
Debug.CheckDeviceExceptions();if (true) return mainmenu.mostCurrent.__c.getField(true,"True");
 }else 
{ BA.debugLineNum = 93;BA.debugLine="Else If KeyCode = KeyCodes.KEYCODE_BACK And Drawe";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, mainmenu.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) && RemoteObject.solveBoolean("=",mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftopen" /*RemoteObject*/ ),mainmenu.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 94;BA.debugLine="pnlExit_Click";
Debug.ShouldStop(536870912);
_pnlexit_click();
 BA.debugLineNum = 95;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return mainmenu.mostCurrent.__c.getField(true,"True");
 }}
;
 BA.debugLineNum = 97;BA.debugLine="Return False";
Debug.ShouldStop(1);
Debug.CheckDeviceExceptions();if (true) return mainmenu.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,80);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 80;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,76);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","activity_resume");}
 BA.debugLineNum = 76;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _actoolbarlight1_menuitemclick(RemoteObject _item) throws Exception{
try {
		Debug.PushSubsStack("ACToolBarLight1_MenuItemClick (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,100);
if (RapidSub.canDelegate("actoolbarlight1_menuitemclick")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","actoolbarlight1_menuitemclick", _item);}
Debug.locals.put("Item", _item);
 BA.debugLineNum = 100;BA.debugLine="Private Sub ACToolBarLight1_MenuItemClick (Item As";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _actoolbarlight1_navigationitemclick() throws Exception{
try {
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,85);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 85;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="Drawer.LeftOpen = Not(Drawer.LeftOpen)";
Debug.ShouldStop(2097152);
mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_setleftopen" /*RemoteObject*/ ,mainmenu.mostCurrent.__c.runMethod(true,"Not",(Object)(mainmenu.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftopen" /*RemoteObject*/ ))));
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mainmenu.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private ToolbarHelper As ACActionBar";
mainmenu.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 19;BA.debugLine="Private Drawer As B4XDrawer";
mainmenu.mostCurrent._drawer = RemoteObject.createNew ("ng.dsoftlab.stegocam.b4xdrawer");
 //BA.debugLineNum = 21;BA.debugLine="Private lb1Menu As Label";
mainmenu.mostCurrent._lb1menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lb2Menu As Label";
mainmenu.mostCurrent._lb2menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lb3Menu As Label";
mainmenu.mostCurrent._lb3menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private ic1Menu As ImageView";
mainmenu.mostCurrent._ic1menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private ic2Menu As ImageView";
mainmenu.mostCurrent._ic2menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private ic3Menu As ImageView";
mainmenu.mostCurrent._ic3menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private ic4Menu As ImageView";
mainmenu.mostCurrent._ic4menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private ic5Menu As ImageView";
mainmenu.mostCurrent._ic5menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private ic6Menu As ImageView";
mainmenu.mostCurrent._ic6menu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private EditText1 As EditText";
mainmenu.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Button1 As Button";
mainmenu.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim myScale As SimpleScale";
mainmenu.mostCurrent._myscale = RemoteObject.createNew ("ng.dsoftlab.stegocam.simplescale");
 //BA.debugLineNum = 34;BA.debugLine="Dim container As Panel";
mainmenu.mostCurrent._container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private imgAbout As ImageView";
mainmenu.mostCurrent._imgabout = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private imgDecode As ImageView";
mainmenu.mostCurrent._imgdecode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private imgEncode As ImageView";
mainmenu.mostCurrent._imgencode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private imgExit As ImageView";
mainmenu.mostCurrent._imgexit = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private imgHistory As ImageView";
mainmenu.mostCurrent._imghistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private imgSettings As ImageView";
mainmenu.mostCurrent._imgsettings = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lblAbout As Label";
mainmenu.mostCurrent._lblabout = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lblDecode As Label";
mainmenu.mostCurrent._lbldecode = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lblEncode As Label";
mainmenu.mostCurrent._lblencode = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private lblExit As Label";
mainmenu.mostCurrent._lblexit = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private lblHistory As Label";
mainmenu.mostCurrent._lblhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private lblSettings As Label";
mainmenu.mostCurrent._lblsettings = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private Panel1 As Panel";
mainmenu.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private Panel2 As Panel";
mainmenu.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private pnlAbout As Panel";
mainmenu.mostCurrent._pnlabout = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private pnlDecode As Panel";
mainmenu.mostCurrent._pnldecode = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private pnlEncode As Panel";
mainmenu.mostCurrent._pnlencode = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private pnlExit As Panel";
mainmenu.mostCurrent._pnlexit = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private pnlHistory As Panel";
mainmenu.mostCurrent._pnlhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private pnlSettings As Panel";
mainmenu.mostCurrent._pnlsettings = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _lb1menu_click() throws Exception{
try {
		Debug.PushSubsStack("lb1Menu_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,119);
if (RapidSub.canDelegate("lb1menu_click")) { ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","lb1menu_click"); return;}
ResumableSub_lb1Menu_Click rsub = new ResumableSub_lb1Menu_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lb1Menu_Click extends BA.ResumableSub {
public ResumableSub_lb1Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lb1Menu_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,119);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 120;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
Debug.ShouldStop(8388608);
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftopen" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_setleftopen" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"False"));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 121;BA.debugLine="Sleep(10)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainmenu.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainmenu", "lb1menu_click"),BA.numberCast(int.class, 10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _lb2menu_click() throws Exception{
try {
		Debug.PushSubsStack("lb2Menu_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,115);
if (RapidSub.canDelegate("lb2menu_click")) { ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","lb2menu_click"); return;}
ResumableSub_lb2Menu_Click rsub = new ResumableSub_lb2Menu_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lb2Menu_Click extends BA.ResumableSub {
public ResumableSub_lb2Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lb2Menu_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,115);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 116;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
Debug.ShouldStop(524288);
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftopen" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_setleftopen" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"False"));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 117;BA.debugLine="Sleep(150)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainmenu.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainmenu", "lb2menu_click"),BA.numberCast(int.class, 150));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _lb4menu_click() throws Exception{
try {
		Debug.PushSubsStack("lb4Menu_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,123);
if (RapidSub.canDelegate("lb4menu_click")) { ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","lb4menu_click"); return;}
ResumableSub_lb4Menu_Click rsub = new ResumableSub_lb4Menu_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lb4Menu_Click extends BA.ResumableSub {
public ResumableSub_lb4Menu_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.mainmenu parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lb4Menu_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,123);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 124;BA.debugLine="If Drawer.LeftOpen Then Drawer.LeftOpen = False";
Debug.ShouldStop(134217728);
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_getleftopen" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent._drawer.runClassMethod (ng.dsoftlab.stegocam.b4xdrawer.class, "_setleftopen" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"False"));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 125;BA.debugLine="Sleep(10)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainmenu.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainmenu", "lb4menu_click"),BA.numberCast(int.class, 10));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 BA.debugLineNum = 126;BA.debugLine="MsgboxAsync(\"Application developed by Ebenezer Og";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Application developed by Ebenezer Ogidiolu in the scope of Alx Software Engineering Project."),parent.mostCurrent.__c.getField(true,"CRLF"),parent.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("The stegocam application allows users to hide secret messages or files within images, providing a secure and confidential communication method."),parent.mostCurrent.__c.getField(true,"CRLF"),parent.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Users can take new photos or select existing ones from their device. They have the option to hide a secret message or file within the image using various encryption methods, such as AES or DES."),parent.mostCurrent.__c.getField(true,"CRLF"),parent.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("To extract hidden data, users can view their modified photos within the app and decrypt the hidden message or extract the hidden file."),parent.mostCurrent.__c.getField(true,"CRLF"),parent.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("For any inquiries or support, please contact: ogidioluebenezer@gmail.com | +2349169442847"),parent.mostCurrent.__c.getField(true,"CRLF")))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("About the stegocam application"))),mainmenu.processBA);
 BA.debugLineNum = 127;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _load_images() throws Exception{
try {
		Debug.PushSubsStack("load_Images (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,105);
if (RapidSub.canDelegate("load_images")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","load_images");}
 BA.debugLineNum = 105;BA.debugLine="Sub load_Images";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="config.AjustImageView(ic1Menu,File.DirAssets,\"loc";
Debug.ShouldStop(512);
mainmenu.mostCurrent._config.runVoidMethod ("_ajustimageview" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent._ic1menu),(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("lock_color.png")));
 BA.debugLineNum = 107;BA.debugLine="config.AjustImageView(ic2Menu,File.DirAssets,\"unl";
Debug.ShouldStop(1024);
mainmenu.mostCurrent._config.runVoidMethod ("_ajustimageview" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent._ic2menu),(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("unlock_color.png")));
 BA.debugLineNum = 108;BA.debugLine="config.AjustImageView(ic3Menu,File.DirAssets,\"his";
Debug.ShouldStop(2048);
mainmenu.mostCurrent._config.runVoidMethod ("_ajustimageview" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent._ic3menu),(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("history_color.png")));
 BA.debugLineNum = 109;BA.debugLine="config.AjustImageView(ic4Menu,File.DirAssets,\"abo";
Debug.ShouldStop(4096);
mainmenu.mostCurrent._config.runVoidMethod ("_ajustimageview" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent._ic4menu),(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("about_color.png")));
 BA.debugLineNum = 110;BA.debugLine="config.AjustImageView(ic5Menu,File.DirAssets,\"pin";
Debug.ShouldStop(8192);
mainmenu.mostCurrent._config.runVoidMethod ("_ajustimageview" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent._ic5menu),(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("pin.png")));
 BA.debugLineNum = 111;BA.debugLine="config.AjustImageView(ic6Menu,File.DirAssets,\"sec";
Debug.ShouldStop(16384);
mainmenu.mostCurrent._config.runVoidMethod ("_ajustimageview" /*RemoteObject*/ ,mainmenu.mostCurrent.activityBA,(Object)(mainmenu.mostCurrent._ic6menu),(Object)(mainmenu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("sec_quest.png")));
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlabout_click() throws Exception{
try {
		Debug.PushSubsStack("pnlAbout_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,159);
if (RapidSub.canDelegate("pnlabout_click")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","pnlabout_click");}
 BA.debugLineNum = 159;BA.debugLine="Private Sub pnlAbout_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="lb4Menu_Click";
Debug.ShouldStop(-2147483648);
_lb4menu_click();
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnldecode_click() throws Exception{
try {
		Debug.PushSubsStack("pnlDecode_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,155);
if (RapidSub.canDelegate("pnldecode_click")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","pnldecode_click");}
 BA.debugLineNum = 155;BA.debugLine="Private Sub pnlDecode_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlencode_click() throws Exception{
try {
		Debug.PushSubsStack("pnlEncode_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,150);
if (RapidSub.canDelegate("pnlencode_click")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","pnlencode_click");}
 BA.debugLineNum = 150;BA.debugLine="Private Sub pnlEncode_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 151;BA.debugLine="StartActivity(encode)";
Debug.ShouldStop(4194304);
mainmenu.mostCurrent.__c.runVoidMethod ("StartActivity",mainmenu.processBA,(Object)((mainmenu.mostCurrent._encode.getObject())));
 BA.debugLineNum = 152;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8388608);
mainmenu.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _pnlexit_click() throws Exception{
try {
		Debug.PushSubsStack("pnlExit_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,141);
if (RapidSub.canDelegate("pnlexit_click")) { ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","pnlexit_click"); return;}
ResumableSub_pnlExit_Click rsub = new ResumableSub_pnlExit_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_pnlExit_Click extends BA.ResumableSub {
public ResumableSub_pnlExit_Click(ng.dsoftlab.stegocam.mainmenu parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.mainmenu parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("pnlExit_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,141);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 142;BA.debugLine="Msgbox2Async(\"Are you sure you want to exit?\",\"Ex";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to exit?")),(Object)(BA.ObjectToCharSequence("Exit Application")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),mainmenu.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 143;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", mainmenu.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainmenu", "pnlexit_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 144;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 145;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _pnlhistory_click() throws Exception{
try {
		Debug.PushSubsStack("pnlHistory_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,136);
if (RapidSub.canDelegate("pnlhistory_click")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","pnlhistory_click");}
 BA.debugLineNum = 136;BA.debugLine="Private Sub pnlHistory_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="StartActivity(history)";
Debug.ShouldStop(256);
mainmenu.mostCurrent.__c.runVoidMethod ("StartActivity",mainmenu.processBA,(Object)((mainmenu.mostCurrent._history.getObject())));
 BA.debugLineNum = 138;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
mainmenu.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlsettings_click() throws Exception{
try {
		Debug.PushSubsStack("pnlSettings_Click (mainmenu) ","mainmenu",2,mainmenu.mostCurrent.activityBA,mainmenu.mostCurrent,131);
if (RapidSub.canDelegate("pnlsettings_click")) { return ng.dsoftlab.stegocam.mainmenu.remoteMe.runUserSub(false, "mainmenu","pnlsettings_click");}
 BA.debugLineNum = 131;BA.debugLine="Private Sub pnlSettings_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(8);
mainmenu.mostCurrent.__c.runVoidMethod ("StartActivity",mainmenu.processBA,(Object)((mainmenu.mostCurrent._settings.getObject())));
 BA.debugLineNum = 133;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
mainmenu.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private Biometric As BiometricManager";
mainmenu._biometric = RemoteObject.createNew ("ng.dsoftlab.stegocam.biometricmanager");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}