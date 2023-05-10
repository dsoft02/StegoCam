package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class config {
private static config mostCurrent = new config();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainmenu _mainmenu = null;
public b4a.example.leftmenu _leftmenu = null;
public static String  _ajustimageview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _imv,String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _delta = 0;
int _height = 0;
int _width = 0;
 //BA.debugLineNum = 10;BA.debugLine="Sub AjustImageView(Imv As ImageView, Dir As String";
 //BA.debugLineNum = 11;BA.debugLine="Private bmp As Bitmap = LoadBitmap(Dir, FileName)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(_dir,_filename);
 //BA.debugLineNum = 12;BA.debugLine="Dim Delta, Height, Width As Int";
_delta = 0;
_height = 0;
_width = 0;
 //BA.debugLineNum = 13;BA.debugLine="If bmp.Width / bmp.Height > Imv.Width / Imv.Heigh";
if (_bmp.getWidth()/(double)_bmp.getHeight()>_imv.getWidth()/(double)_imv.getHeight()) { 
 //BA.debugLineNum = 14;BA.debugLine="Height = bmp.Height / bmp.Width * Imv.Width";
_height = (int) (_bmp.getHeight()/(double)_bmp.getWidth()*_imv.getWidth());
 //BA.debugLineNum = 15;BA.debugLine="Delta = (Imv.Height - Height) / 2";
_delta = (int) ((_imv.getHeight()-_height)/(double)2);
 //BA.debugLineNum = 16;BA.debugLine="Imv.Height = Height";
_imv.setHeight(_height);
 //BA.debugLineNum = 17;BA.debugLine="Imv.Top = Imv.Top + Delta";
_imv.setTop((int) (_imv.getTop()+_delta));
 }else {
 //BA.debugLineNum = 19;BA.debugLine="Width = bmp.Width / bmp.Height * Imv.Height";
_width = (int) (_bmp.getWidth()/(double)_bmp.getHeight()*_imv.getHeight());
 //BA.debugLineNum = 20;BA.debugLine="Delta = (Imv.Width - Width) / 2";
_delta = (int) ((_imv.getWidth()-_width)/(double)2);
 //BA.debugLineNum = 21;BA.debugLine="Imv.Width = Width";
_imv.setWidth(_width);
 //BA.debugLineNum = 22;BA.debugLine="Imv.Left = Imv.Left + Delta";
_imv.setLeft((int) (_imv.getLeft()+_delta));
 };
 //BA.debugLineNum = 24;BA.debugLine="Imv.Gravity = Gravity.FILL";
_imv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 25;BA.debugLine="Imv.Bitmap = bmp";
_imv.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.BitmapDrawable  _bitmaptobitmapdrawable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap) throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
 //BA.debugLineNum = 49;BA.debugLine="Sub BitmapToBitmapDrawable (bitmap As Bitmap) As B";
 //BA.debugLineNum = 50;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 51;BA.debugLine="bd.Initialize(bitmap)";
_bd.Initialize((android.graphics.Bitmap)(_bitmap.getObject()));
 //BA.debugLineNum = 52;BA.debugLine="Return bd";
if (true) return _bd;
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusnavbarcolor(anywheresoftware.b4a.BA _ba,int _clr,boolean _dark) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
anywheresoftware.b4j.object.JavaObject _view = null;
 //BA.debugLineNum = 28;BA.debugLine="Sub SetStatusNavBarColor(clr As Int, dark As Boole";
 //BA.debugLineNum = 29;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 30;BA.debugLine="If p.SdkVersion > 20 Then";
if (_p.getSdkVersion()>20) { 
 //BA.debugLineNum = 32;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 33;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 34;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 35;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(((int)0x80000000))});
 //BA.debugLineNum = 36;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(((int)0x04000000))});
 //BA.debugLineNum = 37;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 //BA.debugLineNum = 38;BA.debugLine="window.RunMethod(\"setNavigationBarColor\", Array(";
_window.RunMethod("setNavigationBarColor",new Object[]{(Object)(_clr)});
 //BA.debugLineNum = 39;BA.debugLine="Dim view As JavaObject = window.RunMethodJO(\"get";
_view = new anywheresoftware.b4j.object.JavaObject();
_view = _window.RunMethodJO("getDecorView",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 40;BA.debugLine="If dark=True Then";
if (_dark==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 41;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(Bi";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.Bit.Or(((int)0x00002000),(int)(BA.ObjectToNumber(_view.RunMethod("getSystemUiVisibility",(Object[])(anywheresoftware.b4a.keywords.Common.Null))))))});
 }else {
 //BA.debugLineNum = 43;BA.debugLine="view.RunMethod(\"setSystemUiVisibility\",Array(0)";
_view.RunMethod("setSystemUiVisibility",new Object[]{(Object)(0)});
 };
 };
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
}
