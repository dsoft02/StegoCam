package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class filehandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "ng.dsoftlab.stegocam.filehandler");
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
public ng.dsoftlab.stegocam.decode _decode = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
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
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private ion As Object";
_ion = new Object();
 //BA.debugLineNum = 3;BA.debugLine="Private OldIntent As Intent";
_oldintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Type LoadResult (Success As Boolean, Dir As Strin";
;
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public ng.dsoftlab.stegocam.filehandler._loadresult  _createloadresult(boolean _success,String _dir,String _filename) throws Exception{
ng.dsoftlab.stegocam.filehandler._loadresult _t1 = null;
 //BA.debugLineNum = 77;BA.debugLine="Private Sub CreateLoadResult (Success As Boolean,";
 //BA.debugLineNum = 78;BA.debugLine="Dim t1 As LoadResult";
_t1 = new ng.dsoftlab.stegocam.filehandler._loadresult();
 //BA.debugLineNum = 79;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 80;BA.debugLine="t1.Success = Success";
_t1.Success /*boolean*/  = _success;
 //BA.debugLineNum = 81;BA.debugLine="t1.Dir = Dir";
_t1.Dir /*String*/  = _dir;
 //BA.debugLineNum = 82;BA.debugLine="t1.FileName = FileName";
_t1.FileName /*String*/  = _filename;
 //BA.debugLineNum = 83;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return null;
}
public String  _extractinformationfromuri(String _uri,ng.dsoftlab.stegocam.filehandler._loadresult _res) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper _resolver = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
ng.dsoftlab.stegocam.b4xset _columns = null;
int _i = 0;
 //BA.debugLineNum = 43;BA.debugLine="Private Sub ExtractInformationFromURI (Uri As Stri";
 //BA.debugLineNum = 44;BA.debugLine="Try";
try { //BA.debugLineNum = 46;BA.debugLine="Dim resolver As ContentResolver";
_resolver = new anywheresoftware.b4a.objects.ContentResolverWrapper();
 //BA.debugLineNum = 47;BA.debugLine="resolver.Initialize(\"\")";
_resolver.Initialize("");
 //BA.debugLineNum = 48;BA.debugLine="Dim u As Uri";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 49;BA.debugLine="u.Parse(Uri)";
_u.Parse(_uri);
 //BA.debugLineNum = 50;BA.debugLine="Dim rs As ResultSet = resolver.Query(u, Null, \"\",";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_resolver.Query(_u,(String[])(__c.Null),"",(String[])(__c.Null),"").getObject()));
 //BA.debugLineNum = 51;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
 //BA.debugLineNum = 52;BA.debugLine="Dim columns As B4XSet = B4XCollections.CreateSet";
_columns = _b4xcollections._createset /*ng.dsoftlab.stegocam.b4xset*/ (getActivityBA());
 //BA.debugLineNum = 53;BA.debugLine="For i = 0 To rs.ColumnCount - 1";
{
final int step9 = 1;
final int limit9 = (int) (_rs.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 54;BA.debugLine="columns.Add(rs.GetColumnName(i))";
_columns._add /*String*/ ((Object)(_rs.GetColumnName(_i)));
 }
};
 //BA.debugLineNum = 56;BA.debugLine="If columns.Contains(\"_display_name\") Then res.Re";
if (_columns._contains /*boolean*/ ((Object)("_display_name"))) { 
_res.RealName /*String*/  = _rs.GetString("_display_name");};
 //BA.debugLineNum = 57;BA.debugLine="If columns.Contains(\"_size\") Then res.Size = rs.";
if (_columns._contains /*boolean*/ ((Object)("_size"))) { 
_res.Size /*long*/  = _rs.GetLong("_size");};
 //BA.debugLineNum = 58;BA.debugLine="If columns.Contains(\"last_modified\") Then res.Mo";
if (_columns._contains /*boolean*/ ((Object)("last_modified"))) { 
_res.Modified /*long*/  = _rs.GetLong("last_modified");};
 //BA.debugLineNum = 59;BA.debugLine="If columns.Contains(\"mime_type\") Then res.MimeTy";
if (_columns._contains /*boolean*/ ((Object)("mime_type"))) { 
_res.MimeType /*String*/  = _rs.GetString("mime_type");};
 };
 //BA.debugLineNum = 61;BA.debugLine="rs.Close";
_rs.Close();
 } 
       catch (Exception e19) {
			ba.setLastException(e19); //BA.debugLineNum = 64;BA.debugLine="Log(\"error extracting information from file prov";
__c.LogImpl("442336277","error extracting information from file provider",0);
 //BA.debugLineNum = 65;BA.debugLine="Log(LastException)";
__c.LogImpl("442336278",BA.ObjectToString(__c.LastException(getActivityBA())),0);
 };
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public Object  _getba() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Private Sub GetBA As Object";
 //BA.debugLineNum = 40;BA.debugLine="Return Me.As(JavaObject).RunMethod(\"getBA\", Null)";
if (true) return ((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this))).RunMethod("getBA",(Object[])(__c.Null));
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public boolean  _isrelevantintent(anywheresoftware.b4a.objects.IntentWrapper _in) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub IsRelevantIntent(in As Intent) As Bool";
 //BA.debugLineNum = 70;BA.debugLine="If in.IsInitialized And in <> OldIntent And in.Ac";
if (_in.IsInitialized() && (_in).equals(_oldintent) == false && (_in.getAction()).equals(_in.ACTION_VIEW)) { 
 //BA.debugLineNum = 71;BA.debugLine="OldIntent = in";
_oldintent = _in;
 //BA.debugLineNum = 72;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 74;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _load() throws Exception{
ResumableSub_Load rsub = new ResumableSub_Load(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Load extends BA.ResumableSub {
public ResumableSub_Load(ng.dsoftlab.stegocam.filehandler parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.filehandler parent;
anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
boolean _success = false;
String _dir = "";
String _filename = "";
ng.dsoftlab.stegocam.filehandler._loadresult _res = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 14;BA.debugLine="Dim cc As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 15;BA.debugLine="cc.Initialize(\"cc\")";
_cc.Initialize("cc");
 //BA.debugLineNum = 16;BA.debugLine="cc.Show(\"*/*\", \"Choose file to hide\")";
_cc.Show(ba,"*/*","Choose file to hide");
 //BA.debugLineNum = 17;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
parent.__c.WaitFor("cc_result", ba, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
 //BA.debugLineNum = 18;BA.debugLine="Dim res As LoadResult = CreateLoadResult(Success,";
_res = parent._createloadresult(_success,_dir,_filename);
 //BA.debugLineNum = 19;BA.debugLine="If res.Success Then ExtractInformationFromURI(res";
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
parent._extractinformationfromuri(_res.FileName /*String*/ ,_res);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 20;BA.debugLine="Return res";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_res));return;};
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _loadcoverimage() throws Exception{
ResumableSub_LoadCoverImage rsub = new ResumableSub_LoadCoverImage(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_LoadCoverImage extends BA.ResumableSub {
public ResumableSub_LoadCoverImage(ng.dsoftlab.stegocam.filehandler parent) {
this.parent = parent;
}
ng.dsoftlab.stegocam.filehandler parent;
anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
boolean _success = false;
String _dir = "";
String _filename = "";
ng.dsoftlab.stegocam.filehandler._loadresult _res = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 24;BA.debugLine="Dim cc As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 25;BA.debugLine="cc.Initialize(\"cc\")";
_cc.Initialize("cc");
 //BA.debugLineNum = 26;BA.debugLine="cc.Show(\"image/*\", \"Choose Cover Image file\")";
_cc.Show(ba,"image/*","Choose Cover Image file");
 //BA.debugLineNum = 27;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
parent.__c.WaitFor("cc_result", ba, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
 //BA.debugLineNum = 28;BA.debugLine="Dim res As LoadResult = CreateLoadResult(Success,";
_res = parent._createloadresult(_success,_dir,_filename);
 //BA.debugLineNum = 29;BA.debugLine="If res.Success Then ExtractInformationFromURI(res";
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
parent._extractinformationfromuri(_res.FileName /*String*/ ,_res);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 30;BA.debugLine="Return res";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_res));return;};
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _startactivityforresult(anywheresoftware.b4a.objects.IntentWrapper _i) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 33;BA.debugLine="Private Sub StartActivityForResult(i As Intent)";
 //BA.debugLineNum = 34;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_getba()));
 //BA.debugLineNum = 35;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
_ion = _jo.CreateEvent(ba,"anywheresoftware.b4a.IOnActivityResult","ion",__c.Null);
 //BA.debugLineNum = 36;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array(ion,";
_jo.RunMethod("startActivityForResult",new Object[]{_ion,(Object)(_i.getObject())});
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
