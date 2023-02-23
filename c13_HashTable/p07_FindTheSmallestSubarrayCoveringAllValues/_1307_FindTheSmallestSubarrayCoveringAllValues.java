package c13_HashTable.p07_FindTheSmallestSubarrayCoveringAllValues;

import static java.lang.System.out;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class _1307_FindTheSmallestSubarrayCoveringAllValues {

	// Represent subarray by starting and ending indices, inclusive .
	private static class Subarray {
		public Integer start;
		public Integer end;

		public Subarray(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
	}

	public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph, Set<String> keywords) {
		Map<String, Integer> keywordsToCover = new HashMap<>();
		for (String keyword : keywords) {
			keywordsToCover.put(keyword, keywordsToCover.containsKey(keyword) ? keywordsToCover.get(keyword) + 1 : 1);

		}
		Subarray result = new Subarray(-1, -1);
		int remainingToCover = keywords.size();
		for (int left = 0, right = 0; right < paragraph.size(); ++right) {
			Integer keywordCount = keywordsToCover.get(paragraph.get(right));
			if (keywordCount != null) {
				keywordsToCover.put(paragraph.get(right), --keywordCount);
				if (keywordCount >= 0) {
					--remainingToCover;
				}
			}

			// Keeps advancing left until it reaches end or keywordsToCover does not
			// have all keywords .
			while (remainingToCover == 0) {
				if ((result.start == -1 && result.end == -1) || right - left < result.end - result.start) {
					result.start = left;
					result.end = right;
				}
				keywordCount = keywordsToCover.get(paragraph.get(left));
				if (keywordCount != null) {
					keywordsToCover.put(paragraph.get(left), ++keywordCount);
					if (keywordCount > 0) {
						++remainingToCover;
					}
				}
				++left;
			}

		}
		return result;

	}
}
