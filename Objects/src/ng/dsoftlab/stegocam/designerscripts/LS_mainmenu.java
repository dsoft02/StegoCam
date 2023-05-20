package ng.dsoftlab.stegocam.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_mainmenu{

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
views.get("panel2").vw.setLeft((int)((views.get("panel1").vw.getWidth())/2d-(views.get("panel2").vw.getWidth())/2d));
views.get("panel2").vw.setTop((int)((views.get("panel1").vw.getHeight())/2d-(views.get("panel2").vw.getHeight())/2d));
views.get("pnlencode").vw.setTop((int)((1d / 100 * height)));
views.get("pnlencode").vw.setHeight((int)((18d / 100 * height) - ((1d / 100 * height))));
views.get("pnlencode").vw.setLeft((int)((1d / 100 * width)));
views.get("pnlencode").vw.setWidth((int)((40d / 100 * width) - ((1d / 100 * width))));
views.get("pnlhistory").vw.setTop((int)((19d / 100 * height)));
views.get("pnlhistory").vw.setHeight((int)((36d / 100 * height) - ((19d / 100 * height))));
views.get("pnlhistory").vw.setLeft((int)((1d / 100 * width)));
views.get("pnlhistory").vw.setWidth((int)((40d / 100 * width) - ((1d / 100 * width))));
views.get("pnlabout").vw.setTop((int)((37d / 100 * height)));
views.get("pnlabout").vw.setHeight((int)((54d / 100 * height) - ((37d / 100 * height))));
views.get("pnlabout").vw.setLeft((int)((1d / 100 * width)));
views.get("pnlabout").vw.setWidth((int)((40d / 100 * width) - ((1d / 100 * width))));
views.get("pnldecode").vw.setTop((int)((1d / 100 * height)));
views.get("pnldecode").vw.setHeight((int)((18d / 100 * height) - ((1d / 100 * height))));
views.get("pnldecode").vw.setLeft((int)((51d / 100 * width)));
views.get("pnldecode").vw.setWidth((int)((90d / 100 * width) - ((51d / 100 * width))));
views.get("pnlsettings").vw.setTop((int)((19d / 100 * height)));
views.get("pnlsettings").vw.setHeight((int)((36d / 100 * height) - ((19d / 100 * height))));
views.get("pnlsettings").vw.setLeft((int)((51d / 100 * width)));
views.get("pnlsettings").vw.setWidth((int)((90d / 100 * width) - ((51d / 100 * width))));
views.get("pnlexit").vw.setTop((int)((37d / 100 * height)));
views.get("pnlexit").vw.setHeight((int)((54d / 100 * height) - ((37d / 100 * height))));
views.get("pnlexit").vw.setLeft((int)((51d / 100 * width)));
views.get("pnlexit").vw.setWidth((int)((90d / 100 * width) - ((51d / 100 * width))));
views.get("imgencode").vw.setLeft((int)((views.get("pnlencode").vw.getWidth())/2d-(views.get("imgencode").vw.getWidth())/2d));
views.get("imgdecode").vw.setLeft((int)((views.get("pnldecode").vw.getWidth())/2d-(views.get("imgdecode").vw.getWidth())/2d));
views.get("imghistory").vw.setLeft((int)((views.get("pnlhistory").vw.getWidth())/2d-(views.get("imghistory").vw.getWidth())/2d));
views.get("imgsettings").vw.setLeft((int)((views.get("pnlsettings").vw.getWidth())/2d-(views.get("imgsettings").vw.getWidth())/2d));
views.get("imgabout").vw.setLeft((int)((views.get("pnlabout").vw.getWidth())/2d-(views.get("imgabout").vw.getWidth())/2d));
views.get("imgexit").vw.setLeft((int)((views.get("pnlexit").vw.getWidth())/2d-(views.get("imgexit").vw.getWidth())/2d));

}
}