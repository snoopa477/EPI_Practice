package c10_BinaryTrees.p09_ComputeTheKmNodeInAnInorderTraversal;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithSize;
public class Test_getKthNodeInorderTraversal {

	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithSize<Integer> root10_01 = MyBinaryTreeNodeWithSize.makeFigure10_01Tree();
		
		
		out.println( ComputeTheKmNodeInAnInorderTraversal.getKthNodeInorderTraversal( root10_01, 3) );
		out.println( ComputeTheKmNodeInAnInorderTraversal.getKthNodeInorderTraversal( root10_01, 5) );
		out.println( ComputeTheKmNodeInAnInorderTraversal.getKthNodeInorderTraversal( root10_01, 7) );
		out.println( ComputeTheKmNodeInAnInorderTraversal.getKthNodeInorderTraversal( root10_01, 8) );
		out.println( ComputeTheKmNodeInAnInorderTraversal.getKthNodeInorderTraversal( root10_01, 9) );
		out.println( ComputeTheKmNodeInAnInorderTraversal.getKthNodeInorderTraversal( root10_01, 30) );
		
	}

}


