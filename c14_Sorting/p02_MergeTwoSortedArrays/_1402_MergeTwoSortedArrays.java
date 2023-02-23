package c14_Sorting.p02_MergeTwoSortedArrays;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1402_MergeTwoSortedArrays {

	public static void mergeTwoSortedArrays(List<Integer> A, int m, List<Integer> B, int n) {
		int a = m - 1, b = n - 1, writeldx = m + n - 1;
		while (a >= 0 && b >= 0) {
			A.set(writeldx, A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));

		}

		while (b >= 0) {
			A.set(writeldx, B.get(b--));
		}
	}
}
