package c17_DynamicProgramming.p05_SearchForASequenceInA02dArray;

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

public class _1705_SearchForASequenceInA02dArray {

	public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {
// Each entry in previousAttempts is a point in the grid and suffix of
// pattern ( identified by its offset). Presence in previousAttempts
// indicates the suffix is not contained in the grid starting from that
// point .
		Set<Attempt> previousAttempts = new HashSet<>();
		for (int i = 0; i < grid.size(); ++i) {
			for (int j = 0; j < grid.get(i).size(); ++j) {
				if (isPatternSuffixContainedStartingAtXY(grid, i, j, pattern, 0, previousAttempts)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isPatternSuffixContainedStartingAtXY(List<List<Integer>> grid, int x, int y,
			List<Integer> pattern, int offset, Set<Attempt> previousAttempts) {
		if (pattern.size() == offset) {
// Nothing left to complete .
			return true;

		}
// Check if (x, y) lies outside the grid.
		if (x < 0 || x >= grid.size() || y < 0 || y >= grid.get(x).size()
				|| previousAttempts.contains(new Attempt(x, y, offset))) {
			return false;
		}

		if (grid.get(x).get(y).equals(pattern.get(offset)) && 
				  (isPatternSuffixContainedStartingAtXY(grid, x - 1, y,pattern, offset + 1, previousAttempts)
				|| isPatternSuffixContainedStartingAtXY(grid, x + 1, y, pattern, offset + 1, previousAttempts)
				|| isPatternSuffixContainedStartingAtXY(grid, x, y - 1, pattern, offset + 1, previousAttempts)
				|| isPatternSuffixContainedStartingAtXY(grid, x, y + 1, pattern, offset + 1, previousAttempts))) {
			return true;
		}
		previousAttempts.add(new Attempt(x, y, offset));
		return false;

	}
}
