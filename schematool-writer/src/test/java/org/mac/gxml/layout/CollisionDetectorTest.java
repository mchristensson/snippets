package org.mac.gxml.layout;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.mac.gxml.layout.error.UnsupportedCollidableClass;

public class CollisionDetectorTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public CollisionDetectorTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CollisionDetectorTest.class);
	}

	public void testA() {

		RadialCollisionElement a = new RadialCollisionElement((float) 0.0,
				(float) 0.0, (float) 1.0);
		RadialCollisionElement b = new RadialCollisionElement((float) -10.0,
				(float) -10.0, (float) 1.0);
		float xMax = 10;
		float yMax = 10;
		try {
			for (float y = -10, x = -10; y < yMax && x < xMax; y++) {
				a.setX(x);
				a.setY(y);
				boolean collides;
				collides = a.collides(b);
				System.out.println(collides);
			}
		} catch (UnsupportedCollidableClass e) {
			e.printStackTrace();
		}
	}

	public void testB() {
		LineCollisionElement b = new LineCollisionElement(new Float(1),
				new Float(1), new Float(2), new Float(2));
		RadialCollisionElement a = new RadialCollisionElement((float) 1.0,
				(float) 3.0, (float) 1.0);
		float xMax = 10;
		float yMax = 10;
		try {
			for (float y = -10, x = -10; y < yMax && x < xMax; y++) {
				a.setX(x);
				a.setY(y);
				boolean collides;
				collides = a.collides(b);
				System.out.println(collides);
			}
		} catch (UnsupportedCollidableClass e) {
			e.printStackTrace();
		}
	}

	public void testC() {
		LineCollisionElement a = new LineCollisionElement(new Float(1),
				new Float(1), new Float(-3), new Float(-3));
		LineCollisionElement b = new LineCollisionElement(new Float(1),
				new Float(1), new Float(2), new Float(2));
		float yMax = 10;
		try {
			for (float y = -10; y < yMax; y++) {
				a.setY(y);
				boolean collides;
				collides = a.collides(b);
				System.out.println(collides);
			}
		} catch (UnsupportedCollidableClass e) {
			e.printStackTrace();
		}
	}

}
