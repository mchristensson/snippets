package org.mac.gxml.enovia.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.mac.gxml.layout.CollisionElement;
import org.mac.gxml.layout.RadialCollisionElement;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object;

public abstract class SchemaToolEntityImpl implements SchemaToolEntity {
	private Object gXmlObject;
	private String symbolicName, name;
	private final short id;

	@Override
	public CollisionElement getCollisionElement() {
		return collisionElement;
	}

	private RadialCollisionElement collisionElement;

	@Override
	public Object getObjectRef() {
		return gXmlObject;
	}

	@Override
	public void setObjectRef(Object gXmlObject) {
		this.gXmlObject = gXmlObject;
	}

	public SchemaToolEntityImpl() {
		this.id = IdGenerator.getId();
	}

	@XmlElement(name = "id")
	@Override
	public void setSymbolicName(String symbolicName) {
		this.symbolicName = symbolicName;
	}

	@XmlElement(name = "name")
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSymbolicName() {
		return symbolicName;
	}

	@Override
	public String getName() {
		return name;
	}

	@XmlTransient
	@Override
	public short getId() {
		return id;
	}

	@XmlTransient
	@Override
	public String getIdentifier() {
		return getSymbolicName();
	}

}
