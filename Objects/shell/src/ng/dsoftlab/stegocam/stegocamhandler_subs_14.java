package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class stegocamhandler_subs_14 {


public static RemoteObject  _bytestofile(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("BytesToFile (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,209);
if (RapidSub.canDelegate("bytestofile")) { return __ref.runUserSub(false, "stegocamhandler","bytestofile", __ref, _dir, _filename, _data);}
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
Debug.locals.put("Data", _data);
 BA.debugLineNum = 209;BA.debugLine="Sub BytesToFile (Dir As String, FileName As String";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir, Fi";
Debug.ShouldStop(131072);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = stegocamhandler.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(_dir),(Object)(_filename),(Object)(stegocamhandler.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 211;BA.debugLine="out.WriteBytes(Data, 0, Data.Length)";
Debug.ShouldStop(262144);
_out.runVoidMethod ("WriteBytes",(Object)(_data),(Object)(BA.numberCast(int.class, 0)),(Object)(_data.getField(true,"length")));
 BA.debugLineNum = 212;BA.debugLine="out.Close";
Debug.ShouldStop(524288);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private steg As F5Steg";
stegocamhandler._steg = RemoteObject.createNew ("b4a.flm.f5steg.F5Steg");__ref.setField("_steg",stegocamhandler._steg);
 //BA.debugLineNum = 3;BA.debugLine="Private stegoCamBytes() As Byte = \"STEGOCAM_\".Get";
stegocamhandler._stegocambytes = RemoteObject.createImmutable("STEGOCAM_").runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));__ref.setField("_stegocambytes",stegocamhandler._stegocambytes);
 //BA.debugLineNum = 4;BA.debugLine="Private str As StringUtils";
stegocamhandler._str = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");__ref.setField("_str",stegocamhandler._str);
 //BA.debugLineNum = 5;BA.debugLine="Public curFilename As String";
stegocamhandler._curfilename = RemoteObject.createImmutable("");__ref.setField("_curfilename",stegocamhandler._curfilename);
 //BA.debugLineNum = 6;BA.debugLine="Public embeddingSuccessful As Boolean=False";
stegocamhandler._embeddingsuccessful = stegocamhandler.__c.getField(true,"False");__ref.setField("_embeddingsuccessful",stegocamhandler._embeddingsuccessful);
 //BA.debugLineNum = 7;BA.debugLine="Public lastErrorMessage As String = \"\"";
stegocamhandler._lasterrormessage = BA.ObjectToString("");__ref.setField("_lasterrormessage",stegocamhandler._lasterrormessage);
 //BA.debugLineNum = 8;BA.debugLine="Public file_extension As String = \"\"";
stegocamhandler._file_extension = BA.ObjectToString("");__ref.setField("_file_extension",stegocamhandler._file_extension);
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _combinebytes(RemoteObject __ref,RemoteObject _arr1,RemoteObject _arr2) throws Exception{
try {
		Debug.PushSubsStack("CombineBytes (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,152);
if (RapidSub.canDelegate("combinebytes")) { return __ref.runUserSub(false, "stegocamhandler","combinebytes", __ref, _arr1, _arr2);}
RemoteObject _res = null;
RemoteObject _bc = RemoteObject.declareNull("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");
Debug.locals.put("arr1", _arr1);
Debug.locals.put("arr2", _arr2);
 BA.debugLineNum = 152;BA.debugLine="Sub CombineBytes(arr1() As Byte, arr2() As Byte) A";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="Dim res(arr1.Length + arr2.Length) As Byte";
Debug.ShouldStop(16777216);
_res = RemoteObject.createNewArray ("byte", new int[] {RemoteObject.solve(new RemoteObject[] {_arr1.getField(true,"length"),_arr2.getField(true,"length")}, "+",1, 1).<Integer>get().intValue()}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 154;BA.debugLine="Dim bc As ByteConverter 'ByteConverter library";
Debug.ShouldStop(33554432);
_bc = RemoteObject.createNew ("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");Debug.locals.put("bc", _bc);
 BA.debugLineNum = 155;BA.debugLine="bc.ArrayCopy(arr1, 0, res, 0, arr1.Length)";
Debug.ShouldStop(67108864);
_bc.runVoidMethod ("ArrayCopy",(Object)((_arr1)),(Object)(BA.numberCast(int.class, 0)),(Object)((_res)),(Object)(BA.numberCast(int.class, 0)),(Object)(_arr1.getField(true,"length")));
 BA.debugLineNum = 156;BA.debugLine="bc.ArrayCopy(arr2, 0, res, arr1.Length, arr2.Leng";
Debug.ShouldStop(134217728);
_bc.runVoidMethod ("ArrayCopy",(Object)((_arr2)),(Object)(BA.numberCast(int.class, 0)),(Object)((_res)),(Object)(_arr1.getField(true,"length")),(Object)(_arr2.getField(true,"length")));
 BA.debugLineNum = 157;BA.debugLine="Return res";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return _res;
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _copyfiletotemp(RemoteObject __ref,RemoteObject _cfilename) throws Exception{
try {
		Debug.PushSubsStack("copyFiletoTemp (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,100);
if (RapidSub.canDelegate("copyfiletotemp")) { return __ref.runUserSub(false, "stegocamhandler","copyfiletotemp", __ref, _cfilename);}
RemoteObject _returnfilepath = RemoteObject.createImmutable("");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _inp = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
RemoteObject _ofilename = RemoteObject.createImmutable("");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("cfilename", _cfilename);
 BA.debugLineNum = 100;BA.debugLine="Sub copyFiletoTemp(cfilename As String) As String";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="Dim returnFilePath As String =\"\"";
Debug.ShouldStop(16);
_returnfilepath = BA.ObjectToString("");Debug.locals.put("returnFilePath", _returnfilepath);Debug.locals.put("returnFilePath", _returnfilepath);
 BA.debugLineNum = 102;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 103;BA.debugLine="Msgbox(cfilename,\"cfile\")";
Debug.ShouldStop(64);
stegocamhandler.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(_cfilename)),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("cfile"))),__ref.runMethod(false,"getActivityBA"));
 BA.debugLineNum = 104;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(128);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 105;BA.debugLine="Dim Inp As InputStream  = GetStreamFromContentRe";
Debug.ShouldStop(256);
_inp = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
_inp = __ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_getstreamfromcontentresult" /*RemoteObject*/ ,(Object)(_cfilename));Debug.locals.put("Inp", _inp);Debug.locals.put("Inp", _inp);
 BA.debugLineNum = 106;BA.debugLine="Dim ofilename As String = \"stegofile.\" & file_ex";
Debug.ShouldStop(512);
_ofilename = RemoteObject.concat(RemoteObject.createImmutable("stegofile."),__ref.getField(true,"_file_extension" /*RemoteObject*/ ));Debug.locals.put("ofilename", _ofilename);Debug.locals.put("ofilename", _ofilename);
 BA.debugLineNum = 107;BA.debugLine="Dim Out As OutputStream = File.OpenOutput(File.D";
Debug.ShouldStop(1024);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = stegocamhandler.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(_ofilename),(Object)(stegocamhandler.__c.getField(true,"False")));Debug.locals.put("Out", _out);Debug.locals.put("Out", _out);
 BA.debugLineNum = 108;BA.debugLine="File.copy2(Inp, Out)";
Debug.ShouldStop(2048);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((_inp.getObject())),(Object)((_out.getObject())));
 BA.debugLineNum = 109;BA.debugLine="Inp.Close";
Debug.ShouldStop(4096);
_inp.runVoidMethod ("Close");
 BA.debugLineNum = 110;BA.debugLine="Out.Close";
Debug.ShouldStop(8192);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 111;BA.debugLine="returnFilePath=File.combine(File.DirInternalCach";
Debug.ShouldStop(16384);
_returnfilepath = stegocamhandler.__c.getField(false,"File").runMethod(true,"Combine",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(_ofilename));Debug.locals.put("returnFilePath", _returnfilepath);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e13.toString()); BA.debugLineNum = 113;BA.debugLine="returnFilePath=\"\"";
Debug.ShouldStop(65536);
_returnfilepath = BA.ObjectToString("");Debug.locals.put("returnFilePath", _returnfilepath);
 BA.debugLineNum = 114;BA.debugLine="Msgbox(LastException.Message,\"\")";
Debug.ShouldStop(131072);
stegocamhandler.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")).runMethod(true,"getMessage"))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))),__ref.runMethod(false,"getActivityBA"));
 BA.debugLineNum = 115;BA.debugLine="Log(\":: issue \" & LastException)";
Debug.ShouldStop(262144);
stegocamhandler.__c.runVoidMethod ("LogImpl","767043343",RemoteObject.concat(RemoteObject.createImmutable(":: issue "),stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA"))),0);
 };
 BA.debugLineNum = 117;BA.debugLine="return returnFilePath";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return _returnfilepath;
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtempcoverimage(RemoteObject __ref,RemoteObject _img) throws Exception{
try {
		Debug.PushSubsStack("createTempCoverImage (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,172);
if (RapidSub.canDelegate("createtempcoverimage")) { return __ref.runUserSub(false, "stegocamhandler","createtempcoverimage", __ref, _img);}
RemoteObject _bitmap1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("img", _img);
 BA.debugLineNum = 172;BA.debugLine="Sub createTempCoverImage(img As ImageView)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 174;BA.debugLine="Dim Bitmap1 As Bitmap = img.Bitmap";
Debug.ShouldStop(8192);
_bitmap1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bitmap1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _img.runMethod(false,"getBitmap"));Debug.locals.put("Bitmap1", _bitmap1);Debug.locals.put("Bitmap1", _bitmap1);
 BA.debugLineNum = 175;BA.debugLine="Dim Out As OutputStream";
Debug.ShouldStop(16384);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("Out", _out);
 BA.debugLineNum = 177;BA.debugLine="Out = File.OpenOutput(File.DirInternalCache, \"st";
Debug.ShouldStop(65536);
_out = stegocamhandler.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(BA.ObjectToString("stegocover.png")),(Object)(stegocamhandler.__c.getField(true,"False")));Debug.locals.put("Out", _out);
 BA.debugLineNum = 178;BA.debugLine="Bitmap1.WriteToStream(Out, 100, \"PNG\")";
Debug.ShouldStop(131072);
_bitmap1.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("PNG"))));
 BA.debugLineNum = 179;BA.debugLine="Out.Close";
Debug.ShouldStop(262144);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deletetempresources(RemoteObject __ref,RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("deleteTempResources (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,203);
if (RapidSub.canDelegate("deletetempresources")) { return __ref.runUserSub(false, "stegocamhandler","deletetempresources", __ref, _res);}
Debug.locals.put("res", _res);
 BA.debugLineNum = 203;BA.debugLine="Sub deleteTempResources(res As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 204;BA.debugLine="If res =\"stegocover\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_res,BA.ObjectToString("stegocover"))) { 
 BA.debugLineNum = 205;BA.debugLine="File.Delete(File.DirInternalCache, \"stegocover.p";
Debug.ShouldStop(4096);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(RemoteObject.createImmutable("stegocover.png")));
 };
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _embedfile(RemoteObject __ref,RemoteObject _secretfile,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("EmbedFile (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("embedfile")) { return __ref.runUserSub(false, "stegocamhandler","embedfile", __ref, _secretfile, _password);}
RemoteObject _stegofilepath = RemoteObject.createImmutable("");
RemoteObject _imagefilepath = RemoteObject.createImmutable("");
RemoteObject _outputfilepath = RemoteObject.createImmutable("");
Debug.locals.put("SecretFile", _secretfile);
Debug.locals.put("Password", _password);
 BA.debugLineNum = 62;BA.debugLine="Sub EmbedFile(SecretFile As String,Password As Str";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 64;BA.debugLine="embeddingSuccessful=False";
Debug.ShouldStop(-2147483648);
__ref.setField ("_embeddingsuccessful" /*RemoteObject*/ ,stegocamhandler.__c.getField(true,"False"));
 BA.debugLineNum = 65;BA.debugLine="Dim stegoFilePath As String = copyFiletoTemp(Sec";
Debug.ShouldStop(1);
_stegofilepath = __ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_copyfiletotemp" /*RemoteObject*/ ,(Object)(_secretfile));Debug.locals.put("stegoFilePath", _stegofilepath);Debug.locals.put("stegoFilePath", _stegofilepath);
 BA.debugLineNum = 67;BA.debugLine="Msgbox(file_extension,\"extension\")";
Debug.ShouldStop(4);
stegocamhandler.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(__ref.getField(true,"_file_extension" /*RemoteObject*/ ))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("extension"))),__ref.runMethod(false,"getActivityBA"));
 BA.debugLineNum = 69;BA.debugLine="Msgbox(SecretFile,\"secret file\")";
Debug.ShouldStop(16);
stegocamhandler.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(_secretfile)),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("secret file"))),__ref.runMethod(false,"getActivityBA"));
 BA.debugLineNum = 70;BA.debugLine="Msgbox(File.Exists(stegoFilePath,\"\"),\"secret mes";
Debug.ShouldStop(32);
stegocamhandler.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(stegocamhandler.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_stegofilepath),(Object)(RemoteObject.createImmutable(""))))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("secret message"))),__ref.runMethod(false,"getActivityBA"));
 BA.debugLineNum = 72;BA.debugLine="Dim imageFilePath As String  = File.Combine(File";
Debug.ShouldStop(128);
_imagefilepath = stegocamhandler.__c.getField(false,"File").runMethod(true,"Combine",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(RemoteObject.createImmutable("stegocover.png")));Debug.locals.put("imageFilePath", _imagefilepath);Debug.locals.put("imageFilePath", _imagefilepath);
 BA.debugLineNum = 73;BA.debugLine="Dim outputFilePath  As String = File.Combine(Fil";
Debug.ShouldStop(256);
_outputfilepath = stegocamhandler.__c.getField(false,"File").runMethod(true,"Combine",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(__ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_generatefilename" /*RemoteObject*/ )));Debug.locals.put("outputFilePath", _outputfilepath);Debug.locals.put("outputFilePath", _outputfilepath);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e10) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e10.toString()); BA.debugLineNum = 76;BA.debugLine="Msgbox(LastException.Message,\"\")";
Debug.ShouldStop(2048);
stegocamhandler.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")).runMethod(true,"getMessage"))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))),__ref.runMethod(false,"getActivityBA"));
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _embedtext(RemoteObject __ref,RemoteObject _secrettext,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("EmbedText (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("embedtext")) { return __ref.runUserSub(false, "stegocamhandler","embedtext", __ref, _secrettext, _password);}
RemoteObject _imagefilepath = RemoteObject.createImmutable("");
RemoteObject _outputfilepath = RemoteObject.createImmutable("");
Debug.locals.put("secretText", _secrettext);
Debug.locals.put("password", _password);
 BA.debugLineNum = 24;BA.debugLine="public Sub EmbedText(secretText As String, passwor";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="embeddingSuccessful=False";
Debug.ShouldStop(16777216);
__ref.setField ("_embeddingsuccessful" /*RemoteObject*/ ,stegocamhandler.__c.getField(true,"False"));
 BA.debugLineNum = 26;BA.debugLine="Dim imageFilePath As String  = File.Combine(File.";
Debug.ShouldStop(33554432);
_imagefilepath = stegocamhandler.__c.getField(false,"File").runMethod(true,"Combine",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(RemoteObject.createImmutable("stegocover.png")));Debug.locals.put("imageFilePath", _imagefilepath);Debug.locals.put("imageFilePath", _imagefilepath);
 BA.debugLineNum = 27;BA.debugLine="Dim outputFilePath  As String = File.Combine(File";
Debug.ShouldStop(67108864);
_outputfilepath = stegocamhandler.__c.getField(false,"File").runMethod(true,"Combine",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(__ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_generatefilename" /*RemoteObject*/ )));Debug.locals.put("outputFilePath", _outputfilepath);Debug.locals.put("outputFilePath", _outputfilepath);
 BA.debugLineNum = 28;BA.debugLine="steg.EmbedString2(imageFilePath, outputFilePath,";
Debug.ShouldStop(134217728);
__ref.getField(false,"_steg" /*RemoteObject*/ ).runVoidMethod ("EmbedString2",__ref.getField(false, "ba"),(Object)(_imagefilepath),(Object)(_outputfilepath),(Object)(_secrettext),(Object)(BA.numberCast(int.class, 100)),(Object)(_password),(Object)(RemoteObject.createImmutable("text")));
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _extracttextwithpassword(RemoteObject __ref,RemoteObject _imagefilepath,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("ExtractTextWithPassword (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,162);
if (RapidSub.canDelegate("extracttextwithpassword")) { return __ref.runUserSub(false, "stegocamhandler","extracttextwithpassword", __ref, _imagefilepath, _password);}
Debug.locals.put("imageFilePath", _imagefilepath);
Debug.locals.put("password", _password);
 BA.debugLineNum = 162;BA.debugLine="Public Sub ExtractTextWithPassword(imageFilePath A";
Debug.ShouldStop(2);
 BA.debugLineNum = 164;BA.debugLine="steg.ExtractToString2(imageFilePath, password, \"s";
Debug.ShouldStop(8);
__ref.getField(false,"_steg" /*RemoteObject*/ ).runVoidMethod ("ExtractToString2",__ref.getField(false, "ba"),(Object)(_imagefilepath),(Object)(_password),(Object)(RemoteObject.createImmutable("steg")));
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _file_embedded(RemoteObject __ref,RemoteObject _outfilename) throws Exception{
try {
		Debug.PushSubsStack("file_Embedded (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,120);
if (RapidSub.canDelegate("file_embedded")) { return __ref.runUserSub(false, "stegocamhandler","file_embedded", __ref, _outfilename);}
RemoteObject _imagebytes = null;
RemoteObject _textstr = RemoteObject.createImmutable("");
RemoteObject _textbytes = null;
RemoteObject _modifiedbytes = null;
RemoteObject _newimagebytes = null;
Debug.locals.put("OutFileName", _outfilename);
 BA.debugLineNum = 120;BA.debugLine="Sub file_Embedded(OutFileName As String)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 123;BA.debugLine="Dim imageBytes() As Byte = File.ReadBytes(OutFil";
Debug.ShouldStop(67108864);
_imagebytes = stegocamhandler.__c.getField(false,"File").runMethod(false,"ReadBytes",(Object)(_outfilename),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("imageBytes", _imagebytes);Debug.locals.put("imageBytes", _imagebytes);
 BA.debugLineNum = 125;BA.debugLine="Dim textStr As String = \"FILE_\" & file_extension";
Debug.ShouldStop(268435456);
_textstr = RemoteObject.concat(RemoteObject.createImmutable("FILE_"),__ref.getField(true,"_file_extension" /*RemoteObject*/ ));Debug.locals.put("textStr", _textstr);Debug.locals.put("textStr", _textstr);
 BA.debugLineNum = 128;BA.debugLine="Dim textBytes() As Byte = textStr.GetBytes(\"UTF8";
Debug.ShouldStop(-2147483648);
_textbytes = _textstr.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("textBytes", _textbytes);Debug.locals.put("textBytes", _textbytes);
 BA.debugLineNum = 131;BA.debugLine="Dim modifiedBytes() As Byte =CombineBytes(stegoC";
Debug.ShouldStop(4);
_modifiedbytes = __ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_combinebytes" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_stegocambytes" /*RemoteObject*/ )),(Object)(_textbytes));Debug.locals.put("modifiedBytes", _modifiedbytes);Debug.locals.put("modifiedBytes", _modifiedbytes);
 BA.debugLineNum = 134;BA.debugLine="Dim newImageBytes() As Byte = CombineBytes(image";
Debug.ShouldStop(32);
_newimagebytes = __ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_combinebytes" /*RemoteObject*/ ,(Object)(_imagebytes),(Object)(_modifiedbytes));Debug.locals.put("newImageBytes", _newimagebytes);Debug.locals.put("newImageBytes", _newimagebytes);
 BA.debugLineNum = 137;BA.debugLine="File.WriteBytes(OutFileName,\"\", newImageBytes)";
Debug.ShouldStop(256);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("WriteBytes",(Object)(_outfilename),(Object)(BA.ObjectToString("")),(Object)(_newimagebytes));
 BA.debugLineNum = 140;BA.debugLine="File.Copy(OutFileName,\"\",config.stegoImagePath,c";
Debug.ShouldStop(2048);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_outfilename),(Object)(BA.ObjectToString("")),(Object)(stegocamhandler._config._stegoimagepath /*RemoteObject*/ ),(Object)(__ref.getField(true,"_curfilename" /*RemoteObject*/ )));
 BA.debugLineNum = 141;BA.debugLine="embeddingSuccessful =File.Exists(config.stegoIma";
Debug.ShouldStop(4096);
__ref.setField ("_embeddingsuccessful" /*RemoteObject*/ ,stegocamhandler.__c.getField(false,"File").runMethod(true,"Exists",(Object)(stegocamhandler._config._stegoimagepath /*RemoteObject*/ ),(Object)(__ref.getField(true,"_curfilename" /*RemoteObject*/ ))));
 BA.debugLineNum = 142;BA.debugLine="lastErrorMessage=\"\"";
Debug.ShouldStop(8192);
__ref.setField ("_lasterrormessage" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 144;BA.debugLine="File.Delete(OutFileName,\"\")";
Debug.ShouldStop(32768);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(_outfilename),(Object)(RemoteObject.createImmutable("")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e13.toString()); BA.debugLineNum = 146;BA.debugLine="embeddingSuccessful =False";
Debug.ShouldStop(131072);
__ref.setField ("_embeddingsuccessful" /*RemoteObject*/ ,stegocamhandler.__c.getField(true,"False"));
 BA.debugLineNum = 147;BA.debugLine="lastErrorMessage=\"Embedding Failed: \" & LastExce";
Debug.ShouldStop(262144);
__ref.setField ("_lasterrormessage" /*RemoteObject*/ ,RemoteObject.concat(RemoteObject.createImmutable("Embedding Failed: "),stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")).runMethod(true,"getMessage")));
 BA.debugLineNum = 148;BA.debugLine="ToastMessageShow(\"Embedding Failed: \" & LastExce";
Debug.ShouldStop(524288);
stegocamhandler.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Embedding Failed: "),stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")).runMethod(true,"getMessage")))),(Object)(stegocamhandler.__c.getField(true,"True")));
 };
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _filetobytes(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("FileToBytes (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,215);
if (RapidSub.canDelegate("filetobytes")) { return __ref.runUserSub(false, "stegocamhandler","filetobytes", __ref, _dir, _filename);}
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 215;BA.debugLine="Sub FileToBytes (Dir As String, FileName As String";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 216;BA.debugLine="Return Bit.InputStreamToBytes(File.OpenInput(Dir,";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return stegocamhandler.__c.getField(false,"Bit").runMethod(false,"InputStreamToBytes",(Object)((stegocamhandler.__c.getField(false,"File").runMethod(false,"OpenInput",(Object)(_dir),(Object)(_filename)).getObject())));
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generatefilename(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GenerateFilename (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,15);
if (RapidSub.canDelegate("generatefilename")) { return __ref.runUserSub(false, "stegocamhandler","generatefilename", __ref);}
RemoteObject _timestamp = RemoteObject.createImmutable(0L);
RemoteObject _filename = RemoteObject.createImmutable("");
 BA.debugLineNum = 15;BA.debugLine="Sub GenerateFilename() As String";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="Dim timestamp As Long = DateTime.Now";
Debug.ShouldStop(32768);
_timestamp = stegocamhandler.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("timestamp", _timestamp);Debug.locals.put("timestamp", _timestamp);
 BA.debugLineNum = 17;BA.debugLine="Dim filename As String = \"IMG_\" & timestamp &";
Debug.ShouldStop(65536);
_filename = RemoteObject.concat(RemoteObject.createImmutable("IMG_"),_timestamp,RemoteObject.createImmutable(".jpg"));Debug.locals.put("filename", _filename);Debug.locals.put("filename", _filename);
 BA.debugLineNum = 18;BA.debugLine="curFilename=filename";
Debug.ShouldStop(131072);
__ref.setField ("_curfilename" /*RemoteObject*/ ,_filename);
 BA.debugLineNum = 19;BA.debugLine="Return filename";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return _filename;
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getstreamfromcontentresult(RemoteObject __ref,RemoteObject _uristring) throws Exception{
try {
		Debug.PushSubsStack("GetStreamFromContentResult (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,82);
if (RapidSub.canDelegate("getstreamfromcontentresult")) { return __ref.runUserSub(false, "stegocamhandler","getstreamfromcontentresult", __ref, _uristring);}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _uri = RemoteObject.declareNull("Object");
RemoteObject _istream = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
Debug.locals.put("UriString", _uristring);
 BA.debugLineNum = 82;BA.debugLine="Sub GetStreamFromContentResult(UriString As String";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(262144);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 84;BA.debugLine="Dim Uri As Object";
Debug.ShouldStop(524288);
_uri = RemoteObject.createNew ("Object");Debug.locals.put("Uri", _uri);
 BA.debugLineNum = 85;BA.debugLine="Dim iStream As InputStream";
Debug.ShouldStop(1048576);
_istream = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("iStream", _istream);
 BA.debugLineNum = 86;BA.debugLine="Uri = r.RunStaticMethod(\"android.net.Uri\", \"parse";
Debug.ShouldStop(2097152);
_uri = _r.runMethod(false,"RunStaticMethod",(Object)(BA.ObjectToString("android.net.Uri")),(Object)(BA.ObjectToString("parse")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_uristring)})),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("java.lang.String")})));Debug.locals.put("Uri", _uri);
 BA.debugLineNum = 87;BA.debugLine="r.Target = r.GetContext";
Debug.ShouldStop(4194304);
_r.setField ("Target",(_r.runMethod(false,"GetContext",__ref.getField(false, "ba"))));
 BA.debugLineNum = 88;BA.debugLine="r.Target = r.RunMethod(\"getContentResolver\")";
Debug.ShouldStop(8388608);
_r.setField ("Target",_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getContentResolver"))));
 BA.debugLineNum = 89;BA.debugLine="iStream = r.RunMethod4( \"openInputStream\", Array";
Debug.ShouldStop(16777216);
_istream = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper"), _r.runMethod(false,"RunMethod4",(Object)(BA.ObjectToString("openInputStream")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_uri})),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("android.net.Uri")}))));Debug.locals.put("iStream", _istream);
 BA.debugLineNum = 97;BA.debugLine="Return iStream";
Debug.ShouldStop(1);
Debug.CheckDeviceExceptions();if (true) return _istream;
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Initialize (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,12);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "stegocamhandler","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 12;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(2048);
 BA.debugLineNum = 13;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _iscoverimage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("isCoverImage (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,197);
if (RapidSub.canDelegate("iscoverimage")) { return __ref.runUserSub(false, "stegocamhandler","iscoverimage", __ref);}
 BA.debugLineNum = 197;BA.debugLine="Sub isCoverImage() As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 198;BA.debugLine="Return File.Exists(File.DirInternalCache, \"stegoc";
Debug.ShouldStop(32);
Debug.CheckDeviceExceptions();if (true) return stegocamhandler.__c.getField(false,"File").runMethod(true,"Exists",(Object)(stegocamhandler.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(RemoteObject.createImmutable("stegocover.png")));
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _steg_stringextracted(RemoteObject __ref,RemoteObject _secretmessage) throws Exception{
try {
		Debug.PushSubsStack("steg_StringExtracted (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,167);
if (RapidSub.canDelegate("steg_stringextracted")) { return __ref.runUserSub(false, "stegocamhandler","steg_stringextracted", __ref, _secretmessage);}
Debug.locals.put("SecretMessage", _secretmessage);
 BA.debugLineNum = 167;BA.debugLine="Sub steg_StringExtracted(SecretMessage As String)";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="Log(\"Extracted Text: \" & SecretMessage)";
Debug.ShouldStop(128);
stegocamhandler.__c.runVoidMethod ("LogImpl","749807361",RemoteObject.concat(RemoteObject.createImmutable("Extracted Text: "),_secretmessage),0);
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _text_embedded(RemoteObject __ref,RemoteObject _outfilename) throws Exception{
try {
		Debug.PushSubsStack("text_Embedded (stegocamhandler) ","stegocamhandler",8,__ref.getField(false, "ba"),__ref,31);
if (RapidSub.canDelegate("text_embedded")) { return __ref.runUserSub(false, "stegocamhandler","text_embedded", __ref, _outfilename);}
RemoteObject _imagebytes = null;
RemoteObject _textbytes = null;
RemoteObject _modifiedbytes = null;
RemoteObject _newimagebytes = null;
Debug.locals.put("OutFileName", _outfilename);
 BA.debugLineNum = 31;BA.debugLine="Sub text_Embedded(OutFileName As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 34;BA.debugLine="Dim imageBytes() As Byte = File.ReadBytes(OutFil";
Debug.ShouldStop(2);
_imagebytes = stegocamhandler.__c.getField(false,"File").runMethod(false,"ReadBytes",(Object)(_outfilename),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("imageBytes", _imagebytes);Debug.locals.put("imageBytes", _imagebytes);
 BA.debugLineNum = 37;BA.debugLine="Dim textBytes() As Byte = \"TEXT\".GetBytes(\"UTF8\"";
Debug.ShouldStop(16);
_textbytes = RemoteObject.createImmutable("TEXT").runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("textBytes", _textbytes);Debug.locals.put("textBytes", _textbytes);
 BA.debugLineNum = 40;BA.debugLine="Dim modifiedBytes() As Byte =CombineBytes(stegoC";
Debug.ShouldStop(128);
_modifiedbytes = __ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_combinebytes" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_stegocambytes" /*RemoteObject*/ )),(Object)(_textbytes));Debug.locals.put("modifiedBytes", _modifiedbytes);Debug.locals.put("modifiedBytes", _modifiedbytes);
 BA.debugLineNum = 43;BA.debugLine="Dim newImageBytes() As Byte = CombineBytes(image";
Debug.ShouldStop(1024);
_newimagebytes = __ref.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_combinebytes" /*RemoteObject*/ ,(Object)(_imagebytes),(Object)(_modifiedbytes));Debug.locals.put("newImageBytes", _newimagebytes);Debug.locals.put("newImageBytes", _newimagebytes);
 BA.debugLineNum = 46;BA.debugLine="File.WriteBytes(OutFileName,\"\", newImageBytes)";
Debug.ShouldStop(8192);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("WriteBytes",(Object)(_outfilename),(Object)(BA.ObjectToString("")),(Object)(_newimagebytes));
 BA.debugLineNum = 49;BA.debugLine="File.Copy(OutFileName,\"\",config.stegoImagePath,c";
Debug.ShouldStop(65536);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_outfilename),(Object)(BA.ObjectToString("")),(Object)(stegocamhandler._config._stegoimagepath /*RemoteObject*/ ),(Object)(__ref.getField(true,"_curfilename" /*RemoteObject*/ )));
 BA.debugLineNum = 50;BA.debugLine="embeddingSuccessful =File.Exists(config.stegoIma";
Debug.ShouldStop(131072);
__ref.setField ("_embeddingsuccessful" /*RemoteObject*/ ,stegocamhandler.__c.getField(false,"File").runMethod(true,"Exists",(Object)(stegocamhandler._config._stegoimagepath /*RemoteObject*/ ),(Object)(__ref.getField(true,"_curfilename" /*RemoteObject*/ ))));
 BA.debugLineNum = 51;BA.debugLine="lastErrorMessage=\"\"";
Debug.ShouldStop(262144);
__ref.setField ("_lasterrormessage" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 53;BA.debugLine="File.Delete(OutFileName,\"\")";
Debug.ShouldStop(1048576);
stegocamhandler.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(_outfilename),(Object)(RemoteObject.createImmutable("")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e12.toString()); BA.debugLineNum = 55;BA.debugLine="embeddingSuccessful =False";
Debug.ShouldStop(4194304);
__ref.setField ("_embeddingsuccessful" /*RemoteObject*/ ,stegocamhandler.__c.getField(true,"False"));
 BA.debugLineNum = 56;BA.debugLine="lastErrorMessage=\"Embedding Failed: \" & LastExce";
Debug.ShouldStop(8388608);
__ref.setField ("_lasterrormessage" /*RemoteObject*/ ,RemoteObject.concat(RemoteObject.createImmutable("Embedding Failed: "),stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")).runMethod(true,"getMessage")));
 BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"Embedding Failed: \" & LastExce";
Debug.ShouldStop(16777216);
stegocamhandler.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Embedding Failed: "),stegocamhandler.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")).runMethod(true,"getMessage")))),(Object)(stegocamhandler.__c.getField(true,"True")));
 };
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}