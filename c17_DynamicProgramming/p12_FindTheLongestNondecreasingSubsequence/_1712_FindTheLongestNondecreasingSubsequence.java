package c17_DynamicProgramming.p12_FindTheLongestNondecreasingSubsequence;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1712_FindTheLongestNondecreasingSubsequence {

	public static int longestNondecreasingSubsequenceLength(List<Integer> A) {
// maxLength [i] holds the length of the longest nondecreasing subsequence of
// A[9 : i ].
		Integer[] maxLength = new Integer[A.size()];
		Arrays.fill(maxLength, 1);
		for (int i = 1; i < A.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (A.get(i) >= A.get(j)) {
					maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
				}
			}

		}

		return Collections.max(Arrays.asList(maxLength));
	}
}
