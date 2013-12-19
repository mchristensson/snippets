package org.mac.gxml.writer.model;

import java.io.File;
import java.io.IOException;

import org.mac.gxml.model.ModelEntity;

public interface XMIDocumentWrapper {
	final static String SHAPE_DEFAULT_LINE_STYLE = "com.gliffy.erd:0x000000,global:0x333333,com.gliffy.basic:0x333333,com.gliffy.symbols.flowchart:0x333333,com.gliffy.symbols.basic:0x333333,com.gliffy.flowchart:0x333333";
	final static String SHAPE_DEFAULT_FILL_STYLE = "global:0xcccccc,com.gliffy.basic:0xcccccc,com.gliffy.symbols.flowchart:0xcccccc,com.gliffy.symbols.basic:0xcccccc,com.gliffy.flowchart:0xcccccc";

	final static String COLOUR_WHITE = "0xffffff";
	final static String COLOUR_BLACK = "0x000000";
	final static String TEXT_DEFAULT_STYLE = "bold=true";

	final static byte OFF = (byte) 0;
	final static byte ON = (byte) 1;
	final static String FALSE = Boolean.FALSE.toString().toLowerCase();
	final static String TRUE = Boolean.TRUE.toString().toLowerCase();

	public void save(File file) throws IOException;

	public void addToIndex(ModelEntity entity);

	public ModelEntity getFromIndex(String identifier);

	public void generateGliffyObjects();

	public void connectGliffyObjects();

}
