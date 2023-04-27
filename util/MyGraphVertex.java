package util;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;

import java.util.Queue;
import java.util.LinkedList;

import util.MyColor;

public class MyGraphVertex {
	
	public String label;
	
	//we don't have node value in this case. Binary node will have node value field
	
	//IMAGINATION: in comparison to binary node, binary tree doesn't need to record state 
	public MyColor color;
		
	//this is similar to Binary tree's left, and right; however, graph has indefinite number of neighbors
	public List<MyGraphVertex> neighbors;
	
	
	
	
	
	public MyGraphVertex(String label) {
		this.color = MyColor.WHITE;
		this.label = label;
		this.neighbors = new ArrayList<>();
	}
	
	
	
	public String getSymbol() {
		return label + " " + color.symbol;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( getSymbol() + "->" );
		
		StringJoiner sj = new StringJoiner(", ", "{", "}");
		neighbors.forEach( e -> sj.add( e.getSymbol() ) );
		
		
		return sb.toString() + sj.toString();
	}



	public static void main(String[] args) {
		
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
		
		out.println("end");
	}
	
	
	
	public static void setNeighbors( MyGraphVertex vertex, MyGraphVertex... neighbors ) {
		vertex.neighbors.addAll(  Arrays.asList( neighbors ) );
	}
	
	
	
	public static HashMap<String, MyGraphVertex> getVertices( String... labels ){
		
		HashMap<String, MyGraphVertex> vertices = new HashMap<>();
		for( String label : labels ) {
			vertices.put( label, new MyGraphVertex(label) );
		}
		
		return vertices;
	}
	
	
	
	public static void printGraph( List<MyGraphVertex> graph ) {
		graph.forEach( e -> out.println( e.toString() ) );
		out.println();
	}
	
	
	
	public static void printGraph( HashMap<String, MyGraphVertex> graph ) {
		printGraph( convertToList( graph ) );
	}
	
	
	
	public static void printGraph( MyGraphVertex graph ) {
		printGraph( Arrays.asList( graph ) );
	}
	
	
	
	public static List<MyGraphVertex> convertToList( HashMap<String, MyGraphVertex> graph ){
		return new ArrayList<>( graph.values() );
	}
	
	
	
	public static List<MyGraphVertexWithValue> convertToList2( HashMap<String, MyGraphVertex> graph ){
		
		ArrayList<MyGraphVertexWithValue > list = new ArrayList<>();
		
		for( MyGraphVertex vertex: graph.values() ) {
			if( vertex instanceof MyGraphVertexWithValue ) {
				list.add( (MyGraphVertexWithValue) vertex );
			}
			
		}
		
		return list;
	}
	
	
	
	//marking visit or not without using color is to use HashMap/ HashSet. Reference. 19.05
	public static void printGraphBFS( MyGraphVertex graph ) {
		
		Queue<MyGraphVertex> printQueue = new LinkedList<>();
		//I only need to know whether I visited before; I don't need to get any specific vertex, set would be suffice
		HashSet<MyGraphVertex> visitedVs = new HashSet<>();
		
		printQueue.add( graph );
		visitedVs.add(graph);
		
		while( printQueue.size() > 0 ) {
			
			MyGraphVertex printVertex = printQueue.poll();
			out.println( printVertex );
			
			for( MyGraphVertex neighbor : printVertex.neighbors ) {
				if( visitedVs.contains(neighbor) == false ) {
					visitedVs.add( neighbor );
					printQueue.add( neighbor );
				}
			}
		}
	}
	
	
	
	public static void printGraphBFS( List<MyGraphVertex> graph ) {
		
		//DETAIL: I use this because I don't wanna tamper with vertext color, which will be used later on
		HashSet<MyGraphVertex> visitedVs = new HashSet<>();
		Deque<MyGraphVertex> queueBFS = new LinkedList<>();
		
		for( MyGraphVertex vertex : graph ) {
			
			if( visitedVs.contains(vertex) == false) {
				queueBFS.add( vertex );
				
				while( queueBFS.size() > 0 ) {
					
					MyGraphVertex currentVertex = queueBFS.poll();
					visitedVs.add( currentVertex );
					out.println( currentVertex );
					
					for( MyGraphVertex neighbor : currentVertex.neighbors ) {
						
						if( visitedVs.contains(neighbor) == false) {
							//wrong: don't forget to add
							visitedVs.add( neighbor );
							queueBFS.add( neighbor );
						}
					}
				}
			}
		}
		
	}
	
	
	public static void printGraphDFS( MyGraphVertex graph ) {
		
		HashSet<MyGraphVertex> visitedVs = new HashSet<>();
		visitedVs.add(graph);
		printGraphDFS( graph, visitedVs );
	}
	
	
	
	private static void printGraphDFS( MyGraphVertex printVertex, HashSet<MyGraphVertex> visitedVs  ) {
		//IMAGINATION: I feel like it's preorder 
		//use instantly, so we don't have to access in later day ( and using hashSdt cannot doing so either )
		out.println( printVertex );
		
		for( MyGraphVertex neighbor : printVertex.neighbors ) {
			if( visitedVs.contains(neighbor) == false ) {
				visitedVs.add( neighbor );
				printGraphDFS( neighbor, visitedVs );
			}
		}
		
		//reaching here meaning out of options, return.
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
	
}



