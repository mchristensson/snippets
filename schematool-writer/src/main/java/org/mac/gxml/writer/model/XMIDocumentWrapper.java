package org.mac.gxml.writer.model;

import java.io.File;
import java.io.IOException;

import org.mac.gxml.layout.impl.GraphModel;
import org.mac.gxml.model.ConnectionLine;
import org.mac.gxml.model.ModelEntity;
import org.mac.gxml.model.XMIReferenceObject;

public interface XMIDocumentWrapper {

	public void save(File file) throws IOException;

	public void addToIndex(ModelEntity entity);

	public ModelEntity getFromIndex(String identifier);

	public void generateGliffyObjects();

	public void connectGliffyObjects();

	public void applyGliffyObjectStyles();

	public void applyLineStyle(ConnectionLine entity);

	public void applyBoxStyle(XMIReferenceObject entity);

	public GraphModel getGraphModel();
}
