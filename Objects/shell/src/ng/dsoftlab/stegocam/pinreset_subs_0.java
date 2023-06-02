package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pinreset_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"pinreset\")";
Debug.ShouldStop(-2147483648);
pinreset.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("pinreset")),pinreset.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(2);
pinreset.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 35;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(4);
pinreset.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",pinreset.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(8);
pinreset.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",pinreset.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 37;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(16);
pinreset.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 38;BA.debugLine="txtNewPin.InputType=Bit.Or(txtNewPin.InputType, 2";
Debug.ShouldStop(32);
pinreset.mostCurrent._txtnewpin.runMethod(true,"setInputType",pinreset.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(pinreset.mostCurrent._txtnewpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 39;BA.debugLine="txtConfirmNewPIN.InputType=Bit.Or(txtConfirmNewPI";
Debug.ShouldStop(64);
pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"setInputType",pinreset.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 40;BA.debugLine="IME.SetLengthFilter(txtNewPin,4)";
Debug.ShouldStop(128);
pinreset.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((pinreset.mostCurrent._txtnewpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 41;BA.debugLine="IME.SetLengthFilter(txtConfirmNewPIN,4)";
Debug.ShouldStop(256);
pinreset.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((pinreset.mostCurrent._txtconfirmnewpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 42;BA.debugLine="clearForm";
Debug.ShouldStop(512);
_clearform();
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_KeyPress (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,94);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 94;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, pinreset.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 96;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(-2147483648);
pinreset.mostCurrent.__c.runVoidMethod ("StartActivity",pinreset.processBA,(Object)((pinreset.mostCurrent._settings.getObject())));
 BA.debugLineNum = 97;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
pinreset.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 98;BA.debugLine="Return True";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return pinreset.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 100;BA.debugLine="Return False";
Debug.ShouldStop(8);
Debug.CheckDeviceExceptions();if (true) return pinreset.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,50);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,46);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","activity_resume");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,89);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 89;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(33554432);
pinreset.mostCurrent.__c.runVoidMethod ("StartActivity",pinreset.processBA,(Object)((pinreset.mostCurrent._settings.getObject())));
 BA.debugLineNum = 91;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
pinreset.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("btnCancel_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,158);
if (RapidSub.canDelegate("btncancel_click")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","btncancel_click");}
 BA.debugLineNum = 158;BA.debugLine="Private Sub btnCancel_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 159;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
pinreset.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("btnSave_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,104);
if (RapidSub.canDelegate("btnsave_click")) { ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","btnsave_click"); return;}
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
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.pinreset parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.pinreset parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,104);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 105;BA.debugLine="If txtNewPin.Text.Length<4 Then";
Debug.ShouldStop(256);
if (true) break;

case 1:
//if
this.state = 12;
if (RemoteObject.solveBoolean("<",parent.mostCurrent._txtnewpin.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
this.state = 3;
}else 
{ BA.debugLineNum = 108;BA.debugLine="else if txtConfirmNewPIN.Text <> txtConfirmNewPIN";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("!",parent.mostCurrent._txtconfirmnewpin.runMethod(true,"getText"),parent.mostCurrent._txtconfirmnewpin.runMethod(true,"getText"))) { 
this.state = 5;
}else {
this.state = 7;
}}
if (true) break;

case 3:
//C
this.state = 12;
 BA.debugLineNum = 106;BA.debugLine="lblErrorMsg.Text=\"Please enter new PIN of 4 digi";
Debug.ShouldStop(512);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter new PIN of 4 digits"));
 BA.debugLineNum = 107;BA.debugLine="txtNewPin.RequestFocus";
Debug.ShouldStop(1024);
parent.mostCurrent._txtnewpin.runVoidMethod ("RequestFocus");
 if (true) break;

case 5:
//C
this.state = 12;
 BA.debugLineNum = 109;BA.debugLine="lblErrorMsg2.Text =\"New PIN and confirm PIN mism";
Debug.ShouldStop(4096);
parent.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
 BA.debugLineNum = 110;BA.debugLine="txtConfirmNewPIN.RequestFocus";
Debug.ShouldStop(8192);
parent.mostCurrent._txtconfirmnewpin.runVoidMethod ("RequestFocus");
 if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 112;BA.debugLine="config.setUserPin(txtNewPin.Text)";
Debug.ShouldStop(32768);
parent.mostCurrent._config.runVoidMethod ("_setuserpin" /*RemoteObject*/ ,pinreset.mostCurrent.activityBA,(Object)(parent.mostCurrent._txtnewpin.runMethod(true,"getText")));
 BA.debugLineNum = 113;BA.debugLine="Msgbox2Async(\"PIN updated successfully!\",\"PIN up";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("PIN updated successfully!")),(Object)(BA.ObjectToCharSequence("PIN updated")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("icons8-success-100.png")))),pinreset.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 114;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", pinreset.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "pinreset", "btnsave_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 8;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 115;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(262144);
if (true) break;

case 8:
//if
this.state = 11;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 116;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
parent.mostCurrent._activity.runVoidMethod ("Finish");
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
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("clearForm (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,54);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","clearform");}
 BA.debugLineNum = 54;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="txtNewPin.Text=\"\"";
Debug.ShouldStop(4194304);
pinreset.mostCurrent._txtnewpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 56;BA.debugLine="txtConfirmNewPIN.Text=\"\"";
Debug.ShouldStop(8388608);
pinreset.mostCurrent._txtconfirmnewpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 57;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(16777216);
pinreset.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 58;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(33554432);
pinreset.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 59;BA.debugLine="lblShowPswd.Text  = config.hide";
Debug.ShouldStop(67108864);
pinreset.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 60;BA.debugLine="lblShowPswd2.Text = config.hide";
Debug.ShouldStop(134217728);
pinreset.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 61;BA.debugLine="txtNewPin.PasswordMode=True";
Debug.ShouldStop(268435456);
pinreset.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 62;BA.debugLine="txtNewPin.RequestFocus";
Debug.ShouldStop(536870912);
pinreset.mostCurrent._txtnewpin.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
pinreset.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ToolbarHelper As ACActionBar";
pinreset.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 18;BA.debugLine="Dim SharedPrefs As SharedPreferences";
pinreset.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 19;BA.debugLine="Dim IME As IME";
pinreset.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 20;BA.debugLine="Private btnCancel As Button";
pinreset.mostCurrent._btncancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btnSave As Button";
pinreset.mostCurrent._btnsave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lblErrorMsg As Label";
pinreset.mostCurrent._lblerrormsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblErrorMsg2 As Label";
pinreset.mostCurrent._lblerrormsg2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lblShowPswd As Label";
pinreset.mostCurrent._lblshowpswd = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lblShowPswd2 As Label";
pinreset.mostCurrent._lblshowpswd2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private txtConfirmNewPIN As EditText";
pinreset.mostCurrent._txtconfirmnewpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtNewPin As EditText";
pinreset.mostCurrent._txtnewpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblshowpassword_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,67);
if (RapidSub.canDelegate("lblshowpassword_click")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","lblshowpassword_click");}
 BA.debugLineNum = 67;BA.debugLine="Private Sub lblShowPassword_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="If lblShowPswd.Text=config.hide Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",pinreset.mostCurrent._lblshowpswd.runMethod(true,"getText"),BA.ObjectToString(pinreset.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 69;BA.debugLine="lblShowPswd.Text=config.show";
Debug.ShouldStop(16);
pinreset.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 70;BA.debugLine="txtNewPin.PasswordMode=False";
Debug.ShouldStop(32);
pinreset.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 72;BA.debugLine="lblShowPswd.Text=config.hide";
Debug.ShouldStop(128);
pinreset.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 73;BA.debugLine="txtNewPin.PasswordMode=True";
Debug.ShouldStop(256);
pinreset.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 75;BA.debugLine="txtNewPin.SelectionStart=txtNewPin.Text.Length";
Debug.ShouldStop(1024);
pinreset.mostCurrent._txtnewpin.runMethod(true,"setSelectionStart",pinreset.mostCurrent._txtnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("lblShowPassword2_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,78);
if (RapidSub.canDelegate("lblshowpassword2_click")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","lblshowpassword2_click");}
 BA.debugLineNum = 78;BA.debugLine="Private Sub lblShowPassword2_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",pinreset.mostCurrent._lblshowpswd2.runMethod(true,"getText"),BA.ObjectToString(pinreset.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 80;BA.debugLine="lblShowPswd2.Text=config.show";
Debug.ShouldStop(32768);
pinreset.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 81;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
Debug.ShouldStop(65536);
pinreset.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 83;BA.debugLine="lblShowPswd2.Text=config.hide";
Debug.ShouldStop(262144);
pinreset.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 84;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
Debug.ShouldStop(524288);
pinreset.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 86;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
Debug.ShouldStop(2097152);
pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"setSelectionStart",pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"getText").runMethod(true,"length"));
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
public static RemoteObject  _lblshowpswd_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPswd_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,135);
if (RapidSub.canDelegate("lblshowpswd_click")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","lblshowpswd_click");}
 BA.debugLineNum = 135;BA.debugLine="Private Sub lblShowPswd_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 136;BA.debugLine="If lblShowPswd.Text=config.hide Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",pinreset.mostCurrent._lblshowpswd.runMethod(true,"getText"),BA.ObjectToString(pinreset.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 137;BA.debugLine="lblShowPswd.Text=config.show";
Debug.ShouldStop(256);
pinreset.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 138;BA.debugLine="txtNewPin.PasswordMode=False";
Debug.ShouldStop(512);
pinreset.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 140;BA.debugLine="lblShowPswd.Text=config.hide";
Debug.ShouldStop(2048);
pinreset.mostCurrent._lblshowpswd.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 141;BA.debugLine="txtNewPin.PasswordMode=True";
Debug.ShouldStop(4096);
pinreset.mostCurrent._txtnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 143;BA.debugLine="txtNewPin.SelectionStart=txtNewPin.Text.Length";
Debug.ShouldStop(16384);
pinreset.mostCurrent._txtnewpin.runMethod(true,"setSelectionStart",pinreset.mostCurrent._txtnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("lblShowPswd2_Click (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,147);
if (RapidSub.canDelegate("lblshowpswd2_click")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","lblshowpswd2_click");}
 BA.debugLineNum = 147;BA.debugLine="Private Sub lblShowPswd2_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="If lblShowPswd2.Text=config.hide Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",pinreset.mostCurrent._lblshowpswd2.runMethod(true,"getText"),BA.ObjectToString(pinreset.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 149;BA.debugLine="lblShowPswd2.Text=config.show";
Debug.ShouldStop(1048576);
pinreset.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 150;BA.debugLine="txtConfirmNewPIN.PasswordMode=False";
Debug.ShouldStop(2097152);
pinreset.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 152;BA.debugLine="lblShowPswd2.Text=config.hide";
Debug.ShouldStop(8388608);
pinreset.mostCurrent._lblshowpswd2.runMethod(true,"setText",BA.ObjectToCharSequence(pinreset.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 153;BA.debugLine="txtConfirmNewPIN.PasswordMode=True";
Debug.ShouldStop(16777216);
pinreset.mostCurrent._txtconfirmnewpin.runVoidMethod ("setPasswordMode",pinreset.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 155;BA.debugLine="txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.";
Debug.ShouldStop(67108864);
pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"setSelectionStart",pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("txtConfirmNewPIN_TextChanged (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,126);
if (RapidSub.canDelegate("txtconfirmnewpin_textchanged")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","txtconfirmnewpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 126;BA.debugLine="Private Sub txtConfirmNewPIN_TextChanged (Old As S";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="If txtNewPin.Text <> txtConfirmNewPIN.Text Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("!",pinreset.mostCurrent._txtnewpin.runMethod(true,"getText"),pinreset.mostCurrent._txtconfirmnewpin.runMethod(true,"getText"))) { 
 BA.debugLineNum = 128;BA.debugLine="lblErrorMsg2.Text=\"New PIN and confirm PIN misma";
Debug.ShouldStop(-2147483648);
pinreset.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence("New PIN and confirm PIN mismatch"));
 }else {
 BA.debugLineNum = 130;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(2);
pinreset.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("txtNewPIN_TextChanged (pinreset) ","pinreset",13,pinreset.mostCurrent.activityBA,pinreset.mostCurrent,122);
if (RapidSub.canDelegate("txtnewpin_textchanged")) { return ng.dsoftlab.stegocam.pinreset.remoteMe.runUserSub(false, "pinreset","txtnewpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 122;BA.debugLine="Private Sub txtNewPIN_TextChanged (Old As String,";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(67108864);
pinreset.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}