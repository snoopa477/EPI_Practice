package c17_DynamicProgramming.p08_FindTheMinimumWeightPathInATriangle;

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

public class _1708_FindTheMinimumWeightPathInATriangle {

	public static int minimumPathTotal(List<List<Integer>> triangle) {
		if (triangle.isEmpty()) {
			return 0;

		}

// As we iterate, prevRow stores the minimum path sum to each entry in
// triangle.get(i - 1).
		List<Integer> prevRow = new ArrayList<>(triangle.get(0));
		for (int i = 1; i < triangle.size(); ++i) {

// Stores the minimum path sum to each entry in triangle .get (i).
			List<Integer> currRow = new ArrayList<>(triangle.get(i));
// For the first element.
			currRow.set(0, currRow.get(0) + prevRow.get(0));
			for (int j = 1; j < currRow.size() - 1; ++j) {
				currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
			}
// For the last element
			currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1) + prevRow.get(prevRow.size() - 1));

			prevRow = currRow;
		}
		return Collections.min(prevRow);
	}
}
