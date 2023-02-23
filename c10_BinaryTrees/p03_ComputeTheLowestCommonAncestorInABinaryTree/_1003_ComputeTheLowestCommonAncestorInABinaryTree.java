package c10_BinaryTrees.p03_ComputeTheLowestCommonAncestorInABinaryTree;

import static java.lang.System.out;
import util.BinaryTreeNode;

public class _1003_ComputeTheLowestCommonAncestorInABinaryTree {

	private static class Status {
		public int numTargetNodes;
		public BinaryTreeNode<Integer> ancestor;

		public Status(int numTargetNodes, BinaryTreeNode<Integer> node) {
			this.numTargetNodes = numTargetNodes;
			this.ancestor = node;
		}
	}

	
	
	public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
		return LCAHelper(tree, node0, node1).ancestor;
	}

	
	
// Returns an object consisting of an int and a node. The int field is
// 0, 1, or 2 depending on how many of {node0, nodel} are present in
// the tree. If both are present in the tree, when ancestor is
// assigned to a non-null value, it is the LCA.
	private static Status LCAHelper(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> nodel) {
		
		if (tree == null) {
			return new Status(0, null);
		}
		
		Status leftResult = LCAHelper(tree.left, node0, nodel);
		
		if (leftResult.numTargetNodes == 2) {
// Found both nodes in the left subtree.
			return leftResult;
		}
		
		Status rightResult = LCAHelper(tree.right, node0, nodel);
		
		if (rightResult.numTargetNodes == 2) {
// Found both nodes in the right subtree.
			return rightResult;
		}
		
		int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes + (tree == node0 ? 1 : 0) + (tree == nodel ? 1 : 0);
		
		return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);

	}
}
