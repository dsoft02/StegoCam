package ng.dsoftlab.stegocam.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_decode{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[decode/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 8;BA.debugLine="pnlCoverImage.HorizontalCenter=50%x"[decode/General script]
views.get("pnlcoverimage").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlcoverimage").vw.getWidth() / 2)));
//BA.debugLineNum = 9;BA.debugLine="btnCamera.HorizontalCenter=50%x"[decode/General script]
views.get("btncamera").vw.setLeft((int)((50d / 100 * width) - (views.get("btncamera").vw.getWidth() / 2)));
//BA.debugLineNum = 12;BA.debugLine="If ActivitySize > 6.5 Then"[decode/General script]
if ((anywheresoftware.b4a.keywords.LayoutBuilder.getScreenSize()>6.5d)) { 
;
//BA.debugLineNum = 13;BA.debugLine="ACToolBarLight1.Height = 64dip"[decode/General script]
views.get("actoolbarlight1").vw.setHeight((int)((64d * scale)));
//BA.debugLineNum = 14;BA.debugLine="Else"[decode/General script]
;}else{ 
;
//BA.debugLineNum = 15;BA.debugLine="If Portrait Then"[decode/General script]
if ((BA.ObjectToBoolean( String.valueOf(anywheresoftware.b4a.keywords.LayoutBuilder.isPortrait())))) { 
;
//BA.debugLineNum = 16;BA.debugLine="ACToolBarLight1.Height = 48dip"[decode/General script]
views.get("actoolbarlight1").vw.setHeight((int)((48d * scale)));
//BA.debugLineNum = 17;BA.debugLine="Else"[decode/General script]
;}else{ 
;
//BA.debugLineNum = 18;BA.debugLine="ACToolBarLight1.Height = 48dip"[decode/General script]
views.get("actoolbarlight1").vw.setHeight((int)((48d * scale)));
//BA.debugLineNum = 19;BA.debugLine="End If"[decode/General script]
;};
//BA.debugLineNum = 20;BA.debugLine="End If"[decode/General script]
;};

}
}