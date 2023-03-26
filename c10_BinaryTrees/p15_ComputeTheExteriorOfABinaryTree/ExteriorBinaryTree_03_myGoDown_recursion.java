package c10_BinaryTrees.p15_ComputeTheExteriorOfABinaryTree;
import static java.lang.System.out;

import util.MyBinaryTreeNode;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

//REFERENCE: Test_ExteriorBinaryTree_01_return
public class ExteriorBinaryTree_03_myGoDown_recursion {

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
		
		if( root == null ||
			//except leaf node
			isLeaf( root ) ) {
			return;
		}
		
		result.add( root );
		//REASONING: go left if possible, if there's no left, go right
		MyBinaryTreeNode<T> nextNode = Optional.ofNullable(root.left).
				orElse(root.right);
		goLeftDown(nextNode, result);
	}
	
	
	
	private static <T> void goRightUp( MyBinaryTreeNode<T> root, List<MyBinaryTreeNode<T>> result ){
		
		if( root == null ||
			//except leaf node
			isLeaf( root ) ) {
			return;
		}
		
		//REASONING: go right if possible, if there's no right, go left
		MyBinaryTreeNode<T> nextNode = Optional.ofNullable(root.right).
				orElse(root.left);
		goRightUp(nextNode, result);
		
		result.add( root );
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


