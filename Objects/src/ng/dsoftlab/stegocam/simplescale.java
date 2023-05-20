package ng.dsoftlab.stegocam;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class simplescale extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "ng.dsoftlab.stegocam.simplescale");
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

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.keywords.LayoutValues _layvalues = null;
public anywheresoftware.b4a.objects.collections.List _initialattribs = null;
public boolean _hastitle = false;
public boolean _isfullscreen = false;
public anywheresoftware.b4a.objects.PanelWrapper _container = null;
public float _lastratiox = 0f;
public float _lastratioy = 0f;
public float _lastpctscreen = 0f;
public ng.dsoftlab.stegocam.main _main = null;
public ng.dsoftlab.stegocam.starter _starter = null;
public ng.dsoftlab.stegocam.mainmenu _mainmenu = null;
public ng.dsoftlab.stegocam.config _config = null;
public ng.dsoftlab.stegocam.login _login = null;
public ng.dsoftlab.stegocam.pinsetup _pinsetup = null;
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
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private layValues As LayoutValues";
_layvalues = new anywheresoftware.b4a.keywords.LayoutValues();
 //BA.debugLineNum = 22;BA.debugLine="Private initialAttribs As List";
_initialattribs = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 23;BA.debugLine="Private hasTitle As Boolean";
_hastitle = false;
 //BA.debugLineNum = 24;BA.debugLine="Private isFullScreen As Boolean";
_isfullscreen = false;
 //BA.debugLineNum = 25;BA.debugLine="Private container As Panel";
_container = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Public lastRatioX As Float";
_lastratiox = 0f;
 //BA.debugLineNum = 27;BA.debugLine="Public lastRatioY As Float";
_lastratioy = 0f;
 //BA.debugLineNum = 28;BA.debugLine="Public lastPctScreen As Float";
_lastpctscreen = 0f;
 //BA.debugLineNum = 32;BA.debugLine="Type ViewAttribs ( _ 		top, left As Int, _ 		widt";
;
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _escalarview(anywheresoftware.b4a.objects.ConcreteViewWrapper _v,ng.dsoftlab.stegocam.simplescale._viewattribs _attribs,float _ratiox,float _ratioy) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lb = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 225;BA.debugLine="Private Sub escalarView (v As View, attribs As Vie";
 //BA.debugLineNum = 226;BA.debugLine="v.Left = attribs.left  * ratiox";
_v.setLeft((int) (_attribs.left /*int*/ *_ratiox));
 //BA.debugLineNum = 227;BA.debugLine="v.Top = attribs.Top   * ratioy";
_v.setTop((int) (_attribs.top /*int*/ *_ratioy));
 //BA.debugLineNum = 228;BA.debugLine="v.Width = attribs.Width * ratiox";
_v.setWidth((int) (_attribs.width /*int*/ *_ratiox));
 //BA.debugLineNum = 229;BA.debugLine="v.Height = attribs.Height  * ratioy";
_v.setHeight((int) (_attribs.height /*int*/ *_ratioy));
 //BA.debugLineNum = 230;BA.debugLine="If v Is Label Then";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 231;BA.debugLine="Dim lb As Label";
_lb = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 232;BA.debugLine="lb = v";
_lb = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 234;BA.debugLine="lb.TextSize = attribs.textSize * (ratiox + rati";
_lb.setTextSize((float) (_attribs.textSize /*float*/ *(_ratiox+_ratioy)/(double)2));
 };
 //BA.debugLineNum = 236;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Sp";
if ((__c.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 237;BA.debugLine="Dim spn As Spinner = v";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
_spn = (anywheresoftware.b4a.objects.SpinnerWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.SpinnerWrapper(), (anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 238;BA.debugLine="spn = v";
_spn = (anywheresoftware.b4a.objects.SpinnerWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.SpinnerWrapper(), (anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 240;BA.debugLine="spn.TextSize = attribs.textSize * (ratiox + rat";
_spn.setTextSize((float) (_attribs.textSize /*float*/ *(_ratiox+_ratioy)/(double)2));
 };
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public String  _escalarviewsfromlayout(float _ratiox,float _ratioy) throws Exception{
int _i = 0;
ng.dsoftlab.stegocam.simplescale._viewattribs _attribs = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 191;BA.debugLine="Private Sub EscalarViewsFromLayout (ratiox As Floa";
 //BA.debugLineNum = 192;BA.debugLine="Log (\"Iniciando EscalarViewsFromLayout \" & \" free";
__c.LogImpl("35177345","Iniciando EscalarViewsFromLayout "+" freeX = "+" layoutvalues = "+BA.ObjectToString(_layvalues),0);
 //BA.debugLineNum = 202;BA.debugLine="Log(\"Numero de views: \" & container.NumberOfViews";
__c.LogImpl("35177355","Numero de views: "+BA.NumberToString(_container.getNumberOfViews()),0);
 //BA.debugLineNum = 203;BA.debugLine="Dim i As Int, attribs As ViewAttribs";
_i = 0;
_attribs = new ng.dsoftlab.stegocam.simplescale._viewattribs();
 //BA.debugLineNum = 206;BA.debugLine="i=0: For Each v As View In container.GetAllVie";
_i = (int) (0);
 //BA.debugLineNum = 206;BA.debugLine="i=0: For Each v As View In container.GetAllVie";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group5 = _container.GetAllViewsRecursive();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group5.Get(index5)));
 //BA.debugLineNum = 208;BA.debugLine="If v.Tag <> Null And (v.Tag = \"dontresize\") Then";
if (_v.getTag()!= null && ((_v.getTag()).equals((Object)("dontresize")))) { 
 //BA.debugLineNum = 209;BA.debugLine="Continue";
if (true) continue;
 }else {
 //BA.debugLineNum = 211;BA.debugLine="Try 'Fazemos um try-catch porque atributos de v";
try { //BA.debugLineNum = 212;BA.debugLine="attribs = initialAttribs.Get(i)";
_attribs = (ng.dsoftlab.stegocam.simplescale._viewattribs)(_initialattribs.Get(_i));
 //BA.debugLineNum = 213;BA.debugLine="escalarView (v, attribs, ratiox, ratioy)";
_escalarview(_v,_attribs,_ratiox,_ratioy);
 } 
       catch (Exception e13) {
			ba.setLastException(e13); //BA.debugLineNum = 215;BA.debugLine="Log(\"Erro ao acessar posicoes da suposta view:";
__c.LogImpl("35177368","Erro ao acessar posicoes da suposta view: "+BA.ObjectToString(_v),0);
 };
 };
 //BA.debugLineNum = 218;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 }
};
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return "";
}
public float  _getdevicephysicalsize() throws Exception{
anywheresoftware.b4a.keywords.LayoutValues _lv = null;
 //BA.debugLineNum = 107;BA.debugLine="Public Sub GetDevicePhysicalSize As Float";
 //BA.debugLineNum = 108;BA.debugLine="Dim lv As LayoutValues";
_lv = new anywheresoftware.b4a.keywords.LayoutValues();
 //BA.debugLineNum = 109;BA.debugLine="lv = GetDeviceLayoutValues";
_lv = __c.GetDeviceLayoutValues(ba);
 //BA.debugLineNum = 110;BA.debugLine="Return Sqrt(Power(lv.Height / lv.Scale / 160, 2)";
if (true) return (float) (__c.Sqrt(__c.Power(_lv.Height/(double)_lv.Scale/(double)160,2)+__c.Power(_lv.Width/(double)_lv.Scale/(double)160,2)));
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return 0f;
}
public String  _guardaratributosoriginais() throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
ng.dsoftlab.stegocam.simplescale._viewattribs _attribs = null;
 //BA.debugLineNum = 60;BA.debugLine="Public  Sub GuardarAtributosOriginais";
 //BA.debugLineNum = 61;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 62;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 63;BA.debugLine="For Each v As View In container.GetAllViewsRec";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _container.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
 //BA.debugLineNum = 64;BA.debugLine="If v.Tag <> Null And (v.Tag = \"dontresize\") Then";
if (_v.getTag()!= null && ((_v.getTag()).equals((Object)("dontresize")))) { 
 //BA.debugLineNum = 65;BA.debugLine="Continue";
if (true) continue;
 }else {
 //BA.debugLineNum = 67;BA.debugLine="Try 'Fazemos um try-catch porque atributos de v";
try { //BA.debugLineNum = 68;BA.debugLine="Dim attribs As ViewAttribs";
_attribs = new ng.dsoftlab.stegocam.simplescale._viewattribs();
 //BA.debugLineNum = 69;BA.debugLine="attribs = guardarAttribsView(v)";
_attribs = _guardarattribsview(_v);
 //BA.debugLineNum = 71;BA.debugLine="lst.Add (attribs)";
_lst.Add((Object)(_attribs));
 } 
       catch (Exception e12) {
			ba.setLastException(e12); //BA.debugLineNum = 73;BA.debugLine="Log(\"Erro ao acessar posicoes da suposta view:";
__c.LogImpl("34784141","Erro ao acessar posicoes da suposta view: "+BA.ObjectToString(_v),0);
 };
 };
 }
};
 //BA.debugLineNum = 77;BA.debugLine="initialAttribs = lst";
_initialattribs = _lst;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public ng.dsoftlab.stegocam.simplescale._viewattribs  _guardarattribsview(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
ng.dsoftlab.stegocam.simplescale._viewattribs _attribs = null;
anywheresoftware.b4a.objects.LabelWrapper _lb = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 82;BA.debugLine="Private Sub guardarAttribsView (v As View)  As Vie";
 //BA.debugLineNum = 83;BA.debugLine="Dim attribs As ViewAttribs";
_attribs = new ng.dsoftlab.stegocam.simplescale._viewattribs();
 //BA.debugLineNum = 84;BA.debugLine="Dim lb As Label : Dim spn As Spinner";
_lb = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 84;BA.debugLine="Dim lb As Label : Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 85;BA.debugLine="attribs.Initialize";
_attribs.Initialize();
 //BA.debugLineNum = 86;BA.debugLine="attribs.left = v.Left";
_attribs.left /*int*/  = _v.getLeft();
 //BA.debugLineNum = 87;BA.debugLine="attribs.Top = v.Top";
_attribs.top /*int*/  = _v.getTop();
 //BA.debugLineNum = 88;BA.debugLine="attribs.Width = v.Width";
_attribs.width /*int*/  = _v.getWidth();
 //BA.debugLineNum = 89;BA.debugLine="attribs.Height = v.Height";
_attribs.height /*int*/  = _v.getHeight();
 //BA.debugLineNum = 90;BA.debugLine="If v Is Label Then 'isso pega varios tipos de ob";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 91;BA.debugLine="lb = v";
_lb = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 92;BA.debugLine="attribs.textSize = lb.TextSize";
_attribs.textSize /*float*/  = _lb.getTextSize();
 };
 //BA.debugLineNum = 94;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Sp";
if ((__c.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 95;BA.debugLine="spn = v";
_spn = (anywheresoftware.b4a.objects.SpinnerWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.SpinnerWrapper(), (anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 96;BA.debugLine="attribs.textSize = spn.TextSize";
_attribs.textSize /*float*/  = _spn.getTextSize();
 };
 //BA.debugLineNum = 98;BA.debugLine="Return attribs";
if (true) return _attribs;
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return null;
}
public String  _horizontalcentercontainer(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Public Sub HorizontalCenterContainer ( v As View)";
 //BA.debugLineNum = 249;BA.debugLine="v.Left = (container.Width - v.Width) / 2";
_v.setLeft((int) ((_container.getWidth()-_v.getWidth())/(double)2));
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _acontainer,anywheresoftware.b4a.keywords.LayoutValues _alayvalues,boolean _ahastitle,boolean _aisfullscreen) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 48;BA.debugLine="Public Sub Initialize(aContainer As Panel, aLayVal";
 //BA.debugLineNum = 49;BA.debugLine="container = aContainer";
_container = _acontainer;
 //BA.debugLineNum = 50;BA.debugLine="layValues = aLayValues";
_layvalues = _alayvalues;
 //BA.debugLineNum = 51;BA.debugLine="lastRatioX = 1";
_lastratiox = (float) (1);
 //BA.debugLineNum = 52;BA.debugLine="lastRatioY = 1";
_lastratioy = (float) (1);
 //BA.debugLineNum = 53;BA.debugLine="hasTitle = aHasTitle";
_hastitle = _ahastitle;
 //BA.debugLineNum = 54;BA.debugLine="isFullScreen = aIsFullScreen";
_isfullscreen = _aisfullscreen;
 //BA.debugLineNum = 55;BA.debugLine="GuardarAtributosOriginais 'guarda os atributos OR";
_guardaratributosoriginais();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _scalelayouttodevicesize() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Public Sub ScaleLayoutToDeviceSize";
 //BA.debugLineNum = 121;BA.debugLine="ScaleTo (1)  'Escala para 100% do tamanho da tela";
_scaleto((float) (1));
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _scalelayouttodevicesizepercent(float _pctscreen) throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Public Sub ScaleLayoutToDeviceSizePercent (pctScre";
 //BA.debugLineNum = 127;BA.debugLine="If pctScreen < 0 Then";
if (_pctscreen<0) { 
 //BA.debugLineNum = 128;BA.debugLine="pctScreen = 0";
_pctscreen = (float) (0);
 };
 //BA.debugLineNum = 132;BA.debugLine="ScaleTo (pctScreen)";
_scaleto(_pctscreen);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _scaleto(float _pctscreen) throws Exception{
double _devicescale = 0;
int _deslocamentotitle = 0;
int _deslocamentofullscreen = 0;
float _ratiox = 0f;
float _ratioy = 0f;
 //BA.debugLineNum = 137;BA.debugLine="Public Sub ScaleTo (pctScreen As Float )";
 //BA.debugLineNum = 138;BA.debugLine="Dim DeviceScale As Double";
_devicescale = 0;
 //BA.debugLineNum = 139;BA.debugLine="DeviceScale = 160dip / 160";
_devicescale = __c.DipToCurrent((int) (160))/(double)160;
 //BA.debugLineNum = 140;BA.debugLine="Dim deslocamentoTitle As Int = 0";
_deslocamentotitle = (int) (0);
 //BA.debugLineNum = 141;BA.debugLine="Dim deslocamentoFullScreen As Int = 0";
_deslocamentofullscreen = (int) (0);
 //BA.debugLineNum = 143;BA.debugLine="Dim ratiox, ratioy As Float";
_ratiox = 0f;
_ratioy = 0f;
 //BA.debugLineNum = 150;BA.debugLine="If hasTitle = True Then";
if (_hastitle==__c.True) { 
 //BA.debugLineNum = 151;BA.debugLine="deslocamentoTitle = 25";
_deslocamentotitle = (int) (25);
 }else {
 //BA.debugLineNum = 153;BA.debugLine="deslocamentoTitle = 0";
_deslocamentotitle = (int) (0);
 };
 //BA.debugLineNum = 156;BA.debugLine="If isFullScreen = True Then";
if (_isfullscreen==__c.True) { 
 //BA.debugLineNum = 157;BA.debugLine="deslocamentoFullScreen = 0";
_deslocamentofullscreen = (int) (0);
 }else {
 //BA.debugLineNum = 159;BA.debugLine="deslocamentoFullScreen = 25";
_deslocamentofullscreen = (int) (25);
 };
 //BA.debugLineNum = 165;BA.debugLine="Log (\"Layout width = \" & layValues.Width)";
__c.LogImpl("35111836","Layout width = "+BA.NumberToString(_layvalues.Width),0);
 //BA.debugLineNum = 166;BA.debugLine="Log (\"Layout height = \" & layValues.Height)";
__c.LogImpl("35111837","Layout height = "+BA.NumberToString(_layvalues.Height),0);
 //BA.debugLineNum = 168;BA.debugLine="ratiox = 100%x/layValues.Width/layValues.Scale";
_ratiox = (float) (__c.PerXToCurrent((float) (100),ba)/(double)_layvalues.Width/(double)_layvalues.Scale/(double)_devicescale);
 //BA.debugLineNum = 169;BA.debugLine="ratioy = 100%y / (layValues.Height - deslocamento";
_ratioy = (float) (__c.PerYToCurrent((float) (100),ba)/(double)(_layvalues.Height-_deslocamentotitle-_deslocamentofullscreen)/(double)_layvalues.Scale/(double)_devicescale);
 //BA.debugLineNum = 173;BA.debugLine="ratiox = ratiox * pctScreen";
_ratiox = (float) (_ratiox*_pctscreen);
 //BA.debugLineNum = 174;BA.debugLine="ratioy = ratioy * pctScreen";
_ratioy = (float) (_ratioy*_pctscreen);
 //BA.debugLineNum = 175;BA.debugLine="Log (\"ratiox = \" & ratiox)";
__c.LogImpl("35111846","ratiox = "+BA.NumberToString(_ratiox),0);
 //BA.debugLineNum = 176;BA.debugLine="Log (\"ratioy = \" & ratioy)";
__c.LogImpl("35111847","ratioy = "+BA.NumberToString(_ratioy),0);
 //BA.debugLineNum = 178;BA.debugLine="EscalarViewsFromLayout (ratiox, ratioy)";
_escalarviewsfromlayout(_ratiox,_ratioy);
 //BA.debugLineNum = 181;BA.debugLine="lastRatioX = ratiox";
_lastratiox = _ratiox;
 //BA.debugLineNum = 182;BA.debugLine="lastRatioY = ratioy";
_lastratioy = _ratioy;
 //BA.debugLineNum = 183;BA.debugLine="lastPctScreen = pctScreen";
_lastpctscreen = _pctscreen;
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public String  _verticalcentercontainer(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Public Sub VerticalCenterContainer ( v As View)";
 //BA.debugLineNum = 254;BA.debugLine="v.Top = (container.Height - v.Height) / 2";
_v.setTop((int) ((_container.getHeight()-_v.getHeight())/(double)2));
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
