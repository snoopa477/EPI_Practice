package c19_Graphs.p04_Deadlockdetection;
import static java.lang.System.out;

import util.MyGraphVertex;
import util.MyColor;
import java.util.List;


public class Deadlockdetection {

	
	
	public static boolean isDeadLocked( List<MyGraphVertex> graph ) {
		
		/**
		 * REASONING:
		 * WHITE: new, untouched
		 * 
		 * GREY: it is called, and is still exploring its neighbors
		 * 	vertex is colored grey once it's called.
		 * 
		 * BLACK: it is called, and is done exploring its neighbors, and so does its all neighbors
		 * 	vertex is colored black once all the call to neighbors end.
		 */
		
		//for any vertex that has cycle, then there is deadlock
		//otherwise, if none of vertices, then there's no deadlock
		for( MyGraphVertex vertex : graph ) {
			
			/*WRONG: we don't consider black vertex because it is already investigated when it is callee's neighbor
			 * e.g. 
			 * a(White) -> b(White) -> c(White)
			 *  
			 * f(a)
			 * 	a(Black) -> b(Black) -> c(Black)
			 * 
			 * should we call f(b)?
			 * 	no need, b is black
			 * 
			 */
			/*THINK_FURTHER: what if we still consider BLACK vertices? the answer won't change because only vertex is called and is grey at same time would give
			 * deadlock; however, they're black means we already investigated them, then why bother doing it again. duplication    
			 */
			//if( hasCycle(vertex) ) {
			//QUESTION: is it possible at this point there exist grey vertex
			if( vertex.color!= MyColor.BLACK && hasCycle(vertex) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	//DFS
	private static boolean hasCycle( MyGraphVertex vertex ) {
		
		if( vertex.color == MyColor.GREY ) {
			//cut-off done further exploring; otherwise, program falls into infinite loop
			return true;
		}
		
		//the moment vertex start exploring, mark as grey
		vertex.color = MyColor.GREY;
		
		//explore neighbor
		for( MyGraphVertex neighbor : vertex.neighbors ) {
			
			//Likewise, it is possible that the neighbor is already visited by other vertex
			//if( vertex.color!= MyColor.BLACK && hasCycle( neighbor ) ) {
			if( vertex.color!= MyColor.BLACK ) { 
				//if( hasCycle( neighbor ) )  {
				boolean hasCycle = hasCycle( neighbor );
				if( hasCycle ) {
					return true;
				}	
			}
		}
		
		//the moment this vertex done exploring, mark as black
		
		return false;
	}
	
	
}




