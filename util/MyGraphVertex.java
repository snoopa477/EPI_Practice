package util;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;

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
		
		List<MyGraphVertex> graph01 = getGraph01();
		printGraph( graph01 );
		
		List<MyGraphVertex> graph02 = getGraph02();
		printGraph( graph02 );
		
		
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
	
	
	
	public static List<MyGraphVertex> getGraph01(){
		
		//vs: vertices
		HashMap<String, MyGraphVertex> vs = getVertices("P", "Q", "R", "S");
		setNeighbors(vs.get("P"), vs.get("Q"), vs.get("S"));
		setNeighbors(vs.get("Q"), vs.get("R"));
		
		
		return new ArrayList<>( vs.values() );
	}
	
	
	
	//with cycle
	public static List<MyGraphVertex> getGraph02(){
		
		HashMap<String, MyGraphVertex> vs = getVertices("P", "Q", "R", "S");
		setNeighbors(vs.get("P"), vs.get("Q"), vs.get("S"));
		setNeighbors(vs.get("Q"), vs.get("R"));
		setNeighbors(vs.get("R"), vs.get("P"));
		
		return new ArrayList<>( vs.values() );
	}
	
	
	
	public static List<MyGraphVertex> getGraph03(){
		
		return null;
		
	}
	
	
	
	//with cycle
	public static List<MyGraphVertex> getGraph04(){
		
		return null;
		
	}
	
}



