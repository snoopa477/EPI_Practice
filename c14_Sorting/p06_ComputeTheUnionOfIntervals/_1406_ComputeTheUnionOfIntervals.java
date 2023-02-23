package c14_Sorting.p06_ComputeTheUnionOfIntervals;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class _1406_ComputeTheUnionOfIntervals {

	public static class Interval implements Comparable<Interval> {
		public Endpoint left = new Endpoint();
		public Endpoint right = new Endpoint();

		private static class Endpoint {
			public boolean isClosed;
			public int val;
		}

		public int compareTo(Interval i) {
			if (Integer.compare(left.val, i.left.val) != 0) {
				return left.val - i.left.val;
			}
// Left endpoints are equal , so now see if one is closed and the
// other open - closed intervals should appear first.
			if (left.isClosed && !i.left.isClosed) {
				return -1;
			}
			if (!left.isClosed && i.left.isClosed) {
				return 1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Interval)) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			Interval that = (Interval) obj;
			return left.val == that.left.val && left.isClosed == that.left.isClosed;
		}

		@Override
		public int hashCode() {
			return Objects.hash(left.val, left.isClosed);
		}

	}

	public static List<Interval> unionOfIntervals(List<Interval> intervals) {
// Empty input.
		if (intervals.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
// Sort intervals according to left endpoints of intervals.
		Collections.sort(intervals);
		Interval curr = intervals.get(0);
		List<Interval> result = new ArrayList<>();
		for (int i = 1; i < intervals.size(); ++i) {
			if (intervals.get(i).left.val < curr.right.val || (intervals.get(i).left.val == curr.right.val
					&& (intervals.get(i).left.isClosed || curr.right.isClosed))) {
				if (intervals.get(i).right.val > curr.right.val
						|| (intervals.get(i).right.val == curr.right.val && intervals.get(i).right.isClosed)) {
					curr.right = intervals.get(i).right;
				}
			} else {
				result.add(curr);
				curr = intervals.get(i);
			}
		}
		result.add(curr);
		return result;

	}
}
