package ng.dsoftlab.stegocam;

import androidx.biometric.*;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class biometricmanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ng.dsoftlab.stegocam.biometricmanager");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ng.dsoftlab.stegocam.biometricmanager.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.JavaObject _ctxt = null;
public anywheresoftware.b4j.object.JavaObject _manager = null;
public anywheresoftware.b4j.object.JavaObject _handler = null;
public Object _executor = null;
public Object _mtarget = null;
public String _meventname = "";
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.encode _encode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public String  _initialize(ng.dsoftlab.stegocam.biometricmanager __ref,anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="biometricmanager";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_target,_eventname}));}
RDebugUtils.currentLine=43712512;
 //BA.debugLineNum = 43712512;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
RDebugUtils.currentLine=43712513;
 //BA.debugLineNum = 43712513;BA.debugLine="mTarget = Target";
__ref._mtarget /*Object*/  = _target;
RDebugUtils.currentLine=43712514;
 //BA.debugLineNum = 43712514;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=43712515;
 //BA.debugLineNum = 43712515;BA.debugLine="ctxt.InitializeContext";
__ref._ctxt /*anywheresoftware.b4j.object.JavaObject*/ .InitializeContext(ba);
RDebugUtils.currentLine=43712516;
 //BA.debugLineNum = 43712516;BA.debugLine="Manager = Manager.InitializeStatic(\"androidx.biom";
__ref._manager /*anywheresoftware.b4j.object.JavaObject*/  = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(__ref._manager /*anywheresoftware.b4j.object.JavaObject*/ .InitializeStatic("androidx.biometric.BiometricManager").RunMethod("from",new Object[]{(Object)(__ref._ctxt /*anywheresoftware.b4j.object.JavaObject*/ .getObject())})));
RDebugUtils.currentLine=43712517;
 //BA.debugLineNum = 43712517;BA.debugLine="Handler.InitializeNewInstance(\"android.os.Handler";
__ref._handler /*anywheresoftware.b4j.object.JavaObject*/ .InitializeNewInstance("android.os.Handler",(Object[])(__c.Null));
RDebugUtils.currentLine=43712518;
 //BA.debugLineNum = 43712518;BA.debugLine="Executor = Handler.CreateEvent(\"java.util.concurr";
__ref._executor /*Object*/  = __ref._handler /*anywheresoftware.b4j.object.JavaObject*/ .CreateEvent(ba,"java.util.concurrent.Executor","Executor",__c.Null);
RDebugUtils.currentLine=43712519;
 //BA.debugLineNum = 43712519;BA.debugLine="End Sub";
return "";
}
public String  _canauthenticate(ng.dsoftlab.stegocam.biometricmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="biometricmanager";
if (Debug.shouldDelegate(ba, "canauthenticate", false))
	 {return ((String) Debug.delegate(ba, "canauthenticate", null));}
int _v = 0;
RDebugUtils.currentLine=43843584;
 //BA.debugLineNum = 43843584;BA.debugLine="Public Sub CanAuthenticate As String";
RDebugUtils.currentLine=43843585;
 //BA.debugLineNum = 43843585;BA.debugLine="Dim v As Int = Manager.RunMethod(\"canAuthenticate";
_v = (int)(BA.ObjectToNumber(__ref._manager /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("canAuthenticate",(Object[])(__c.Null))));
RDebugUtils.currentLine=43843586;
 //BA.debugLineNum = 43843586;BA.debugLine="Select v";
switch (_v) {
case 1: {
RDebugUtils.currentLine=43843588;
 //BA.debugLineNum = 43843588;BA.debugLine="Return \"UNAVAILABLE\"";
if (true) return "UNAVAILABLE";
 break; }
case 11: {
RDebugUtils.currentLine=43843590;
 //BA.debugLineNum = 43843590;BA.debugLine="Return \"NONE_ENROLLED\"";
if (true) return "NONE_ENROLLED";
 break; }
case 12: {
RDebugUtils.currentLine=43843592;
 //BA.debugLineNum = 43843592;BA.debugLine="Return \"NO_HARDWARE\"";
if (true) return "NO_HARDWARE";
 break; }
case 0: {
RDebugUtils.currentLine=43843594;
 //BA.debugLineNum = 43843594;BA.debugLine="Return \"SUCCESS\"";
if (true) return "SUCCESS";
 break; }
default: {
RDebugUtils.currentLine=43843596;
 //BA.debugLineNum = 43843596;BA.debugLine="Return \"UNKNOWN\"";
if (true) return "UNKNOWN";
 break; }
}
;
RDebugUtils.currentLine=43843598;
 //BA.debugLineNum = 43843598;BA.debugLine="End Sub";
return "";
}
public String  _show(ng.dsoftlab.stegocam.biometricmanager __ref,String _msg) throws Exception{
__ref = this;
RDebugUtils.currentModule="biometricmanager";
if (Debug.shouldDelegate(ba, "show", false))
	 {return ((String) Debug.delegate(ba, "show", new Object[] {_msg}));}
anywheresoftware.b4j.object.JavaObject _promptinfobuilder = null;
anywheresoftware.b4j.object.JavaObject _ev = null;
anywheresoftware.b4j.object.JavaObject _prompt = null;
RDebugUtils.currentLine=43909120;
 //BA.debugLineNum = 43909120;BA.debugLine="Public Sub Show (Msg As String)";
RDebugUtils.currentLine=43909121;
 //BA.debugLineNum = 43909121;BA.debugLine="Dim PromptInfoBuilder As JavaObject";
_promptinfobuilder = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=43909122;
 //BA.debugLineNum = 43909122;BA.debugLine="PromptInfoBuilder.InitializeNewInstance(\"androidx";
_promptinfobuilder.InitializeNewInstance("androidx.biometric.BiometricPrompt$PromptInfo$Builder",(Object[])(__c.Null));
RDebugUtils.currentLine=43909123;
 //BA.debugLineNum = 43909123;BA.debugLine="PromptInfoBuilder.RunMethod(\"setTitle\", Array(Msg";
_promptinfobuilder.RunMethod("setTitle",new Object[]{(Object)(_msg)});
RDebugUtils.currentLine=43909124;
 //BA.debugLineNum = 43909124;BA.debugLine="PromptInfoBuilder.RunMethod(\"setNegativeButtonTex";
_promptinfobuilder.RunMethod("setNegativeButtonText",new Object[]{(Object)("Cancel")});
RDebugUtils.currentLine=43909125;
 //BA.debugLineNum = 43909125;BA.debugLine="Dim Ev As JavaObject";
_ev = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=43909126;
 //BA.debugLineNum = 43909126;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
_ev.InitializeNewInstance(__c.Application.getPackageName()+".biometricmanager.BiometricPromptAuthentication",new Object[]{this});
RDebugUtils.currentLine=43909127;
 //BA.debugLineNum = 43909127;BA.debugLine="Dim Prompt As JavaObject";
_prompt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=43909128;
 //BA.debugLineNum = 43909128;BA.debugLine="Prompt.InitializeNewInstance(\"androidx.biometric.";
_prompt.InitializeNewInstance("androidx.biometric.BiometricPrompt",new Object[]{(Object)(__ref._ctxt /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),__ref._executor /*Object*/ ,(Object)(_ev.getObject())});
RDebugUtils.currentLine=43909129;
 //BA.debugLineNum = 43909129;BA.debugLine="Prompt.RunMethod(\"authenticate\", Array(PromptInfo";
_prompt.RunMethod("authenticate",new Object[]{_promptinfobuilder.RunMethod("build",(Object[])(__c.Null))});
RDebugUtils.currentLine=43909131;
 //BA.debugLineNum = 43909131;BA.debugLine="End Sub";
return "";
}
public String  _auth_complete(ng.dsoftlab.stegocam.biometricmanager __ref,boolean _success,int _errorcode,String _errormessage) throws Exception{
__ref = this;
RDebugUtils.currentModule="biometricmanager";
if (Debug.shouldDelegate(ba, "auth_complete", false))
	 {return ((String) Debug.delegate(ba, "auth_complete", new Object[] {_success,_errorcode,_errormessage}));}
RDebugUtils.currentLine=43974656;
 //BA.debugLineNum = 43974656;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
RDebugUtils.currentLine=43974658;
 //BA.debugLineNum = 43974658;BA.debugLine="CallSubDelayed3(mTarget, mEventName & \"_complete\"";
__c.CallSubDelayed3(ba,__ref._mtarget /*Object*/ ,__ref._meventname /*String*/ +"_complete",(Object)(_success),(Object)(_errormessage));
RDebugUtils.currentLine=43974659;
 //BA.debugLineNum = 43974659;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(ng.dsoftlab.stegocam.biometricmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="biometricmanager";
RDebugUtils.currentLine=43646976;
 //BA.debugLineNum = 43646976;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=43646977;
 //BA.debugLineNum = 43646977;BA.debugLine="Private ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=43646978;
 //BA.debugLineNum = 43646978;BA.debugLine="Private Manager As JavaObject";
_manager = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=43646979;
 //BA.debugLineNum = 43646979;BA.debugLine="Private Handler As JavaObject";
_handler = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=43646980;
 //BA.debugLineNum = 43646980;BA.debugLine="Private Executor As Object";
_executor = new Object();
RDebugUtils.currentLine=43646981;
 //BA.debugLineNum = 43646981;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
RDebugUtils.currentLine=43646982;
 //BA.debugLineNum = 43646982;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=43646983;
 //BA.debugLineNum = 43646983;BA.debugLine="End Sub";
return "";
}
public Object  _executor_event(ng.dsoftlab.stegocam.biometricmanager __ref,String _methodname,Object[] _args) throws Exception{
__ref = this;
RDebugUtils.currentModule="biometricmanager";
if (Debug.shouldDelegate(ba, "executor_event", false))
	 {return ((Object) Debug.delegate(ba, "executor_event", new Object[] {_methodname,_args}));}
RDebugUtils.currentLine=43778048;
 //BA.debugLineNum = 43778048;BA.debugLine="Private Sub Executor_Event (MethodName As String,";
RDebugUtils.currentLine=43778049;
 //BA.debugLineNum = 43778049;BA.debugLine="If MethodName = \"execute\" Then";
if ((_methodname).equals("execute")) { 
RDebugUtils.currentLine=43778050;
 //BA.debugLineNum = 43778050;BA.debugLine="Handler.RunMethod(\"post\", Array(Args(0)))";
__ref._handler /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("post",new Object[]{_args[(int) (0)]});
 };
RDebugUtils.currentLine=43778052;
 //BA.debugLineNum = 43778052;BA.debugLine="Return Null";
if (true) return __c.Null;
RDebugUtils.currentLine=43778053;
 //BA.debugLineNum = 43778053;BA.debugLine="End Sub";
return null;
}

public static class BiometricPromptAuthentication extends BiometricPrompt.AuthenticationCallback {
	private BA ba;
	public BiometricPromptAuthentication(B4AClass parent) {
		ba = parent.getBA();
	}
	@Override
	public void onAuthenticationError(int errorCode, CharSequence errString) {
		super.onAuthenticationError(errorCode, errString);
		 ba.raiseEventFromUI(this, "auth_complete", false, errorCode, errString);
	}

	@Override
	public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
		super.onAuthenticationSucceeded(result);
		 ba.raiseEventFromUI(this, "auth_complete", true, 0, "");
	}

	@Override
	public void onAuthenticationFailed() {
		super.onAuthenticationFailed();
	}
}
}