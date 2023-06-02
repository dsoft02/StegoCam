
package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class simplescale {
    public static RemoteObject myClass;
	public simplescale() {
	}
    public static PCBA staticBA = new PCBA(null, simplescale.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _layvalues = RemoteObject.declareNull("anywheresoftware.b4a.keywords.LayoutValues");
public static RemoteObject _initialattribs = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _hastitle = RemoteObject.createImmutable(false);
public static RemoteObject _isfullscreen = RemoteObject.createImmutable(false);
public static RemoteObject _container = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lastratiox = RemoteObject.createImmutable(0f);
public static RemoteObject _lastratioy = RemoteObject.createImmutable(0f);
public static RemoteObject _lastpctscreen = RemoteObject.createImmutable(0f);
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
		return new Object[] {"container",_ref.getField(false, "_container"),"DateUtils",_ref.getField(false, "_dateutils"),"hasTitle",_ref.getField(false, "_hastitle"),"initialAttribs",_ref.getField(false, "_initialattribs"),"isFullScreen",_ref.getField(false, "_isfullscreen"),"lastPctScreen",_ref.getField(false, "_lastpctscreen"),"lastRatioX",_ref.getField(false, "_lastratiox"),"lastRatioY",_ref.getField(false, "_lastratioy"),"layValues",_ref.getField(false, "_layvalues")};
}
}