package c15_BinarySearchTrees.p02_FindTheFirstKeyGreaterThanAGivenValueInABst;

import static java.lang.System.out;

public class _1502_FindTheFirstKeyGreaterThanAGivenValueInABst {

	public static BSTNode<Integer> findFirstGreaterThanK(BSTNode<Integer> tree, Integer k) {
		BSTNode<Integer> subtree = tree, firstSoFar = null;
		while (subtree != null) {
			if (subtree.data > k) {
				firstSoFar = subtree;
				subtree = subtree.left;
			} else { // Root and all keys in left-subtree are <= k, so skip them.
				subtree = subtree.right;
			}
		}
		return firstSoFar;
	}
}
