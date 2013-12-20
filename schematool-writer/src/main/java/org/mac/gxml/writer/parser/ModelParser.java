package org.mac.gxml.writer.parser;

import java.io.File;
import java.io.IOException;

import org.mac.gxml.layout.impl.GraphModel;

/**
 * @author mac
 * 
 */
public interface ModelParser {
	void applyGraphModel(GraphModel graphModel);

	void parseDirectory(File file) throws IOException;

	void save(File file) throws IOException;

}
