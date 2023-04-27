package c19_Graphs.p08_TeamPhotoday_02;
import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.MyColor;
import util.MyGraphVertex;
import util.MyGraphVertexWithValue;


public class TeamPhotoday_02 {
	
	private static final MyColor UNVISITED = MyColor.WHITE;
	private static final MyColor VISITED = MyColor.BLACK;
	
	
	public static int findLargestTeams( List<MyGraphVertexWithValue> graph ) {
		
		Deque<MyGraphVertexWithValue> topologicalOrdering = buildTopologicalOrdering( graph );
		
		return findLongestPath( topologicalOrdering );
	}
	
	
	
	private static Deque<MyGraphVertexWithValue> buildTopologicalOrdering( List<MyGraphVertexWithValue> graph ){
		
		Deque<MyGraphVertexWithValue> topologicalOrdering = new LinkedList<>();
		
		for( MyGraphVertexWithValue vertex: graph ) {
				//THINK_FURTHER: the vertex might have been affect by previous calls
				if( vertex.color == UNVISITED ) {
					buildTopologicalOrdering_DFS( vertex, topologicalOrdering );
				}
		}
		
		return topologicalOrdering;
	}
	
	
	
	private static void buildTopologicalOrdering_DFS( MyGraphVertexWithValue vertex, Deque<MyGraphVertexWithValue> topologicalOrdering ) {
		
		vertex.color = VISITED;
		
		for( MyGraphVertex neighbor: vertex.neighbors ) {
			if( neighbor instanceof MyGraphVertexWithValue  ) {
				MyGraphVertexWithValue neighborWithValue = (MyGraphVertexWithValue) neighbor;
				
				if( neighborWithValue.color == UNVISITED ) {
					buildTopologicalOrdering_DFS( neighborWithValue, topologicalOrdering );
				}
			}
		}
		
		
		//REASONING: reaching here meaning all neighbor has done explored, which means they all have finished their DFS calling 
		//THINK_FURTHER: similar to binary tree, first to reach here is leaf
		/*THINK_FURTHER: it's the isolated vertex( leaf), which points to no one, would come here first; 
		 * after it is added to Deque, all pointers to this vertex are removed; after that, here might comes new isolated vertex 
		 */
		topologicalOrdering.addFirst(vertex);
		
	}
	
	
	
	private static int findLongestPath( Deque<MyGraphVertexWithValue> topologicalOrdering ) {
		
		/**
		 * due to topologicalOrdering, every vertex points to its neighbor by right
		 * for any vertex that has its own longestPath, when we gonna compute it, we only needs to scan from left to right, because its neighbor always at right hand side 
		 */
		
		int longestPath = 0;
		
		while( topologicalOrdering.size() > 0 ) {
			
			MyGraphVertexWithValue currentVertex =  topologicalOrdering.peek();
			//update, if possible
			longestPath = Math.max(longestPath, currentVertex.value );
			
			//for every neighbor of current vertex, neighbor takes current vertex into account if it will updates its longestPath
			for( MyGraphVertex neighbor: currentVertex.neighbors ) {
				if( neighbor instanceof MyGraphVertexWithValue  ) {
					MyGraphVertexWithValue neighborWithValue = (MyGraphVertexWithValue) neighbor;
					
					//DETAIL: current vertex is its neighbor's neighbor, which is one unit distance.
					//DETAIL: maxDistance is called because we use max function everytime
					neighborWithValue.value = Math.max(neighborWithValue.value, currentVertex.value + 1);
				}
			}
			
			/*REASONING: since the left side of current are already removed, no one can affect it in the future, 
			 * and since every neighbor of current vertex already update its maxDistance by taking currentVertex into account,
			 * we don't need currentVertex anymore
			 */
			topologicalOrdering.removeFirst();
		}
		
		return longestPath;
	}
	

}


