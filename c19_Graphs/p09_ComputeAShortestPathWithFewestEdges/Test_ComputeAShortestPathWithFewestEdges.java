package c19_Graphs.p09_ComputeAShortestPathWithFewestEdges;
import static java.lang.System.out;

import java.util.Map;
public class Test_ComputeAShortestPathWithFewestEdges {

	public static void main(String[] args) {
		
		Map< String, MyGraphVertexWithEdgeValue > graph_fig19_01 = MyGraphVertexWithEdgeValue.getTagToVertex_fig19_01();
		
//		ComputeAShortestPathWithFewestEdges.IS_DEBUG = true;
		
		out.println( "ComputeAShortestPathWithFewestEdges.dijkstraShortestPath(graph_fig19_01.get(\"A\"), graph_fig19_01.get(\"H\"));" );
		ComputeAShortestPathWithFewestEdges.dijkstraShortestPath(graph_fig19_01.get("A"), graph_fig19_01.get("H"));
		
		
	}

}


