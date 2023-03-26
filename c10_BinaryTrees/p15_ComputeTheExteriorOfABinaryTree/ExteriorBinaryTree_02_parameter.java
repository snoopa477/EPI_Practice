package c10_BinaryTrees.p15_ComputeTheExteriorOfABinaryTree;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import util.MyBinaryTreeNode;
public class ExteriorBinaryTree_02_parameter {
	
public static <T> List<MyBinaryTreeNode<T>> exteriorOfTree( MyBinaryTreeNode<T> root ){
		
		List<MyBinaryTreeNode<T>> boundsAndLeaves = new ArrayList<>();
		
		if( root == null ) {
			return boundsAndLeaves;
		}
		
		boundsAndLeaves.add( root );
		left_BoundAndLeaves( root.left, true, boundsAndLeaves);
		right_BoundAndLeaves( root.right, true, boundsAndLeaves);
		
		return boundsAndLeaves;
	}
	
	
	

	private static <T> void left_BoundAndLeaves( MyBinaryTreeNode<T> root, boolean isLeftBoundary, List<MyBinaryTreeNode<T>> boundsAndLeaves ){
		
		if( root == null ) {
			return;
		}
		
		
		if( isLeftBoundary || isLeaf(root) ) {
			boundsAndLeaves.add( root );
		}
		

		boolean isLeft_ChildOnBoundary = isLeftBoundary;
		left_BoundAndLeaves( root.left, isLeft_ChildOnBoundary, boundsAndLeaves );
		
		
		boolean isRight_ChildOnBoundary = isLeftBoundary && root.left == null;
		left_BoundAndLeaves( root.right, isRight_ChildOnBoundary, boundsAndLeaves );
		
		return;
	}
	
	
	
	private static <T> void right_BoundAndLeaves( MyBinaryTreeNode<T> root, boolean isRightBoundary, List<MyBinaryTreeNode<T>> boundsAndLeaves ){
		
		if( root == null ) {
			return;
		}
		
		
		boolean isLeft_ChildOnBoundary = isRightBoundary && root.right == null;
		right_BoundAndLeaves( root.left, isLeft_ChildOnBoundary, boundsAndLeaves );
		
		
		
		boolean isRight_ChildOnBoundary = isRightBoundary ;
		right_BoundAndLeaves( root.right, isRight_ChildOnBoundary, boundsAndLeaves );
		
		
		
		if( isRightBoundary || isLeaf(root) ) {
			boundsAndLeaves.add( root );
		}
		
		return;
	}
	
	
	
	private static <T> boolean isLeaf( MyBinaryTreeNode<T> root ){
		return root.left == null && root.right == null;
	}

}


