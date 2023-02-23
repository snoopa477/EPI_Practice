package c13_HashTable.p09_FindTheLongestSubarrayWithDistinctEntries;

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

public class _1309_FindTheLongestSubarrayWithDistinctEntries {

	public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
// Records the most recent occurrences of each entry.
		Map<Integer, Integer> mostRecentOccurrence = new HashMap<>();
		int longestDupFreeSubarrayStartldx = 0, result = 0;
		for (int i = 0; i < A.size(); ++i) {
			Integer dupldx = mostRecentOccurrence.put(A.get(i), i);
// A.get(i) appeared before. Did it appear in the longest current
// subarray?
			if (dupldx != null) {
				if (dupldx >= longestDupFreeSubarrayStartldx) {
					result = Math.max(result, i - longestDupFreeSubarrayStartldx);
					longestDupFreeSubarrayStartldx = dupldx + 1;
				}
			}
		}
		result = Math.max(result, A.size() - longestDupFreeSubarrayStartldx);
		return result;
	}

}
