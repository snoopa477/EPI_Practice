package c19_Graphs.p06_MakingWiredConnections;
import static java.lang.System.out;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.MyGraphVertex;
import util.MyGraphVertexWithValue;
public class MakingWiredConnections_02_DFS_BinaryStates {

	private static final int UNVISITED = -1;
	private static final int GROUP_A_VALUE = 0;
	private static final int GROUP_B_VALUE = 1;
	
	public static boolean isTwoGroupsPossbile( List< MyGraphVertexWithValue > graph ) {
		
		
		//it is possible that some vertex cannot be reached by one vertex entry: has to try every vertex so the whole graph is explored
		for( MyGraphVertexWithValue vertex : graph ) {
			
			if( vertex.value == UNVISITED ) {
				vertex.value = GROUP_A_VALUE;
				boolean result = exploreAndMarkDFS( vertex );
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
	private static boolean exploreAndMarkDFS( MyGraphVertexWithValue vertex ) {
		
		
		for( MyGraphVertex neighbor : vertex.neighbors ) {
			
			if( neighbor instanceof MyGraphVertexWithValue  ) {
				MyGraphVertexWithValue neighborValueWithValue = (MyGraphVertexWithValue) neighbor;
				
				if( neighborValueWithValue.value == UNVISITED ) {
					neighborValueWithValue.value = vertex.value == GROUP_A_VALUE ? GROUP_B_VALUE : GROUP_A_VALUE;
					//DFS
					boolean subResult = exploreAndMarkDFS( neighborValueWithValue  );
					
					//cut off if neighbor and its neighbors have false
					if( subResult == false ) {
						return false;
					}
				}
				//if neighbor has same value as current vertex -> return false;
				else if ( neighborValueWithValue.value == vertex.value ) {
					return false;
				}
				
			}
		}
		
		
		return true;
	}
	
	
}


