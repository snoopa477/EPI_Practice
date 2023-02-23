package c10_BinaryTrees.p06_FindARootToLeafPathWithSpecifiedSum;

import static java.lang.System.out;
import util.BinaryTreeNode;

public class _1006_FindARootToLeafPathWithSpecifiedSum {

	public static boolean hasPathSum(BinaryTreeNode<Integer> tree, int targetSum) {
		return hasPathSumHelper(tree, 0, targetSum);
	}

	private static boolean hasPathSumHelper(BinaryTreeNode<Integer> node, int partialPathSum, int targetSum) {
		if (node == null) {
			return false;
		}
		partialPathSum += node.data;
		if (node.left == null && node.right == null) { // Leaf.
			return partialPathSum == targetSum;
		}
// Non-leaf .
		return hasPathSumHelper(node.left, partialPathSum, targetSum)
				|| hasPathSumHelper(node.right, partialPathSum, targetSum);
	}
}
