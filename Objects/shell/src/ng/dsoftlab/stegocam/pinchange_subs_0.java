package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pinchange_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,45);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="Activity.LoadLayout(\"pinchange\")";
Debug.ShouldStop(16384);
pinchange.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("pinchange")),pinchange.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(65536);
pinchange.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 50;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(131072);
pinchange.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",pinchange.mostCurrent.activityBA);
 BA.debugLineNum = 51;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(262144);
pinchange.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",pinchange.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 52;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(524288);
pinchange.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 53;BA.debugLine="txtPin.InputType=Bit.Or(txtPin.InputType, 2)";
Debug.ShouldStop(1048576);
pinchange.mostCurrent._txtpin.runMethod(true,"setInputType",pinchange.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(pinchange.mostCurrent._txtpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 54;BA.debugLine="txtNewPIN.InputType=Bit.Or(txtNewPIN.InputType, 2";
Debug.ShouldStop(2097152);
pinchange.mostCurrent._txtnewpin.runMethod(true,"setInputType",pinchange.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(pinchange.mostCurrent._txtnewpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 55;BA.debugLine="txtConfirmNewPIN.InputType=Bit.Or(txtConfirmNewPI";
Debug.ShouldStop(4194304);
pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"setInputType",pinchange.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 56;BA.debugLine="IME.Initialize(\"IME\")";
Debug.ShouldStop(8388608);
pinchange.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("IME")));
 BA.debugLineNum = 57;BA.debugLine="IME.SetLengthFilter(txtPin,4)";
Debug.ShouldStop(16777216);
pinchange.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((pinchange.mostCurrent._txtpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 58;BA.debugLine="IME.SetLengthFilter(txtNewPIN,4)";
Debug.ShouldStop(33554432);
pinchange.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((pinchange.mostCurrent._txtnewpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 59;BA.debugLine="IME.SetLengthFilter(txtConfirmNewPIN,4)";
Debug.ShouldStop(67108864);
pinchange.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((pinchange.mostCurrent._txtconfirmnewpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 60;BA.debugLine="clearForm";
Debug.ShouldStop(134217728);
_clearform();
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_KeyPress (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,124);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 124;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, pinchange.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 126;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(536870912);
pinchange.mostCurrent.__c.runVoidMethod ("StartActivity",pinchange.processBA,(Object)((pinchange.mostCurrent._settings.getObject())));
 BA.debugLineNum = 127;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
pinchange.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 128;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
Debug.CheckDeviceExceptions();if (true) return pinchange.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 130;BA.debugLine="Return False";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return pinchange.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Pause (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,68);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,64);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","activity_resume");}
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,119);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 119;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(8388608);
pinchange.mostCurrent.__c.runVoidMethod ("StartActivity",pinchange.processBA,(Object)((pinchange.mostCurrent._settings.getObject())));
 BA.debugLineNum = 121;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
pinchange.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _alert_oncancel() throws Exception{
try {
		Debug.PushSubsStack("Alert_onCancel (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,164);
if (RapidSub.canDelegate("alert_oncancel")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","alert_oncancel");}
 BA.debugLineNum = 164;BA.debugLine="Sub Alert_onCancel()";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="Log($\"Alert_onCancel()\"$)";
Debug.ShouldStop(16);
pinchange.mostCurrent.__c.runVoidMethod ("LogImpl","746399489",(RemoteObject.createImmutable("Alert_onCancel()")),0);
 BA.debugLineNum = 166;BA.debugLine="sweet.AlertType = sweet.TypeError";
Debug.ShouldStop(32);
pinchange.mostCurrent._sweet.runMethod(true,"setAlertType",pinchange.mostCurrent._sweet.runMethod(true,"getTypeError"));
 BA.debugLineNum = 168;BA.debugLine="sweet.dismissWithAnimation";
Debug.ShouldStop(128);
pinchange.mostCurrent._sweet.runVoidMethod ("dismissWithAnimation");
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _alert_onconfirm() throws Exception{
try {
		Debug.PushSubsStack("Alert_onConfirm (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,170);
if (RapidSub.canDelegate("alert_onconfirm")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","alert_onconfirm");}
 BA.debugLineNum = 170;BA.debugLine="Sub Alert_onConfirm()";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="Log($\"Alert_onConfirm()\"$)";
Debug.ShouldStop(1024);
pinchange.mostCurrent.__c.runVoidMethod ("LogImpl","746465025",(RemoteObject.createImmutable("Alert_onConfirm()")),0);
 BA.debugLineNum = 173;BA.debugLine="sweet.dismissWithAnimation";
Debug.ShouldStop(4096);
pinchange.mostCurrent._sweet.runVoidMethod ("dismissWithAnimation");
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncancel_click() throws Exception{
try {
		Debug.PushSubsStack("btnCancel_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,227);
if (RapidSub.canDelegate("btncancel_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","btncancel_click");}
 BA.debugLineNum = 227;BA.debugLine="Private Sub btnCancel_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(8);
pinchange.mostCurrent.__c.runVoidMethod ("StartActivity",pinchange.processBA,(Object)((pinchange.mostCurrent._settings.getObject())));
 BA.debugLineNum = 229;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
pinchange.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 230;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btnsave_click() throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,134);
if (RapidSub.canDelegate("btnsave_click")) { ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","btnsave_click"); return;}
ResumableSub_btnSave_Click rsub = new ResumableSub_btnSave_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnSave_Click extends BA.ResumableSub {
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.pinchange parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.pinchange parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,134);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 135;BA.debugLine="sweet.Initialize(\"Alert\")";
Debug.ShouldStop(64);
parent.mostCurrent._sweet.runVoidMethod ("Initialize",pinchange.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Alert")));
 BA.debugLineNum = 136;BA.debugLine="If txtPin.Text.Length<4 Then";
Debug.ShouldStop(128);
if (true) break;

case 1:
//if
this.state = 16;
if (RemoteObject.solveBoolean("<",parent.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
this.state = 3;
}else 
{ BA.debugLineNum = 138;BA.debugLine="else if txtPin.Text <>config.getUserPin Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("!",parent.mostCurrent._txtpin.runMethod(true,"getText"),parent.mostCurrent._config.runMethod(true,"_getuserpin" /*RemoteObject*/ ,pinchange.mostCurrent.activityBA))) { 
this.state = 5;
}else 
{ BA.debugLineNum = 142;BA.debugLine="Else If txtNewPIN.Text.Length<4 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("<",parent.mostCurrent._txtnewpin.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
this.state = 7;
}else 
{ BA.debugLineNum = 145;BA.debugLine="else if txtNewPIN.Text <> txtConfirmNewPIN.Text T";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("!",parent.mostCurrent._txtnewpin.runMethod(true,"getText"),parent.mostCurrent._txtconfirmnewpin.runMethod(true,"getText"))) { 
this.state = 9;
}else {
this.state = 11;
}}}}
if (true) break;

case 3:
//C
this.state = 16;
 BA.debugLineNum = 137;BA.debugLine="lblErrorMsg.Text=\"Please enter current PIN of 4";
Debug.ShouldStop(256);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter current PIN of 4 digits"));
 if (true) break;

case 5:
//C
this.state = 16;
 BA.debugLineNum = 139;BA.debugLine="lblErrorMsg.Text=\"current PIN is invalid\"";
Debug.ShouldStop(1024);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("current PIN is invalid"));
 BA.debugLineNum = 140;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
Debug.ShouldStop(2048);
parent.mostCurrent._txtpin.runMethod(true,"setSelectionStart",parent.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 141;BA.debugLine="txtPin.RequestFocus";
Debug.ShouldStop(4096);
parent.mostCurrent._txtpin.runVoidMethod ("RequestFocus");
 if (true) break;

case 7:
//C
this.state = 16;
 BA.debugLineNum = 143;BA.debugLine="lblErrorMsg2.Text=\"Please enter new PIN of 4 dig";
Debug.ShouldStop(16384);
parent.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter new PIN of 4 digits"));
 BA.debugLineNum = 144;BA.debugLine="txtNewPIN.RequestFocus";
Debug.ShouldStop(32768);
parent.mostCurrent._txtnewpin.runVoidMethod ("RequestFocus");
 if (true) break;

case 9:
//C
this.state = 16;
 BA.debugLineNum = 146;BA.debugLine="lblErrorMsg3.Text =\"New PIN and confirm PIN mism";
Debug.ShouldStop(131072);
parent.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
 BA.debugLineNum = 147;BA.debugLine="txtConfirmNewPIN.RequestFocus";
Debug.ShouldStop(262144);
parent.mostCurrent._txtconfirmnewpin.runVoidMethod ("RequestFocus");
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 149;BA.debugLine="config.setUserPin(txtNewPIN.Text)";
Debug.ShouldStop(1048576);
parent.mostCurrent._config.runVoidMethod ("_setuserpin" /*RemoteObject*/ ,pinchange.mostCurrent.activityBA,(Object)(parent.mostCurrent._txtnewpin.runMethod(true,"getText")));
 BA.debugLineNum = 150;BA.debugLine="Msgbox2Async(\"PIN updated successfully!\",\"PIN up";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("PIN updated successfully!")),(Object)(BA.ObjectToCharSequence("PIN updated")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("icons8-success-100.png")))),pinchange.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 151;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", pinchange.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "pinchange", "btnsave_click"), null);
this.state = 17;
return;
case 17:
//C
this.state = 12;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 152;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(8388608);
if (true) break;

case 12:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 153;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",pinchange.processBA,(Object)((parent.mostCurrent._settings.getObject())));
 BA.debugLineNum = 154;BA.debugLine="Activity.Finish";
Debug.ShouldStop(33554432);
parent.mostCurrent._activity.runVoidMethod ("Finish");
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
 BA.debugLineNum = 159;BA.debugLine="End Sub";
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
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _clearform() throws Exception{
try {
		Debug.PushSubsStack("clearForm (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,72);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","clearform");}
 BA.debugLineNum = 72;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="txtPin.Text=\"\"";
Debug.ShouldStop(256);
pinchange.mostCurrent._txtpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 74;BA.debugLine="txtNewPIN.Text=\"\"";
Debug.ShouldStop(512);
pinchange.mostCurrent._txtnewpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 75;BA.debugLine="txtConfirmNewPIN.Text=\"\"";
Debug.ShouldStop(1024);
pinchange.mostCurrent._txtconfirmnewpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 76;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(2048);
pinchange.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 77;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(4096);
pinchange.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 78;BA.debugLine="lblErrorMsg3.Text=\"\"";
Debug.ShouldStop(8192);
pinchange.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 79;BA.debugLine="lblShowPswd.Text  = config.hide";
Debug.ShouldStop(16384);
pinchange.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 80;BA.debugLine="lblShowPswd2.Text = config.hide";
Debug.ShouldStop(32768);
pinchange.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 81;BA.debugLine="lblShowPswd3.Text = config.hide";
Debug.ShouldStop(65536);
pinchange.mostCurrent._lblshowpswd3.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 82;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(131072);
pinchange.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 83;BA.debugLine="txtPin.RequestFocus";
Debug.ShouldStop(262144);
pinchange.mostCurrent._txtpin.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 16;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
pinchange.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ToolbarHelper As ACActionBar";
pinchange.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 18;BA.debugLine="Dim SharedPrefs As SharedPreferences";
pinchange.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 20;BA.debugLine="Private imgIcon As ImageView";
pinchange.mostCurrent._imgicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lblErrorMsg As Label";
pinchange.mostCurrent._lblerrormsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lblErrorMsg2 As Label";
pinchange.mostCurrent._lblerrormsg2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblErrorMsg3 As Label";
pinchange.mostCurrent._lblerrormsg3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlContainer As Panel";
pinchange.mostCurrent._pnlcontainer = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtPin As EditText";
pinchange.mostCurrent._txtpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private btnSave As Button";
pinchange.mostCurrent._btnsave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim sweet As SweetAlertDialog";
pinchange.mostCurrent._sweet = RemoteObject.createNew ("de.donmanfred.SweetAlertDialogWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim IME As IME";
pinchange.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 33;BA.debugLine="Private ImageView1 As ImageView";
pinchange.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private ImageView2 As ImageView";
pinchange.mostCurrent._imageview2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblShowPswd As Label";
pinchange.mostCurrent._lblshowpswd = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblShowPswd2 As Label";
pinchange.mostCurrent._lblshowpswd2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblShowPswd3 As Label";
pinchange.mostCurrent._lblshowpswd3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private txtConfirmNewPIN As EditText";
pinchange.mostCurrent._txtconfirmnewpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private txtNewPIN As EditText";
pinchange.mostCurrent._txtnewpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private User_img As ImageView";
pinchange.mostCurrent._user_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private User_panel As Panel";
pinchange.mostCurrent._user_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private btnCancel As Button";
pinchange.mostCurrent._btncancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblshowpassword_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,86);
if (RapidSub.canDelegate("lblshowpassword_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","lblshowpassword_click");}
 BA.debugLineNum = 86;BA.debugLine="Private Sub lblShowPassword_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="If lblShowPswd.Text=config.hide Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",pinchange.mostCurrent._lblshowpswd.runMethod(true,"getText"),BA.ObjectToString(pinchange.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 88;BA.debugLine="lblShowPswd.Text=config.show";
Debug.ShouldStop(8388608);
pinchange.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 89;BA.debugLine="txtPin.PasswordMode=False";
Debug.ShouldStop(16777216);
pinchange.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 91;BA.debugLine="lblShowPswd.Text=config.hide";
Debug.ShouldStop(67108864);
pinchange.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 92;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(134217728);
pinchange.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 94;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
Debug.ShouldStop(536870912);
pinchange.mostCurrent._txtpin.runMethod(true,"setSelectionStart",pinchange.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblshowpassword2_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword2_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,97);
if (RapidSub.canDelegate("lblshowpassword2_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","lblshowpassword2_click");}
 BA.debugLineNum = 97;BA.debugLine="Private Sub lblShowPassword2_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",pinchange.mostCurrent._lblshowpswd2.runMethod(true,"getText"),BA.ObjectToString(pinchange.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 99;BA.debugLine="lblShowPswd2.Text=config.show";
Debug.ShouldStop(4);
pinchange.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 100;BA.debugLine="txtNewPIN.PasswordMode=False";
Debug.ShouldStop(8);
pinchange.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 102;BA.debugLine="lblShowPswd2.Text=config.hide";
Debug.ShouldStop(32);
pinchange.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 103;BA.debugLine="txtNewPIN.PasswordMode=True";
Debug.ShouldStop(64);
pinchange.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 105;BA.debugLine="txtNewPIN.SelectionStart=txtNewPIN.Text.Length";
Debug.ShouldStop(256);
pinchange.mostCurrent._txtnewpin.runMethod(true,"setSelectionStart",pinchange.mostCurrent._txtnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblshowpassword3_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword3_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,108);
if (RapidSub.canDelegate("lblshowpassword3_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","lblshowpassword3_click");}
 BA.debugLineNum = 108;BA.debugLine="Private Sub lblShowPassword3_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="If lblShowPswd3.Text=config.hide Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",pinchange.mostCurrent._lblshowpswd3.runMethod(true,"getText"),BA.ObjectToString(pinchange.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 110;BA.debugLine="lblShowPswd3.Text=config.show";
Debug.ShouldStop(8192);
pinchange.mostCurrent._lblshowpswd3.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 111;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
Debug.ShouldStop(16384);
pinchange.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 113;BA.debugLine="lblShowPswd3.Text=config.hide";
Debug.ShouldStop(65536);
pinchange.mostCurrent._lblshowpswd3.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 114;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
Debug.ShouldStop(131072);
pinchange.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 116;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
Debug.ShouldStop(524288);
pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"setSelectionStart",pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblshowpswd_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPswd_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,193);
if (RapidSub.canDelegate("lblshowpswd_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","lblshowpswd_click");}
 BA.debugLineNum = 193;BA.debugLine="Private Sub lblShowPswd_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="If lblShowPswd.Text=config.hide Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",pinchange.mostCurrent._lblshowpswd.runMethod(true,"getText"),BA.ObjectToString(pinchange.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 195;BA.debugLine="lblShowPswd.Text=config.show";
Debug.ShouldStop(4);
pinchange.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 196;BA.debugLine="txtPin.PasswordMode=False";
Debug.ShouldStop(8);
pinchange.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 198;BA.debugLine="lblShowPswd.Text=config.hide";
Debug.ShouldStop(32);
pinchange.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 199;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(64);
pinchange.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 201;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
Debug.ShouldStop(256);
pinchange.mostCurrent._txtpin.runMethod(true,"setSelectionStart",pinchange.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblshowpswd2_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPswd2_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,205);
if (RapidSub.canDelegate("lblshowpswd2_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","lblshowpswd2_click");}
 BA.debugLineNum = 205;BA.debugLine="Private Sub lblShowPswd2_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",pinchange.mostCurrent._lblshowpswd2.runMethod(true,"getText"),BA.ObjectToString(pinchange.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 207;BA.debugLine="lblShowPswd2.Text=config.show";
Debug.ShouldStop(16384);
pinchange.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 208;BA.debugLine="txtNewPIN.PasswordMode=False";
Debug.ShouldStop(32768);
pinchange.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 210;BA.debugLine="lblShowPswd2.Text=config.hide";
Debug.ShouldStop(131072);
pinchange.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 211;BA.debugLine="txtNewPIN.PasswordMode=True";
Debug.ShouldStop(262144);
pinchange.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 213;BA.debugLine="txtNewPIN.SelectionStart=txtNewPIN.Text.Length";
Debug.ShouldStop(1048576);
pinchange.mostCurrent._txtnewpin.runMethod(true,"setSelectionStart",pinchange.mostCurrent._txtnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblshowpswd3_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPswd3_Click (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,216);
if (RapidSub.canDelegate("lblshowpswd3_click")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","lblshowpswd3_click");}
 BA.debugLineNum = 216;BA.debugLine="Private Sub lblShowPswd3_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="If lblShowPswd3.Text=config.hide Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",pinchange.mostCurrent._lblshowpswd3.runMethod(true,"getText"),BA.ObjectToString(pinchange.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 218;BA.debugLine="lblShowPswd3.Text=config.show";
Debug.ShouldStop(33554432);
pinchange.mostCurrent._lblshowpswd3.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 219;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
Debug.ShouldStop(67108864);
pinchange.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 221;BA.debugLine="lblShowPswd3.Text=config.hide";
Debug.ShouldStop(268435456);
pinchange.mostCurrent._lblshowpswd3.runMethod(true,"setText",BA.ObjectToCharSequence(pinchange.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 222;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
Debug.ShouldStop(536870912);
pinchange.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinchange.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 224;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
Debug.ShouldStop(-2147483648);
pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"setSelectionStart",pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _txtconfirmnewpin_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtConfirmNewPIN_TextChanged (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,184);
if (RapidSub.canDelegate("txtconfirmnewpin_textchanged")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","txtconfirmnewpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 184;BA.debugLine="Private Sub txtConfirmNewPIN_TextChanged (Old As S";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 185;BA.debugLine="If txtNewPIN.Text <> txtConfirmNewPIN.Text Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("!",pinchange.mostCurrent._txtnewpin.runMethod(true,"getText"),pinchange.mostCurrent._txtconfirmnewpin.runMethod(true,"getText"))) { 
 BA.debugLineNum = 186;BA.debugLine="lblErrorMsg3.Text=\"New PIN and confirm PIN misma";
Debug.ShouldStop(33554432);
pinchange.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
 }else {
 BA.debugLineNum = 188;BA.debugLine="lblErrorMsg3.Text=\"\"";
Debug.ShouldStop(134217728);
pinchange.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtnewpin_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtNewPIN_TextChanged (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,180);
if (RapidSub.canDelegate("txtnewpin_textchanged")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","txtnewpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 180;BA.debugLine="Private Sub txtNewPIN_TextChanged (Old As String,";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(1048576);
pinchange.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtpin_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtPin_TextChanged (pinchange) ","pinchange",12,pinchange.mostCurrent.activityBA,pinchange.mostCurrent,176);
if (RapidSub.canDelegate("txtpin_textchanged")) { return ng.dsoftlab.stegocam.pinchange.remoteMe.runUserSub(false, "pinchange","txtpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 176;BA.debugLine="Private Sub txtPin_TextChanged (Old As String, New";
Debug.ShouldStop(32768);
 BA.debugLineNum = 177;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(65536);
pinchange.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}