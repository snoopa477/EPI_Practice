package c19_Graphs.p06_MakingWiredConnections;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;

import util.MyGraphVertex;
import util.MyGraphVertexWithValue;

public class Test_MakingWiredConnections {

	public static void main(String[] args) {
		
		
		out.println("+++++++++++++++++++++++++++++++++ MyGraphVertexWithValue");
		out.println("--------------graph19_08");
		HashMap<String, MyGraphVertex> graph19_08 = MyGraphVertexWithValue.getGraph19_08();
		MyGraphVertexWithValue.setValueBFS( graph19_08, -1 );
		out.println( MakingWiredConnections.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph19_08 ) ) );
		
		out.println("--------------graph_Triangle");
		HashMap<String, MyGraphVertex> graph_Triangle = MyGraphVertexWithValue.getGraph_Triangle();
		MyGraphVertexWithValue.setValueBFS( graph_Triangle, -1 );
		out.println( MakingWiredConnections.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Triangle ) ) );
		MyGraphVertexWithValue.printGraphBFS(graph_Triangle.get("A"));
		
		out.println("--------------graph_Square");
		HashMap<String, MyGraphVertex> graph_Square = MyGraphVertexWithValue.getGraph_Square();
		MyGraphVertexWithValue.setValueBFS( graph_Square, -1 );
		out.println( MakingWiredConnections.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Square ) ) );
		
		out.println("--------------graph_Pentago");
		HashMap<String, MyGraphVertex> graph_Pentago = MyGraphVertexWithValue.getGraph_Pentagon();
		MyGraphVertexWithValue.setValueBFS( graph_Pentago, -1 );
		out.println( MakingWiredConnections.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Pentago ) ) );
		
		out.println("--------------graph_Hexagon");
		HashMap<String, MyGraphVertex> graph_Hexagon = MyGraphVertexWithValue.getGraph_Hexagon();
		MyGraphVertexWithValue.setValueBFS( graph_Hexagon, -1 );
		out.println( MakingWiredConnections.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Hexagon ) ) );
		
		
		out.println("+++++++++++++++++++++++++++++++++ MakingWiredConnections_02_DFS_BinaryStates");
		out.println("--------------graph19_08");
		MyGraphVertexWithValue.setValueBFS( graph19_08, -1 );
		out.println( MakingWiredConnections_02_DFS_BinaryStates.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph19_08 ) ) );
		
		out.println("--------------graph_Triangle");
		MyGraphVertexWithValue.setValueBFS( graph_Triangle, -1 );
		out.println( MakingWiredConnections_02_DFS_BinaryStates.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Triangle ) ) );
		
		out.println("--------------graph_Square");
		MyGraphVertexWithValue.setValueBFS( graph_Square, -1 );
		out.println( MakingWiredConnections_02_DFS_BinaryStates.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Square ) ) );
		
		out.println("--------------graph_Pentago");
		MyGraphVertexWithValue.setValueBFS( graph_Pentago, -1 );
		out.println( MakingWiredConnections_02_DFS_BinaryStates.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Pentago ) ) );
		
		out.println("--------------graph_Hexagon");
		MyGraphVertexWithValue.setValueBFS( graph_Hexagon, -1 );
		out.println( MakingWiredConnections_02_DFS_BinaryStates.isTwoGroupsPossbile( MyGraphVertexWithValue.getGraphByList( graph_Hexagon ) ) );
		
	}
	
	

}


