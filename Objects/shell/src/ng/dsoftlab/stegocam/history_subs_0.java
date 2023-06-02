package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class history_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,46);
if (RapidSub.canDelegate("activity_create")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"history\")";
Debug.ShouldStop(32768);
history.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("history")),history.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="SharedPrefs.Initialize(\"StegoCamPrefs\")";
Debug.ShouldStop(65536);
history.mostCurrent._sharedprefs.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("StegoCamPrefs")));
 BA.debugLineNum = 50;BA.debugLine="ToolbarHelper.Initialize";
Debug.ShouldStop(131072);
history.mostCurrent._toolbarhelper.runVoidMethod ("Initialize",history.mostCurrent.activityBA);
 BA.debugLineNum = 51;BA.debugLine="ToolbarHelper.ShowUpIndicator = True 'set to true";
Debug.ShouldStop(262144);
history.mostCurrent._toolbarhelper.runVoidMethod ("setShowUpIndicator",history.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 52;BA.debugLine="ACToolBarLight1.InitMenuListener";
Debug.ShouldStop(524288);
history.mostCurrent._actoolbarlight1.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 53;BA.debugLine="Dialog.Initialize(Activity)";
Debug.ShouldStop(1048576);
history.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_initialize" /*RemoteObject*/ ,history.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), history.mostCurrent._activity.getObject()));
 BA.debugLineNum = 54;BA.debugLine="Dialog.Title = \"Stego Image View\"";
Debug.ShouldStop(2097152);
history.mostCurrent._dialog.setField ("_title" /*RemoteObject*/ ,RemoteObject.createImmutable(("Stego Image View")));
 BA.debugLineNum = 55;BA.debugLine="FindPictures";
Debug.ShouldStop(4194304);
_findpictures();
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_KeyPress (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,71);
if (RapidSub.canDelegate("activity_keypress")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And Dialog.Clo";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, history.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) && RemoteObject.solveBoolean(".",history.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_close" /*RemoteObject*/ ,(Object)(history.mostCurrent._xui.getField(true,"DialogResponse_Cancel"))))) { 
 BA.debugLineNum = 73;BA.debugLine="Return True";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return history.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 75;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, history.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 76;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(2048);
history.mostCurrent.__c.runVoidMethod ("StartActivity",history.processBA,(Object)((history.mostCurrent._mainmenu.getObject())));
 BA.debugLineNum = 77;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
history.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 78;BA.debugLine="Return True";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return history.mostCurrent.__c.getField(true,"True");
 };
 };
 BA.debugLineNum = 82;BA.debugLine="Return False";
Debug.ShouldStop(131072);
Debug.CheckDeviceExceptions();if (true) return history.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Pause (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,62);
if (RapidSub.canDelegate("activity_pause")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 62;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,58);
if (RapidSub.canDelegate("activity_resume")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","activity_resume");}
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("Activity_Touch (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,236);
if (RapidSub.canDelegate("activity_touch")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","activity_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 236;BA.debugLine="Sub Activity_Touch (Action As Int, X As Float, Y A";
Debug.ShouldStop(2048);
 BA.debugLineNum = 237;BA.debugLine="Select Action";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(_action,history.mostCurrent._activity.getField(true,"ACTION_DOWN"),history.mostCurrent._activity.getField(true,"ACTION_UP"))) {
case 0: {
 BA.debugLineNum = 239;BA.debugLine="startX = X";
Debug.ShouldStop(16384);
history._startx = _x;
 BA.debugLineNum = 240;BA.debugLine="startY = Y";
Debug.ShouldStop(32768);
history._starty = _y;
 break; }
case 1: {
 BA.debugLineNum = 242;BA.debugLine="If Abs(y - startY) > 20%y Then Return";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",history.mostCurrent.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_y,history._starty}, "-",1, 0))),BA.numberCast(double.class, history.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),history.mostCurrent.activityBA)))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 243;BA.debugLine="If X - startX > 30%x Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",RemoteObject.solve(new RemoteObject[] {_x,history._startx}, "-",1, 0),BA.numberCast(double.class, history.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),history.mostCurrent.activityBA)))) { 
 BA.debugLineNum = 244;BA.debugLine="If btnPrev.Enabled=True Then CallSub(\"\",btnPre";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",history.mostCurrent._btnprev.runMethod(true,"getEnabled"),history.mostCurrent.__c.getField(true,"True"))) { 
history.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",history.processBA,(Object)(RemoteObject.createImmutable((""))),(Object)(_btnprev_click()));};
 }else 
{ BA.debugLineNum = 245;BA.debugLine="Else If startX - x > 30%x Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean(">",RemoteObject.solve(new RemoteObject[] {history._startx,_x}, "-",1, 0),BA.numberCast(double.class, history.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),history.mostCurrent.activityBA)))) { 
 BA.debugLineNum = 246;BA.debugLine="If btnNext.Enabled=True Then CallSub(\"\",btnNex";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",history.mostCurrent._btnnext.runMethod(true,"getEnabled"),history.mostCurrent.__c.getField(true,"True"))) { 
history.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",history.processBA,(Object)(RemoteObject.createImmutable((""))),(Object)(_btnnext_click()));};
 }}
;
 break; }
}
;
 BA.debugLineNum = 250;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("ACToolBarLight1_NavigationItemClick (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,66);
if (RapidSub.canDelegate("actoolbarlight1_navigationitemclick")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","actoolbarlight1_navigationitemclick");}
 BA.debugLineNum = 66;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="StartActivity(mainmenu)";
Debug.ShouldStop(4);
history.mostCurrent.__c.runVoidMethod ("StartActivity",history.processBA,(Object)((history.mostCurrent._mainmenu.getObject())));
 BA.debugLineNum = 68;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
history.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _b4xtable1_cellclicked(RemoteObject _columnid,RemoteObject _rowid) throws Exception{
try {
		Debug.PushSubsStack("B4XTable1_CellClicked (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,179);
if (RapidSub.canDelegate("b4xtable1_cellclicked")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","b4xtable1_cellclicked", _columnid, _rowid);}
RemoteObject _img = RemoteObject.createImmutable("");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _panelspacing = RemoteObject.createImmutable(0);
Debug.locals.put("ColumnId", _columnid);
Debug.locals.put("RowId", _rowid);
 BA.debugLineNum = 179;BA.debugLine="Sub B4XTable1_CellClicked (ColumnId As String, Row";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="Dim img As String = B4XTable1.GetRow(RowId).Get(C";
Debug.ShouldStop(524288);
_img = BA.ObjectToString(history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_getrow" /*RemoteObject*/ ,(Object)(_rowid)).runMethod(false,"Get",(Object)((_columnid))));Debug.locals.put("img", _img);Debug.locals.put("img", _img);
 BA.debugLineNum = 181;BA.debugLine="curCol=ColumnId";
Debug.ShouldStop(1048576);
history._curcol = BA.numberCast(int.class, _columnid);
 BA.debugLineNum = 182;BA.debugLine="curRow = RowId";
Debug.ShouldStop(2097152);
history._currow = BA.numberCast(int.class, _rowid);
 BA.debugLineNum = 183;BA.debugLine="If img <> \"\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("!",_img,BA.ObjectToString(""))) { 
 BA.debugLineNum = 184;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(8388608);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_pnl = history.mostCurrent._xui.runMethod(false,"CreatePanel",history.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("pnl", _pnl);Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 187;BA.debugLine="pnl.SetLayoutAnimated(0, 0, 0, 90%x, 80%y)";
Debug.ShouldStop(67108864);
_pnl.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(history.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),history.mostCurrent.activityBA)),(Object)(history.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),history.mostCurrent.activityBA)));
 BA.debugLineNum = 188;BA.debugLine="pnl.LoadLayout(\"embedDialog\")";
Debug.ShouldStop(134217728);
_pnl.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("embedDialog")),history.mostCurrent.activityBA);
 BA.debugLineNum = 192;BA.debugLine="imgPreview.Width=pnlPreview.Width-20";
Debug.ShouldStop(-2147483648);
history.mostCurrent._imgpreview.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {history.mostCurrent._pnlpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(20)}, "-",1, 1));
 BA.debugLineNum = 193;BA.debugLine="imgPreview.Height=imgPreview.Width";
Debug.ShouldStop(1);
history.mostCurrent._imgpreview.runMethod(true,"setHeight",history.mostCurrent._imgpreview.runMethod(true,"getWidth"));
 BA.debugLineNum = 194;BA.debugLine="imgPreview.Left=pnlPreview.Width/2 - imgPreview.";
Debug.ShouldStop(2);
history.mostCurrent._imgpreview.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {history.mostCurrent._pnlpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),history.mostCurrent._imgpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 195;BA.debugLine="imgPreview.Bitmap = xui.LoadBitmapResize(\"\", img";
Debug.ShouldStop(4);
history.mostCurrent._imgpreview.runMethod(false,"setBitmap",(history.mostCurrent._xui.runMethod(false,"LoadBitmapResize",(Object)(BA.ObjectToString("")),(Object)(_img),(Object)(history.mostCurrent._imgpreview.runMethod(true,"getWidth")),(Object)(history.mostCurrent._imgpreview.runMethod(true,"getHeight")),(Object)(history.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 197;BA.debugLine="pnlExtract.Top=imgPreview.Top+imgPreview.Height+";
Debug.ShouldStop(16);
history.mostCurrent._pnlextract.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {history.mostCurrent._imgpreview.runMethod(true,"getTop"),history.mostCurrent._imgpreview.runMethod(true,"getHeight"),history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 198;BA.debugLine="pnlDelete.Top=imgPreview.Top+imgPreview.Height+1";
Debug.ShouldStop(32);
history.mostCurrent._pnldelete.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {history.mostCurrent._imgpreview.runMethod(true,"getTop"),history.mostCurrent._imgpreview.runMethod(true,"getHeight"),history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 199;BA.debugLine="pnlShare.Top=imgPreview.Top+imgPreview.Height+10";
Debug.ShouldStop(64);
history.mostCurrent._pnlshare.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {history.mostCurrent._imgpreview.runMethod(true,"getTop"),history.mostCurrent._imgpreview.runMethod(true,"getHeight"),history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1));
 BA.debugLineNum = 201;BA.debugLine="Dim panelWidth, panelSpacing As Int";
Debug.ShouldStop(256);
_panelwidth = RemoteObject.createImmutable(0);Debug.locals.put("panelWidth", _panelwidth);
_panelspacing = RemoteObject.createImmutable(0);Debug.locals.put("panelSpacing", _panelspacing);
 BA.debugLineNum = 202;BA.debugLine="panelSpacing = 5dip";
Debug.ShouldStop(512);
_panelspacing = history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("panelSpacing", _panelspacing);
 BA.debugLineNum = 203;BA.debugLine="panelWidth = (pnlPreview.Width / 3)";
Debug.ShouldStop(1024);
_panelwidth = BA.numberCast(int.class, (RemoteObject.solve(new RemoteObject[] {history.mostCurrent._pnlpreview.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0)));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 205;BA.debugLine="pnlExtract.Width  = panelWidth";
Debug.ShouldStop(4096);
history.mostCurrent._pnlextract.runMethod(true,"setWidth",_panelwidth);
 BA.debugLineNum = 206;BA.debugLine="pnlDelete.Width   = panelWidth";
Debug.ShouldStop(8192);
history.mostCurrent._pnldelete.runMethod(true,"setWidth",_panelwidth);
 BA.debugLineNum = 207;BA.debugLine="pnlShare.Width    = panelWidth";
Debug.ShouldStop(16384);
history.mostCurrent._pnlshare.runMethod(true,"setWidth",_panelwidth);
 BA.debugLineNum = 209;BA.debugLine="pnlExtract.Left=0";
Debug.ShouldStop(65536);
history.mostCurrent._pnlextract.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 210;BA.debugLine="pnlDelete.Left=panelWidth";
Debug.ShouldStop(131072);
history.mostCurrent._pnldelete.runMethod(true,"setLeft",_panelwidth);
 BA.debugLineNum = 211;BA.debugLine="pnlShare.Left=(panelWidth * 2)";
Debug.ShouldStop(262144);
history.mostCurrent._pnlshare.runMethod(true,"setLeft",(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)));
 BA.debugLineNum = 216;BA.debugLine="imgExtract.Left=pnlExtract.Width/2-imgExtract.Wi";
Debug.ShouldStop(8388608);
history.mostCurrent._imgextract.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {history.mostCurrent._pnlextract.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),history.mostCurrent._imgextract.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 217;BA.debugLine="imgDelete.Left=pnlDelete.Width/2-imgDelete.Width";
Debug.ShouldStop(16777216);
history.mostCurrent._imgdelete.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {history.mostCurrent._pnldelete.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),history.mostCurrent._imgdelete.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 218;BA.debugLine="imgShare.Left=pnlShare.Width/2-imgShare.Width/2";
Debug.ShouldStop(33554432);
history.mostCurrent._imgshare.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {history.mostCurrent._pnlshare.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),history.mostCurrent._imgshare.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/-/",1, 0)));
 BA.debugLineNum = 220;BA.debugLine="Label1.Left=0";
Debug.ShouldStop(134217728);
history.mostCurrent._label1.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 221;BA.debugLine="Label1.Width=pnlExtract.Width";
Debug.ShouldStop(268435456);
history.mostCurrent._label1.runMethod(true,"setWidth",history.mostCurrent._pnlextract.runMethod(true,"getWidth"));
 BA.debugLineNum = 223;BA.debugLine="Label4.Left=0";
Debug.ShouldStop(1073741824);
history.mostCurrent._label4.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 224;BA.debugLine="Label4.Width=pnlDelete.Width";
Debug.ShouldStop(-2147483648);
history.mostCurrent._label4.runMethod(true,"setWidth",history.mostCurrent._pnldelete.runMethod(true,"getWidth"));
 BA.debugLineNum = 226;BA.debugLine="Label2.Left=0";
Debug.ShouldStop(2);
history.mostCurrent._label2.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 227;BA.debugLine="Label2.Width=pnlShare.Width";
Debug.ShouldStop(4);
history.mostCurrent._label2.runMethod(true,"setWidth",history.mostCurrent._pnlshare.runMethod(true,"getWidth"));
 BA.debugLineNum = 230;BA.debugLine="lblImgLocation.Text=img";
Debug.ShouldStop(32);
history.mostCurrent._lblimglocation.runMethod(true,"setText",BA.ObjectToCharSequence(_img));
 BA.debugLineNum = 231;BA.debugLine="Dialog.ShowCustom(pnl, \"Close\", \"\", \"\")";
Debug.ShouldStop(64);
history.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_showcustom" /*RemoteObject*/ ,(Object)(_pnl),(Object)(RemoteObject.createImmutable(("Close"))),(Object)(RemoteObject.createImmutable((""))),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _b4xtable1_dataupdated() throws Exception{
try {
		Debug.PushSubsStack("B4XTable1_DataUpdated (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,156);
if (RapidSub.canDelegate("b4xtable1_dataupdated")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","b4xtable1_dataupdated");}
RemoteObject _row = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _rowid = RemoteObject.createImmutable(0L);
RemoteObject _column = RemoteObject.declareNull("ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
 BA.debugLineNum = 156;BA.debugLine="Sub B4XTable1_DataUpdated";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="Dim row As Map";
Debug.ShouldStop(268435456);
_row = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("row", _row);
 BA.debugLineNum = 158;BA.debugLine="For i = 0 To B4XTable1.VisibleRowIds.Size - 1";
Debug.ShouldStop(536870912);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {history.mostCurrent._b4xtable1.getField(false,"_visiblerowids" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 159;BA.debugLine="Dim RowId As Long = B4XTable1.VisibleRowIds.Get(";
Debug.ShouldStop(1073741824);
_rowid = BA.numberCast(long.class, history.mostCurrent._b4xtable1.getField(false,"_visiblerowids" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("RowId", _rowid);Debug.locals.put("RowId", _rowid);
 BA.debugLineNum = 160;BA.debugLine="If RowId > 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",_rowid,BA.numberCast(long.class, 0))) { 
 BA.debugLineNum = 161;BA.debugLine="row = B4XTable1.GetRow(RowId)";
Debug.ShouldStop(1);
_row = history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_getrow" /*RemoteObject*/ ,(Object)(_rowid));Debug.locals.put("row", _row);
 }else {
 BA.debugLineNum = 163;BA.debugLine="row = CreateMap()";
Debug.ShouldStop(4);
_row = history.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {}));Debug.locals.put("row", _row);
 };
 BA.debugLineNum = 165;BA.debugLine="For Each column As B4XTableColumn In B4XTable1.C";
Debug.ShouldStop(16);
{
final RemoteObject group9 = history.mostCurrent._b4xtable1.getField(false,"_columns" /*RemoteObject*/ );
final int groupLen9 = group9.runMethod(true,"getSize").<Integer>get()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_column = (group9.runMethod(false,"Get",index9));Debug.locals.put("column", _column);
Debug.locals.put("column", _column);
 BA.debugLineNum = 166;BA.debugLine="Dim pnl As B4XView = column.CellsLayouts.Get(i";
Debug.ShouldStop(32);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_pnl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _column.getField(false,"CellsLayouts" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1))));Debug.locals.put("pnl", _pnl);Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 167;BA.debugLine="Dim iv As B4XView = pnl.GetView(1) 'ImageView w";
Debug.ShouldStop(64);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_iv = _pnl.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("iv", _iv);Debug.locals.put("iv", _iv);
 BA.debugLineNum = 168;BA.debugLine="If row.GetDefault(column.Id, \"\") <> \"\" Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("!",_row.runMethod(false,"GetDefault",(Object)((_column.getField(true,"Id" /*RemoteObject*/ ))),(Object)((RemoteObject.createImmutable("")))),RemoteObject.createImmutable(("")))) { 
 BA.debugLineNum = 169;BA.debugLine="iv.SetBitmap(xui.LoadBitmapResize(\"\", row.Get(";
Debug.ShouldStop(256);
_iv.runVoidMethod ("SetBitmap",(Object)((history.mostCurrent._xui.runMethod(false,"LoadBitmapResize",(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString(_row.runMethod(false,"Get",(Object)((_column.getField(true,"Id" /*RemoteObject*/ )))))),(Object)(_iv.runMethod(true,"getWidth")),(Object)(_iv.runMethod(true,"getHeight")),(Object)(history.mostCurrent.__c.getField(true,"False"))).getObject())));
 }else {
 BA.debugLineNum = 171;BA.debugLine="iv.SetBitmap(Null)";
Debug.ShouldStop(1024);
_iv.runVoidMethod ("SetBitmap",(Object)((history.mostCurrent.__c.getField(false,"Null"))));
 };
 }
}Debug.locals.put("column", _column);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 175;BA.debugLine="btnNext.Enabled = B4XTable1.lblNext.Tag";
Debug.ShouldStop(16384);
history.mostCurrent._btnnext.runMethod(true,"setEnabled",BA.ObjectToBoolean(history.mostCurrent._b4xtable1.getField(false,"_lblnext" /*RemoteObject*/ ).runMethod(false,"getTag")));
 BA.debugLineNum = 176;BA.debugLine="btnPrev.Enabled = B4XTable1.lblBack.Tag";
Debug.ShouldStop(32768);
history.mostCurrent._btnprev.runMethod(true,"setEnabled",BA.ObjectToBoolean(history.mostCurrent._b4xtable1.getField(false,"_lblback" /*RemoteObject*/ ).runMethod(false,"getTag")));
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("btnCancel_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,266);
if (RapidSub.canDelegate("btncancel_click")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","btncancel_click");}
 BA.debugLineNum = 266;BA.debugLine="Private Sub btnCancel_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 268;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnnext_click() throws Exception{
try {
		Debug.PushSubsStack("btnNext_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,252);
if (RapidSub.canDelegate("btnnext_click")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","btnnext_click");}
 BA.debugLineNum = 252;BA.debugLine="Sub btnNext_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 253;BA.debugLine="B4XTable1.CurrentPage = B4XTable1.CurrentPage + 1";
Debug.ShouldStop(268435456);
history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_setcurrentpage" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_getcurrentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 254;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnprev_click() throws Exception{
try {
		Debug.PushSubsStack("btnPrev_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,256);
if (RapidSub.canDelegate("btnprev_click")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","btnprev_click");}
 BA.debugLineNum = 256;BA.debugLine="Sub btnPrev_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 257;BA.debugLine="B4XTable1.CurrentPage = B4XTable1.CurrentPage - 1";
Debug.ShouldStop(1);
history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_setcurrentpage" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_getcurrentpage" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnshare_click() throws Exception{
try {
		Debug.PushSubsStack("btnShare_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,261);
if (RapidSub.canDelegate("btnshare_click")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","btnshare_click");}
 BA.debugLineNum = 261;BA.debugLine="Private Sub btnShare_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 263;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtable(RemoteObject _files) throws Exception{
try {
		Debug.PushSubsStack("CreateTable (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,101);
if (RapidSub.canDelegate("createtable")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","createtable", _files);}
int _i = 0;
RemoteObject _col = RemoteObject.declareNull("ng.dsoftlab.stegocam.b4xtable._b4xtablecolumn");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
Debug.locals.put("Files", _files);
 BA.debugLineNum = 101;BA.debugLine="Sub CreateTable (Files As List)";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="B4XTable1.Clear";
Debug.ShouldStop(32);
history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_clear" /*void*/ );
 BA.debugLineNum = 103;BA.debugLine="B4XTable1.AllowSmallRowHeightModifications = Fals";
Debug.ShouldStop(64);
history.mostCurrent._b4xtable1.setField ("_allowsmallrowheightmodifications" /*RemoteObject*/ ,history.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="B4XTable1.RowHeight = 100dip";
Debug.ShouldStop(128);
history.mostCurrent._b4xtable1.setField ("_rowheight" /*RemoteObject*/ ,history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));
 BA.debugLineNum = 105;BA.debugLine="B4XTable1.SearchField.TextField.Enabled = False";
Debug.ShouldStop(256);
history.mostCurrent._b4xtable1.getField(false,"_searchfield" /*RemoteObject*/ ).runClassMethod (ng.dsoftlab.stegocam.b4xfloattextfield.class, "_gettextfield" /*RemoteObject*/ ).runMethod(true,"setEnabled",history.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 106;BA.debugLine="B4XTable1.SearchField.TextField.Visible=False";
Debug.ShouldStop(512);
history.mostCurrent._b4xtable1.getField(false,"_searchfield" /*RemoteObject*/ ).runClassMethod (ng.dsoftlab.stegocam.b4xfloattextfield.class, "_gettextfield" /*RemoteObject*/ ).runMethod(true,"setVisible",history.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 107;BA.debugLine="B4XTable1.SearchField.mBase.Visible=False";
Debug.ShouldStop(1024);
history.mostCurrent._b4xtable1.getField(false,"_searchfield" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",history.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(2048);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {history._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 109;BA.debugLine="B4XTable1.AddColumn(i, B4XTable1.COLUMN_TYPE_TEX";
Debug.ShouldStop(4096);
history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_addcolumn" /*RemoteObject*/ ,(Object)(BA.NumberToString(_i)),(Object)(history.mostCurrent._b4xtable1.getField(true,"_column_type_text" /*RemoteObject*/ )));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 112;BA.debugLine="B4XTable1.MaximumRowsPerPage = 20";
Debug.ShouldStop(32768);
history.mostCurrent._b4xtable1.setField ("_maximumrowsperpage" /*RemoteObject*/ ,BA.numberCast(int.class, 20));
 BA.debugLineNum = 113;BA.debugLine="B4XTable1.BuildLayoutsCache(B4XTable1.MaximumRows";
Debug.ShouldStop(65536);
history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_buildlayoutscache" /*RemoteObject*/ ,(Object)(history.mostCurrent._b4xtable1.getField(true,"_maximumrowsperpage" /*RemoteObject*/ )));
 BA.debugLineNum = 114;BA.debugLine="For Each col As B4XTableColumn In B4XTable1.Colum";
Debug.ShouldStop(131072);
{
final RemoteObject group12 = history.mostCurrent._b4xtable1.getField(false,"_columns" /*RemoteObject*/ );
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_col = (group12.runMethod(false,"Get",index12));Debug.locals.put("col", _col);
Debug.locals.put("col", _col);
 BA.debugLineNum = 115;BA.debugLine="col.Sortable = False";
Debug.ShouldStop(262144);
_col.setField ("Sortable" /*RemoteObject*/ ,history.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 116;BA.debugLine="col.Width = 100%x / NumberOfColumns";
Debug.ShouldStop(524288);
_col.setField ("Width" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {history.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),history.mostCurrent.activityBA),history._numberofcolumns}, "/",0, 0)));
 BA.debugLineNum = 117;BA.debugLine="For i = 0 To col.CellsLayouts.Size - 1";
Debug.ShouldStop(1048576);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_col.getField(false,"CellsLayouts" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 118;BA.debugLine="Dim pnl As B4XView = col.CellsLayouts.Get(i)";
Debug.ShouldStop(2097152);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_pnl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _col.getField(false,"CellsLayouts" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("pnl", _pnl);Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 119;BA.debugLine="pnl.GetView(0).Visible = False 'hide the label";
Debug.ShouldStop(4194304);
_pnl.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).runMethod(true,"setVisible",history.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 120;BA.debugLine="If i > 0 Then 'i = 0 is the header";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 121;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(16777216);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 122;BA.debugLine="iv.Initialize(\"\")";
Debug.ShouldStop(33554432);
_iv.runVoidMethod ("Initialize",history.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 123;BA.debugLine="pnl.AddView(iv, 2dip, 2dip, col.Width - 4dip,";
Debug.ShouldStop(67108864);
_pnl.runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_col.getField(true,"Width" /*RemoteObject*/ ),history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {history.mostCurrent._b4xtable1.getField(true,"_rowheight" /*RemoteObject*/ ),history.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "-",1, 1)));
 };
 }
}Debug.locals.put("i", _i);
;
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 127;BA.debugLine="LoadData(Files)";
Debug.ShouldStop(1073741824);
_loaddata(_files);
 BA.debugLineNum = 128;BA.debugLine="B4XTable1.mBase.Visible = True";
Debug.ShouldStop(-2147483648);
history.mostCurrent._b4xtable1.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",history.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _findpictures() throws Exception{
try {
		Debug.PushSubsStack("FindPictures (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,86);
if (RapidSub.canDelegate("findpictures")) { ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","findpictures"); return;}
ResumableSub_FindPictures rsub = new ResumableSub_FindPictures(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_FindPictures extends BA.ResumableSub {
public ResumableSub_FindPictures(ng.dsoftlab.stegocam.history parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.history parent;
RemoteObject _allpictures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _picturesfolder = RemoteObject.createImmutable("");
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _files = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _f = RemoteObject.createImmutable("");
RemoteObject group7;
int index7;
int groupLen7;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("FindPictures (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,86);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 87;BA.debugLine="Dim AllPictures As List";
Debug.ShouldStop(4194304);
_allpictures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("AllPictures", _allpictures);
 BA.debugLineNum = 88;BA.debugLine="AllPictures.Initialize";
Debug.ShouldStop(8388608);
_allpictures.runVoidMethod ("Initialize");
 BA.debugLineNum = 89;BA.debugLine="Dim PicturesFolder As String = config.stegoImageP";
Debug.ShouldStop(16777216);
_picturesfolder = parent.mostCurrent._config._stegoimagepath /*RemoteObject*/ ;Debug.locals.put("PicturesFolder", _picturesfolder);Debug.locals.put("PicturesFolder", _picturesfolder);
 BA.debugLineNum = 90;BA.debugLine="If File.Exists(PicturesFolder, \"\") = False Then C";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_picturesfolder),(Object)(RemoteObject.createImmutable(""))),parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
this.state = -1;
if (true) break;;
if (true) break;

case 6:
//C
this.state = 7;
;
 BA.debugLineNum = 91;BA.debugLine="Wait For (File.ListFilesAsync(PicturesFolder)) Co";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", history.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "history", "findpictures"), parent.mostCurrent.__c.getField(false,"File").runMethod(false,"ListFilesAsync",history.processBA,(Object)(_picturesfolder)));
this.state = 15;
return;
case 15:
//C
this.state = 7;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_files = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(1));Debug.locals.put("Files", _files);
;
 BA.debugLineNum = 92;BA.debugLine="If Success Then";
Debug.ShouldStop(134217728);
if (true) break;

case 7:
//if
this.state = 14;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 93;BA.debugLine="For Each f As String In Files";
Debug.ShouldStop(268435456);
if (true) break;

case 10:
//for
this.state = 13;
group7 = _files;
index7 = 0;
groupLen7 = group7.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("f", _f);
this.state = 16;
if (true) break;

case 16:
//C
this.state = 13;
if (index7 < groupLen7) {
this.state = 12;
_f = BA.ObjectToString(group7.runMethod(false,"Get",index7));Debug.locals.put("f", _f);}
if (true) break;

case 17:
//C
this.state = 16;
index7++;
Debug.locals.put("f", _f);
if (true) break;

case 12:
//C
this.state = 17;
 BA.debugLineNum = 94;BA.debugLine="AllPictures.Add(File.Combine(PicturesFolder, f)";
Debug.ShouldStop(536870912);
_allpictures.runVoidMethod ("Add",(Object)((parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(_picturesfolder),(Object)(_f)))));
 if (true) break;
if (true) break;

case 13:
//C
this.state = 14;
Debug.locals.put("f", _f);
;
 if (true) break;

case 14:
//C
this.state = -1;
;
 BA.debugLineNum = 98;BA.debugLine="CreateTable(AllPictures)";
Debug.ShouldStop(2);
_createtable(_allpictures);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
public static void  _complete(RemoteObject _success,RemoteObject _files) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
history.mostCurrent._actoolbarlight1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarLightWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private ToolbarHelper As ACActionBar";
history.mostCurrent._toolbarhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 21;BA.debugLine="Dim SharedPrefs As SharedPreferences";
history.mostCurrent._sharedprefs = RemoteObject.createNew ("com.b4x.sharedpreferences.SharedPreferences");
 //BA.debugLineNum = 22;BA.debugLine="Private xui As XUI";
history.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 23;BA.debugLine="Private B4XTable1 As B4XTable";
history.mostCurrent._b4xtable1 = RemoteObject.createNew ("ng.dsoftlab.stegocam.b4xtable");
 //BA.debugLineNum = 24;BA.debugLine="Private Dialog As B4XDialog";
history.mostCurrent._dialog = RemoteObject.createNew ("ng.dsoftlab.stegocam.b4xdialog");
 //BA.debugLineNum = 25;BA.debugLine="Private btnPrev As Button";
history.mostCurrent._btnprev = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private btnNext As Button";
history.mostCurrent._btnnext = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btnCancel As Button";
history.mostCurrent._btncancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private btnExtract As Button";
history.mostCurrent._btnextract = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnShare As Button";
history.mostCurrent._btnshare = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private imgPreview As ImageView";
history.mostCurrent._imgpreview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private pnlPreview As Panel";
history.mostCurrent._pnlpreview = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim startX, startY As Float";
history._startx = RemoteObject.createImmutable(0f);
history._starty = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 34;BA.debugLine="Private lblImgLocation As Label";
history.mostCurrent._lblimglocation = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private imgDelete As ImageView";
history.mostCurrent._imgdelete = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private imgExtract As ImageView";
history.mostCurrent._imgextract = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private imgShare As ImageView";
history.mostCurrent._imgshare = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private pnlDelete As Panel";
history.mostCurrent._pnldelete = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private pnlExtract As Panel";
history.mostCurrent._pnlextract = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private pnlShare As Panel";
history.mostCurrent._pnlshare = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private Label1 As Label";
history.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private Label4 As Label";
history.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private Label2 As Label";
history.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _imgdelete_click() throws Exception{
try {
		Debug.PushSubsStack("imgDelete_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,293);
if (RapidSub.canDelegate("imgdelete_click")) { ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","imgdelete_click"); return;}
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
public ResumableSub_imgDelete_Click(ng.dsoftlab.stegocam.history parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ng.dsoftlab.stegocam.history parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("imgDelete_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,293);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 294;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete fil";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to delete file?")),(Object)(BA.ObjectToCharSequence("Delete Image")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),history.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 295;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", history.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "history", "imgdelete_click"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 296;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(128);
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
 BA.debugLineNum = 297;BA.debugLine="File.Delete(lblImgLocation.Text,\"\")";
Debug.ShouldStop(256);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(parent.mostCurrent._lblimglocation.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 298;BA.debugLine="FindPictures";
Debug.ShouldStop(512);
_findpictures();
 BA.debugLineNum = 299;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
Debug.ShouldStop(1024);
parent.mostCurrent._dialog.runClassMethod (ng.dsoftlab.stegocam.b4xdialog.class, "_close" /*RemoteObject*/ ,(Object)(parent.mostCurrent._xui.getField(true,"DialogResponse_Cancel")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 301;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
public static RemoteObject  _imgextract_click() throws Exception{
try {
		Debug.PushSubsStack("imgExtract_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,289);
if (RapidSub.canDelegate("imgextract_click")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","imgextract_click");}
 BA.debugLineNum = 289;BA.debugLine="Private Sub imgExtract_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("imgShare_Click (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,270);
if (RapidSub.canDelegate("imgshare_click")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","imgshare_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _inten = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _tmpt = RemoteObject.createImmutable("");
 BA.debugLineNum = 270;BA.debugLine="Private Sub imgShare_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 272;BA.debugLine="Dim filename As String=lblImgLocation.Text.SubSt";
Debug.ShouldStop(32768);
_filename = history.mostCurrent._lblimglocation.runMethod(true,"getText").runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {history.mostCurrent._lblimglocation.runMethod(true,"getText").runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/"))),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("filename", _filename);Debug.locals.put("filename", _filename);
 BA.debugLineNum = 273;BA.debugLine="File.Copy(lblImgLocation.Text,\"\", Starter.Provid";
Debug.ShouldStop(65536);
history.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(history.mostCurrent._lblimglocation.runMethod(true,"getText")),(Object)(BA.ObjectToString("")),(Object)(history.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename));
 BA.debugLineNum = 274;BA.debugLine="Dim u As Uri 'ContentResolver library";
Debug.ShouldStop(131072);
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("u", _u);
 BA.debugLineNum = 275;BA.debugLine="u.Parse(Starter.Provider.GetFileUri(filename))";
Debug.ShouldStop(262144);
_u.runVoidMethod ("Parse",(Object)(BA.ObjectToString(history.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ng.dsoftlab.stegocam.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename)))));
 BA.debugLineNum = 276;BA.debugLine="Dim inten As Intent";
Debug.ShouldStop(524288);
_inten = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("inten", _inten);
 BA.debugLineNum = 277;BA.debugLine="Dim tmpt As String = \"\"";
Debug.ShouldStop(1048576);
_tmpt = BA.ObjectToString("");Debug.locals.put("tmpt", _tmpt);Debug.locals.put("tmpt", _tmpt);
 BA.debugLineNum = 278;BA.debugLine="inten.Initialize(inten.ACTION_SEND,\"\")";
Debug.ShouldStop(2097152);
_inten.runVoidMethod ("Initialize",(Object)(_inten.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 279;BA.debugLine="inten.SetType(\"image/*\")";
Debug.ShouldStop(4194304);
_inten.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("image/*")));
 BA.debugLineNum = 280;BA.debugLine="inten.PutExtra(\"android.intent.extra.STREAM\",u)";
Debug.ShouldStop(8388608);
_inten.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.STREAM")),(Object)((_u.getObject())));
 BA.debugLineNum = 283;BA.debugLine="StartActivity(inten)";
Debug.ShouldStop(67108864);
history.mostCurrent.__c.runVoidMethod ("StartActivity",history.processBA,(Object)((_inten.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",history.processBA, e13.toString()); BA.debugLineNum = 285;BA.debugLine="ToastMessageShow(LastException.Message,True)";
Debug.ShouldStop(268435456);
history.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(history.mostCurrent.__c.runMethod(false,"LastException",history.mostCurrent.activityBA).runMethod(true,"getMessage"))),(Object)(history.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 287;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loaddata(RemoteObject _files) throws Exception{
try {
		Debug.PushSubsStack("LoadData (history) ","history",16,history.mostCurrent.activityBA,history.mostCurrent,131);
if (RapidSub.canDelegate("loaddata")) { return ng.dsoftlab.stegocam.history.remoteMe.runUserSub(false, "history","loaddata", _files);}
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _row = null;
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _f = RemoteObject.createImmutable("");
int _i = 0;
Debug.locals.put("Files", _files);
 BA.debugLineNum = 131;BA.debugLine="Private Sub LoadData (Files As List)";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="Dim Data As List";
Debug.ShouldStop(8);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Data", _data);
 BA.debugLineNum = 133;BA.debugLine="Data.Initialize";
Debug.ShouldStop(16);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 134;BA.debugLine="Dim row(NumberOfColumns) As Object";
Debug.ShouldStop(32);
_row = RemoteObject.createNewArray ("Object", new int[] {history._numberofcolumns.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("row", _row);
 BA.debugLineNum = 135;BA.debugLine="Dim index As Int = -1";
Debug.ShouldStop(64);
_index = BA.numberCast(int.class, -(double) (0 + 1));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 136;BA.debugLine="For Each f As String In Files";
Debug.ShouldStop(128);
{
final RemoteObject group5 = _files;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_f = BA.ObjectToString(group5.runMethod(false,"Get",index5));Debug.locals.put("f", _f);
Debug.locals.put("f", _f);
 BA.debugLineNum = 137;BA.debugLine="If f.EndsWith(\".jpg\") Or f.EndsWith(\".png\") Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(".",_f.runMethod(true,"endsWith",(Object)(RemoteObject.createImmutable(".jpg")))) || RemoteObject.solveBoolean(".",_f.runMethod(true,"endsWith",(Object)(RemoteObject.createImmutable(".png"))))) { 
 BA.debugLineNum = 138;BA.debugLine="index = (index + 1) Mod NumberOfColumns";
Debug.ShouldStop(512);
_index = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "+",1, 1)),history._numberofcolumns}, "%",0, 1);Debug.locals.put("index", _index);
 BA.debugLineNum = 139;BA.debugLine="row(index) = f";
Debug.ShouldStop(1024);
_row.setArrayElement ((_f),_index);
 BA.debugLineNum = 140;BA.debugLine="If index = NumberOfColumns - 1 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_index,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {history._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 141;BA.debugLine="Data.Add(row)";
Debug.ShouldStop(4096);
_data.runVoidMethod ("Add",(Object)((_row)));
 BA.debugLineNum = 142;BA.debugLine="Dim row(NumberOfColumns) As Object";
Debug.ShouldStop(8192);
_row = RemoteObject.createNewArray ("Object", new int[] {history._numberofcolumns.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("row", _row);
 };
 };
 }
}Debug.locals.put("f", _f);
;
 BA.debugLineNum = 146;BA.debugLine="If index < NumberOfColumns - 1 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",_index,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {history._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 148;BA.debugLine="For i = index + 1 To NumberOfColumns - 1";
Debug.ShouldStop(524288);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {history._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue() ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 149;BA.debugLine="row(i) = \"\"";
Debug.ShouldStop(1048576);
_row.setArrayElement (RemoteObject.createImmutable(("")),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 151;BA.debugLine="Data.Add(row)";
Debug.ShouldStop(4194304);
_data.runVoidMethod ("Add",(Object)((_row)));
 };
 BA.debugLineNum = 153;BA.debugLine="B4XTable1.SetData(Data)";
Debug.ShouldStop(16777216);
history.mostCurrent._b4xtable1.runClassMethod (ng.dsoftlab.stegocam.b4xtable.class, "_setdata" /*RemoteObject*/ ,(Object)(_data));
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 10;BA.debugLine="Private rp As RuntimePermissions";
history._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 11;BA.debugLine="Private NumberOfColumns As Int = 3";
history._numberofcolumns = BA.numberCast(int.class, 3);
 //BA.debugLineNum = 12;BA.debugLine="Dim curRow As Int";
history._currow = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Dim curCol As Int";
history._curcol = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}