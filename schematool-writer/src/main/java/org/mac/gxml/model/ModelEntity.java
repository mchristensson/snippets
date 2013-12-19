package org.mac.gxml.model;

import java.util.Collection;

public interface ModelEntity extends BaseModelEntity {

	public String getName();

	void setName(String name);

	public Collection<Short> getTargetIds();

	public Collection<Short> getSourceIds();

}
