package c12_Searching.p02_SearchASortedArrayForEntryEqualToItsIndex;

import static java.lang.System.out;
import java.util.List;

public class _1202_SearchASortedArrayForEntryEqualToItsIndex {

	public static int searchEntryEqualToItsIndex(List<Integer> A) {
		int left = 0, right = A.size() - 1;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			int difference = A.get(mid) - mid;
// A .get (mid) == mid if and only if difference == 0.
			if (difference == 0) {
				return mid;
			} else if (difference > 0) {
				right = mid - 1;
			} else { // difference < 0.
				left = mid + 1;

			}

		}
		return -1;

	}
}
