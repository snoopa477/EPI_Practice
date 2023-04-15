package c19_Graphs.p05_CloneAGraph;
import static java.lang.System.out;

import util.MyGraphVertex;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneAGraph_01_BFS {

	public static MyGraphVertex cloneGraph( MyGraphVertex targetVertex ) {
		
		/**
		 *  
		 */
		//REVIEW: queue: serves as time stamp: first come first serve
		Queue<MyGraphVertex> elementsToBuildEdges = new LinkedList<>();
		
		/**
		 * This also serves as 2 color: WHITE and BLACK
		 * we don't need GREY, since we don't need to detect cycle or not.
		 * 
		 * not having given element in map means equivalent to WHITE
		 * having given element in map means equivalent to BLACK 
		 */
		//seenOldVertex_to_newVertex
		//HashMap<String, MyGraphVertex> seenOld_to_new = new HashMap<String, MyGraphVertex>();
		HashMap<MyGraphVertex, MyGraphVertex> seenOld_to_new = new HashMap<MyGraphVertex, MyGraphVertex>();
		
		//IMAGINATION: a dummy (null) vertex's only neighbor is targetVertex, it is not visited yet. It is first seen, so add to both queue and map
		//To start off, add given element to both queue and map unconditionally
		
		seenOld_to_new.put( targetVertex, new MyGraphVertex( targetVertex.label ) );
		
		//WRONG
		//elementsToBuildEdges.add( seenOld_to_new.get( targetVertex.label) );
		elementsToBuildEdges.add( targetVertex );
		
		//PURPOSE: add edges for all vertex after creating new node if necessary
		while( elementsToBuildEdges.size() > 0 ) {
			
			//--
			MyGraphVertex elementToBuildEdges = elementsToBuildEdges.poll();
			
			//DETAIL: only old vertices have edges, so queue stores old vertices not new ones
			//explore neighbors, some might already seen( and then processed) and some might not
			for( MyGraphVertex neighbor: elementToBuildEdges.neighbors ) {
				
				
				//unseen neighbors
				if( seenOld_to_new.containsKey(neighbor) == false ) {
					
					//seen
					seenOld_to_new.put(neighbor, new MyGraphVertex( neighbor.label ) );
					
					//in waiting queue
					//++
					elementsToBuildEdges.add( neighbor  );
				}
				
				//THINK_FURTHER: no matter first seen or not, neighbor has to exist before building edge with `elementToBuildEdge`
				//reaching here, we can infer that all neighbors are seen now
				
				//elementToBuildEdges.neighbors.add( seenOld_to_new.get( neighbor.label ) );
				//DETAIL only new vertices needs to build edge
				seenOld_to_new.get( elementToBuildEdges ).neighbors.add( seenOld_to_new.get( neighbor ) );
			}
		}
		
		
		
		return seenOld_to_new.get( targetVertex );
	}
	
	
}


