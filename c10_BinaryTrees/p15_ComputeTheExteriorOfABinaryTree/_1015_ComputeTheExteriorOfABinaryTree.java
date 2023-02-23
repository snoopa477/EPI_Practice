package c10_BinaryTrees.p15_ComputeTheExteriorOfABinaryTree;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

import util.ListNode;
import util.BinaryTreeNode;

public class _1015_ComputeTheExteriorOfABinaryTree {

	public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
		List<BinaryTreeNode<Integer>> exterior = new LinkedList<>();
		if (tree != null) {
			exterior.add(tree);
			exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
			exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
		}
		return exterior;
	}

// Computes the nodes from the root to the leftmost leaf followed by all the
// leaves in subtreeRoot.
	private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaves(BinaryTreeNode<Integer> subtreeRoot,
			boolean isBoundary) {
		List<BinaryTreeNode<Integer>> result = new LinkedList<>();
		if (subtreeRoot != null) {
			if (isBoundary || isLeaf(subtreeRoot)) {
				result.add(subtreeRoot);
			}
			result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
			result.addAll(leftBoundaryAndLeaves(subtreeRoot.right, isBoundary && subtreeRoot.left == null));
		}
		return result;
	}

// Computes the leaves in left-to-right order followed by the rightmost leaf
// to the root path in subtreeRoot.
	private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaves(BinaryTreeNode<Integer> subtreeRoot,
			boolean isBoundary) {
		List<BinaryTreeNode<Integer>> result = new LinkedList<>();
		if (subtreeRoot != null) {
			result.addAll(rightBoundaryAndLeaves(subtreeRoot.left, isBoundary && subtreeRoot.right == null));
			result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
			if (isBoundary || isLeaf(subtreeRoot)) {
				result.add(subtreeRoot);
			}

		}
		return result;

	}

	private static boolean isLeaf(BinaryTreeNode<Integer> node) {
		return node.left == null && node.right == null;
	}
}
