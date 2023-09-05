package c06_Arrays.p01_TheDutchNationalFlagProblem;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;

public class _0601_TheDutchNationalFlagProblem_V03 {

	public static enum Color {
		RED, WHITE, BLUE
	};

	public static void dutchFlagPartition(int pivotlndex, List<Color> A) {
		Color pivot = A.get(pivotlndex);
		/**
		 *
		 * Keep the following invariants during partitioning: bottom group: A .subList
		 * (SI , smaller) . middle group: A .subList (smaller , equal). unclassified
		 * group: A .subList (equal , larger). top group: A .subList (larger , A .
		 * size()).
		 */
		int smaller = 0, equal = 0, larger = A.size();
		// Keep iterating as long as there is an unclassified element.
		while (equal < larger) {
			// A .get (equal) is the incoming unclassified element.
			if (A.get(equal).ordinal() < pivot.ordinal()) {
				Collections.swap(A, smaller++, equal++);
			} else if (A.get(equal).ordinal() == pivot.ordinal()) {
				++equal;
			} else {// A . get (equal) > pivot.
				Collections.swap(A, equal, --larger);
			}
		}
	}

}
