package c19_Graphs.p09_ComputeAShortestPathWithFewestEdges;
import static java.lang.System.out;

import java.util.List;
import java.util.Objects;


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
		
			
	
}




