package org.mac.gxml.enovia.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import org.mac.gxml.enovia.model.SchemaToolEntityImpl;
import org.mac.gxml.enovia.parser.model.FromDef;
import org.mac.gxml.enovia.parser.model.ToDef;

public class Relationship extends SchemaToolEntityImpl {

	public static enum CARDINALITY {
		ONE, MANY
	}

	@XmlTransient
	private CARDINALITY fromCardinality, toCardinality;
	@XmlTransient
	private String fromCloneAction, toCloneAction;
	@XmlTransient
	private String fromReviseAction, toReviseAction;
	@XmlTransient
	private String fromPropagateConnection, toPropagateConnection;

	/**
	 * Defaults to {@link CARDINALITY#ONE} if unable to resolve cardinality
	 * 
	 * @param from
	 */
	@XmlElement(type = FromDef.class, name = "from")
	public void setFrom(FromDef from) {
		if (CARDINALITY.ONE.name().equalsIgnoreCase(from.getCardinality())) {
			this.fromCardinality = CARDINALITY.ONE;
		} else if (CARDINALITY.MANY.name().equalsIgnoreCase(
				from.getCardinality())) {
			this.fromCardinality = CARDINALITY.MANY;
		} else {
			this.fromCardinality = CARDINALITY.ONE;
		}

		this.fromCloneAction = from.getCloneAction();
		this.fromReviseAction = from.getReviseAction();
		this.fromPropagateConnection = from.getPropagateConnection();
		this.fromTypeIdentifiers = from.getTypes();
	}

	private List<String> fromTypeIdentifiers = new ArrayList<String>(0);
	private List<String> toTypeIdentifiers = new ArrayList<String>(0);

	/**
	 * Defaults to {@link CARDINALITY#ONE} if unable to resolve cardinality
	 * 
	 * @param to
	 */
	@XmlElement(type = ToDef.class, name = "to")
	public void setTo(ToDef to) {
		/*
		 * Set cardinality
		 */
		if (CARDINALITY.ONE.name().equalsIgnoreCase(to.getCardinality())) {
			this.toCardinality = CARDINALITY.ONE;
		} else if (CARDINALITY.MANY.name()
				.equalsIgnoreCase(to.getCardinality())) {
			this.toCardinality = CARDINALITY.MANY;
		} else {
			this.toCardinality = CARDINALITY.ONE;
		}

		this.toCloneAction = to.getCloneAction();
		this.toReviseAction = to.getReviseAction();
		this.toPropagateConnection = to.getPropagateConnection();
		this.toTypeIdentifiers = to.getTypes();
	}

	protected List<Short> attributesId = new ArrayList<Short>();

	public void addAttributeId(short id) {
		this.attributesId.add(id);
	}

	public Iterator<Short> getAttributesId() {
		return attributesId.iterator();
	}

	private List<String> attributes;

	public List<String> getAttributes() {
		if (attributes == null)
			return Collections.emptyList();
		return this.attributes;
	}

	@XmlElementWrapper(name = "attributes", nillable = true, required = false)
	@XmlElement(name = "attribute")
	public void setAttributes(List<String> attribute) {
		this.attributes = attribute;
	}

	public List<String> getFromTypeIdentifiers() {
		if (fromTypeIdentifiers == null)
			return Collections.emptyList();
		return this.fromTypeIdentifiers;
	}

	public List<String> getToTypeIdentifiers() {
		if (toTypeIdentifiers == null)
			return Collections.emptyList();
		return this.toTypeIdentifiers;
	}

	public void addToTypeId(short id) {
		this.toTypeId.add(id);
	}

	public void addFromTypeId(short id) {
		this.fromTypeId.add(id);
	}

	protected List<Short> toTypeId = new ArrayList<Short>();
	protected List<Short> fromTypeId = new ArrayList<Short>();

	@Override
	public Collection<Short> getTargetIds() {
		return toTypeId;
	}

	@Override
	public Collection<Short> getSourceIds() {
		return fromTypeId;
	}
}
