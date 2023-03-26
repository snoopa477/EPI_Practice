package c10_BinaryTrees.p15_ComputeTheExteriorOfABinaryTree;
import static java.lang.System.out;
import util.MyBinaryTreeNode;

import java.util.ArrayList;
import java.util.List;


public class Test_ExteriorBinaryTree_01_return {

	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> root_10_01 = MyBinaryTreeNode.makeFigure10_01Tree();
		
		out.println("-------------------------ExteriorBinaryTree_01_return");
		out.println( ExteriorBinaryTree_01_return.exteriorOfTree( root_10_01 ) );
		
		
		out.println("\n-------------------------ExteriorBinaryTree_02_parameter");
		out.println( ExteriorBinaryTree_02_parameter.exteriorOfTree(root_10_01) );
		
		
		out.println("\n-------------------------ExteriorBinaryTree_03_myGoDown_recursion");
		ExteriorBinaryTree_03_myGoDown_recursion.IS_DEBUG = false;
		out.println( ExteriorBinaryTree_03_myGoDown_recursion.exteriorOfTree(root_10_01) );
		
		
		out.println("\n-------------------------ExteriorBinaryTree_04_myGoDown_while");
		out.println( ExteriorBinaryTree_04_myGoDown_while.exteriorOfTree(root_10_01) );
		
		
		out.println("\n-------------------------left_ExteriorFrom_Bottom");
		out.println( left_ExteriorFrom_Bottom(root_10_01) );
		
		
		out.println("\n-------------------------left_ExteriorFrom_Top");
		out.println( left_ExteriorFrom_Top(root_10_01) );
		
		
		out.println("\n-------------------------right_ExteriorFrom_Bottom");
		out.println( right_ExteriorFrom_Bottom(root_10_01) );
		
		
		out.println("\n-------------------------right_ExteriorFrom_Top");
		out.println( right_ExteriorFrom_Top(root_10_01) );
		
		
	}
	
	
	private static <T> List<MyBinaryTreeNode<T>> left_ExteriorFrom_Bottom( MyBinaryTreeNode<T> root ){
		List<MyBinaryTreeNode<T>> result = new ArrayList<>();
		left_ExteriorFrom_Bottom(root, true, result);
		return result;
	}
	
	
	
	private static <T> void left_ExteriorFrom_Bottom( MyBinaryTreeNode<T> root, boolean isLeftBoundary, List<MyBinaryTreeNode<T>> result ){
		
		if( root == null ) {
			return;
		}
		
		
		boolean isLeft_ChildOnBoundary = isLeftBoundary;
		left_ExteriorFrom_Bottom( root.left, isLeft_ChildOnBoundary, result );
		
		
		boolean isRight_ChildOnBoundary = isLeftBoundary && root.left == null;
		left_ExteriorFrom_Bottom( root.right, isRight_ChildOnBoundary, result );
		
		
		if( isLeftBoundary ) {
			result.add( root );
		}
		
		return;
	}
	
	
	
	private static <T> List<MyBinaryTreeNode<T>> left_ExteriorFrom_Top( MyBinaryTreeNode<T> root ){
		List<MyBinaryTreeNode<T>> result = new ArrayList<>();
		left_ExteriorFrom_Top(root, true, result);
		return result;
	}
	
	
	
	private static <T> void left_ExteriorFrom_Top( MyBinaryTreeNode<T> root, boolean isLeftBoundary, List<MyBinaryTreeNode<T>> result ){
		
		if( root == null ) {
			return;
		}
		
		
		if( isLeftBoundary ) {
			result.add( root );
		}
		

		boolean isLeft_ChildOnBoundary = isLeftBoundary;
		left_ExteriorFrom_Top( root.left, isLeft_ChildOnBoundary, result );
		
		
		boolean isRight_ChildOnBoundary = isLeftBoundary && root.left == null;
		left_ExteriorFrom_Top( root.right, isRight_ChildOnBoundary, result );
		
		return;
	}
	
	
	
	private static <T> List<MyBinaryTreeNode<T>> right_ExteriorFrom_Bottom( MyBinaryTreeNode<T> root ){
		List<MyBinaryTreeNode<T>> result = new ArrayList<>();
		right_ExteriorFrom_Bottom(root, true, result);
		return result;
	}
	
	
	
	private static <T> void right_ExteriorFrom_Bottom( MyBinaryTreeNode<T> root, boolean isRightBoundary, List<MyBinaryTreeNode<T>> result ){
		
		if( root == null ) {
			return;
		}
		
		
		boolean isLeft_ChildOnBoundary = isRightBoundary && root.right == null;
		right_ExteriorFrom_Bottom( root.left, isLeft_ChildOnBoundary, result );
		
		
		
		boolean isRight_ChildOnBoundary = isRightBoundary ;
		right_ExteriorFrom_Bottom( root.right, isRight_ChildOnBoundary, result );
		
		
		
		if( isRightBoundary ) {
			result.add( root );
		}
		
		return;
		
	}
	
	
	
	private static <T> List<MyBinaryTreeNode<T>> right_ExteriorFrom_Top( MyBinaryTreeNode<T> root ){
		List<MyBinaryTreeNode<T>> result = new ArrayList<>();
		right_ExteriorFrom_Top(root, true, result);
		return result;
	}
	
	
	
	private static <T> void right_ExteriorFrom_Top( MyBinaryTreeNode<T> root, boolean isRightBoundary, List<MyBinaryTreeNode<T>> result ){
		
		if( root == null ) {
			return;
		}
		
		
		if( isRightBoundary ) {
			result.add( root );
		}
		
		
		boolean isLeft_ChildOnBoundary = isRightBoundary && root.right == null;
		right_ExteriorFrom_Top( root.left, isLeft_ChildOnBoundary, result );
		
		
		
		boolean isRight_ChildOnBoundary = isRightBoundary ;
		right_ExteriorFrom_Top( root.right, isRight_ChildOnBoundary, result );
		
		return;
	}
	
	

}






