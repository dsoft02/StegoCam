
package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class b4xloadingindicator {
    public static RemoteObject myClass;
	public b4xloadingindicator() {
	}
    public static PCBA staticBA = new PCBA(null, b4xloadingindicator.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _mbase = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _clr = RemoteObject.createImmutable(0);
public static RemoteObject _index = RemoteObject.createImmutable(0);
public static RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
public static RemoteObject _duration = RemoteObject.createImmutable(0);
public static RemoteObject _drawingsubname = RemoteObject.createImmutable("");
public static RemoteObject _tag = RemoteObject.declareNull("Object");
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
		return new Object[] {"clr",_ref.getField(false, "_clr"),"cvs",_ref.getField(false, "_cvs"),"DateUtils",_ref.getField(false, "_dateutils"),"DrawingSubName",_ref.getField(false, "_drawingsubname"),"duration",_ref.getField(false, "_duration"),"index",_ref.getField(false, "_index"),"mBase",_ref.getField(false, "_mbase"),"mCallBack",_ref.getField(false, "_mcallback"),"mEventName",_ref.getField(false, "_meventname"),"Tag",_ref.getField(false, "_tag"),"xui",_ref.getField(false, "_xui")};
}
}