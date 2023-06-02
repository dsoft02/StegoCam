
package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class b4xinputtemplate {
    public static RemoteObject myClass;
	public b4xinputtemplate() {
	}
    public static PCBA staticBA = new PCBA(null, b4xinputtemplate.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _mbase = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _text = RemoteObject.createImmutable("");
public static RemoteObject _xdialog = RemoteObject.declareNull("ng.dsoftlab.stegocam.b4xdialog");
public static RemoteObject _regexpattern = RemoteObject.createImmutable("");
public static RemoteObject _textfield1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _lbltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _ime = RemoteObject.declareNull("anywheresoftware.b4a.objects.IME");
public static RemoteObject _mallowdecimals = RemoteObject.createImmutable(false);
public static RemoteObject _bordercolor = RemoteObject.createImmutable(0);
public static RemoteObject _bordercolorinvalid = RemoteObject.createImmutable(0);
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
		return new Object[] {"BorderColor",_ref.getField(false, "_bordercolor"),"BorderColorInvalid",_ref.getField(false, "_bordercolorinvalid"),"DateUtils",_ref.getField(false, "_dateutils"),"IME",_ref.getField(false, "_ime"),"lblTitle",_ref.getField(false, "_lbltitle"),"mAllowDecimals",_ref.getField(false, "_mallowdecimals"),"mBase",_ref.getField(false, "_mbase"),"RegexPattern",_ref.getField(false, "_regexpattern"),"Text",_ref.getField(false, "_text"),"TextField1",_ref.getField(false, "_textfield1"),"xDialog",_ref.getField(false, "_xdialog"),"xui",_ref.getField(false, "_xui")};
}
}