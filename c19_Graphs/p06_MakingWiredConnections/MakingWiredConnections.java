package c19_Graphs.p06_MakingWiredConnections;
import static java.lang.System.out;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import util.MyGraphVertex;
import util.MyGraphVertexWithValue;


public class MakingWiredConnections {
	
	private static final int UNVISITED = -1;
	private static final int INITIAL_VALUE = 0;
	
	public static boolean isTwoGroupsPossbile( List< MyGraphVertexWithValue > graph ) {
		
		
		//it is possible that some vertex cannot be reached by one vertex entry: has to try every vertex so the whole graph is explored
		for( MyGraphVertexWithValue vertex : graph ) {
			
			//WRONG: TYPO
			//if( vertex.value != UNVISITED ) {
			if( vertex.value == UNVISITED ) {
				boolean result = exploreAndMarkBFS( vertex );
				if( result == false ) {
					return false;
				}
			}
			
		}
		
		
		return true;
	}
	
	
	
	/**
	 * 
	 * @param vertex
	 * @return true if can partition into two groups, with given vertex and its descendants.
	 */
	private static boolean exploreAndMarkBFS( MyGraphVertexWithValue vertex ) {
		
		Queue<MyGraphVertexWithValue> queue = new LinkedList<>();
		//++
		queue.add( vertex );
//		vertex.value = 0;
		vertex.value = INITIAL_VALUE;
		
		
		while( queue.size() > 0 ) {
			
			//--
			MyGraphVertexWithValue currentVertex = queue.poll();
			
			for( MyGraphVertex neighborVertex : currentVertex.neighbors ) {
				
				//I feel like this is unnecessary
				if( neighborVertex instanceof MyGraphVertexWithValue ) {
					
					MyGraphVertexWithValue neighborVertexWithValue = (MyGraphVertexWithValue) neighborVertex;
					
					//if( neighborVertexWithValue.value ==  ) {
					if( neighborVertexWithValue.value == UNVISITED ) {
						neighborVertexWithValue.value = currentVertex.value + 1;
						//++
						queue.add( neighborVertexWithValue );
					}
					else if( neighborVertexWithValue.value == currentVertex.value ) {
						//cut off the whole exploration once find invalid
						return false;
					}
				}
				
			}
			
			
			
		}
		
		//reaching here none of the vertex returns false, then all of the vertices are done fine
		return true;
	}
	

}


