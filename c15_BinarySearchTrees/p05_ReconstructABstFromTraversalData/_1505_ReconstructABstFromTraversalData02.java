package c15_BinarySearchTrees.p05_ReconstructABstFromTraversalData;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1505_ReconstructABstFromTraversalData02 {

	// Global variable, tracks current subtree.
	private static Integer rootIdx;

	public static BSTNode<Integer> rebuildBSTFromPreorder(List<Integer> preorderSequence) {
		rootIdx = 0;
		return rebuildBSFromPreorderOnValueRange(preorderSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// Builds a BST on the subtree rooted at rootldx from preorderSequence on keys
	// in (lowerBound, upperBound).
	private static BSTNode<Integer> rebuildBSFromPreorderOnValueRange(List<Integer> preorderSequence,
			Integer lowerBound, Integer upperBound) {
		if (rootldx == preorderSequence.size()) {
			return null;
		}
		Integer root = preorderSequence.get(rootIdx);
		if (root < lowerBound || root > upperBound) {
			return null;
		}
		++rootIdx;
		// Note that rebuildBSFromPreorderOnValueRange updates rootldx. So the order
		// of following two calls are critical.
		BSTNode<Integer> leftSubtree = rebuildBSFromPreorderOnValueRange(preorderSequence, lowerBound, root);
		BSTNode<Integer> rightSubtree = rebuildBSFromPreorderOnValueRange(preorderSequence, root, upperBound);
		return new BSTNode<>(root, leftSubtree, rightSubtree);

	}
}
