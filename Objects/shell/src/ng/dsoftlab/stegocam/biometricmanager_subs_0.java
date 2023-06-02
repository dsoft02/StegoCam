package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class biometricmanager_subs_0 {


public static RemoteObject  _auth_complete(RemoteObject __ref,RemoteObject _success,RemoteObject _errorcode,RemoteObject _errormessage) throws Exception{
try {
		Debug.PushSubsStack("Auth_Complete (biometricmanager) ","biometricmanager",9,__ref.getField(false, "ba"),__ref,58);
if (RapidSub.canDelegate("auth_complete")) { return __ref.runUserSub(false, "biometricmanager","auth_complete", __ref, _success, _errorcode, _errormessage);}
Debug.locals.put("Success", _success);
Debug.locals.put("ErrorCode", _errorcode);
Debug.locals.put("ErrorMessage", _errormessage);
 BA.debugLineNum = 58;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="CallSubDelayed3(mTarget, mEventName & \"_complete\"";
Debug.ShouldStop(134217728);
biometricmanager.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_complete"))),(Object)((_success)),(Object)((_errormessage)));
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _canauthenticate(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CanAuthenticate (biometricmanager) ","biometricmanager",9,__ref.getField(false, "ba"),__ref,29);
if (RapidSub.canDelegate("canauthenticate")) { return __ref.runUserSub(false, "biometricmanager","canauthenticate", __ref);}
RemoteObject _v = RemoteObject.createImmutable(0);
 BA.debugLineNum = 29;BA.debugLine="Public Sub CanAuthenticate As String";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Dim v As Int = Manager.RunMethod(\"canAuthenticate";
Debug.ShouldStop(536870912);
_v = BA.numberCast(int.class, __ref.getField(false,"_manager" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("canAuthenticate")),(Object)((biometricmanager.__c.getField(false,"Null")))));Debug.locals.put("v", _v);Debug.locals.put("v", _v);
 BA.debugLineNum = 31;BA.debugLine="Select v";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(_v,BA.numberCast(int.class, 1),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12),BA.numberCast(int.class, 0))) {
case 0: {
 BA.debugLineNum = 33;BA.debugLine="Return \"UNAVAILABLE\"";
Debug.ShouldStop(1);
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("UNAVAILABLE");
 break; }
case 1: {
 BA.debugLineNum = 35;BA.debugLine="Return \"NONE_ENROLLED\"";
Debug.ShouldStop(4);
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("NONE_ENROLLED");
 break; }
case 2: {
 BA.debugLineNum = 37;BA.debugLine="Return \"NO_HARDWARE\"";
Debug.ShouldStop(16);
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("NO_HARDWARE");
 break; }
case 3: {
 BA.debugLineNum = 39;BA.debugLine="Return \"SUCCESS\"";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("SUCCESS");
 break; }
default: {
 BA.debugLineNum = 41;BA.debugLine="Return \"UNKNOWN\"";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return BA.ObjectToString("UNKNOWN");
 break; }
}
;
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private ctxt As JavaObject";
biometricmanager._ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_ctxt",biometricmanager._ctxt);
 //BA.debugLineNum = 6;BA.debugLine="Private Manager As JavaObject";
biometricmanager._manager = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_manager",biometricmanager._manager);
 //BA.debugLineNum = 7;BA.debugLine="Private Handler As JavaObject";
biometricmanager._handler = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_handler",biometricmanager._handler);
 //BA.debugLineNum = 8;BA.debugLine="Private Executor As Object";
biometricmanager._executor = RemoteObject.createNew ("Object");__ref.setField("_executor",biometricmanager._executor);
 //BA.debugLineNum = 9;BA.debugLine="Private mTarget As Object";
biometricmanager._mtarget = RemoteObject.createNew ("Object");__ref.setField("_mtarget",biometricmanager._mtarget);
 //BA.debugLineNum = 10;BA.debugLine="Private mEventName As String";
biometricmanager._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",biometricmanager._meventname);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _executor_event(RemoteObject __ref,RemoteObject _methodname,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("Executor_Event (biometricmanager) ","biometricmanager",9,__ref.getField(false, "ba"),__ref,22);
if (RapidSub.canDelegate("executor_event")) { return __ref.runUserSub(false, "biometricmanager","executor_event", __ref, _methodname, _args);}
Debug.locals.put("MethodName", _methodname);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 22;BA.debugLine="Private Sub Executor_Event (MethodName As String,";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="If MethodName = \"execute\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_methodname,BA.ObjectToString("execute"))) { 
 BA.debugLineNum = 24;BA.debugLine="Handler.RunMethod(\"post\", Array(Args(0)))";
Debug.ShouldStop(8388608);
__ref.getField(false,"_handler" /*RemoteObject*/ ).runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("post")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_args.getArrayElement(false,BA.numberCast(int.class, 0))})));
 };
 BA.debugLineNum = 26;BA.debugLine="Return Null";
Debug.ShouldStop(33554432);
Debug.CheckDeviceExceptions();if (true) return biometricmanager.__c.getField(false,"Null");
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _target,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (biometricmanager) ","biometricmanager",9,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "biometricmanager","initialize", __ref, _ba, _target, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Target", _target);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 13;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="mTarget = Target";
Debug.ShouldStop(8192);
__ref.setField ("_mtarget" /*RemoteObject*/ ,_target);
 BA.debugLineNum = 15;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(16384);
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 16;BA.debugLine="ctxt.InitializeContext";
Debug.ShouldStop(32768);
__ref.getField(false,"_ctxt" /*RemoteObject*/ ).runVoidMethod ("InitializeContext",__ref.getField(false, "ba"));
 BA.debugLineNum = 17;BA.debugLine="Manager = Manager.InitializeStatic(\"androidx.biom";
Debug.ShouldStop(65536);
__ref.getField(false,"_manager" /*RemoteObject*/ ).setObject (__ref.getField(false,"_manager" /*RemoteObject*/ ).runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("androidx.biometric.BiometricManager"))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("from")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(__ref.getField(false,"_ctxt" /*RemoteObject*/ ).getObject())}))));
 BA.debugLineNum = 18;BA.debugLine="Handler.InitializeNewInstance(\"android.os.Handler";
Debug.ShouldStop(131072);
__ref.getField(false,"_handler" /*RemoteObject*/ ).runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.os.Handler")),(Object)((biometricmanager.__c.getField(false,"Null"))));
 BA.debugLineNum = 19;BA.debugLine="Executor = Handler.CreateEvent(\"java.util.concurr";
Debug.ShouldStop(262144);
__ref.setField ("_executor" /*RemoteObject*/ ,__ref.getField(false,"_handler" /*RemoteObject*/ ).runMethod(false,"CreateEvent",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("java.util.concurrent.Executor")),(Object)(BA.ObjectToString("Executor")),(Object)(biometricmanager.__c.getField(false,"Null"))));
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show(RemoteObject __ref,RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("Show (biometricmanager) ","biometricmanager",9,__ref.getField(false, "ba"),__ref,45);
if (RapidSub.canDelegate("show")) { return __ref.runUserSub(false, "biometricmanager","show", __ref, _msg);}
RemoteObject _promptinfobuilder = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _ev = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _prompt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Msg", _msg);
 BA.debugLineNum = 45;BA.debugLine="Public Sub Show (Msg As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim PromptInfoBuilder As JavaObject";
Debug.ShouldStop(8192);
_promptinfobuilder = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("PromptInfoBuilder", _promptinfobuilder);
 BA.debugLineNum = 47;BA.debugLine="PromptInfoBuilder.InitializeNewInstance(\"androidx";
Debug.ShouldStop(16384);
_promptinfobuilder.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("androidx.biometric.BiometricPrompt$PromptInfo$Builder")),(Object)((biometricmanager.__c.getField(false,"Null"))));
 BA.debugLineNum = 48;BA.debugLine="PromptInfoBuilder.RunMethod(\"setTitle\", Array(Msg";
Debug.ShouldStop(32768);
_promptinfobuilder.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setTitle")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_msg)})));
 BA.debugLineNum = 49;BA.debugLine="PromptInfoBuilder.RunMethod(\"setNegativeButtonTex";
Debug.ShouldStop(65536);
_promptinfobuilder.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setNegativeButtonText")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("Cancel"))})));
 BA.debugLineNum = 50;BA.debugLine="Dim Ev As JavaObject";
Debug.ShouldStop(131072);
_ev = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("Ev", _ev);
 BA.debugLineNum = 51;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
Debug.ShouldStop(262144);
_ev.runVoidMethod ("InitializeNewInstance",(Object)(RemoteObject.concat(biometricmanager.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable(".biometricmanager.BiometricPromptAuthentication"))),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {__ref})));
 BA.debugLineNum = 52;BA.debugLine="Dim Prompt As JavaObject";
Debug.ShouldStop(524288);
_prompt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("Prompt", _prompt);
 BA.debugLineNum = 53;BA.debugLine="Prompt.InitializeNewInstance(\"androidx.biometric.";
Debug.ShouldStop(1048576);
_prompt.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("androidx.biometric.BiometricPrompt")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(__ref.getField(false,"_ctxt" /*RemoteObject*/ ).getObject()),__ref.getField(false,"_executor" /*RemoteObject*/ ),(_ev.getObject())})));
 BA.debugLineNum = 54;BA.debugLine="Prompt.RunMethod(\"authenticate\", Array(PromptInfo";
Debug.ShouldStop(2097152);
_prompt.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("authenticate")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_promptinfobuilder.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("build")),(Object)((biometricmanager.__c.getField(false,"Null"))))})));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}