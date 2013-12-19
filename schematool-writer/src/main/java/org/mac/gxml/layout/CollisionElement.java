package org.mac.gxml.layout;

import org.mac.gxml.layout.error.UnsupportedCollidableClass;

public interface CollisionElement {

	public boolean collides(CollisionElement b)
			throws UnsupportedCollidableClass;

	/**
	 * Linear Algebra util class
	 * 
	 * @author mac
	 * 
	 */
	public abstract class Util {
		/**
		 * Resolves the length of a vector.
		 * 
		 * @param a
		 *            Point A
		 * @param b
		 *            Point B
		 * @return
		 */
		public static float getVLength(CollisionElement a, CollisionElement b) {
			float dx = b.getX() - a.getX();
			float dy = b.getY() - a.getY();
			return length(new float[] { dx, dy });
		}

		/**
		 * 
		 * Resolves the length of a vector.
		 * 
		 * @param vec
		 * @return
		 */
		private static float length(float[] vec) {
			float f = (float) Math.sqrt(vec[0] * vec[0] + vec[1] * vec[1]);
			return f;
		}

		/**
		 * Resolves the orthogonal projection.
		 * 
		 * @param a
		 * @param b
		 * @return
		 */
		public static float[] getOrtProjection(LineCollisionElement a,
				CollisionElement b) {
			float[] vP0 = new float[] { a.getX(), a.getY() };
			float[] vQ = new float[] { b.getX(), b.getY() };
			float[] vU = new float[] { vQ[0] - vP0[0], vQ[1] - vP0[1] };
			float[] vV = new float[] { (a.getX1() - a.getX()),
					(a.getY1() - a.getY()) };
			float vPK = (vV[0] * vU[0] + vV[1] * vU[1])
					/ (vV[0] * vV[0] + vV[1] * vV[1]);
			float[] vP = new float[] { vV[0] * vPK, vV[1] * vPK };
			float[] vOP = new float[] { vV[0] + vP[0], vV[1] + vP[1] };

			return vOP;
		}

		public static float getOrtProjLength(LineCollisionElement a,
				CollisionElement b) {
			return length(getOrtProjection(a, b));
		}

		/**
		 * Check if two lines are parallel, within a certain tolerance (tol >
		 * 0.00)
		 * 
		 * @param a
		 * @param b
		 * @param tol
		 *            Tolerance larger than zero
		 * @return
		 */
		public static boolean areParallel(LineCollisionElement a,
				LineCollisionElement b, float tol) {
			float aDyDx = (a.getY1() - a.getY()) / (a.getX1() - a.getX());
			float bDyDx = (b.getY1() - b.getY()) / (b.getX1() - b.getX());
			float delta = Math.abs(aDyDx - bDyDx);
			return delta < tol;
		}
	}

	public void setX(float x);

	public void setY(float y);

	public float getX();

	public float getY();

}
