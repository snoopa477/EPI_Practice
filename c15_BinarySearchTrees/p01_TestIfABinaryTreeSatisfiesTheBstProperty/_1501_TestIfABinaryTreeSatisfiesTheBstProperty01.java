package c15_BinarySearchTrees.p01_TestIfABinaryTreeSatisfiesTheBstProperty;

import static java.lang.System.out;

import util.BinaryTreeNode;

public class _1501_TestIfABinaryTreeSatisfiesTheBstProperty01 {

	public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
		return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean areKeysInRange(BinaryTreeNode<Integer> tree, Integer lower, Integer upper) {
		if (tree == null) {
			return true;
		} else if (Integer.compare(tree.data, lower) < 0 || Integer.compare(tree.data, upper) > 0) {
			return false;
		}

		return areKeysInRange(tree.left, lower, tree.data) && areKeysInRange(tree.right, tree.data, upper);

	}
}
