package c18_GreedyAlgorithms.p04_The03SumProblem;

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

public class _1804_The03SumProblem {

	public static boolean hasThreeSum(List<Integer> A, int t) {

		Collections.sort(A);
		for (Integer a : A) {
// Finds if the sum of two numbers in A equals to t - a.
			if (TwoSum.hasTwoSum(A, t - a)) {
				return true;
			}
		}
		return false;

	}
}
