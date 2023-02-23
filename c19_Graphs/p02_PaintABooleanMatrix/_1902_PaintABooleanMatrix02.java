package c19_Graphs.p02_PaintABooleanMatrix;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1902_PaintABooleanMatrix02 {

	public static void flipColor(List<List<Boolean>> A, int x, int y) {
		final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean color = A.get(x).get(y);
		A.get(x).set(y, !color); // Flips.
		for (int[] dir : DIRS) {
			int nextX = x + dir[0], nextY = y + dir[1];
			if (nextX >= 0 && nextX < A.size() && nextY >= 0 && nextY < A.get(nextX).size()
					&& A.get(nextX).get(nextY) == color) {
				flipColor(A, nextX, nextY);
			}

		}

	}
}
