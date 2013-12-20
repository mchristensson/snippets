package org.mac.gxml.util;

import java.util.Collection;
import java.util.LinkedList;

public class PathEncoder {

	private class Coord {
		private final float x, y;
		private final boolean flag;
		private final String l;
		private final short fill;

		private Coord(float x, float y, boolean flag, String l, short fill) {
			super();
			this.x = x;
			this.y = y;
			this.flag = flag;
			this.l = l;
			this.fill = fill;
		}

		@Override
		public String toString() {
			return String.format("%d,%d,%b,%s,%d;", x, y, flag, l, fill);
		}

	}

	private final Collection<Coord> coords;

	public PathEncoder() {
		this.coords = new LinkedList<PathEncoder.Coord>();
	}

	public void addCoord(float x, float y, boolean flag, String l, short fill) {
		coords.add(new Coord(x, y, flag, l, fill));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(8);
		for (Coord coord : coords) {
			sb.append(coord.toString());
		}
		return sb.toString();
	}
}