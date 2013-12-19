package org.mac.gxml.enovia.parser.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.mac.gxml.enovia.model.impl.Relationship;

@XmlRootElement(name = "definition")
public class RelationshipDef {
	private Relationship relationship;

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}
}
