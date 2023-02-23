package c10_BinaryTrees.p04_ComputeTheLcaWhenNodesHaveParentPointers;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithParent;
public class ComputeTheLcaWhenNodesHaveParentPointers {

	
	/*REASONING: it would be better to track from current node to root, since it's the only way; however, starting with root will be faced with problem that
	 * every attempt to reach current node, there's two path to decide
	*/
	//IMAGINATION: depth is like number of linkage
	//DETAIL: without <T> the wrong message would be: T cannot be resolved to a type
	//private static int getDepth( MyBinaryTreeNodeWithParent<T> node ) {
	private static<T> int getDepth( MyBinaryTreeNodeWithParent<T> node ) {
		
		if( node == null ) {
			return -1;
		}
		
		int depth = 0;
		MyBinaryTreeNodeWithParent<T> currentNode = node;
		
		//REASONING: null is one step above root. can think of it as tail of a link list
		while( currentNode != null ) {
			currentNode = currentNode.parent;
			if( currentNode != null) {
				depth ++;
			}
		}
		
		return depth;
	}
	
	
	
	public static<T> MyBinaryTreeNodeWithParent<T> LCA( MyBinaryTreeNodeWithParent<T> node0, MyBinaryTreeNodeWithParent<T> node1 ){
		
		/**
		 * STEPS:
		 * step 1: make both nodes at the same depth by going up lower node
		 * step 2. both nodes go up at the same time, until they meet where it is LCA
		 * 	, or they both reach null-- which is one node above root-- at the same time, because they start with same depth 
		 */
		
		//PURPOSE: step1
		
		int depth0 = getDepth( node0 );
		//If a node is null, then there must be no LCA
		if( depth0 == -1 ) {
			return null;
		}
		
		
		int depth1 = getDepth( node1 );
		if( depth1 == -1 ) {
			return null;
		}
		
		int depthDiff = depth0 - depth1;
		//DETAIL: that's rename both nodes. nodeA is a node that is lower or equal height to nodeB
		MyBinaryTreeNodeWithParent<T> nodeA =  depthDiff > 0? node0 : node1;
		MyBinaryTreeNodeWithParent<T> nodeB = nodeA == node0? node1 : node0;
		
		for( int i = 0; i < Math.abs(depthDiff); i++) {
			nodeA = nodeA.parent;
		}
		
		//REASONING: now both nodeA and node B are on the same level
		
		//PURPOSE step 2
		
		while( nodeA != nodeB ) {
			nodeA = nodeA.parent;
			nodeB = nodeB.parent;
		}
		
		//reaching here nodeA == nodeB, nodeA is either LCA if they have common node, or null if they don't have common node
		if( nodeA != null ) {
			return nodeA;
		}
		//DETAIL: In the viewpoint of code, it's redundant; however, it my viewpoint, I can better understand
		else {
			return null;
		}
		
	}
	
	
}








