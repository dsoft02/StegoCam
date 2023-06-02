package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class encode_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,65);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 65;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 67;BA.debugLine="Activity.LoadLayout(\"encode\")";
Debug.ShouldStop(4);
encode.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("encode")),encode.mostCurrent.activityBA);
 BA.debugLineNum = 68;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(8);
encode.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 69;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(16);
encode.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",encode.mostCurrent.activityBA);
 BA.debugLineNum = 70;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(32);
encode.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",encode.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 71;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(64);
encode.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 72;BA.debugLine="clearForm";
Debug.ShouldStop(128);
_clearform();
 BA.debugLineNum = 73;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
Debug.ShouldStop(256);
if (encode._lastpicture.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
encode.mostCurrent._imgcover.runMethod(false,"setBitmap",(encode._lastpicture.getObject()));};
 BA.debugLineNum = 74;BA.debugLine="FileHandler1.Initialize";
Debug.ShouldStop(512);
encode._filehandler1.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_initialize" /*RemoteObject*/ ,encode.processBA);
 BA.debugLineNum = 75;BA.debugLine="stegoHandler.Initialize";
Debug.ShouldStop(1024);
encode._stegohandler.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_initialize" /*RemoteObject*/ ,encode.processBA);
 BA.debugLineNum = 76;BA.debugLine="Dialog.Initialize(Activity)";
Debug.ShouldStop(2048);
encode.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_initialize" /*RemoteObject*/ ,encode.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), encode.mostCurrent._activity.getObject()));
 BA.debugLineNum = 77;BA.debugLine="Dialog.Title = \"Stego Image View\"";
Debug.ShouldStop(4096);
encode.mostCurrent._dialog.setField ("_title" /*RemoteObject*/ ,RemoteObject.createImmutable(("Stego Image View")));
 BA.debugLineNum = 78;BA.debugLine="getPermissions";
Debug.ShouldStop(8192);
_getpermissions();
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,94);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 94;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, encode.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 96;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(-2147483648);
encode.mostCurrent.__c.runVoidMethod ("StartActivity",encode.processBA,(Object)((encode.mostCurrent._mainmenu.getObject())));
 BA.debugLineNum = 97;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
encode.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 98;BA.debugLine="Return True";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return encode.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 100;BA.debugLine="Return False";
Debug.ShouldStop(8);
Debug.CheckDeviceExceptions();if (true) return encode.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,85);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 85;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,81);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","activity_resume");}
 BA.debugLineNum = 81;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _actoolbarlight1_navigationitemclick() throws Exception{
try {
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,89);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 89;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(33554432);
encode.mostCurrent.__c.runVoidMethod ("StartActivity",encode.processBA,(Object)((encode.mostCurrent._mainmenu.getObject())));
 BA.debugLineNum = 91;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
encode.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _browsecoverimage() throws Exception{
try {
		Debug.PushSubsStack("BrowseCoverImage (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,291);
if (RapidSub.canDelegate("browsecoverimage")) { ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","browsecoverimage"); return;}
ResumableSub_BrowseCoverImage rsub = new ResumableSub_BrowseCoverImage(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_BrowseCoverImage extends BA.ResumableSub {
public ResumableSub_BrowseCoverImage(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.encode parent;
RemoteObject _result = RemoteObject.declareNull("ng.dsoftlab.stegocam.filehandler._loadresult");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("BrowseCoverImage (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,291);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 292;BA.debugLine="Dim xui As XUI";
Debug.ShouldStop(8);
parent.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 BA.debugLineNum = 293;BA.debugLine="Wait For (FileHandler1.LoadCoverImage) Complete (";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", encode.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "encode", "browsecoverimage"), parent._filehandler1.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_loadcoverimage" /*RemoteObject*/ ));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 294;BA.debugLine="If Result.Success Then";
Debug.ShouldStop(32);
if (true) break;

case 1:
//if
this.state = 10;
if (_result.getField(true,"Success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 295;BA.debugLine="Try";
Debug.ShouldStop(64);
if (true) break;

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
 BA.debugLineNum = 297;BA.debugLine="imgCover.Bitmap =xui.LoadBitmapResize(Result.Di";
Debug.ShouldStop(256);
parent.mostCurrent._imgcover.runMethod(false,"setBitmap",(parent.mostCurrent._xui.runMethod(false,"LoadBitmapResize",(Object)(_result.getField(true,"Dir" /*RemoteObject*/ )),(Object)(_result.getField(true,"FileName" /*RemoteObject*/ )),(Object)(parent.mostCurrent._imgcover.runMethod(true,"getWidth")),(Object)(parent.mostCurrent._imgcover.runMethod(true,"getHeight")),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 298;BA.debugLine="imgCover.Tag= GetPathFromContentResult(Result.F";
Debug.ShouldStop(512);
parent.mostCurrent._imgcover.runMethod(false,"setTag",(_getpathfromcontentresult(_result.getField(true,"FileName" /*RemoteObject*/ ))));
 BA.debugLineNum = 299;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(1024);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 301;BA.debugLine="imgCover.Bitmap=Null";
Debug.ShouldStop(4096);
parent.mostCurrent._imgcover.runMethod(false,"setBitmap",(parent.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 302;BA.debugLine="imgCover.Tag=\"\"";
Debug.ShouldStop(8192);
parent.mostCurrent._imgcover.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 303;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","740763404",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA)),0);
 BA.debugLineNum = 304;BA.debugLine="lblErrorMsg.Text=LastException.Message";
Debug.ShouldStop(32768);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA).runMethod(true,"getMessage")));
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",encode.processBA, e0.toString());}
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
public static void  _complete(RemoteObject _result) throws Exception{
}
public static void  _browsefile() throws Exception{
try {
		Debug.PushSubsStack("BrowseFile (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,310);
if (RapidSub.canDelegate("browsefile")) { ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","browsefile"); return;}
ResumableSub_BrowseFile rsub = new ResumableSub_BrowseFile(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_BrowseFile extends BA.ResumableSub {
public ResumableSub_BrowseFile(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.encode parent;
RemoteObject _result = RemoteObject.declareNull("ng.dsoftlab.stegocam.filehandler._loadresult");
RemoteObject _fpath = RemoteObject.createImmutable("");
RemoteObject _fname = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("BrowseFile (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,310);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 311;BA.debugLine="Wait For (FileHandler1.Load) Complete (Result As";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", encode.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "encode", "browsefile"), parent._filehandler1.runClassMethod (ng.dsoftlab.stegocam.filehandler.class, "_load" /*RemoteObject*/ ));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 312;BA.debugLine="If Result.Success Then";
Debug.ShouldStop(8388608);
if (true) break;

case 1:
//if
this.state = 10;
if (_result.getField(true,"Success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 313;BA.debugLine="Dim fpath As String=\"\"";
Debug.ShouldStop(16777216);
_fpath = BA.ObjectToString("");Debug.locals.put("fpath", _fpath);Debug.locals.put("fpath", _fpath);
 BA.debugLineNum = 314;BA.debugLine="Dim fname As String=\"\"";
Debug.ShouldStop(33554432);
_fname = BA.ObjectToString("");Debug.locals.put("fname", _fname);Debug.locals.put("fname", _fname);
 BA.debugLineNum = 315;BA.debugLine="Try";
Debug.ShouldStop(67108864);
if (true) break;

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
 BA.debugLineNum = 316;BA.debugLine="fpath=Result.FileName 'Result.Dir & \"/\" &  GetP";
Debug.ShouldStop(134217728);
_fpath = _result.getField(true,"FileName" /*RemoteObject*/ );Debug.locals.put("fpath", _fpath);
 BA.debugLineNum = 318;BA.debugLine="fname=Result.RealName";
Debug.ShouldStop(536870912);
_fname = _result.getField(true,"RealName" /*RemoteObject*/ );Debug.locals.put("fname", _fname);
 BA.debugLineNum = 319;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(1073741824);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 321;BA.debugLine="fpath=\"\"";
Debug.ShouldStop(1);
_fpath = BA.ObjectToString("");Debug.locals.put("fpath", _fpath);
 BA.debugLineNum = 322;BA.debugLine="fname=\"\"";
Debug.ShouldStop(2);
_fname = BA.ObjectToString("");Debug.locals.put("fname", _fname);
 BA.debugLineNum = 323;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","740828941",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA)),0);
 BA.debugLineNum = 324;BA.debugLine="lblErrorMsg.Text=LastException.Message";
Debug.ShouldStop(8);
parent.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA).runMethod(true,"getMessage")));
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
 BA.debugLineNum = 326;BA.debugLine="txtFilename.Text=fname";
Debug.ShouldStop(32);
parent.mostCurrent._txtfilename.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_fname));
 BA.debugLineNum = 327;BA.debugLine="txtFilename.Tag=fpath";
Debug.ShouldStop(64);
parent.mostCurrent._txtfilename.runMethod(false,"setTag",(_fpath));
 BA.debugLineNum = 328;BA.debugLine="imgCover.Tag=fpath";
Debug.ShouldStop(128);
parent.mostCurrent._imgcover.runMethod(false,"setTag",(_fpath));
 BA.debugLineNum = 329;BA.debugLine="Log(fpath)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","740828947",_fpath,0);
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 331;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",encode.processBA, e0.toString());}
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
public static RemoteObject  _btnbrowse_click() throws Exception{
try {
		Debug.PushSubsStack("btnBrowse_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,385);
if (RapidSub.canDelegate("btnbrowse_click")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","btnbrowse_click");}
 BA.debugLineNum = 385;BA.debugLine="Private Sub btnBrowse_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 386;BA.debugLine="BrowseFile";
Debug.ShouldStop(2);
_browsefile();
 BA.debugLineNum = 387;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncancel_click() throws Exception{
try {
		Debug.PushSubsStack("btnCancel_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,105);
if (RapidSub.canDelegate("btncancel_click")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","btncancel_click");}
 BA.debugLineNum = 105;BA.debugLine="Private Sub btnCancel_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(512);
encode.mostCurrent.__c.runVoidMethod ("StartActivity",encode.processBA,(Object)((encode.mostCurrent._mainmenu.getObject())));
 BA.debugLineNum = 107;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1024);
encode.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnencode_click() throws Exception{
try {
		Debug.PushSubsStack("btnEncode_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,110);
if (RapidSub.canDelegate("btnencode_click")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","btnencode_click");}
 BA.debugLineNum = 110;BA.debugLine="Private Sub btnEncode_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="If imgCover.Bitmap=Null Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("n",encode.mostCurrent._imgcover.runMethod(false,"getBitmap"))) { 
 BA.debugLineNum = 112;BA.debugLine="lblErrorMsg.Text=\"Please select cover Image\"";
Debug.ShouldStop(32768);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please select cover Image"));
 BA.debugLineNum = 113;BA.debugLine="ToastMessageShow(\"Please select cover Image\",Fal";
Debug.ShouldStop(65536);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please select cover Image")),(Object)(encode.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 114;BA.debugLine="Else If rboxEncodeText.Checked And txtMessage.Tex";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(".",encode.mostCurrent._rboxencodetext.runMethod(true,"getChecked")) && RemoteObject.solveBoolean("=",encode.mostCurrent._txtmessage.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 115;BA.debugLine="lblErrorMsg.Text=\"Please enter your secret messa";
Debug.ShouldStop(262144);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter your secret message"));
 BA.debugLineNum = 116;BA.debugLine="ToastMessageShow(\"Please enter your secret messa";
Debug.ShouldStop(524288);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter your secret message")),(Object)(encode.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 117;BA.debugLine="txtMessage.RequestFocus";
Debug.ShouldStop(1048576);
encode.mostCurrent._txtmessage.runVoidMethod ("RequestFocus");
 }else 
{ BA.debugLineNum = 118;BA.debugLine="Else If rboxEncodeFile.Checked And txtFilename.Te";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(".",encode.mostCurrent._rboxencodefile.runMethod(true,"getChecked")) && RemoteObject.solveBoolean("=",encode.mostCurrent._txtfilename.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 119;BA.debugLine="lblErrorMsg.Text=\"Please select your secret file";
Debug.ShouldStop(4194304);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please select your secret file"));
 BA.debugLineNum = 120;BA.debugLine="ToastMessageShow(\"Please select your secret file";
Debug.ShouldStop(8388608);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please select your secret file")),(Object)(encode.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 121;BA.debugLine="BrowseFile";
Debug.ShouldStop(16777216);
_browsefile();
 }else 
{ BA.debugLineNum = 122;BA.debugLine="else if txtKey.Text=\"\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",encode.mostCurrent._txtkey.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 123;BA.debugLine="lblErrorMsg.Text=\"Please enter your encryption k";
Debug.ShouldStop(67108864);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence("Please enter your encryption key"));
 BA.debugLineNum = 124;BA.debugLine="ToastMessageShow(\"Please enter your encryption k";
Debug.ShouldStop(134217728);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter your encryption key")),(Object)(encode.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 125;BA.debugLine="txtKey.RequestFocus";
Debug.ShouldStop(268435456);
encode.mostCurrent._txtkey.runVoidMethod ("RequestFocus");
 }else {
 BA.debugLineNum = 128;BA.debugLine="lblErrorMsg.Text=\"\"";
Debug.ShouldStop(-2147483648);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 129;BA.debugLine="stegoHandler.createTempCoverImage(imgCover)";
Debug.ShouldStop(1);
encode._stegohandler.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_createtempcoverimage" /*RemoteObject*/ ,(Object)(encode.mostCurrent._imgcover));
 BA.debugLineNum = 130;BA.debugLine="If stegoHandler.isCoverImage Then";
Debug.ShouldStop(2);
if (encode._stegohandler.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_iscoverimage" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 131;BA.debugLine="If rboxEncodeText.Checked Then";
Debug.ShouldStop(4);
if (encode.mostCurrent._rboxencodetext.runMethod(true,"getChecked").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 132;BA.debugLine="stegoHandler.EmbedText(txtMessage.Text,txtKey.";
Debug.ShouldStop(8);
encode._stegohandler.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_embedtext" /*RemoteObject*/ ,(Object)(encode.mostCurrent._txtmessage.runMethod(true,"getText")),(Object)(encode.mostCurrent._txtkey.runMethod(true,"getText")));
 BA.debugLineNum = 133;BA.debugLine="If stegoHandler.embeddingSuccessful=True Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",encode._stegohandler.getField(true,"_embeddingsuccessful" /*RemoteObject*/ ),encode.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 134;BA.debugLine="ToastMessageShow(\"Secret has been hidden succ";
Debug.ShouldStop(32);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Secret has been hidden successfully!")),(Object)(encode.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 135;BA.debugLine="showCompleteDialog(File.Combine(config.stegoI";
Debug.ShouldStop(64);
_showcompletedialog(encode.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(encode.mostCurrent._config._stegoimagepath /*RemoteObject*/ ),(Object)(encode._stegohandler.getField(true,"_curfilename" /*RemoteObject*/ ))));
 }else {
 BA.debugLineNum = 137;BA.debugLine="lblErrorMsg.Text=stegoHandler.lastErrorMessag";
Debug.ShouldStop(256);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(encode._stegohandler.getField(true,"_lasterrormessage" /*RemoteObject*/ )));
 };
 }else 
{ BA.debugLineNum = 139;BA.debugLine="Else if rboxEncodeFile.Checked Then";
Debug.ShouldStop(1024);
if (encode.mostCurrent._rboxencodefile.runMethod(true,"getChecked").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 140;BA.debugLine="stegoHandler.EmbedFile(txtFilename.Tag,txtKey.";
Debug.ShouldStop(2048);
encode._stegohandler.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_embedfile" /*RemoteObject*/ ,(Object)(BA.ObjectToString(encode.mostCurrent._txtfilename.runMethod(false,"getTag"))),(Object)(encode.mostCurrent._txtkey.runMethod(true,"getText")));
 BA.debugLineNum = 141;BA.debugLine="If stegoHandler.embeddingSuccessful=True Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",encode._stegohandler.getField(true,"_embeddingsuccessful" /*RemoteObject*/ ),encode.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 142;BA.debugLine="ToastMessageShow(\"Secret File has been hidden";
Debug.ShouldStop(8192);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Secret File has been hidden successfully!")),(Object)(encode.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 143;BA.debugLine="showCompleteDialog(File.Combine(config.stegoI";
Debug.ShouldStop(16384);
_showcompletedialog(encode.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(encode.mostCurrent._config._stegoimagepath /*RemoteObject*/ ),(Object)(encode._stegohandler.getField(true,"_curfilename" /*RemoteObject*/ ))));
 }else {
 BA.debugLineNum = 145;BA.debugLine="lblErrorMsg.Text=stegoHandler.lastErrorMessag";
Debug.ShouldStop(65536);
encode.mostCurrent._lblerrormsg.runMethod(true,"setText",BA.ObjectToCharSequence(encode._stegohandler.getField(true,"_lasterrormessage" /*RemoteObject*/ )));
 };
 }}
;
 }else {
 BA.debugLineNum = 149;BA.debugLine="ToastMessageShow(\"An error has occured please T";
Debug.ShouldStop(1048576);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("An error has occured please Try Again!")),(Object)(encode.mostCurrent.__c.getField(true,"True")));
 };
 }}}}
;
 BA.debugLineNum = 152;BA.debugLine="stegoHandler.deleteTempResources(\"stegocover\")";
Debug.ShouldStop(8388608);
encode._stegohandler.runClassMethod (ng.dsoftlab.stegocam.stegocamhandler.class, "_deletetempresources" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("stegocover")));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clearform() throws Exception{
try {
		Debug.PushSubsStack("clearForm (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,219);
if (RapidSub.canDelegate("clearform")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","clearform");}
RemoteObject _encryptiontypes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 219;BA.debugLine="Private Sub clearForm";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="Dim encryptionTypes As List";
Debug.ShouldStop(134217728);
_encryptiontypes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("encryptionTypes", _encryptiontypes);
 BA.debugLineNum = 221;BA.debugLine="encryptionTypes.Initialize";
Debug.ShouldStop(268435456);
_encryptiontypes.runVoidMethod ("Initialize");
 BA.debugLineNum = 222;BA.debugLine="encryptionTypes.AddAll(Array As String(\"AES\", \"DE";
Debug.ShouldStop(536870912);
_encryptiontypes.runVoidMethod ("AddAll",(Object)(encode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("AES"),RemoteObject.createImmutable("DES")})))));
 BA.debugLineNum = 223;BA.debugLine="cboEncryption.SetItems(encryptionTypes)";
Debug.ShouldStop(1073741824);
encode.mostCurrent._cboencryption.runClassMethod (ng.dsoftlab.stegocam.b4xcombobox.class, "_setitems" /*RemoteObject*/ ,(Object)(_encryptiontypes));
 BA.debugLineNum = 224;BA.debugLine="cboEncryption.SelectedIndex=0";
Debug.ShouldStop(-2147483648);
encode.mostCurrent._cboencryption.runClassMethod (ng.dsoftlab.stegocam.b4xcombobox.class, "_setselectedindex" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 225;BA.debugLine="lastPicture=Null";
Debug.ShouldStop(1);
encode._lastpicture = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), encode.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 226;BA.debugLine="imgCover.Bitmap=Null";
Debug.ShouldStop(2);
encode.mostCurrent._imgcover.runMethod(false,"setBitmap",(encode.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 227;BA.debugLine="txtFilename.Text=\"\"";
Debug.ShouldStop(4);
encode.mostCurrent._txtfilename.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 228;BA.debugLine="txtMessage.Text=\"\"";
Debug.ShouldStop(8);
encode.mostCurrent._txtmessage.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 229;BA.debugLine="imgCover.Tag=\"\"";
Debug.ShouldStop(16);
encode.mostCurrent._imgcover.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 230;BA.debugLine="txtFilename.Tag=\"\"";
Debug.ShouldStop(32);
encode.mostCurrent._txtfilename.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 231;BA.debugLine="txtKey.Text=\"\"";
Debug.ShouldStop(64);
encode.mostCurrent._txtkey.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 232;BA.debugLine="lblShowPassword.Text=config.hide";
Debug.ShouldStop(128);
encode.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(encode.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 233;BA.debugLine="txtKey.PasswordMode=True";
Debug.ShouldStop(256);
encode.mostCurrent._txtkey.runVoidMethod ("setPasswordMode",encode.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 234;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getba() throws Exception{
try {
		Debug.PushSubsStack("GetBA (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,376);
if (RapidSub.canDelegate("getba")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","getba");}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _cls = RemoteObject.createImmutable("");
 BA.debugLineNum = 376;BA.debugLine="Sub GetBA As Object";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 377;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(16777216);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 378;BA.debugLine="Dim cls As String = Me";
Debug.ShouldStop(33554432);
_cls = BA.ObjectToString(encode.getObject());Debug.locals.put("cls", _cls);Debug.locals.put("cls", _cls);
 BA.debugLineNum = 379;BA.debugLine="cls = cls.SubString(\"class \".Length)";
Debug.ShouldStop(67108864);
_cls = _cls.runMethod(true,"substring",(Object)(RemoteObject.createImmutable("class ").runMethod(true,"length")));Debug.locals.put("cls", _cls);
 BA.debugLineNum = 380;BA.debugLine="jo.InitializeStatic(cls)";
Debug.ShouldStop(134217728);
_jo.runVoidMethod ("InitializeStatic",(Object)(_cls));
 BA.debugLineNum = 381;BA.debugLine="Return jo.GetField(\"processBA\")";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return _jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("processBA")));
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getpathfromcontentresult(RemoteObject _uristring) throws Exception{
try {
		Debug.PushSubsStack("GetPathFromContentResult (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,438);
if (RapidSub.canDelegate("getpathfromcontentresult")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","getpathfromcontentresult", _uristring);}
RemoteObject _cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _uri1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _proj = null;
RemoteObject _cr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper");
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _id = RemoteObject.createImmutable("");
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("UriString", _uristring);
 BA.debugLineNum = 438;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 439;BA.debugLine="If UriString.StartsWith(\"/\") Then Return UriStrin";
Debug.ShouldStop(4194304);
if (_uristring.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("/"))).<Boolean>get().booleanValue()) { 
Debug.CheckDeviceExceptions();if (true) return _uristring;};
 BA.debugLineNum = 440;BA.debugLine="Dim Cursor1 As Cursor";
Debug.ShouldStop(8388608);
_cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor1", _cursor1);
 BA.debugLineNum = 441;BA.debugLine="Dim Uri1 As Uri";
Debug.ShouldStop(16777216);
_uri1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("Uri1", _uri1);
 BA.debugLineNum = 442;BA.debugLine="Dim Proj() As String = Array As String(\"_data\")";
Debug.ShouldStop(33554432);
_proj = RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("_data")});Debug.locals.put("Proj", _proj);Debug.locals.put("Proj", _proj);
 BA.debugLineNum = 443;BA.debugLine="Dim cr As ContentResolver";
Debug.ShouldStop(67108864);
_cr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper");Debug.locals.put("cr", _cr);
 BA.debugLineNum = 444;BA.debugLine="cr.Initialize(\"\")";
Debug.ShouldStop(134217728);
_cr.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 445;BA.debugLine="If UriString.StartsWith(\"content://com.android.pr";
Debug.ShouldStop(268435456);
if (_uristring.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("content://com.android.providers.media.documents"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 446;BA.debugLine="Dim i As Int = UriString.IndexOf(\"%3A\")";
Debug.ShouldStop(536870912);
_i = _uristring.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("%3A")));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 447;BA.debugLine="Dim id As String = UriString.SubString(i + 3)";
Debug.ShouldStop(1073741824);
_id = _uristring.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(3)}, "+",1, 1)));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 448;BA.debugLine="Uri1.Parse(\"content://media/external/images/medi";
Debug.ShouldStop(-2147483648);
_uri1.runVoidMethod ("Parse",(Object)(RemoteObject.createImmutable("content://media/external/images/media")));
 BA.debugLineNum = 449;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"_id = ?\", Array";
Debug.ShouldStop(1);
_cursor1 = _cr.runMethod(false,"Query",(Object)(_uri1),(Object)(_proj),(Object)(BA.ObjectToString("_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_id})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("Cursor1", _cursor1);
 }else {
 BA.debugLineNum = 451;BA.debugLine="Uri1.Parse(UriString)";
Debug.ShouldStop(4);
_uri1.runVoidMethod ("Parse",(Object)(_uristring));
 BA.debugLineNum = 452;BA.debugLine="Cursor1 = cr.Query(Uri1, Proj, \"\", Null, \"\")";
Debug.ShouldStop(8);
_cursor1 = _cr.runMethod(false,"Query",(Object)(_uri1),(Object)(_proj),(Object)(BA.ObjectToString("")),(Object)((encode.mostCurrent.__c.getField(false,"Null"))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("Cursor1", _cursor1);
 };
 BA.debugLineNum = 454;BA.debugLine="Cursor1.Position = 0";
Debug.ShouldStop(32);
_cursor1.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 455;BA.debugLine="Dim res As String";
Debug.ShouldStop(64);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 456;BA.debugLine="res = Cursor1.GetString(\"_data\")";
Debug.ShouldStop(128);
_res = _cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("_data")));Debug.locals.put("res", _res);
 BA.debugLineNum = 457;BA.debugLine="Cursor1.Close";
Debug.ShouldStop(256);
_cursor1.runVoidMethod ("Close");
 BA.debugLineNum = 458;BA.debugLine="Return res";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return _res;
 BA.debugLineNum = 459;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _getpermissions() throws Exception{
try {
		Debug.PushSubsStack("getPermissions (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,277);
if (RapidSub.canDelegate("getpermissions")) { ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","getpermissions"); return;}
ResumableSub_getPermissions rsub = new ResumableSub_getPermissions(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_getPermissions extends BA.ResumableSub {
public ResumableSub_getPermissions(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.encode parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject group1;
int index1;
int groupLen1;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("getPermissions (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,277);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 278;BA.debugLine="For Each permission As String In Array(Starter.rp";
Debug.ShouldStop(2097152);
if (true) break;

case 1:
//for
this.state = 8;
group1 = RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(parent.mostCurrent._starter._rp /*RemoteObject*/ .getField(true,"PERMISSION_CAMERA")),(parent.mostCurrent._starter._rp /*RemoteObject*/ .getField(true,"PERMISSION_READ_EXTERNAL_STORAGE")),(parent.mostCurrent._starter._rp /*RemoteObject*/ .getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE"))});
index1 = 0;
groupLen1 = group1.getField(true,"length").<Integer>get();
Debug.locals.put("permission", _permission);
this.state = 9;
if (true) break;

case 9:
//C
this.state = 8;
if (index1 < groupLen1) {
this.state = 3;
_permission = BA.ObjectToString(group1.getArrayElement(false,RemoteObject.createImmutable(index1)));Debug.locals.put("permission", _permission);}
if (true) break;

case 10:
//C
this.state = 9;
index1++;
Debug.locals.put("permission", _permission);
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 279;BA.debugLine="Starter.rp.CheckAndRequest(permission)";
Debug.ShouldStop(4194304);
parent.mostCurrent._starter._rp /*RemoteObject*/ .runVoidMethod ("CheckAndRequest",encode.processBA,(Object)(_permission));
 BA.debugLineNum = 280;BA.debugLine="Wait For Activity_PermissionResult (permission A";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", encode.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "encode", "getpermissions"), null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 281;BA.debugLine="If Result = False Then";
Debug.ShouldStop(16777216);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_result,parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 282;BA.debugLine="MsgboxAsync(\"Please grant the neccessary permis";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Please grant the neccessary permission to continue")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("No Permission granted"))),encode.processBA);
 BA.debugLineNum = 284;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 285;BA.debugLine="Return";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return ;
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;
if (true) break;

case 8:
//C
this.state = -1;
Debug.locals.put("permission", _permission);
;
 BA.debugLineNum = 289;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
encode.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private ToolbarHelper As ACActionBar";
encode.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 23;BA.debugLine="Dim SharedPrefs As SharedPreferences";
encode.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 24;BA.debugLine="Dim IME As IME";
encode.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 25;BA.debugLine="Private xui As XUI";
encode.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 26;BA.debugLine="Private Dialog As B4XDialog";
encode.mostCurrent._dialog = RemoteObject.createNew ("ng.dsoftlab.stegocam.b4xdialog");
 //BA.debugLineNum = 28;BA.debugLine="Private btnCancel As Button";
encode.mostCurrent._btncancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnEncode As Button";
encode.mostCurrent._btnencode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private ImageView2 As ImageView";
encode.mostCurrent._imageview2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private ImageView3 As ImageView";
encode.mostCurrent._imageview3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private ImageView4 As ImageView";
encode.mostCurrent._imageview4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblErrorMsg As Label";
encode.mostCurrent._lblerrormsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private pnlEncryption As Panel";
encode.mostCurrent._pnlencryption = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private pnlFile As Panel";
encode.mostCurrent._pnlfile = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private pnlKey As Panel";
encode.mostCurrent._pnlkey = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private pnlMessage As Panel";
encode.mostCurrent._pnlmessage = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private rboxEncodeFile As RadioButton";
encode.mostCurrent._rboxencodefile = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private rboxEncodeText As RadioButton";
encode.mostCurrent._rboxencodetext = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private txtFilename As EditText";
encode.mostCurrent._txtfilename = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private txtKey As EditText";
encode.mostCurrent._txtkey = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private txtMessage As EditText";
encode.mostCurrent._txtmessage = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private imgCover As ImageView";
encode.mostCurrent._imgcover = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private pnlCoverImage As Panel";
encode.mostCurrent._pnlcoverimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private cboEncryption As B4XComboBox";
encode.mostCurrent._cboencryption = RemoteObject.createNew ("ng.dsoftlab.stegocam.b4xcombobox");
 //BA.debugLineNum = 46;BA.debugLine="Dim toast As BCToast";
encode.mostCurrent._toast = RemoteObject.createNew ("ng.dsoftlab.stegocam.bctoast");
 //BA.debugLineNum = 47;BA.debugLine="Private btnBrowse As ImageView";
encode.mostCurrent._btnbrowse = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private lblShowPassword As Label";
encode.mostCurrent._lblshowpassword = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private imgPreview As ImageView";
encode.mostCurrent._imgpreview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private btnExtract As Button";
encode.mostCurrent._btnextract = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private btnShare As Button";
encode.mostCurrent._btnshare = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private lblImgLocation As Label";
encode.mostCurrent._lblimglocation = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private pnlPreview As Panel";
encode.mostCurrent._pnlpreview = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private imgDelete As ImageView";
encode.mostCurrent._imgdelete = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private imgExtract As ImageView";
encode.mostCurrent._imgextract = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private imgShare As ImageView";
encode.mostCurrent._imgshare = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private Label1 As Label";
encode.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private Label2 As Label";
encode.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private Label4 As Label";
encode.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private pnlDelete As Panel";
encode.mostCurrent._pnldelete = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private pnlExtract As Panel";
encode.mostCurrent._pnlextract = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private pnlShare As Panel";
encode.mostCurrent._pnlshare = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _imgcover_click() throws Exception{
try {
		Debug.PushSubsStack("imgCover_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,265);
if (RapidSub.canDelegate("imgcover_click")) { ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","imgcover_click"); return;}
ResumableSub_imgCover_Click rsub = new ResumableSub_imgCover_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_imgCover_Click extends BA.ResumableSub {
public ResumableSub_imgCover_Click(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.encode parent;
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("imgCover_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,265);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 266;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(512);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 267;BA.debugLine="bmp.Initialize(File.DirAssets, \"question.png\")";
Debug.ShouldStop(1024);
_bmp.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("question.png")));
 BA.debugLineNum = 268;BA.debugLine="Msgbox2Async(\"Click on Yes to take picture from c";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Click on Yes to take picture from camera, or No to browse from a file?")),(Object)(BA.ObjectToCharSequence("Browse Cover Image")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("No")),(Object)(_bmp),encode.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 269;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", encode.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "encode", "imgcover_click"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 270;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(8192);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}else 
{ BA.debugLineNum = 272;BA.debugLine="Else if Result = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 5;
}}
if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 271;BA.debugLine="TakePicture";
Debug.ShouldStop(16384);
_takepicture();
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 273;BA.debugLine="BrowseCoverImage";
Debug.ShouldStop(65536);
_browsecoverimage();
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 275;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static void  _imgdelete_click() throws Exception{
try {
		Debug.PushSubsStack("imgDelete_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,426);
if (RapidSub.canDelegate("imgdelete_click")) { ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","imgdelete_click"); return;}
ResumableSub_imgDelete_Click rsub = new ResumableSub_imgDelete_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_imgDelete_Click extends BA.ResumableSub {
public ResumableSub_imgDelete_Click(ng.dsoftlab.stegocam.encode parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.encode parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("imgDelete_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,426);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 427;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete fil";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to delete file?")),(Object)(BA.ObjectToCharSequence("Delete Image")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),encode.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 428;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", encode.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "encode", "imgdelete_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 429;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(4096);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 430;BA.debugLine="File.Delete(lblImgLocation.Text,\"\")";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(parent.mostCurrent._lblimglocation.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 431;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
Debug.ShouldStop(16384);
parent.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_close" /*RemoteObject*/ ,(Object)(parent.mostCurrent._xui.getField(true,"DialogResponse_Cancel")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 433;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
public static RemoteObject  _imgextract_click() throws Exception{
try {
		Debug.PushSubsStack("imgExtract_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,422);
if (RapidSub.canDelegate("imgextract_click")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","imgextract_click");}
 BA.debugLineNum = 422;BA.debugLine="Private Sub imgExtract_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 424;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _imgshare_click() throws Exception{
try {
		Debug.PushSubsStack("imgShare_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,403);
if (RapidSub.canDelegate("imgshare_click")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","imgshare_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _inten = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _tmpt = RemoteObject.createImmutable("");
 BA.debugLineNum = 403;BA.debugLine="Private Sub imgShare_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 404;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 405;BA.debugLine="Dim filename As String=lblImgLocation.Text.SubSt";
Debug.ShouldStop(1048576);
_filename = encode.mostCurrent._lblimglocation.runMethod(true,"getText").runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._lblimglocation.runMethod(true,"getText").runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/"))),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("filename", _filename);Debug.locals.put("filename", _filename);
 BA.debugLineNum = 406;BA.debugLine="File.Copy(lblImgLocation.Text,\"\", Starter.Provid";
Debug.ShouldStop(2097152);
encode.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(encode.mostCurrent._lblimglocation.runMethod(true,"getText")),(Object)(BA.ObjectToString("")),(Object)(encode.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename));
 BA.debugLineNum = 407;BA.debugLine="Dim u As Uri 'ContentResolver library";
Debug.ShouldStop(4194304);
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("u", _u);
 BA.debugLineNum = 408;BA.debugLine="u.Parse(Starter.Provider.GetFileUri(filename))";
Debug.ShouldStop(8388608);
_u.runVoidMethod ("Parse",(Object)(BA.ObjectToString(encode.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ng.dsoftlab.stegocam.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename)))));
 BA.debugLineNum = 409;BA.debugLine="Dim inten As Intent";
Debug.ShouldStop(16777216);
_inten = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("inten", _inten);
 BA.debugLineNum = 410;BA.debugLine="Dim tmpt As String = \"\"";
Debug.ShouldStop(33554432);
_tmpt = BA.ObjectToString("");Debug.locals.put("tmpt", _tmpt);Debug.locals.put("tmpt", _tmpt);
 BA.debugLineNum = 411;BA.debugLine="inten.Initialize(inten.ACTION_SEND,\"\")";
Debug.ShouldStop(67108864);
_inten.runVoidMethod ("Initialize",(Object)(_inten.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 412;BA.debugLine="inten.SetType(\"image/*\")";
Debug.ShouldStop(134217728);
_inten.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("image/*")));
 BA.debugLineNum = 413;BA.debugLine="inten.PutExtra(\"android.intent.extra.STREAM\",u)";
Debug.ShouldStop(268435456);
_inten.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.STREAM")),(Object)((_u.getObject())));
 BA.debugLineNum = 416;BA.debugLine="StartActivity(inten)";
Debug.ShouldStop(-2147483648);
encode.mostCurrent.__c.runVoidMethod ("StartActivity",encode.processBA,(Object)((_inten.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",encode.processBA, e13.toString()); BA.debugLineNum = 418;BA.debugLine="ToastMessageShow(LastException.Message,True)";
Debug.ShouldStop(2);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(encode.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA).runMethod(true,"getMessage"))),(Object)(encode.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 420;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ion_event(RemoteObject _methodname,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("ion_Event (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,348);
if (RapidSub.canDelegate("ion_event")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","ion_event", _methodname, _args);}
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("MethodName", _methodname);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 348;BA.debugLine="Sub ion_Event (MethodName As String, Args() As Obj";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 349;BA.debugLine="Dim xui As XUI";
Debug.ShouldStop(268435456);
encode.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 BA.debugLineNum = 350;BA.debugLine="If Args(0) = -1 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_args.getArrayElement(false,BA.numberCast(int.class, 0)),RemoteObject.createImmutable((-(double) (0 + 1))))) { 
 BA.debugLineNum = 351;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 352;BA.debugLine="Dim in As Intent = Args(1)";
Debug.ShouldStop(-2147483648);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _args.getArrayElement(false,BA.numberCast(int.class, 1)));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 353;BA.debugLine="If File.Exists(Starter.provider.SharedFolder, t";
Debug.ShouldStop(1);
if (encode.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(encode.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(encode._tempimagefile)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 354;BA.debugLine="lastPicture = LoadBitmapSample(Starter.provide";
Debug.ShouldStop(2);
encode._lastpicture = encode.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(encode.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(encode._tempimagefile),(Object)(encode.mostCurrent._imgcover.runMethod(true,"getWidth")),(Object)(encode.mostCurrent._imgcover.runMethod(true,"getHeight")));
 BA.debugLineNum = 355;BA.debugLine="lastPicture =xui.LoadBitmapResize(Starter.prov";
Debug.ShouldStop(4);
encode._lastpicture = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), encode.mostCurrent._xui.runMethod(false,"LoadBitmapResize",(Object)(encode.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(encode._tempimagefile),(Object)(encode.mostCurrent._imgcover.runMethod(true,"getWidth")),(Object)(encode.mostCurrent._imgcover.runMethod(true,"getHeight")),(Object)(encode.mostCurrent.__c.getField(true,"True"))).getObject());
 BA.debugLineNum = 356;BA.debugLine="imgCover.Bitmap = lastPicture";
Debug.ShouldStop(8);
encode.mostCurrent._imgcover.runMethod(false,"setBitmap",(encode._lastpicture.getObject()));
 }else 
{ BA.debugLineNum = 357;BA.debugLine="Else If in.HasExtra(\"data\") Then 'try to get th";
Debug.ShouldStop(16);
if (_in.runMethod(true,"HasExtra",(Object)(RemoteObject.createImmutable("data"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 358;BA.debugLine="Dim jo As JavaObject = in";
Debug.ShouldStop(32);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _in.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 359;BA.debugLine="lastPicture = jo.RunMethodJO(\"getExtras\", Null";
Debug.ShouldStop(64);
encode._lastpicture = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getExtras")),(Object)((encode.mostCurrent.__c.getField(false,"Null")))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("get")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("data"))}))));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e14) {
			BA.rdebugUtils.runVoidMethod("setLastException",encode.processBA, e14.toString()); BA.debugLineNum = 362;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
encode.mostCurrent.__c.runVoidMethod ("LogImpl","740960014",BA.ObjectToString(encode.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA)),0);
 };
 };
 BA.debugLineNum = 365;BA.debugLine="If lastPicture.IsInitialized Then imgCover.Bitmap";
Debug.ShouldStop(4096);
if (encode._lastpicture.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
encode.mostCurrent._imgcover.runMethod(false,"setBitmap",(encode._lastpicture.getObject()));};
 BA.debugLineNum = 366;BA.debugLine="Return Null";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return encode.mostCurrent.__c.getField(false,"Null");
 BA.debugLineNum = 367;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblshowpassword_click() throws Exception{
try {
		Debug.PushSubsStack("lblShowPassword_Click (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,390);
if (RapidSub.canDelegate("lblshowpassword_click")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","lblshowpassword_click");}
 BA.debugLineNum = 390;BA.debugLine="Private Sub lblShowPassword_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 391;BA.debugLine="If lblShowPassword.Text=config.hide Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",encode.mostCurrent._lblshowpassword.runMethod(true,"getText"),BA.ObjectToString(encode.mostCurrent._config._hide /*RemoteObject*/ ))) { 
 BA.debugLineNum = 392;BA.debugLine="lblShowPassword.Text=config.show";
Debug.ShouldStop(128);
encode.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(encode.mostCurrent._config._show /*RemoteObject*/ ));
 BA.debugLineNum = 393;BA.debugLine="txtKey.PasswordMode=False";
Debug.ShouldStop(256);
encode.mostCurrent._txtkey.runVoidMethod ("setPasswordMode",encode.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 395;BA.debugLine="lblShowPassword.Text=config.hide";
Debug.ShouldStop(1024);
encode.mostCurrent._lblshowpassword.runMethod(true,"setText",BA.ObjectToCharSequence(encode.mostCurrent._config._hide /*RemoteObject*/ ));
 BA.debugLineNum = 396;BA.debugLine="txtKey.PasswordMode=True";
Debug.ShouldStop(2048);
encode.mostCurrent._txtkey.runVoidMethod ("setPasswordMode",encode.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 398;BA.debugLine="txtKey.SelectionStart=txtKey.Text.Length";
Debug.ShouldStop(8192);
encode.mostCurrent._txtkey.runMethod(true,"setSelectionStart",encode.mostCurrent._txtkey.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 399;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private ion As Object";
encode._ion = RemoteObject.createNew ("Object");
 //BA.debugLineNum = 11;BA.debugLine="Private const tempImageFile As String = \"stegocam";
encode._tempimagefile = BA.ObjectToString("stegocam_coverimage.jpg");
 //BA.debugLineNum = 12;BA.debugLine="Private lastPicture As Bitmap";
encode._lastpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private imageChooser As ContentChooser";
encode._imagechooser = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 14;BA.debugLine="Private FileHandler1 As FileHandler";
encode._filehandler1 = RemoteObject.createNew ("ng.dsoftlab.stegocam.filehandler");
 //BA.debugLineNum = 15;BA.debugLine="Private stegoHandler As StegocamHandler";
encode._stegohandler = RemoteObject.createNew ("ng.dsoftlab.stegocam.stegocamhandler");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rboxencodefile_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rboxEncodeFile_CheckedChange (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,251);
if (RapidSub.canDelegate("rboxencodefile_checkedchange")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","rboxencodefile_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 251;BA.debugLine="Private Sub rboxEncodeFile_CheckedChange(Checked A";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 252;BA.debugLine="If rboxEncodeFile.Checked Then";
Debug.ShouldStop(134217728);
if (encode.mostCurrent._rboxencodefile.runMethod(true,"getChecked").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 253;BA.debugLine="pnlMessage.Visible=False";
Debug.ShouldStop(268435456);
encode.mostCurrent._pnlmessage.runMethod(true,"setVisible",encode.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 254;BA.debugLine="pnlFile.Visible=True";
Debug.ShouldStop(536870912);
encode.mostCurrent._pnlfile.runMethod(true,"setVisible",encode.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 257;BA.debugLine="pnlKey.Top=pnlFile.Top+pnlFile.Height+15dip";
Debug.ShouldStop(1);
encode.mostCurrent._pnlkey.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._pnlfile.runMethod(true,"getTop"),encode.mostCurrent._pnlfile.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "++",2, 1));
 BA.debugLineNum = 258;BA.debugLine="lblErrorMsg.Top=pnlKey.Top+pnlKey.Height+15dip";
Debug.ShouldStop(2);
encode.mostCurrent._lblerrormsg.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._pnlkey.runMethod(true,"getTop"),encode.mostCurrent._pnlkey.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "++",2, 1));
 BA.debugLineNum = 259;BA.debugLine="btnCancel.Top=lblErrorMsg.Top+lblErrorMsg.Height";
Debug.ShouldStop(4);
encode.mostCurrent._btncancel.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._lblerrormsg.runMethod(true,"getTop"),encode.mostCurrent._lblerrormsg.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 260;BA.debugLine="btnEncode.Top=lblErrorMsg.Top+lblErrorMsg.Height";
Debug.ShouldStop(8);
encode.mostCurrent._btnencode.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._lblerrormsg.runMethod(true,"getTop"),encode.mostCurrent._lblerrormsg.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 };
 BA.debugLineNum = 262;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rboxencodetext_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rboxEncodeText_CheckedChange (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,238);
if (RapidSub.canDelegate("rboxencodetext_checkedchange")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","rboxencodetext_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 238;BA.debugLine="Private Sub rboxEncodeText_CheckedChange(Checked A";
Debug.ShouldStop(8192);
 BA.debugLineNum = 239;BA.debugLine="If rboxEncodeText.Checked Then";
Debug.ShouldStop(16384);
if (encode.mostCurrent._rboxencodetext.runMethod(true,"getChecked").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 240;BA.debugLine="pnlFile.Visible=False";
Debug.ShouldStop(32768);
encode.mostCurrent._pnlfile.runMethod(true,"setVisible",encode.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 241;BA.debugLine="pnlMessage.Visible=True";
Debug.ShouldStop(65536);
encode.mostCurrent._pnlmessage.runMethod(true,"setVisible",encode.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 244;BA.debugLine="pnlKey.Top=pnlMessage.Top+pnlMessage.Height+10di";
Debug.ShouldStop(524288);
encode.mostCurrent._pnlkey.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._pnlmessage.runMethod(true,"getTop"),encode.mostCurrent._pnlmessage.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 245;BA.debugLine="lblErrorMsg.Top=pnlKey.Top+pnlKey.Height+10dip";
Debug.ShouldStop(1048576);
encode.mostCurrent._lblerrormsg.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._pnlkey.runMethod(true,"getTop"),encode.mostCurrent._pnlkey.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 246;BA.debugLine="btnCancel.Top=lblErrorMsg.Top+lblErrorMsg.Height";
Debug.ShouldStop(2097152);
encode.mostCurrent._btncancel.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._lblerrormsg.runMethod(true,"getTop"),encode.mostCurrent._lblerrormsg.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 247;BA.debugLine="btnEncode.Top=lblErrorMsg.Top+lblErrorMsg.Height";
Debug.ShouldStop(4194304);
encode.mostCurrent._btnencode.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {encode.mostCurrent._lblerrormsg.runMethod(true,"getTop"),encode.mostCurrent._lblerrormsg.runMethod(true,"getHeight"),encode.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 };
 BA.debugLineNum = 249;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _showcompletedialog(RemoteObject _img) throws Exception{
try {
		Debug.PushSubsStack("showCompleteDialog (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,156);
if (RapidSub.canDelegate("showcompletedialog")) { ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","showcompletedialog", _img); return;}
ResumableSub_showCompleteDialog rsub = new ResumableSub_showCompleteDialog(null,_img);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_showCompleteDialog extends BA.ResumableSub {
public ResumableSub_showCompleteDialog(ng.dsoftlab.stegocam.encode parent,RemoteObject _img) {
this.parent = parent;
this._img = _img;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.encode parent;
RemoteObject _img;
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _panelspacing = RemoteObject.createImmutable(0);
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("showCompleteDialog (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,156);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("img", _img);
 BA.debugLineNum = 157;BA.debugLine="Try";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//try
this.state = 10;
this.catchState = 9;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 9;
 BA.debugLineNum = 158;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(536870912);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_pnl = parent.mostCurrent._xui.runMethod(false,"CreatePanel",encode.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("pnl", _pnl);Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 161;BA.debugLine="pnl.SetLayoutAnimated(0, 0, 0, 90%x, 80%y)";
Debug.ShouldStop(1);
_pnl.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),encode.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),encode.mostCurrent.activityBA)));
 BA.debugLineNum = 162;BA.debugLine="pnl.LoadLayout(\"embedDialog\")";
Debug.ShouldStop(2);
_pnl.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("embedDialog")),encode.mostCurrent.activityBA);
 BA.debugLineNum = 166;BA.debugLine="imgPreview.Width=pnlPreview.Width-20";
Debug.ShouldStop(32);
parent.mostCurrent._imgpreview.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(20)}, "-",1, 1));
 BA.debugLineNum = 167;BA.debugLine="imgPreview.Height=imgPreview.Width";
Debug.ShouldStop(64);
parent.mostCurrent._imgpreview.runMethod(true,"setHeight",parent.mostCurrent._imgpreview.runMethod(true,"getWidth"));
 BA.debugLineNum = 168;BA.debugLine="imgPreview.Left=pnlPreview.Width/2 - imgPreview.";
Debug.ShouldStop(128);
parent.mostCurrent._imgpreview.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),parent.mostCurrent._imgpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 169;BA.debugLine="imgPreview.Bitmap = xui.LoadBitmapResize(\"\", img";
Debug.ShouldStop(256);
parent.mostCurrent._imgpreview.runMethod(false,"setBitmap",(parent.mostCurrent._xui.runMethod(false,"LoadBitmapResize",(Object)(BA.ObjectToString("")),(Object)(_img),(Object)(parent.mostCurrent._imgpreview.runMethod(true,"getWidth")),(Object)(parent.mostCurrent._imgpreview.runMethod(true,"getHeight")),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 171;BA.debugLine="pnlExtract.Top=imgPreview.Top+imgPreview.Height+";
Debug.ShouldStop(1024);
parent.mostCurrent._pnlextract.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._imgpreview.runMethod(true,"getTop"),parent.mostCurrent._imgpreview.runMethod(true,"getHeight"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 172;BA.debugLine="pnlDelete.Top=imgPreview.Top+imgPreview.Height+1";
Debug.ShouldStop(2048);
parent.mostCurrent._pnldelete.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._imgpreview.runMethod(true,"getTop"),parent.mostCurrent._imgpreview.runMethod(true,"getHeight"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 173;BA.debugLine="pnlShare.Top=imgPreview.Top+imgPreview.Height+10";
Debug.ShouldStop(4096);
parent.mostCurrent._pnlshare.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._imgpreview.runMethod(true,"getTop"),parent.mostCurrent._imgpreview.runMethod(true,"getHeight"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 175;BA.debugLine="Dim panelWidth, panelSpacing As Int";
Debug.ShouldStop(16384);
_panelwidth = RemoteObject.createImmutable(0);Debug.locals.put("panelWidth", _panelwidth);
_panelspacing = RemoteObject.createImmutable(0);Debug.locals.put("panelSpacing", _panelspacing);
 BA.debugLineNum = 176;BA.debugLine="panelSpacing = 5dip";
Debug.ShouldStop(32768);
_panelspacing = parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("panelSpacing", _panelspacing);
 BA.debugLineNum = 177;BA.debugLine="panelWidth = (pnlPreview.Width / 3)";
Debug.ShouldStop(65536);
_panelwidth = BA.numberCast(int.class, (RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0)));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 179;BA.debugLine="pnlExtract.Width  = panelWidth";
Debug.ShouldStop(262144);
parent.mostCurrent._pnlextract.runMethod(true,"setWidth",_panelwidth);
 BA.debugLineNum = 180;BA.debugLine="pnlDelete.Width   = panelWidth";
Debug.ShouldStop(524288);
parent.mostCurrent._pnldelete.runMethod(true,"setWidth",_panelwidth);
 BA.debugLineNum = 181;BA.debugLine="pnlShare.Width    = panelWidth";
Debug.ShouldStop(1048576);
parent.mostCurrent._pnlshare.runMethod(true,"setWidth",_panelwidth);
 BA.debugLineNum = 183;BA.debugLine="pnlExtract.Left=0";
Debug.ShouldStop(4194304);
parent.mostCurrent._pnlextract.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 184;BA.debugLine="pnlDelete.Left=panelWidth";
Debug.ShouldStop(8388608);
parent.mostCurrent._pnldelete.runMethod(true,"setLeft",_panelwidth);
 BA.debugLineNum = 185;BA.debugLine="pnlShare.Left=(panelWidth * 2)";
Debug.ShouldStop(16777216);
parent.mostCurrent._pnlshare.runMethod(true,"setLeft",(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)));
 BA.debugLineNum = 190;BA.debugLine="imgExtract.Left=pnlExtract.Width/2-imgExtract.Wi";
Debug.ShouldStop(536870912);
parent.mostCurrent._imgextract.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlextract.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),parent.mostCurrent._imgextract.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 191;BA.debugLine="imgDelete.Left=pnlDelete.Width/2-imgDelete.Width";
Debug.ShouldStop(1073741824);
parent.mostCurrent._imgdelete.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnldelete.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),parent.mostCurrent._imgdelete.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 192;BA.debugLine="imgShare.Left=pnlShare.Width/2-imgShare.Width/2";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._imgshare.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlshare.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),parent.mostCurrent._imgshare.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 194;BA.debugLine="Label1.Left=0";
Debug.ShouldStop(2);
parent.mostCurrent._label1.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 195;BA.debugLine="Label1.Width=pnlExtract.Width";
Debug.ShouldStop(4);
parent.mostCurrent._label1.runMethod(true,"setWidth",parent.mostCurrent._pnlextract.runMethod(true,"getWidth"));
 BA.debugLineNum = 197;BA.debugLine="Label4.Left=0";
Debug.ShouldStop(16);
parent.mostCurrent._label4.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 198;BA.debugLine="Label4.Width=pnlDelete.Width";
Debug.ShouldStop(32);
parent.mostCurrent._label4.runMethod(true,"setWidth",parent.mostCurrent._pnldelete.runMethod(true,"getWidth"));
 BA.debugLineNum = 200;BA.debugLine="Label2.Left=0";
Debug.ShouldStop(128);
parent.mostCurrent._label2.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 201;BA.debugLine="Label2.Width=pnlShare.Width";
Debug.ShouldStop(256);
parent.mostCurrent._label2.runMethod(true,"setWidth",parent.mostCurrent._pnlshare.runMethod(true,"getWidth"));
 BA.debugLineNum = 204;BA.debugLine="lblImgLocation.Text=img";
Debug.ShouldStop(2048);
parent.mostCurrent._lblimglocation.runMethod(true,"setText",BA.ObjectToCharSequence(_img));
 BA.debugLineNum = 206;BA.debugLine="Dim rs As ResumableSub = Dialog.ShowCustom(pnl,";
Debug.ShouldStop(8192);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper");
_rs = parent.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_showcustom" /*RemoteObject*/ ,(Object)(_pnl),(Object)(RemoteObject.createImmutable(("Ok"))),(Object)(RemoteObject.createImmutable((""))),(Object)((RemoteObject.createImmutable("Cancel"))));Debug.locals.put("rs", _rs);Debug.locals.put("rs", _rs);
 BA.debugLineNum = 207;BA.debugLine="Wait For (rs) Complete (Result As Int)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", encode.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "encode", "showcompletedialog"), _rs);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 208;BA.debugLine="If Result = xui.DialogResponse_Positive Or Resul";
Debug.ShouldStop(32768);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent._xui.getField(true,"DialogResponse_Positive"))) || RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent._xui.getField(true,"DialogResponse_Cancel")))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 210;BA.debugLine="clearForm";
Debug.ShouldStop(131072);
_clearform();
 if (true) break;

case 7:
//C
this.state = 10;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 BA.debugLineNum = 213;BA.debugLine="ToastMessageShow(LastException.Message,True)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA).runMethod(true,"getMessage"))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 214;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","763307834",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",encode.processBA, e0.toString());}
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
public static RemoteObject  _startactivityforresult(RemoteObject _i) throws Exception{
try {
		Debug.PushSubsStack("StartActivityForResult (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,370);
if (RapidSub.canDelegate("startactivityforresult")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","startactivityforresult", _i);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("i", _i);
 BA.debugLineNum = 370;BA.debugLine="Sub StartActivityForResult(i As Intent)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 371;BA.debugLine="Dim jo As JavaObject = GetBA";
Debug.ShouldStop(262144);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _getba());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 372;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
Debug.ShouldStop(524288);
encode._ion = _jo.runMethod(false,"CreateEvent",encode.processBA,(Object)(BA.ObjectToString("anywheresoftware.b4a.IOnActivityResult")),(Object)(BA.ObjectToString("ion")),(Object)(encode.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 373;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
Debug.ShouldStop(1048576);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("startActivityForResult")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {encode._ion,(_i.getObject())})));
 BA.debugLineNum = 374;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _takepicture() throws Exception{
try {
		Debug.PushSubsStack("TakePicture (encode) ","encode",4,encode.mostCurrent.activityBA,encode.mostCurrent,333);
if (RapidSub.canDelegate("takepicture")) { return ng.dsoftlab.stegocam.encode.remoteMe.runUserSub(false, "encode","takepicture");}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _u = RemoteObject.declareNull("Object");
 BA.debugLineNum = 333;BA.debugLine="Sub TakePicture";
Debug.ShouldStop(4096);
 BA.debugLineNum = 334;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(8192);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 335;BA.debugLine="i.Initialize(\"android.media.action.IMAGE_CAPTURE\"";
Debug.ShouldStop(16384);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.media.action.IMAGE_CAPTURE")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 336;BA.debugLine="File.Delete(Starter.provider.SharedFolder, tempIm";
Debug.ShouldStop(32768);
encode.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(encode.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(encode._tempimagefile));
 BA.debugLineNum = 337;BA.debugLine="Dim u As Object = Starter.provider.GetFileUri(tem";
Debug.ShouldStop(65536);
_u = encode.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ng.dsoftlab.stegocam.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(encode._tempimagefile));Debug.locals.put("u", _u);Debug.locals.put("u", _u);
 BA.debugLineNum = 338;BA.debugLine="i.PutExtra(\"output\", u) 'the image will be saved";
Debug.ShouldStop(131072);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("output")),(Object)(_u));
 BA.debugLineNum = 339;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 340;BA.debugLine="StartActivityForResult(i)";
Debug.ShouldStop(524288);
_startactivityforresult(_i);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",encode.processBA, e9.toString()); BA.debugLineNum = 342;BA.debugLine="ToastMessageShow(\"Camera is not available.\", Tru";
Debug.ShouldStop(2097152);
encode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Camera is not available.")),(Object)(encode.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 343;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4194304);
encode.mostCurrent.__c.runVoidMethod ("LogImpl","740894474",BA.ObjectToString(encode.mostCurrent.__c.runMethod(false,"LastException",encode.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 345;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}