package c13_HashTable.p10_FindTheLengthOfALongestContainedInterval;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import java.util.HashMap;
import java.util.Map;

import java.util.HashSet;
import java.util.Set;

public class _1310_FindTheLengthOfALongestContainedInterval {

	public static int longestContainedRange(List<Integer> A) {
// unprocessedEntries records the existence of each entry in A.
		Set<Integer> unprocessedEntries = new HashSet(A);
		int maxIntervalSize = 0;
		while (!unprocessedEntries.isEmpty()) {
			int a = unprocessedEntries.iterator().next();
			unprocessedEntries.remove(a);
// Finds the lower bound of the largest range containing a.
			int lowerBound = a - 1;
			while (unprocessedEntries.contains(lowerBound)) {
				unprocessedEntries.remove(lowerBound);
				--lowerBound;
			}

// Finds the upper bound of the largest range containing a.
			int upperBound = a + 1;
			while (unprocessedEntries.contains(upperBound)) {
				unprocessedEntries.remove(upperBound);
				++upperBound;
			}

			maxIntervalSize = Math.max(upperBound - lowerBound - 1, maxIntervalSize);

		}
		return maxIntervalSize;
	}
}
