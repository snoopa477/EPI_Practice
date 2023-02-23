package c10_BinaryTrees.p03_ComputeTheLowestCommonAncestorInABinaryTree;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class ComputeTheLowestCommonAncestorInABinaryTree {
	
	//total number of target nodes: node0 and node1 
	private static final int TWO = 2; 
	
	//DETAIL: info, result, or status
	private static class Status<T>{
		//counter of node0 and node1
		public int numTargetNodes;
		//ultimate goal
		public MyBinaryTreeNode<T> LCA;
		
		public Status(int numTargetNodes, MyBinaryTreeNode<T> lCA) {
			this.numTargetNodes = numTargetNodes;
			this.LCA = lCA;
		}
	}
	
	
	
	public static <T> MyBinaryTreeNode<T> LCA( MyBinaryTreeNode<T> currentNode, MyBinaryTreeNode<T> node0, MyBinaryTreeNode<T> node1 ){
		return LCA_Helper(currentNode, node0, node1).LCA;
	}
	
	
	
	private static <T> Status<T> LCA_Helper( MyBinaryTreeNode<T> currentNode, MyBinaryTreeNode<T> node0, MyBinaryTreeNode<T> node1 ){
		
		//REASONING: neither node0 nor node1 is null, so we don't find any
		if( currentNode == null ) {
			return new Status<T>(0, null);
		}
		
		
		Status<T> leftResult = LCA_Helper( currentNode.left, node0, node1 );
		/*REASONING: the subtree already met those two target nodes, meaning it also found the LCA
		 * , this node simply acts as a conductor, passing the result to parent
		 */
		if( leftResult.numTargetNodes == TWO ) {
			return leftResult;
		}
		
		
		Status<T> rightResult = LCA_Helper( currentNode.right, node0, node1 );
		if( rightResult.numTargetNodes == TWO ) {
			return rightResult;
		}
		
		//REASONING: reaching here, meaning none of above cases, now check the current node
		boolean isFoundTargetNode = currentNode == node0 || currentNode == node1;
		int numTargetNodes = ( isFoundTargetNode? 1 : 0 ) 
				+ leftResult.numTargetNodes
				+ rightResult.numTargetNodes;
		
		//REASONING: ONCE numTargetNodes == 2, this is the FIRST TIME == 2, and we can infer that this node is LCA
		//THINK_FURTHER: how can I infer that?
		if( numTargetNodes == TWO ) {
			return new Status<T>(numTargetNodes, currentNode);
		}
			
		//THINK_FURTHER: reaching here, we can infer that  0 <= numTargetNodes <=1
		return new Status<T>(numTargetNodes, null);
	}
	
	
}




