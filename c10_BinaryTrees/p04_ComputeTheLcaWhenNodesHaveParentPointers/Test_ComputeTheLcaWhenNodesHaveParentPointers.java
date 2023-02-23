package c10_BinaryTrees.p04_ComputeTheLcaWhenNodesHaveParentPointers;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithParent;
public class Test_ComputeTheLcaWhenNodesHaveParentPointers {

	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithParent<Integer> root = MyBinaryTreeNodeWithParent.makeFigure10_01Tree();
		
		MyBinaryTreeNodeWithParent<Integer> nodeL = MyBinaryTreeNodeWithParent.findByTag(root, 'L');
		MyBinaryTreeNodeWithParent<Integer> nodeO = MyBinaryTreeNodeWithParent.findByTag(root, 'O');
		MyBinaryTreeNodeWithParent<Integer> nodeM = MyBinaryTreeNodeWithParent.findByTag(root, 'M');
		MyBinaryTreeNodeWithParent<Integer> nodeN = MyBinaryTreeNodeWithParent.findByTag(root, 'N');
		MyBinaryTreeNodeWithParent<Integer> nodeD = MyBinaryTreeNodeWithParent.findByTag(root, 'D');
		
		
		MyBinaryTreeNodeWithParent<Integer> root2 = MyBinaryTreeNodeWithParent.makeFigure10_01Tree();
		MyBinaryTreeNodeWithParent<Integer> nodeO2 = MyBinaryTreeNodeWithParent.findByTag(root2, 'O');
		
		out.println( ComputeTheLcaWhenNodesHaveParentPointers.LCA( nodeL, nodeO) );
		out.println( ComputeTheLcaWhenNodesHaveParentPointers.LCA( nodeM, nodeN) );
		out.println( ComputeTheLcaWhenNodesHaveParentPointers.LCA( nodeD, nodeM) );
		
		out.println( ComputeTheLcaWhenNodesHaveParentPointers.LCA( null, nodeM) );
		
		out.println( ComputeTheLcaWhenNodesHaveParentPointers.LCA( nodeL, nodeO2) );
		
	}

}


