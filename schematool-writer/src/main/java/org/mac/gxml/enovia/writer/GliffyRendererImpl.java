package org.mac.gxml.enovia.writer;

import org.mac.gxml.model.ConnectionLine;
import org.mac.gxml.model.XMIReferenceObject;
import org.mac.gxml.schema.StageDocument.Stage.PageObj;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object.Style;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object.Text;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Styles;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Styles.LineStyle;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Styles.ShapeStyle;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Styles.TextStyle;

public class GliffyRendererImpl {

	private static String getShapeLabel(String text) {
		return "<P ALIGN=\"CENTER\"><FONT COLOR=\"#000000\" FACE=\"Arial\" KERNING=\"0\" LETTERSPACING=\"0\" SIZE=\"12\"><B>"
				+ text + "</B></FONT></P>";
	}

	private static final String COLOR_STEEL_BLUE = "0xcccccc";
	private static final String DEFAULT_SHAPE_RECT = "0.0,0.0,120.0,18.0;0.0,18.0,120.0,52.0;";

	public static void applyStyle(XMIReferenceObject schemaToolEntity) {
		Object obj = schemaToolEntity.getObjectRef();
		obj.setTextHorizontalPos("center");
		obj.setSvgId("EntityAttr");
		obj.setShpId(schemaToolEntity.getId());
		obj.setRot(0);
		obj.setLock(FALSE);
		obj.setGradon(TRUE);
		obj.setFixedAspect(FALSE);
		obj.setFill(COLOR_STEEL_BLUE);
		obj.setDsy(4);
		obj.setDsx(4);
		obj.setDshad(FALSE);
		obj.setParts(DEFAULT_SHAPE_RECT);
		obj.setOrder((short) 32);
		obj.setLinew(Byte.parseByte("1"));
		obj.setLinec(COLOUR_BLACK);
		obj.setLibraryid("com.gliffy.erd");
		obj.setY(641);
		obj.setX((float) 305.5);
		obj.setWidth(119);
		obj.setHeight(70);
		obj.setClass1("GliffyMultiPartSVGShape");

		Text label = obj.addNewText();
		label.setStringValue(getShapeLabel(schemaToolEntity.getName()));
		label.setTvp("top");
		Text subLabel = obj.addNewText();
		subLabel.setTvp("top");
	}

	public static void applyStyle(ConnectionLine entity) {
		Object obj = entity.getObjectRef();
		obj.setVersion(Byte.parseByte("2"));
		obj.setRoundedCorners(TRUE);
		obj.setPath("0.0,0.0,false,y,1;0.0,136.0,false,n,0;49.0,136.0,false,x,0;");
		obj.setNumSegs(Byte.parseByte("2"));
		obj.setLinep(Byte.parseByte("0"));
		obj.setEndStyle(Byte.parseByte("2"));
		obj.setCornerRadius(Byte.parseByte("10"));
		obj.setBuff(Byte.parseByte("20"));
		obj.setBeginStyle(Byte.parseByte("0"));
		obj.setAlg("threeMid");
		obj.setLnId(entity.getId());
		obj.setLibraryid("standard");
		obj.setOrder((short) 105);
		obj.setLinew(Byte.parseByte("0"));
		obj.setLinec(COLOUR_BLACK);
		obj.setY(594);
		obj.setX(197);
		obj.setWidth(49);
		obj.setHeight(136);
		obj.setClass1("TheOrthoLine");

		Style style = obj.addNewStyle();
		style.setBorderedInnerColor(COLOUR_WHITE);
		style.setBorderLine(FALSE);

	}

	public static void preparePage(PageObj page) {
		{
			page.setWidth((short) 5000);
			page.setHeight((short) 5000);
			page.setPrintScale(OFF);
			page.setPrintPaper("A3");
			page.setPrintLayout(OFF);
			page.setPrintGrid(OFF);
			page.setPb(OFF);
			page.setIstt(FALSE);
			page.setGuides(OFF);
			page.setGr(ON); // Grid
			page.setFill(COLOUR_WHITE);
			page.setDrawingWidth((short) 1129);
			page.setDrawingHeight((short) 927);
			page.setBorder(OFF);

			Styles styles = page.addNewStyles();

			ShapeStyle shapeStyle = styles.addNewShapeStyle();
			{
				shapeStyle.setLineWidth(Byte.parseByte("-1"));
				shapeStyle.setLineColor(SHAPE_DEFAULT_LINE_STYLE);
				shapeStyle.setGradientOn(TRUE);
				shapeStyle.setFillColor(SHAPE_DEFAULT_FILL_STYLE);
				shapeStyle.setDropShadowOn(FALSE);
			}
			TextStyle textStyle = styles.addNewTextStyle();
			{
				textStyle.setStyle(TEXT_DEFAULT_STYLE);
				textStyle.setSize(Byte.parseByte("12"));
				textStyle.setFace("Arial");
				textStyle.setColor(COLOUR_BLACK);
			}

			LineStyle lineStyle = styles.addNewLineStyle();
			{
				lineStyle.setWidth(Byte.parseByte("0"));
				lineStyle.setRoundCorners(TRUE);
				lineStyle.setPattern(Byte.parseByte("0"));
				lineStyle.setEnd(Byte.parseByte("2"));
				lineStyle.setConnType("right");
				lineStyle.setColor(COLOUR_BLACK);
				lineStyle.setBorderLine(FALSE);
				lineStyle.setBegin(Byte.parseByte("0"));
			}

		}

	}

	private final static String SHAPE_DEFAULT_LINE_STYLE = "com.gliffy.erd:0x000000,global:0x333333,com.gliffy.basic:0x333333,com.gliffy.symbols.flowchart:0x333333,com.gliffy.symbols.basic:0x333333,com.gliffy.flowchart:0x333333";
	private final static String SHAPE_DEFAULT_FILL_STYLE = "global:0xcccccc,com.gliffy.basic:0xcccccc,com.gliffy.symbols.flowchart:0xcccccc,com.gliffy.symbols.basic:0xcccccc,com.gliffy.flowchart:0xcccccc";

	private final static String COLOUR_WHITE = "0xffffff";
	private final static String COLOUR_BLACK = "0x000000";
	private final static String TEXT_DEFAULT_STYLE = "bold=true";

	private final static byte OFF = (byte) 0;
	private final static byte ON = (byte) 1;
	private final static String FALSE = Boolean.FALSE.toString().toLowerCase();
	private final static String TRUE = Boolean.TRUE.toString().toLowerCase();
}
