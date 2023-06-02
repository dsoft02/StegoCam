package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class stegocamhandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ng.dsoftlab.stegocam.stegocamhandler");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ng.dsoftlab.stegocam.stegocamhandler.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.flm.f5steg.F5Steg _steg = null;
public byte[] _stegocambytes = null;
public anywheresoftware.b4a.objects.StringUtils _str = null;
public String _curfilename = "";
public boolean _embeddingsuccessful = false;
public String _lasterrormessage = "";
public String _file_extension = "";
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
public String  _initialize(ng.dsoftlab.stegocam.stegocamhandler __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=43581440;
 //BA.debugLineNum = 43581440;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=43581441;
 //BA.debugLineNum = 43581441;BA.debugLine="End Sub";
return "";
}
public String  _createtempcoverimage(ng.dsoftlab.stegocam.stegocamhandler __ref,anywheresoftware.b4a.objects.ImageViewWrapper _img) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "createtempcoverimage", false))
	 {return ((String) Debug.delegate(ba, "createtempcoverimage", new Object[] {_img}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=53084160;
 //BA.debugLineNum = 53084160;BA.debugLine="Sub createTempCoverImage(img As ImageView)";
RDebugUtils.currentLine=53084162;
 //BA.debugLineNum = 53084162;BA.debugLine="Dim Bitmap1 As Bitmap = img.Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bitmap1 = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_img.getBitmap()));
RDebugUtils.currentLine=53084163;
 //BA.debugLineNum = 53084163;BA.debugLine="Dim Out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=53084165;
 //BA.debugLineNum = 53084165;BA.debugLine="Out = File.OpenOutput(File.DirInternalCache, \"st";
_out = __c.File.OpenOutput(__c.File.getDirInternalCache(),"stegocover.png",__c.False);
RDebugUtils.currentLine=53084166;
 //BA.debugLineNum = 53084166;BA.debugLine="Bitmap1.WriteToStream(Out, 100, \"PNG\")";
_bitmap1.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=53084167;
 //BA.debugLineNum = 53084167;BA.debugLine="Out.Close";
_out.Close();
RDebugUtils.currentLine=53084183;
 //BA.debugLineNum = 53084183;BA.debugLine="End Sub";
return "";
}
public boolean  _iscoverimage(ng.dsoftlab.stegocam.stegocamhandler __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "iscoverimage", false))
	 {return ((Boolean) Debug.delegate(ba, "iscoverimage", null));}
RDebugUtils.currentLine=53870592;
 //BA.debugLineNum = 53870592;BA.debugLine="Sub isCoverImage() As Boolean";
RDebugUtils.currentLine=53870593;
 //BA.debugLineNum = 53870593;BA.debugLine="Return File.Exists(File.DirInternalCache, \"stegoc";
if (true) return __c.File.Exists(__c.File.getDirInternalCache(),"stegocover.png");
RDebugUtils.currentLine=53870594;
 //BA.debugLineNum = 53870594;BA.debugLine="End Sub";
return false;
}
public String  _embedtext(ng.dsoftlab.stegocam.stegocamhandler __ref,String _secrettext,String _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "embedtext", false))
	 {return ((String) Debug.delegate(ba, "embedtext", new Object[] {_secrettext,_password}));}
String _imagefilepath = "";
String _outputfilepath = "";
RDebugUtils.currentLine=54460416;
 //BA.debugLineNum = 54460416;BA.debugLine="public Sub EmbedText(secretText As String, passwor";
RDebugUtils.currentLine=54460417;
 //BA.debugLineNum = 54460417;BA.debugLine="embeddingSuccessful=False";
__ref._embeddingsuccessful /*boolean*/  = __c.False;
RDebugUtils.currentLine=54460418;
 //BA.debugLineNum = 54460418;BA.debugLine="Dim imageFilePath As String  = File.Combine(File.";
_imagefilepath = __c.File.Combine(__c.File.getDirInternalCache(),"stegocover.png");
RDebugUtils.currentLine=54460419;
 //BA.debugLineNum = 54460419;BA.debugLine="Dim outputFilePath  As String = File.Combine(File";
_outputfilepath = __c.File.Combine(__c.File.getDirInternalCache(),__ref._generatefilename /*String*/ (null));
RDebugUtils.currentLine=54460420;
 //BA.debugLineNum = 54460420;BA.debugLine="steg.EmbedString2(imageFilePath, outputFilePath,";
__ref._steg /*b4a.flm.f5steg.F5Steg*/ .EmbedString2(ba,_imagefilepath,_outputfilepath,_secrettext,(int) (100),_password,"text");
RDebugUtils.currentLine=54460421;
 //BA.debugLineNum = 54460421;BA.debugLine="End Sub";
return "";
}
public String  _embedfile(ng.dsoftlab.stegocam.stegocamhandler __ref,String _secretfile,String _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "embedfile", false))
	 {return ((String) Debug.delegate(ba, "embedfile", new Object[] {_secretfile,_password}));}
String _imagefilepath = "";
String _outputfilepath = "";
RDebugUtils.currentLine=65208320;
 //BA.debugLineNum = 65208320;BA.debugLine="Sub EmbedFile(SecretFile As String,Password As Str";
RDebugUtils.currentLine=65208321;
 //BA.debugLineNum = 65208321;BA.debugLine="Try";
try {RDebugUtils.currentLine=65208322;
 //BA.debugLineNum = 65208322;BA.debugLine="embeddingSuccessful=False";
__ref._embeddingsuccessful /*boolean*/  = __c.False;
RDebugUtils.currentLine=65208324;
 //BA.debugLineNum = 65208324;BA.debugLine="file_extension=SecretFile.SubString(SecretFile.L";
__ref._file_extension /*String*/  = _secretfile.substring((int) (_secretfile.lastIndexOf(".")+1));
RDebugUtils.currentLine=65208326;
 //BA.debugLineNum = 65208326;BA.debugLine="Msgbox(SecretFile,\"secret file\")";
__c.Msgbox(BA.ObjectToCharSequence(_secretfile),BA.ObjectToCharSequence("secret file"),getActivityBA());
RDebugUtils.currentLine=65208328;
 //BA.debugLineNum = 65208328;BA.debugLine="copyFiletoTemp(SecretFile)";
__ref._copyfiletotemp /*String*/ (null,_secretfile);
RDebugUtils.currentLine=65208330;
 //BA.debugLineNum = 65208330;BA.debugLine="Dim imageFilePath As String  = File.Combine(File";
_imagefilepath = __c.File.Combine(__c.File.getDirInternalCache(),"stegocover.png");
RDebugUtils.currentLine=65208331;
 //BA.debugLineNum = 65208331;BA.debugLine="Dim outputFilePath  As String = File.Combine(Fil";
_outputfilepath = __c.File.Combine(__c.File.getDirInternalCache(),__ref._generatefilename /*String*/ (null));
 } 
       catch (Exception e9) {
			ba.setLastException(e9);RDebugUtils.currentLine=65208334;
 //BA.debugLineNum = 65208334;BA.debugLine="Msgbox(LastException.Message,\"\")";
__c.Msgbox(BA.ObjectToCharSequence(__c.LastException(getActivityBA()).getMessage()),BA.ObjectToCharSequence(""),getActivityBA());
 };
RDebugUtils.currentLine=65208337;
 //BA.debugLineNum = 65208337;BA.debugLine="End Sub";
return "";
}
public String  _deletetempresources(ng.dsoftlab.stegocam.stegocamhandler __ref,String _res) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "deletetempresources", false))
	 {return ((String) Debug.delegate(ba, "deletetempresources", new Object[] {_res}));}
RDebugUtils.currentLine=64618496;
 //BA.debugLineNum = 64618496;BA.debugLine="Sub deleteTempResources(res As String)";
RDebugUtils.currentLine=64618497;
 //BA.debugLineNum = 64618497;BA.debugLine="If res =\"stegocover\" Then";
if ((_res).equals("stegocover")) { 
RDebugUtils.currentLine=64618498;
 //BA.debugLineNum = 64618498;BA.debugLine="File.Delete(File.DirInternalCache, \"stegocover.p";
__c.File.Delete(__c.File.getDirInternalCache(),"stegocover.png");
 };
RDebugUtils.currentLine=64618500;
 //BA.debugLineNum = 64618500;BA.debugLine="End Sub";
return "";
}
public String  _bytestofile(ng.dsoftlab.stegocam.stegocamhandler __ref,String _dir,String _filename,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "bytestofile", false))
	 {return ((String) Debug.delegate(ba, "bytestofile", new Object[] {_dir,_filename,_data}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=65863680;
 //BA.debugLineNum = 65863680;BA.debugLine="Sub BytesToFile (Dir As String, FileName As String";
RDebugUtils.currentLine=65863681;
 //BA.debugLineNum = 65863681;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir, Fi";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
RDebugUtils.currentLine=65863682;
 //BA.debugLineNum = 65863682;BA.debugLine="out.WriteBytes(Data, 0, Data.Length)";
_out.WriteBytes(_data,(int) (0),_data.length);
RDebugUtils.currentLine=65863683;
 //BA.debugLineNum = 65863683;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=65863684;
 //BA.debugLineNum = 65863684;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(ng.dsoftlab.stegocam.stegocamhandler __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
RDebugUtils.currentLine=43515904;
 //BA.debugLineNum = 43515904;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=43515905;
 //BA.debugLineNum = 43515905;BA.debugLine="Private steg As F5Steg";
_steg = new b4a.flm.f5steg.F5Steg();
RDebugUtils.currentLine=43515906;
 //BA.debugLineNum = 43515906;BA.debugLine="Private stegoCamBytes() As Byte = \"STEGOCAM_\".Get";
_stegocambytes = "STEGOCAM_".getBytes("UTF8");
RDebugUtils.currentLine=43515907;
 //BA.debugLineNum = 43515907;BA.debugLine="Private str As StringUtils";
_str = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=43515908;
 //BA.debugLineNum = 43515908;BA.debugLine="Public curFilename As String";
_curfilename = "";
RDebugUtils.currentLine=43515909;
 //BA.debugLineNum = 43515909;BA.debugLine="Public embeddingSuccessful As Boolean=False";
_embeddingsuccessful = __c.False;
RDebugUtils.currentLine=43515910;
 //BA.debugLineNum = 43515910;BA.debugLine="Public lastErrorMessage As String = \"\"";
_lasterrormessage = "";
RDebugUtils.currentLine=43515911;
 //BA.debugLineNum = 43515911;BA.debugLine="Public file_extension As String = \"\"";
_file_extension = "";
RDebugUtils.currentLine=43515912;
 //BA.debugLineNum = 43515912;BA.debugLine="End Sub";
return "";
}
public byte[]  _combinebytes(ng.dsoftlab.stegocam.stegocamhandler __ref,byte[] _arr1,byte[] _arr2) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "combinebytes", false))
	 {return ((byte[]) Debug.delegate(ba, "combinebytes", new Object[] {_arr1,_arr2}));}
byte[] _res = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
RDebugUtils.currentLine=54919168;
 //BA.debugLineNum = 54919168;BA.debugLine="Sub CombineBytes(arr1() As Byte, arr2() As Byte) A";
RDebugUtils.currentLine=54919169;
 //BA.debugLineNum = 54919169;BA.debugLine="Dim res(arr1.Length + arr2.Length) As Byte";
_res = new byte[(int) (_arr1.length+_arr2.length)];
;
RDebugUtils.currentLine=54919170;
 //BA.debugLineNum = 54919170;BA.debugLine="Dim bc As ByteConverter 'ByteConverter library";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
RDebugUtils.currentLine=54919171;
 //BA.debugLineNum = 54919171;BA.debugLine="bc.ArrayCopy(arr1, 0, res, 0, arr1.Length)";
_bc.ArrayCopy((Object)(_arr1),(int) (0),(Object)(_res),(int) (0),_arr1.length);
RDebugUtils.currentLine=54919172;
 //BA.debugLineNum = 54919172;BA.debugLine="bc.ArrayCopy(arr2, 0, res, arr1.Length, arr2.Leng";
_bc.ArrayCopy((Object)(_arr2),(int) (0),(Object)(_res),_arr1.length,_arr2.length);
RDebugUtils.currentLine=54919173;
 //BA.debugLineNum = 54919173;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=54919174;
 //BA.debugLineNum = 54919174;BA.debugLine="End Sub";
return null;
}
public String  _copyfiletotemp(ng.dsoftlab.stegocam.stegocamhandler __ref,String _cfilename) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "copyfiletotemp", false))
	 {return ((String) Debug.delegate(ba, "copyfiletotemp", new Object[] {_cfilename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _inp = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=67043328;
 //BA.debugLineNum = 67043328;BA.debugLine="Sub copyFiletoTemp(cfilename As String)";
RDebugUtils.currentLine=67043329;
 //BA.debugLineNum = 67043329;BA.debugLine="Try";
try {RDebugUtils.currentLine=67043330;
 //BA.debugLineNum = 67043330;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=67043331;
 //BA.debugLineNum = 67043331;BA.debugLine="Dim Inp As InputStream  = GetStreamFromContentRe";
_inp = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_inp = __ref._getstreamfromcontentresult /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ (null,_cfilename);
RDebugUtils.currentLine=67043332;
 //BA.debugLineNum = 67043332;BA.debugLine="Dim cfilename As String = \"stegofile.\" & file_ex";
_cfilename = "stegofile."+__ref._file_extension /*String*/ ;
RDebugUtils.currentLine=67043333;
 //BA.debugLineNum = 67043333;BA.debugLine="Dim Out As OutputStream = File.OpenOutput(File.D";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(__c.File.getDirInternalCache(),_cfilename,__c.False);
RDebugUtils.currentLine=67043334;
 //BA.debugLineNum = 67043334;BA.debugLine="File.copy2(Inp, Out)";
__c.File.Copy2((java.io.InputStream)(_inp.getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=67043335;
 //BA.debugLineNum = 67043335;BA.debugLine="Inp.Close";
_inp.Close();
RDebugUtils.currentLine=67043336;
 //BA.debugLineNum = 67043336;BA.debugLine="Out.Close";
_out.Close();
RDebugUtils.currentLine=67043337;
 //BA.debugLineNum = 67043337;BA.debugLine="Msgbox(File.Exists(File.DirInternalCache, cfilen";
__c.Msgbox(BA.ObjectToCharSequence(__c.File.Exists(__c.File.getDirInternalCache(),_cfilename)),BA.ObjectToCharSequence("exist"),getActivityBA());
 } 
       catch (Exception e11) {
			ba.setLastException(e11);RDebugUtils.currentLine=67043339;
 //BA.debugLineNum = 67043339;BA.debugLine="Msgbox(LastException.Message,\"\")";
__c.Msgbox(BA.ObjectToCharSequence(__c.LastException(getActivityBA()).getMessage()),BA.ObjectToCharSequence(""),getActivityBA());
RDebugUtils.currentLine=67043340;
 //BA.debugLineNum = 67043340;BA.debugLine="Log(\":: issue \" & LastException)";
__c.LogImpl("767043340",":: issue "+BA.ObjectToString(__c.LastException(getActivityBA())),0);
 };
RDebugUtils.currentLine=67043342;
 //BA.debugLineNum = 67043342;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _getstreamfromcontentresult(ng.dsoftlab.stegocam.stegocamhandler __ref,String _uristring) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "getstreamfromcontentresult", false))
	 {return ((anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) Debug.delegate(ba, "getstreamfromcontentresult", new Object[] {_uristring}));}
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object _uri = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _istream = null;
RDebugUtils.currentLine=66125824;
 //BA.debugLineNum = 66125824;BA.debugLine="Sub GetStreamFromContentResult(UriString As String";
RDebugUtils.currentLine=66125825;
 //BA.debugLineNum = 66125825;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=66125826;
 //BA.debugLineNum = 66125826;BA.debugLine="Dim Uri As Object";
_uri = new Object();
RDebugUtils.currentLine=66125827;
 //BA.debugLineNum = 66125827;BA.debugLine="Dim iStream As InputStream";
_istream = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=66125828;
 //BA.debugLineNum = 66125828;BA.debugLine="Uri = r.RunStaticMethod(\"android.net.Uri\", \"parse";
_uri = _r.RunStaticMethod("android.net.Uri","parse",new Object[]{(Object)(_uristring)},new String[]{"java.lang.String"});
RDebugUtils.currentLine=66125829;
 //BA.debugLineNum = 66125829;BA.debugLine="r.Target = r.GetContext";
_r.Target = (Object)(_r.GetContext(ba));
RDebugUtils.currentLine=66125830;
 //BA.debugLineNum = 66125830;BA.debugLine="r.Target = r.RunMethod(\"getContentResolver\")";
_r.Target = _r.RunMethod("getContentResolver");
RDebugUtils.currentLine=66125831;
 //BA.debugLineNum = 66125831;BA.debugLine="iStream = r.RunMethod4( \"openInputStream\", Array";
_istream = (anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper(), (java.io.InputStream)(_r.RunMethod4("openInputStream",new Object[]{_uri},new String[]{"android.net.Uri"})));
RDebugUtils.currentLine=66125832;
 //BA.debugLineNum = 66125832;BA.debugLine="Return iStream";
if (true) return _istream;
RDebugUtils.currentLine=66125833;
 //BA.debugLineNum = 66125833;BA.debugLine="End Sub";
return null;
}
public String  _generatefilename(ng.dsoftlab.stegocam.stegocamhandler __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "generatefilename", false))
	 {return ((String) Debug.delegate(ba, "generatefilename", null));}
long _timestamp = 0L;
String _filename = "";
RDebugUtils.currentLine=54525952;
 //BA.debugLineNum = 54525952;BA.debugLine="Sub GenerateFilename() As String";
RDebugUtils.currentLine=54525953;
 //BA.debugLineNum = 54525953;BA.debugLine="Dim timestamp As Long = DateTime.Now";
_timestamp = __c.DateTime.getNow();
RDebugUtils.currentLine=54525954;
 //BA.debugLineNum = 54525954;BA.debugLine="Dim filename As String = \"IMG_\" & timestamp &";
_filename = "IMG_"+BA.NumberToString(_timestamp)+".jpg";
RDebugUtils.currentLine=54525955;
 //BA.debugLineNum = 54525955;BA.debugLine="curFilename=filename";
__ref._curfilename /*String*/  = _filename;
RDebugUtils.currentLine=54525956;
 //BA.debugLineNum = 54525956;BA.debugLine="Return filename";
if (true) return _filename;
RDebugUtils.currentLine=54525957;
 //BA.debugLineNum = 54525957;BA.debugLine="End Sub";
return "";
}
public String  _extracttextwithpassword(ng.dsoftlab.stegocam.stegocamhandler __ref,String _imagefilepath,String _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "extracttextwithpassword", false))
	 {return ((String) Debug.delegate(ba, "extracttextwithpassword", new Object[] {_imagefilepath,_password}));}
RDebugUtils.currentLine=49741824;
 //BA.debugLineNum = 49741824;BA.debugLine="Public Sub ExtractTextWithPassword(imageFilePath A";
RDebugUtils.currentLine=49741826;
 //BA.debugLineNum = 49741826;BA.debugLine="steg.ExtractToString2(imageFilePath, password, \"s";
__ref._steg /*b4a.flm.f5steg.F5Steg*/ .ExtractToString2(ba,_imagefilepath,_password,"steg");
RDebugUtils.currentLine=49741827;
 //BA.debugLineNum = 49741827;BA.debugLine="End Sub";
return "";
}
public String  _file_embedded(ng.dsoftlab.stegocam.stegocamhandler __ref,String _outfilename) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "file_embedded", false))
	 {return ((String) Debug.delegate(ba, "file_embedded", new Object[] {_outfilename}));}
byte[] _imagebytes = null;
String _textstr = "";
byte[] _textbytes = null;
byte[] _modifiedbytes = null;
byte[] _newimagebytes = null;
RDebugUtils.currentLine=65798144;
 //BA.debugLineNum = 65798144;BA.debugLine="Sub file_Embedded(OutFileName As String)";
RDebugUtils.currentLine=65798145;
 //BA.debugLineNum = 65798145;BA.debugLine="Try";
try {RDebugUtils.currentLine=65798147;
 //BA.debugLineNum = 65798147;BA.debugLine="Dim imageBytes() As Byte = File.ReadBytes(OutFil";
_imagebytes = __c.File.ReadBytes(_outfilename,"");
RDebugUtils.currentLine=65798149;
 //BA.debugLineNum = 65798149;BA.debugLine="Dim textStr As String = \"FILE_\" & file_extension";
_textstr = "FILE_"+__ref._file_extension /*String*/ ;
RDebugUtils.currentLine=65798152;
 //BA.debugLineNum = 65798152;BA.debugLine="Dim textBytes() As Byte = textStr.GetBytes(\"UTF8";
_textbytes = _textstr.getBytes("UTF8");
RDebugUtils.currentLine=65798155;
 //BA.debugLineNum = 65798155;BA.debugLine="Dim modifiedBytes() As Byte =CombineBytes(stegoC";
_modifiedbytes = __ref._combinebytes /*byte[]*/ (null,__ref._stegocambytes /*byte[]*/ ,_textbytes);
RDebugUtils.currentLine=65798158;
 //BA.debugLineNum = 65798158;BA.debugLine="Dim newImageBytes() As Byte = CombineBytes(image";
_newimagebytes = __ref._combinebytes /*byte[]*/ (null,_imagebytes,_modifiedbytes);
RDebugUtils.currentLine=65798161;
 //BA.debugLineNum = 65798161;BA.debugLine="File.WriteBytes(OutFileName,\"\", newImageBytes)";
__c.File.WriteBytes(_outfilename,"",_newimagebytes);
RDebugUtils.currentLine=65798164;
 //BA.debugLineNum = 65798164;BA.debugLine="File.Copy(OutFileName,\"\",config.stegoImagePath,c";
__c.File.Copy(_outfilename,"",_config._stegoimagepath /*String*/ ,__ref._curfilename /*String*/ );
RDebugUtils.currentLine=65798165;
 //BA.debugLineNum = 65798165;BA.debugLine="embeddingSuccessful =File.Exists(config.stegoIma";
__ref._embeddingsuccessful /*boolean*/  = __c.File.Exists(_config._stegoimagepath /*String*/ ,__ref._curfilename /*String*/ );
RDebugUtils.currentLine=65798166;
 //BA.debugLineNum = 65798166;BA.debugLine="lastErrorMessage=\"\"";
__ref._lasterrormessage /*String*/  = "";
RDebugUtils.currentLine=65798168;
 //BA.debugLineNum = 65798168;BA.debugLine="File.Delete(OutFileName,\"\")";
__c.File.Delete(_outfilename,"");
 } 
       catch (Exception e13) {
			ba.setLastException(e13);RDebugUtils.currentLine=65798170;
 //BA.debugLineNum = 65798170;BA.debugLine="embeddingSuccessful =False";
__ref._embeddingsuccessful /*boolean*/  = __c.False;
RDebugUtils.currentLine=65798171;
 //BA.debugLineNum = 65798171;BA.debugLine="lastErrorMessage=\"Embedding Failed: \" & LastExce";
__ref._lasterrormessage /*String*/  = "Embedding Failed: "+__c.LastException(getActivityBA()).getMessage();
RDebugUtils.currentLine=65798172;
 //BA.debugLineNum = 65798172;BA.debugLine="ToastMessageShow(\"Embedding Failed: \" & LastExce";
__c.ToastMessageShow(BA.ObjectToCharSequence("Embedding Failed: "+__c.LastException(getActivityBA()).getMessage()),__c.True);
 };
RDebugUtils.currentLine=65798174;
 //BA.debugLineNum = 65798174;BA.debugLine="End Sub";
return "";
}
public byte[]  _filetobytes(ng.dsoftlab.stegocam.stegocamhandler __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "filetobytes", false))
	 {return ((byte[]) Debug.delegate(ba, "filetobytes", new Object[] {_dir,_filename}));}
RDebugUtils.currentLine=50003968;
 //BA.debugLineNum = 50003968;BA.debugLine="Sub FileToBytes (Dir As String, FileName As String";
RDebugUtils.currentLine=50003969;
 //BA.debugLineNum = 50003969;BA.debugLine="Return Bit.InputStreamToBytes(File.OpenInput(Dir,";
if (true) return __c.Bit.InputStreamToBytes((java.io.InputStream)(__c.File.OpenInput(_dir,_filename).getObject()));
RDebugUtils.currentLine=50003970;
 //BA.debugLineNum = 50003970;BA.debugLine="End Sub";
return null;
}
public String  _steg_stringextracted(ng.dsoftlab.stegocam.stegocamhandler __ref,String _secretmessage) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "steg_stringextracted", false))
	 {return ((String) Debug.delegate(ba, "steg_stringextracted", new Object[] {_secretmessage}));}
RDebugUtils.currentLine=49807360;
 //BA.debugLineNum = 49807360;BA.debugLine="Sub steg_StringExtracted(SecretMessage As String)";
RDebugUtils.currentLine=49807361;
 //BA.debugLineNum = 49807361;BA.debugLine="Log(\"Extracted Text: \" & SecretMessage)";
__c.LogImpl("749807361","Extracted Text: "+_secretmessage,0);
RDebugUtils.currentLine=49807362;
 //BA.debugLineNum = 49807362;BA.debugLine="End Sub";
return "";
}
public String  _text_embedded(ng.dsoftlab.stegocam.stegocamhandler __ref,String _outfilename) throws Exception{
__ref = this;
RDebugUtils.currentModule="stegocamhandler";
if (Debug.shouldDelegate(ba, "text_embedded", false))
	 {return ((String) Debug.delegate(ba, "text_embedded", new Object[] {_outfilename}));}
byte[] _imagebytes = null;
byte[] _textbytes = null;
byte[] _modifiedbytes = null;
byte[] _newimagebytes = null;
RDebugUtils.currentLine=65536000;
 //BA.debugLineNum = 65536000;BA.debugLine="Sub text_Embedded(OutFileName As String)";
RDebugUtils.currentLine=65536001;
 //BA.debugLineNum = 65536001;BA.debugLine="Try";
try {RDebugUtils.currentLine=65536003;
 //BA.debugLineNum = 65536003;BA.debugLine="Dim imageBytes() As Byte = File.ReadBytes(OutFil";
_imagebytes = __c.File.ReadBytes(_outfilename,"");
RDebugUtils.currentLine=65536006;
 //BA.debugLineNum = 65536006;BA.debugLine="Dim textBytes() As Byte = \"TEXT\".GetBytes(\"UTF8\"";
_textbytes = "TEXT".getBytes("UTF8");
RDebugUtils.currentLine=65536009;
 //BA.debugLineNum = 65536009;BA.debugLine="Dim modifiedBytes() As Byte =CombineBytes(stegoC";
_modifiedbytes = __ref._combinebytes /*byte[]*/ (null,__ref._stegocambytes /*byte[]*/ ,_textbytes);
RDebugUtils.currentLine=65536012;
 //BA.debugLineNum = 65536012;BA.debugLine="Dim newImageBytes() As Byte = CombineBytes(image";
_newimagebytes = __ref._combinebytes /*byte[]*/ (null,_imagebytes,_modifiedbytes);
RDebugUtils.currentLine=65536015;
 //BA.debugLineNum = 65536015;BA.debugLine="File.WriteBytes(OutFileName,\"\", newImageBytes)";
__c.File.WriteBytes(_outfilename,"",_newimagebytes);
RDebugUtils.currentLine=65536018;
 //BA.debugLineNum = 65536018;BA.debugLine="File.Copy(OutFileName,\"\",config.stegoImagePath,c";
__c.File.Copy(_outfilename,"",_config._stegoimagepath /*String*/ ,__ref._curfilename /*String*/ );
RDebugUtils.currentLine=65536019;
 //BA.debugLineNum = 65536019;BA.debugLine="embeddingSuccessful =File.Exists(config.stegoIma";
__ref._embeddingsuccessful /*boolean*/  = __c.File.Exists(_config._stegoimagepath /*String*/ ,__ref._curfilename /*String*/ );
RDebugUtils.currentLine=65536020;
 //BA.debugLineNum = 65536020;BA.debugLine="lastErrorMessage=\"\"";
__ref._lasterrormessage /*String*/  = "";
RDebugUtils.currentLine=65536022;
 //BA.debugLineNum = 65536022;BA.debugLine="File.Delete(OutFileName,\"\")";
__c.File.Delete(_outfilename,"");
 } 
       catch (Exception e12) {
			ba.setLastException(e12);RDebugUtils.currentLine=65536024;
 //BA.debugLineNum = 65536024;BA.debugLine="embeddingSuccessful =False";
__ref._embeddingsuccessful /*boolean*/  = __c.False;
RDebugUtils.currentLine=65536025;
 //BA.debugLineNum = 65536025;BA.debugLine="lastErrorMessage=\"Embedding Failed: \" & LastExce";
__ref._lasterrormessage /*String*/  = "Embedding Failed: "+__c.LastException(getActivityBA()).getMessage();
RDebugUtils.currentLine=65536026;
 //BA.debugLineNum = 65536026;BA.debugLine="ToastMessageShow(\"Embedding Failed: \" & LastExce";
__c.ToastMessageShow(BA.ObjectToCharSequence("Embedding Failed: "+__c.LastException(getActivityBA()).getMessage()),__c.True);
 };
RDebugUtils.currentLine=65536028;
 //BA.debugLineNum = 65536028;BA.debugLine="End Sub";
return "";
}
}