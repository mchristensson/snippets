package org.mac.gxml.enovia.model;

import org.mac.gxml.enovia.writer.GliffyRendererImpl;
import org.mac.gxml.layout.impl.GraphModel;
import org.mac.gxml.model.ConnectionLine;
import org.mac.gxml.model.XMIReferenceObject;
import org.mac.gxml.schema.StageDocument.Stage.PageObj;
import org.mac.gxml.writer.model.XMIDocumentWrapperImpl;

public class DefaultDocumentImpl extends XMIDocumentWrapperImpl {

	@Override
	protected void preparePage(PageObj page) {
		GliffyRendererImpl.preparePage(page);
	}

	@Override
	public void applyLineStyle(ConnectionLine entity) {
		GliffyRendererImpl.applyStyle(entity);
	}

	@Override
	public void applyBoxStyle(XMIReferenceObject entity) {
		GliffyRendererImpl.applyStyle(entity);
	}

	@Override
	public GraphModel getGraphModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
