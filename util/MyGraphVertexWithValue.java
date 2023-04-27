package util;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class MyGraphVertexWithValue extends MyGraphVertex {

	
	public Integer value;
	
	
	public MyGraphVertexWithValue(String label) {
		super(label);
		// WRONG if missing this line, would get null pointer exception, because it's null object
		this.value = 0;
	}
	
	
	
	public MyGraphVertexWithValue(String label, Integer value) {
		super(label);
		this.value = value;
	}
	
	
	
	public String getSymbol() {
		return label + " " + value.toString() + " " + color.symbol ;
	}

	
	
	public static void main(String[] args) {
		
		MyGraphVertex vertex = new MyGraphVertexWithValue("A", 10);
		out.println( vertex );
		
		
		out.println("-----------graph01");
		HashMap<String, MyGraphVertex> graph01 = getGraph01();
		printGraph( graph01 );
		
		out.println("-----------graph02");
		HashMap<String, MyGraphVertex> graph02 = getGraph02();
		printGraph( graph02 );
		
		out.println("-----------graph03");
		HashMap<String, MyGraphVertex> graph03 = getGraph03();
		printGraph( graph03 );
		
		out.println("-----------graph04");
		HashMap<String, MyGraphVertex> graph04 = getGraph04();
		printGraph( graph04 );
		
		
		out.println("++++++++++++++++++++++++++++++++++++++test printGraphBFS");
		out.println( "printGraphBFS ( graph04.get(\"P\") )" );
		printGraphBFS ( graph04.get("P") );
		out.println( "printGraphBFS ( graph04.get(\"V\") )" );
		printGraphBFS ( graph04.get("V") );
		
		out.println("\n++++++++++++++++++++++++++++++++++++++test printGraphDFS");
		out.println( "printGraphDFS ( graph04.get(\"P\") )" );
		printGraphDFS ( graph04.get("P") );
		out.println( "printGraphDFS ( graph04.get(\"V\") )" );
		printGraphDFS ( graph04.get("V") );
		
		out.println("\n++++++++++++++++++++++++++++++++++++++test printGraphDFS  getGraph19_08() ");
		out.println( "printGraphDFS ( getGraph19_08().get(\"A\") )" );
		HashMap<String, MyGraphVertex> graph19_08 = getGraph19_08();
		setValueBFS( graph19_08, -1 );
		printGraphDFS ( graph19_08.get("A") );
		
		
		out.println("\n++++++++++++++++++++++++++++++++++++++test printGraphDFS  getGraph_problem19_08() ");
		out.println( "printGraphDFS ( getGraph19_08().get(\"A\") )" );
		HashMap<String, MyGraphVertex> graph_problem19_08 = getGraph_problem19_08();
		setValueBFS( graph_problem19_08, 1 );
		printGraphBFS ( convertToList (graph_problem19_08) );
		
		
		
		out.println("end");
		
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getVertices( String... labels ){
		
		HashMap<String, MyGraphVertex> vertices = new HashMap<>();
		for( String label : labels ) {
			vertices.put( label, new MyGraphVertexWithValue(label) );
		}
		
		return vertices;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph01(){
		
		//vs: vertices
		HashMap<String, MyGraphVertex> vs = getVertices("P", "Q", "R", "S");
		setNeighbors(vs.get("P"), vs.get("Q"), vs.get("S"));
		setNeighbors(vs.get("Q"), vs.get("R"));
		
		
		return vs;
	}
	
	
	
	//with cycle
	public static HashMap<String, MyGraphVertex> getGraph02(){
		
		HashMap<String, MyGraphVertex> vs = getVertices("P", "Q", "R", "S");
		setNeighbors(vs.get("P"), vs.get("Q"), vs.get("S"));
		setNeighbors(vs.get("Q"), vs.get("R"));
		setNeighbors(vs.get("R"), vs.get("P"));
		
		return vs;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph03(){
		
		HashMap<String, MyGraphVertex> vs = getVertices("P", "Q", "R", "S", "T", "U", "V");
		
		setNeighbors(vs.get("P"), vs.get("Q"), vs.get("R"), vs.get("S") );
		setNeighbors(vs.get("R"), vs.get("V") );
		setNeighbors(vs.get("S"), vs.get("V") );
		setNeighbors(vs.get("V"), vs.get("T"), vs.get("U") );
		
		return vs;
	}
	
	
	
	//with cycle
	public static HashMap<String, MyGraphVertex> getGraph04(){
		
		HashMap<String, MyGraphVertex> vs = getVertices("P", "Q", "R", "S", "T", "U", "V");
		
		setNeighbors(vs.get("P"), vs.get("Q"), vs.get("R"), vs.get("S") );
		setNeighbors(vs.get("R"), vs.get("V") );
		setNeighbors(vs.get("S"), vs.get("V") );
		setNeighbors(vs.get("V"), vs.get("T"), vs.get("U") );
		setNeighbors(vs.get("U"), vs.get("S") );
		
		return vs;
		
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph19_08(){
		
		HashMap<String, MyGraphVertex> vs = getVertices( "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V" );
		
		setNeighbors(vs.get("A"), vs.get("B"), vs.get("J") );
		setNeighbors(vs.get("B"), vs.get("A"), vs.get("C") );
		setNeighbors(vs.get("C"), vs.get("B"), vs.get("D"), vs.get("L") );
		setNeighbors(vs.get("D"), vs.get("C"), vs.get("E"), vs.get("M") );
		setNeighbors(vs.get("E"), vs.get("D"), vs.get("F") );
		setNeighbors(vs.get("F"), vs.get("E"), vs.get("G"), vs.get("M"), vs.get("N") );
		setNeighbors(vs.get("G"), vs.get("F"), vs.get("H") );
		setNeighbors(vs.get("H"), vs.get("G"), vs.get("I"), vs.get("N") );
		setNeighbors(vs.get("I"), vs.get("H"), vs.get("V") );
		setNeighbors(vs.get("J"), vs.get("A"), vs.get("K"), vs.get("O") );
		setNeighbors(vs.get("K"), vs.get("J"), vs.get("L"), vs.get("P") );
		setNeighbors(vs.get("L"), vs.get("C"), vs.get("M"), vs.get("Q"), vs.get("K") );
		setNeighbors(vs.get("M"), vs.get("F"), vs.get("L"), vs.get("R"), vs.get("D") );
		setNeighbors(vs.get("N"), vs.get("F"), vs.get("H"), vs.get("V"), vs.get("T") );
		setNeighbors(vs.get("O"), vs.get("J"), vs.get("P") );
		setNeighbors(vs.get("P"), vs.get("K"), vs.get("O"), vs.get("Q") );
		setNeighbors(vs.get("Q"), vs.get("P"), vs.get("L"), vs.get("R") );
		setNeighbors(vs.get("R"), vs.get("Q"), vs.get("M"), vs.get("S") );
		setNeighbors(vs.get("S"), vs.get("R"), vs.get("T") );
		setNeighbors(vs.get("T"), vs.get("S"), vs.get("N"), vs.get("U") );
		setNeighbors(vs.get("U"), vs.get("T"), vs.get("V") );
		setNeighbors(vs.get("V"), vs.get("U"), vs.get("I"), vs.get("N") );
		
		return vs;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph_Triangle(){
		
		HashMap<String, MyGraphVertex> vs = getVertices( "A", "B", "C" );
		
		setNeighbors(vs.get("A"), vs.get("B"), vs.get("C") );
		setNeighbors(vs.get("B"), vs.get("A"), vs.get("C") );
		setNeighbors(vs.get("C"), vs.get("A"), vs.get("B") );
		
		return vs;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph_Square(){
		
		HashMap<String, MyGraphVertex> vs = getVertices( "A", "B", "C", "D" );
		
		setNeighbors(vs.get("A"), vs.get("B"), vs.get("C") );
		setNeighbors(vs.get("B"), vs.get("A"), vs.get("D") );
		setNeighbors(vs.get("C"), vs.get("A"), vs.get("D") );
		setNeighbors(vs.get("D"), vs.get("C"), vs.get("B") );
		
		return vs;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph_Pentagon(){
		
		HashMap<String, MyGraphVertex> vs = getVertices( "A", "B", "C", "D", "E" );
		
		setNeighbors(vs.get("A"), vs.get("B"), vs.get("E") );
		setNeighbors(vs.get("B"), vs.get("A"), vs.get("C") );
		setNeighbors(vs.get("C"), vs.get("B"), vs.get("D") );
		setNeighbors(vs.get("D"), vs.get("C"), vs.get("E") );
		setNeighbors(vs.get("E"), vs.get("A"), vs.get("D") );
		
		return vs;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph_Hexagon(){
		
		HashMap<String, MyGraphVertex> vs = getVertices( "A", "B", "C", "D", "E", "F" );
		
		setNeighbors(vs.get("A"), vs.get("B"), vs.get("F") );
		setNeighbors(vs.get("B"), vs.get("A"), vs.get("C") );
		setNeighbors(vs.get("C"), vs.get("B"), vs.get("D") );
		setNeighbors(vs.get("D"), vs.get("C"), vs.get("E") );
		setNeighbors(vs.get("E"), vs.get("F"), vs.get("D") );
		setNeighbors(vs.get("F"), vs.get("A"), vs.get("E") );
		
		return vs;
	}
	
	
	
	public static void setValueBFS( HashMap<String, MyGraphVertex> graph, int value ) {
		
		ArrayList<MyGraphVertex> list = new ArrayList<MyGraphVertex>( graph.values() );
		ArrayList<MyGraphVertexWithValue> list2 = new ArrayList<>();
		
		for( MyGraphVertex vertex: list ) {
			
			if( vertex instanceof MyGraphVertexWithValue ) {
				MyGraphVertexWithValue vertexWithValue = ( MyGraphVertexWithValue ) vertex;
				list2.add( vertexWithValue );
			}
			
		}
		
		setValueBFS( list2, value );
	}
	
	
	
	public static void setValueBFS( List<MyGraphVertexWithValue> graph, int value ) {
		
		HashSet<MyGraphVertexWithValue> visitedVs = new HashSet<>();
		
		for( MyGraphVertexWithValue vertex: graph ) {
			
			if( visitedVs.contains( vertex ) == false ) {
				setValueBFS(  vertex, visitedVs, value );
			}
			
		}
		
	}
	
	
	
	public static void setValueBFS( MyGraphVertexWithValue graph, HashSet<MyGraphVertexWithValue> visitedVs, int value ) {
		
		Queue<MyGraphVertexWithValue> printQueue = new LinkedList<>();
		//I only need to know whether I visited before; I don't need to get any specific vertex, set would be suffice
		
		printQueue.add( graph );
		visitedVs.add(graph);
		
		while( printQueue.size() > 0 ) {
			
			MyGraphVertexWithValue vertex = printQueue.poll();
//			out.println( printVertex );
			vertex.value = value;
			
			for( MyGraphVertex neighbor : vertex.neighbors ) {
				
				if( neighbor instanceof MyGraphVertexWithValue ) {
					
					MyGraphVertexWithValue neighborWithValue = (MyGraphVertexWithValue) neighbor;
					
					if( visitedVs.contains(neighborWithValue) == false ) {
						visitedVs.add( neighborWithValue );
						printQueue.add( neighborWithValue );
					}
				}
			}
		}
	}
	
	
	
	public static List<MyGraphVertexWithValue> getGraphByList( HashMap<String, MyGraphVertex> graph ){
		
		List<MyGraphVertexWithValue> list = new ArrayList<>();
		
		for( MyGraphVertex vertex : graph.values() ) {
			
			if( vertex instanceof MyGraphVertexWithValue ) {
				list.add( (MyGraphVertexWithValue) vertex  );
			}
			
		}
		
		return list;
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getGraph_problem19_08(){
		
		HashMap<String, MyGraphVertex> vs = getVertices( "1", "2", "3", "4", "5", "6" );
		
		setNeighbors(vs.get("1"), vs.get("2"), vs.get("4") );
		setNeighbors(vs.get("2"), vs.get("3") );
		
		setNeighbors(vs.get("4"), vs.get("2"), vs.get("5"), vs.get("6") );
		setNeighbors(vs.get("5"), vs.get("6") );
		
		return vs;
	}
	
	
}


