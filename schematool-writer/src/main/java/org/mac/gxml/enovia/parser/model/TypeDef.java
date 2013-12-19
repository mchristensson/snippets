package org.mac.gxml.enovia.parser.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.mac.gxml.enovia.model.impl.Type;

@XmlRootElement(name = "definition")
public class TypeDef implements Definition {

	Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
