package c19_Graphs.p08_TeamPhotoday_02;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1908_TeamPhotoday_02 {

	public static class GraphVertex {
		public List<GraphVertex> edges = new ArrayList<>();
		public int maxDistance = 1;
		public boolean visited = false;
	}

	
	
	public static int findLargestNumberTeams(List<GraphVertex> G) {
		Deque<GraphVertex> orderedVertices = buildTopologicalOrdering(G);
		return findLongestPath(orderedVertices);
	}

	
	
	private static Deque<GraphVertex> buildTopologicalOrdering(List<GraphVertex> G) {
		Deque<GraphVertex> orderedVertices = new LinkedList<>();
		for (GraphVertex g : G) {
			if (!g.visited) {
				DFS(g, orderedVertices);
			}
		}
		return orderedVertices;
	}

	
	
	private static int findLongestPath(Deque<GraphVertex> orderedVertices) {
		int maxDistance = 0;
		while (!orderedVertices.isEmpty()) {
			GraphVertex u = orderedVertices.peekFirst();
			maxDistance = Math.max(maxDistance, u.maxDistance);
			for (GraphVertex v : u.edges) {
				v.maxDistance = Math.max(v.maxDistance, u.maxDistance + 1);
			}
			orderedVertices.removeFirst();
		}
		return maxDistance;
	}

	
	
	private static void DFS(GraphVertex cur, Deque<GraphVertex> orderedVertices) {
		cur.visited = true;
		for (GraphVertex next : cur.edges) {
			if (!next.visited) {
				DFS(next, orderedVertices);

			}

		}
		orderedVertices.addFirst(cur);
	}
}
