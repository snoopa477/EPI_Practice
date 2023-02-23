package c10_BinaryTrees.p03_ComputeTheLowestCommonAncestorInABinaryTree;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class Test_ComputeTheLowestCommonAncestorInABinaryTree {

	
	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> root = MyBinaryTreeNode.makeFigure10_01Tree();
		
		MyBinaryTreeNode<Integer> nodeL = MyBinaryTreeNode.findByTag(root, 'L');
		MyBinaryTreeNode<Integer> nodeO = MyBinaryTreeNode.findByTag(root, 'O');
		MyBinaryTreeNode<Integer> nodeM = MyBinaryTreeNode.findByTag(root, 'M');
		MyBinaryTreeNode<Integer> nodeN = MyBinaryTreeNode.findByTag(root, 'N');
		MyBinaryTreeNode<Integer> nodeD = MyBinaryTreeNode.findByTag(root, 'D');
		
		out.println( ComputeTheLowestCommonAncestorInABinaryTree.LCA(root, nodeL, nodeO) );
		out.println( ComputeTheLowestCommonAncestorInABinaryTree.LCA(root, nodeM, nodeN) );
		out.println( ComputeTheLowestCommonAncestorInABinaryTree.LCA(root, nodeD, nodeM) );
		
		out.println( ComputeTheLowestCommonAncestorInABinaryTree.LCA(root, null, nodeM) );
		
	}
	
	
	
	
	
}


