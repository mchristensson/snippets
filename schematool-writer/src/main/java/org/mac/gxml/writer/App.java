package org.mac.gxml.writer;

import java.io.File;
import java.io.IOException;

import org.mac.gxml.enovia.model.DefaultDocumentImpl;
import org.mac.gxml.enovia.parser.impl.SchemaToolParser;
import org.mac.gxml.writer.model.XMIDocumentWrapper;
import org.mac.gxml.writer.parser.ModelParser;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		XMIDocumentWrapper doc = new DefaultDocumentImpl();
		ModelParser parser = new SchemaToolParser(doc);

		try {
			parser.parseDirectory(new File("D:/temp/TUI_schema/temp"));
			parser.save(new File("c:/temp/test_" + System.currentTimeMillis()
					+ ".gxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

}
