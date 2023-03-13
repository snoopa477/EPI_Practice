package c10_BinaryTrees.p07_ImplementAnInorderTraversalWithoutRecursion;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
import java.util.ArrayList;

public class Test_ImplementAnInorderTraversalWithoutRecursion {

	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> root_10_01 =  MyBinaryTreeNode.makeFigure10_01Tree();
		
		ArrayList<MyBinaryTreeNode<Integer>> inorderList = ImplementAnInorderTraversalWithoutRecursion.inorderWithoutRecursion(root_10_01);
		
		for( MyBinaryTreeNode<Integer> node : inorderList ) {
			out.println( node );
		}
		
		
	}

}


