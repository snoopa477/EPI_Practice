package c13_HashTable.p08_FindSmallestSubarraySequentiallyCoveringAllValues;

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

public class _1308_FindSmallestSubarraySequentiallyCoveringAllValues {
	public static class Subarray {
		// Represent subarray by starting and ending indices, inclusive.
		public Integer start;
		public Integer end;

		public Subarray(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
	}

	public static Subarray findSmallestSequentiallyCoveringSubset(List<String> paragraph, List<String> keywords) {
		// Maps each keyword to its index in the keywords array.
		Map<String, Integer> keywordToIdx = new HashMap<>();
		// Since keywords are uniquely identified by their indices in keywords
		// array, we can use those indices as keys to lookup in a vector.
		List<Integer> latestOccurrence = new ArrayList<>(keywords.size());
		// For each keyword (identified by its index in keywords array), stores the
		// length of the shortest subarray ending at the most recent occurrence of
		// that keyword that sequentially cover all keywords up to that keyword.
		List<Integer> shortestSubarrayLength = new ArrayList<>(keywords.size());
		// Initializes latestOccurrence, shortestSubarrayLength, and keywordToIdx.
		for (int i = 0; i < keywords.size(); ++i) {
			latestOccurrence.add(-1);
			shortestSubarrayLength.add(Integer.MAX_VALUE);
			keywordToIdx.put(keywords.get(i), i);
		}
		int shortestDistance = Integer.MAX_VALUE;
		Subarray result = new Subarray(-1, -1);
		for (int i = 0; i < paragraph.size(); ++i) {
			Integer keywordldx = keywordToIdx.get(paragraph.get(i));
			if (keywordldx != null) {
				if (keywordldx == 0) {// First keyword.
					shortestSubarrayLength.set(0, 1);
				} else if (shortestSubarrayLength.get(keywordldx - 1) != Integer.MAX_VALUE) {
					int distanceToPreviousKeyword = i - latestOccurrence.get(keywordldx - 1);
					shortestSubarrayLength.set(keywordldx,
							distanceToPreviousKeyword + shortestSubarrayLength.get(keywordldx - 1));

				}
				latestOccurrence.set(keywordldx, i);
				// Last keyword, look for improved subarray.
				if (keywordldx == keywords.size() - 1
						&& shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) < shortestDistance) {
					shortestDistance = shortestSubarrayLength.get(shortestSubarrayLength.size() - 1);
					result.start = i - shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) + 1;
					result.end = i;
				}

			}

		}
		return result;

	}
}
