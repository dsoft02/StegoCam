package ng.dsoftlab.stegocam.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_encode{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pnlcoverimage").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlcoverimage").vw.getWidth() / 2)));
views.get("btncamera").vw.setLeft((int)((50d / 100 * width) - (views.get("btncamera").vw.getWidth() / 2)));
if ((anywheresoftware.b4a.keywords.LayoutBuilder.getScreenSize()>6.5d)) { 
;
views.get("actoolbarlight1").vw.setHeight((int)((64d * scale)));
;}else{ 
;
if ((BA.ObjectToBoolean( String.valueOf(anywheresoftware.b4a.keywords.LayoutBuilder.isPortrait())))) { 
;
views.get("actoolbarlight1").vw.setHeight((int)((48d * scale)));
;}else{ 
;
views.get("actoolbarlight1").vw.setHeight((int)((48d * scale)));
;};
//BA.debugLineNum = 20;BA.debugLine="End If"[encode/General script]
;};

}
}