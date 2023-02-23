package c15_BinarySearchTrees.p03_FindTheKLargestElementsInABst;

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

public class _1503_FindTheKLargestElementsInABst {

	public static List<Integer> findKLargestlnBST(BSTNode<Integer> tree, int k) {
		List<Integer> kLargestElements = new ArrayList<>();
		findKLargestlnBSTHelper(tree, k, kLargestElements);
		return kLargestElements;
	}

	private static void findKLargestlnBSTHelper(BSTNode<Integer> tree, int k, List<Integer> kLargestElements) {
// Perform reverse inorder traversal.
		if (tree != null && kLargestElements.size() < k) {

			findKLargestlnBSTHelper(tree.right, k, kLargestElements);
			if (kLargestElements.size() < k) {
				kLargestElements.add(tree.data);
				findKLargestlnBSTHelper(tree.left, k, kLargestElements);
			}

		}

	}
}
