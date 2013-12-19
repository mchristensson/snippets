package org.mac.gxml.model;

import org.mac.gxml.layout.CollisionElement;
import org.mac.gxml.layout.LineCollisionElement;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object;

public class ConnectionLine implements BaseModelEntity {

	public ConnectionLine(ModelEntity source, ModelEntity target) {

	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setObjectRef(Object gXmlObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getObjectRef() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollisionElement getCollisionElement() {
		return collisionElement;
	}

	private LineCollisionElement collisionElement;

}
