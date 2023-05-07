package c19_Graphs.p09_ComputeAShortestPathWithFewestEdges;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


//as a member of MyGraphVertex
class VertexInfo{
	public int shortestPath;
	public int fewestEdges;
	
	
	public VertexInfo(int shortestPath, int fewestEdges) {
		super();
		this.shortestPath = shortestPath;
		this.fewestEdges = fewestEdges;
	}
}



//as a member of MyGraphVertex: the neighbor and the cost reaching neighbor
class NeighborAndEdge{
	public MyGraphVertexWithEdgeValue neighbor;
	public int edge;
	
	
	public NeighborAndEdge(MyGraphVertexWithEdgeValue neighbor, int edge) {
		super();
		this.neighbor = neighbor;
		this.edge = edge;
	}
}



/*PURPOSE: to make use of data structure 'TreeSet', have to implement Comparable
/* additionally, have to also redefine methods 'equal' and 'hash' */
public class MyGraphVertexWithEdgeValue implements Comparable<MyGraphVertexWithEdgeValue>{


	public VertexInfo info;
	public List<NeighborAndEdge> neighborsNEdges;
	//DETAIL!
	public MyGraphVertexWithEdgeValue pred;
	public String tag;
	
	
	@Override
	public int compareTo(MyGraphVertexWithEdgeValue other) {
		int compareResult01 =  Integer.compare( this.info.shortestPath, other.info.shortestPath );
		
		//I don't want nested
		//if( compareResult01 == 0 ) {
		if( compareResult01 != 0 ) {
			return compareResult01;
		}
		
		int compareResult02 =  Integer.compare( this.info.fewestEdges, other.info.fewestEdges );
		if( compareResult02 != 0 ) {
			return compareResult02;
		}
		
		//WRONG: don't forget this line
		//reaching here meaning all fields are equal, compare the tag
		return this.tag.compareTo(other.tag);
	}
	
	
	
	@Override
	public boolean equals( Object other ) {
		
		if( this == other ) {
			return true;
		}
		
		if( other instanceof MyGraphVertexWithEdgeValue == false ) {
			return false;
		}
		
		MyGraphVertexWithEdgeValue o = (MyGraphVertexWithEdgeValue) other;
		
		if( this.tag.equals(o.tag)
			&& this.info.shortestPath == o.info.shortestPath
			&& this.info.fewestEdges == o.info.fewestEdges) {
			return true;
		}
		
		return false;
	}
	
	
	
	@Override
	public int hashCode() {
	//DETAIL: have to be the exact 
	//public int hash() {
		//return hash(info, neighborsNEdges);
		//DETAIL: sth + 's' is utility.
		//QUESTION: What's the difference between the two?
		//return Objects.hash( info, neighborsNEdges );
		return Objects.hash( info.shortestPath, info.fewestEdges );
	}



	
	//-------------------------------------------------------------------------------------
	public MyGraphVertexWithEdgeValue(String tag) {
		this.info = new VertexInfo(Integer.MAX_VALUE, 0);
		this.neighborsNEdges = new ArrayList<NeighborAndEdge>();
		this.pred = null;
		this.tag = tag;
	}
	
	
	
	public static Map< String, MyGraphVertexWithEdgeValue > getTagToVertex_fig19_01(){
		
		Map< String, MyGraphVertexWithEdgeValue > map = new HashMap<>();
		
		MyGraphVertexWithEdgeValue vertexA = new MyGraphVertexWithEdgeValue("A");
		MyGraphVertexWithEdgeValue vertexB = new MyGraphVertexWithEdgeValue("B");
		MyGraphVertexWithEdgeValue vertexC = new MyGraphVertexWithEdgeValue("C");
		MyGraphVertexWithEdgeValue vertexD = new MyGraphVertexWithEdgeValue("D");
		MyGraphVertexWithEdgeValue vertexE = new MyGraphVertexWithEdgeValue("E");
		MyGraphVertexWithEdgeValue vertexF = new MyGraphVertexWithEdgeValue("F");
		MyGraphVertexWithEdgeValue vertexG = new MyGraphVertexWithEdgeValue("G");
		MyGraphVertexWithEdgeValue vertexH = new MyGraphVertexWithEdgeValue("H");
		MyGraphVertexWithEdgeValue vertexI = new MyGraphVertexWithEdgeValue("I");
		MyGraphVertexWithEdgeValue vertexJ = new MyGraphVertexWithEdgeValue("J");
		MyGraphVertexWithEdgeValue vertexK = new MyGraphVertexWithEdgeValue("K");
		MyGraphVertexWithEdgeValue vertexL = new MyGraphVertexWithEdgeValue("L");
		MyGraphVertexWithEdgeValue vertexM = new MyGraphVertexWithEdgeValue("M");
		MyGraphVertexWithEdgeValue vertexN = new MyGraphVertexWithEdgeValue("N");
		
		map.put( "A", vertexA );
		map.put( "B", vertexB );
		map.put( "C", vertexC );
		map.put( "D", vertexD );
		map.put( "E", vertexE );
		map.put( "F", vertexF );
		map.put( "G", vertexG );
		map.put( "H", vertexH );
		map.put( "I", vertexI );
		map.put( "J", vertexJ );
		map.put( "K", vertexK );
		map.put( "L", vertexL );
		map.put( "M", vertexM );
		map.put( "N", vertexN );
		
		vertexA.neighborsNEdges.add( new NeighborAndEdge( vertexB, 3) );
		vertexA.neighborsNEdges.add( new NeighborAndEdge( vertexC, 2) );
		
		vertexB.neighborsNEdges.add( new NeighborAndEdge( vertexA, 4) );
		vertexB.neighborsNEdges.add( new NeighborAndEdge( vertexK, 1) );
		
		vertexC.neighborsNEdges.add( new NeighborAndEdge( vertexE, 8) );
		
		vertexD.neighborsNEdges.add( new NeighborAndEdge( vertexC, 5) );
		vertexD.neighborsNEdges.add( new NeighborAndEdge( vertexH, 5) );
		
		vertexE.neighborsNEdges.add( new NeighborAndEdge( vertexD, 7) );
		
		vertexF.neighborsNEdges.add( new NeighborAndEdge( vertexG, 6) );
		
		vertexG.neighborsNEdges.add( new NeighborAndEdge( vertexF, 7) );
		vertexG.neighborsNEdges.add( new NeighborAndEdge( vertexH, 4) );
		
		vertexI.neighborsNEdges.add( new NeighborAndEdge( vertexJ, 6) );
		
		vertexJ.neighborsNEdges.add( new NeighborAndEdge( vertexF, 1) );
		vertexJ.neighborsNEdges.add( new NeighborAndEdge( vertexL, 7) );
		
		
		vertexK.neighborsNEdges.add( new NeighborAndEdge( vertexI, 1) );
		
		vertexL.neighborsNEdges.add( new NeighborAndEdge( vertexI, 9) );
		
		vertexM.neighborsNEdges.add( new NeighborAndEdge( vertexN, 5) );
		vertexN.neighborsNEdges.add( new NeighborAndEdge( vertexM, 12) );
		
		
		return map;
	}
	
	
	
	public static void printGraphDFS( Map< String, MyGraphVertexWithEdgeValue > graph) {
		
		//the vertex itself doesn't have info such as color
		Set<MyGraphVertexWithEdgeValue> visiteds = new HashSet<>();
		
		for( MyGraphVertexWithEdgeValue vertex: graph.values() ) {
			
			if( visiteds.contains( vertex ) == false) {
				printGraphDFS( vertex, visiteds );
			}
		}
		
	}
	
	
	
	private static void printGraphDFS( MyGraphVertexWithEdgeValue vertex, Set<MyGraphVertexWithEdgeValue> visiteds) {
		
		if( visiteds.contains( vertex ) ) {
			return ;
		}
		
		out.println( vertex );
		visiteds.add( vertex );
		
		for( NeighborAndEdge neighborNEdges: vertex.neighborsNEdges ) {
			printGraphDFS( neighborNEdges.neighbor, visiteds );
		}
	}
	
	
	
	@Override
	public String toString() {
		
		String str = "";
		str += "tag: " + this.tag;
		str += ", shortestPath: " + this.info.shortestPath;
		str += ", fewestEdges: " + this.info.fewestEdges;
		
		StringJoiner sj = new StringJoiner(", ", "->{", "}");
		
		for( NeighborAndEdge neighborNEdge : this.neighborsNEdges ) {
			sj.add( "tag: " + neighborNEdge.neighbor.tag + " edge: " + neighborNEdge.edge );
		}
		str += sj.toString();
		
		return str;
	}
	
	
	
	public static void main( String[] args ) {
		
		Map< String, MyGraphVertexWithEdgeValue > graph_fig19_01 = getTagToVertex_fig19_01();
		
		printGraphDFS( graph_fig19_01 );
		
	}
	
}




