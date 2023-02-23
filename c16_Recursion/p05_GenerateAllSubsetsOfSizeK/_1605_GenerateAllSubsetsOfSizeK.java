package c16_Recursion.p05_GenerateAllSubsetsOfSizeK;

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

public class _1605_GenerateAllSubsetsOfSizeK {

	public static List<List<Integer>> combinations(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		directedCombinations(n, k, 1, new ArrayList<Integer>(), result);
		return result;
	}

	private static void directedCombinations(int n, int k, int offset,

			List<Integer> partialCombination, List<List<Integer>> result) {

		if (partialCombination.size() == k) {
			result.add(new ArrayList<>(partialCombination));
			return;
		}
// Generate remaining combinations over {offset, ...>> n - 1} of size
// numRemaining.
		final int numRemaining = k - partialCombination.size();
		for (int i = offset; i <= n && numRemaining <= n - i + 1; ++i) {
			partialCombination.add(i);
			directedCombinations(n, k, i + 1, partialCombination, result);
			partialCombination.remove(partialCombination.size() - 1);
		}
	}
}
