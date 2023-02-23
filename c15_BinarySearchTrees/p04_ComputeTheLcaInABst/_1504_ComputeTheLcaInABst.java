package c15_BinarySearchTrees.p04_ComputeTheLcaInABst;

import static java.lang.System.out;

public class _1504_ComputeTheLcaInABst {

	// Input nodes are not null and the key at s is less than or equal to that at
	// b.
	public static BSTNode<Integer> findLCA(BSTNode<Integer> tree, BSTNode<Integer> s, BSTNode<Integer> b) {
		BSTNode<Integer> p = tree;
		while (p.data < s.data || p.data > b.data) {
			// Keep searching since p is outside of [s, b].
			while (p.data < s.data) {
				p = p.right; // LCA must be in p's right child.
			}
			while (p.data > b.data) {
				p = p.left; // LCA must be in p's left child.
			}
		}
		// Now, s.data >= p.data && p.data <- b.data.
		return p;
	}
}
