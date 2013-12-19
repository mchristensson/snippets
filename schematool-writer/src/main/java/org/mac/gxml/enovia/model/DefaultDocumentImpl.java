package org.mac.gxml.enovia.model;

import org.mac.gxml.enovia.writer.GliffyRendererImpl;
import org.mac.gxml.schema.StageDocument.Stage.PageObj;
import org.mac.gxml.writer.model.XMIDocumentWrapperImpl;

public class DefaultDocumentImpl extends XMIDocumentWrapperImpl {

	@Override
	protected void preparePage(PageObj page) {
		GliffyRendererImpl.preparePage(page);
	}

}
