package org.mac.gxml.model;

import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object;

public interface XMIReferenceObject {
	void setObjectRef(
			org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object gXmlObject);

	public String getName();

	public Object getObjectRef();

	public short getId();
}
