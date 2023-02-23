package c06_Arrays.p01_TheDutchNationalFlagProblem;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;

public class _0601_TheDutchNationalFlagProblem {

	public static enum Color {
		RED, WHITE, BLUE
	}

	public static void dutchFlagPartition(int pivotlndex, List<Color> A) {
		Color pivot = A.get(pivotlndex);
// First pass: group elements smaller than pivot.
		for (int i = 0; i < A.size(); ++i) {
// Look for a smaller element.
			for (int j = i + 1; j < A.size(); ++j) {
				if (A.get(j).ordinal() < pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}
// Second pass: group elements larger than pivot.
		for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); --i) {
// Look for a larger element. Stop when we reach an element less
// than pivot, since first pass has moved them to the start of A.
			for (int j = i - 1; j >= 0 && A.get(j).ordinal() >= pivot.ordinal(); --j) {
				if (A.get(j).ordinal() > pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}
	}

}
