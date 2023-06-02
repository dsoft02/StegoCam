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
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public static boolean  _isfirstrun(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "isfirstrun", false))
	 {return ((Boolean) Debug.delegate(null, "isfirstrun", new Object[] {_ba}));}
RDebugUtils.currentLine=39256064;
 //BA.debugLineNum = 39256064;BA.debugLine="Sub isFirstRun() As Boolean";
RDebugUtils.currentLine=39256065;
 //BA.debugLineNum = 39256065;BA.debugLine="firstRun=True";
_firstrun = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=39256067;
 //BA.debugLineNum = 39256067;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39256070;
 //BA.debugLineNum = 39256070;BA.debugLine="firstRun = SharedPrefs.GetBoolean(\"FirstRun\", Tru";
_firstrun = _sharedprefs.GetBoolean("FirstRun",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39256072;
 //BA.debugLineNum = 39256072;BA.debugLine="Return firstRun";
if (true) return _firstrun;
RDebugUtils.currentLine=39256073;
 //BA.debugLineNum = 39256073;BA.debugLine="End Sub";
return false;
}
public static String  _getuserpin(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "getuserpin", false))
	 {return ((String) Debug.delegate(null, "getuserpin", new Object[] {_ba}));}
RDebugUtils.currentLine=39059456;
 //BA.debugLineNum = 39059456;BA.debugLine="Sub getUserPin() As String";
RDebugUtils.currentLine=39059457;
 //BA.debugLineNum = 39059457;BA.debugLine="userPin=\"\"";
_userpin = "";
RDebugUtils.currentLine=39059459;
 //BA.debugLineNum = 39059459;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39059461;
 //BA.debugLineNum = 39059461;BA.debugLine="userPin = SharedPrefs.GetString(\"PIN\",\"\")";
_userpin = _sharedprefs.GetString("PIN","");
RDebugUtils.currentLine=39059462;
 //BA.debugLineNum = 39059462;BA.debugLine="Return userPin";
if (true) return _userpin;
RDebugUtils.currentLine=39059463;
 //BA.debugLineNum = 39059463;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.BitmapDrawable  _bitmaptobitmapdrawable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "bitmaptobitmapdrawable", false))
	 {return ((anywheresoftware.b4a.objects.drawable.BitmapDrawable) Debug.delegate(null, "bitmaptobitmapdrawable", new Object[] {_ba,_bitmap}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
RDebugUtils.currentLine=39649280;
 //BA.debugLineNum = 39649280;BA.debugLine="Sub BitmapToBitmapDrawable (bitmap As Bitmap) As B";
RDebugUtils.currentLine=39649281;
 //BA.debugLineNum = 39649281;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=39649282;
 //BA.debugLineNum = 39649282;BA.debugLine="bd.Initialize(bitmap)";
_bd.Initialize((android.graphics.Bitmap)(_bitmap.getObject()));
RDebugUtils.currentLine=39649283;
 //BA.debugLineNum = 39649283;BA.debugLine="Return bd";
if (true) return _bd;
RDebugUtils.currentLine=39649284;
 //BA.debugLineNum = 39649284;BA.debugLine="End Sub";
return null;
}
public static String  _ajustimageview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _imv,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "ajustimageview", false))
	 {return ((String) Debug.delegate(null, "ajustimageview", new Object[] {_ba,_imv,_dir,_filename}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _delta = 0;
int _height = 0;
int _width = 0;
RDebugUtils.currentLine=39518208;
 //BA.debugLineNum = 39518208;BA.debugLine="Sub AjustImageView(Imv As ImageView, Dir As String";
RDebugUtils.currentLine=39518209;
 //BA.debugLineNum = 39518209;BA.debugLine="Private bmp As Bitmap = LoadBitmap(Dir, FileName)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(_dir,_filename);
RDebugUtils.currentLine=39518210;
 //BA.debugLineNum = 39518210;BA.debugLine="Dim Delta, Height, Width As Int";
_delta = 0;
_height = 0;
_width = 0;
RDebugUtils.currentLine=39518211;
 //BA.debugLineNum = 39518211;BA.debugLine="If bmp.Width / bmp.Height > Imv.Width / Imv.Heigh";
if (_bmp.getWidth()/(double)_bmp.getHeight()>_imv.getWidth()/(double)_imv.getHeight()) { 
RDebugUtils.currentLine=39518212;
 //BA.debugLineNum = 39518212;BA.debugLine="Height = bmp.Height / bmp.Width * Imv.Width";
_height = (int) (_bmp.getHeight()/(double)_bmp.getWidth()*_imv.getWidth());
RDebugUtils.currentLine=39518213;
 //BA.debugLineNum = 39518213;BA.debugLine="Delta = (Imv.Height - Height) / 2";
_delta = (int) ((_imv.getHeight()-_height)/(double)2);
RDebugUtils.currentLine=39518214;
 //BA.debugLineNum = 39518214;BA.debugLine="Imv.Height = Height";
_imv.setHeight(_height);
RDebugUtils.currentLine=39518215;
 //BA.debugLineNum = 39518215;BA.debugLine="Imv.Top = Imv.Top + Delta";
_imv.setTop((int) (_imv.getTop()+_delta));
 }else {
RDebugUtils.currentLine=39518217;
 //BA.debugLineNum = 39518217;BA.debugLine="Width = bmp.Width / bmp.Height * Imv.Height";
_width = (int) (_bmp.getWidth()/(double)_bmp.getHeight()*_imv.getHeight());
RDebugUtils.currentLine=39518218;
 //BA.debugLineNum = 39518218;BA.debugLine="Delta = (Imv.Width - Width) / 2";
_delta = (int) ((_imv.getWidth()-_width)/(double)2);
RDebugUtils.currentLine=39518219;
 //BA.debugLineNum = 39518219;BA.debugLine="Imv.Width = Width";
_imv.setWidth(_width);
RDebugUtils.currentLine=39518220;
 //BA.debugLineNum = 39518220;BA.debugLine="Imv.Left = Imv.Left + Delta";
_imv.setLeft((int) (_imv.getLeft()+_delta));
 };
RDebugUtils.currentLine=39518222;
 //BA.debugLineNum = 39518222;BA.debugLine="Imv.Gravity = Gravity.FILL";
_imv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=39518223;
 //BA.debugLineNum = 39518223;BA.debugLine="Imv.Bitmap = bmp";
_imv.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=39518224;
 //BA.debugLineNum = 39518224;BA.debugLine="End Sub";
return "";
}
public static boolean  _getbiometric(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "getbiometric", false))
	 {return ((Boolean) Debug.delegate(null, "getbiometric", new Object[] {_ba}));}
RDebugUtils.currentLine=39321600;
 //BA.debugLineNum = 39321600;BA.debugLine="Sub getBiometric() As Boolean";
RDebugUtils.currentLine=39321601;
 //BA.debugLineNum = 39321601;BA.debugLine="isBioEnabled=True";
_isbioenabled = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=39321603;
 //BA.debugLineNum = 39321603;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39321606;
 //BA.debugLineNum = 39321606;BA.debugLine="isBioEnabled = SharedPrefs.GetBoolean(\"Biometric\"";
_isbioenabled = _sharedprefs.GetBoolean("Biometric",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=39321608;
 //BA.debugLineNum = 39321608;BA.debugLine="Return isBioEnabled";
if (true) return _isbioenabled;
RDebugUtils.currentLine=39321609;
 //BA.debugLineNum = 39321609;BA.debugLine="End Sub";
return false;
}
public static String  _getfileinfobyindex(anywheresoftware.b4a.BA _ba,String _column,String _uri) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "getfileinfobyindex", false))
	 {return ((String) Debug.delegate(null, "getfileinfobyindex", new Object[] {_ba,_column,_uri}));}
String _results = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri1 = null;
anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
int _i = 0;
String _id = "";
RDebugUtils.currentLine=62062592;
 //BA.debugLineNum = 62062592;BA.debugLine="Sub GetFileInfoByIndex(column As String, uri As St";
RDebugUtils.currentLine=62062594;
 //BA.debugLineNum = 62062594;BA.debugLine="Dim results As String";
_results = "";
RDebugUtils.currentLine=62062595;
 //BA.debugLineNum = 62062595;BA.debugLine="Dim Cur As Cursor";
_cur = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=62062596;
 //BA.debugLineNum = 62062596;BA.debugLine="Dim Uri1 As Uri";
_uri1 = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=62062597;
 //BA.debugLineNum = 62062597;BA.debugLine="Dim cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
RDebugUtils.currentLine=62062598;
 //BA.debugLineNum = 62062598;BA.debugLine="cr.Initialize(\"\")";
_cr.Initialize("");
RDebugUtils.currentLine=62062601;
 //BA.debugLineNum = 62062601;BA.debugLine="If uri.StartsWith(\"content://media/\") Then";
if (_uri.startsWith("content://media/")) { 
RDebugUtils.currentLine=62062602;
 //BA.debugLineNum = 62062602;BA.debugLine="Dim i As Int = uri.LastIndexOf(\"/\")";
_i = _uri.lastIndexOf("/");
RDebugUtils.currentLine=62062603;
 //BA.debugLineNum = 62062603;BA.debugLine="Dim id As String = uri.SubString(i + 1)";
_id = _uri.substring((int) (_i+1));
RDebugUtils.currentLine=62062604;
 //BA.debugLineNum = 62062604;BA.debugLine="Uri1.Parse(uri)";
_uri1.Parse(_uri);
RDebugUtils.currentLine=62062605;
 //BA.debugLineNum = 62062605;BA.debugLine="Cur = cr.Query(Uri1, Null, \"_id = ?\", Array As S";
_cur = _cr.Query(_uri1,(String[])(anywheresoftware.b4a.keywords.Common.Null),"_id = ?",new String[]{_id},BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=62062606;
 //BA.debugLineNum = 62062606;BA.debugLine="Cur.Position = 0";
_cur.setPosition((int) (0));
RDebugUtils.currentLine=62062607;
 //BA.debugLineNum = 62062607;BA.debugLine="If Cur.RowCount <> 0 Then";
if (_cur.getRowCount()!=0) { 
RDebugUtils.currentLine=62062608;
 //BA.debugLineNum = 62062608;BA.debugLine="For i = 0 To Cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
RDebugUtils.currentLine=62062609;
 //BA.debugLineNum = 62062609;BA.debugLine="If Cur.GetColumnName(i) <> Null Then";
if (_cur.GetColumnName(_i)!= null) { 
RDebugUtils.currentLine=62062610;
 //BA.debugLineNum = 62062610;BA.debugLine="If Cur.GetColumnName(i) = column Then";
if ((_cur.GetColumnName(_i)).equals(_column)) { 
RDebugUtils.currentLine=62062611;
 //BA.debugLineNum = 62062611;BA.debugLine="results = Cur.GetString2(i)";
_results = _cur.GetString2(_i);
RDebugUtils.currentLine=62062612;
 //BA.debugLineNum = 62062612;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 };
 }else {
RDebugUtils.currentLine=62062618;
 //BA.debugLineNum = 62062618;BA.debugLine="Uri1.Parse(uri)";
_uri1.Parse(_uri);
RDebugUtils.currentLine=62062619;
 //BA.debugLineNum = 62062619;BA.debugLine="Cur = cr.Query(Uri1, Null, Null, Null, Null)";
_cur = _cr.Query(_uri1,(String[])(anywheresoftware.b4a.keywords.Common.Null),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null),(String[])(anywheresoftware.b4a.keywords.Common.Null),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=62062620;
 //BA.debugLineNum = 62062620;BA.debugLine="Cur.Position = 0";
_cur.setPosition((int) (0));
RDebugUtils.currentLine=62062621;
 //BA.debugLineNum = 62062621;BA.debugLine="If Cur.RowCount <> 0 Then";
if (_cur.getRowCount()!=0) { 
RDebugUtils.currentLine=62062622;
 //BA.debugLineNum = 62062622;BA.debugLine="For i = 0 To Cur.ColumnCount - 1";
{
final int step27 = 1;
final int limit27 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
RDebugUtils.currentLine=62062623;
 //BA.debugLineNum = 62062623;BA.debugLine="If Cur.GetColumnName(i) <> Null Then";
if (_cur.GetColumnName(_i)!= null) { 
RDebugUtils.currentLine=62062624;
 //BA.debugLineNum = 62062624;BA.debugLine="If Cur.GetColumnName(i) = column Then";
if ((_cur.GetColumnName(_i)).equals(_column)) { 
RDebugUtils.currentLine=62062625;
 //BA.debugLineNum = 62062625;BA.debugLine="results = Cur.GetString2(i)";
_results = _cur.GetString2(_i);
RDebugUtils.currentLine=62062626;
 //BA.debugLineNum = 62062626;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 };
 };
RDebugUtils.currentLine=62062633;
 //BA.debugLineNum = 62062633;BA.debugLine="Cur.Close";
_cur.Close();
RDebugUtils.currentLine=62062635;
 //BA.debugLineNum = 62062635;BA.debugLine="Return results";
if (true) return _results;
RDebugUtils.currentLine=62062637;
 //BA.debugLineNum = 62062637;BA.debugLine="End Sub";
return "";
}
public static String  _getsecurityanswer(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "getsecurityanswer", false))
	 {return ((String) Debug.delegate(null, "getsecurityanswer", new Object[] {_ba}));}
RDebugUtils.currentLine=39452672;
 //BA.debugLineNum = 39452672;BA.debugLine="Sub getSecurityAnswer() As String";
RDebugUtils.currentLine=39452673;
 //BA.debugLineNum = 39452673;BA.debugLine="answer=\"\"";
_answer = "";
RDebugUtils.currentLine=39452675;
 //BA.debugLineNum = 39452675;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39452678;
 //BA.debugLineNum = 39452678;BA.debugLine="answer = SharedPrefs.GetString(\"Answer\", \"\")";
_answer = _sharedprefs.GetString("Answer","");
RDebugUtils.currentLine=39452680;
 //BA.debugLineNum = 39452680;BA.debugLine="Return answer";
if (true) return _answer;
RDebugUtils.currentLine=39452681;
 //BA.debugLineNum = 39452681;BA.debugLine="End Sub";
return "";
}
public static String  _getsecurityquestion(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "getsecurityquestion", false))
	 {return ((String) Debug.delegate(null, "getsecurityquestion", new Object[] {_ba}));}
RDebugUtils.currentLine=39387136;
 //BA.debugLineNum = 39387136;BA.debugLine="Sub getSecurityQuestion() As String";
RDebugUtils.currentLine=39387137;
 //BA.debugLineNum = 39387137;BA.debugLine="question=\"\"";
_question = "";
RDebugUtils.currentLine=39387139;
 //BA.debugLineNum = 39387139;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39387142;
 //BA.debugLineNum = 39387142;BA.debugLine="question = SharedPrefs.GetString(\"Question\", \"\")";
_question = _sharedprefs.GetString("Question","");
RDebugUtils.currentLine=39387144;
 //BA.debugLineNum = 39387144;BA.debugLine="Return question";
if (true) return _question;
RDebugUtils.currentLine=39387145;
 //BA.debugLineNum = 39387145;BA.debugLine="End Sub";
return "";
}
public static String  _resizelabelheight(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.LabelWrapper _lbl) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "resizelabelheight", false))
	 {return ((String) Debug.delegate(null, "resizelabelheight", new Object[] {_ba,_lbl}));}
anywheresoftware.b4a.objects.StringUtils _su = null;
RDebugUtils.currentLine=39714816;
 //BA.debugLineNum = 39714816;BA.debugLine="Sub ResizeLabelHeight(lbl As Label)";
RDebugUtils.currentLine=39714817;
 //BA.debugLineNum = 39714817;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=39714818;
 //BA.debugLineNum = 39714818;BA.debugLine="lbl.Height = su.MeasureMultilineTextHeight(lbl, l";
_lbl.setHeight(_su.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_lbl.getText())));
RDebugUtils.currentLine=39714819;
 //BA.debugLineNum = 39714819;BA.debugLine="End Sub";
return "";
}
public static String  _savesecurityqa(anywheresoftware.b4a.BA _ba,String _quest,String _ans) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "savesecurityqa", false))
	 {return ((String) Debug.delegate(null, "savesecurityqa", new Object[] {_ba,_quest,_ans}));}
RDebugUtils.currentLine=39190528;
 //BA.debugLineNum = 39190528;BA.debugLine="Sub saveSecurityQA(quest As String,ans As String)";
RDebugUtils.currentLine=39190530;
 //BA.debugLineNum = 39190530;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39190532;
 //BA.debugLineNum = 39190532;BA.debugLine="SharedPrefs.SaveString(\"Question\",quest)";
_sharedprefs.SaveString("Question",_quest);
RDebugUtils.currentLine=39190533;
 //BA.debugLineNum = 39190533;BA.debugLine="SharedPrefs.SaveString(\"Answer\",ans)";
_sharedprefs.SaveString("Answer",_ans);
RDebugUtils.currentLine=39190534;
 //BA.debugLineNum = 39190534;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusnavbarcolor(anywheresoftware.b4a.BA _ba,int _clr,boolean _dark) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "setstatusnavbarcolor", false))
	 {return ((String) Debug.delegate(null, "setstatusnavbarcolor", new Object[] {_ba,_clr,_dark}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
anywheresoftware.b4j.object.JavaObject _view = null;
RDebugUtils.currentLine=39583744;
 //BA.debugLineNum = 39583744;BA.debugLine="Sub SetStatusNavBarColor(clr As Int, dark As Boole";
RDebugUtils.currentLine=39583745;
 //BA.debugLineNum = 39583745;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=39583746;
 //BA.debugLineNum = 39583746;BA.debugLine="If p.SdkVersion > 20 Then";
if (_p.getSdkVersion()>20) { 
RDebugUtils.currentLine=39583748;
 //BA.debugLineNum = 39583748;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=39583749;
 //BA.debugLineNum = 39583749;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
RDebugUtils.currentLine=39583750;
 //BA.debugLineNum = 39583750;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=39583751;
 //BA.debugLineNum = 39583751;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(((int)0x80000000))});
RDebugUtils.currentLine=39583752;
 //BA.debugLineNum = 39583752;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(((int)0x04000000))});
RDebugUtils.currentLine=39583753;
 //BA.debugLineNum = 39583753;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
RDebugUtils.currentLine=39583754;
 //BA.debugLineNum = 39583754;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
_window.RunMethod("setNavigationBarColor",new Object[]{(Object)(_clr)});
RDebugUtils.currentLine=39583755;
 //BA.debugLineNum = 39583755;BA.debugLine="Dim view As JavaObject = window.RunMethodJO(\"get";
_view = new anywheresoftware.b4j.object.JavaObject();
_view = _window.RunMethodJO("getDecorView",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=39583756;
 //BA.debugLineNum = 39583756;BA.debugLine="If dark=True Then";
if (_dark==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=39583757;
 //BA.debugLineNum = 39583757;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(Bi";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.Bit.Or(((int)0x00002000),(int)(BA.ObjectToNumber(_view.RunMethod("getSystemUiVisibility",(Object[])(anywheresoftware.b4a.keywords.Common.Null))))))});
 }else {
RDebugUtils.currentLine=39583759;
 //BA.debugLineNum = 39583759;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(0)";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(0)});
 };
 };
RDebugUtils.currentLine=39583762;
 //BA.debugLineNum = 39583762;BA.debugLine="End Sub";
return "";
}
public static String  _setuserpin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
RDebugUtils.currentModule="config";
if (Debug.shouldDelegate(null, "setuserpin", false))
	 {return ((String) Debug.delegate(null, "setuserpin", new Object[] {_ba,_pin}));}
RDebugUtils.currentLine=39124992;
 //BA.debugLineNum = 39124992;BA.debugLine="Sub setUserPin(pin As String)";
RDebugUtils.currentLine=39124994;
 //BA.debugLineNum = 39124994;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
_sharedprefs.Initialize("StegoCamPrefs");
RDebugUtils.currentLine=39124996;
 //BA.debugLineNum = 39124996;BA.debugLine="SharedPrefs.SaveString(\"PIN\",pin)";
_sharedprefs.SaveString("PIN",_pin);
RDebugUtils.currentLine=39124997;
 //BA.debugLineNum = 39124997;BA.debugLine="End Sub";
return "";
}
}