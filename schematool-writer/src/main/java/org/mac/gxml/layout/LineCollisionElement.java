package org.mac.gxml.layout;

import org.mac.gxml.layout.error.UnsupportedCollidableClass;

public class LineCollisionElement implements CollisionElement {
	@Override
	public float getX() {
		return this.x;
	}

	@Override
	public float getY() {
		return this.y;
	}

	/**
	 * Points on line
	 */
	private float x, y;
	private float x1;
	private float y1;

	public LineCollisionElement(float x0, float y0, float x1, float y1) {
		this.x = x0;
		this.y = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	@Override
	public boolean collides(CollisionElement other)
			throws UnsupportedCollidableClass {
		if (other instanceof RadialCollisionElement) {
			float tol = 0;
			RadialCollisionElement b = (RadialCollisionElement) other;
			float dMin = b.getR() + 0 + tol;
			return Util.getVLength(this, b) <= dMin;
		} else if (other instanceof LineCollisionElement) {
			LineCollisionElement b = (LineCollisionElement) other;
			float tol = (float) 0.001;
			return !Util.areParallel(b, this, tol);
		} else {
			throw new UnsupportedCollidableClass(other.getClass());
		}
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public float getY1() {
		return this.y1;
	}

	public float getX1() {
		return this.x1;
	}

}
