package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_create")) { ng.dsoftlab.stegocam.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(ng.dsoftlab.stegocam.main parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.main parent;
RemoteObject _firsttime;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"splash\")";
Debug.ShouldStop(4096);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("splash")),main.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="imgIcon.SetBitmap(xui.LoadBitmapResize(File.DirAs";
Debug.ShouldStop(8192);
parent.mostCurrent._imgicon.runVoidMethod ("SetBitmap",(Object)((parent._xui.runMethod(false,"LoadBitmapResize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("stegocam_ico.png")),(Object)(parent.mostCurrent._imgicon.runMethod(true,"getWidth")),(Object)(parent.mostCurrent._imgicon.runMethod(true,"getHeight")),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 47;BA.debugLine="Sleep(3000)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"),BA.numberCast(int.class, 3000));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 BA.debugLineNum = 49;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(65536);
parent.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 53;BA.debugLine="firstRun =config.isFirstRun 'SharedPrefs.GetBoole";
Debug.ShouldStop(1048576);
parent._firstrun = parent.mostCurrent._config.runMethod(true,"_isfirstrun" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="userPin =config.getUserPin 'SharedPrefs.GetString";
Debug.ShouldStop(4194304);
parent.mostCurrent._userpin = parent.mostCurrent._config.runMethod(true,"_getuserpin" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 58;BA.debugLine="If firstRun Or userPin=\"\" Then";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean(".",parent._firstrun) || RemoteObject.solveBoolean("=",parent.mostCurrent._userpin,BA.ObjectToString(""))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 60;BA.debugLine="StartActivity(PinSetup)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((parent.mostCurrent._pinsetup.getObject())));
 BA.debugLineNum = 62;BA.debugLine="SharedPrefs.SaveBoolean(\"FirstRun\", False)";
Debug.ShouldStop(536870912);
parent.mostCurrent._sharedprefs.runVoidMethod ("SaveBoolean",(Object)(BA.ObjectToString("FirstRun")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 65;BA.debugLine="StartActivity(Login)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((parent.mostCurrent._login.getObject())));
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 67;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,75);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 37;BA.debugLine="Private imgIcon As B4XView";
main.mostCurrent._imgicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Dim splashTimer As Timer";
main.mostCurrent._splashtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 39;BA.debugLine="Dim firstRun As Boolean";
main._firstrun = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 40;BA.debugLine="Dim userPin As String";
main.mostCurrent._userpin = RemoteObject.createImmutable("");
 //BA.debugLineNum = 41;BA.debugLine="Dim SharedPrefs As SharedPreferences";
main.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mytimer_tick() throws Exception{
try {
		Debug.PushSubsStack("myTimer_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("mytimer_tick")) { return ng.dsoftlab.stegocam.main.remoteMe.runUserSub(false, "main","mytimer_tick");}
 BA.debugLineNum = 83;BA.debugLine="Sub myTimer_tick";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="splashTimer.Enabled=False";
Debug.ShouldStop(524288);
main.mostCurrent._splashtimer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 85;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 86;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._mainmenu.getObject())));
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
mainmenu_subs_0._process_globals();
config_subs_0._process_globals();
encode_subs_0._process_globals();
settings_subs_0._process_globals();
pinsetup_subs_0._process_globals();
forgotpin_subs_0._process_globals();
login_subs_0._process_globals();
pinchange_subs_0._process_globals();
pinreset_subs_0._process_globals();
securityquestion_subs_0._process_globals();
history_subs_0._process_globals();
b4xcollections_subs_0._process_globals();
httputils2service_subs_0._process_globals();
xuiviewsutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.main");
starter.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.starter");
mainmenu.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.mainmenu");
config.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.config");
encode.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.encode");
settings.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.settings");
filehandler.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.filehandler");
pinsetup.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.pinsetup");
stegocamhandler.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.stegocamhandler");
biometricmanager.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.biometricmanager");
forgotpin.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.forgotpin");
login.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.login");
pinchange.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.pinchange");
pinreset.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.pinreset");
securityquestion.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.securityquestion");
simplescale.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.simplescale");
history.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.history");
b4xbitset.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xbitset");
b4xbytesbuilder.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xbytesbuilder");
b4xcache.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xcache");
b4xcollections.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xcollections");
b4xcomparatorsort.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xcomparatorsort");
b4xorderedmap.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xorderedmap");
b4xset.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xset");
b4xdrawer.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xdrawer");
b4xtable.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xtable");
b4xformatter.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xformatter");
bctoast.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.bctoast");
httputils2service.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.httputils2service");
httpjob.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.httpjob");
bbcodeparser.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.bbcodeparser");
bbcodeview.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.bbcodeview");
bblabel.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.bblabel");
bctextengine.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.bctextengine");
fileprovider.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.fileprovider");
animatedcounter.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.animatedcounter");
anotherprogressbar.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.anotherprogressbar");
b4xbreadcrumb.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xbreadcrumb");
b4xcolortemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xcolortemplate");
b4xcombobox.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xcombobox");
b4xdatetemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xdatetemplate");
b4xdialog.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xdialog");
b4xfloattextfield.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xfloattextfield");
b4ximageview.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4ximageview");
b4xinputtemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xinputtemplate");
b4xlisttemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xlisttemplate");
b4xloadingindicator.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xloadingindicator");
b4xlongtexttemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xlongtexttemplate");
b4xplusminus.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xplusminus");
b4xradiobutton.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xradiobutton");
b4xsearchtemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xsearchtemplate");
b4xseekbar.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xseekbar");
b4xsignaturetemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xsignaturetemplate");
b4xswitch.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xswitch");
b4xtimedtemplate.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.b4xtimedtemplate");
madewithlove.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.madewithlove");
roundslider.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.roundslider");
scrollinglabel.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.scrollinglabel");
swiftbutton.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.swiftbutton");
xuiviewsutils.myClass = BA.getDeviceClass ("ng.dsoftlab.stegocam.xuiviewsutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 31;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}