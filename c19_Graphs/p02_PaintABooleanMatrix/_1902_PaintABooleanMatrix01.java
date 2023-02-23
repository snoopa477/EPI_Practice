package c19_Graphs.p02_PaintABooleanMatrix;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _1902_PaintABooleanMatrix01 {

	private static class Coordinate {
		public Integer x;
		public Integer y;

		public Coordinate(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void flipColor(List<List<Boolean>> A, int x, int y) {
		final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean color = A.get(x).get(y);
		Queue<Coordinate> q = new LinkedList<>();
		A.get(x).set(y, !A.get(x).get(y)); // Flips.
		q.add(new Coordinate(x, y));
		while (!q.isEmpty()) {
			Coordinate curr = q.element();
			for (int[] dir : DIRS) {
				Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
				if (next.x >= 0 && next.x < A.size() && next.y >= 0 && next.y < A.get(next.x).size()
						&& A.get(next.x).get(next.y) == color) {
// Flips the color.
					A.get(next.x).set(next.y, !color);
					q.add(next);
				}
			}
			q.remove();
		}
	}
}
