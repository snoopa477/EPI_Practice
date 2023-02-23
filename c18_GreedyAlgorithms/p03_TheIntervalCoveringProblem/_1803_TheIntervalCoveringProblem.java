package c18_GreedyAlgorithms.p03_TheIntervalCoveringProblem;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1803_TheIntervalCoveringProblem {

	public static class Interval {
		public int left, right;

		public Interval(int l, int r) {
			this.left = l;
			this.right = r;
		}
	}

	public static List<Integer> findMinimumVisits(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return Collections.EMPTY_LIST;
		}

// Sort intervals based on the right endpoints.
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.right, i2.right);
			}
		});
		List<Integer> visits = new ArrayList<>();
		Integer lastVisitTime = intervals.get(0).right;
		visits.add(lastVisitTime);
		for (Interval interval : intervals) {
			if (interval.left > lastVisitTime) {
// The current right endpoint , lastVisitTime , will not cover any more
// intervals .
				lastVisitTime = interval.right;
				visits.add(lastVisitTime);
			}
		}
		return visits;

	}
}
