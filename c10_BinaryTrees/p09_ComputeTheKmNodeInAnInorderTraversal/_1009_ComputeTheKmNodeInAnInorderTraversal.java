package c10_BinaryTrees.p09_ComputeTheKmNodeInAnInorderTraversal;

import static java.lang.System.out;
import util.BinaryTreeNode;

public class _1009_ComputeTheKmNodeInAnInorderTraversal {

	public static BinaryTreeNode<Integer> findKthNodeBinaryTree(BinaryTreeNode<Integer> tree, int k) {
		BinaryTreeNode<Integer> iter = tree;
		while (iter != null) {
			int leftSize = iter.left != null ? iter.left.size : 0;
			if (leftSize + 1 < k) {// k-th node must be in right subtree of iter.
				k -= (leftSize + 1);
				iter = iter.right;
			} else if (leftSize == k - 1) {// k-th is iter itself.
				return iter;
			} else {// k-th node must be in left subtree of iter.
				iter = iter.left;
			}
		}

// If k is between 1 and the tree size, this line is unreachable .
		return null;
	}
}
