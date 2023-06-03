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
public static boolean _isbioenabled = false;
public static String _question = "";
public static String _answer = "";
public static String _stegoimagepath = "";
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.encode _encode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.decode _decode = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static String  _ajustimageview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _imv,String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _delta = 0;
int _height = 0;
int _width = 0;
 //BA.debugLineNum = 89;BA.debugLine="Sub AjustImageView(Imv As ImageView, Dir As String";
 //BA.debugLineNum = 90;BA.debugLine="Private bmp As Bitmap = LoadBitmap(Dir, FileName)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(_dir,_filename);
 //BA.debugLineNum = 91;BA.debugLine="Dim Delta, Height, Width As Int";
_delta = 0;
_height = 0;
_width = 0;
 //BA.debugLineNum = 92;BA.debugLine="If bmp.Width / bmp.Height > Imv.Width / Imv.Heigh";
if (_bmp.getWidth()/(double)_bmp.getHeight()>_imv.getWidth()/(double)_imv.getHeight()) { 
 //BA.debugLineNum = 93;BA.debugLine="Height = bmp.Height / bmp.Width * Imv.Width";
_height = (int) (_bmp.getHeight()/(double)_bmp.getWidth()*_imv.getWidth());
 //BA.debugLineNum = 94;BA.debugLine="Delta = (Imv.Height - Height) / 2";
_delta = (int) ((_imv.getHeight()-_height)/(double)2);
 //BA.debugLineNum = 95;BA.debugLine="Imv.Height = Height";
_imv.setHeight(_height);
 //BA.debugLineNum = 96;BA.debugLine="Imv.Top = Imv.Top + Delta";
_imv.setTop((int) (_imv.getTop()+_delta));
 }else {
 //BA.debugLineNum = 98;BA.debugLine="Width = bmp.Width / bmp.Height * Imv.Height";
_width = (int) (_bmp.getWidth()/(double)_bmp.getHeight()*_imv.getHeight());
 //BA.debugLineNum = 99;BA.debugLine="Delta = (Imv.Width - Width) / 2";
_delta = (int) ((_imv.getWidth()-_width)/(double)2);
 //BA.debugLineNum = 100;BA.debugLine="Imv.Width = Width";
_imv.setWidth(_width);
 //BA.debugLineNum = 101;BA.debugLine="Imv.Left = Imv.Left + Delta";
_imv.setLeft((int) (_imv.getLeft()+_delta));
 };
 //BA.debugLineNum = 103;BA.debugLine="Imv.Gravity = Gravity.FILL";
_imv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 104;BA.debugLine="Imv.Bitmap = bmp";
_imv.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.BitmapDrawable  _bitmaptobitmapdrawable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap) throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
 //BA.debugLineNum = 128;BA.debugLine="Sub BitmapToBitmapDrawable (bitmap As Bitmap) As B";
 //BA.debugLineNum = 129;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 130;BA.debugLine="bd.Initialize(bitmap)";
_bd.Initialize((android.graphics.Bitmap)(_bitmap.getObject()));
 //BA.debugLineNum = 131;BA.debugLine="Return bd";
if (true) return _bd;
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return null;
}
public static String  _displaymessage(anywheresoftware.b4a.BA _ba,String _message,anywheresoftware.b4a.objects.LabelWrapper _lbldisplay,boolean _success) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Sub displayMessage(message As String,lblDisplay As";
 //BA.debugLineNum = 195;BA.debugLine="lblDisplay.Text=message";
_lbldisplay.setText(BA.ObjectToCharSequence(_message));
 //BA.debugLineNum = 196;BA.debugLine="If success=True Then";
if (_success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 197;BA.debugLine="lblDisplay.TextColor=Colors.Blue";
_lbldisplay.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 }else {
 //BA.debugLineNum = 199;BA.debugLine="lblDisplay.TextColor=Colors.Red";
_lbldisplay.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 };
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public static boolean  _getbiometric(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub getBiometric() As Boolean";
 //BA.debugLineNum = 56;BA.debugLine="isBioEnabled=True";
_isbioenabled = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 58;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 61;BA.debugLine="isBioEnabled = SharedPrefs.GetBoolean(\"Biometric\"";
_isbioenabled = _sharedprefs.GetBoolean("Biometric",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 63;BA.debugLine="Return isBioEnabled";
if (true) return _isbioenabled;
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return false;
}
public static String  _getfileextension(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Sub getFileExtension(filename As String) As String";
 //BA.debugLineNum = 204;BA.debugLine="Return filename.SubString(filename.LastIndexOf(\".";
if (true) return _filename.substring((int) (_filename.lastIndexOf(".")+1));
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _getfileinfobyindex(anywheresoftware.b4a.BA _ba,String _column,String _uri) throws Exception{
String _results = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri1 = null;
anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
int _i = 0;
String _id = "";
 //BA.debugLineNum = 145;BA.debugLine="Sub GetFileInfoByIndex(column As String, uri As St";
 //BA.debugLineNum = 147;BA.debugLine="Dim results As String";
_results = "";
 //BA.debugLineNum = 148;BA.debugLine="Dim Cur As Cursor";
_cur = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 149;BA.debugLine="Dim Uri1 As Uri";
_uri1 = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 150;BA.debugLine="Dim cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
 //BA.debugLineNum = 151;BA.debugLine="cr.Initialize(\"\")";
_cr.Initialize("");
 //BA.debugLineNum = 154;BA.debugLine="If uri.StartsWith(\"content://media/\") Then";
if (_uri.startsWith("content://media/")) { 
 //BA.debugLineNum = 155;BA.debugLine="Dim i As Int = uri.LastIndexOf(\"/\")";
_i = _uri.lastIndexOf("/");
 //BA.debugLineNum = 156;BA.debugLine="Dim id As String = uri.SubString(i + 1)";
_id = _uri.substring((int) (_i+1));
 //BA.debugLineNum = 157;BA.debugLine="Uri1.Parse(uri)";
_uri1.Parse(_uri);
 //BA.debugLineNum = 158;BA.debugLine="Cur = cr.Query(Uri1, Null, \"_id = ?\", Array As S";
_cur = _cr.Query(_uri1,(String[])(anywheresoftware.b4a.keywords.Common.Null),"_id = ?",new String[]{_id},BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 159;BA.debugLine="Cur.Position = 0";
_cur.setPosition((int) (0));
 //BA.debugLineNum = 160;BA.debugLine="If Cur.RowCount <> 0 Then";
if (_cur.getRowCount()!=0) { 
 //BA.debugLineNum = 161;BA.debugLine="For i = 0 To Cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 162;BA.debugLine="If Cur.GetColumnName(i) <> Null Then";
if (_cur.GetColumnName(_i)!= null) { 
 //BA.debugLineNum = 163;BA.debugLine="If Cur.GetColumnName(i) = column Then";
if ((_cur.GetColumnName(_i)).equals(_column)) { 
 //BA.debugLineNum = 164;BA.debugLine="results = Cur.GetString2(i)";
_results = _cur.GetString2(_i);
 //BA.debugLineNum = 165;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 };
 }else {
 //BA.debugLineNum = 171;BA.debugLine="Uri1.Parse(uri)";
_uri1.Parse(_uri);
 //BA.debugLineNum = 172;BA.debugLine="Cur = cr.Query(Uri1, Null, Null, Null, Null)";
_cur = _cr.Query(_uri1,(String[])(anywheresoftware.b4a.keywords.Common.Null),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null),(String[])(anywheresoftware.b4a.keywords.Common.Null),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 173;BA.debugLine="Cur.Position = 0";
_cur.setPosition((int) (0));
 //BA.debugLineNum = 174;BA.debugLine="If Cur.RowCount <> 0 Then";
if (_cur.getRowCount()!=0) { 
 //BA.debugLineNum = 175;BA.debugLine="For i = 0 To Cur.ColumnCount - 1";
{
final int step27 = 1;
final int limit27 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
 //BA.debugLineNum = 176;BA.debugLine="If Cur.GetColumnName(i) <> Null Then";
if (_cur.GetColumnName(_i)!= null) { 
 //BA.debugLineNum = 177;BA.debugLine="If Cur.GetColumnName(i) = column Then";
if ((_cur.GetColumnName(_i)).equals(_column)) { 
 //BA.debugLineNum = 178;BA.debugLine="results = Cur.GetString2(i)";
_results = _cur.GetString2(_i);
 //BA.debugLineNum = 179;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 };
 };
 //BA.debugLineNum = 186;BA.debugLine="Cur.Close";
_cur.Close();
 //BA.debugLineNum = 188;BA.debugLine="Return results";
if (true) return _results;
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _getsecurityanswer(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub getSecurityAnswer() As String";
 //BA.debugLineNum = 79;BA.debugLine="answer=\"\"";
_answer = "";
 //BA.debugLineNum = 81;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 84;BA.debugLine="answer = SharedPrefs.GetString(\"Answer\", \"\")";
_answer = _sharedprefs.GetString("Answer","");
 //BA.debugLineNum = 86;BA.debugLine="Return answer";
if (true) return _answer;
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _getsecurityquestion(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub getSecurityQuestion() As String";
 //BA.debugLineNum = 67;BA.debugLine="question=\"\"";
_question = "";
 //BA.debugLineNum = 69;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 72;BA.debugLine="question = SharedPrefs.GetString(\"Question\", \"\")";
_question = _sharedprefs.GetString("Question","");
 //BA.debugLineNum = 74;BA.debugLine="Return question";
if (true) return _question;
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _getuserpin(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub getUserPin() As String";
 //BA.debugLineNum = 18;BA.debugLine="userPin=\"\"";
_userpin = "";
 //BA.debugLineNum = 20;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 22;BA.debugLine="userPin = SharedPrefs.GetString(\"PIN\",\"\")";
_userpin = _sharedprefs.GetString("PIN","");
 //BA.debugLineNum = 23;BA.debugLine="Return userPin";
if (true) return _userpin;
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static boolean  _isfirstrun(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub isFirstRun() As Boolean";
 //BA.debugLineNum = 44;BA.debugLine="firstRun=True";
_firstrun = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 46;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 49;BA.debugLine="firstRun = SharedPrefs.GetBoolean(\"FirstRun\", Tru";
_firstrun = _sharedprefs.GetBoolean("FirstRun",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 51;BA.debugLine="Return firstRun";
if (true) return _firstrun;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Dim isBioEnabled As Boolean=True";
_isbioenabled = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 12;BA.debugLine="Dim question As String=\"\"";
_question = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim answer As String=\"\"sss";
_answer = "";
 //BA.debugLineNum = 14;BA.debugLine="Public stegoImagePath As String = Starter.rp.GetS";
_stegoimagepath = mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .GetSafeDirDefaultExternal("stegoimages");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _resizelabelheight(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.LabelWrapper _lbl) throws Exception{
anywheresoftware.b4a.objects.StringUtils _su = null;
 //BA.debugLineNum = 134;BA.debugLine="Sub ResizeLabelHeight(lbl As Label)";
 //BA.debugLineNum = 135;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 136;BA.debugLine="lbl.Height = su.MeasureMultilineTextHeight(lbl, l";
_lbl.setHeight(_su.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_lbl.getText())));
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public static String  _savesecurityqa(anywheresoftware.b4a.BA _ba,String _quest,String _ans) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub saveSecurityQA(quest As String,ans As String)";
 //BA.debugLineNum = 36;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 38;BA.debugLine="SharedPrefs.SaveString(\"Question\",quest)";
_sharedprefs.SaveString("Question",_quest);
 //BA.debugLineNum = 39;BA.debugLine="SharedPrefs.SaveString(\"Answer\",ans)";
_sharedprefs.SaveString("Answer",_ans);
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusnavbarcolor(anywheresoftware.b4a.BA _ba,int _clr,boolean _dark) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
anywheresoftware.b4j.object.JavaObject _view = null;
 //BA.debugLineNum = 107;BA.debugLine="Sub SetStatusNavBarColor(clr As Int, dark As Boole";
 //BA.debugLineNum = 108;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 109;BA.debugLine="If p.SdkVersion > 20 Then";
if (_p.getSdkVersion()>20) { 
 //BA.debugLineNum = 111;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 112;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 113;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 114;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(((int)0x80000000))});
 //BA.debugLineNum = 115;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(((int)0x04000000))});
 //BA.debugLineNum = 116;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 //BA.debugLineNum = 117;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
_window.RunMethod("setNavigationBarColor",new Object[]{(Object)(_clr)});
 //BA.debugLineNum = 118;BA.debugLine="Dim view As JavaObject = window.RunMethodJO(\"get";
_view = new anywheresoftware.b4j.object.JavaObject();
_view = _window.RunMethodJO("getDecorView",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 119;BA.debugLine="If dark=True Then";
if (_dark==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 120;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(Bi";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.Bit.Or(((int)0x00002000),(int)(BA.ObjectToNumber(_view.RunMethod("getSystemUiVisibility",(Object[])(anywheresoftware.b4a.keywords.Common.Null))))))});
 }else {
 //BA.debugLineNum = 122;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(0)";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(0)});
 };
 };
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static String  _setuserpin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub setUserPin(pin As String)";
 //BA.debugLineNum = 29;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
 //BA.debugLineNum = 31;BA.debugLine="SharedPrefs.SaveString(\"PIN\",pin)";
_sharedprefs.SaveString("PIN",_pin);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
}
