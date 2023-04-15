package c19_Graphs.p05_CloneAGraph;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyGraphVertex;
public class Test_CloneAGraph {

	public static void main(String[] args) {
		
		out.println("CloneAGraph_01_BFS------------");
		out.println("getGraph01");
		{
			HashMap<String, MyGraphVertex> graph01 = MyGraphVertex.getGraph01();
			MyGraphVertex p = graph01.get( "P" );
			MyGraphVertex r = graph01.get( "R" );
			
			out.println("---P");
			MyGraphVertex.printGraphBFS( CloneAGraph_01_BFS.cloneGraph( p ) );
			
			out.println("---R");
			MyGraphVertex.printGraphBFS( CloneAGraph_01_BFS.cloneGraph( r ) );
		}
		
		
		out.println("getGraph04");
		{
			HashMap<String, MyGraphVertex> graph01 = MyGraphVertex.getGraph04();
			MyGraphVertex p = graph01.get( "P" );
			MyGraphVertex v = graph01.get( "V" );
			
			out.println("---P");
			MyGraphVertex.printGraphBFS( CloneAGraph_01_BFS.cloneGraph( p ) );
			
			out.println("---V");
			MyGraphVertex.printGraphBFS( CloneAGraph_01_BFS.cloneGraph( v ) );
		}
		
		
		
		
		out.println("CloneAGraph_02_DFS------------");
		{
			HashMap<String, MyGraphVertex> graph01 = MyGraphVertex.getGraph01();
			MyGraphVertex p = graph01.get( "P" );
			MyGraphVertex r = graph01.get( "R" );
			
			out.println("---P");
			MyGraphVertex.printGraphBFS( CloneAGraph_02_DFS.cloneGraph( p ) );
			
			out.println("---R");
			MyGraphVertex.printGraphBFS( CloneAGraph_02_DFS.cloneGraph( r ) );
		}
		
		
		out.println("getGraph04");
		{
			HashMap<String, MyGraphVertex> graph01 = MyGraphVertex.getGraph04();
			MyGraphVertex p = graph01.get( "P" );
			MyGraphVertex v = graph01.get( "V" );
			
			out.println("---P");
			MyGraphVertex.printGraphBFS( CloneAGraph_02_DFS.cloneGraph( p ) );
			
			out.println("---V");
			MyGraphVertex.printGraphBFS( CloneAGraph_02_DFS.cloneGraph( v ) );
		}
		
	}

}


