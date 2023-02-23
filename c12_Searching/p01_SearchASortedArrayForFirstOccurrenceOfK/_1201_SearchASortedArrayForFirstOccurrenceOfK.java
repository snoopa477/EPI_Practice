package c12_Searching.p01_SearchASortedArrayForFirstOccurrenceOfK;

import static java.lang.System.out;
import java.util.List;

public class _1201_SearchASortedArrayForFirstOccurrenceOfK {

	public static int searchFirstOfK(List<Integer> A, int k) {
		int left = 0, right = A.size() - 1, result = -1;
// A .subList (left , right + 1) is the candidate set.
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (A.get(mid) > k) {
				right = mid - 1;
			} else if (A.get(mid) == k) {
				result = mid;
// Nothing to the right of mid can be the first occurrence of k.
				right = mid - 1;
			} else { // A .get (mid) < k
				left = mid + 1;
			}
		}
		return result;
	}
}
