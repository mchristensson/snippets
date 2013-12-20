package org.mac.gxml.enovia.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.mac.gxml.layout.CollisionElement;
import org.mac.gxml.layout.RadialCollisionElement;

public abstract class SchemaToolEntityImpl implements SchemaToolEntity {
	private String symbolicName, name;
	private final short id;

	@Override
	public CollisionElement getCollisionElement() {
		return collisionElement;
	}

	private final RadialCollisionElement collisionElement;

	public SchemaToolEntityImpl() {
		this.collisionElement = new RadialCollisionElement(new Float(0),
				new Float(0), 1);
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
