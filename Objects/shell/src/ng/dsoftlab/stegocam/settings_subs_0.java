package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class settings_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"settings\")";
Debug.ShouldStop(67108864);
settings.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("settings")),settings.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(134217728);
settings.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",settings.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(268435456);
settings.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",settings.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 30;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(536870912);
settings.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 33;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(1);
settings.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 34;BA.debugLine="B4XSwitch1.Value=config.getBiometric";
Debug.ShouldStop(2);
settings.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_setvalue" /*RemoteObject*/ ,settings.mostCurrent._config.runMethod(true,"_getbiometric" /*RemoteObject*/ ,settings.mostCurrent.activityBA));
 BA.debugLineNum = 35;BA.debugLine="Biometric.Initialize(Me, \"Authenticate\")";
Debug.ShouldStop(4);
settings.mostCurrent._biometric.runClassMethod (ng.dsoftlab.stegocam.biometricmanager.class, "_initialize" /*RemoteObject*/ ,settings.processBA,(Object)(settings.getObject()),(Object)(RemoteObject.createImmutable("Authenticate")));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,42);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,38);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","activity_resume");}
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,46);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 46;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
settings.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 48;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(32768);
settings.mostCurrent.__c.runVoidMethod ("StartActivity",settings.processBA,(Object)((settings.mostCurrent._mainmenu.getObject())));
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
public static void  _b4xswitch1_valuechanged(RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("B4XSwitch1_ValueChanged (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,52);
if (RapidSub.canDelegate("b4xswitch1_valuechanged")) { ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","b4xswitch1_valuechanged", _value); return;}
ResumableSub_B4XSwitch1_ValueChanged rsub = new ResumableSub_B4XSwitch1_ValueChanged(null,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_B4XSwitch1_ValueChanged extends BA.ResumableSub {
public ResumableSub_B4XSwitch1_ValueChanged(ng.dsoftlab.stegocam.settings parent,RemoteObject _value) {
this.parent = parent;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.settings parent;
RemoteObject _value;
RemoteObject _icfingerprint = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _bioval = RemoteObject.createImmutable(false);
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _errormessage = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("B4XSwitch1_ValueChanged (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,52);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Value", _value);
 BA.debugLineNum = 53;BA.debugLine="Dim icFingerprint As Bitmap";
Debug.ShouldStop(1048576);
_icfingerprint = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("icFingerprint", _icfingerprint);
 BA.debugLineNum = 54;BA.debugLine="Dim bioVal As Boolean= B4XSwitch1.Value";
Debug.ShouldStop(2097152);
_bioval = parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_getvalue" /*RemoteObject*/ );Debug.locals.put("bioVal", _bioval);Debug.locals.put("bioVal", _bioval);
 BA.debugLineNum = 55;BA.debugLine="If B4XSwitch1.Value=False Then";
Debug.ShouldStop(4194304);
if (true) break;

case 1:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_getvalue" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 3;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 56;BA.debugLine="Msgbox2Async(\"Are you sure you want to disable f";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to disable fingerprint login?")),(Object)(BA.ObjectToCharSequence("Disable Fingerprint")),(Object)(BA.ObjectToString("Confirm")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("icons8-fingerprint-94.png")))),settings.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 57;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", settings.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "settings", "b4xswitch1_valuechanged"), null);
this.state = 25;
return;
case 25:
//C
this.state = 4;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 58;BA.debugLine="If Result=DialogResponse.POSITIVE Then";
Debug.ShouldStop(33554432);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 59;BA.debugLine="SharedPrefs.SaveBoolean(\"Biometric\",B4XSwitch1.";
Debug.ShouldStop(67108864);
parent.mostCurrent._sharedprefs.runVoidMethod ("SaveBoolean",(Object)(BA.ObjectToString("Biometric")),(Object)(parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_getvalue" /*RemoteObject*/ )));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 61;BA.debugLine="B4XSwitch1.Value=True";
Debug.ShouldStop(268435456);
parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_setvalue" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 9:
//C
this.state = 24;
;
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 64;BA.debugLine="Dim res As String = Biometric.CanAuthenticate";
Debug.ShouldStop(-2147483648);
_res = parent.mostCurrent._biometric.runClassMethod (ng.dsoftlab.stegocam.biometricmanager.class, "_canauthenticate" /*RemoteObject*/ );Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 65;BA.debugLine="If res = \"SUCCESS\" Then";
Debug.ShouldStop(1);
if (true) break;

case 12:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",_res,BA.ObjectToString("SUCCESS"))) { 
this.state = 14;
}else {
this.state = 22;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 66;BA.debugLine="Biometric.Show(\"Verifying Finegerprint\")";
Debug.ShouldStop(2);
parent.mostCurrent._biometric.runClassMethod (ng.dsoftlab.stegocam.biometricmanager.class, "_show" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("Verifying Finegerprint")));
 BA.debugLineNum = 67;BA.debugLine="Wait For Authenticate_Complete (Success As Bool";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","authenticate_complete", settings.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "settings", "b4xswitch1_valuechanged"), null);
this.state = 26;
return;
case 26:
//C
this.state = 15;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_errormessage = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("ErrorMessage", _errormessage);
;
 BA.debugLineNum = 68;BA.debugLine="If Success Then";
Debug.ShouldStop(8);
if (true) break;

case 15:
//if
this.state = 20;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 17;
}else {
this.state = 19;
}if (true) break;

case 17:
//C
this.state = 20;
 BA.debugLineNum = 69;BA.debugLine="SharedPrefs.SaveBoolean(\"Biometric\",B4XSwitch1";
Debug.ShouldStop(16);
parent.mostCurrent._sharedprefs.runVoidMethod ("SaveBoolean",(Object)(BA.ObjectToString("Biometric")),(Object)(parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_getvalue" /*RemoteObject*/ )));
 BA.debugLineNum = 70;BA.debugLine="Msgbox2Async(\"Fingerprint login enabled\",\"Fing";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Fingerprint login enabled")),(Object)(BA.ObjectToCharSequence("Fingerprint Enabled")),(Object)(BA.ObjectToString("Done")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("icons8-fingerprint-94.png")))),settings.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 72;BA.debugLine="B4XSwitch1.Value=False";
Debug.ShouldStop(128);
parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_setvalue" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 20:
//C
this.state = 23;
;
 if (true) break;

case 22:
//C
this.state = 23;
 BA.debugLineNum = 75;BA.debugLine="B4XSwitch1.Value=False";
Debug.ShouldStop(1024);
parent.mostCurrent._b4xswitch1.runClassMethod (ng.dsoftlab.stegocam.b4xswitch.class, "_setvalue" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = -1;
;
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
public static void  _authenticate_complete(RemoteObject _success,RemoteObject _errormessage) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
settings.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private ToolbarHelper As ACActionBar";
settings.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 17;BA.debugLine="Private B4XSwitch1 As B4XSwitch";
settings.mostCurrent._b4xswitch1 = RemoteObject.createNew ("ng.dsoftlab.stegocam.b4xswitch");
 //BA.debugLineNum = 18;BA.debugLine="Dim SharedPrefs As SharedPreferences";
settings.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 19;BA.debugLine="Private Biometric As BiometricManager";
settings.mostCurrent._biometric = RemoteObject.createNew ("ng.dsoftlab.stegocam.biometricmanager");
 //BA.debugLineNum = 20;BA.debugLine="Private lblSignout As Label";
settings.mostCurrent._lblsignout = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pnlPinChange As Panel";
settings.mostCurrent._pnlpinchange = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private pnlSecurityQuestion As Panel";
settings.mostCurrent._pnlsecurityquestion = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblsignout_click() throws Exception{
try {
		Debug.PushSubsStack("lblSignout_Click (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,80);
if (RapidSub.canDelegate("lblsignout_click")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","lblsignout_click");}
 BA.debugLineNum = 80;BA.debugLine="Private Sub lblSignout_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
settings.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 82;BA.debugLine="StartActivity(Login)";
Debug.ShouldStop(131072);
settings.mostCurrent.__c.runVoidMethod ("StartActivity",settings.processBA,(Object)((settings.mostCurrent._login.getObject())));
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
public static RemoteObject  _pnlpinchange_click() throws Exception{
try {
		Debug.PushSubsStack("pnlPinChange_Click (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,90);
if (RapidSub.canDelegate("pnlpinchange_click")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","pnlpinchange_click");}
 BA.debugLineNum = 90;BA.debugLine="Private Sub pnlPinChange_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
settings.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 92;BA.debugLine="StartActivity(PinChange)";
Debug.ShouldStop(134217728);
settings.mostCurrent.__c.runVoidMethod ("StartActivity",settings.processBA,(Object)((settings.mostCurrent._pinchange.getObject())));
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlsecurityquestion_click() throws Exception{
try {
		Debug.PushSubsStack("pnlSecurityQuestion_Click (settings) ","settings",5,settings.mostCurrent.activityBA,settings.mostCurrent,85);
if (RapidSub.canDelegate("pnlsecurityquestion_click")) { return ng.dsoftlab.stegocam.settings.remoteMe.runUserSub(false, "settings","pnlsecurityquestion_click");}
 BA.debugLineNum = 85;BA.debugLine="Private Sub pnlSecurityQuestion_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2097152);
settings.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 87;BA.debugLine="StartActivity(securityquestion)";
Debug.ShouldStop(4194304);
settings.mostCurrent.__c.runVoidMethod ("StartActivity",settings.processBA,(Object)((settings.mostCurrent._securityquestion.getObject())));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}