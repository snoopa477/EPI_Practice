package c10_BinaryTrees.p08_ImplementAPreorderTraversalWithoutRecursion;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import util.MyBinaryTreeNode;
public class Test_ImplementAPreorderTraversalWithoutRecursion {

	public static void main( String[] main) {
		
		MyBinaryTreeNode<Integer> root_10_01 =  MyBinaryTreeNode.makeFigure10_01Tree();
		
		//Type mismatch: cannot convert from List<MyBinaryTreeNode<Integer>> to  List<MyBinaryTreeNode<Integer>>
		//List<MyBinaryTreeNode<Integer>> preorderList = ImplementAPreorderTraversalWithoutRecursion.preorder(root_10_01);
		
		List<MyBinaryTreeNode<Integer>> preorderList = ImplementAPreorderTraversalWithoutRecursion.preorder(root_10_01);
		
		for( MyBinaryTreeNode<Integer> node : preorderList ) {
			out.println( node );
		}
		
	}
	
	
}


