package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class filehandler_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private ion As Object";
filehandler._ion = RemoteObject.createNew ("Object");__ref.setField("_ion",filehandler._ion);
 //BA.debugLineNum = 3;BA.debugLine="Private OldIntent As Intent";
filehandler._oldintent = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");__ref.setField("_oldintent",filehandler._oldintent);
 //BA.debugLineNum = 4;BA.debugLine="Type LoadResult (Success As Boolean, Dir As Strin";
;
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _createloadresult(RemoteObject __ref,RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("CreateLoadResult (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,77);
if (RapidSub.canDelegate("createloadresult")) { return __ref.runUserSub(false, "filehandler","createloadresult", __ref, _success, _dir, _filename);}
RemoteObject _t1 = RemoteObject.declareNull("ng.dsoftlab.stegocam.filehandler._loadresult");
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 77;BA.debugLine="Private Sub CreateLoadResult (Success As Boolean,";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim t1 As LoadResult";
Debug.ShouldStop(8192);
_t1 = RemoteObject.createNew ("ng.dsoftlab.stegocam.filehandler._loadresult");Debug.locals.put("t1", _t1);
 BA.debugLineNum = 79;BA.debugLine="t1.Initialize";
Debug.ShouldStop(16384);
_t1.runVoidMethod ("Initialize");
 BA.debugLineNum = 80;BA.debugLine="t1.Success = Success";
Debug.ShouldStop(32768);
_t1.setField ("Success" /*RemoteObject*/ ,_success);
 BA.debugLineNum = 81;BA.debugLine="t1.Dir = Dir";
Debug.ShouldStop(65536);
_t1.setField ("Dir" /*RemoteObject*/ ,_dir);
 BA.debugLineNum = 82;BA.debugLine="t1.FileName = FileName";
Debug.ShouldStop(131072);
_t1.setField ("FileName" /*RemoteObject*/ ,_filename);
 BA.debugLineNum = 83;BA.debugLine="Return t1";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return _t1;
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _extractinformationfromuri(RemoteObject __ref,RemoteObject _uri,RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("ExtractInformationFromURI (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,43);
if (RapidSub.canDelegate("extractinformationfromuri")) { return __ref.runUserSub(false, "filehandler","extractinformationfromuri", __ref, _uri, _res);}
RemoteObject _resolver = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _columns = RemoteObject.declareNull("ng.dsoftlab.stegocam.b4xset");
int _i = 0;
Debug.locals.put("Uri", _uri);
Debug.locals.put("res", _res);
 BA.debugLineNum = 43;BA.debugLine="Private Sub ExtractInformationFromURI (Uri As Stri";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 46;BA.debugLine="Dim resolver As ContentResolver";
Debug.ShouldStop(8192);
_resolver = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper");Debug.locals.put("resolver", _resolver);
 BA.debugLineNum = 47;BA.debugLine="resolver.Initialize(\"\")";
Debug.ShouldStop(16384);
_resolver.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 48;BA.debugLine="Dim u As Uri";
Debug.ShouldStop(32768);
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("u", _u);
 BA.debugLineNum = 49;BA.debugLine="u.Parse(Uri)";
Debug.ShouldStop(65536);
_u.runVoidMethod ("Parse",(Object)(_uri));
 BA.debugLineNum = 50;BA.debugLine="Dim rs As ResultSet = resolver.Query(u, Null, \"\",";
Debug.ShouldStop(131072);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _resolver.runMethod(false,"Query",(Object)(_u),(Object)((filehandler.__c.getField(false,"Null"))),(Object)(BA.ObjectToString("")),(Object)((filehandler.__c.getField(false,"Null"))),(Object)(RemoteObject.createImmutable(""))).getObject());Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 51;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(262144);
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 52;BA.debugLine="Dim columns As B4XSet = B4XCollections.CreateSet";
Debug.ShouldStop(524288);
_columns = filehandler._b4xcollections.runMethod(false,"_createset" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"));Debug.locals.put("columns", _columns);Debug.locals.put("columns", _columns);
 BA.debugLineNum = 53;BA.debugLine="For i = 0 To rs.ColumnCount - 1";
Debug.ShouldStop(1048576);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_rs.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 54;BA.debugLine="columns.Add(rs.GetColumnName(i))";
Debug.ShouldStop(2097152);
_columns.runClassMethod (ng.dsoftlab.stegocam.b4xset.class, "_add" /*RemoteObject*/ ,(Object)((_rs.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 56;BA.debugLine="If columns.Contains(\"_display_name\") Then res.Re";
Debug.ShouldStop(8388608);
if (_columns.runClassMethod (ng.dsoftlab.stegocam.b4xset.class, "_contains" /*RemoteObject*/ ,(Object)((RemoteObject.createImmutable("_display_name")))).<Boolean>get().booleanValue()) { 
_res.setField ("RealName" /*RemoteObject*/ ,_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("_display_name"))));};
 BA.debugLineNum = 57;BA.debugLine="If columns.Contains(\"_size\") Then res.Size = rs.";
Debug.ShouldStop(16777216);
if (_columns.runClassMethod (ng.dsoftlab.stegocam.b4xset.class, "_contains" /*RemoteObject*/ ,(Object)((RemoteObject.createImmutable("_size")))).<Boolean>get().booleanValue()) { 
_res.setField ("Size" /*RemoteObject*/ ,_rs.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("_size"))));};
 BA.debugLineNum = 58;BA.debugLine="If columns.Contains(\"last_modified\") Then res.Mo";
Debug.ShouldStop(33554432);
if (_columns.runClassMethod (ng.dsoftlab.stegocam.b4xset.class, "_contains" /*RemoteObject*/ ,(Object)((RemoteObject.createImmutable("last_modified")))).<Boolean>get().booleanValue()) { 
_res.setField ("Modified" /*RemoteObject*/ ,_rs.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("last_modified"))));};
 BA.debugLineNum = 59;BA.debugLine="If columns.Contains(\"mime_type\") Then res.MimeTy";
Debug.ShouldStop(67108864);
if (_columns.runClassMethod (ng.dsoftlab.stegocam.b4xset.class, "_contains" /*RemoteObject*/ ,(Object)((RemoteObject.createImmutable("mime_type")))).<Boolean>get().booleanValue()) { 
_res.setField ("MimeType" /*RemoteObject*/ ,_rs.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mime_type"))));};
 };
 BA.debugLineNum = 61;BA.debugLine="rs.Close";
Debug.ShouldStop(268435456);
_rs.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e19) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e19.toString()); BA.debugLineNum = 64;BA.debugLine="Log(\"error extracting information from file prov";
Debug.ShouldStop(-2147483648);
filehandler.__c.runVoidMethod ("LogImpl","742336277",RemoteObject.createImmutable("error extracting information from file provider"),0);
 BA.debugLineNum = 65;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1);
filehandler.__c.runVoidMethod ("LogImpl","742336278",BA.ObjectToString(filehandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA"))),0);
 };
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getba(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetBA (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,39);
if (RapidSub.canDelegate("getba")) { return __ref.runUserSub(false, "filehandler","getba", __ref);}
 BA.debugLineNum = 39;BA.debugLine="Private Sub GetBA As Object";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Return Me.As(JavaObject).RunMethod(\"getBA\", Null)";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), __ref)).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getBA")),(Object)((filehandler.__c.getField(false,"Null"))));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "filehandler","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(128);
 BA.debugLineNum = 10;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isrelevantintent(RemoteObject __ref,RemoteObject _in) throws Exception{
try {
		Debug.PushSubsStack("IsRelevantIntent (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,69);
if (RapidSub.canDelegate("isrelevantintent")) { return __ref.runUserSub(false, "filehandler","isrelevantintent", __ref, _in);}
Debug.locals.put("in", _in);
 BA.debugLineNum = 69;BA.debugLine="Private Sub IsRelevantIntent(in As Intent) As Bool";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="If in.IsInitialized And in <> OldIntent And in.Ac";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(".",_in.runMethod(true,"IsInitialized")) && RemoteObject.solveBoolean("!",_in,__ref.getField(false,"_oldintent" /*RemoteObject*/ )) && RemoteObject.solveBoolean("=",_in.runMethod(true,"getAction"),_in.getField(true,"ACTION_VIEW"))) { 
 BA.debugLineNum = 71;BA.debugLine="OldIntent = in";
Debug.ShouldStop(64);
__ref.setField ("_oldintent" /*RemoteObject*/ ,_in);
 BA.debugLineNum = 72;BA.debugLine="Return True";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return filehandler.__c.getField(true,"True");
 };
 BA.debugLineNum = 74;BA.debugLine="Return False";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return filehandler.__c.getField(true,"False");
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _load(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Load (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("load")) { return __ref.runUserSub(false, "filehandler","load", __ref);}
ResumableSub_Load rsub = new ResumableSub_Load(null,__ref);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Load extends BA.ResumableSub {
public ResumableSub_Load(ng.dsoftlab.stegocam.filehandler parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
ng.dsoftlab.stegocam.filehandler parent;
RemoteObject _cc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _res = RemoteObject.declareNull("ng.dsoftlab.stegocam.filehandler._loadresult");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Load (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,13);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 14;BA.debugLine="Dim cc As ContentChooser";
Debug.ShouldStop(8192);
_cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");Debug.locals.put("cc", _cc);
 BA.debugLineNum = 15;BA.debugLine="cc.Initialize(\"cc\")";
Debug.ShouldStop(16384);
_cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("cc")));
 BA.debugLineNum = 16;BA.debugLine="cc.Show(\"*/*\", \"Choose file to hide\")";
Debug.ShouldStop(32768);
_cc.runVoidMethod ("Show",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("*/*")),(Object)(RemoteObject.createImmutable("Choose file to hide")));
 BA.debugLineNum = 17;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
Debug.ShouldStop(65536);
parent.__c.runVoidMethod ("WaitFor","cc_result", __ref.getField(false, "ba"), anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "filehandler", "load"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Success", _success);
_dir = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(2));Debug.locals.put("Dir", _dir);
_filename = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(3));Debug.locals.put("FileName", _filename);
;
 BA.debugLineNum = 18;BA.debugLine="Dim res As LoadResult = CreateLoadResult(Success,";
Debug.ShouldStop(131072);
_res = __ref.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_createloadresult" /*RemoteObject*/ ,(Object)(_success),(Object)(_dir),(Object)(_filename));Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 19;BA.debugLine="If res.Success Then ExtractInformationFromURI(res";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//if
this.state = 6;
if (_res.getField(true,"Success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
__ref.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_extractinformationfromuri" /*RemoteObject*/ ,(Object)(_res.getField(true,"FileName" /*RemoteObject*/ )),(Object)(_res));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 20;BA.debugLine="Return res";
Debug.ShouldStop(524288);
Debug.CheckDeviceExceptions();if (true) {
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_res));return;};
 BA.debugLineNum = 21;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _cc_result(RemoteObject __ref,RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
}
public static RemoteObject  _loadcoverimage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("LoadCoverImage (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,23);
if (RapidSub.canDelegate("loadcoverimage")) { return __ref.runUserSub(false, "filehandler","loadcoverimage", __ref);}
ResumableSub_LoadCoverImage rsub = new ResumableSub_LoadCoverImage(null,__ref);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_LoadCoverImage extends BA.ResumableSub {
public ResumableSub_LoadCoverImage(ng.dsoftlab.stegocam.filehandler parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
ng.dsoftlab.stegocam.filehandler parent;
RemoteObject _cc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _res = RemoteObject.declareNull("ng.dsoftlab.stegocam.filehandler._loadresult");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("LoadCoverImage (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,23);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 24;BA.debugLine="Dim cc As ContentChooser";
Debug.ShouldStop(8388608);
_cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");Debug.locals.put("cc", _cc);
 BA.debugLineNum = 25;BA.debugLine="cc.Initialize(\"cc\")";
Debug.ShouldStop(16777216);
_cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("cc")));
 BA.debugLineNum = 26;BA.debugLine="cc.Show(\"image/*\", \"Choose Cover Image file\")";
Debug.ShouldStop(33554432);
_cc.runVoidMethod ("Show",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose Cover Image file")));
 BA.debugLineNum = 27;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
Debug.ShouldStop(67108864);
parent.__c.runVoidMethod ("WaitFor","cc_result", __ref.getField(false, "ba"), anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "filehandler", "loadcoverimage"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Success", _success);
_dir = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(2));Debug.locals.put("Dir", _dir);
_filename = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(3));Debug.locals.put("FileName", _filename);
;
 BA.debugLineNum = 28;BA.debugLine="Dim res As LoadResult = CreateLoadResult(Success,";
Debug.ShouldStop(134217728);
_res = __ref.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_createloadresult" /*RemoteObject*/ ,(Object)(_success),(Object)(_dir),(Object)(_filename));Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 29;BA.debugLine="If res.Success Then ExtractInformationFromURI(res";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//if
this.state = 6;
if (_res.getField(true,"Success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
__ref.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_extractinformationfromuri" /*RemoteObject*/ ,(Object)(_res.getField(true,"FileName" /*RemoteObject*/ )),(Object)(_res));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 30;BA.debugLine="Return res";
Debug.ShouldStop(536870912);
Debug.CheckDeviceExceptions();if (true) {
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_res));return;};
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _startactivityforresult(RemoteObject __ref,RemoteObject _i) throws Exception{
try {
		Debug.PushSubsStack("StartActivityForResult (filehandler) ","filehandler",6,__ref.getField(false, "ba"),__ref,33);
if (RapidSub.canDelegate("startactivityforresult")) { return __ref.runUserSub(false, "filehandler","startactivityforresult", __ref, _i);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("i", _i);
 BA.debugLineNum = 33;BA.debugLine="Private Sub StartActivityForResult(i As Intent)";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Dim jo As JavaObject = GetBA";
Debug.ShouldStop(2);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), __ref.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_getba" /*RemoteObject*/ ));Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 35;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
Debug.ShouldStop(4);
__ref.setField ("_ion" /*RemoteObject*/ ,_jo.runMethod(false,"CreateEvent",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("anywheresoftware.b4a.IOnActivityResult")),(Object)(BA.ObjectToString("ion")),(Object)(filehandler.__c.getField(false,"Null"))));
 BA.debugLineNum = 36;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array(ion,";
Debug.ShouldStop(8);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("startActivityForResult")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {__ref.getField(false,"_ion" /*RemoteObject*/ ),(_i.getObject())})));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}