package ng.dsoftlab.stegocam.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_history{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
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
views.get("b4xtable1").vw.setTop((int)((views.get("actoolbarlight1").vw.getTop())+(views.get("actoolbarlight1").vw.getHeight())));
//BA.debugLineNum = 15;BA.debugLine="btnPrev.Top=B4XTable1.Height/2-btnPrev.Height/2"[history/General script]
views.get("btnprev").vw.setTop((int)((views.get("b4xtable1").vw.getHeight())/2d-(views.get("btnprev").vw.getHeight())/2d));
//BA.debugLineNum = 16;BA.debugLine="btnNext.Top=B4XTable1.Height/2-btnNext.Height/2"[history/General script]
views.get("btnnext").vw.setTop((int)((views.get("b4xtable1").vw.getHeight())/2d-(views.get("btnnext").vw.getHeight())/2d));

}
}