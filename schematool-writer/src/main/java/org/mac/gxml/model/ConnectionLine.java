package org.mac.gxml.model;

import org.mac.gxml.layout.CollisionElement;
import org.mac.gxml.layout.LineCollisionElement;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object;

public class ConnectionLine implements BaseModelEntity, XMIReferenceObject {
	private Object gXmlObject;
	private final short id;

	public ConnectionLine(ModelEntity source, ModelEntity target) {
		this.collisionElement = new LineCollisionElement(source
				.getCollisionElement().getX(), target.getCollisionElement()
				.getY(), source.getCollisionElement().getX(), target
				.getCollisionElement().getY());
		this.id = IdGenerator.getId();
	}

	@Override
	public String getIdentifier() {
		return null;
	}

	@Override
	public short getId() {
		return id;
	}

	@Override
	public void setObjectRef(Object gXmlObject) {
		this.gXmlObject = gXmlObject;
	}

	@Override
	public Object getObjectRef() {
		return this.gXmlObject;
	}

	@Override
	public CollisionElement getCollisionElement() {
		return collisionElement;
	}

	private final LineCollisionElement collisionElement;

	@Override
	public String getName() {
		return null;
	}

}
