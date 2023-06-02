
package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class b4xdrawer {
    public static RemoteObject myClass;
	public b4xdrawer() {
	}
    public static PCBA staticBA = new PCBA(null, b4xdrawer.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _msidewidth = RemoteObject.createImmutable(0);
public static RemoteObject _mleftpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _mdarkpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _mbasepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _mcenterpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _extrawidth = RemoteObject.createImmutable(0);
public static RemoteObject _touchxstart = RemoteObject.createImmutable(0f);
public static RemoteObject _touchystart = RemoteObject.createImmutable(0f);
public static RemoteObject _isopen = RemoteObject.createImmutable(false);
public static RemoteObject _handlingswipe = RemoteObject.createImmutable(false);
public static RemoteObject _startatscrim = RemoteObject.createImmutable(false);
public static RemoteObject _menabled = RemoteObject.createImmutable(false);
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
		return new Object[] {"DateUtils",_ref.getField(false, "_dateutils"),"ExtraWidth",_ref.getField(false, "_extrawidth"),"HandlingSwipe",_ref.getField(false, "_handlingswipe"),"IsOpen",_ref.getField(false, "_isopen"),"mBasePanel",_ref.getField(false, "_mbasepanel"),"mCallBack",_ref.getField(false, "_mcallback"),"mCenterPanel",_ref.getField(false, "_mcenterpanel"),"mDarkPanel",_ref.getField(false, "_mdarkpanel"),"mEnabled",_ref.getField(false, "_menabled"),"mEventName",_ref.getField(false, "_meventname"),"mLeftPanel",_ref.getField(false, "_mleftpanel"),"mSideWidth",_ref.getField(false, "_msidewidth"),"StartAtScrim",_ref.getField(false, "_startatscrim"),"TouchXStart",_ref.getField(false, "_touchxstart"),"TouchYStart",_ref.getField(false, "_touchystart"),"xui",_ref.getField(false, "_xui")};
}
}