package ng.dsoftlab.stegocam.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_pinchange{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("user_img").vw.setTop((int)((views.get("user_panel").vw.getHeight())/2d-(views.get("user_img").vw.getHeight())/2d));
views.get("lblshowpswd").vw.setTop((int)((views.get("user_panel").vw.getHeight())/2d-(views.get("lblshowpswd").vw.getHeight())/2d));
views.get("imgicon").vw.setLeft((int)((views.get("pnlcontainer").vw.getWidth())/2d-(views.get("imgicon").vw.getWidth())/2d));
views.get("imageview1").vw.setTop((int)((views.get("panel1").vw.getHeight())/2d-(views.get("imageview1").vw.getHeight())/2d));
views.get("lblshowpswd2").vw.setTop((int)((views.get("panel1").vw.getHeight())/2d-(views.get("lblshowpswd2").vw.getHeight())/2d));
views.get("imageview2").vw.setTop((int)((views.get("panel2").vw.getHeight())/2d-(views.get("imageview2").vw.getHeight())/2d));
views.get("lblshowpswd3").vw.setTop((int)((views.get("panel2").vw.getHeight())/2d-(views.get("lblshowpswd3").vw.getHeight())/2d));
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
;};

}
}