package c14_Sorting.p01_ComputeTheIntersectionOfTwoSortedArrays;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1401_ComputeTheIntersectionOfTwoSortedArrays03 {

	public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
		List<Integer> intersectionAB = new ArrayList<>();
		int i = 0, j = 0;
		while (i < A.size() && j < B.size()) {
			if (A.get(i) == B.get(j) && (i == 0 || A.get(i) != A.get(i - 1))) {
				intersectionAB.add(A.get(i));
				++i;
				++j;
			} else if (A.get(i) < B.get(j)) {
				++i;
			} else {// A.get(i) > B.get(j).
				++j;
			}
		}
		return intersectionAB;
	}

}
