package ng.dsoftlab.stegocam;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bctoast_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public pnl As B4XView";
bctoast._pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_pnl",bctoast._pnl);
 //BA.debugLineNum = 3;BA.debugLine="Private xui As XUI";
bctoast._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");__ref.setField("_xui",bctoast._xui);
 //BA.debugLineNum = 4;BA.debugLine="Private ShowIndex As Int";
bctoast._showindex = RemoteObject.createImmutable(0);__ref.setField("_showindex",bctoast._showindex);
 //BA.debugLineNum = 5;BA.debugLine="Public BB1 As BBLabel";
bctoast._bb1 = RemoteObject.createNew ("ng.dsoftlab.stegocam.bblabel");__ref.setField("_bb1",bctoast._bb1);
 //BA.debugLineNum = 6;BA.debugLine="Private te As BCTextEngine";
bctoast._te = RemoteObject.createNew ("ng.dsoftlab.stegocam.bctextengine");__ref.setField("_te",bctoast._te);
 //BA.debugLineNum = 7;BA.debugLine="Private iv As B4XView";
bctoast._iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_iv",bctoast._iv);
 //BA.debugLineNum = 8;BA.debugLine="Public DurationMs As Int = 3000";
bctoast._durationms = BA.numberCast(int.class, 3000);__ref.setField("_durationms",bctoast._durationms);
 //BA.debugLineNum = 9;BA.debugLine="Public DefaultTextColor As Int = 0xFF3E3E3E";
bctoast._defaulttextcolor = BA.numberCast(int.class, ((int)0xff3e3e3e));__ref.setField("_defaulttextcolor",bctoast._defaulttextcolor);
 //BA.debugLineNum = 10;BA.debugLine="Public PaddingSides As Int = 15dip";
bctoast._paddingsides = bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)));__ref.setField("_paddingsides",bctoast._paddingsides);
 //BA.debugLineNum = 11;BA.debugLine="Public PaddingTopBottom As Int = 10dip";
bctoast._paddingtopbottom = bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));__ref.setField("_paddingtopbottom",bctoast._paddingtopbottom);
 //BA.debugLineNum = 12;BA.debugLine="Public MaxHeight As Int = 100dip";
bctoast._maxheight = bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));__ref.setField("_maxheight",bctoast._maxheight);
 //BA.debugLineNum = 13;BA.debugLine="Public VerticalCenterPercentage As Int = 85";
bctoast._verticalcenterpercentage = BA.numberCast(int.class, 85);__ref.setField("_verticalcenterpercentage",bctoast._verticalcenterpercentage);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _parent) throws Exception{
try {
		Debug.PushSubsStack("Initialize (bctoast) ","bctoast",27,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bctoast","initialize", __ref, _ba, _parent);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("ba", _ba);
Debug.locals.put("Parent", _parent);
 BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize (Parent As B4XView)";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 17;BA.debugLine="pnl = xui.CreatePanel(\"\")";
Debug.JustUpdateDeviceLine();
__ref.setField ("_pnl" /*RemoteObject*/ ,__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(false,"CreatePanel",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 18;BA.debugLine="Parent.AddView(pnl, 0, 0, Parent.Width - 30dip, M";
Debug.JustUpdateDeviceLine();
_parent.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_pnl" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_parent.runMethod(true,"getWidth"),bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(__ref.getField(true,"_maxheight" /*RemoteObject*/ )));
 BA.debugLineNum = 19;BA.debugLine="pnl.LoadLayout(\"BCToast\")";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("BCToast")),__ref.getField(false, "ba"));
 BA.debugLineNum = 20;BA.debugLine="pnl.SetColorAndBorder(0xFFC3C3C3, 0dip, xui.Color";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("SetColorAndBorder",(Object)(BA.numberCast(int.class, ((int)0xffc3c3c3))),(Object)(bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(__ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_White")),(Object)(bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 21;BA.debugLine="pnl.Visible = False";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(true,"setVisible",bctoast.__c.getField(true,"False"));
 BA.debugLineNum = 22;BA.debugLine="te.Initialize(pnl)";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_te" /*RemoteObject*/ ).runClassMethod (ng.dsoftlab.stegocam.bctextengine.class, "_initialize" /*RemoteObject*/ ,__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_pnl" /*RemoteObject*/ )));
 BA.debugLineNum = 23;BA.debugLine="iv = BB1.mBase.GetView(0)";
Debug.JustUpdateDeviceLine();
__ref.setField ("_iv" /*RemoteObject*/ ,__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 24;BA.debugLine="iv.RemoveViewFromParent";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_iv" /*RemoteObject*/ ).runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 25;BA.debugLine="BB1.DisableResizeEvent = True";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bb1" /*RemoteObject*/ ).setField ("_disableresizeevent" /*RemoteObject*/ ,bctoast.__c.getField(true,"True"));
 BA.debugLineNum = 27;BA.debugLine="Dim p As Panel = pnl";
Debug.JustUpdateDeviceLine();
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), __ref.getField(false,"_pnl" /*RemoteObject*/ ).getObject());Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 28;BA.debugLine="p.Elevation = 5dip";
Debug.JustUpdateDeviceLine();
_p.runMethod(true,"setElevation",BA.numberCast(float.class, bctoast.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _show(RemoteObject __ref,RemoteObject _message) throws Exception{
try {
		Debug.PushSubsStack("Show (bctoast) ","bctoast",27,__ref.getField(false, "ba"),__ref,33);
if (RapidSub.canDelegate("show")) { __ref.runUserSub(false, "bctoast","show", __ref, _message); return;}
ResumableSub_Show rsub = new ResumableSub_Show(null,__ref,_message);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Show extends BA.ResumableSub {
public ResumableSub_Show(ng.dsoftlab.stegocam.bctoast parent,RemoteObject __ref,RemoteObject _message) {
this.parent = parent;
this.__ref = __ref;
this._message = _message;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
ng.dsoftlab.stegocam.bctoast parent;
RemoteObject _message;
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _w = RemoteObject.createImmutable(0);
RemoteObject _h = RemoteObject.createImmutable(0);
RemoteObject _parent = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _newleft = RemoteObject.createImmutable(0);
RemoteObject _dx = RemoteObject.createImmutable(0);
RemoteObject _dy = RemoteObject.createImmutable(0);
RemoteObject _myindex = RemoteObject.createImmutable(0);
RemoteObject group3;
int index3;
int groupLen3;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Show (bctoast) ","bctoast",27,__ref.getField(false, "ba"),__ref,33);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
Debug.locals.put("Message", _message);
 BA.debugLineNum = 34;BA.debugLine="BB1.ParseData.DefaultColor = DefaultTextColor";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_parsedata" /*RemoteObject*/ ).setField ("DefaultColor" /*RemoteObject*/ ,__ref.getField(true,"_defaulttextcolor" /*RemoteObject*/ ));
 BA.debugLineNum = 35;BA.debugLine="iv.RemoveViewFromParent";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_iv" /*RemoteObject*/ ).runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 36;BA.debugLine="For Each v As B4XView In pnl.GetAllViewsRecursive";
Debug.JustUpdateDeviceLine();
if (true) break;

case 1:
//for
this.state = 10;
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
group3 = __ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(false,"GetAllViewsRecursive");
index3 = 0;
groupLen3 = group3.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("v", _v);
this.state = 19;
if (true) break;

case 19:
//C
this.state = 10;
if (index3 < groupLen3) {
this.state = 3;
_v = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), group3.runMethod(false,"Get",index3));Debug.locals.put("v", _v);}
if (true) break;

case 20:
//C
this.state = 19;
index3++;
Debug.locals.put("v", _v);
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 37;BA.debugLine="If v.Tag = \"to remove\" Then v.RemoveViewFromPare";
Debug.JustUpdateDeviceLine();
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",_v.runMethod(false,"getTag"),RemoteObject.createImmutable(("to remove")))) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
_v.runVoidMethod ("RemoveViewFromParent");
if (true) break;

case 9:
//C
this.state = 20;
;
 if (true) break;
if (true) break;

case 10:
//C
this.state = 11;
Debug.locals.put("v", _v);
;
 BA.debugLineNum = 39;BA.debugLine="pnl.Width = pnl.Parent.Width - 2 * PaddingSides";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(false,"getParent").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),__ref.getField(true,"_paddingsides" /*RemoteObject*/ )}, "-*",1, 1));
 BA.debugLineNum = 40;BA.debugLine="pnl.Height = MaxHeight";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(true,"setHeight",__ref.getField(true,"_maxheight" /*RemoteObject*/ ));
 BA.debugLineNum = 41;BA.debugLine="BB1.mBase.Width = pnl.Width";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setWidth",__ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(true,"getWidth"));
 BA.debugLineNum = 42;BA.debugLine="BB1.mBase.Height = pnl.Height";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setHeight",__ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(true,"getHeight"));
 BA.debugLineNum = 43;BA.debugLine="BB1.mBase.AddView(iv, 0, 0, BB1.mBase.Width, BB1.";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_iv" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 44;BA.debugLine="BB1.Text = Message";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bb1" /*RemoteObject*/ ).runClassMethod (ng.dsoftlab.stegocam.bblabel.class, "_settext" /*RemoteObject*/ ,_message);
 BA.debugLineNum = 45;BA.debugLine="Dim iv As B4XView = BB1.mBase.GetView(0)";
Debug.JustUpdateDeviceLine();
parent._iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
parent._iv = __ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0)));__ref.setField("_iv",parent._iv);
 BA.debugLineNum = 46;BA.debugLine="iv.RemoveViewFromParent";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_iv" /*RemoteObject*/ ).runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 47;BA.debugLine="Dim w As Int = iv.Width + 2 * PaddingSides";
Debug.JustUpdateDeviceLine();
_w = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_iv" /*RemoteObject*/ ).runMethod(true,"getWidth"),RemoteObject.createImmutable(2),__ref.getField(true,"_paddingsides" /*RemoteObject*/ )}, "+*",1, 1);Debug.locals.put("w", _w);Debug.locals.put("w", _w);
 BA.debugLineNum = 48;BA.debugLine="Dim h As Int = iv.Height + 2 * PaddingTopBottom";
Debug.JustUpdateDeviceLine();
_h = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_iv" /*RemoteObject*/ ).runMethod(true,"getHeight"),RemoteObject.createImmutable(2),__ref.getField(true,"_paddingtopbottom" /*RemoteObject*/ )}, "+*",1, 1);Debug.locals.put("h", _h);Debug.locals.put("h", _h);
 BA.debugLineNum = 49;BA.debugLine="Dim Parent As B4XView = pnl.Parent";
Debug.JustUpdateDeviceLine();
_parent = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_parent = __ref.getField(false,"_pnl" /*RemoteObject*/ ).runMethod(false,"getParent");Debug.locals.put("Parent", _parent);Debug.locals.put("Parent", _parent);
 BA.debugLineNum = 50;BA.debugLine="Dim NewLeft As Int = Parent.Width / 2 - w / 2";
Debug.JustUpdateDeviceLine();
_newleft = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_parent.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),_w,RemoteObject.createImmutable(2)}, "/-/",1, 0));Debug.locals.put("NewLeft", _newleft);Debug.locals.put("NewLeft", _newleft);
 BA.debugLineNum = 51;BA.debugLine="pnl.SetLayoutAnimated(0, NewLeft, Parent.Height *";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(_newleft),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_parent.runMethod(true,"getHeight"),__ref.getField(true,"_verticalcenterpercentage" /*RemoteObject*/ ),RemoteObject.createImmutable(100),_h,RemoteObject.createImmutable(2)}, "*/-/",1, 0))),(Object)(_w),(Object)(_h));
 BA.debugLineNum = 52;BA.debugLine="pnl.BringToFront";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("BringToFront");
 BA.debugLineNum = 53;BA.debugLine="Dim dx As Int = PaddingSides - iv.Left";
Debug.JustUpdateDeviceLine();
_dx = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_paddingsides" /*RemoteObject*/ ),__ref.getField(false,"_iv" /*RemoteObject*/ ).runMethod(true,"getLeft")}, "-",1, 1);Debug.locals.put("dx", _dx);Debug.locals.put("dx", _dx);
 BA.debugLineNum = 54;BA.debugLine="Dim dy As Int = PaddingTopBottom - iv.Top";
Debug.JustUpdateDeviceLine();
_dy = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_paddingtopbottom" /*RemoteObject*/ ),__ref.getField(false,"_iv" /*RemoteObject*/ ).runMethod(true,"getTop")}, "-",1, 1);Debug.locals.put("dy", _dy);Debug.locals.put("dy", _dy);
 BA.debugLineNum = 55;BA.debugLine="pnl.AddView(iv, PaddingSides, PaddingTopBottom, i";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_iv" /*RemoteObject*/ ).getObject())),(Object)(__ref.getField(true,"_paddingsides" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_paddingtopbottom" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_iv" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_iv" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 57;BA.debugLine="Do While BB1.mBase.NumberOfViews > 0";
Debug.JustUpdateDeviceLine();
if (true) break;

case 11:
//do while
this.state = 14;
while (RemoteObject.solveBoolean(">",__ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getNumberOfViews"),BA.numberCast(double.class, 0))) {
this.state = 13;
if (true) break;
}
if (true) break;

case 13:
//C
this.state = 11;
 BA.debugLineNum = 58;BA.debugLine="Dim v As B4XView = BB1.mBase.GetView(0)";
Debug.JustUpdateDeviceLine();
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_v = __ref.getField(false,"_bb1" /*RemoteObject*/ ).getField(false,"_mbase" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("v", _v);Debug.locals.put("v", _v);
 BA.debugLineNum = 59;BA.debugLine="v.RemoveViewFromParent";
Debug.JustUpdateDeviceLine();
_v.runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 60;BA.debugLine="v.Tag = \"to remove\"";
Debug.JustUpdateDeviceLine();
_v.runMethod(false,"setTag",RemoteObject.createImmutable(("to remove")));
 BA.debugLineNum = 61;BA.debugLine="pnl.AddView(v, dx + v.Left, dy + v.Top, v.Width,";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_v.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_dx,_v.runMethod(true,"getLeft")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_dy,_v.runMethod(true,"getTop")}, "+",1, 1)),(Object)(_v.runMethod(true,"getWidth")),(Object)(_v.runMethod(true,"getHeight")));
 if (true) break;

case 14:
//C
this.state = 15;
;
 BA.debugLineNum = 63;BA.debugLine="pnl.SetVisibleAnimated(200, True)";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.__c.getField(true,"True")));
 BA.debugLineNum = 64;BA.debugLine="ShowIndex = ShowIndex + 1";
Debug.JustUpdateDeviceLine();
__ref.setField ("_showindex" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_showindex" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 65;BA.debugLine="Dim MyIndex As Int = ShowIndex";
Debug.JustUpdateDeviceLine();
_myindex = __ref.getField(true,"_showindex" /*RemoteObject*/ );Debug.locals.put("MyIndex", _myindex);Debug.locals.put("MyIndex", _myindex);
 BA.debugLineNum = 66;BA.debugLine="Sleep(DurationMs)";
Debug.JustUpdateDeviceLine();
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "bctoast", "show"),__ref.getField(true,"_durationms" /*RemoteObject*/ ));
this.state = 21;
return;
case 21:
//C
this.state = 15;
;
 BA.debugLineNum = 67;BA.debugLine="If MyIndex = ShowIndex Then";
Debug.JustUpdateDeviceLine();
if (true) break;

case 15:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",_myindex,BA.numberCast(double.class, __ref.getField(true,"_showindex" /*RemoteObject*/ )))) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 68;BA.debugLine="pnl.SetVisibleAnimated(200, False)";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_pnl" /*RemoteObject*/ ).runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(parent.__c.getField(true,"False")));
 if (true) break;

case 18:
//C
this.state = -1;
;
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
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
}