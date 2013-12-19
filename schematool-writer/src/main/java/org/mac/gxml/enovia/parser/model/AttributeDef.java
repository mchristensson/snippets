package org.mac.gxml.enovia.parser.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.mac.gxml.enovia.model.impl.Attribute;

@XmlRootElement(name = "definition")
public class AttributeDef implements Definition {

	private Attribute attribute;

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

}
