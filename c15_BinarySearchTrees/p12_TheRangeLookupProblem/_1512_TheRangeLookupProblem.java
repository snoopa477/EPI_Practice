package c15_BinarySearchTrees.p12_TheRangeLookupProblem;

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

public class _1512_TheRangeLookupProblem {

	private static class Interval {
		public int left, right;

		public Interval(int left, int right) {
			this.left = left;
			this.right = right;

		}

	}

	public static List<Integer> rangeLookupInBST(BSTNode<Integer> tree, Interval interval) {
		List<Integer> result = new ArrayList<>();
		rangeLookupInBSTHelper(tree, interval, result);
		return result;
	}

	public static void rangeLookupInBSTHelper(BSTNode<Integer> tree, Interval interval, List<Integer> result) {
		if (tree == null) {
			return;

		}

		if (interval.left <= tree.data && tree.data <= interval.right) {
// tree.data lies in the interval.
			rangeLookupInBSTHelper(tree.left, interval, result);
			result.add(tree.data);
			rangeLookupInBSTHelper(tree.right, interval, result);
		} else if (interval.left > tree.data) {
			rangeLookupInBSTHelper(tree.right, interval, result);
		} else { // interval.right >= tree.data
			rangeLookupInBSTHelper(tree.left, interval, result);
		}

	}
}
