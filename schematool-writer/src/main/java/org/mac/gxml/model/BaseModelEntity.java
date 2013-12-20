package org.mac.gxml.model;

import org.mac.gxml.layout.CollisionElement;

public interface BaseModelEntity {
	public CollisionElement getCollisionElement();

	class IdGenerator {
		private static short next = 100;

		public static short getId() {
			next++;
			return next;
		}

	}

	/**
	 * @return a Unique custom identifier
	 */
	public String getIdentifier();

	public short getId();

}
