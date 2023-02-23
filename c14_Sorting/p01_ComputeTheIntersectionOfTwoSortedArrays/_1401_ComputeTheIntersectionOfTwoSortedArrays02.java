package c14_Sorting.p01_ComputeTheIntersectionOfTwoSortedArrays;

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

public class _1401_ComputeTheIntersectionOfTwoSortedArrays02 {

	public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
		List<Integer> intersectionAB = new ArrayList<>();
		for (int i = 0; i < A.size(); ++i) {
			if ((i == 0 || A.get(i) != A.get(i - 1)) && Collections.binarySearch(B, A.get(i)) >= 0) {
				intersectionAB.add(A.get(i));
			}
		}
		return intersectionAB;
	}
}
