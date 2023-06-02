package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class config_subs_0 {


public static RemoteObject  _ajustimageview(RemoteObject _ba,RemoteObject _imv,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("AjustImageView (config) ","config",3,_ba,config.mostCurrent,89);
if (RapidSub.canDelegate("ajustimageview")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","ajustimageview", _ba, _imv, _dir, _filename);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _delta = RemoteObject.createImmutable(0);
RemoteObject _height = RemoteObject.createImmutable(0);
RemoteObject _width = RemoteObject.createImmutable(0);
;
Debug.locals.put("Imv", _imv);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 89;BA.debugLine="Sub AjustImageView(Imv As ImageView, Dir As String";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="Private bmp As Bitmap = LoadBitmap(Dir, FileName)";
Debug.ShouldStop(33554432);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = config.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_filename));Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 91;BA.debugLine="Dim Delta, Height, Width As Int";
Debug.ShouldStop(67108864);
_delta = RemoteObject.createImmutable(0);Debug.locals.put("Delta", _delta);
_height = RemoteObject.createImmutable(0);Debug.locals.put("Height", _height);
_width = RemoteObject.createImmutable(0);Debug.locals.put("Width", _width);
 BA.debugLineNum = 92;BA.debugLine="If bmp.Width / bmp.Height > Imv.Width / Imv.Heigh";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",RemoteObject.solve(new RemoteObject[] {_bmp.runMethod(true,"getWidth"),_bmp.runMethod(true,"getHeight")}, "/",0, 0),RemoteObject.solve(new RemoteObject[] {_imv.runMethod(true,"getWidth"),_imv.runMethod(true,"getHeight")}, "/",0, 0))) { 
 BA.debugLineNum = 93;BA.debugLine="Height = bmp.Height / bmp.Width * Imv.Width";
Debug.ShouldStop(268435456);
_height = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_bmp.runMethod(true,"getHeight"),_bmp.runMethod(true,"getWidth"),_imv.runMethod(true,"getWidth")}, "/*",0, 0));Debug.locals.put("Height", _height);
 BA.debugLineNum = 94;BA.debugLine="Delta = (Imv.Height - Height) / 2";
Debug.ShouldStop(536870912);
_delta = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_imv.runMethod(true,"getHeight"),_height}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("Delta", _delta);
 BA.debugLineNum = 95;BA.debugLine="Imv.Height = Height";
Debug.ShouldStop(1073741824);
_imv.runMethod(true,"setHeight",_height);
 BA.debugLineNum = 96;BA.debugLine="Imv.Top = Imv.Top + Delta";
Debug.ShouldStop(-2147483648);
_imv.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_imv.runMethod(true,"getTop"),_delta}, "+",1, 1));
 }else {
 BA.debugLineNum = 98;BA.debugLine="Width = bmp.Width / bmp.Height * Imv.Height";
Debug.ShouldStop(2);
_width = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_bmp.runMethod(true,"getWidth"),_bmp.runMethod(true,"getHeight"),_imv.runMethod(true,"getHeight")}, "/*",0, 0));Debug.locals.put("Width", _width);
 BA.debugLineNum = 99;BA.debugLine="Delta = (Imv.Width - Width) / 2";
Debug.ShouldStop(4);
_delta = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_imv.runMethod(true,"getWidth"),_width}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("Delta", _delta);
 BA.debugLineNum = 100;BA.debugLine="Imv.Width = Width";
Debug.ShouldStop(8);
_imv.runMethod(true,"setWidth",_width);
 BA.debugLineNum = 101;BA.debugLine="Imv.Left = Imv.Left + Delta";
Debug.ShouldStop(16);
_imv.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_imv.runMethod(true,"getLeft"),_delta}, "+",1, 1));
 };
 BA.debugLineNum = 103;BA.debugLine="Imv.Gravity = Gravity.FILL";
Debug.ShouldStop(64);
_imv.runMethod(true,"setGravity",config.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 104;BA.debugLine="Imv.Bitmap = bmp";
Debug.ShouldStop(128);
_imv.runMethod(false,"setBitmap",(_bmp.getObject()));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bitmaptobitmapdrawable(RemoteObject _ba,RemoteObject _bitmap) throws Exception{
try {
		Debug.PushSubsStack("BitmapToBitmapDrawable (config) ","config",3,_ba,config.mostCurrent,128);
if (RapidSub.canDelegate("bitmaptobitmapdrawable")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","bitmaptobitmapdrawable", _ba, _bitmap);}
RemoteObject _bd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
;
Debug.locals.put("bitmap", _bitmap);
 BA.debugLineNum = 128;BA.debugLine="Sub BitmapToBitmapDrawable (bitmap As Bitmap) As B";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 129;BA.debugLine="Dim bd As BitmapDrawable";
Debug.ShouldStop(1);
_bd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("bd", _bd);
 BA.debugLineNum = 130;BA.debugLine="bd.Initialize(bitmap)";
Debug.ShouldStop(2);
_bd.runVoidMethod ("Initialize",(Object)((_bitmap.getObject())));
 BA.debugLineNum = 131;BA.debugLine="Return bd";
Debug.ShouldStop(4);
Debug.CheckDeviceExceptions();if (true) return _bd;
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getbiometric(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("getBiometric (config) ","config",3,_ba,config.mostCurrent,55);
if (RapidSub.canDelegate("getbiometric")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","getbiometric", _ba);}
;
 BA.debugLineNum = 55;BA.debugLine="Sub getBiometric() As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="isBioEnabled=True";
Debug.ShouldStop(8388608);
config._isbioenabled = config.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 58;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(33554432);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 61;BA.debugLine="isBioEnabled = SharedPrefs.GetBoolean(\"Biometric\"";
Debug.ShouldStop(268435456);
config._isbioenabled = config._sharedprefs.runMethod(true,"GetBoolean",(Object)(BA.ObjectToString("Biometric")),(Object)(config.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 63;BA.debugLine="Return isBioEnabled";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return config._isbioenabled;
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getfileinfobyindex(RemoteObject _ba,RemoteObject _column,RemoteObject _uri) throws Exception{
try {
		Debug.PushSubsStack("GetFileInfoByIndex (config) ","config",3,_ba,config.mostCurrent,145);
if (RapidSub.canDelegate("getfileinfobyindex")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","getfileinfobyindex", _ba, _column, _uri);}
RemoteObject _results = RemoteObject.createImmutable("");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _uri1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _cr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper");
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _id = RemoteObject.createImmutable("");
;
Debug.locals.put("column", _column);
Debug.locals.put("uri", _uri);
 BA.debugLineNum = 145;BA.debugLine="Sub GetFileInfoByIndex(column As String, uri As St";
Debug.ShouldStop(65536);
 BA.debugLineNum = 147;BA.debugLine="Dim results As String";
Debug.ShouldStop(262144);
_results = RemoteObject.createImmutable("");Debug.locals.put("results", _results);
 BA.debugLineNum = 148;BA.debugLine="Dim Cur As Cursor";
Debug.ShouldStop(524288);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cur", _cur);
 BA.debugLineNum = 149;BA.debugLine="Dim Uri1 As Uri";
Debug.ShouldStop(1048576);
_uri1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("Uri1", _uri1);
 BA.debugLineNum = 150;BA.debugLine="Dim cr As ContentResolver";
Debug.ShouldStop(2097152);
_cr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper");Debug.locals.put("cr", _cr);
 BA.debugLineNum = 151;BA.debugLine="cr.Initialize(\"\")";
Debug.ShouldStop(4194304);
_cr.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 154;BA.debugLine="If uri.StartsWith(\"content://media/\") Then";
Debug.ShouldStop(33554432);
if (_uri.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("content://media/"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 155;BA.debugLine="Dim i As Int = uri.LastIndexOf(\"/\")";
Debug.ShouldStop(67108864);
_i = _uri.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 156;BA.debugLine="Dim id As String = uri.SubString(i + 1)";
Debug.ShouldStop(134217728);
_id = _uri.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 157;BA.debugLine="Uri1.Parse(uri)";
Debug.ShouldStop(268435456);
_uri1.runVoidMethod ("Parse",(Object)(_uri));
 BA.debugLineNum = 158;BA.debugLine="Cur = cr.Query(Uri1, Null, \"_id = ?\", Array As S";
Debug.ShouldStop(536870912);
_cur = _cr.runMethod(false,"Query",(Object)(_uri1),(Object)((config.mostCurrent.__c.getField(false,"Null"))),(Object)(BA.ObjectToString("_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_id})),(Object)(BA.ObjectToString(config.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("Cur", _cur);
 BA.debugLineNum = 159;BA.debugLine="Cur.Position = 0";
Debug.ShouldStop(1073741824);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 160;BA.debugLine="If Cur.RowCount <> 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("!",_cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 161;BA.debugLine="For i = 0 To Cur.ColumnCount - 1";
Debug.ShouldStop(1);
{
final int step13 = 1;
final int limit13 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step13 > 0 && _i.<Integer>get().intValue() <= limit13) || (step13 < 0 && _i.<Integer>get().intValue() >= limit13) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step13))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 162;BA.debugLine="If Cur.GetColumnName(i) <> Null Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("N",_cur.runMethod(true,"GetColumnName",(Object)(_i)))) { 
 BA.debugLineNum = 163;BA.debugLine="If Cur.GetColumnName(i) = column Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_cur.runMethod(true,"GetColumnName",(Object)(_i)),_column)) { 
 BA.debugLineNum = 164;BA.debugLine="results = Cur.GetString2(i)";
Debug.ShouldStop(8);
_results = _cur.runMethod(true,"GetString2",(Object)(_i));Debug.locals.put("results", _results);
 BA.debugLineNum = 165;BA.debugLine="Exit";
Debug.ShouldStop(16);
if (true) break;
 };
 };
 }
}Debug.locals.put("i", _i);
;
 };
 }else {
 BA.debugLineNum = 171;BA.debugLine="Uri1.Parse(uri)";
Debug.ShouldStop(1024);
_uri1.runVoidMethod ("Parse",(Object)(_uri));
 BA.debugLineNum = 172;BA.debugLine="Cur = cr.Query(Uri1, Null, Null, Null, Null)";
Debug.ShouldStop(2048);
_cur = _cr.runMethod(false,"Query",(Object)(_uri1),(Object)((config.mostCurrent.__c.getField(false,"Null"))),(Object)(BA.ObjectToString(config.mostCurrent.__c.getField(false,"Null"))),(Object)((config.mostCurrent.__c.getField(false,"Null"))),(Object)(BA.ObjectToString(config.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("Cur", _cur);
 BA.debugLineNum = 173;BA.debugLine="Cur.Position = 0";
Debug.ShouldStop(4096);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 174;BA.debugLine="If Cur.RowCount <> 0 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("!",_cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 175;BA.debugLine="For i = 0 To Cur.ColumnCount - 1";
Debug.ShouldStop(16384);
{
final int step27 = 1;
final int limit27 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step27 > 0 && _i.<Integer>get().intValue() <= limit27) || (step27 < 0 && _i.<Integer>get().intValue() >= limit27) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step27))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 176;BA.debugLine="If Cur.GetColumnName(i) <> Null Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("N",_cur.runMethod(true,"GetColumnName",(Object)(_i)))) { 
 BA.debugLineNum = 177;BA.debugLine="If Cur.GetColumnName(i) = column Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_cur.runMethod(true,"GetColumnName",(Object)(_i)),_column)) { 
 BA.debugLineNum = 178;BA.debugLine="results = Cur.GetString2(i)";
Debug.ShouldStop(131072);
_results = _cur.runMethod(true,"GetString2",(Object)(_i));Debug.locals.put("results", _results);
 BA.debugLineNum = 179;BA.debugLine="Exit";
Debug.ShouldStop(262144);
if (true) break;
 };
 };
 }
}Debug.locals.put("i", _i);
;
 };
 };
 BA.debugLineNum = 186;BA.debugLine="Cur.Close";
Debug.ShouldStop(33554432);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 188;BA.debugLine="Return results";
Debug.ShouldStop(134217728);
Debug.CheckDeviceExceptions();if (true) return _results;
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsecurityanswer(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("getSecurityAnswer (config) ","config",3,_ba,config.mostCurrent,78);
if (RapidSub.canDelegate("getsecurityanswer")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","getsecurityanswer", _ba);}
;
 BA.debugLineNum = 78;BA.debugLine="Sub getSecurityAnswer() As String";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="answer=\"\"";
Debug.ShouldStop(16384);
config._answer = BA.ObjectToString("");
 BA.debugLineNum = 81;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(65536);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 84;BA.debugLine="answer = SharedPrefs.GetString(\"Answer\", \"\")";
Debug.ShouldStop(524288);
config._answer = config._sharedprefs.runMethod(true,"GetString",(Object)(BA.ObjectToString("Answer")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 86;BA.debugLine="Return answer";
Debug.ShouldStop(2097152);
Debug.CheckDeviceExceptions();if (true) return config._answer;
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsecurityquestion(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("getSecurityQuestion (config) ","config",3,_ba,config.mostCurrent,66);
if (RapidSub.canDelegate("getsecurityquestion")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","getsecurityquestion", _ba);}
;
 BA.debugLineNum = 66;BA.debugLine="Sub getSecurityQuestion() As String";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="question=\"\"";
Debug.ShouldStop(4);
config._question = BA.ObjectToString("");
 BA.debugLineNum = 69;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(16);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 72;BA.debugLine="question = SharedPrefs.GetString(\"Question\", \"\")";
Debug.ShouldStop(128);
config._question = config._sharedprefs.runMethod(true,"GetString",(Object)(BA.ObjectToString("Question")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 74;BA.debugLine="Return question";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return config._question;
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getuserpin(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("getUserPin (config) ","config",3,_ba,config.mostCurrent,17);
if (RapidSub.canDelegate("getuserpin")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","getuserpin", _ba);}
;
 BA.debugLineNum = 17;BA.debugLine="Sub getUserPin() As String";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="userPin=\"\"";
Debug.ShouldStop(131072);
config._userpin = BA.ObjectToString("");
 BA.debugLineNum = 20;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(524288);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 22;BA.debugLine="userPin = SharedPrefs.GetString(\"PIN\",\"\")";
Debug.ShouldStop(2097152);
config._userpin = config._sharedprefs.runMethod(true,"GetString",(Object)(BA.ObjectToString("PIN")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 23;BA.debugLine="Return userPin";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) return config._userpin;
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isfirstrun(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("isFirstRun (config) ","config",3,_ba,config.mostCurrent,43);
if (RapidSub.canDelegate("isfirstrun")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","isfirstrun", _ba);}
;
 BA.debugLineNum = 43;BA.debugLine="Sub isFirstRun() As Boolean";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="firstRun=True";
Debug.ShouldStop(2048);
config._firstrun = config.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 46;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(8192);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 49;BA.debugLine="firstRun = SharedPrefs.GetBoolean(\"FirstRun\", Tru";
Debug.ShouldStop(65536);
config._firstrun = config._sharedprefs.runMethod(true,"GetBoolean",(Object)(BA.ObjectToString("FirstRun")),(Object)(config.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 51;BA.debugLine="Return firstRun";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return config._firstrun;
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public show As Char = Chr(0xF06E)";
config._show = config.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf06e))));
 //BA.debugLineNum = 7;BA.debugLine="Public hide As Char = Chr(0xF070)";
config._hide = config.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf070))));
 //BA.debugLineNum = 8;BA.debugLine="Dim SharedPrefs As SharedPreferences";
config._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 9;BA.debugLine="Dim userPin As String =\"\"";
config._userpin = BA.ObjectToString("");
 //BA.debugLineNum = 10;BA.debugLine="Dim firstRun As Boolean=True";
config._firstrun = config.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 11;BA.debugLine="Dim isBioEnabled As Boolean=True";
config._isbioenabled = config.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 12;BA.debugLine="Dim question As String=\"\"";
config._question = BA.ObjectToString("");
 //BA.debugLineNum = 13;BA.debugLine="Dim answer As String=\"\"sss";
config._answer = BA.ObjectToString("");
 //BA.debugLineNum = 14;BA.debugLine="Public stegoImagePath As String = Starter.rp.GetS";
config._stegoimagepath = config.mostCurrent._starter._rp /*RemoteObject*/ .runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("stegoimages")));
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _resizelabelheight(RemoteObject _ba,RemoteObject _lbl) throws Exception{
try {
		Debug.PushSubsStack("ResizeLabelHeight (config) ","config",3,_ba,config.mostCurrent,134);
if (RapidSub.canDelegate("resizelabelheight")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","resizelabelheight", _ba, _lbl);}
RemoteObject _su = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
;
Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 134;BA.debugLine="Sub ResizeLabelHeight(lbl As Label)";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="Dim su As StringUtils";
Debug.ShouldStop(64);
_su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");Debug.locals.put("su", _su);
 BA.debugLineNum = 136;BA.debugLine="lbl.Height = su.MeasureMultilineTextHeight(lbl, l";
Debug.ShouldStop(128);
_lbl.runMethod(true,"setHeight",_su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_lbl.getObject())),(Object)(BA.ObjectToCharSequence(_lbl.runMethod(true,"getText")))));
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savesecurityqa(RemoteObject _ba,RemoteObject _quest,RemoteObject _ans) throws Exception{
try {
		Debug.PushSubsStack("saveSecurityQA (config) ","config",3,_ba,config.mostCurrent,34);
if (RapidSub.canDelegate("savesecurityqa")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","savesecurityqa", _ba, _quest, _ans);}
;
Debug.locals.put("quest", _quest);
Debug.locals.put("ans", _ans);
 BA.debugLineNum = 34;BA.debugLine="Sub saveSecurityQA(quest As String,ans As String)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(8);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 38;BA.debugLine="SharedPrefs.SaveString(\"Question\",quest)";
Debug.ShouldStop(32);
config._sharedprefs.runVoidMethod ("SaveString",(Object)(BA.ObjectToString("Question")),(Object)(_quest));
 BA.debugLineNum = 39;BA.debugLine="SharedPrefs.SaveString(\"Answer\",ans)";
Debug.ShouldStop(64);
config._sharedprefs.runVoidMethod ("SaveString",(Object)(BA.ObjectToString("Answer")),(Object)(_ans));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setstatusnavbarcolor(RemoteObject _ba,RemoteObject _clr,RemoteObject _dark) throws Exception{
try {
		Debug.PushSubsStack("SetStatusNavBarColor (config) ","config",3,_ba,config.mostCurrent,107);
if (RapidSub.canDelegate("setstatusnavbarcolor")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","setstatusnavbarcolor", _ba, _clr, _dark);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _view = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("clr", _clr);
Debug.locals.put("dark", _dark);
 BA.debugLineNum = 107;BA.debugLine="Sub SetStatusNavBarColor(clr As Int, dark As Boole";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(2048);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 109;BA.debugLine="If p.SdkVersion > 20 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 111;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(16384);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 112;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(32768);
_jo.runVoidMethod ("InitializeContext",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba));
 BA.debugLineNum = 113;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(65536);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((config.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 114;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(131072);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((((int)0x80000000)))})));
 BA.debugLineNum = 115;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(262144);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((((int)0x04000000)))})));
 BA.debugLineNum = 116;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(524288);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 BA.debugLineNum = 117;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
Debug.ShouldStop(1048576);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setNavigationBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 BA.debugLineNum = 118;BA.debugLine="Dim view As JavaObject = window.RunMethodJO(\"get";
Debug.ShouldStop(2097152);
_view = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_view = _window.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getDecorView")),(Object)((config.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("view", _view);Debug.locals.put("view", _view);
 BA.debugLineNum = 119;BA.debugLine="If dark=True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_dark,config.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 120;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(Bi";
Debug.ShouldStop(8388608);
_view.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(config.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(BA.numberCast(int.class, ((int)0x00002000))),(Object)(BA.numberCast(int.class, _view.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getSystemUiVisibility")),(Object)((config.mostCurrent.__c.getField(false,"Null"))))))))})));
 }else {
 BA.debugLineNum = 122;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(0)";
Debug.ShouldStop(33554432);
_view.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0))})));
 };
 };
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setuserpin(RemoteObject _ba,RemoteObject _pin) throws Exception{
try {
		Debug.PushSubsStack("setUserPin (config) ","config",3,_ba,config.mostCurrent,27);
if (RapidSub.canDelegate("setuserpin")) { return ng.dsoftlab.stegocam.config.remoteMe.runUserSub(false, "config","setuserpin", _ba, _pin);}
;
Debug.locals.put("pin", _pin);
 BA.debugLineNum = 27;BA.debugLine="Sub setUserPin(pin As String)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(268435456);
config._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 31;BA.debugLine="SharedPrefs.SaveString(\"PIN\",pin)";
Debug.ShouldStop(1073741824);
config._sharedprefs.runVoidMethod ("SaveString",(Object)(BA.ObjectToString("PIN")),(Object)(_pin));
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}