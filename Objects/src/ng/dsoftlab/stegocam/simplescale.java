package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class simplescale extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ng.dsoftlab.stegocam.simplescale");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ng.dsoftlab.stegocam.simplescale.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _viewattribs{
public boolean IsInitialized;
public int top;
public int left;
public int width;
public int height;
public float textSize;
public int ItemHeight;
public anywheresoftware.b4a.objects.collections.List subList;
public void Initialize() {
IsInitialized = true;
top = 0;
left = 0;
width = 0;
height = 0;
textSize = 0f;
ItemHeight = 0;
subList = new anywheresoftware.b4a.objects.collections.List();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.keywords.LayoutValues _layvalues = null;
public anywheresoftware.b4a.objects.collections.List _initialattribs = null;
public boolean _hastitle = false;
public boolean _isfullscreen = false;
public anywheresoftware.b4a.objects.PanelWrapper _container = null;
public float _lastratiox = 0f;
public float _lastratioy = 0f;
public float _lastpctscreen = 0f;
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
public String  _class_globals(ng.dsoftlab.stegocam.simplescale __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
RDebugUtils.currentLine=48824320;
 //BA.debugLineNum = 48824320;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=48824321;
 //BA.debugLineNum = 48824321;BA.debugLine="Private layValues As LayoutValues";
_layvalues = new anywheresoftware.b4a.keywords.LayoutValues();
RDebugUtils.currentLine=48824322;
 //BA.debugLineNum = 48824322;BA.debugLine="Private initialAttribs As List";
_initialattribs = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48824323;
 //BA.debugLineNum = 48824323;BA.debugLine="Private hasTitle As Boolean";
_hastitle = false;
RDebugUtils.currentLine=48824324;
 //BA.debugLineNum = 48824324;BA.debugLine="Private isFullScreen As Boolean";
_isfullscreen = false;
RDebugUtils.currentLine=48824325;
 //BA.debugLineNum = 48824325;BA.debugLine="Private container As Panel";
_container = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=48824326;
 //BA.debugLineNum = 48824326;BA.debugLine="Public lastRatioX As Float";
_lastratiox = 0f;
RDebugUtils.currentLine=48824327;
 //BA.debugLineNum = 48824327;BA.debugLine="Public lastRatioY As Float";
_lastratioy = 0f;
RDebugUtils.currentLine=48824328;
 //BA.debugLineNum = 48824328;BA.debugLine="Public lastPctScreen As Float";
_lastpctscreen = 0f;
RDebugUtils.currentLine=48824332;
 //BA.debugLineNum = 48824332;BA.debugLine="Type ViewAttribs ( _ 		top, left As Int, _ 		widt";
;
RDebugUtils.currentLine=48824340;
 //BA.debugLineNum = 48824340;BA.debugLine="End Sub";
return "";
}
public String  _escalarview(ng.dsoftlab.stegocam.simplescale __ref,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,ng.dsoftlab.stegocam.simplescale._viewattribs _attribs,float _ratiox,float _ratioy) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "escalarview", false))
	 {return ((String) Debug.delegate(ba, "escalarview", new Object[] {_v,_attribs,_ratiox,_ratioy}));}
anywheresoftware.b4a.objects.LabelWrapper _lb = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
RDebugUtils.currentLine=49414144;
 //BA.debugLineNum = 49414144;BA.debugLine="Private Sub escalarView (v As View, attribs As Vie";
RDebugUtils.currentLine=49414145;
 //BA.debugLineNum = 49414145;BA.debugLine="v.Left = attribs.left  * ratiox";
_v.setLeft((int) (_attribs.left /*int*/ *_ratiox));
RDebugUtils.currentLine=49414146;
 //BA.debugLineNum = 49414146;BA.debugLine="v.Top = attribs.Top   * ratioy";
_v.setTop((int) (_attribs.top /*int*/ *_ratioy));
RDebugUtils.currentLine=49414147;
 //BA.debugLineNum = 49414147;BA.debugLine="v.Width = attribs.Width * ratiox";
_v.setWidth((int) (_attribs.width /*int*/ *_ratiox));
RDebugUtils.currentLine=49414148;
 //BA.debugLineNum = 49414148;BA.debugLine="v.Height = attribs.Height  * ratioy";
_v.setHeight((int) (_attribs.height /*int*/ *_ratioy));
RDebugUtils.currentLine=49414149;
 //BA.debugLineNum = 49414149;BA.debugLine="If v Is Label Then";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=49414150;
 //BA.debugLineNum = 49414150;BA.debugLine="Dim lb As Label";
_lb = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=49414151;
 //BA.debugLineNum = 49414151;BA.debugLine="lb = v";
_lb = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_v.getObject()));
RDebugUtils.currentLine=49414153;
 //BA.debugLineNum = 49414153;BA.debugLine="lb.TextSize = attribs.textSize * (ratiox + rati";
_lb.setTextSize((float) (_attribs.textSize /*float*/ *(_ratiox+_ratioy)/(double)2));
 };
RDebugUtils.currentLine=49414155;
 //BA.debugLineNum = 49414155;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Sp";
if ((__c.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
RDebugUtils.currentLine=49414156;
 //BA.debugLineNum = 49414156;BA.debugLine="Dim spn As Spinner = v";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
_spn = (anywheresoftware.b4a.objects.SpinnerWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.SpinnerWrapper(), (anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=49414157;
 //BA.debugLineNum = 49414157;BA.debugLine="spn = v";
_spn = (anywheresoftware.b4a.objects.SpinnerWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.SpinnerWrapper(), (anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=49414159;
 //BA.debugLineNum = 49414159;BA.debugLine="spn.TextSize = attribs.textSize * (ratiox + rat";
_spn.setTextSize((float) (_attribs.textSize /*float*/ *(_ratiox+_ratioy)/(double)2));
 };
RDebugUtils.currentLine=49414162;
 //BA.debugLineNum = 49414162;BA.debugLine="End Sub";
return "";
}
public String  _escalarviewsfromlayout(ng.dsoftlab.stegocam.simplescale __ref,float _ratiox,float _ratioy) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "escalarviewsfromlayout", false))
	 {return ((String) Debug.delegate(ba, "escalarviewsfromlayout", new Object[] {_ratiox,_ratioy}));}
int _i = 0;
ng.dsoftlab.stegocam.simplescale._viewattribs _attribs = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
RDebugUtils.currentLine=49348608;
 //BA.debugLineNum = 49348608;BA.debugLine="Private Sub EscalarViewsFromLayout (ratiox As Floa";
RDebugUtils.currentLine=49348609;
 //BA.debugLineNum = 49348609;BA.debugLine="Log (\"Iniciando EscalarViewsFromLayout \" & \" free";
__c.LogImpl("749348609","Iniciando EscalarViewsFromLayout "+" freeX = "+" layoutvalues = "+BA.ObjectToString(__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ ),0);
RDebugUtils.currentLine=49348619;
 //BA.debugLineNum = 49348619;BA.debugLine="Log(\"Numero de views: \" & container.NumberOfViews";
__c.LogImpl("749348619","Numero de views: "+BA.NumberToString(__ref._container /*anywheresoftware.b4a.objects.PanelWrapper*/ .getNumberOfViews()),0);
RDebugUtils.currentLine=49348620;
 //BA.debugLineNum = 49348620;BA.debugLine="Dim i As Int, attribs As ViewAttribs";
_i = 0;
_attribs = new ng.dsoftlab.stegocam.simplescale._viewattribs();
RDebugUtils.currentLine=49348623;
 //BA.debugLineNum = 49348623;BA.debugLine="i=0: For Each v As View In container.GetAllVie";
_i = (int) (0);
RDebugUtils.currentLine=49348623;
 //BA.debugLineNum = 49348623;BA.debugLine="i=0: For Each v As View In container.GetAllVie";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group5 = __ref._container /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetAllViewsRecursive();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group5.Get(index5)));
RDebugUtils.currentLine=49348625;
 //BA.debugLineNum = 49348625;BA.debugLine="If v.Tag <> Null And (v.Tag = \"dontresize\") Then";
if (_v.getTag()!= null && ((_v.getTag()).equals((Object)("dontresize")))) { 
RDebugUtils.currentLine=49348626;
 //BA.debugLineNum = 49348626;BA.debugLine="Continue";
if (true) continue;
 }else {
RDebugUtils.currentLine=49348628;
 //BA.debugLineNum = 49348628;BA.debugLine="Try 'Fazemos um try-catch porque atributos de v";
try {RDebugUtils.currentLine=49348629;
 //BA.debugLineNum = 49348629;BA.debugLine="attribs = initialAttribs.Get(i)";
_attribs = (ng.dsoftlab.stegocam.simplescale._viewattribs)(__ref._initialattribs /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=49348630;
 //BA.debugLineNum = 49348630;BA.debugLine="escalarView (v, attribs, ratiox, ratioy)";
__ref._escalarview /*String*/ (null,_v,_attribs,_ratiox,_ratioy);
 } 
       catch (Exception e13) {
			ba.setLastException(e13);RDebugUtils.currentLine=49348632;
 //BA.debugLineNum = 49348632;BA.debugLine="Log(\"Erro ao acessar posicoes da suposta view:";
__c.LogImpl("749348632","Erro ao acessar posicoes da suposta view: "+BA.ObjectToString(_v),0);
 };
 };
RDebugUtils.currentLine=49348635;
 //BA.debugLineNum = 49348635;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 }
};
RDebugUtils.currentLine=49348638;
 //BA.debugLineNum = 49348638;BA.debugLine="End Sub";
return "";
}
public float  _getdevicephysicalsize(ng.dsoftlab.stegocam.simplescale __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "getdevicephysicalsize", false))
	 {return ((Float) Debug.delegate(ba, "getdevicephysicalsize", null));}
anywheresoftware.b4a.keywords.LayoutValues _lv = null;
RDebugUtils.currentLine=49086464;
 //BA.debugLineNum = 49086464;BA.debugLine="Public Sub GetDevicePhysicalSize As Float";
RDebugUtils.currentLine=49086465;
 //BA.debugLineNum = 49086465;BA.debugLine="Dim lv As LayoutValues";
_lv = new anywheresoftware.b4a.keywords.LayoutValues();
RDebugUtils.currentLine=49086466;
 //BA.debugLineNum = 49086466;BA.debugLine="lv = GetDeviceLayoutValues";
_lv = __c.GetDeviceLayoutValues(ba);
RDebugUtils.currentLine=49086467;
 //BA.debugLineNum = 49086467;BA.debugLine="Return Sqrt(Power(lv.Height / lv.Scale / 160, 2)";
if (true) return (float) (__c.Sqrt(__c.Power(_lv.Height/(double)_lv.Scale/(double)160,2)+__c.Power(_lv.Width/(double)_lv.Scale/(double)160,2)));
RDebugUtils.currentLine=49086468;
 //BA.debugLineNum = 49086468;BA.debugLine="End Sub";
return 0f;
}
public String  _guardaratributosoriginais(ng.dsoftlab.stegocam.simplescale __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "guardaratributosoriginais", false))
	 {return ((String) Debug.delegate(ba, "guardaratributosoriginais", null));}
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
ng.dsoftlab.stegocam.simplescale._viewattribs _attribs = null;
RDebugUtils.currentLine=48955392;
 //BA.debugLineNum = 48955392;BA.debugLine="Public  Sub GuardarAtributosOriginais";
RDebugUtils.currentLine=48955393;
 //BA.debugLineNum = 48955393;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=48955394;
 //BA.debugLineNum = 48955394;BA.debugLine="lst.Initialize";
_lst.Initialize();
RDebugUtils.currentLine=48955395;
 //BA.debugLineNum = 48955395;BA.debugLine="For Each v As View In container.GetAllViewsRec";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = __ref._container /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
RDebugUtils.currentLine=48955396;
 //BA.debugLineNum = 48955396;BA.debugLine="If v.Tag <> Null And (v.Tag = \"dontresize\") Then";
if (_v.getTag()!= null && ((_v.getTag()).equals((Object)("dontresize")))) { 
RDebugUtils.currentLine=48955397;
 //BA.debugLineNum = 48955397;BA.debugLine="Continue";
if (true) continue;
 }else {
RDebugUtils.currentLine=48955399;
 //BA.debugLineNum = 48955399;BA.debugLine="Try 'Fazemos um try-catch porque atributos de v";
try {RDebugUtils.currentLine=48955400;
 //BA.debugLineNum = 48955400;BA.debugLine="Dim attribs As ViewAttribs";
_attribs = new ng.dsoftlab.stegocam.simplescale._viewattribs();
RDebugUtils.currentLine=48955401;
 //BA.debugLineNum = 48955401;BA.debugLine="attribs = guardarAttribsView(v)";
_attribs = __ref._guardarattribsview /*ng.dsoftlab.stegocam.simplescale._viewattribs*/ (null,_v);
RDebugUtils.currentLine=48955403;
 //BA.debugLineNum = 48955403;BA.debugLine="lst.Add (attribs)";
_lst.Add((Object)(_attribs));
 } 
       catch (Exception e12) {
			ba.setLastException(e12);RDebugUtils.currentLine=48955405;
 //BA.debugLineNum = 48955405;BA.debugLine="Log(\"Erro ao acessar posicoes da suposta view:";
__c.LogImpl("748955405","Erro ao acessar posicoes da suposta view: "+BA.ObjectToString(_v),0);
 };
 };
 }
};
RDebugUtils.currentLine=48955409;
 //BA.debugLineNum = 48955409;BA.debugLine="initialAttribs = lst";
__ref._initialattribs /*anywheresoftware.b4a.objects.collections.List*/  = _lst;
RDebugUtils.currentLine=48955410;
 //BA.debugLineNum = 48955410;BA.debugLine="End Sub";
return "";
}
public ng.dsoftlab.stegocam.simplescale._viewattribs  _guardarattribsview(ng.dsoftlab.stegocam.simplescale __ref,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "guardarattribsview", false))
	 {return ((ng.dsoftlab.stegocam.simplescale._viewattribs) Debug.delegate(ba, "guardarattribsview", new Object[] {_v}));}
ng.dsoftlab.stegocam.simplescale._viewattribs _attribs = null;
anywheresoftware.b4a.objects.LabelWrapper _lb = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
RDebugUtils.currentLine=49020928;
 //BA.debugLineNum = 49020928;BA.debugLine="Private Sub guardarAttribsView (v As View)  As Vie";
RDebugUtils.currentLine=49020929;
 //BA.debugLineNum = 49020929;BA.debugLine="Dim attribs As ViewAttribs";
_attribs = new ng.dsoftlab.stegocam.simplescale._viewattribs();
RDebugUtils.currentLine=49020930;
 //BA.debugLineNum = 49020930;BA.debugLine="Dim lb As Label : Dim spn As Spinner";
_lb = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=49020930;
 //BA.debugLineNum = 49020930;BA.debugLine="Dim lb As Label : Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=49020931;
 //BA.debugLineNum = 49020931;BA.debugLine="attribs.Initialize";
_attribs.Initialize();
RDebugUtils.currentLine=49020932;
 //BA.debugLineNum = 49020932;BA.debugLine="attribs.left = v.Left";
_attribs.left /*int*/  = _v.getLeft();
RDebugUtils.currentLine=49020933;
 //BA.debugLineNum = 49020933;BA.debugLine="attribs.Top = v.Top";
_attribs.top /*int*/  = _v.getTop();
RDebugUtils.currentLine=49020934;
 //BA.debugLineNum = 49020934;BA.debugLine="attribs.Width = v.Width";
_attribs.width /*int*/  = _v.getWidth();
RDebugUtils.currentLine=49020935;
 //BA.debugLineNum = 49020935;BA.debugLine="attribs.Height = v.Height";
_attribs.height /*int*/  = _v.getHeight();
RDebugUtils.currentLine=49020936;
 //BA.debugLineNum = 49020936;BA.debugLine="If v Is Label Then 'isso pega varios tipos de ob";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=49020937;
 //BA.debugLineNum = 49020937;BA.debugLine="lb = v";
_lb = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_v.getObject()));
RDebugUtils.currentLine=49020938;
 //BA.debugLineNum = 49020938;BA.debugLine="attribs.textSize = lb.TextSize";
_attribs.textSize /*float*/  = _lb.getTextSize();
 };
RDebugUtils.currentLine=49020940;
 //BA.debugLineNum = 49020940;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Sp";
if ((__c.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
RDebugUtils.currentLine=49020941;
 //BA.debugLineNum = 49020941;BA.debugLine="spn = v";
_spn = (anywheresoftware.b4a.objects.SpinnerWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.SpinnerWrapper(), (anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=49020942;
 //BA.debugLineNum = 49020942;BA.debugLine="attribs.textSize = spn.TextSize";
_attribs.textSize /*float*/  = _spn.getTextSize();
 };
RDebugUtils.currentLine=49020944;
 //BA.debugLineNum = 49020944;BA.debugLine="Return attribs";
if (true) return _attribs;
RDebugUtils.currentLine=49020945;
 //BA.debugLineNum = 49020945;BA.debugLine="End Sub";
return null;
}
public String  _horizontalcentercontainer(ng.dsoftlab.stegocam.simplescale __ref,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "horizontalcentercontainer", false))
	 {return ((String) Debug.delegate(ba, "horizontalcentercontainer", new Object[] {_v}));}
RDebugUtils.currentLine=49479680;
 //BA.debugLineNum = 49479680;BA.debugLine="Public Sub HorizontalCenterContainer ( v As View)";
RDebugUtils.currentLine=49479681;
 //BA.debugLineNum = 49479681;BA.debugLine="v.Left = (container.Width - v.Width) / 2";
_v.setLeft((int) ((__ref._container /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()-_v.getWidth())/(double)2));
RDebugUtils.currentLine=49479682;
 //BA.debugLineNum = 49479682;BA.debugLine="End Sub";
return "";
}
public String  _initialize(ng.dsoftlab.stegocam.simplescale __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _acontainer,anywheresoftware.b4a.keywords.LayoutValues _alayvalues,boolean _ahastitle,boolean _aisfullscreen) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_acontainer,_alayvalues,_ahastitle,_aisfullscreen}));}
RDebugUtils.currentLine=48889856;
 //BA.debugLineNum = 48889856;BA.debugLine="Public Sub Initialize(aContainer As Panel, aLayVal";
RDebugUtils.currentLine=48889857;
 //BA.debugLineNum = 48889857;BA.debugLine="container = aContainer";
__ref._container /*anywheresoftware.b4a.objects.PanelWrapper*/  = _acontainer;
RDebugUtils.currentLine=48889858;
 //BA.debugLineNum = 48889858;BA.debugLine="layValues = aLayValues";
__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/  = _alayvalues;
RDebugUtils.currentLine=48889859;
 //BA.debugLineNum = 48889859;BA.debugLine="lastRatioX = 1";
__ref._lastratiox /*float*/  = (float) (1);
RDebugUtils.currentLine=48889860;
 //BA.debugLineNum = 48889860;BA.debugLine="lastRatioY = 1";
__ref._lastratioy /*float*/  = (float) (1);
RDebugUtils.currentLine=48889861;
 //BA.debugLineNum = 48889861;BA.debugLine="hasTitle = aHasTitle";
__ref._hastitle /*boolean*/  = _ahastitle;
RDebugUtils.currentLine=48889862;
 //BA.debugLineNum = 48889862;BA.debugLine="isFullScreen = aIsFullScreen";
__ref._isfullscreen /*boolean*/  = _aisfullscreen;
RDebugUtils.currentLine=48889863;
 //BA.debugLineNum = 48889863;BA.debugLine="GuardarAtributosOriginais 'guarda os atributos OR";
__ref._guardaratributosoriginais /*String*/ (null);
RDebugUtils.currentLine=48889864;
 //BA.debugLineNum = 48889864;BA.debugLine="End Sub";
return "";
}
public String  _scalelayouttodevicesize(ng.dsoftlab.stegocam.simplescale __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "scalelayouttodevicesize", false))
	 {return ((String) Debug.delegate(ba, "scalelayouttodevicesize", null));}
RDebugUtils.currentLine=49152000;
 //BA.debugLineNum = 49152000;BA.debugLine="Public Sub ScaleLayoutToDeviceSize";
RDebugUtils.currentLine=49152001;
 //BA.debugLineNum = 49152001;BA.debugLine="ScaleTo (1)  'Escala para 100% do tamanho da tela";
__ref._scaleto /*String*/ (null,(float) (1));
RDebugUtils.currentLine=49152002;
 //BA.debugLineNum = 49152002;BA.debugLine="End Sub";
return "";
}
public String  _scaleto(ng.dsoftlab.stegocam.simplescale __ref,float _pctscreen) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "scaleto", false))
	 {return ((String) Debug.delegate(ba, "scaleto", new Object[] {_pctscreen}));}
double _devicescale = 0;
int _deslocamentotitle = 0;
int _deslocamentofullscreen = 0;
float _ratiox = 0f;
float _ratioy = 0f;
RDebugUtils.currentLine=49283072;
 //BA.debugLineNum = 49283072;BA.debugLine="Public Sub ScaleTo (pctScreen As Float )";
RDebugUtils.currentLine=49283073;
 //BA.debugLineNum = 49283073;BA.debugLine="Dim DeviceScale As Double";
_devicescale = 0;
RDebugUtils.currentLine=49283074;
 //BA.debugLineNum = 49283074;BA.debugLine="DeviceScale = 160dip / 160";
_devicescale = __c.DipToCurrent((int) (160))/(double)160;
RDebugUtils.currentLine=49283075;
 //BA.debugLineNum = 49283075;BA.debugLine="Dim deslocamentoTitle As Int = 0";
_deslocamentotitle = (int) (0);
RDebugUtils.currentLine=49283076;
 //BA.debugLineNum = 49283076;BA.debugLine="Dim deslocamentoFullScreen As Int = 0";
_deslocamentofullscreen = (int) (0);
RDebugUtils.currentLine=49283078;
 //BA.debugLineNum = 49283078;BA.debugLine="Dim ratiox, ratioy As Float";
_ratiox = 0f;
_ratioy = 0f;
RDebugUtils.currentLine=49283085;
 //BA.debugLineNum = 49283085;BA.debugLine="If hasTitle = True Then";
if (__ref._hastitle /*boolean*/ ==__c.True) { 
RDebugUtils.currentLine=49283086;
 //BA.debugLineNum = 49283086;BA.debugLine="deslocamentoTitle = 25";
_deslocamentotitle = (int) (25);
 }else {
RDebugUtils.currentLine=49283088;
 //BA.debugLineNum = 49283088;BA.debugLine="deslocamentoTitle = 0";
_deslocamentotitle = (int) (0);
 };
RDebugUtils.currentLine=49283091;
 //BA.debugLineNum = 49283091;BA.debugLine="If isFullScreen = True Then";
if (__ref._isfullscreen /*boolean*/ ==__c.True) { 
RDebugUtils.currentLine=49283092;
 //BA.debugLineNum = 49283092;BA.debugLine="deslocamentoFullScreen = 0";
_deslocamentofullscreen = (int) (0);
 }else {
RDebugUtils.currentLine=49283094;
 //BA.debugLineNum = 49283094;BA.debugLine="deslocamentoFullScreen = 25";
_deslocamentofullscreen = (int) (25);
 };
RDebugUtils.currentLine=49283100;
 //BA.debugLineNum = 49283100;BA.debugLine="Log (\"Layout width = \" & layValues.Width)";
__c.LogImpl("749283100","Layout width = "+BA.NumberToString(__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ .Width),0);
RDebugUtils.currentLine=49283101;
 //BA.debugLineNum = 49283101;BA.debugLine="Log (\"Layout height = \" & layValues.Height)";
__c.LogImpl("749283101","Layout height = "+BA.NumberToString(__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ .Height),0);
RDebugUtils.currentLine=49283103;
 //BA.debugLineNum = 49283103;BA.debugLine="ratiox = 100%x/layValues.Width/layValues.Scale";
_ratiox = (float) (__c.PerXToCurrent((float) (100),ba)/(double)__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ .Width/(double)__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ .Scale/(double)_devicescale);
RDebugUtils.currentLine=49283104;
 //BA.debugLineNum = 49283104;BA.debugLine="ratioy = 100%y / (layValues.Height - deslocamento";
_ratioy = (float) (__c.PerYToCurrent((float) (100),ba)/(double)(__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ .Height-_deslocamentotitle-_deslocamentofullscreen)/(double)__ref._layvalues /*anywheresoftware.b4a.keywords.LayoutValues*/ .Scale/(double)_devicescale);
RDebugUtils.currentLine=49283108;
 //BA.debugLineNum = 49283108;BA.debugLine="ratiox = ratiox * pctScreen";
_ratiox = (float) (_ratiox*_pctscreen);
RDebugUtils.currentLine=49283109;
 //BA.debugLineNum = 49283109;BA.debugLine="ratioy = ratioy * pctScreen";
_ratioy = (float) (_ratioy*_pctscreen);
RDebugUtils.currentLine=49283110;
 //BA.debugLineNum = 49283110;BA.debugLine="Log (\"ratiox = \" & ratiox)";
__c.LogImpl("749283110","ratiox = "+BA.NumberToString(_ratiox),0);
RDebugUtils.currentLine=49283111;
 //BA.debugLineNum = 49283111;BA.debugLine="Log (\"ratioy = \" & ratioy)";
__c.LogImpl("749283111","ratioy = "+BA.NumberToString(_ratioy),0);
RDebugUtils.currentLine=49283113;
 //BA.debugLineNum = 49283113;BA.debugLine="EscalarViewsFromLayout (ratiox, ratioy)";
__ref._escalarviewsfromlayout /*String*/ (null,_ratiox,_ratioy);
RDebugUtils.currentLine=49283116;
 //BA.debugLineNum = 49283116;BA.debugLine="lastRatioX = ratiox";
__ref._lastratiox /*float*/  = _ratiox;
RDebugUtils.currentLine=49283117;
 //BA.debugLineNum = 49283117;BA.debugLine="lastRatioY = ratioy";
__ref._lastratioy /*float*/  = _ratioy;
RDebugUtils.currentLine=49283118;
 //BA.debugLineNum = 49283118;BA.debugLine="lastPctScreen = pctScreen";
__ref._lastpctscreen /*float*/  = _pctscreen;
RDebugUtils.currentLine=49283119;
 //BA.debugLineNum = 49283119;BA.debugLine="End Sub";
return "";
}
public String  _scalelayouttodevicesizepercent(ng.dsoftlab.stegocam.simplescale __ref,float _pctscreen) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "scalelayouttodevicesizepercent", false))
	 {return ((String) Debug.delegate(ba, "scalelayouttodevicesizepercent", new Object[] {_pctscreen}));}
RDebugUtils.currentLine=49217536;
 //BA.debugLineNum = 49217536;BA.debugLine="Public Sub ScaleLayoutToDeviceSizePercent (pctScre";
RDebugUtils.currentLine=49217537;
 //BA.debugLineNum = 49217537;BA.debugLine="If pctScreen < 0 Then";
if (_pctscreen<0) { 
RDebugUtils.currentLine=49217538;
 //BA.debugLineNum = 49217538;BA.debugLine="pctScreen = 0";
_pctscreen = (float) (0);
 };
RDebugUtils.currentLine=49217542;
 //BA.debugLineNum = 49217542;BA.debugLine="ScaleTo (pctScreen)";
__ref._scaleto /*String*/ (null,_pctscreen);
RDebugUtils.currentLine=49217543;
 //BA.debugLineNum = 49217543;BA.debugLine="End Sub";
return "";
}
public String  _verticalcentercontainer(ng.dsoftlab.stegocam.simplescale __ref,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
__ref = this;
RDebugUtils.currentModule="simplescale";
if (Debug.shouldDelegate(ba, "verticalcentercontainer", false))
	 {return ((String) Debug.delegate(ba, "verticalcentercontainer", new Object[] {_v}));}
RDebugUtils.currentLine=49545216;
 //BA.debugLineNum = 49545216;BA.debugLine="Public Sub VerticalCenterContainer ( v As View)";
RDebugUtils.currentLine=49545217;
 //BA.debugLineNum = 49545217;BA.debugLine="v.Top = (container.Height - v.Height) / 2";
_v.setTop((int) ((__ref._container /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()-_v.getHeight())/(double)2));
RDebugUtils.currentLine=49545218;
 //BA.debugLineNum = 49545218;BA.debugLine="End Sub";
return "";
}
}