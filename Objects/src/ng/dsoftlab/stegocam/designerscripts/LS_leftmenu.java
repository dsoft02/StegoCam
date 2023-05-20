package ng.dsoftlab.stegocam.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_leftmenu{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 1;BA.debugLine="AutoScaleAll"[leftmenu/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="pVerdeMenu.SetLeftAndRight(0%x,100%x)"[leftmenu/General script]
views.get("pverdemenu").vw.setLeft((int)((0d / 100 * width)));
views.get("pverdemenu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 4;BA.debugLine="pVerdeMenu.SetTopAndBottom(0%y,25%y)"[leftmenu/General script]
views.get("pverdemenu").vw.setTop((int)((0d / 100 * height)));
views.get("pverdemenu").vw.setHeight((int)((25d / 100 * height) - ((0d / 100 * height))));
//BA.debugLineNum = 6;BA.debugLine="pRedondoMenu.SetLeftAndRight(7%x,27%x)"[leftmenu/General script]
views.get("predondomenu").vw.setLeft((int)((7d / 100 * width)));
views.get("predondomenu").vw.setWidth((int)((27d / 100 * width) - ((7d / 100 * width))));
//BA.debugLineNum = 7;BA.debugLine="pRedondoMenu.Height = pRedondoMenu.Width"[leftmenu/General script]
views.get("predondomenu").vw.setHeight((int)((views.get("predondomenu").vw.getWidth())));
//BA.debugLineNum = 12;BA.debugLine="lbNomeMenu.SetLeftAndRight(32%x,98%x)"[leftmenu/General script]
views.get("lbnomemenu").vw.setLeft((int)((32d / 100 * width)));
views.get("lbnomemenu").vw.setWidth((int)((98d / 100 * width) - ((32d / 100 * width))));
//BA.debugLineNum = 13;BA.debugLine="lbNomeMenu.SetTopAndBottom(pRedondoMenu.Top,pRedondoMenu.Bottom)"[leftmenu/General script]
views.get("lbnomemenu").vw.setTop((int)((views.get("predondomenu").vw.getTop())));
views.get("lbnomemenu").vw.setHeight((int)((views.get("predondomenu").vw.getTop() + views.get("predondomenu").vw.getHeight()) - ((views.get("predondomenu").vw.getTop()))));
//BA.debugLineNum = 15;BA.debugLine="lbEmailMenu.SetLeftAndRight(8%x,98%x)"[leftmenu/General script]
views.get("lbemailmenu").vw.setLeft((int)((8d / 100 * width)));
views.get("lbemailmenu").vw.setWidth((int)((98d / 100 * width) - ((8d / 100 * width))));
//BA.debugLineNum = 16;BA.debugLine="lbEmailMenu.SetTopAndBottom(pRedondoMenu.Bottom +2%y,pRedondoMenu.Bottom + 7%y)"[leftmenu/General script]
views.get("lbemailmenu").vw.setTop((int)((views.get("predondomenu").vw.getTop() + views.get("predondomenu").vw.getHeight())+(2d / 100 * height)));
views.get("lbemailmenu").vw.setHeight((int)((views.get("predondomenu").vw.getTop() + views.get("predondomenu").vw.getHeight())+(7d / 100 * height) - ((views.get("predondomenu").vw.getTop() + views.get("predondomenu").vw.getHeight())+(2d / 100 * height))));
//BA.debugLineNum = 21;BA.debugLine="pFundo1Menu.SetLeftAndRight(0%X,100%X)"[leftmenu/General script]
views.get("pfundo1menu").vw.setLeft((int)((0d / 100 * width)));
views.get("pfundo1menu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 22;BA.debugLine="pFundo1Menu.SetTopAndBottom(28%Y,35%Y)"[leftmenu/General script]
views.get("pfundo1menu").vw.setTop((int)((28d / 100 * height)));
views.get("pfundo1menu").vw.setHeight((int)((35d / 100 * height) - ((28d / 100 * height))));
//BA.debugLineNum = 24;BA.debugLine="pBranco1Menu.SetLeftAndRight(1%X,100%X)"[leftmenu/General script]
views.get("pbranco1menu").vw.setLeft((int)((1d / 100 * width)));
views.get("pbranco1menu").vw.setWidth((int)((100d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 25;BA.debugLine="pBranco1Menu.SetTopAndBottom(0%y,pFundo1Menu.Height)"[leftmenu/General script]
views.get("pbranco1menu").vw.setTop((int)((0d / 100 * height)));
views.get("pbranco1menu").vw.setHeight((int)((views.get("pfundo1menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 27;BA.debugLine="ic1Menu.Height = pFundo1Menu.Height / 2.5"[leftmenu/General script]
views.get("ic1menu").vw.setHeight((int)((views.get("pfundo1menu").vw.getHeight())/2.5d));
//BA.debugLineNum = 28;BA.debugLine="ic1Menu.Width = ic1Menu.Height"[leftmenu/General script]
views.get("ic1menu").vw.setWidth((int)((views.get("ic1menu").vw.getHeight())));
//BA.debugLineNum = 29;BA.debugLine="ic1Menu.Left = 6%x"[leftmenu/General script]
views.get("ic1menu").vw.setLeft((int)((6d / 100 * width)));
//BA.debugLineNum = 30;BA.debugLine="ic1Menu.Top =  pBranco1Menu.VerticalCenter - ic1Menu.Height / 2"[leftmenu/General script]
views.get("ic1menu").vw.setTop((int)((views.get("pbranco1menu").vw.getTop() + views.get("pbranco1menu").vw.getHeight()/2)-(views.get("ic1menu").vw.getHeight())/2d));
//BA.debugLineNum = 32;BA.debugLine="lb1Menu.SetLeftAndRight(19%X,100%X)"[leftmenu/General script]
views.get("lb1menu").vw.setLeft((int)((19d / 100 * width)));
views.get("lb1menu").vw.setWidth((int)((100d / 100 * width) - ((19d / 100 * width))));
//BA.debugLineNum = 33;BA.debugLine="lb1Menu.SetTopAndBottom(0%y,pFundo1Menu.Height)"[leftmenu/General script]
views.get("lb1menu").vw.setTop((int)((0d / 100 * height)));
views.get("lb1menu").vw.setHeight((int)((views.get("pfundo1menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 37;BA.debugLine="pFundo2Menu.SetLeftAndRight(0%X,100%X)"[leftmenu/General script]
views.get("pfundo2menu").vw.setLeft((int)((0d / 100 * width)));
views.get("pfundo2menu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 38;BA.debugLine="pFundo2Menu.SetTopAndBottom(36%Y,43%Y)"[leftmenu/General script]
views.get("pfundo2menu").vw.setTop((int)((36d / 100 * height)));
views.get("pfundo2menu").vw.setHeight((int)((43d / 100 * height) - ((36d / 100 * height))));
//BA.debugLineNum = 40;BA.debugLine="pBranco2Menu.SetLeftAndRight(1%X,100%X)"[leftmenu/General script]
views.get("pbranco2menu").vw.setLeft((int)((1d / 100 * width)));
views.get("pbranco2menu").vw.setWidth((int)((100d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 41;BA.debugLine="pBranco2Menu.SetTopAndBottom(0%y,pFundo2Menu.Height)"[leftmenu/General script]
views.get("pbranco2menu").vw.setTop((int)((0d / 100 * height)));
views.get("pbranco2menu").vw.setHeight((int)((views.get("pfundo2menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 43;BA.debugLine="ic2Menu.Height = pFundo2Menu.Height / 2.5"[leftmenu/General script]
views.get("ic2menu").vw.setHeight((int)((views.get("pfundo2menu").vw.getHeight())/2.5d));
//BA.debugLineNum = 44;BA.debugLine="ic2Menu.Width = ic2Menu.Height"[leftmenu/General script]
views.get("ic2menu").vw.setWidth((int)((views.get("ic2menu").vw.getHeight())));
//BA.debugLineNum = 45;BA.debugLine="ic2Menu.Left = 6%x"[leftmenu/General script]
views.get("ic2menu").vw.setLeft((int)((6d / 100 * width)));
//BA.debugLineNum = 46;BA.debugLine="ic2Menu.Top =  pBranco2Menu.VerticalCenter - ic2Menu.Height / 2"[leftmenu/General script]
views.get("ic2menu").vw.setTop((int)((views.get("pbranco2menu").vw.getTop() + views.get("pbranco2menu").vw.getHeight()/2)-(views.get("ic2menu").vw.getHeight())/2d));
//BA.debugLineNum = 48;BA.debugLine="lb2Menu.SetLeftAndRight(19%X,100%X)"[leftmenu/General script]
views.get("lb2menu").vw.setLeft((int)((19d / 100 * width)));
views.get("lb2menu").vw.setWidth((int)((100d / 100 * width) - ((19d / 100 * width))));
//BA.debugLineNum = 49;BA.debugLine="lb2Menu.SetTopAndBottom(0%y,pFundo2Menu.Height)"[leftmenu/General script]
views.get("lb2menu").vw.setTop((int)((0d / 100 * height)));
views.get("lb2menu").vw.setHeight((int)((views.get("pfundo2menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 53;BA.debugLine="pFundo3Menu.SetLeftAndRight(0%X,100%X)"[leftmenu/General script]
views.get("pfundo3menu").vw.setLeft((int)((0d / 100 * width)));
views.get("pfundo3menu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 54;BA.debugLine="pFundo3Menu.SetTopAndBottom(44%Y,51%Y)"[leftmenu/General script]
views.get("pfundo3menu").vw.setTop((int)((44d / 100 * height)));
views.get("pfundo3menu").vw.setHeight((int)((51d / 100 * height) - ((44d / 100 * height))));
//BA.debugLineNum = 56;BA.debugLine="pBranco3Menu.SetLeftAndRight(1%X,100%X)"[leftmenu/General script]
views.get("pbranco3menu").vw.setLeft((int)((1d / 100 * width)));
views.get("pbranco3menu").vw.setWidth((int)((100d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 57;BA.debugLine="pBranco3Menu.SetTopAndBottom(0%y,pFundo3Menu.Height)"[leftmenu/General script]
views.get("pbranco3menu").vw.setTop((int)((0d / 100 * height)));
views.get("pbranco3menu").vw.setHeight((int)((views.get("pfundo3menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 59;BA.debugLine="ic3Menu.Height = pFundo3Menu.Height / 2.5"[leftmenu/General script]
views.get("ic3menu").vw.setHeight((int)((views.get("pfundo3menu").vw.getHeight())/2.5d));
//BA.debugLineNum = 60;BA.debugLine="ic3Menu.Width = ic3Menu.Height"[leftmenu/General script]
views.get("ic3menu").vw.setWidth((int)((views.get("ic3menu").vw.getHeight())));
//BA.debugLineNum = 61;BA.debugLine="ic3Menu.Left = 6%x"[leftmenu/General script]
views.get("ic3menu").vw.setLeft((int)((6d / 100 * width)));
//BA.debugLineNum = 62;BA.debugLine="ic3Menu.Top =  pBranco3Menu.VerticalCenter - ic3Menu.Height / 2"[leftmenu/General script]
views.get("ic3menu").vw.setTop((int)((views.get("pbranco3menu").vw.getTop() + views.get("pbranco3menu").vw.getHeight()/2)-(views.get("ic3menu").vw.getHeight())/2d));
//BA.debugLineNum = 64;BA.debugLine="lb3Menu.SetLeftAndRight(19%X,100%X)"[leftmenu/General script]
views.get("lb3menu").vw.setLeft((int)((19d / 100 * width)));
views.get("lb3menu").vw.setWidth((int)((100d / 100 * width) - ((19d / 100 * width))));
//BA.debugLineNum = 65;BA.debugLine="lb3Menu.SetTopAndBottom(0%y,pFundo3Menu.Height)"[leftmenu/General script]
views.get("lb3menu").vw.setTop((int)((0d / 100 * height)));
views.get("lb3menu").vw.setHeight((int)((views.get("pfundo3menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 69;BA.debugLine="pFundo4Menu.SetLeftAndRight(0%X,100%X)"[leftmenu/General script]
views.get("pfundo4menu").vw.setLeft((int)((0d / 100 * width)));
views.get("pfundo4menu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 70;BA.debugLine="pFundo4Menu.SetTopAndBottom(52%Y,59%Y)"[leftmenu/General script]
views.get("pfundo4menu").vw.setTop((int)((52d / 100 * height)));
views.get("pfundo4menu").vw.setHeight((int)((59d / 100 * height) - ((52d / 100 * height))));
//BA.debugLineNum = 72;BA.debugLine="pBranco4Menu.SetLeftAndRight(1%X,100%X)"[leftmenu/General script]
views.get("pbranco4menu").vw.setLeft((int)((1d / 100 * width)));
views.get("pbranco4menu").vw.setWidth((int)((100d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 73;BA.debugLine="pBranco4Menu.SetTopAndBottom(0%y,pFundo4Menu.Height)"[leftmenu/General script]
views.get("pbranco4menu").vw.setTop((int)((0d / 100 * height)));
views.get("pbranco4menu").vw.setHeight((int)((views.get("pfundo4menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 75;BA.debugLine="ic4Menu.Height = pFundo4Menu.Height / 2.5"[leftmenu/General script]
views.get("ic4menu").vw.setHeight((int)((views.get("pfundo4menu").vw.getHeight())/2.5d));
//BA.debugLineNum = 76;BA.debugLine="ic4Menu.Width = ic4Menu.Height"[leftmenu/General script]
views.get("ic4menu").vw.setWidth((int)((views.get("ic4menu").vw.getHeight())));
//BA.debugLineNum = 77;BA.debugLine="ic4Menu.Left = 6%x"[leftmenu/General script]
views.get("ic4menu").vw.setLeft((int)((6d / 100 * width)));
//BA.debugLineNum = 78;BA.debugLine="ic4Menu.Top =  pBranco4Menu.VerticalCenter - ic4Menu.Height / 2"[leftmenu/General script]
views.get("ic4menu").vw.setTop((int)((views.get("pbranco4menu").vw.getTop() + views.get("pbranco4menu").vw.getHeight()/2)-(views.get("ic4menu").vw.getHeight())/2d));
//BA.debugLineNum = 80;BA.debugLine="lb4Menu.SetLeftAndRight(19%X,100%X)"[leftmenu/General script]
views.get("lb4menu").vw.setLeft((int)((19d / 100 * width)));
views.get("lb4menu").vw.setWidth((int)((100d / 100 * width) - ((19d / 100 * width))));
//BA.debugLineNum = 81;BA.debugLine="lb4Menu.SetTopAndBottom(0%y,pFundo4Menu.Height)"[leftmenu/General script]
views.get("lb4menu").vw.setTop((int)((0d / 100 * height)));
views.get("lb4menu").vw.setHeight((int)((views.get("pfundo4menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 84;BA.debugLine="pFundo5Menu.SetLeftAndRight(0%X,100%X)"[leftmenu/General script]
views.get("pfundo5menu").vw.setLeft((int)((0d / 100 * width)));
views.get("pfundo5menu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 85;BA.debugLine="pFundo5Menu.SetTopAndBottom(60%Y,67%Y)"[leftmenu/General script]
views.get("pfundo5menu").vw.setTop((int)((60d / 100 * height)));
views.get("pfundo5menu").vw.setHeight((int)((67d / 100 * height) - ((60d / 100 * height))));
//BA.debugLineNum = 87;BA.debugLine="pBranco5Menu.SetLeftAndRight(1%X,100%X)"[leftmenu/General script]
views.get("pbranco5menu").vw.setLeft((int)((1d / 100 * width)));
views.get("pbranco5menu").vw.setWidth((int)((100d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 88;BA.debugLine="pBranco5Menu.SetTopAndBottom(0%y,pFundo5Menu.Height)"[leftmenu/General script]
views.get("pbranco5menu").vw.setTop((int)((0d / 100 * height)));
views.get("pbranco5menu").vw.setHeight((int)((views.get("pfundo5menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 90;BA.debugLine="ic5Menu.Height = pFundo5Menu.Height / 2.5"[leftmenu/General script]
views.get("ic5menu").vw.setHeight((int)((views.get("pfundo5menu").vw.getHeight())/2.5d));
//BA.debugLineNum = 91;BA.debugLine="ic5Menu.Width = ic5Menu.Height"[leftmenu/General script]
views.get("ic5menu").vw.setWidth((int)((views.get("ic5menu").vw.getHeight())));
//BA.debugLineNum = 92;BA.debugLine="ic5Menu.Left = 6%x"[leftmenu/General script]
views.get("ic5menu").vw.setLeft((int)((6d / 100 * width)));
//BA.debugLineNum = 93;BA.debugLine="ic5Menu.Top =  pBranco5Menu.VerticalCenter - ic5Menu.Height / 2"[leftmenu/General script]
views.get("ic5menu").vw.setTop((int)((views.get("pbranco5menu").vw.getTop() + views.get("pbranco5menu").vw.getHeight()/2)-(views.get("ic5menu").vw.getHeight())/2d));
//BA.debugLineNum = 95;BA.debugLine="lb5Menu.SetLeftAndRight(19%X,100%X)"[leftmenu/General script]
views.get("lb5menu").vw.setLeft((int)((19d / 100 * width)));
views.get("lb5menu").vw.setWidth((int)((100d / 100 * width) - ((19d / 100 * width))));
//BA.debugLineNum = 96;BA.debugLine="lb5Menu.SetTopAndBottom(0%y,pFundo5Menu.Height)"[leftmenu/General script]
views.get("lb5menu").vw.setTop((int)((0d / 100 * height)));
views.get("lb5menu").vw.setHeight((int)((views.get("pfundo5menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 100;BA.debugLine="pFundo6Menu.SetLeftAndRight(0%X,100%X)"[leftmenu/General script]
views.get("pfundo6menu").vw.setLeft((int)((0d / 100 * width)));
views.get("pfundo6menu").vw.setWidth((int)((100d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 101;BA.debugLine="pFundo6Menu.SetTopAndBottom(68%Y,75%Y)"[leftmenu/General script]
views.get("pfundo6menu").vw.setTop((int)((68d / 100 * height)));
views.get("pfundo6menu").vw.setHeight((int)((75d / 100 * height) - ((68d / 100 * height))));
//BA.debugLineNum = 103;BA.debugLine="pBranco6Menu.SetLeftAndRight(1%X,100%X)"[leftmenu/General script]
views.get("pbranco6menu").vw.setLeft((int)((1d / 100 * width)));
views.get("pbranco6menu").vw.setWidth((int)((100d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 104;BA.debugLine="pBranco6Menu.SetTopAndBottom(0%y,pFundo6Menu.Height)"[leftmenu/General script]
views.get("pbranco6menu").vw.setTop((int)((0d / 100 * height)));
views.get("pbranco6menu").vw.setHeight((int)((views.get("pfundo6menu").vw.getHeight()) - ((0d / 100 * height))));
//BA.debugLineNum = 106;BA.debugLine="ic6Menu.Height = pFundo6Menu.Height / 2.5"[leftmenu/General script]
views.get("ic6menu").vw.setHeight((int)((views.get("pfundo6menu").vw.getHeight())/2.5d));
//BA.debugLineNum = 107;BA.debugLine="ic6Menu.Width = ic6Menu.Height"[leftmenu/General script]
views.get("ic6menu").vw.setWidth((int)((views.get("ic6menu").vw.getHeight())));
//BA.debugLineNum = 108;BA.debugLine="ic6Menu.Left = 6%x"[leftmenu/General script]
views.get("ic6menu").vw.setLeft((int)((6d / 100 * width)));
//BA.debugLineNum = 109;BA.debugLine="ic6Menu.Top =  pBranco6Menu.VerticalCenter - ic6Menu.Height / 2"[leftmenu/General script]
views.get("ic6menu").vw.setTop((int)((views.get("pbranco6menu").vw.getTop() + views.get("pbranco6menu").vw.getHeight()/2)-(views.get("ic6menu").vw.getHeight())/2d));
//BA.debugLineNum = 111;BA.debugLine="lb6Menu.SetLeftAndRight(19%X,100%X)"[leftmenu/General script]
views.get("lb6menu").vw.setLeft((int)((19d / 100 * width)));
views.get("lb6menu").vw.setWidth((int)((100d / 100 * width) - ((19d / 100 * width))));
//BA.debugLineNum = 112;BA.debugLine="lb6Menu.SetTopAndBottom(0%y,pFundo6Menu.Height)"[leftmenu/General script]
views.get("lb6menu").vw.setTop((int)((0d / 100 * height)));
views.get("lb6menu").vw.setHeight((int)((views.get("pfundo6menu").vw.getHeight()) - ((0d / 100 * height))));

}
}