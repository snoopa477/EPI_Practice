package c14_Sorting.p05_MergingIntervals;

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

public class _1405_MergingIntervals {

	private static class Interval {
		public int left, right;

		public Interval(int l, int r) {
			this.left = l;
			this.right = r;

		}

	}

	public static List<Interval> addlnterval(List<Interval> disjointIntervals, Interval newlnterval) {
		int i = 0;
		List<Interval> result = new ArrayList<>();
// Processes intervals in disjointlntervals which come before newlnterval.
		while (i < disjointIntervals.size() && newlnterval.left > disjointIntervals.get(i).right) {
			result.add(disjointIntervals.get(i++));

		}

// Processes intervals in disjointlntervals which overlap with newlnterval.
		while (i < disjointIntervals.size()

				&& newlnterval.right >= disjointIntervals.get(i).left) {
// If [a, b ] and [c , d] overlap, their union is [ min(a , c),max(b, d) ] .
			newlnterval = new Interval(Math.min(newlnterval.left, disjointIntervals.get(i).left),
					Math.max(newlnterval.right, disjointIntervals.get(i).right));
			++i;

		}
		result.add(newlnterval);
// Processes intervals in disjointlntervals which come after newlnterval .
		result.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
		return result;

	}
}
