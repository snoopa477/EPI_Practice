package c10_BinaryTrees.p02_TestifABinarytreeisSymmetric;

import static java.lang.System.out;

import util.BinaryTreeNode;

public class _1002_TestifABinarytreeisSymmetric {

	public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
		return tree == null || checkSymmetric(tree.left, tree.right);
	}

	private static boolean checkSymmetric(BinaryTreeNode<Integer> subtree0
			, BinaryTreeNode<Integer> subtree1) {
		
		
		if (subtree0 == null && subtree1 == null) {
			return true;
			
		} 
		else if (subtree0 != null && subtree1 != null) {
			return subtree0.data == subtree1.data 
					&& checkSymmetric(subtree0.left, subtree1.right)
					&& checkSymmetric(subtree0.right, subtree1.left);
			
		}
		
		// One subtree is empty, and the other is not.
		return false;
	}
}
