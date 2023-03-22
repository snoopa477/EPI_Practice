package c10_BinaryTrees.p14_FormALinkedListFromTheLeavesOfABinaryTree;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import util.MyBinaryTreeNode;

public class FormALinkedListFromTheLeavesOfABinaryTree_01_preorder {

	
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
		}
		
		getLeavesHelper( currentNode.left, leavesCollector );
		getLeavesHelper( currentNode.right, leavesCollector );
	}
	
}






