
package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class biometricmanager {
    public static RemoteObject myClass;
	public biometricmanager() {
	}
    public static PCBA staticBA = new PCBA(null, biometricmanager.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _manager = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _handler = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _executor = RemoteObject.declareNull("Object");
public static RemoteObject _mtarget = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ng.dsoftlab.stegocam.main _main = null;
public static ng.dsoftlab.stegocam.starter _starter = null;
public static ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public static ng.dsoftlab.stegocam.config _config = null;
public static ng.dsoftlab.stegocam.encode _encode = null;
public static ng.dsoftlab.stegocam.settings _settings = null;
public static ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public static ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public static ng.dsoftlab.stegocam.login _login = null;
public static ng.dsoftlab.stegocam.pinchange _pinchange = null;
public static ng.dsoftlab.stegocam.pinreset _pinreset = null;
public static ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public static ng.dsoftlab.stegocam.history _history = null;
public static ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public static ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public static ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ctxt",_ref.getField(false, "_ctxt"),"DateUtils",_ref.getField(false, "_dateutils"),"Executor",_ref.getField(false, "_executor"),"Handler",_ref.getField(false, "_handler"),"Manager",_ref.getField(false, "_manager"),"mEventName",_ref.getField(false, "_meventname"),"mTarget",_ref.getField(false, "_mtarget")};
}
}