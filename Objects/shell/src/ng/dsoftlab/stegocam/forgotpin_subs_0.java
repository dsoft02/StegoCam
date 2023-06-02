package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class forgotpin_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"forgotpin\")";
Debug.ShouldStop(1073741824);
forgotpin.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("forgotpin")),forgotpin.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(-2147483648);
forgotpin.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 33;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(1);
forgotpin.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",forgotpin.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(2);
forgotpin.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",forgotpin.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 35;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(4);
forgotpin.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 36;BA.debugLine="clearForm";
Debug.ShouldStop(8);
_clearform();
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_KeyPress (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,51);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, forgotpin.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 53;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
forgotpin.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 54;BA.debugLine="Return True";
Debug.ShouldStop(2097152);
Debug.CheckDeviceExceptions();if (true) return forgotpin.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 56;BA.debugLine="Return False";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return forgotpin.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","activity_resume");}
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,47);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 47;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
forgotpin.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("btnCancel_Click (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,72);
if (RapidSub.canDelegate("btncancel_click")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","btncancel_click");}
 BA.debugLineNum = 72;BA.debugLine="Private Sub btnCancel_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
forgotpin.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnsave_click() throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,60);
if (RapidSub.canDelegate("btnsave_click")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","btnsave_click");}
 BA.debugLineNum = 60;BA.debugLine="Private Sub btnSave_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If txtAnswer.Text=\"\" Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",forgotpin.mostCurrent._txtanswer.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 62;BA.debugLine="lblErrorMsg.Text =\"Please enter security answer\"";
Debug.ShouldStop(536870912);
forgotpin.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter security answer"));
 }else 
{ BA.debugLineNum = 63;BA.debugLine="Else if txtAnswer.Text=config.getSecurityAnswer T";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",forgotpin.mostCurrent._txtanswer.runMethod(true,"getText"),forgotpin.mostCurrent._config.runMethod(true,"_getsecurityanswer" /*RemoteObject*/ ,forgotpin.mostCurrent.activityBA))) { 
 BA.debugLineNum = 64;BA.debugLine="StartActivity(pinreset)";
Debug.ShouldStop(-2147483648);
forgotpin.mostCurrent.__c.runVoidMethod ("StartActivity",forgotpin.processBA,(Object)((forgotpin.mostCurrent._pinreset.getObject())));
 BA.debugLineNum = 65;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
forgotpin.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 67;BA.debugLine="lblErrorMsg.Text =\"invalid security answer\"";
Debug.ShouldStop(4);
forgotpin.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("invalid security answer"));
 }}
;
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("clearForm (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,77);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","clearform");}
 BA.debugLineNum = 77;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="txtAnswer.Text=\"\"";
Debug.ShouldStop(8192);
forgotpin.mostCurrent._txtanswer.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 79;BA.debugLine="lblSecQuestion.Text=config.getSecurityQuestion";
Debug.ShouldStop(16384);
forgotpin.mostCurrent._lblsecquestion.runMethod(true,"setText",BA.ObjectToCharSequence(forgotpin.mostCurrent._config.runMethod(true,"_getsecurityquestion" /*RemoteObject*/ ,forgotpin.mostCurrent.activityBA)));
 BA.debugLineNum = 80;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(32768);
forgotpin.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 81;BA.debugLine="config.ResizeLabelHeight(lblSecQuestion)";
Debug.ShouldStop(65536);
forgotpin.mostCurrent._config.runVoidMethod ("_resizelabelheight" /*RemoteObject*/ ,forgotpin.mostCurrent.activityBA,(Object)(forgotpin.mostCurrent._lblsecquestion));
 BA.debugLineNum = 82;BA.debugLine="Panel1.Top=lblSecQuestion.Top+lblSecQuestion.Heig";
Debug.ShouldStop(131072);
forgotpin.mostCurrent._panel1.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {forgotpin.mostCurrent._lblsecquestion.runMethod(true,"getTop"),forgotpin.mostCurrent._lblsecquestion.runMethod(true,"getHeight"),RemoteObject.createImmutable(3)}, "++",2, 1));
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
forgotpin.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ToolbarHelper As ACActionBar";
forgotpin.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 18;BA.debugLine="Dim SharedPrefs As SharedPreferences";
forgotpin.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 19;BA.debugLine="Dim IME As IME";
forgotpin.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 21;BA.debugLine="Private txtAnswer As EditText";
forgotpin.mostCurrent._txtanswer = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private btnCancel As Button";
forgotpin.mostCurrent._btncancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private btnSave As Button";
forgotpin.mostCurrent._btnsave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lblErrorMsg As Label";
forgotpin.mostCurrent._lblerrormsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lblSecQuestion As Label";
forgotpin.mostCurrent._lblsecquestion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Panel1 As Panel";
forgotpin.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _txtanswer_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtAnswer_TextChanged (forgotpin) ","forgotpin",10,forgotpin.mostCurrent.activityBA,forgotpin.mostCurrent,85);
if (RapidSub.canDelegate("txtanswer_textchanged")) { return ng.dsoftlab.stegocam.forgotpin.remoteMe.runUserSub(false, "forgotpin","txtanswer_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 85;BA.debugLine="Private Sub txtAnswer_TextChanged (Old As String,";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(2097152);
forgotpin.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
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
}