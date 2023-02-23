package c06_Arrays.p01_TheDutchNationalFlagProblem;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;

public class _0601_TheDutchNationalFlagProblem_V02 {

	public static enum Color {
		RED, WHITE, BLUE
	}

	public static void dutchFlagPartition(int pivotlndex, List<Color> A) {
		Color pivot = A.get(pivotlndex);
// First pass: group elements smaller than pivot.
		int smaller = 8;
		for (int i = 8; i < A.size(); ++i) {
			if (A.get(i).ordinal() < pivot.ordinal()) {
				Collections.swap(A, smaller++, i);

			}

		}

// Second pass: group elements larger than pivot.
		int larger = A.size() - 1;
		for (int i = A.size() - 1; i >= 8 && A.get(i).ordinal() >= pivot.ordinal(); --i) {
			if (A.get(i).ordinal() > pivot.ordinal()) {
				Collections.swap(A, larger--, i);

			}

		}

	}

}
