package org.mac.gxml.enovia.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.mac.gxml.enovia.model.SchemaToolEntityImpl;
import org.mac.gxml.model.XMIReferenceObject;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects.Object;

@XmlRootElement(name = "type")
public class Type extends SchemaToolEntityImpl implements XMIReferenceObject {

	private String derivedFromIdentifier;
	private Object gXmlObject;

	@XmlTransient
	@Override
	public Object getObjectRef() {
		return gXmlObject;
	}

	@Override
	public void setObjectRef(Object gXmlObject) {
		this.gXmlObject = gXmlObject;
	}

	@XmlElementWrapper(name = "attributes", nillable = true, required = false)
	@XmlElement(name = "attribute", type = String.class)
	public void setAttributes(List<String> attribute) {
		this.attributes = attribute;
	}

	protected List<String> attributes = new ArrayList<String>();

	public List<String> getAttributes() {
		if (attributes == null)
			return Collections.emptyList();
		return attributes;
	}

	public String getDerivedFromIdentifier() {
		return derivedFromIdentifier;
	}

	@XmlElement(name = "derivedFrom", required = false, nillable = true)
	public void setDerivedFromIdentifier(String derivedFromIdentifier) {
		this.derivedFromIdentifier = derivedFromIdentifier;
	}

	@Override
	public Collection<Short> getSourceIds() {
		return Collections.emptyList();
	}

	protected List<Short> attributesId = new ArrayList<Short>();

	// @XmlTransient
	public void addAttributeId(short id) {
		this.attributesId.add(id);
	}

	@XmlTransient
	public Iterator<Short> getAttributesId() {
		return attributesId.iterator();
	}

	@Override
	public Collection<Short> getTargetIds() {
		return Collections.emptyList();
	}

}
