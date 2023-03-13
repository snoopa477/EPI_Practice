package c10_BinaryTrees.p11_ImplementAnInorderTraversalWith00_01Space;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithParent;
import java.util.ArrayList;

public class Test_ImplementAnInorderTraversalWith00_01Space {

	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithParent<Integer> root_10_01 = MyBinaryTreeNodeWithParent.makeFigure10_01Tree();
		
		
		ArrayList<MyBinaryTreeNodeWithParent<Integer>> inorderList =  ImplementAnInorderTraversalWith00_01Space.inorderTraversal( root_10_01 );
		
		out.println( inorderList );
		
		
	}

}


