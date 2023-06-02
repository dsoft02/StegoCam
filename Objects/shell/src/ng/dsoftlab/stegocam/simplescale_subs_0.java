package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class simplescale_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private layValues As LayoutValues";
simplescale._layvalues = RemoteObject.createNew ("anywheresoftware.b4a.keywords.LayoutValues");__ref.setField("_layvalues",simplescale._layvalues);
 //BA.debugLineNum = 22;BA.debugLine="Private initialAttribs As List";
simplescale._initialattribs = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_initialattribs",simplescale._initialattribs);
 //BA.debugLineNum = 23;BA.debugLine="Private hasTitle As Boolean";
simplescale._hastitle = RemoteObject.createImmutable(false);__ref.setField("_hastitle",simplescale._hastitle);
 //BA.debugLineNum = 24;BA.debugLine="Private isFullScreen As Boolean";
simplescale._isfullscreen = RemoteObject.createImmutable(false);__ref.setField("_isfullscreen",simplescale._isfullscreen);
 //BA.debugLineNum = 25;BA.debugLine="Private container As Panel";
simplescale._container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_container",simplescale._container);
 //BA.debugLineNum = 26;BA.debugLine="Public lastRatioX As Float";
simplescale._lastratiox = RemoteObject.createImmutable(0f);__ref.setField("_lastratiox",simplescale._lastratiox);
 //BA.debugLineNum = 27;BA.debugLine="Public lastRatioY As Float";
simplescale._lastratioy = RemoteObject.createImmutable(0f);__ref.setField("_lastratioy",simplescale._lastratioy);
 //BA.debugLineNum = 28;BA.debugLine="Public lastPctScreen As Float";
simplescale._lastpctscreen = RemoteObject.createImmutable(0f);__ref.setField("_lastpctscreen",simplescale._lastpctscreen);
 //BA.debugLineNum = 32;BA.debugLine="Type ViewAttribs ( _ 		top, left As Int, _ 		widt";
;
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _escalarview(RemoteObject __ref,RemoteObject _v,RemoteObject _attribs,RemoteObject _ratiox,RemoteObject _ratioy) throws Exception{
try {
		Debug.PushSubsStack("escalarView (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,225);
if (RapidSub.canDelegate("escalarview")) { return __ref.runUserSub(false, "simplescale","escalarview", __ref, _v, _attribs, _ratiox, _ratioy);}
RemoteObject _lb = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _spn = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
Debug.locals.put("v", _v);
Debug.locals.put("attribs", _attribs);
Debug.locals.put("ratiox", _ratiox);
Debug.locals.put("ratioy", _ratioy);
 BA.debugLineNum = 225;BA.debugLine="Private Sub escalarView (v As View, attribs As Vie";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="v.Left = attribs.left  * ratiox";
Debug.ShouldStop(2);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_attribs.getField(true,"left" /*RemoteObject*/ ),_ratiox}, "*",0, 0)));
 BA.debugLineNum = 227;BA.debugLine="v.Top = attribs.Top   * ratioy";
Debug.ShouldStop(4);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_attribs.getField(true,"top" /*RemoteObject*/ ),_ratioy}, "*",0, 0)));
 BA.debugLineNum = 228;BA.debugLine="v.Width = attribs.Width * ratiox";
Debug.ShouldStop(8);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_attribs.getField(true,"width" /*RemoteObject*/ ),_ratiox}, "*",0, 0)));
 BA.debugLineNum = 229;BA.debugLine="v.Height = attribs.Height  * ratioy";
Debug.ShouldStop(16);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_attribs.getField(true,"height" /*RemoteObject*/ ),_ratioy}, "*",0, 0)));
 BA.debugLineNum = 230;BA.debugLine="If v Is Label Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 231;BA.debugLine="Dim lb As Label";
Debug.ShouldStop(64);
_lb = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lb", _lb);
 BA.debugLineNum = 232;BA.debugLine="lb = v";
Debug.ShouldStop(128);
_lb = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _v.getObject());Debug.locals.put("lb", _lb);
 BA.debugLineNum = 234;BA.debugLine="lb.TextSize = attribs.textSize * (ratiox + rati";
Debug.ShouldStop(512);
_lb.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_attribs.getField(true,"textSize" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {_ratiox,_ratioy}, "+",1, 0)),RemoteObject.createImmutable(2)}, "*/",0, 0)));
 };
 BA.debugLineNum = 236;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Sp";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",simplescale.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner"))) { 
 BA.debugLineNum = 237;BA.debugLine="Dim spn As Spinner = v";
Debug.ShouldStop(4096);
_spn = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
_spn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.SpinnerWrapper"), _v.getObject());Debug.locals.put("spn", _spn);Debug.locals.put("spn", _spn);
 BA.debugLineNum = 238;BA.debugLine="spn = v";
Debug.ShouldStop(8192);
_spn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.SpinnerWrapper"), _v.getObject());Debug.locals.put("spn", _spn);
 BA.debugLineNum = 240;BA.debugLine="spn.TextSize = attribs.textSize * (ratiox + rat";
Debug.ShouldStop(32768);
_spn.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_attribs.getField(true,"textSize" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {_ratiox,_ratioy}, "+",1, 0)),RemoteObject.createImmutable(2)}, "*/",0, 0)));
 };
 BA.debugLineNum = 243;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _escalarviewsfromlayout(RemoteObject __ref,RemoteObject _ratiox,RemoteObject _ratioy) throws Exception{
try {
		Debug.PushSubsStack("EscalarViewsFromLayout (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,191);
if (RapidSub.canDelegate("escalarviewsfromlayout")) { return __ref.runUserSub(false, "simplescale","escalarviewsfromlayout", __ref, _ratiox, _ratioy);}
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _attribs = RemoteObject.declareNull("ng.dsoftlab.stegocam.simplescale._viewattribs");
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
Debug.locals.put("ratiox", _ratiox);
Debug.locals.put("ratioy", _ratioy);
 BA.debugLineNum = 191;BA.debugLine="Private Sub EscalarViewsFromLayout (ratiox As Floa";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="Log (\"Iniciando EscalarViewsFromLayout \" & \" free";
Debug.ShouldStop(-2147483648);
simplescale.__c.runVoidMethod ("LogImpl","749348609",RemoteObject.concat(RemoteObject.createImmutable("Iniciando EscalarViewsFromLayout "),RemoteObject.createImmutable(" freeX = "),RemoteObject.createImmutable(" layoutvalues = "),__ref.getField(false,"_layvalues" /*RemoteObject*/ )),0);
 BA.debugLineNum = 202;BA.debugLine="Log(\"Numero de views: \" & container.NumberOfViews";
Debug.ShouldStop(512);
simplescale.__c.runVoidMethod ("LogImpl","749348619",RemoteObject.concat(RemoteObject.createImmutable("Numero de views: "),__ref.getField(false,"_container" /*RemoteObject*/ ).runMethod(true,"getNumberOfViews")),0);
 BA.debugLineNum = 203;BA.debugLine="Dim i As Int, attribs As ViewAttribs";
Debug.ShouldStop(1024);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
_attribs = RemoteObject.createNew ("ng.dsoftlab.stegocam.simplescale._viewattribs");Debug.locals.put("attribs", _attribs);
 BA.debugLineNum = 206;BA.debugLine="i=0: For Each v As View In container.GetAllVie";
Debug.ShouldStop(8192);
_i = BA.numberCast(int.class, 0);Debug.locals.put("i", _i);
 BA.debugLineNum = 206;BA.debugLine="i=0: For Each v As View In container.GetAllVie";
Debug.ShouldStop(8192);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group5 = __ref.getField(false,"_container" /*RemoteObject*/ ).runMethod(false,"GetAllViewsRecursive");
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_v = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), group5.runMethod(false,"Get",index5));Debug.locals.put("v", _v);
Debug.locals.put("v", _v);
 BA.debugLineNum = 208;BA.debugLine="If v.Tag <> Null And (v.Tag = \"dontresize\") Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("N",_v.runMethod(false,"getTag")) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",_v.runMethod(false,"getTag"),(RemoteObject.createImmutable("dontresize"))))))) { 
 BA.debugLineNum = 209;BA.debugLine="Continue";
Debug.ShouldStop(65536);
if (true) continue;
 }else {
 BA.debugLineNum = 211;BA.debugLine="Try 'Fazemos um try-catch porque atributos de v";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 212;BA.debugLine="attribs = initialAttribs.Get(i)";
Debug.ShouldStop(524288);
_attribs = (__ref.getField(false,"_initialattribs" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(_i)));Debug.locals.put("attribs", _attribs);
 BA.debugLineNum = 213;BA.debugLine="escalarView (v, attribs, ratiox, ratioy)";
Debug.ShouldStop(1048576);
__ref.runClassMethod (ng.dsoftlab.stegocam.simplescale.class, "_escalarview" /*RemoteObject*/ ,(Object)(_v),(Object)(_attribs),(Object)(_ratiox),(Object)(_ratioy));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e13.toString()); BA.debugLineNum = 215;BA.debugLine="Log(\"Erro ao acessar posicoes da suposta view:";
Debug.ShouldStop(4194304);
simplescale.__c.runVoidMethod ("LogImpl","749348632",RemoteObject.concat(RemoteObject.createImmutable("Erro ao acessar posicoes da suposta view: "),_v),0);
 };
 };
 BA.debugLineNum = 218;BA.debugLine="i = i+1";
Debug.ShouldStop(33554432);
_i = RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("i", _i);
 }
}Debug.locals.put("v", _v);
;
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdevicephysicalsize(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetDevicePhysicalSize (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,107);
if (RapidSub.canDelegate("getdevicephysicalsize")) { return __ref.runUserSub(false, "simplescale","getdevicephysicalsize", __ref);}
RemoteObject _lv = RemoteObject.declareNull("anywheresoftware.b4a.keywords.LayoutValues");
 BA.debugLineNum = 107;BA.debugLine="Public Sub GetDevicePhysicalSize As Float";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="Dim lv As LayoutValues";
Debug.ShouldStop(2048);
_lv = RemoteObject.createNew ("anywheresoftware.b4a.keywords.LayoutValues");Debug.locals.put("lv", _lv);
 BA.debugLineNum = 109;BA.debugLine="lv = GetDeviceLayoutValues";
Debug.ShouldStop(4096);
_lv = simplescale.__c.runMethod(false,"GetDeviceLayoutValues",__ref.getField(false, "ba"));Debug.locals.put("lv", _lv);
 BA.debugLineNum = 110;BA.debugLine="Return Sqrt(Power(lv.Height / lv.Scale / 160, 2)";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return BA.numberCast(float.class, simplescale.__c.runMethod(true,"Sqrt",(Object)(RemoteObject.solve(new RemoteObject[] {simplescale.__c.runMethod(true,"Power",(Object)(RemoteObject.solve(new RemoteObject[] {_lv.getField(true,"Height"),_lv.getField(true,"Scale"),RemoteObject.createImmutable(160)}, "//",0, 0)),(Object)(BA.numberCast(double.class, 2))),simplescale.__c.runMethod(true,"Power",(Object)(RemoteObject.solve(new RemoteObject[] {_lv.getField(true,"Width"),_lv.getField(true,"Scale"),RemoteObject.createImmutable(160)}, "//",0, 0)),(Object)(BA.numberCast(double.class, 2)))}, "+",1, 0))));
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _guardaratributosoriginais(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GuardarAtributosOriginais (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,60);
if (RapidSub.canDelegate("guardaratributosoriginais")) { return __ref.runUserSub(false, "simplescale","guardaratributosoriginais", __ref);}
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _attribs = RemoteObject.declareNull("ng.dsoftlab.stegocam.simplescale._viewattribs");
 BA.debugLineNum = 60;BA.debugLine="Public  Sub GuardarAtributosOriginais";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="Dim lst As List";
Debug.ShouldStop(268435456);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 62;BA.debugLine="lst.Initialize";
Debug.ShouldStop(536870912);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 63;BA.debugLine="For Each v As View In container.GetAllViewsRec";
Debug.ShouldStop(1073741824);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group3 = __ref.getField(false,"_container" /*RemoteObject*/ ).runMethod(false,"GetAllViewsRecursive");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_v = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), group3.runMethod(false,"Get",index3));Debug.locals.put("v", _v);
Debug.locals.put("v", _v);
 BA.debugLineNum = 64;BA.debugLine="If v.Tag <> Null And (v.Tag = \"dontresize\") Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("N",_v.runMethod(false,"getTag")) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",_v.runMethod(false,"getTag"),(RemoteObject.createImmutable("dontresize"))))))) { 
 BA.debugLineNum = 65;BA.debugLine="Continue";
Debug.ShouldStop(1);
if (true) continue;
 }else {
 BA.debugLineNum = 67;BA.debugLine="Try 'Fazemos um try-catch porque atributos de v";
Debug.ShouldStop(4);
try { BA.debugLineNum = 68;BA.debugLine="Dim attribs As ViewAttribs";
Debug.ShouldStop(8);
_attribs = RemoteObject.createNew ("ng.dsoftlab.stegocam.simplescale._viewattribs");Debug.locals.put("attribs", _attribs);
 BA.debugLineNum = 69;BA.debugLine="attribs = guardarAttribsView(v)";
Debug.ShouldStop(16);
_attribs = __ref.runClassMethod (ng.dsoftlab.stegocam.simplescale.class, "_guardarattribsview" /*RemoteObject*/ ,(Object)(_v));Debug.locals.put("attribs", _attribs);
 BA.debugLineNum = 71;BA.debugLine="lst.Add (attribs)";
Debug.ShouldStop(64);
_lst.runVoidMethod ("Add",(Object)((_attribs)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e12.toString()); BA.debugLineNum = 73;BA.debugLine="Log(\"Erro ao acessar posicoes da suposta view:";
Debug.ShouldStop(256);
simplescale.__c.runVoidMethod ("LogImpl","748955405",RemoteObject.concat(RemoteObject.createImmutable("Erro ao acessar posicoes da suposta view: "),_v),0);
 };
 };
 }
}Debug.locals.put("v", _v);
;
 BA.debugLineNum = 77;BA.debugLine="initialAttribs = lst";
Debug.ShouldStop(4096);
__ref.setField ("_initialattribs" /*RemoteObject*/ ,_lst);
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _guardarattribsview(RemoteObject __ref,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("guardarAttribsView (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,82);
if (RapidSub.canDelegate("guardarattribsview")) { return __ref.runUserSub(false, "simplescale","guardarattribsview", __ref, _v);}
RemoteObject _attribs = RemoteObject.declareNull("ng.dsoftlab.stegocam.simplescale._viewattribs");
RemoteObject _lb = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _spn = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
Debug.locals.put("v", _v);
 BA.debugLineNum = 82;BA.debugLine="Private Sub guardarAttribsView (v As View)  As Vie";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="Dim attribs As ViewAttribs";
Debug.ShouldStop(262144);
_attribs = RemoteObject.createNew ("ng.dsoftlab.stegocam.simplescale._viewattribs");Debug.locals.put("attribs", _attribs);
 BA.debugLineNum = 84;BA.debugLine="Dim lb As Label : Dim spn As Spinner";
Debug.ShouldStop(524288);
_lb = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lb", _lb);
 BA.debugLineNum = 84;BA.debugLine="Dim lb As Label : Dim spn As Spinner";
Debug.ShouldStop(524288);
_spn = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("spn", _spn);
 BA.debugLineNum = 85;BA.debugLine="attribs.Initialize";
Debug.ShouldStop(1048576);
_attribs.runVoidMethod ("Initialize");
 BA.debugLineNum = 86;BA.debugLine="attribs.left = v.Left";
Debug.ShouldStop(2097152);
_attribs.setField ("left" /*RemoteObject*/ ,_v.runMethod(true,"getLeft"));
 BA.debugLineNum = 87;BA.debugLine="attribs.Top = v.Top";
Debug.ShouldStop(4194304);
_attribs.setField ("top" /*RemoteObject*/ ,_v.runMethod(true,"getTop"));
 BA.debugLineNum = 88;BA.debugLine="attribs.Width = v.Width";
Debug.ShouldStop(8388608);
_attribs.setField ("width" /*RemoteObject*/ ,_v.runMethod(true,"getWidth"));
 BA.debugLineNum = 89;BA.debugLine="attribs.Height = v.Height";
Debug.ShouldStop(16777216);
_attribs.setField ("height" /*RemoteObject*/ ,_v.runMethod(true,"getHeight"));
 BA.debugLineNum = 90;BA.debugLine="If v Is Label Then 'isso pega varios tipos de ob";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 91;BA.debugLine="lb = v";
Debug.ShouldStop(67108864);
_lb = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _v.getObject());Debug.locals.put("lb", _lb);
 BA.debugLineNum = 92;BA.debugLine="attribs.textSize = lb.TextSize";
Debug.ShouldStop(134217728);
_attribs.setField ("textSize" /*RemoteObject*/ ,_lb.runMethod(true,"getTextSize"));
 };
 BA.debugLineNum = 94;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Sp";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",simplescale.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner"))) { 
 BA.debugLineNum = 95;BA.debugLine="spn = v";
Debug.ShouldStop(1073741824);
_spn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.SpinnerWrapper"), _v.getObject());Debug.locals.put("spn", _spn);
 BA.debugLineNum = 96;BA.debugLine="attribs.textSize = spn.TextSize";
Debug.ShouldStop(-2147483648);
_attribs.setField ("textSize" /*RemoteObject*/ ,_spn.runMethod(true,"getTextSize"));
 };
 BA.debugLineNum = 98;BA.debugLine="Return attribs";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return _attribs;
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _horizontalcentercontainer(RemoteObject __ref,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("HorizontalCenterContainer (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,248);
if (RapidSub.canDelegate("horizontalcentercontainer")) { return __ref.runUserSub(false, "simplescale","horizontalcentercontainer", __ref, _v);}
Debug.locals.put("v", _v);
 BA.debugLineNum = 248;BA.debugLine="Public Sub HorizontalCenterContainer ( v As View)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="v.Left = (container.Width - v.Width) / 2";
Debug.ShouldStop(16777216);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_container" /*RemoteObject*/ ).runMethod(true,"getWidth"),_v.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
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
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _acontainer,RemoteObject _alayvalues,RemoteObject _ahastitle,RemoteObject _aisfullscreen) throws Exception{
try {
		Debug.PushSubsStack("Initialize (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,48);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "simplescale","initialize", __ref, _ba, _acontainer, _alayvalues, _ahastitle, _aisfullscreen);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("aContainer", _acontainer);
Debug.locals.put("aLayValues", _alayvalues);
Debug.locals.put("aHasTitle", _ahastitle);
Debug.locals.put("aIsFullScreen", _aisfullscreen);
 BA.debugLineNum = 48;BA.debugLine="Public Sub Initialize(aContainer As Panel, aLayVal";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="container = aContainer";
Debug.ShouldStop(65536);
__ref.setField ("_container" /*RemoteObject*/ ,_acontainer);
 BA.debugLineNum = 50;BA.debugLine="layValues = aLayValues";
Debug.ShouldStop(131072);
__ref.setField ("_layvalues" /*RemoteObject*/ ,_alayvalues);
 BA.debugLineNum = 51;BA.debugLine="lastRatioX = 1";
Debug.ShouldStop(262144);
__ref.setField ("_lastratiox" /*RemoteObject*/ ,BA.numberCast(float.class, 1));
 BA.debugLineNum = 52;BA.debugLine="lastRatioY = 1";
Debug.ShouldStop(524288);
__ref.setField ("_lastratioy" /*RemoteObject*/ ,BA.numberCast(float.class, 1));
 BA.debugLineNum = 53;BA.debugLine="hasTitle = aHasTitle";
Debug.ShouldStop(1048576);
__ref.setField ("_hastitle" /*RemoteObject*/ ,_ahastitle);
 BA.debugLineNum = 54;BA.debugLine="isFullScreen = aIsFullScreen";
Debug.ShouldStop(2097152);
__ref.setField ("_isfullscreen" /*RemoteObject*/ ,_aisfullscreen);
 BA.debugLineNum = 55;BA.debugLine="GuardarAtributosOriginais 'guarda os atributos OR";
Debug.ShouldStop(4194304);
__ref.runClassMethod (ng.dsoftlab.stegocam.simplescale.class, "_guardaratributosoriginais" /*RemoteObject*/ );
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
public static RemoteObject  _scalelayouttodevicesize(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ScaleLayoutToDeviceSize (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,120);
if (RapidSub.canDelegate("scalelayouttodevicesize")) { return __ref.runUserSub(false, "simplescale","scalelayouttodevicesize", __ref);}
 BA.debugLineNum = 120;BA.debugLine="Public Sub ScaleLayoutToDeviceSize";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="ScaleTo (1)  'Escala para 100% do tamanho da tela";
Debug.ShouldStop(16777216);
__ref.runClassMethod (ng.dsoftlab.stegocam.simplescale.class, "_scaleto" /*RemoteObject*/ ,(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scalelayouttodevicesizepercent(RemoteObject __ref,RemoteObject _pctscreen) throws Exception{
try {
		Debug.PushSubsStack("ScaleLayoutToDeviceSizePercent (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,126);
if (RapidSub.canDelegate("scalelayouttodevicesizepercent")) { return __ref.runUserSub(false, "simplescale","scalelayouttodevicesizepercent", __ref, _pctscreen);}
Debug.locals.put("pctScreen", _pctscreen);
 BA.debugLineNum = 126;BA.debugLine="Public Sub ScaleLayoutToDeviceSizePercent (pctScre";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="If pctScreen < 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("<",_pctscreen,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 128;BA.debugLine="pctScreen = 0";
Debug.ShouldStop(-2147483648);
_pctscreen = BA.numberCast(float.class, 0);Debug.locals.put("pctScreen", _pctscreen);
 };
 BA.debugLineNum = 132;BA.debugLine="ScaleTo (pctScreen)";
Debug.ShouldStop(8);
__ref.runClassMethod (ng.dsoftlab.stegocam.simplescale.class, "_scaleto" /*RemoteObject*/ ,(Object)(_pctscreen));
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleto(RemoteObject __ref,RemoteObject _pctscreen) throws Exception{
try {
		Debug.PushSubsStack("ScaleTo (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,137);
if (RapidSub.canDelegate("scaleto")) { return __ref.runUserSub(false, "simplescale","scaleto", __ref, _pctscreen);}
RemoteObject _devicescale = RemoteObject.createImmutable(0);
RemoteObject _deslocamentotitle = RemoteObject.createImmutable(0);
RemoteObject _deslocamentofullscreen = RemoteObject.createImmutable(0);
RemoteObject _ratiox = RemoteObject.createImmutable(0f);
RemoteObject _ratioy = RemoteObject.createImmutable(0f);
Debug.locals.put("pctScreen", _pctscreen);
 BA.debugLineNum = 137;BA.debugLine="Public Sub ScaleTo (pctScreen As Float )";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="Dim DeviceScale As Double";
Debug.ShouldStop(512);
_devicescale = RemoteObject.createImmutable(0);Debug.locals.put("DeviceScale", _devicescale);
 BA.debugLineNum = 139;BA.debugLine="DeviceScale = 160dip / 160";
Debug.ShouldStop(1024);
_devicescale = RemoteObject.solve(new RemoteObject[] {simplescale.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160))),RemoteObject.createImmutable(160)}, "/",0, 0);Debug.locals.put("DeviceScale", _devicescale);
 BA.debugLineNum = 140;BA.debugLine="Dim deslocamentoTitle As Int = 0";
Debug.ShouldStop(2048);
_deslocamentotitle = BA.numberCast(int.class, 0);Debug.locals.put("deslocamentoTitle", _deslocamentotitle);Debug.locals.put("deslocamentoTitle", _deslocamentotitle);
 BA.debugLineNum = 141;BA.debugLine="Dim deslocamentoFullScreen As Int = 0";
Debug.ShouldStop(4096);
_deslocamentofullscreen = BA.numberCast(int.class, 0);Debug.locals.put("deslocamentoFullScreen", _deslocamentofullscreen);Debug.locals.put("deslocamentoFullScreen", _deslocamentofullscreen);
 BA.debugLineNum = 143;BA.debugLine="Dim ratiox, ratioy As Float";
Debug.ShouldStop(16384);
_ratiox = RemoteObject.createImmutable(0f);Debug.locals.put("ratiox", _ratiox);
_ratioy = RemoteObject.createImmutable(0f);Debug.locals.put("ratioy", _ratioy);
 BA.debugLineNum = 150;BA.debugLine="If hasTitle = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_hastitle" /*RemoteObject*/ ),simplescale.__c.getField(true,"True"))) { 
 BA.debugLineNum = 151;BA.debugLine="deslocamentoTitle = 25";
Debug.ShouldStop(4194304);
_deslocamentotitle = BA.numberCast(int.class, 25);Debug.locals.put("deslocamentoTitle", _deslocamentotitle);
 }else {
 BA.debugLineNum = 153;BA.debugLine="deslocamentoTitle = 0";
Debug.ShouldStop(16777216);
_deslocamentotitle = BA.numberCast(int.class, 0);Debug.locals.put("deslocamentoTitle", _deslocamentotitle);
 };
 BA.debugLineNum = 156;BA.debugLine="If isFullScreen = True Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_isfullscreen" /*RemoteObject*/ ),simplescale.__c.getField(true,"True"))) { 
 BA.debugLineNum = 157;BA.debugLine="deslocamentoFullScreen = 0";
Debug.ShouldStop(268435456);
_deslocamentofullscreen = BA.numberCast(int.class, 0);Debug.locals.put("deslocamentoFullScreen", _deslocamentofullscreen);
 }else {
 BA.debugLineNum = 159;BA.debugLine="deslocamentoFullScreen = 25";
Debug.ShouldStop(1073741824);
_deslocamentofullscreen = BA.numberCast(int.class, 25);Debug.locals.put("deslocamentoFullScreen", _deslocamentofullscreen);
 };
 BA.debugLineNum = 165;BA.debugLine="Log (\"Layout width = \" & layValues.Width)";
Debug.ShouldStop(16);
simplescale.__c.runVoidMethod ("LogImpl","749283100",RemoteObject.concat(RemoteObject.createImmutable("Layout width = "),__ref.getField(false,"_layvalues" /*RemoteObject*/ ).getField(true,"Width")),0);
 BA.debugLineNum = 166;BA.debugLine="Log (\"Layout height = \" & layValues.Height)";
Debug.ShouldStop(32);
simplescale.__c.runVoidMethod ("LogImpl","749283101",RemoteObject.concat(RemoteObject.createImmutable("Layout height = "),__ref.getField(false,"_layvalues" /*RemoteObject*/ ).getField(true,"Height")),0);
 BA.debugLineNum = 168;BA.debugLine="ratiox = 100%x/layValues.Width/layValues.Scale";
Debug.ShouldStop(128);
_ratiox = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {simplescale.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba")),__ref.getField(false,"_layvalues" /*RemoteObject*/ ).getField(true,"Width"),__ref.getField(false,"_layvalues" /*RemoteObject*/ ).getField(true,"Scale"),_devicescale}, "///",0, 0));Debug.locals.put("ratiox", _ratiox);
 BA.debugLineNum = 169;BA.debugLine="ratioy = 100%y / (layValues.Height - deslocamento";
Debug.ShouldStop(256);
_ratioy = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {simplescale.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba")),(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_layvalues" /*RemoteObject*/ ).getField(true,"Height"),_deslocamentotitle,_deslocamentofullscreen}, "--",2, 1)),__ref.getField(false,"_layvalues" /*RemoteObject*/ ).getField(true,"Scale"),_devicescale}, "///",0, 0));Debug.locals.put("ratioy", _ratioy);
 BA.debugLineNum = 173;BA.debugLine="ratiox = ratiox * pctScreen";
Debug.ShouldStop(4096);
_ratiox = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_ratiox,_pctscreen}, "*",0, 0));Debug.locals.put("ratiox", _ratiox);
 BA.debugLineNum = 174;BA.debugLine="ratioy = ratioy * pctScreen";
Debug.ShouldStop(8192);
_ratioy = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_ratioy,_pctscreen}, "*",0, 0));Debug.locals.put("ratioy", _ratioy);
 BA.debugLineNum = 175;BA.debugLine="Log (\"ratiox = \" & ratiox)";
Debug.ShouldStop(16384);
simplescale.__c.runVoidMethod ("LogImpl","749283110",RemoteObject.concat(RemoteObject.createImmutable("ratiox = "),_ratiox),0);
 BA.debugLineNum = 176;BA.debugLine="Log (\"ratioy = \" & ratioy)";
Debug.ShouldStop(32768);
simplescale.__c.runVoidMethod ("LogImpl","749283111",RemoteObject.concat(RemoteObject.createImmutable("ratioy = "),_ratioy),0);
 BA.debugLineNum = 178;BA.debugLine="EscalarViewsFromLayout (ratiox, ratioy)";
Debug.ShouldStop(131072);
__ref.runClassMethod (ng.dsoftlab.stegocam.simplescale.class, "_escalarviewsfromlayout" /*RemoteObject*/ ,(Object)(_ratiox),(Object)(_ratioy));
 BA.debugLineNum = 181;BA.debugLine="lastRatioX = ratiox";
Debug.ShouldStop(1048576);
__ref.setField ("_lastratiox" /*RemoteObject*/ ,_ratiox);
 BA.debugLineNum = 182;BA.debugLine="lastRatioY = ratioy";
Debug.ShouldStop(2097152);
__ref.setField ("_lastratioy" /*RemoteObject*/ ,_ratioy);
 BA.debugLineNum = 183;BA.debugLine="lastPctScreen = pctScreen";
Debug.ShouldStop(4194304);
__ref.setField ("_lastpctscreen" /*RemoteObject*/ ,_pctscreen);
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _verticalcentercontainer(RemoteObject __ref,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("VerticalCenterContainer (simplescale) ","simplescale",15,__ref.getField(false, "ba"),__ref,253);
if (RapidSub.canDelegate("verticalcentercontainer")) { return __ref.runUserSub(false, "simplescale","verticalcentercontainer", __ref, _v);}
Debug.locals.put("v", _v);
 BA.debugLineNum = 253;BA.debugLine="Public Sub VerticalCenterContainer ( v As View)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 254;BA.debugLine="v.Top = (container.Height - v.Height) / 2";
Debug.ShouldStop(536870912);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_container" /*RemoteObject*/ ).runMethod(true,"getHeight"),_v.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 255;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}