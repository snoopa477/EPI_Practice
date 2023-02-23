package c10_BinaryTrees.p04_ComputeTheLcaWhenNodesHaveParentPointers;

import static java.lang.System.out;

import util.BinaryTree;
import util.BinaryTreeNode;

public class _1004_ComputeTheLcaWhenNodesHaveParentPointers {

	public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0, BinaryTree<Integer> node1) {
		int depth0 = getDepth(node0), depthl = getDepth(node1);
// Makes node(0 as the deeper node in order to simplify the code.
		if (depthl > depth0) {
			BinaryTree<Integer> temp = node0;
			node0 = node1;
			node1 = temp;
		}
// Ascends from the deeper node.
		int depthDiff = Math.abs(depth0 - depthl);
		while (depthDiff-- > 0) {
			node0 = node0.parent;
		}
// Now ascends both nodes until we reach the LCA.

		while (node0 != node1) {
			node0 = node0.parent;
			node1 = node1.parent;
		}
		return node0;
	}

	private static int getDepth(BinaryTree<Integer> node) {
		int depth = 0;
		while (node.parent != null) {
			++depth;
			node = node.parent;
		}
		return depth;
	}
}
