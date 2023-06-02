package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class securityquestion_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"securityquestion\")";
Debug.ShouldStop(64);
securityquestion.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("securityquestion")),securityquestion.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(128);
securityquestion.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 41;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(256);
securityquestion.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",securityquestion.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(512);
securityquestion.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",securityquestion.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 43;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(1024);
securityquestion.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 44;BA.debugLine="clearForm";
Debug.ShouldStop(2048);
_clearform();
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,60);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, securityquestion.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 62;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(536870912);
securityquestion.mostCurrent.__c.runVoidMethod ("StartActivity",securityquestion.processBA,(Object)((securityquestion.mostCurrent._settings.getObject())));
 BA.debugLineNum = 63;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
securityquestion.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 64;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
Debug.CheckDeviceExceptions();if (true) return securityquestion.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 66;BA.debugLine="Return False";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return securityquestion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 67;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,51);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Resume (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,47);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","activity_resume");}
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16384);
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
public static RemoteObject  _actoolbarlight1_navigationitemclick() throws Exception{
try {
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,55);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 55;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(8388608);
securityquestion.mostCurrent.__c.runVoidMethod ("StartActivity",securityquestion.processBA,(Object)((securityquestion.mostCurrent._settings.getObject())));
 BA.debugLineNum = 57;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
securityquestion.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btncancel_click() throws Exception{
try {
		Debug.PushSubsStack("btnCancel_Click (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,88);
if (RapidSub.canDelegate("btncancel_click")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","btncancel_click");}
 BA.debugLineNum = 88;BA.debugLine="Private Sub btnCancel_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(16777216);
securityquestion.mostCurrent.__c.runVoidMethod ("StartActivity",securityquestion.processBA,(Object)((securityquestion.mostCurrent._settings.getObject())));
 BA.debugLineNum = 90;BA.debugLine="Activity.Finish";
Debug.ShouldStop(33554432);
securityquestion.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("btnSave_Click (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,70);
if (RapidSub.canDelegate("btnsave_click")) { ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","btnsave_click"); return;}
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
public ResumableSub_btnSave_Click(ng.dsoftlab.stegocam.securityquestion parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.securityquestion parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,70);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 71;BA.debugLine="If txtQuestion.Text=\"\" Then";
Debug.ShouldStop(64);
if (true) break;

case 1:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txtquestion.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 3;
}else 
{ BA.debugLineNum = 73;BA.debugLine="Else If txtAnswer.Text=\"\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txtanswer.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 5;
}else {
this.state = 7;
}}
if (true) break;

case 3:
//C
this.state = 12;
 BA.debugLineNum = 72;BA.debugLine="lblErrorMsg2.Text=\"Please enter security questio";
Debug.ShouldStop(128);
parent.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter security question"));
 if (true) break;

case 5:
//C
this.state = 12;
 BA.debugLineNum = 74;BA.debugLine="lblErrorMsg3.Text =\"Please enter security answer";
Debug.ShouldStop(512);
parent.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter security answer"));
 if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 76;BA.debugLine="config.saveSecurityQA(txtQuestion.Text,txtAnswer";
Debug.ShouldStop(2048);
parent.mostCurrent._config.runVoidMethod ("_savesecurityqa" /*RemoteObject*/ ,securityquestion.mostCurrent.activityBA,(Object)(parent.mostCurrent._txtquestion.runMethod(true,"getText")),(Object)(parent.mostCurrent._txtanswer.runMethod(true,"getText")));
 BA.debugLineNum = 77;BA.debugLine="Msgbox2Async(\"Security Question and Answer updat";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Security Question and Answer updated successfully!")),(Object)(BA.ObjectToCharSequence("Updated")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("icons8-success-100.png")))),securityquestion.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 78;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", securityquestion.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "securityquestion", "btnsave_click"), null);
this.state = 13;
return;
case 13:
//C
this.state = 8;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 79;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 80;BA.debugLine="StartActivity(settings)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",securityquestion.processBA,(Object)((parent.mostCurrent._settings.getObject())));
 BA.debugLineNum = 81;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
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
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("clearForm (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,94);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","clearform");}
 BA.debugLineNum = 94;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="txtQuestion.Text=config.getSecurityQuestion";
Debug.ShouldStop(1073741824);
securityquestion.mostCurrent._txtquestion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(securityquestion.mostCurrent._config.runMethod(true,"_getsecurityquestion" /*RemoteObject*/ ,securityquestion.mostCurrent.activityBA)));
 BA.debugLineNum = 96;BA.debugLine="txtAnswer.Text=config.getSecurityAnswer";
Debug.ShouldStop(-2147483648);
securityquestion.mostCurrent._txtanswer.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(securityquestion.mostCurrent._config.runMethod(true,"_getsecurityanswer" /*RemoteObject*/ ,securityquestion.mostCurrent.activityBA)));
 BA.debugLineNum = 97;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(1);
securityquestion.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 98;BA.debugLine="lblErrorMsg3.Text=\"\"";
Debug.ShouldStop(2);
securityquestion.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 99;BA.debugLine="txtQuestion.RequestFocus";
Debug.ShouldStop(4);
securityquestion.mostCurrent._txtquestion.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
securityquestion.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ToolbarHelper As ACActionBar";
securityquestion.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 18;BA.debugLine="Dim SharedPrefs As SharedPreferences";
securityquestion.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 19;BA.debugLine="Dim IME As IME";
securityquestion.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 20;BA.debugLine="Private btnCancel As Button";
securityquestion.mostCurrent._btncancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btnSave As Button";
securityquestion.mostCurrent._btnsave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private ImageView1 As ImageView";
securityquestion.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private ImageView2 As ImageView";
securityquestion.mostCurrent._imageview2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private imgIcon As ImageView";
securityquestion.mostCurrent._imgicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Label1 As Label";
securityquestion.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Label3 As Label";
securityquestion.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Label4 As Label";
securityquestion.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private lblErrorMsg2 As Label";
securityquestion.mostCurrent._lblerrormsg2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private lblErrorMsg3 As Label";
securityquestion.mostCurrent._lblerrormsg3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Panel1 As Panel";
securityquestion.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Panel2 As Panel";
securityquestion.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private pnlContainer As Panel";
securityquestion.mostCurrent._pnlcontainer = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private txtAnswer As EditText";
securityquestion.mostCurrent._txtanswer = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private txtQuestion As EditText";
securityquestion.mostCurrent._txtquestion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _txtanswer_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtAnswer_TextChanged (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,107);
if (RapidSub.canDelegate("txtanswer_textchanged")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","txtanswer_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 107;BA.debugLine="Private Sub txtAnswer_TextChanged (Old As String,";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="lblErrorMsg3.Text=\"\"";
Debug.ShouldStop(2048);
securityquestion.mostCurrent._lblerrormsg3.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("txtQuestion_TextChanged (securityquestion) ","securityquestion",14,securityquestion.mostCurrent.activityBA,securityquestion.mostCurrent,103);
if (RapidSub.canDelegate("txtquestion_textchanged")) { return ng.dsoftlab.stegocam.securityquestion.remoteMe.runUserSub(false, "securityquestion","txtquestion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 103;BA.debugLine="Private Sub txtQuestion_TextChanged (Old As String";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="lblErrorMsg2.Text=\"\"";
Debug.ShouldStop(128);
securityquestion.mostCurrent._lblerrormsg2.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}