package c16_Recursion.p03_GeneratePermutations01;

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

public class _1603_GeneratePermutations01 {

	public static List<List<Integer>> permutations(List<Integer> A) {
		List<List<Integer>> result = new ArrayList<>();
		directedPermutations(0, A, result);
		return result;
	}

	private static void directedPermutations(int i, List<Integer> A, List<List<Integer>> result) {
		if (i == A.size() - 1) {
			result.add(new ArrayList<>(A));
			return;
		}

// Try every possibility for A[i].
		for (int j = i; j < A.size(); ++j) {
			Collections.swap(A, i, j);
// Generate all permutations for A.subList(i + 1, A.size()).
			directedPermutations(i + 1, A, result);
			Collections.swap(A, i, j);
		}

	}
}
