package org.mac.gxml.layout.error;

import org.mac.gxml.layout.CollisionElement;

public class UnsupportedCollidableClass extends Exception {

	public UnsupportedCollidableClass(Class<? extends CollisionElement> class1) {
		System.err.println("Class " + class1.getName()
				+ " has not been implemented");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4463029560564060157L;

}
