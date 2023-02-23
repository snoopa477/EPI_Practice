package c16_Recursion.p09_ImplementASudokuSolver;

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

public class _1609_ImplementASudokuSolver {

	private static final int EMPTY_ENTRY = 0;

	public static boolean solveSudoku(List<List<Integer>> partialAssignment) {
		return solvePartialSudoku(0, 0, partialAssignment);
	}

	private static boolean solvePartialSudoku(int i, int j, List<List<Integer>> partialAssignment) {
		if (i == partialAssignment.size()) {
			i = 0; // Starts a new row.
			if (++j == partialAssignment.get(i).size()) {
				return true; // Entire matrix has been filled without conflict.
			}
		}
// Skips nonempty entries.
		if (partialAssignment.get(i).get(j) != EMPTY_ENTRY) {
			return solvePartialSudoku(i + 1, j, partialAssignment);
		}
		for (int val = 1; val <= partialAssignment.size(); ++val) {
// It's substantially quicker to check if entry val conflicts
// with any of the constraints if we add it at (i,j) before
// adding it, rather than adding it and then checking all constraints.
// The reason is that we are starting with a valid configuration,
// and the only entry which can cause a problem is entryval at (i,j).
			if (validToAddVal(partialAssignment, i, j, val)) {
				partialAssignment.get(i).set(j, val);
				if (solvePartialSudoku(i + 1, j, partialAssignment)) {
					return true;
				}
			}
		}
		partialAssignment.get(i).set(j, EMPTY_ENTRY); // Undo assignment.
		return false;
	}

	private static boolean validToAddVal(List<List<Integer>> partialAssignment, int i, int j, int val) {
// Check row constraints.
		for (List<Integer> element : partialAssignment) {
			if (val == element.get(j)) {
				return false;
			}
		}
// Check column constraints.
		for (int k = 0; k < partialAssignment.size(); ++k) {
			if (val == partialAssignment.get(i).get(k)) {
				return false;
			}
		}

// Check region constraints.
		int regionSize = (int) Math.sqrt(partialAssignment.size());
		int I = i / regionSize, J = j / regionSize;
		for (int a = 0; a < regionSize; ++a) {
			for (int b = 0; b < regionSize; ++b) {
				if (val == partialAssignment.get(regionSize * I + a).get(regionSize * J + b)) {
					return false;
				}
			}
		}
		return true;
	}
}
