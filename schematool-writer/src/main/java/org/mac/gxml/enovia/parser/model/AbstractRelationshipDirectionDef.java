package org.mac.gxml.enovia.parser.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public abstract class AbstractRelationshipDirectionDef {

	private String meaning, cardinality, reviseAction, cloneAction,
			propagateConnection;

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getCardinality() {
		return cardinality;
	}

	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	public String getReviseAction() {
		return reviseAction;
	}

	public void setReviseAction(String reviseAction) {
		this.reviseAction = reviseAction;
	}

	public String getCloneAction() {
		return cloneAction;
	}

	public void setCloneAction(String cloneAction) {
		this.cloneAction = cloneAction;
	}

	public String getPropagateConnection() {
		return propagateConnection;
	}

	public void setPropagateConnection(String propagateConnection) {
		this.propagateConnection = propagateConnection;
	}

	public List<String> getTypes() {
		if (types == null)
			return Collections.emptyList();
		return types;
	}

	@XmlElementWrapper(name = "types")
	@XmlElement(name = "type", type = String.class)
	public void setTypes(List<String> types) {
		this.types = types;
	}

	protected List<String> types = new ArrayList<String>();

}
