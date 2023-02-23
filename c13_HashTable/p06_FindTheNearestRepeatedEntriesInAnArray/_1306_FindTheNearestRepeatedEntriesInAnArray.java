package c13_HashTable.p06_FindTheNearestRepeatedEntriesInAnArray;

import static java.lang.System.out;

import java.util.List;
import java.util.PriorityQueue;

import java.util.HashMap;
import java.util.Map;

public class _1306_FindTheNearestRepeatedEntriesInAnArray {

	public static int findNearestRepetition(List<String> paragraph) {
		Map<String, Integer> wordToLatestIndex = new HashMap<>();
		int nearestRepeatedDistance = Integer.MAX_VALUE;
		for (int i = 0; i < paragraph.size(); ++i) {
			if (wordToLatestIndex.containsKey(paragraph.get(i))) {
				nearestRepeatedDistance = Math.min(nearestRepeatedDistance,
						i - wordToLatestIndex.get(paragraph.get(i)));
			}
			wordToLatestIndex.put(paragraph.get(i), i);
		}
		return nearestRepeatedDistance;
	}
}
