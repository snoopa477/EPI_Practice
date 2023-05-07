package c19_Graphs.p09_ComputeAShortestPathWithFewestEdges;
import static java.lang.System.out;

import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

public class ComputeAShortestPathWithFewestEdges {
	
	public static boolean IS_DEBUG = false;

	public static void dijkstraShortestPath( MyGraphVertexWithEdgeValue sourceVertex, MyGraphVertexWithEdgeValue targetVertex ) {
		
		/* PURPOSE: 
		 * store the travel information from 'sourceVertex' to any given reachable vertex, ONLY when the travel has least cost.
		 * So each reachable vertex has travel info, where we starts with sourceVertex ends with given vertex 
		 * 
		 * Every vertex has travel info, and we only need the requested one
		 */
		
		//TreeSet<MyGraphVertexWithEdgeValue> f = new TreeSet<MyGraphVertexWithEdgeValue>();
		//QUESTION: how do I know its interface is SortedSet, which is the parent of NavigableSet
		//and how do I choose from between SortedSet and NavigableSet? Guess: the what operations that I need
		//I need first(), which is from 'SortedSet'; while add(), and remove() are from 'Set'
		//QUESTION 02: why bother using interface? guess: when I use it, I don't wanna know its detail( tree or wat), I only need to know its function ( sorted)
		
		//THINK_FURTHER: it's also ok to use regular queue. will get same answer, but takes more computation
		//DETAIL: MIN HEAP?
		SortedSet<MyGraphVertexWithEdgeValue> sortedVertexSets = new TreeSet<MyGraphVertexWithEdgeValue>();
		
		//start to use, need to reset to differentiate from other vertex
		sourceVertex.info = new VertexInfo( 0, 0 );
		sortedVertexSets.add( sourceVertex );
		
		
		while( sortedVertexSets.size() > 0 ) {
			
			//PURPOSE: update neighbors
			
			/*PURPOSE: we consider smallest first, 
			 * because we assume smallest travel cost has higher likelihood to cost least to get to the destination than non-least value vertex
			 */
			MyGraphVertexWithEdgeValue currentVertex = sortedVertexSets.first();
			
			//found the answer, go to the next snippet of code to print the result
			if( currentVertex.equals( targetVertex ) ) {
				break;
			}
			
			if( IS_DEBUG ) { out.println( currentVertex ); }
			
			//processed, now remove it from the to-do list, the min-heap
			sortedVertexSets.remove( currentVertex );
			
			
			//REASONING: update only when find the smaller travel cost; eventually, only the minimum travel cost is stored on that vertex 
			//QUESTION: is it possible there exist minimum while not update the vertex?
			
			//THINK_FURTHER: neighbor is either already visited or not. don't care will handle all situation 
			for( NeighborAndEdge neighborAndEdge : currentVertex.neighborsNEdges ) {
				
				MyGraphVertexWithEdgeValue neighbor = neighborAndEdge.neighbor;
				
				//reaching cost from 'sourceVertex' to the neighbor
				int toNeighbor_Path = currentVertex.info.shortestPath + neighborAndEdge.edge;
				int toNeighbor_Edges = currentVertex.info.fewestEdges + 1;
				
				if( toNeighbor_Path < neighbor.info.shortestPath 
					|| ( toNeighbor_Path == neighbor.info.shortestPath && toNeighbor_Edges < neighbor.info.fewestEdges ) ) {
					
					//if it is already in the min-heap; to rearrange it's position, remove it and then add it back
					sortedVertexSets.remove( neighbor );
					neighbor.info.shortestPath = toNeighbor_Path;
					neighbor.info.fewestEdges = toNeighbor_Edges;
					
					//just in case it's possible to print out the answer
					neighbor.pred = currentVertex;
					
					//reaching here, meaning it's the first time, which needs further exploration; or it is updated to fewer travel cost, which is also needs re-evaluation
					sortedVertexSets.add( neighbor );
				}
				
			}
			
			
		}
		
		//REASONING: reaching meaning either found the answer break, pred has value, or exhausted min heap meaning targetVerx's pred is null, non-reachable
		printOutput( targetVertex );
		
	}
	
	
	
	private static void printOutput( MyGraphVertexWithEdgeValue vertex ) {
		
		MyGraphVertexWithEdgeValue currentVertx = vertex;
		StringJoiner sj = new StringJoiner(", ");
		
		while( currentVertx.pred != null ) {
			sj.add( currentVertx.tag );
			//WRONG if I forget this line
			currentVertx = currentVertx.pred;
		}
		
		//WRONG if I forget this line
		//reaching here meaning currentVertex is root
		sj.add( currentVertx.tag );
		
		out.println( sj.toString() );
		
	}
	
}


