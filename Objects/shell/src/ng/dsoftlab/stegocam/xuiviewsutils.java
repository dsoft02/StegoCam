
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

public class xuiviewsutils implements IRemote{
	public static xuiviewsutils mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public xuiviewsutils() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, xuiviewsutils.class);
    static {
		mostCurrent = new xuiviewsutils();
        remoteMe = RemoteObject.declareNull("ng.dsoftlab.stegocam.xuiviewsutils");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("xuiviewsutils"), "ng.dsoftlab.stegocam.xuiviewsutils");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("ng.dsoftlab.stegocam.xuiviewsutils"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _utilsinitialized = RemoteObject.createImmutable(false);
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
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
  public Object[] GetGlobals() {
		return new Object[] {"B4XCollections",Debug.moduleToString(ng.dsoftlab.stegocam.b4xcollections.class),"config",Debug.moduleToString(ng.dsoftlab.stegocam.config.class),"DateUtils",xuiviewsutils.mostCurrent._dateutils,"encode",Debug.moduleToString(ng.dsoftlab.stegocam.encode.class),"forgotpin",Debug.moduleToString(ng.dsoftlab.stegocam.forgotpin.class),"history",Debug.moduleToString(ng.dsoftlab.stegocam.history.class),"HttpUtils2Service",Debug.moduleToString(ng.dsoftlab.stegocam.httputils2service.class),"Login",Debug.moduleToString(ng.dsoftlab.stegocam.login.class),"Main",Debug.moduleToString(ng.dsoftlab.stegocam.main.class),"mainmenu",Debug.moduleToString(ng.dsoftlab.stegocam.mainmenu.class),"PinChange",Debug.moduleToString(ng.dsoftlab.stegocam.pinchange.class),"pinreset",Debug.moduleToString(ng.dsoftlab.stegocam.pinreset.class),"PinSetup",Debug.moduleToString(ng.dsoftlab.stegocam.pinsetup.class),"securityquestion",Debug.moduleToString(ng.dsoftlab.stegocam.securityquestion.class),"settings",Debug.moduleToString(ng.dsoftlab.stegocam.settings.class),"Starter",Debug.moduleToString(ng.dsoftlab.stegocam.starter.class),"UtilsInitialized",xuiviewsutils._utilsinitialized,"xui",xuiviewsutils._xui};
}
}