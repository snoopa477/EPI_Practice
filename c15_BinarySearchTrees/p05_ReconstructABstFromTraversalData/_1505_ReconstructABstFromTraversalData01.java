package c15_BinarySearchTrees.p05_ReconstructABstFromTraversalData;

import static java.lang.System.out;

import java.util.List;

public class _1505_ReconstructABstFromTraversalData01 {

	public static BSTNode<Integer> rebuildBSTFromPreorder(List<Integer> preorderSequence) {
		return rebuildBSTFromPreorderHelper(preorderSequence, 0, preorderSequence.size());
	}

// Builds a BST from preorderSequence.subList(start, end).
	private static BSTNode<Integer> rebuildBSTFromPreorderHelper(List<Integer> preorderSequence, int start, int end) {
		if (start >= end) {
			return null;
		}
		int transitionPoint = start + 1;
		while (transitionPoint < end
				&& Integer.compare(preorderSequence.get(transitionPoint), preorderSequence.get(start)) < 0) {
			++transitionPoint;
		}
		return new BSTNode<>(preorderSequence.get(start),
				rebuildBSTFromPreorderHelper(preorderSequence, start + 1, transitionPoint),

				rebuildBSTFromPreorderHelper(preorderSequence, transitionPoint, end));
	}
}