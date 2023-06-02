
package ng.dsoftlab.stegocam;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "ng.dsoftlab.stegocam.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _imgicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _splashtimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _firstrun = RemoteObject.createImmutable(false);
public static RemoteObject _userpin = RemoteObject.createImmutable("");
public static RemoteObject _sharedprefs = RemoteObject.declareNull("com.b4x.sharedpreferences.SharedPreferences");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
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
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"B4XCollections",Debug.moduleToString(ng.dsoftlab.stegocam.b4xcollections.class),"config",Debug.moduleToString(ng.dsoftlab.stegocam.config.class),"DateUtils",main.mostCurrent._dateutils,"encode",Debug.moduleToString(ng.dsoftlab.stegocam.encode.class),"firstRun",main._firstrun,"forgotpin",Debug.moduleToString(ng.dsoftlab.stegocam.forgotpin.class),"history",Debug.moduleToString(ng.dsoftlab.stegocam.history.class),"HttpUtils2Service",Debug.moduleToString(ng.dsoftlab.stegocam.httputils2service.class),"imgIcon",main.mostCurrent._imgicon,"Login",Debug.moduleToString(ng.dsoftlab.stegocam.login.class),"mainmenu",Debug.moduleToString(ng.dsoftlab.stegocam.mainmenu.class),"PinChange",Debug.moduleToString(ng.dsoftlab.stegocam.pinchange.class),"pinreset",Debug.moduleToString(ng.dsoftlab.stegocam.pinreset.class),"PinSetup",Debug.moduleToString(ng.dsoftlab.stegocam.pinsetup.class),"securityquestion",Debug.moduleToString(ng.dsoftlab.stegocam.securityquestion.class),"settings",Debug.moduleToString(ng.dsoftlab.stegocam.settings.class),"SharedPrefs",main.mostCurrent._sharedprefs,"splashTimer",main.mostCurrent._splashtimer,"Starter",Debug.moduleToString(ng.dsoftlab.stegocam.starter.class),"userPin",main.mostCurrent._userpin,"xui",main._xui,"XUIViewsUtils",Debug.moduleToString(ng.dsoftlab.stegocam.xuiviewsutils.class)};
}
}