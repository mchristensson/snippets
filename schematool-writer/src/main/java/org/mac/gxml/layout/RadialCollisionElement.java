package org.mac.gxml.layout;

import org.mac.gxml.layout.error.UnsupportedCollidableClass;

/**
 * A radial Collision Element
 * 
 * @author mac
 * 
 */
public class RadialCollisionElement implements CollisionElement {

	/**
	 * Mass
	 */
	private float m;

	/**
	 * Radius
	 */
	private final float r;

	/**
	 * X Position
	 */
	private Float x;

	/**
	 * Y position
	 */
	private Float y;

	public RadialCollisionElement(Float x, Float y, float r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	/**
	 * Check if objects collides using inner-product
	 * 
	 * @param b
	 * @return
	 * @throws UnsupportedCollidableClass
	 * @since TPG R2.3
	 */
	@Override
	public boolean collides(CollisionElement other)
			throws UnsupportedCollidableClass {
		float tol = 0;
		if (other instanceof RadialCollisionElement) {
			RadialCollisionElement b = (RadialCollisionElement) other;
			float dMin = r + b.r + tol;
			return Util.getVLength(this, b) <= dMin;
		} else if (other instanceof LineCollisionElement) {
			LineCollisionElement b = (LineCollisionElement) other;
			float dMin = r + 0 + tol;
			return Util.getOrtProjLength(b, this) <= dMin;
		} else {
			throw new UnsupportedCollidableClass(other.getClass());
		}
	}

	@Override
	public Float getX() {
		return this.x;
	}

	@Override
	public Float getY() {
		return this.y;
	}

	@Override
	public void setX(Float x) {
		this.x = x;
	}

	@Override
	public void setY(Float y) {
		this.y = y;
	}

	public float getR() {
		return this.r;
	}

	public float getM() {
		return m;
	}

	protected void setM(float m) {
		this.m = m;
	}
}