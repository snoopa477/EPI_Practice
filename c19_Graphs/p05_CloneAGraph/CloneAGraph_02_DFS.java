package c19_Graphs.p05_CloneAGraph;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import util.MyGraphVertex;
public class CloneAGraph_02_DFS {
	
	public static MyGraphVertex cloneGraph( MyGraphVertex targetVertex ) {
		

		HashMap<MyGraphVertex, MyGraphVertex> seenOld_to_new = new HashMap<MyGraphVertex, MyGraphVertex>();
		seenOld_to_new.put( targetVertex, new MyGraphVertex( targetVertex.label ) );
		setEdgeHelper(targetVertex, seenOld_to_new );
		
		
		return seenOld_to_new.get( targetVertex );
	}
	
	
	
	//THINK_FURTHER: why BFS needs queue to store elements but DFS don't? natural call stacks
	private static void setEdgeHelper( MyGraphVertex targetVertex, HashMap<MyGraphVertex, MyGraphVertex> seenOld_to_new ) {
		
		//DETAIL: the base case is no neighbor, or all neighbors are already seen
		
		for( MyGraphVertex neighbor : targetVertex.neighbors ) {
			
			if( seenOld_to_new.containsKey(neighbor) == false ) {
				seenOld_to_new.put(neighbor, new MyGraphVertex( neighbor.label ) );
				
				//DFS
				//IMAGINATION: current.left, current.right
				setEdgeHelper( neighbor, seenOld_to_new );
			}
			
			//set edge
			seenOld_to_new.get( targetVertex ).neighbors.add( seenOld_to_new.get( neighbor ) );
			
			
			//WRONG if i place this code here, meaning any neghbor, including visited one could go; however, if there's cycle -> infinite loop and stack overflow
			//setEdgeHelper( neighbor, seenOld_to_new );
		}
		
	}

}


