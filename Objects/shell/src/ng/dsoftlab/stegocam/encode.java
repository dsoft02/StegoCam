
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

public class encode implements IRemote{
	public static encode mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public encode() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("encode"), "ng.dsoftlab.stegocam.encode");
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
		pcBA = new PCBA(this, encode.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ion = RemoteObject.declareNull("Object");
public static RemoteObject _tempimagefile = RemoteObject.createImmutable("");
public static RemoteObject _lastpicture = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _imagechooser = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _filehandler1 = RemoteObject.declareNull("ng.dsoftlab.stegocam.filehandler");
public static RemoteObject _stegohandler = RemoteObject.declareNull("ng.dsoftlab.stegocam.stegocamhandler");
public static RemoteObject _actoolbarlight1 = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
public static RemoteObject _toolbarhelper = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACActionBar");
public static RemoteObject _sharedprefs = RemoteObject.declareNull("com.b4x.sharedpreferences.SharedPreferences");
public static RemoteObject _ime = RemoteObject.declareNull("anywheresoftware.b4a.objects.IME");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _dialog = RemoteObject.declareNull("ng.dsoftlab.stegocam.b4xdialog");
public static RemoteObject _btncancel = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnencode = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imageview2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _imageview3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _imageview4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _lblerrormsg = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlencryption = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlfile = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlkey = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlmessage = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _rboxencodefile = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _rboxencodetext = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _txtfilename = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtkey = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtmessage = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _imgcover = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _pnlcoverimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cboencryption = RemoteObject.declareNull("ng.dsoftlab.stegocam.b4xcombobox");
public static RemoteObject _toast = RemoteObject.declareNull("ng.dsoftlab.stegocam.bctoast");
public static RemoteObject _btnbrowse = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _lblshowpassword = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _imgpreview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _btnextract = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnshare = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblimglocation = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlpreview = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _imgdelete = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _imgextract = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _imgshare = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnldelete = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlextract = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlshare = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ng.dsoftlab.stegocam.main _main = null;
public static ng.dsoftlab.stegocam.starter _starter = null;
public static ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public static ng.dsoftlab.stegocam.config _config = null;
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
		return new Object[] {"Activity",encode.mostCurrent._activity,"ACToolBarLight1",encode.mostCurrent._actoolbarlight1,"B4XCollections",Debug.moduleToString(ng.dsoftlab.stegocam.b4xcollections.class),"btnBrowse",encode.mostCurrent._btnbrowse,"btnCancel",encode.mostCurrent._btncancel,"btnEncode",encode.mostCurrent._btnencode,"btnExtract",encode.mostCurrent._btnextract,"btnShare",encode.mostCurrent._btnshare,"cboEncryption",encode.mostCurrent._cboencryption,"config",Debug.moduleToString(ng.dsoftlab.stegocam.config.class),"DateUtils",encode.mostCurrent._dateutils,"Dialog",encode.mostCurrent._dialog,"FileHandler1",encode._filehandler1,"forgotpin",Debug.moduleToString(ng.dsoftlab.stegocam.forgotpin.class),"history",Debug.moduleToString(ng.dsoftlab.stegocam.history.class),"HttpUtils2Service",Debug.moduleToString(ng.dsoftlab.stegocam.httputils2service.class),"imageChooser",encode._imagechooser,"ImageView2",encode.mostCurrent._imageview2,"ImageView3",encode.mostCurrent._imageview3,"ImageView4",encode.mostCurrent._imageview4,"IME",encode.mostCurrent._ime,"imgCover",encode.mostCurrent._imgcover,"imgDelete",encode.mostCurrent._imgdelete,"imgExtract",encode.mostCurrent._imgextract,"imgPreview",encode.mostCurrent._imgpreview,"imgShare",encode.mostCurrent._imgshare,"ion",encode._ion,"Label1",encode.mostCurrent._label1,"Label2",encode.mostCurrent._label2,"Label4",encode.mostCurrent._label4,"lastPicture",encode._lastpicture,"lblErrorMsg",encode.mostCurrent._lblerrormsg,"lblImgLocation",encode.mostCurrent._lblimglocation,"lblShowPassword",encode.mostCurrent._lblshowpassword,"Login",Debug.moduleToString(ng.dsoftlab.stegocam.login.class),"Main",Debug.moduleToString(ng.dsoftlab.stegocam.main.class),"mainmenu",Debug.moduleToString(ng.dsoftlab.stegocam.mainmenu.class),"PinChange",Debug.moduleToString(ng.dsoftlab.stegocam.pinchange.class),"pinreset",Debug.moduleToString(ng.dsoftlab.stegocam.pinreset.class),"PinSetup",Debug.moduleToString(ng.dsoftlab.stegocam.pinsetup.class),"pnlCoverImage",encode.mostCurrent._pnlcoverimage,"pnlDelete",encode.mostCurrent._pnldelete,"pnlEncryption",encode.mostCurrent._pnlencryption,"pnlExtract",encode.mostCurrent._pnlextract,"pnlFile",encode.mostCurrent._pnlfile,"pnlKey",encode.mostCurrent._pnlkey,"pnlMessage",encode.mostCurrent._pnlmessage,"pnlPreview",encode.mostCurrent._pnlpreview,"pnlShare",encode.mostCurrent._pnlshare,"rboxEncodeFile",encode.mostCurrent._rboxencodefile,"rboxEncodeText",encode.mostCurrent._rboxencodetext,"securityquestion",Debug.moduleToString(ng.dsoftlab.stegocam.securityquestion.class),"settings",Debug.moduleToString(ng.dsoftlab.stegocam.settings.class),"SharedPrefs",encode.mostCurrent._sharedprefs,"Starter",Debug.moduleToString(ng.dsoftlab.stegocam.starter.class),"stegoHandler",encode._stegohandler,"tempImageFile",encode._tempimagefile,"toast",encode.mostCurrent._toast,"ToolbarHelper",encode.mostCurrent._toolbarhelper,"txtFilename",encode.mostCurrent._txtfilename,"txtKey",encode.mostCurrent._txtkey,"txtMessage",encode.mostCurrent._txtmessage,"xui",encode.mostCurrent._xui,"XUIViewsUtils",Debug.moduleToString(ng.dsoftlab.stegocam.xuiviewsutils.class)};
}
}