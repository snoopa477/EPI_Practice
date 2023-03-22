package c10_BinaryTrees.p14_FormALinkedListFromTheLeavesOfABinaryTree;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import util.MyBinaryTreeNode;
public class FormALinkedListFromTheLeavesOfABinaryTree_04_better {
	
	public static <T> List<MyBinaryTreeNode<T>> getLeaves( MyBinaryTreeNode<T> root ){
		
		List<MyBinaryTreeNode<T>> leavesCollector = new ArrayList<>();
		getLeavesHelper( root, leavesCollector );
		return leavesCollector;
	}
	
	
	
	private static <T> void getLeavesHelper( MyBinaryTreeNode<T> currentNode, List<MyBinaryTreeNode<T>> leavesCollector ) {
		
		if( currentNode == null ) {
			return;
		}

		
		if( currentNode.left == null && currentNode.right == null ) {
			leavesCollector.add( currentNode );
			/*REASONING: since our mission is to collect leaves, going to null--which is the next step-- doesn't help
			 * just cut off going either to left or right because they're both null 
			 * ( even if we don't cut off, it doesn't affect result because null has no effect to result, nor does it affect the execution flow) 
			 */
			//QUESTION: on first glance it's kinda weird since it doesn't look like pre, in, nor post order. 
			return;
		}
		getLeavesHelper( currentNode.left, leavesCollector );
		getLeavesHelper( currentNode.right, leavesCollector );
		
		
		
	}
}


