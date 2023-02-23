package c15_BinarySearchTrees.p09_BuildAMinimumHeightBstFromASortedArray;

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

public class _1509_BuildAMinimumHeightBstFromASortedArray {

	public static BSTNode<Integer> buildMinHeightBSTFromSortedArray(List<Integer> A) {
		return buildMinHeightBSTFromSortedArrayHelper(A, 0, A.size());
	}

// Build a min-height BST over the entries in A.subList(start, end - 1).
	private static BSTNode<Integer> buildMinHeightBSTFromSortedArrayHelper(
	List<Integer> A, int start, int end) {
		if (start >= end) {
			return null;
		}
		int mid = start + ((end - start) / 2);
		return new BSTNode<>(
				A.get(mid), 
				buildMinHeightBSTFromSortedArrayHelper (A , start, mid),
				buildMinHeightBSTFromSortedArrayHelper (A , mid + 1, end));
	}
}
