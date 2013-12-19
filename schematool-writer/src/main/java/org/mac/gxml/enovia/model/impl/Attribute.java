package org.mac.gxml.enovia.model.impl;

import java.util.Collection;
import java.util.Collections;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.mac.gxml.enovia.model.SchemaToolEntityImpl;

@XmlRootElement(name = "attribute")
public class Attribute extends SchemaToolEntityImpl {
	private String attributeType;

	public String getAttributeType() {
		return attributeType;
	}

	@XmlElement(name = "type")
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	@Override
	public Collection<Short> getTargetIds() {
		return Collections.emptyList();
	}

	@Override
	public Collection<Short> getSourceIds() {
		return Collections.emptyList();
	}

}
