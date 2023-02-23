package c10_BinaryTrees.p05_SumTheRootToLeafPathsInABinaryTree;

import static java.lang.System.out;
import util.BinaryTreeNode;

public class _1005_SumTheRootToLeafPathsInABinaryTree {

	public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
		return sumRootToLeafHelper(tree, 0);
	}

	private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialPathSum) {
		if (tree == null) {
			return 0;
		}
		partialPathSum = partialPathSum * 2 + tree.data;
		if (tree.left == null && tree.right == null) { // Leaf.
			return partialPathSum;
		}
// Son-leaf .
		return sumRootToLeafHelper(tree.left, partialPathSum) + sumRootToLeafHelper(tree.right, partialPathSum);
	}
}
