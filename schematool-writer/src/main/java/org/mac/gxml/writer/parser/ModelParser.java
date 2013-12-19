package org.mac.gxml.writer.parser;

import java.io.File;
import java.io.IOException;

/**
 * @author mac
 * 
 */
public interface ModelParser {

	void applyGraphModel();

	// void generateGliffyObjects();
	//
	// void connectGliffyObjects();

	void parseDirectory(File file) throws IOException;

	void save(File file) throws IOException;

}
