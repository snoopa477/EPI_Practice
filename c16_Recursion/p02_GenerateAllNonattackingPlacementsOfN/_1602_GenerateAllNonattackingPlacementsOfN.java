package c16_Recursion.p02_GenerateAllNonattackingPlacementsOfN;

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

public class _1602_GenerateAllNonattackingPlacementsOfN {

	public static List<List<Integer>> nQueens(int n) {
		List<List<Integer>> result = new ArrayList<>();
		solveNQueens(n, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
		if (row == n) {
// All queens are legally placed.
			result.add(new ArrayList<>(colPlacement));
		} else {
			for (int col = 0; col < n; ++col) {
				colPlacement.add(col);
				if (isValid(colPlacement)) {
					solveNQueens(n, row + 1, colPlacement, result);
				}
				colPlacement.remove(colPlacement.size() - 1);
			}
		}
	}

// Test if a newly placed queen will conflict any earlier queens
// placed before.
	private static boolean isValid(List<Integer> colPlacement) {
		int rowID = colPlacement.size() - 1;
		for (int i = 0; i < rowID; ++i) {

			int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
			if (diff == 0 || diff == rowID - i) {
				return false;
			}

		}
		return true;

	}
}
