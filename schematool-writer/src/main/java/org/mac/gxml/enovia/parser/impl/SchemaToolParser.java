package org.mac.gxml.enovia.parser.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.mac.gxml.enovia.model.impl.Attribute;
import org.mac.gxml.enovia.model.impl.Relationship;
import org.mac.gxml.enovia.model.impl.Type;
import org.mac.gxml.enovia.parser.model.AttributeDef;
import org.mac.gxml.enovia.parser.model.RelationshipDef;
import org.mac.gxml.enovia.parser.model.TypeDef;
import org.mac.gxml.layout.impl.GraphModel;
import org.mac.gxml.writer.model.XMIDocumentWrapper;
import org.mac.gxml.writer.parser.ModelParser;

public class SchemaToolParser implements ModelParser {

	private final XMIDocumentWrapper doc;

	public SchemaToolParser(XMIDocumentWrapper doc) {
		this.doc = doc;
	}

	/**
	 * File filter to only find XML files
	 */
	private static final FileFilter XMLfileFilter = new FileFilter() {

		@Override
		public boolean accept(File pathname) {
			return pathname.getName().endsWith("xml");
		}
	};
	private static final String DIR_ATTRIBUTES = "attributes";
	private static final String DIR_RELATIONSHIPS = "relationships";
	private static final String DIR_TYPES = "types";

	@Override
	public void parseDirectory(File file) throws IOException {
		if (file == null)
			throw new IOException("File is invalid (null)");
		else if (!file.isDirectory() || !file.exists()) {
			throw new IOException("File is not a valid directory");
		}

		try {
			/*
			 * Parse attributes...
			 */
			for (File schemaDir : file.listFiles()) {
				if (DIR_ATTRIBUTES.equals(schemaDir.getName())) {
					for (File schemaFile : schemaDir.listFiles(XMLfileFilter)) {
						parseEnoviaAttribute(schemaFile);
					}
				}
			}
			/*
			 * Parse types
			 */
			for (File schemaDir : file.listFiles()) {
				if (DIR_TYPES.equals(schemaDir.getName())) {
					for (File schemaFile : schemaDir.listFiles(XMLfileFilter)) {
						parseEnoviaType(schemaFile);
					}
				}
			}
			/*
			 * Parse relationships
			 */
			for (File schemaDir : file.listFiles()) {
				if (DIR_RELATIONSHIPS.equals(schemaDir.getName())) {
					for (File schemaFile : schemaDir.listFiles(XMLfileFilter)) {
						parseEnoviaRelationship(schemaFile);
					}
				}
			}
		} catch (JAXBException e) {
			throw new IOException(e);
		}

		doc.generateGliffyObjects();
		doc.connectGliffyObjects();
		applyGraphModel(doc.getGraphModel());
		doc.applyGliffyObjectStyles();
	}

	@Override
	public void applyGraphModel(GraphModel graphModel) {
		// TODO Auto-generated method stub

	}

	/**
	 * Reads SchemaTool XML corresponding to a Enovia Type
	 * 
	 * @param schemaFile
	 * @throws JAXBException
	 */
	private void parseEnoviaType(File schemaFile) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(TypeDef.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		TypeDef typeDef = (TypeDef) jaxbUnmarshaller.unmarshal(schemaFile);
		Type type = typeDef.getType();
		doc.addToIndex(type);
		/*
		 * Index lookup attributes...
		 */
		Iterator<String> attrs = type.getAttributes().iterator();
		while (attrs.hasNext()) {
			String attr = attrs.next();
			if (attr != null && attr.length() > 0) {
				attr = attr.substring(1, attr.length() - 1);
				type.addAttributeId(doc.getFromIndex(attr).getId());
			}
		}
	}

	/**
	 * Reads SchemaTool XML corresponding to a Enovia Relationship
	 * 
	 * @param schemaFile
	 * @throws JAXBException
	 */
	private void parseEnoviaRelationship(File schemaFile) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext
				.newInstance(RelationshipDef.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		System.out.println(schemaFile.getName());
		RelationshipDef relationshipDef = (RelationshipDef) jaxbUnmarshaller
				.unmarshal(schemaFile);
		Relationship relationship = relationshipDef.getRelationship();
		doc.addToIndex(relationship);
		/*
		 * Index lookup attributes...
		 */
		Iterator<String> attrs = relationship.getAttributes().iterator();
		while (attrs.hasNext()) {
			String attr = attrs.next();
			if (attr != null && attr.length() > 0) {
				attr = attr.substring(1, attr.length() - 1);
				relationship.addAttributeId(doc.getFromIndex(attr).getId());
			}
		}
		/*
		 * Index lookup types...
		 */
		Iterator<String> types = relationship.getToTypeIdentifiers().iterator();
		while (types.hasNext()) {
			String type = types.next();
			if (type != null && type.length() > 0) {
				type = type.substring(1, type.length() - 1);
				relationship.addToTypeId(doc.getFromIndex(type).getId());
			}
		}
		types = relationship.getFromTypeIdentifiers().iterator();
		while (types.hasNext()) {
			String type = types.next();
			if (type != null && type.length() > 0) {
				type = type.substring(1, type.length() - 1);
				relationship.addFromTypeId(doc.getFromIndex(type).getId());
			}
		}
	}

	/**
	 * Reads SchemaTool XML corresponding to a Enovia Attribute
	 * 
	 * @param file
	 * @throws JAXBException
	 */
	private void parseEnoviaAttribute(File schemaFile) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(AttributeDef.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AttributeDef attributeDef = (AttributeDef) jaxbUnmarshaller
				.unmarshal(schemaFile);
		Attribute attribute = attributeDef.getAttribute();
		doc.addToIndex(attribute);

	}

	@Override
	public void save(File file) throws IOException {
		doc.save(file);
	}

}
