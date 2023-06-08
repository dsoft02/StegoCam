package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class stegocamhandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "ng.dsoftlab.stegocam.stegocamhandler");
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

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.flm.f5steg.F5Steg _steg = null;
public byte[] _stegocambytes = null;
public anywheresoftware.b4a.objects.StringUtils _str = null;
public String _curfilename = "";
public boolean _embeddingsuccessful = false;
public boolean _extractionsuccessful = false;
public String _lasterrormessage = "";
public String _file_extension = "";
public String _extractedstring = "";
public byte[] _stegomarkerbyte = null;
public b4a.example.dateutils _dateutils = null;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.encode _encode = null;
public ng.dsoftlab.stegocam.history _history = null;
public ng.dsoftlab.stegocam.decode _decode = null;
public ng.dsoftlab.stegocam.settings _settings = null;
public ng.dsoftlab.stegocam.pinreset _pinreset = null;
public ng.dsoftlab.stegocam.forgotpin _forgotpin = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinchange _pinchange = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
public ng.dsoftlab.stegocam.securityquestion _securityquestion = null;
public ng.dsoftlab.stegocam.stegopreview _stegopreview = null;
public ng.dsoftlab.stegocam.b4xcollections _b4xcollections = null;
public ng.dsoftlab.stegocam.httputils2service _httputils2service = null;
public ng.dsoftlab.stegocam.xuiviewsutils _xuiviewsutils = null;
public String  _bytestofile(byte[] _data,String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 154;BA.debugLine="Sub BytesToFile (Data() As Byte,Dir As String, Fil";
 //BA.debugLineNum = 155;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir, Fi";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
 //BA.debugLineNum = 156;BA.debugLine="out.WriteBytes(Data, 0, Data.Length)";
_out.WriteBytes(_data,(int) (0),_data.length);
 //BA.debugLineNum = 157;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private steg As F5Steg";
_steg = new b4a.flm.f5steg.F5Steg();
 //BA.debugLineNum = 3;BA.debugLine="Private stegoCamBytes() As Byte = \"_STEGOCAM_\".Ge";
_stegocambytes = "_STEGOCAM_".getBytes("UTF8");
 //BA.debugLineNum = 4;BA.debugLine="Private str As StringUtils";
_str = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 5;BA.debugLine="Public curFilename As String";
_curfilename = "";
 //BA.debugLineNum = 6;BA.debugLine="Public embeddingSuccessful As Boolean=False";
_embeddingsuccessful = __c.False;
 //BA.debugLineNum = 7;BA.debugLine="Public extractionSuccessful As Boolean=False";
_extractionsuccessful = __c.False;
 //BA.debugLineNum = 8;BA.debugLine="Public lastErrorMessage As String = \"\"";
_lasterrormessage = "";
 //BA.debugLineNum = 9;BA.debugLine="Public file_extension As String = \"\"";
_file_extension = "";
 //BA.debugLineNum = 10;BA.debugLine="Public extractedString As String = \"\"";
_extractedstring = "";
 //BA.debugLineNum = 11;BA.debugLine="Public stegoMarkerByte() As Byte = FileToBytes(Fi";
_stegomarkerbyte = _filetobytes(__c.File.getDirAssets(),"stegomarker.jpg");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public byte[]  _combinebytes(byte[] _arr1,byte[] _arr2) throws Exception{
byte[] _res = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 78;BA.debugLine="Sub CombineBytes(arr1() As Byte, arr2() As Byte) A";
 //BA.debugLineNum = 79;BA.debugLine="Dim res(arr1.Length + arr2.Length) As Byte";
_res = new byte[(int) (_arr1.length+_arr2.length)];
;
 //BA.debugLineNum = 80;BA.debugLine="Dim bc As ByteConverter 'ByteConverter library";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 81;BA.debugLine="bc.ArrayCopy(arr1, 0, res, 0, arr1.Length)";
_bc.ArrayCopy((Object)(_arr1),(int) (0),(Object)(_res),(int) (0),_arr1.length);
 //BA.debugLineNum = 82;BA.debugLine="bc.ArrayCopy(arr2, 0, res, arr1.Length, arr2.Leng";
_bc.ArrayCopy((Object)(_arr2),(int) (0),(Object)(_res),_arr1.length,_arr2.length);
 //BA.debugLineNum = 83;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return null;
}
public String  _copyfiletotemp(String _srcfile,String _destfile) throws Exception{
String _returnfilepath = "";
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _inp = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 175;BA.debugLine="Sub copyFiletoTemp(srcFile As String,destFile As S";
 //BA.debugLineNum = 176;BA.debugLine="Dim returnFilePath As String =\"\"";
_returnfilepath = "";
 //BA.debugLineNum = 177;BA.debugLine="Try";
try { //BA.debugLineNum = 179;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 180;BA.debugLine="Dim Inp As InputStream  = GetStreamFromContentRe";
_inp = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_inp = _getstreamfromcontentresult(_srcfile);
 //BA.debugLineNum = 182;BA.debugLine="Dim Out As OutputStream = File.OpenOutput(File.D";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(__c.File.getDirInternalCache(),_destfile,__c.False);
 //BA.debugLineNum = 183;BA.debugLine="File.copy2(Inp, Out)";
__c.File.Copy2((java.io.InputStream)(_inp.getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 184;BA.debugLine="Inp.Close";
_inp.Close();
 //BA.debugLineNum = 185;BA.debugLine="Out.Close";
_out.Close();
 //BA.debugLineNum = 186;BA.debugLine="returnFilePath=File.combine(File.DirInternalCach";
_returnfilepath = __c.File.Combine(__c.File.getDirInternalCache(),_destfile);
 } 
       catch (Exception e11) {
			ba.setLastException(e11); //BA.debugLineNum = 188;BA.debugLine="returnFilePath=\"\"";
_returnfilepath = "";
 //BA.debugLineNum = 190;BA.debugLine="Log(\":: issue \" & LastException)";
__c.LogImpl("36291471",":: issue "+BA.ObjectToString(__c.LastException(getActivityBA())),0);
 };
 //BA.debugLineNum = 192;BA.debugLine="Return returnFilePath";
if (true) return _returnfilepath;
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _createtempcoverimage(ng.dsoftlab.stegocam.b4ximageview _img) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 134;BA.debugLine="Sub createTempCoverImage(img As B4XImageView)";
 //BA.debugLineNum = 135;BA.debugLine="Dim Bitmap1 As Bitmap = img.Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bitmap1 = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_img._getbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ ().getObject()));
 //BA.debugLineNum = 136;BA.debugLine="Dim Out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 138;BA.debugLine="Out = File.OpenOutput(File.DirInternalCache, \"st";
_out = __c.File.OpenOutput(__c.File.getDirInternalCache(),"stegocover.png",__c.False);
 //BA.debugLineNum = 139;BA.debugLine="Bitmap1.WriteToStream(Out, 100, \"PNG\")";
_bitmap1.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
 //BA.debugLineNum = 140;BA.debugLine="Out.Close";
_out.Close();
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _deletetempresources(String _res) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Sub deleteTempResources(res As String)";
 //BA.debugLineNum = 149;BA.debugLine="If res =\"stegocover\" Then";
if ((_res).equals("stegocover")) { 
 //BA.debugLineNum = 150;BA.debugLine="File.Delete(File.DirInternalCache, \"stegocover.p";
__c.File.Delete(__c.File.getDirInternalCache(),"stegocover.png");
 };
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public String  _embedtext(String _secrettext,String _password) throws Exception{
String _imagefilepath = "";
String _outputfilepath = "";
 //BA.debugLineNum = 27;BA.debugLine="public Sub EmbedText(secretText As String, passwor";
 //BA.debugLineNum = 28;BA.debugLine="embeddingSuccessful=False";
_embeddingsuccessful = __c.False;
 //BA.debugLineNum = 29;BA.debugLine="Dim imageFilePath As String  = File.Combine(File.";
_imagefilepath = __c.File.Combine(__c.File.getDirInternalCache(),"stegocover.png");
 //BA.debugLineNum = 30;BA.debugLine="Dim outputFilePath  As String = File.Combine(File";
_outputfilepath = __c.File.Combine(__c.File.getDirInternalCache(),_generatefilename());
 //BA.debugLineNum = 31;BA.debugLine="steg.EmbedString2(imageFilePath, outputFilePath,";
_steg.EmbedString2(ba,_imagefilepath,_outputfilepath,_secrettext,(int) (100),_password,"text");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _extracttext(String _imagefilepath,String _password) throws Exception{
String[] _errmessage = null;
 //BA.debugLineNum = 50;BA.debugLine="Public Sub ExtractText(imageFilePath As String, pa";
 //BA.debugLineNum = 52;BA.debugLine="Try";
try { //BA.debugLineNum = 53;BA.debugLine="steg.ExtractToString2(imageFilePath, password, \"";
_steg.ExtractToString2(ba,_imagefilepath,_password,"steg");
 //BA.debugLineNum = 55;BA.debugLine="lastErrorMessage=\"Success: Extraction completed";
_lasterrormessage = "Success: Extraction completed successfully!";
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 57;BA.debugLine="Log(LastException)";
__c.LogImpl("35570567",BA.ObjectToString(__c.LastException(getActivityBA())),0);
 //BA.debugLineNum = 58;BA.debugLine="Dim errMessage() As String =Regex.Split(\":\", Las";
_errmessage = __c.Regex.Split(":",__c.LastException(getActivityBA()).getMessage());
 //BA.debugLineNum = 59;BA.debugLine="If errMessage(errMessage.Length-1) =\"BAD_DECRYPT";
if ((_errmessage[(int) (_errmessage.length-1)]).equals("BAD_DECRYPT")) { 
 //BA.debugLineNum = 60;BA.debugLine="Msgbox2Async(\"Error: Invalid Decryption Key Ple";
__c.Msgbox2Async(BA.ObjectToCharSequence("Error: Invalid Decryption Key Please Try Again!"),BA.ObjectToCharSequence("Extraction Fail"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(__c.Null)),ba,__c.False);
 //BA.debugLineNum = 61;BA.debugLine="lastErrorMessage=\"Error: Invalid Decryption Key";
_lasterrormessage = "Error: Invalid Decryption Key Please Try Again!";
 }else {
 //BA.debugLineNum = 63;BA.debugLine="Msgbox2Async(\"Error: Invalid Stego Image or wro";
__c.Msgbox2Async(BA.ObjectToCharSequence("Error: Invalid Stego Image or wrong Decryption Key Please Try Again!"),BA.ObjectToCharSequence("Extraction Fail"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(__c.Null)),ba,__c.False);
 //BA.debugLineNum = 64;BA.debugLine="lastErrorMessage=\"Error: Invalid Stego Image or";
_lasterrormessage = "Error: Invalid Stego Image or wrong Decryption Key";
 };
 //BA.debugLineNum = 67;BA.debugLine="extractionSuccessful=False";
_extractionsuccessful = __c.False;
 };
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public byte[]  _filetobytes(String _dir,String _filename) throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Sub FileToBytes (Dir As String, FileName As String";
 //BA.debugLineNum = 161;BA.debugLine="Return Bit.InputStreamToBytes(File.OpenInput(Di";
if (true) return __c.Bit.InputStreamToBytes((java.io.InputStream)(__c.File.OpenInput(_dir,_filename).getObject()));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return null;
}
public String  _generatefilename() throws Exception{
long _timestamp = 0L;
String _filename = "";
 //BA.debugLineNum = 18;BA.debugLine="Sub GenerateFilename() As String";
 //BA.debugLineNum = 19;BA.debugLine="Dim timestamp As Long = DateTime.Now";
_timestamp = __c.DateTime.getNow();
 //BA.debugLineNum = 20;BA.debugLine="Dim filename As String = \"IMG_\" & timestamp &";
_filename = "IMG_"+BA.NumberToString(_timestamp)+".jpg";
 //BA.debugLineNum = 21;BA.debugLine="curFilename=filename";
_curfilename = _filename;
 //BA.debugLineNum = 22;BA.debugLine="Return filename";
if (true) return _filename;
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _getstreamfromcontentresult(String _uristring) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object _uri = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _istream = null;
 //BA.debugLineNum = 164;BA.debugLine="Sub GetStreamFromContentResult(UriString As String";
 //BA.debugLineNum = 165;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 166;BA.debugLine="Dim Uri As Object";
_uri = new Object();
 //BA.debugLineNum = 167;BA.debugLine="Dim iStream As InputStream";
_istream = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 168;BA.debugLine="Uri = r.RunStaticMethod(\"android.net.Uri\", \"parse";
_uri = _r.RunStaticMethod("android.net.Uri","parse",new Object[]{(Object)(_uristring)},new String[]{"java.lang.String"});
 //BA.debugLineNum = 169;BA.debugLine="r.Target = r.GetContext";
_r.Target = (Object)(_r.GetContext(ba));
 //BA.debugLineNum = 170;BA.debugLine="r.Target = r.RunMethod(\"getContentResolver\")";
_r.Target = _r.RunMethod("getContentResolver");
 //BA.debugLineNum = 171;BA.debugLine="iStream = r.RunMethod4( \"openInputStream\", Array";
_istream = (anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper(), (java.io.InputStream)(_r.RunMethod4("openInputStream",new Object[]{_uri},new String[]{"android.net.Uri"})));
 //BA.debugLineNum = 172;BA.debugLine="Return iStream";
if (true) return _istream;
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public boolean  _iscoverimage() throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Sub isCoverImage() As Boolean";
 //BA.debugLineNum = 145;BA.debugLine="Return File.Exists(File.DirInternalCache, \"stegoc";
if (true) return __c.File.Exists(__c.File.getDirInternalCache(),"stegocover.png");
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return false;
}
public boolean  _isstegoimage(String _imagefilepath) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
byte[] _filebytes = null;
String _filebytesstring = "";
String _stegobytesstring = "";
 //BA.debugLineNum = 86;BA.debugLine="Public Sub isStegoImage(imageFilePath As String) A";
 //BA.debugLineNum = 87;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 89;BA.debugLine="If Not(File.Exists(imageFilePath,\"\")) Then";
if (__c.Not(__c.File.Exists(_imagefilepath,""))) { 
 //BA.debugLineNum = 91;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 95;BA.debugLine="Dim fileBytes() As Byte = FileToBytes(imageFil";
_filebytes = _filetobytes(_imagefilepath,"");
 //BA.debugLineNum = 96;BA.debugLine="Dim fileBytesString As String= bc.StringFromBytes";
_filebytesstring = _bc.StringFromBytes(_filebytes,"UTF8");
 //BA.debugLineNum = 97;BA.debugLine="Dim stegoBytesString As String =bc.StringFromByte";
_stegobytesstring = _bc.StringFromBytes(_stegomarkerbyte,"UTF8");
 //BA.debugLineNum = 98;BA.debugLine="If fileBytesString.Contains(stegoBytesString) The";
if (_filebytesstring.contains(_stegobytesstring)) { 
 //BA.debugLineNum = 99;BA.debugLine="Return True";
if (true) return __c.True;
 }else {
 //BA.debugLineNum = 101;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 104;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return false;
}
public String  _removestegocambytes(String _imagefilepath) throws Exception{
String _newfilepath = "";
byte[] _filebytes = null;
int _stegocamlength = 0;
int _newlength = 0;
byte[] _modifiedbytes = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 107;BA.debugLine="Public Sub RemoveStegoCamBytes(imageFilePath As St";
 //BA.debugLineNum = 108;BA.debugLine="Dim newFilePath As String = \"\"";
_newfilepath = "";
 //BA.debugLineNum = 109;BA.debugLine="Try";
try { //BA.debugLineNum = 110;BA.debugLine="Dim fileBytes() As Byte = File.ReadBytes(imageFi";
_filebytes = __c.File.ReadBytes(_imagefilepath,"");
 //BA.debugLineNum = 112;BA.debugLine="Dim stegoCamLength As Int = stegoMarkerByte.Leng";
_stegocamlength = _stegomarkerbyte.length;
 //BA.debugLineNum = 114;BA.debugLine="Dim newLength As Int = fileBytes.Length - stegoC";
_newlength = (int) (_filebytes.length-_stegocamlength);
 //BA.debugLineNum = 116;BA.debugLine="Dim modifiedBytes(newLength) As Byte";
_modifiedbytes = new byte[_newlength];
;
 //BA.debugLineNum = 117;BA.debugLine="Dim bc As ByteConverter 'ByteConverter library";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 120;BA.debugLine="bc.ArrayCopy(fileBytes,0, modifiedBytes,0, newLe";
_bc.ArrayCopy((Object)(_filebytes),(int) (0),(Object)(_modifiedbytes),(int) (0),_newlength);
 //BA.debugLineNum = 123;BA.debugLine="newFilePath = File.Combine(File.DirInternalCache";
_newfilepath = __c.File.Combine(__c.File.getDirInternalCache(),"ModifiedStegoImage.jpg");
 //BA.debugLineNum = 124;BA.debugLine="File.WriteBytes(newFilePath,\"\", modifiedBytes)";
__c.File.WriteBytes(_newfilepath,"",_modifiedbytes);
 } 
       catch (Exception e12) {
			ba.setLastException(e12); //BA.debugLineNum = 128;BA.debugLine="ToastMessageShow(\"Error: \" & LastException.Messa";
__c.ToastMessageShow(BA.ObjectToCharSequence("Error: "+__c.LastException(getActivityBA()).getMessage()),__c.True);
 };
 //BA.debugLineNum = 131;BA.debugLine="Return newFilePath";
if (true) return _newfilepath;
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public String  _steg_stringextracted(String _secretmessage) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub steg_StringExtracted(SecretMessage As String)";
 //BA.debugLineNum = 72;BA.debugLine="extractedString = SecretMessage";
_extractedstring = _secretmessage;
 //BA.debugLineNum = 73;BA.debugLine="extractionSuccessful = True";
_extractionsuccessful = __c.True;
 //BA.debugLineNum = 74;BA.debugLine="lastErrorMessage = \"Success: Extraction completed";
_lasterrormessage = "Success: Extraction completed successfully!";
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _text_embedded(String _outfilename) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub text_Embedded(OutFileName As String)";
 //BA.debugLineNum = 35;BA.debugLine="Try";
try { //BA.debugLineNum = 37;BA.debugLine="File.Copy(OutFileName,\"\",config.stegoImagePath,c";
__c.File.Copy(_outfilename,"",_config._stegoimagepath /*String*/ ,_curfilename);
 //BA.debugLineNum = 38;BA.debugLine="embeddingSuccessful =File.Exists(config.stegoIma";
_embeddingsuccessful = __c.File.Exists(_config._stegoimagepath /*String*/ ,_curfilename);
 //BA.debugLineNum = 39;BA.debugLine="lastErrorMessage=\"\"";
_lasterrormessage = "";
 //BA.debugLineNum = 41;BA.debugLine="File.Delete(OutFileName,\"\")";
__c.File.Delete(_outfilename,"");
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 43;BA.debugLine="embeddingSuccessful =False";
_embeddingsuccessful = __c.False;
 //BA.debugLineNum = 44;BA.debugLine="lastErrorMessage=\"Embedding Failed: \" & LastExce";
_lasterrormessage = "Embedding Failed: "+__c.LastException(getActivityBA()).getMessage();
 //BA.debugLineNum = 45;BA.debugLine="ToastMessageShow(\"Embedding Failed: \" & LastExce";
__c.ToastMessageShow(BA.ObjectToCharSequence("Embedding Failed: "+__c.LastException(getActivityBA()).getMessage()),__c.True);
 };
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
