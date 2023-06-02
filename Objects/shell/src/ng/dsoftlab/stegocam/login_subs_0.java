package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class login_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","activity_create", _firsttime);}
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"login\")";
Debug.ShouldStop(8);
login.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("login")),login.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(16);
login.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 38;BA.debugLine="txtPin.InputType=Bit.Or(txtPin.InputType, 2)";
Debug.ShouldStop(32);
login.mostCurrent._txtpin.runMethod(true,"setInputType",login.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(login.mostCurrent._txtpin.runMethod(true,"getInputType")),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 39;BA.debugLine="IME.Initialize(\"IME\")";
Debug.ShouldStop(64);
login.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("IME")));
 BA.debugLineNum = 40;BA.debugLine="IME.SetLengthFilter(txtPin,4)";
Debug.ShouldStop(128);
login.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((login.mostCurrent._txtpin.getObject())),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 41;BA.debugLine="clearForm";
Debug.ShouldStop(256);
_clearform();
 BA.debugLineNum = 42;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(512);
login.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",login.mostCurrent.activityBA);
 BA.debugLineNum = 43;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(1024);
login.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",login.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 44;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(2048);
login.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 45;BA.debugLine="txtPin.Text=\"\"";
Debug.ShouldStop(4096);
login.mostCurrent._txtpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 46;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(8192);
login.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 48;BA.debugLine="Biometric.Initialize(Me, \"Authenticate\")";
Debug.ShouldStop(32768);
login._biometric.runClassMethod (ng.dsoftlab.stegocam.biometricmanager.class, "_initialize" /*RemoteObject*/ ,login.processBA,(Object)(login.getObject()),(Object)(RemoteObject.createImmutable("Authenticate")));
 BA.debugLineNum = 49;BA.debugLine="Dim res As String = Biometric.CanAuthenticate";
Debug.ShouldStop(65536);
_res = login._biometric.runClassMethod (ng.dsoftlab.stegocam.biometricmanager.class, "_canauthenticate" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 50;BA.debugLine="If res = \"SUCCESS\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_res,BA.ObjectToString("SUCCESS"))) { 
 BA.debugLineNum = 51;BA.debugLine="Label3.Visible=True";
Debug.ShouldStop(262144);
login.mostCurrent._label3.runMethod(true,"setVisible",login.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 52;BA.debugLine="imgFingerprint.Visible=True";
Debug.ShouldStop(524288);
login.mostCurrent._imgfingerprint.runMethod(true,"setVisible",login.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 54;BA.debugLine="Label3.Visible=False";
Debug.ShouldStop(2097152);
login.mostCurrent._label3.runMethod(true,"setVisible",login.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 55;BA.debugLine="imgFingerprint.Visible=False";
Debug.ShouldStop(4194304);
login.mostCurrent._imgfingerprint.runMethod(true,"setVisible",login.mostCurrent.__c.getField(true,"False"));
 };
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,80);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 80;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, login.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 83;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
login.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 85;BA.debugLine="Return False";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return login.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_Pause (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,70);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,66);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","activity_resume");}
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,75);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 75;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
login.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnresetpin_click() throws Exception{
try {
		Debug.PushSubsStack("btnResetPin_Click (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,138);
if (RapidSub.canDelegate("btnresetpin_click")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","btnresetpin_click");}
 BA.debugLineNum = 138;BA.debugLine="Private Sub btnResetPin_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="StartActivity(forgotpin)";
Debug.ShouldStop(1024);
login.mostCurrent.__c.runVoidMethod ("StartActivity",login.processBA,(Object)((login.mostCurrent._forgotpin.getObject())));
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsignin_click() throws Exception{
try {
		Debug.PushSubsStack("btnSignin_Click (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,106);
if (RapidSub.canDelegate("btnsignin_click")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","btnsignin_click");}
RemoteObject _curpin = RemoteObject.createImmutable("");
 BA.debugLineNum = 106;BA.debugLine="Private Sub btnSignin_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 109;BA.debugLine="userPin = config.getUserPin";
Debug.ShouldStop(4096);
login.mostCurrent._userpin = login.mostCurrent._config.runMethod(true,"_getuserpin" /*RemoteObject*/ ,login.mostCurrent.activityBA);
 BA.debugLineNum = 111;BA.debugLine="Dim curPIN As String = txtPin.Text";
Debug.ShouldStop(16384);
_curpin = login.mostCurrent._txtpin.runMethod(true,"getText");Debug.locals.put("curPIN", _curpin);Debug.locals.put("curPIN", _curpin);
 BA.debugLineNum = 112;BA.debugLine="If curPIN=\"\" Or curPIN.Length<4 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_curpin,BA.ObjectToString("")) || RemoteObject.solveBoolean("<",_curpin.runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 113;BA.debugLine="lblErrorMsg.Text=\"Please enter 4 digits PIN\"";
Debug.ShouldStop(65536);
login.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter 4 digits PIN"));
 }else 
{ BA.debugLineNum = 114;BA.debugLine="Else if curPIN=userPin Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_curpin,login.mostCurrent._userpin)) { 
 BA.debugLineNum = 115;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
login.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 116;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(524288);
login.mostCurrent.__c.runVoidMethod ("StartActivity",login.processBA,(Object)((login.mostCurrent._mainmenu.getObject())));
 }else {
 BA.debugLineNum = 118;BA.debugLine="lblErrorMsg.Text=\"Invalid PIN\"";
Debug.ShouldStop(2097152);
login.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Invalid PIN"));
 }}
;
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clearform() throws Exception{
try {
		Debug.PushSubsStack("clearForm (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,60);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","clearform");}
 BA.debugLineNum = 60;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="txtPin.Text=\"\"";
Debug.ShouldStop(268435456);
login.mostCurrent._txtpin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 62;BA.debugLine="lblShowPassword.Text=config.hide";
Debug.ShouldStop(536870912);
login.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(login.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 63;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(1073741824);
login.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",login.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 64;BA.debugLine="txtPin.RequestFocus";
Debug.ShouldStop(-2147483648);
login.mostCurrent._txtpin.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 16;BA.debugLine="Private btnResetPin As Label";
login.mostCurrent._btnresetpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private btnSignin As B4XView";
login.mostCurrent._btnsignin = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private imgFingerprint As B4XView";
login.mostCurrent._imgfingerprint = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private imgIcon As B4XView";
login.mostCurrent._imgicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lblShowPassword As B4XView";
login.mostCurrent._lblshowpassword = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txtPin As EditText";
login.mostCurrent._txtpin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Label3 As B4XView";
login.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim userPin As String";
login.mostCurrent._userpin = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Dim SharedPrefs As SharedPreferences";
login.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 27;BA.debugLine="Private lblErrorMsg As B4XView";
login.mostCurrent._lblerrormsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim IME As IME";
login.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 29;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
login.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private ToolbarHelper As ACActionBar";
login.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _imgfingerprint_click() throws Exception{
try {
		Debug.PushSubsStack("imgFingerprint_Click (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,88);
if (RapidSub.canDelegate("imgfingerprint_click")) { ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","imgfingerprint_click"); return;}
ResumableSub_imgFingerprint_Click rsub = new ResumableSub_imgFingerprint_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_imgFingerprint_Click extends BA.ResumableSub {
public ResumableSub_imgFingerprint_Click(ng.dsoftlab.stegocam.login parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.login parent;
RemoteObject _fingerprintenabled = RemoteObject.createImmutable(false);
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _errormessage = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("imgFingerprint_Click (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,88);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 89;BA.debugLine="Dim fingerPrintEnabled As Boolean=config.getBiome";
Debug.ShouldStop(16777216);
_fingerprintenabled = parent.mostCurrent._config.runMethod(true,"_getbiometric" /*RemoteObject*/ ,login.mostCurrent.activityBA);Debug.locals.put("fingerPrintEnabled", _fingerprintenabled);Debug.locals.put("fingerPrintEnabled", _fingerprintenabled);
 BA.debugLineNum = 91;BA.debugLine="If fingerPrintEnabled=True Then";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",_fingerprintenabled,parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 3;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 92;BA.debugLine="Biometric.Show(\"Verifying Finegerprint\")";
Debug.ShouldStop(134217728);
parent._biometric.runClassMethod (ng.dsoftlab.stegocam.biometricmanager.class, "_show" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("Verifying Finegerprint")));
 BA.debugLineNum = 93;BA.debugLine="Wait For Authenticate_Complete (Success As Boole";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","authenticate_complete", login.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "login", "imgfingerprint_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 4;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_errormessage = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("ErrorMessage", _errormessage);
;
 BA.debugLineNum = 94;BA.debugLine="If Success Then";
Debug.ShouldStop(536870912);
if (true) break;

case 4:
//if
this.state = 9;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 95;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 96;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",login.processBA,(Object)((parent.mostCurrent._mainmenu.getObject())));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 99;BA.debugLine="ToastMessageShow(\"Error: \" & ErrorMessage,False";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_errormessage))),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 9:
//C
this.state = 12;
;
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 102;BA.debugLine="Msgbox2Async(\"Fingerprint login is not available";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Fingerprint login is not available for this account. You can change this in the settings page after login")),(Object)(BA.ObjectToCharSequence("Notice")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),login.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
public static void  _authenticate_complete(RemoteObject _success,RemoteObject _errormessage) throws Exception{
}
public static RemoteObject  _lblshowpassword_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword_Click (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,122);
if (RapidSub.canDelegate("lblshowpassword_click")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","lblshowpassword_click");}
 BA.debugLineNum = 122;BA.debugLine="Private Sub lblShowPassword_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="If lblShowPassword.Text=config.hide Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",login.mostCurrent._lblshowpassword.runMethod(true,"getText"),BA.ObjectToString(login.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 124;BA.debugLine="lblShowPassword.Text=config.show";
Debug.ShouldStop(134217728);
login.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(login.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 125;BA.debugLine="txtPin.PasswordMode=False";
Debug.ShouldStop(268435456);
login.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",login.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 127;BA.debugLine="lblShowPassword.Text=config.hide";
Debug.ShouldStop(1073741824);
login.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(login.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 128;BA.debugLine="txtPin.PasswordMode=True";
Debug.ShouldStop(-2147483648);
login.mostCurrent._txtpin.runVoidMethod ("setPasswordMode",login.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 130;BA.debugLine="txtPin.SelectionStart=txtPin.Text.Length";
Debug.ShouldStop(2);
login.mostCurrent._txtpin.runMethod(true,"setSelectionStart",login.mostCurrent._txtpin.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
login._biometric = RemoteObject.createNew ("ng.dsoftlab.stegocam.biometricmanager");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _txtpin_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtPin_TextChanged (login) ","login",11,login.mostCurrent.activityBA,login.mostCurrent,133);
if (RapidSub.canDelegate("txtpin_textchanged")) { return ng.dsoftlab.stegocam.login.remoteMe.runUserSub(false, "login","txtpin_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 133;BA.debugLine="Private Sub txtPin_TextChanged (Old As String, New";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(32);
login.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
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
}