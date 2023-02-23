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

public class _1603_GeneratePermutations02 {

	public static List<List<Integer>> permutations(List<Integer> A) {
		List<List<Integer>> result = new ArrayList<>();

// Generate the first permutation in dictionary order.
		Collections.sort(A);
		do {
			result.add(new ArrayList<>(A));
			A = NextPermutation.nextPermutation(A);
		} while (!A.isEmpty());
		return result;

	}
}
