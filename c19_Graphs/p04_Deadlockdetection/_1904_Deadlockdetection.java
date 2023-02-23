package c19_Graphs.p04_Deadlockdetection;

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

public class _1904_Deadlockdetection {

	public static class GraphVertex {
		public static enum Color {
			WHITE, GRAY, BLACK
		}

		public Color color;
		public List<GraphVertex> edges;
	}

	public static boolean isDeadlocked(List<GraphVertex> G) {
		for (GraphVertex vertex : G) {
			if (vertex.color == GraphVertex.Color.WHITE && hasCycle(vertex)) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasCycle(GraphVertex cur) {
// Visiting a gray vertex means a cycle.
		if (cur.color == GraphVertex.Color.GRAY) {
			return true;
		}
		cur.color = GraphVertex.Color.GRAY; // Marks current vertex as a gray one.
// Traverse the neighbor vertices.
		for (GraphVertex next : cur.edges) {
			if (next.color != GraphVertex.Color.BLACK) {
				if (hasCycle(next)) {
					return true;
				}

			}

		}
		cur.color = GraphVertex.Color.BLACK; // Marks current vertex as black.
		return false;

	}
}
