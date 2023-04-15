package c19_Graphs.p05_CloneAGraph;

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

public class _1905_CloneAGraph {

	public static class GraphVertex {
		public int label;
		public List<GraphVertex> edges;

		public GraphVertex(int label) {
			this.label = label;
			edges = new ArrayList<>();
		}
	}

	
	
	public static GraphVertex cloneGraph(GraphVertex g) {
		
		if (g == null) {
			return null;
		}
		
		Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
		Queue<GraphVertex> q = new LinkedList<>();
		q.add(g);
		vertexMap.put(g, new GraphVertex(g.label));
		
		while (!q.isEmpty()) {
			GraphVertex v = q.remove();

			for (GraphVertex e : v.edges) {
				// Try to copy vertex e.
				if (!vertexMap.containsKey(e)) {
					vertexMap.put(e, new GraphVertex(e.label));
					q.add(e);
				}
				// Copy edge .
				vertexMap.get(v).edges.add(vertexMap.get(e));
			}

		}
		return vertexMap.get(g);

	}
}
