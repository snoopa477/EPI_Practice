package c12_Searching.p06_SearchInA02dSortedArray;

import static java.lang.System.out;
import java.util.List;

public class _1206_SearchInA02dSortedArray {

	public static boolean matrixSearch(List<List<Integer>> A, int x) {
		int row = 0, col = A.get(0).size() - 1; // Start from the top-right corner.
// Keeps searching while there are unclassified rows and columns.
		while (row < A.size() && col >= 0) {

			if (A.get(row).get(col).equals(x)) {
				return true;
			} else if (A.get(row).get(col) < x) {
				++row; // Eliminate this row.
			} else { // A.get(row).get(col) > x.
				--col; // Eliminate this column.
			}

		}
		return false;

	}
}
