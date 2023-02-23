package c13_HashTable.p04_ComputeTheLcaOptimizingForCloseAncestors;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Set;

public class _1304_ComputeTheLcaOptimizingForCloseAncestors {

	public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0, BinaryTree<Integer> node1) {
		Set<BinaryTree<Integer>> hash = new HashSet<>();
		while (node0 != null || node1 != null) {
// Ascend tree in tandem from these two nodes.
			if (node0 != null) {
				if (!hash.add(node0)) {
					return node0;
				}
				node0 = node0.parent;
			}
			if (node1 != null) {
				if (!hash.add(node1)) {
					return node1;
				}
				node1 = node1.parent;
			}
		}
		throw new IllegalArgumentException("node0 and nodel are not in the same tree");
	}
}
