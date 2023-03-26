package c10_BinaryTrees.p15_ComputeTheExteriorOfABinaryTree;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import util.MyBinaryTreeNode;
public class ExteriorBinaryTree_04_myGoDown_while {

	public static boolean IS_DEBUG = false;
	
	public static <T> List<MyBinaryTreeNode<T>> exteriorOfTree( MyBinaryTreeNode<T> root ){
		
		if( root == null ) {
			return null;
		}
		
		List<MyBinaryTreeNode<T>> result = new ArrayList<>();
		
		result.add( root );
		
		goLeftDown(root.left, result);
		if( IS_DEBUG ) {
			out.println("goLeftDown");
			out.println( result );
		}
		
		leavesCollect(root, result);
		if( IS_DEBUG ) {
			out.println("goLeftDown + leavesCollect");
			out.println( result );
		}
		
		goRightUp(root.right, result);
		if( IS_DEBUG ) {
			out.println("goLeftDown + leavesCollect + goRightUp");
			out.println( result );
		}
		
		
		return result;
	}
	
	
	
	/**
	 *	return it collects left side of exterior part, except of leaf node 
	 */
	private static <T> void goLeftDown( MyBinaryTreeNode<T> root, List<MyBinaryTreeNode<T>> result ){
		
		List<MyBinaryTreeNode<T>> subResult = new ArrayList<>();
		
		MyBinaryTreeNode<T> currentNode = root;
		
		
		while( !(currentNode == null || isLeaf(currentNode)) ) {
			
			subResult.add( currentNode );
			
			//prepare the next node
			currentNode =  Optional.ofNullable(currentNode.left).
					orElse(currentNode.right);
		}
		
		result.addAll( subResult );
		
		
	}
	
	
	
	/**
	 *	return it collects right side of exterior part, except of leaf node 
	 */
	private static <T> void goRightUp( MyBinaryTreeNode<T> root, List<MyBinaryTreeNode<T>> result ){
		
		Deque<MyBinaryTreeNode<T>> reverseOrderList = new LinkedList<>();
		
		MyBinaryTreeNode<T> currentNode = root;
		
		
		while( !(currentNode == null || isLeaf(currentNode)) ) {
			
			//PURPOSE: reverse order, so it looks like 'go right up'
			reverseOrderList.addFirst( currentNode );
			
			currentNode =  Optional.ofNullable(currentNode.right).
					orElse(currentNode.left);
		}
		
		result.addAll( reverseOrderList );
	}
	
	
	
	private static <T> void leavesCollect( MyBinaryTreeNode<T> root, List<MyBinaryTreeNode<T>> result ) {
		
		if( root == null ) {
			return;
		}
		
		if( isLeaf(root) ) {
			result.add( root );
		}
		
		leavesCollect( root.left, result );
		leavesCollect( root.right, result );
	}
	
	
	
	private static <T> boolean isLeaf( MyBinaryTreeNode<T> root ){
		return root.left == null && root.right == null;
	}
	
}


