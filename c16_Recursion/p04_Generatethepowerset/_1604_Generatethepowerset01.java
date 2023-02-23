package c16_Recursion.p04_Generatethepowerset;

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

public class _1604_Generatethepowerset01 {

	public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
		List<List<Integer>> powerSet = new ArrayList<>();
		directedPowerSet(inputSet, 0, new ArrayList<Integer>(), powerSet);
		return powerSet;
	}

// Generate all subsets whose intersection with inputSet[<9], ...,
// inputSet[toBeSelected - 1] is exactly selectedSoFar.
	private static void directedPowerSet(List<Integer> inputSet, int toBeSelected, List<Integer> selectedSoFar,
			List<List<Integer>> powerSet) {
		if (toBeSelected == inputSet.size()) {
			powerSet.add(new ArrayList<>(selectedSoFar));
			return;
		}
// Generate all subsets that contain inputSet[toBeSelected].
		selectedSoFar.add(inputSet.get(toBeSelected));
		directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
// Generate all subsets that do not contain inputSet[toBeSelected].
		selectedSoFar.remove(selectedSoFar.size() - 1);
		directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
	}
}
