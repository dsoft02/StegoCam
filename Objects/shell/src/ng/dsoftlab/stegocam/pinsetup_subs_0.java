package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pinsetup_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"pinsetup\")";
Debug.ShouldStop(64);
pinsetup.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("pinsetup")),pinsetup.mostCurrent.activityBA);
 BA.debugLineNum = 41;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(256);
pinsetup.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 42;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(512);
pinsetup.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",pinsetup.mostCurrent.activityBA);
 BA.debugLineNum = 43;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(1024);
pinsetup.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",pinsetup.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 44;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(2048);
pinsetup.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 45;BA.debugLine="txtPin.InputType=Bit.Or(txtPin.InputType, 2)";
Debug.ShouldStop(4096);
pinsetup.mostCurrent._txtpin.runMethod(true,"setInputType",pinsetup.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(pinsetup.mostCurrent._txtpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 46;BA.debugLine="IME.Initialize(\"IME\")";
Debug.ShouldStop(8192);
pinsetup.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("IME")));
 BA.debugLineNum = 47;BA.debugLine="IME.SetLengthFilter(txtPin,4)";
Debug.ShouldStop(16384);
pinsetup.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((pinsetup.mostCurrent._txtpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 48;BA.debugLine="clearForm";
Debug.ShouldStop(32768);
_clearform();
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_KeyPress (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,89);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 89;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, pinsetup.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 92;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
pinsetup.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 93;BA.debugLine="Return True";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return pinsetup.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 95;BA.debugLine="Return False";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return pinsetup.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,56);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Resume (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,52);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","activity_resume");}
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,84);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 84;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="ExitApplication";
Debug.ShouldStop(1048576);
pinsetup.mostCurrent.__c.runVoidMethod ("ExitApplication");
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
public static RemoteObject  _alert_oncancel() throws Exception{
try {
		Debug.PushSubsStack("Alert_onCancel (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,125);
if (RapidSub.canDelegate("alert_oncancel")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","alert_oncancel");}
 BA.debugLineNum = 125;BA.debugLine="Sub Alert_onCancel()";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Log($\"Alert_onCancel()\"$)";
Debug.ShouldStop(536870912);
pinsetup.mostCurrent.__c.runVoidMethod ("LogImpl","743188225",(RemoteObject.createImmutable("Alert_onCancel()")),0);
 BA.debugLineNum = 127;BA.debugLine="sweet.AlertType = sweet.TypeError";
Debug.ShouldStop(1073741824);
pinsetup.mostCurrent._sweet.runMethod(true,"setAlertType",pinsetup.mostCurrent._sweet.runMethod(true,"getTypeError"));
 BA.debugLineNum = 129;BA.debugLine="sweet.dismissWithAnimation";
Debug.ShouldStop(1);
pinsetup.mostCurrent._sweet.runVoidMethod ("dismissWithAnimation");
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Alert_onConfirm (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,131);
if (RapidSub.canDelegate("alert_onconfirm")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","alert_onconfirm");}
 BA.debugLineNum = 131;BA.debugLine="Sub Alert_onConfirm()";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="Log($\"Alert_onConfirm()\"$)";
Debug.ShouldStop(8);
pinsetup.mostCurrent.__c.runVoidMethod ("LogImpl","743253761",(RemoteObject.createImmutable("Alert_onConfirm()")),0);
 BA.debugLineNum = 134;BA.debugLine="sweet.dismissWithAnimation";
Debug.ShouldStop(32);
pinsetup.mostCurrent._sweet.runVoidMethod ("dismissWithAnimation");
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("btnSave_Click (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,99);
if (RapidSub.canDelegate("btnsave_click")) { ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","btnsave_click"); return;}
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
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.pinsetup parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.pinsetup parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,99);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 100;BA.debugLine="sweet.Initialize(\"Alert\")";
Debug.ShouldStop(8);
parent.mostCurrent._sweet.runVoidMethod ("Initialize",pinsetup.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Alert")));
 BA.debugLineNum = 101;BA.debugLine="If txtPin.Text.Length<4 Then";
Debug.ShouldStop(16);
if (true) break;

case 1:
//if
this.state = 14;
if (RemoteObject.solveBoolean("<",parent.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
this.state = 3;
}else 
{ BA.debugLineNum = 103;BA.debugLine="Else If txtQuestion.Text=\"\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txtquestion.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 5;
}else 
{ BA.debugLineNum = 105;BA.debugLine="Else If txtAnswer.Text=\"\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txtanswer.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 7;
}else {
this.state = 9;
}}}
if (true) break;

case 3:
//C
this.state = 14;
 BA.debugLineNum = 102;BA.debugLine="lblErrorMsg.Text=\"Please enter 4 digits\"";
Debug.ShouldStop(32);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter 4 digits"));
 if (true) break;

case 5:
//C
this.state = 14;
 BA.debugLineNum = 104;BA.debugLine="lblErrorMsg2.Text=\"Please enter security questio";
Debug.ShouldStop(128);
parent.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter security question"));
 if (true) break;

case 7:
//C
this.state = 14;
 BA.debugLineNum = 106;BA.debugLine="lblErrorMsg3.Text =\"Please enter security answer";
Debug.ShouldStop(512);
parent.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter security answer"));
 if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 108;BA.debugLine="config.setUserPin(txtPin.Text)";
Debug.ShouldStop(2048);
parent.mostCurrent._config.runVoidMethod ("_setuserpin" /*RemoteObject*/ ,pinsetup.mostCurrent.activityBA,(Object)(parent.mostCurrent._txtpin.runMethod(true,"getText")));
 BA.debugLineNum = 109;BA.debugLine="config.saveSecurityQA(txtQuestion.Text,txtAnswer";
Debug.ShouldStop(4096);
parent.mostCurrent._config.runVoidMethod ("_savesecurityqa" /*RemoteObject*/ ,pinsetup.mostCurrent.activityBA,(Object)(parent.mostCurrent._txtquestion.runMethod(true,"getText")),(Object)(parent.mostCurrent._txtanswer.runMethod(true,"getText")));
 BA.debugLineNum = 110;BA.debugLine="Msgbox2Async(\"PIN updated successfully!\",\"PIN up";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("PIN updated successfully!")),(Object)(BA.ObjectToCharSequence("PIN updated")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("icons8-success-100.png")))),pinsetup.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 111;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", pinsetup.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "pinsetup", "btnsave_click"), null);
this.state = 15;
return;
case 15:
//C
this.state = 10;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 112;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(32768);
if (true) break;

case 10:
//if
this.state = 13;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 113;BA.debugLine="StartActivity(Login)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",pinsetup.processBA,(Object)((parent.mostCurrent._login.getObject())));
 BA.debugLineNum = 114;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
parent.mostCurrent._activity.runVoidMethod ("Finish");
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
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("clearForm (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,60);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","clearform");}
 BA.debugLineNum = 60;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="txtPin.Text=\"\"";
Debug.ShouldStop(268435456);
pinsetup.mostCurrent._txtpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 62;BA.debugLine="txtQuestion.Text=\"\"";
Debug.ShouldStop(536870912);
pinsetup.mostCurrent._txtquestion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 63;BA.debugLine="txtAnswer.Text=\"\"";
Debug.ShouldStop(1073741824);
pinsetup.mostCurrent._txtanswer.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 64;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(-2147483648);
pinsetup.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 65;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(1);
pinsetup.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 66;BA.debugLine="lblErrorMsg3.Text=\"\"";
Debug.ShouldStop(2);
pinsetup.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 67;BA.debugLine="lblShowPassword.Text=config.hide";
Debug.ShouldStop(4);
pinsetup.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(pinsetup.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 68;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(8);
pinsetup.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinsetup.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 69;BA.debugLine="txtPin.RequestFocus";
Debug.ShouldStop(16);
pinsetup.mostCurrent._txtpin.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
pinsetup.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ToolbarHelper As ACActionBar";
pinsetup.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 19;BA.debugLine="Private imgIcon As B4XView";
pinsetup.mostCurrent._imgicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lblErrorMsg As B4XView";
pinsetup.mostCurrent._lblerrormsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lblErrorMsg2 As B4XView";
pinsetup.mostCurrent._lblerrormsg2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lblErrorMsg3 As B4XView";
pinsetup.mostCurrent._lblerrormsg3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblShowPassword As B4XView";
pinsetup.mostCurrent._lblshowpassword = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlContainer As B4XView";
pinsetup.mostCurrent._pnlcontainer = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtAnswer As EditText";
pinsetup.mostCurrent._txtanswer = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private txtPin As EditText";
pinsetup.mostCurrent._txtpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtQuestion As EditText";
pinsetup.mostCurrent._txtquestion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private btnSave As B4XView";
pinsetup.mostCurrent._btnsave = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim SharedPrefs As SharedPreferences";
pinsetup.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 31;BA.debugLine="Dim sweet As SweetAlertDialog";
pinsetup.mostCurrent._sweet = RemoteObject.createNew ("de.donmanfred.SweetAlertDialogWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim IME As IME";
pinsetup.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblshowpassword_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword_Click (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,72);
if (RapidSub.canDelegate("lblshowpassword_click")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","lblshowpassword_click");}
 BA.debugLineNum = 72;BA.debugLine="Private Sub lblShowPassword_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="If lblShowPassword.Text=config.hide Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",pinsetup.mostCurrent._lblshowpassword.runMethod(true,"getText"),BA.ObjectToString(pinsetup.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 74;BA.debugLine="lblShowPassword.Text=config.show";
Debug.ShouldStop(512);
pinsetup.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(pinsetup.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 75;BA.debugLine="txtPin.PasswordMode=False";
Debug.ShouldStop(1024);
pinsetup.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinsetup.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 77;BA.debugLine="lblShowPassword.Text=config.hide";
Debug.ShouldStop(4096);
pinsetup.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(pinsetup.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 78;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(8192);
pinsetup.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",pinsetup.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 80;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
Debug.ShouldStop(32768);
pinsetup.mostCurrent._txtpin.runMethod(true,"setSelectionStart",pinsetup.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
public static RemoteObject  _txtanswer_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtAnswer_TextChanged (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,145);
if (RapidSub.canDelegate("txtanswer_textchanged")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","txtanswer_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 145;BA.debugLine="Private Sub txtAnswer_TextChanged (Old As String,";
Debug.ShouldStop(65536);
 BA.debugLineNum = 146;BA.debugLine="lblErrorMsg3.Text=\"\"";
Debug.ShouldStop(131072);
pinsetup.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("txtPin_TextChanged (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,137);
if (RapidSub.canDelegate("txtpin_textchanged")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","txtpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 137;BA.debugLine="Private Sub txtPin_TextChanged (Old As String, New";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(512);
pinsetup.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
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
public static RemoteObject  _txtquestion_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtQuestion_TextChanged (pinsetup) ","pinsetup",7,pinsetup.mostCurrent.activityBA,pinsetup.mostCurrent,141);
if (RapidSub.canDelegate("txtquestion_textchanged")) { return ng.dsoftlab.stegocam.pinsetup.remoteMe.runUserSub(false, "pinsetup","txtquestion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 141;BA.debugLine="Private Sub txtQuestion_TextChanged (Old As String";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(8192);
pinsetup.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}