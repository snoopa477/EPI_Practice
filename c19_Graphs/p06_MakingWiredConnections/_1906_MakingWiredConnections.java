package c19_Graphs.p06_MakingWiredConnections;

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

public class _1906_MakingWiredConnections {

	public static class GraphVertex {
		public int d = -1;
		public List<GraphVertex> edges = new ArrayList<>();
	}

	public static boolean isAnyPlacementFeasible(List<GraphVertex> G) {
		for (GraphVertex v : G) {
			if (v.d == -1) {// Unvisited vertex.
				v.d = 0;
				if (!BFS(v)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean BFS(GraphVertex s) {
		Queue<GraphVertex> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			for (GraphVertex t : q.peek().edges) {
				if (t.d == -1) {// Unvisited vertex.
					t.d = q.peek().d + 1;
					q.add(t);
				} else if (t.d == q.peek().d) {
					return false;
				}
			}
			q.remove();
		}
		return true;
	}
}
