package c10_BinaryTrees.p15_ComputeTheExteriorOfABinaryTree;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
import java.util.List;
import java.util.ArrayList;

public class ExteriorBinaryTree_01_return {

	public static <T> List<MyBinaryTreeNode<T>> exteriorOfTree( MyBinaryTreeNode<T> root ){
		
		List<MyBinaryTreeNode<T>> boundsAndLeaves = new ArrayList<>();
		
		if( root == null ) {
			return boundsAndLeaves;
		}
		
		//WRONG: forget to add
		boundsAndLeaves.add( root );
		boundsAndLeaves.addAll( left_BoundAndLeaves( root.left, true) );
		boundsAndLeaves.addAll( right_BoundAndLeaves( root.right, true) );
		
		return boundsAndLeaves;
	}
	
	
	
	/**
	 * THINK_FURTHER:
	 * what factor leads to what consequences?
	 * preorder or postorder affects the sequence of collecting answer, and is independent of boundary or not
	 * the boundary status of current node, and whether child node having siblings affects a child will be on boundary or not 
	 */
	private static <T> List<MyBinaryTreeNode<T>> left_BoundAndLeaves( MyBinaryTreeNode<T> root, boolean isLeftBoundary ){
		
		if( root == null ) {
			return new ArrayList<>();
			//WRONG: would cause nullpointer exception when answer try to colect?
			//return null;
		}
		
		
		List<MyBinaryTreeNode<T>> leftBoundAndLeaves = new ArrayList<>();
		
		if( isLeftBoundary || isLeaf(root) ) {
			leftBoundAndLeaves.add( root );
		}
		
		/*REASONING:
		 * isLeftBoundary of left node
		 * if current node is on left boundary, its left node will be on left boundary
		 * if current node is not on left boundary, its left node will not be on left boundary
		 */
		//boolean isLeft_ChildLeftBoundary = isLeftBoundary;
		boolean isLeft_ChildOnBoundary = isLeftBoundary;
		List<MyBinaryTreeNode<T>> leftResult = left_BoundAndLeaves( root.left, isLeft_ChildOnBoundary );
		//I don't like succinct, because I have to remember so many things in one line, and the main purpose is blurred
		//beside, it's hard for me that the first parameter ( root.left) has something to do with second parameter ( is leftboundary or not ) 
		//leftBoundAndLeaves.addAll( leftBoundAndLeaves( root.left, isLeftBoundary ) );
		leftBoundAndLeaves.addAll( leftResult );
		
		
		/*REASONING:
		 * isLeftBoundary of right node
		 * if current node is on left boundary, its right node will be on left boundary, ONLY IF the left node is not exist
		 * if current node is not on left boundary, its right node will not be on left boundary
		 */
		/**
		 * DETAIL: how I should read  isLeftBoundary && root.left == null?
		 * for right node of is leftBoundary
		 * if its parent is on left boundary, and it doesn't have left sibling -> it will be on left boundary
		 * if its parent is not on left boundary -> cut off further consideration -> it will NOT on left boundary
		 */
		boolean isRight_ChildOnBoundary = isLeftBoundary && root.left == null;
		//WRONG: TYPO
		//List<MyBinaryTreeNode<T>> rightResult = left_BoundAndLeaves( root.left, isRight_ChildOnBoundary );
		List<MyBinaryTreeNode<T>> rightResult = left_BoundAndLeaves( root.right, isRight_ChildOnBoundary );
		leftBoundAndLeaves.addAll( rightResult );
		
		return leftBoundAndLeaves;
	}
	
	
	
	//similar logic to leftBoundAndLeaves, but with different collecting order, and different bound side
	private static <T> List<MyBinaryTreeNode<T>> right_BoundAndLeaves( MyBinaryTreeNode<T> root, boolean isRightBoundary ){
		
		if( root == null ) {
			return new ArrayList<>();
		}
		
		
		List<MyBinaryTreeNode<T>> rightBoundAndLeaves = new ArrayList<>();
		
		
		//boolean isLeft_ChildRightBoundary = isRightBoundary && root.right == null;
		boolean isLeft_ChildOnBoundary = isRightBoundary && root.right == null;
		List<MyBinaryTreeNode<T>> leftResult = right_BoundAndLeaves( root.left, isLeft_ChildOnBoundary );
		rightBoundAndLeaves.addAll( leftResult );
		
		
		
		boolean isRight_ChildOnBoundary = isRightBoundary ;
		List<MyBinaryTreeNode<T>> rightResult = right_BoundAndLeaves( root.right, isRight_ChildOnBoundary );
		rightBoundAndLeaves.addAll( rightResult );
		
		
		
		if( isRightBoundary || isLeaf(root) ) {
			rightBoundAndLeaves.add( root );
		}
		
		return rightBoundAndLeaves;
	}
	
	
	
	private static <T> boolean isLeaf( MyBinaryTreeNode<T> root ){
		return root.left == null && root.right == null;
	}
	
}


