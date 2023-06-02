package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class filehandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ng.dsoftlab.stegocam.filehandler");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ng.dsoftlab.stegocam.filehandler.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _loadresult{
public boolean IsInitialized;
public boolean Success;
public String Dir;
public String FileName;
public String RealName;
public long Size;
public long Modified;
public String MimeType;
public void Initialize() {
IsInitialized = true;
Success = false;
Dir = "";
FileName = "";
RealName = "";
Size = 0L;
Modified = 0L;
MimeType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public Object _ion = null;
public anywheresoftware.b4a.objects.IntentWrapper _oldintent = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
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
public String  _initialize(ng.dsoftlab.stegocam.filehandler __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=42008576;
 //BA.debugLineNum = 42008576;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=42008578;
 //BA.debugLineNum = 42008578;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _loadcoverimage(ng.dsoftlab.stegocam.filehandler __ref) throws Exception{
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "loadcoverimage", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "loadcoverimage", null));}
ResumableSub_LoadCoverImage rsub = new ResumableSub_LoadCoverImage(this,__ref);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_LoadCoverImage extends BA.ResumableSub {
public ResumableSub_LoadCoverImage(ng.dsoftlab.stegocam.filehandler parent,ng.dsoftlab.stegocam.filehandler __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
ng.dsoftlab.stegocam.filehandler __ref;
ng.dsoftlab.stegocam.filehandler parent;
anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
boolean _success = false;
String _dir = "";
String _filename = "";
ng.dsoftlab.stegocam.filehandler._loadresult _res = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="filehandler";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=42139649;
 //BA.debugLineNum = 42139649;BA.debugLine="Dim cc As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
RDebugUtils.currentLine=42139650;
 //BA.debugLineNum = 42139650;BA.debugLine="cc.Initialize(\"cc\")";
_cc.Initialize("cc");
RDebugUtils.currentLine=42139651;
 //BA.debugLineNum = 42139651;BA.debugLine="cc.Show(\"image/*\", \"Choose Cover Image file\")";
_cc.Show(ba,"image/*","Choose Cover Image file");
RDebugUtils.currentLine=42139652;
 //BA.debugLineNum = 42139652;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
parent.__c.WaitFor("cc_result", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "filehandler", "loadcoverimage"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (Boolean) result[1];
_dir = (String) result[2];
_filename = (String) result[3];
;
RDebugUtils.currentLine=42139653;
 //BA.debugLineNum = 42139653;BA.debugLine="Dim res As LoadResult = CreateLoadResult(Success,";
_res = __ref._createloadresult /*ng.dsoftlab.stegocam.filehandler._loadresult*/ (null,_success,_dir,_filename);
RDebugUtils.currentLine=42139654;
 //BA.debugLineNum = 42139654;BA.debugLine="If res.Success Then ExtractInformationFromURI(res";
if (true) break;

case 1:
//if
this.state = 6;
if (_res.Success /*boolean*/ ) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
__ref._extractinformationfromuri /*String*/ (null,_res.FileName /*String*/ ,_res);
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=42139655;
 //BA.debugLineNum = 42139655;BA.debugLine="Return res";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_res));return;};
RDebugUtils.currentLine=42139656;
 //BA.debugLineNum = 42139656;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _load(ng.dsoftlab.stegocam.filehandler __ref) throws Exception{
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "load", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "load", null));}
ResumableSub_Load rsub = new ResumableSub_Load(this,__ref);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Load extends BA.ResumableSub {
public ResumableSub_Load(ng.dsoftlab.stegocam.filehandler parent,ng.dsoftlab.stegocam.filehandler __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
ng.dsoftlab.stegocam.filehandler __ref;
ng.dsoftlab.stegocam.filehandler parent;
anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
boolean _success = false;
String _dir = "";
String _filename = "";
ng.dsoftlab.stegocam.filehandler._loadresult _res = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="filehandler";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=42074113;
 //BA.debugLineNum = 42074113;BA.debugLine="Dim cc As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
RDebugUtils.currentLine=42074114;
 //BA.debugLineNum = 42074114;BA.debugLine="cc.Initialize(\"cc\")";
_cc.Initialize("cc");
RDebugUtils.currentLine=42074115;
 //BA.debugLineNum = 42074115;BA.debugLine="cc.Show(\"*/*\", \"Choose file to hide\")";
_cc.Show(ba,"*/*","Choose file to hide");
RDebugUtils.currentLine=42074116;
 //BA.debugLineNum = 42074116;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
parent.__c.WaitFor("cc_result", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "filehandler", "load"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (Boolean) result[1];
_dir = (String) result[2];
_filename = (String) result[3];
;
RDebugUtils.currentLine=42074117;
 //BA.debugLineNum = 42074117;BA.debugLine="Dim res As LoadResult = CreateLoadResult(Success,";
_res = __ref._createloadresult /*ng.dsoftlab.stegocam.filehandler._loadresult*/ (null,_success,_dir,_filename);
RDebugUtils.currentLine=42074118;
 //BA.debugLineNum = 42074118;BA.debugLine="If res.Success Then ExtractInformationFromURI(res";
if (true) break;

case 1:
//if
this.state = 6;
if (_res.Success /*boolean*/ ) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
__ref._extractinformationfromuri /*String*/ (null,_res.FileName /*String*/ ,_res);
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=42074119;
 //BA.debugLineNum = 42074119;BA.debugLine="Return res";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_res));return;};
RDebugUtils.currentLine=42074120;
 //BA.debugLineNum = 42074120;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals(ng.dsoftlab.stegocam.filehandler __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="filehandler";
RDebugUtils.currentLine=41943040;
 //BA.debugLineNum = 41943040;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=41943041;
 //BA.debugLineNum = 41943041;BA.debugLine="Private ion As Object";
_ion = new Object();
RDebugUtils.currentLine=41943042;
 //BA.debugLineNum = 41943042;BA.debugLine="Private OldIntent As Intent";
_oldintent = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=41943043;
 //BA.debugLineNum = 41943043;BA.debugLine="Type LoadResult (Success As Boolean, Dir As Strin";
;
RDebugUtils.currentLine=41943045;
 //BA.debugLineNum = 41943045;BA.debugLine="End Sub";
return "";
}
public ng.dsoftlab.stegocam.filehandler._loadresult  _createloadresult(ng.dsoftlab.stegocam.filehandler __ref,boolean _success,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "createloadresult", false))
	 {return ((ng.dsoftlab.stegocam.filehandler._loadresult) Debug.delegate(ba, "createloadresult", new Object[] {_success,_dir,_filename}));}
ng.dsoftlab.stegocam.filehandler._loadresult _t1 = null;
RDebugUtils.currentLine=42467328;
 //BA.debugLineNum = 42467328;BA.debugLine="Private Sub CreateLoadResult (Success As Boolean,";
RDebugUtils.currentLine=42467329;
 //BA.debugLineNum = 42467329;BA.debugLine="Dim t1 As LoadResult";
_t1 = new ng.dsoftlab.stegocam.filehandler._loadresult();
RDebugUtils.currentLine=42467330;
 //BA.debugLineNum = 42467330;BA.debugLine="t1.Initialize";
_t1.Initialize();
RDebugUtils.currentLine=42467331;
 //BA.debugLineNum = 42467331;BA.debugLine="t1.Success = Success";
_t1.Success /*boolean*/  = _success;
RDebugUtils.currentLine=42467332;
 //BA.debugLineNum = 42467332;BA.debugLine="t1.Dir = Dir";
_t1.Dir /*String*/  = _dir;
RDebugUtils.currentLine=42467333;
 //BA.debugLineNum = 42467333;BA.debugLine="t1.FileName = FileName";
_t1.FileName /*String*/  = _filename;
RDebugUtils.currentLine=42467334;
 //BA.debugLineNum = 42467334;BA.debugLine="Return t1";
if (true) return _t1;
RDebugUtils.currentLine=42467335;
 //BA.debugLineNum = 42467335;BA.debugLine="End Sub";
return null;
}
public String  _extractinformationfromuri(ng.dsoftlab.stegocam.filehandler __ref,String _uri,ng.dsoftlab.stegocam.filehandler._loadresult _res) throws Exception{
__ref = this;
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "extractinformationfromuri", false))
	 {return ((String) Debug.delegate(ba, "extractinformationfromuri", new Object[] {_uri,_res}));}
anywheresoftware.b4a.objects.ContentResolverWrapper _resolver = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
ng.dsoftlab.stegocam.b4xset _columns = null;
int _i = 0;
RDebugUtils.currentLine=42336256;
 //BA.debugLineNum = 42336256;BA.debugLine="Private Sub ExtractInformationFromURI (Uri As Stri";
RDebugUtils.currentLine=42336257;
 //BA.debugLineNum = 42336257;BA.debugLine="Try";
try {RDebugUtils.currentLine=42336259;
 //BA.debugLineNum = 42336259;BA.debugLine="Dim resolver As ContentResolver";
_resolver = new anywheresoftware.b4a.objects.ContentResolverWrapper();
RDebugUtils.currentLine=42336260;
 //BA.debugLineNum = 42336260;BA.debugLine="resolver.Initialize(\"\")";
_resolver.Initialize("");
RDebugUtils.currentLine=42336261;
 //BA.debugLineNum = 42336261;BA.debugLine="Dim u As Uri";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=42336262;
 //BA.debugLineNum = 42336262;BA.debugLine="u.Parse(Uri)";
_u.Parse(_uri);
RDebugUtils.currentLine=42336263;
 //BA.debugLineNum = 42336263;BA.debugLine="Dim rs As ResultSet = resolver.Query(u, Null, \"\",";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_resolver.Query(_u,(String[])(__c.Null),"",(String[])(__c.Null),"").getObject()));
RDebugUtils.currentLine=42336264;
 //BA.debugLineNum = 42336264;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
RDebugUtils.currentLine=42336265;
 //BA.debugLineNum = 42336265;BA.debugLine="Dim columns As B4XSet = B4XCollections.CreateSet";
_columns = _b4xcollections._createset /*ng.dsoftlab.stegocam.b4xset*/ (getActivityBA());
RDebugUtils.currentLine=42336266;
 //BA.debugLineNum = 42336266;BA.debugLine="For i = 0 To rs.ColumnCount - 1";
{
final int step9 = 1;
final int limit9 = (int) (_rs.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=42336267;
 //BA.debugLineNum = 42336267;BA.debugLine="columns.Add(rs.GetColumnName(i))";
_columns._add /*String*/ (null,(Object)(_rs.GetColumnName(_i)));
 }
};
RDebugUtils.currentLine=42336269;
 //BA.debugLineNum = 42336269;BA.debugLine="If columns.Contains(\"_display_name\") Then res.Re";
if (_columns._contains /*boolean*/ (null,(Object)("_display_name"))) { 
_res.RealName /*String*/  = _rs.GetString("_display_name");};
RDebugUtils.currentLine=42336270;
 //BA.debugLineNum = 42336270;BA.debugLine="If columns.Contains(\"_size\") Then res.Size = rs.";
if (_columns._contains /*boolean*/ (null,(Object)("_size"))) { 
_res.Size /*long*/  = _rs.GetLong("_size");};
RDebugUtils.currentLine=42336271;
 //BA.debugLineNum = 42336271;BA.debugLine="If columns.Contains(\"last_modified\") Then res.Mo";
if (_columns._contains /*boolean*/ (null,(Object)("last_modified"))) { 
_res.Modified /*long*/  = _rs.GetLong("last_modified");};
RDebugUtils.currentLine=42336272;
 //BA.debugLineNum = 42336272;BA.debugLine="If columns.Contains(\"mime_type\") Then res.MimeTy";
if (_columns._contains /*boolean*/ (null,(Object)("mime_type"))) { 
_res.MimeType /*String*/  = _rs.GetString("mime_type");};
 };
RDebugUtils.currentLine=42336274;
 //BA.debugLineNum = 42336274;BA.debugLine="rs.Close";
_rs.Close();
 } 
       catch (Exception e19) {
			ba.setLastException(e19);RDebugUtils.currentLine=42336277;
 //BA.debugLineNum = 42336277;BA.debugLine="Log(\"error extracting information from file prov";
__c.LogImpl("742336277","error extracting information from file provider",0);
RDebugUtils.currentLine=42336278;
 //BA.debugLineNum = 42336278;BA.debugLine="Log(LastException)";
__c.LogImpl("742336278",BA.ObjectToString(__c.LastException(getActivityBA())),0);
 };
RDebugUtils.currentLine=42336280;
 //BA.debugLineNum = 42336280;BA.debugLine="End Sub";
return "";
}
public Object  _getba(ng.dsoftlab.stegocam.filehandler __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "getba", false))
	 {return ((Object) Debug.delegate(ba, "getba", null));}
RDebugUtils.currentLine=42270720;
 //BA.debugLineNum = 42270720;BA.debugLine="Private Sub GetBA As Object";
RDebugUtils.currentLine=42270721;
 //BA.debugLineNum = 42270721;BA.debugLine="Return Me.As(JavaObject).RunMethod(\"getBA\", Null)";
if (true) return ((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this))).RunMethod("getBA",(Object[])(__c.Null));
RDebugUtils.currentLine=42270722;
 //BA.debugLineNum = 42270722;BA.debugLine="End Sub";
return null;
}
public boolean  _isrelevantintent(ng.dsoftlab.stegocam.filehandler __ref,anywheresoftware.b4a.objects.IntentWrapper _in) throws Exception{
__ref = this;
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "isrelevantintent", false))
	 {return ((Boolean) Debug.delegate(ba, "isrelevantintent", new Object[] {_in}));}
RDebugUtils.currentLine=42401792;
 //BA.debugLineNum = 42401792;BA.debugLine="Private Sub IsRelevantIntent(in As Intent) As Bool";
RDebugUtils.currentLine=42401793;
 //BA.debugLineNum = 42401793;BA.debugLine="If in.IsInitialized And in <> OldIntent And in.Ac";
if (_in.IsInitialized() && (_in).equals(__ref._oldintent /*anywheresoftware.b4a.objects.IntentWrapper*/ ) == false && (_in.getAction()).equals(_in.ACTION_VIEW)) { 
RDebugUtils.currentLine=42401794;
 //BA.debugLineNum = 42401794;BA.debugLine="OldIntent = in";
__ref._oldintent /*anywheresoftware.b4a.objects.IntentWrapper*/  = _in;
RDebugUtils.currentLine=42401795;
 //BA.debugLineNum = 42401795;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=42401797;
 //BA.debugLineNum = 42401797;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=42401798;
 //BA.debugLineNum = 42401798;BA.debugLine="End Sub";
return false;
}
public String  _startactivityforresult(ng.dsoftlab.stegocam.filehandler __ref,anywheresoftware.b4a.objects.IntentWrapper _i) throws Exception{
__ref = this;
RDebugUtils.currentModule="filehandler";
if (Debug.shouldDelegate(ba, "startactivityforresult", false))
	 {return ((String) Debug.delegate(ba, "startactivityforresult", new Object[] {_i}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=42205184;
 //BA.debugLineNum = 42205184;BA.debugLine="Private Sub StartActivityForResult(i As Intent)";
RDebugUtils.currentLine=42205185;
 //BA.debugLineNum = 42205185;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(__ref._getba /*Object*/ (null)));
RDebugUtils.currentLine=42205186;
 //BA.debugLineNum = 42205186;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
__ref._ion /*Object*/  = _jo.CreateEvent(ba,"anywheresoftware.b4a.IOnActivityResult","ion",__c.Null);
RDebugUtils.currentLine=42205187;
 //BA.debugLineNum = 42205187;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array(ion,";
_jo.RunMethod("startActivityForResult",new Object[]{__ref._ion /*Object*/ ,(Object)(_i.getObject())});
RDebugUtils.currentLine=42205188;
 //BA.debugLineNum = 42205188;BA.debugLine="End Sub";
return "";
}
}