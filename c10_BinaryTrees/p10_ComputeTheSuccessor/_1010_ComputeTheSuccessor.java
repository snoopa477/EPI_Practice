package c10_BinaryTrees.p10_ComputeTheSuccessor;

import static java.lang.System.out;

public class _1010_ComputeTheSuccessor {

	public static BinaryTree<Integer> findSuccessor(BinaryTree<Integer> node) {
		BinaryTree<Integer> iter = node;
		if (iter.right != null) {
// Find the leftmost element in node's right subtree.
			iter = iter.right;
			while (iter.left != null) {
				iter = iter.left;
			}
			return iter;

		}

// Find the closest ancestor whose left subtree contains node.
		while (iter.parent != null && iter.parent.right == iter) {
			iter = iter.parent;
		}
// A return value of null means node does not have successor, i.e., it is
// the rightmost node in the tree.
		return iter.parent;

	}
}
