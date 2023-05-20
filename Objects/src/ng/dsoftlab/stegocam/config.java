package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class config {
private static config mostCurrent = new config();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static char _show = '\0';
public static char _hide = '\0';
public static com.b4x.sharedpreferences.SharedPreferences _sharedprefs = null;
public static String _userpin = "";
public static boolean _firstrun = false;
public static String _question = "";
public static String _answer = "";
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public static String  _ajustimageview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _imv,String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _delta = 0;
int _height = 0;
int _width = 0;
 //BA.debugLineNum = 76;BA.debugLine="Sub AjustImageView(Imv As ImageView, Dir As String";
 //BA.debugLineNum = 77;BA.debugLine="Private bmp As Bitmap = LoadBitmap(Dir, FileName)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(_dir,_filename);
 //BA.debugLineNum = 78;BA.debugLine="Dim Delta, Height, Width As Int";
_delta = 0;
_height = 0;
_width = 0;
 //BA.debugLineNum = 79;BA.debugLine="If bmp.Width / bmp.Height > Imv.Width / Imv.Heigh";
if (_bmp.getWidth()/(double)_bmp.getHeight()>_imv.getWidth()/(double)_imv.getHeight()) { 
 //BA.debugLineNum = 80;BA.debugLine="Height = bmp.Height / bmp.Width * Imv.Width";
_height = (int) (_bmp.getHeight()/(double)_bmp.getWidth()*_imv.getWidth());
 //BA.debugLineNum = 81;BA.debugLine="Delta = (Imv.Height - Height) / 2";
_delta = (int) ((_imv.getHeight()-_height)/(double)2);
 //BA.debugLineNum = 82;BA.debugLine="Imv.Height = Height";
_imv.setHeight(_height);
 //BA.debugLineNum = 83;BA.debugLine="Imv.Top = Imv.Top + Delta";
_imv.setTop((int) (_imv.getTop()+_delta));
 }else {
 //BA.debugLineNum = 85;BA.debugLine="Width = bmp.Width / bmp.Height * Imv.Height";
_width = (int) (_bmp.getWidth()/(double)_bmp.getHeight()*_imv.getHeight());
 //BA.debugLineNum = 86;BA.debugLine="Delta = (Imv.Width - Width) / 2";
_delta = (int) ((_imv.getWidth()-_width)/(double)2);
 //BA.debugLineNum = 87;BA.debugLine="Imv.Width = Width";
_imv.setWidth(_width);
 //BA.debugLineNum = 88;BA.debugLine="Imv.Left = Imv.Left + Delta";
_imv.setLeft((int) (_imv.getLeft()+_delta));
 };
 //BA.debugLineNum = 90;BA.debugLine="Imv.Gravity = Gravity.FILL";
_imv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 91;BA.debugLine="Imv.Bitmap = bmp";
_imv.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.BitmapDrawable  _bitmaptobitmapdrawable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap) throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
 //BA.debugLineNum = 115;BA.debugLine="Sub BitmapToBitmapDrawable (bitmap As Bitmap) As B";
 //BA.debugLineNum = 116;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 117;BA.debugLine="bd.Initialize(bitmap)";
_bd.Initialize((android.graphics.Bitmap)(_bitmap.getObject()));
 //BA.debugLineNum = 118;BA.debugLine="Return bd";
if (true) return _bd;
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return null;
}
public static String  _getsecurityanswer(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub getSecurityAnswer() As String";
 //BA.debugLineNum = 66;BA.debugLine="answer=\"\"";
_answer = "";
 //BA.debugLineNum = 68;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 71;BA.debugLine="answer = SharedPrefs.GetBoolean(\"Answer\", True)";
_answer = BA.ObjectToString(_sharedprefs.GetBoolean("Answer",anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 73;BA.debugLine="Return answer";
if (true) return _answer;
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _getsecurityquestion(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub getSecurityQuestion() As String";
 //BA.debugLineNum = 54;BA.debugLine="question=\"\"";
_question = "";
 //BA.debugLineNum = 56;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 59;BA.debugLine="question = SharedPrefs.GetBoolean(\"Question\", Tru";
_question = BA.ObjectToString(_sharedprefs.GetBoolean("Question",anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 61;BA.debugLine="Return question";
if (true) return _question;
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _getuserpin(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub getUserPin() As String";
 //BA.debugLineNum = 16;BA.debugLine="userPin=\"\"";
_userpin = "";
 //BA.debugLineNum = 18;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 20;BA.debugLine="userPin = SharedPrefs.GetString(\"PIN\",\"\")";
_userpin = _sharedprefs.GetString("PIN","");
 //BA.debugLineNum = 21;BA.debugLine="Return userPin";
if (true) return _userpin;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static boolean  _isfirstrun(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Sub isFirstRun() As Boolean";
 //BA.debugLineNum = 42;BA.debugLine="firstRun=True";
_firstrun = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 44;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 47;BA.debugLine="firstRun = SharedPrefs.GetBoolean(\"FirstRun\", Tru";
_firstrun = _sharedprefs.GetBoolean("FirstRun",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 49;BA.debugLine="Return firstRun";
if (true) return _firstrun;
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public show As Char = Chr(0xF06E)";
_show = anywheresoftware.b4a.keywords.Common.Chr(((int)0xf06e));
 //BA.debugLineNum = 7;BA.debugLine="Public hide As Char = Chr(0xF070)";
_hide = anywheresoftware.b4a.keywords.Common.Chr(((int)0xf070));
 //BA.debugLineNum = 8;BA.debugLine="Dim SharedPrefs As SharedPreferences";
_sharedprefs = new com.b4x.sharedpreferences.SharedPreferences();
 //BA.debugLineNum = 9;BA.debugLine="Dim userPin As String =\"\"";
_userpin = "";
 //BA.debugLineNum = 10;BA.debugLine="Dim firstRun As Boolean=True";
_firstrun = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 11;BA.debugLine="Dim question As String=\"\"";
_question = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim answer As String=\"\"";
_answer = "";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _savesecurityqa(anywheresoftware.b4a.BA _ba,String _quest,String _ans) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub saveSecurityQA(quest As String,ans As String)";
 //BA.debugLineNum = 34;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 36;BA.debugLine="SharedPrefs.SaveString(\"Question\",quest)";
_sharedprefs.SaveString("Question",_quest);
 //BA.debugLineNum = 37;BA.debugLine="SharedPrefs.SaveString(\"Answer\",ans)";
_sharedprefs.SaveString("Answer",_ans);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusnavbarcolor(anywheresoftware.b4a.BA _ba,int _clr,boolean _dark) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
anywheresoftware.b4j.object.JavaObject _view = null;
 //BA.debugLineNum = 94;BA.debugLine="Sub SetStatusNavBarColor(clr As Int, dark As Boole";
 //BA.debugLineNum = 95;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 96;BA.debugLine="If p.SdkVersion > 20 Then";
if (_p.getSdkVersion()>20) { 
 //BA.debugLineNum = 98;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 99;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 100;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 101;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(((int)0x80000000))});
 //BA.debugLineNum = 102;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(((int)0x04000000))});
 //BA.debugLineNum = 103;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 //BA.debugLineNum = 104;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
_window.RunMethod("setNavigationBarColor",new Object[]{(Object)(_clr)});
 //BA.debugLineNum = 105;BA.debugLine="Dim view As JavaObject = window.RunMethodJO(\"get";
_view = new anywheresoftware.b4j.object.JavaObject();
_view = _window.RunMethodJO("getDecorView",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 106;BA.debugLine="If dark=True Then";
if (_dark==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 107;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(Bi";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.Bit.Or(((int)0x00002000),(int)(BA.ObjectToNumber(_view.RunMethod("getSystemUiVisibility",(Object[])(anywheresoftware.b4a.keywords.Common.Null))))))});
 }else {
 //BA.debugLineNum = 109;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(0)";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(0)});
 };
 };
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _setuserpin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub setUserPin(pin As String)";
 //BA.debugLineNum = 27;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 29;BA.debugLine="SharedPrefs.SaveString(\"PIN\",pin)";
_sharedprefs.SaveString("PIN",_pin);
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
}
