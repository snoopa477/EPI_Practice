package c06_Arrays.p14_ComputeARandomSubset;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class _0614_ComputeARandomSubset {
	// Returns a random k-sized subset of {0, 1, n - 1}.
	public static List<Integer> randomSubset(int n, int k) {
		Map<Integer, Integer> changedElements = new HashMap<>();
		Random randldxGen = new Random();
		for (int i = 0; i < k; ++i) {
			// Generate random int in [i, n - 1].
			int randldx = i + randldxGen.nextInt(n - i);
			Integer ptrl = changedElements.get(randldx);
			Integer ptr2 = changedElements.get(i);
			if (ptrl == null && ptr2 == null) {
				changedElements.put(randldx, i);
				changedElements.put(i, randldx);
			} else if (ptrl == null && ptr2 != null) {
				changedElements.put(randldx, ptr2);
				changedElements.put(i, randldx);
			} else if (ptrl != null && ptr2 == null) {
				changedElements.put(i, ptrl);
				changedElements.put(randldx, i);
			} else {
				changedElements.put(i, ptrl);
				changedElements.put(randldx, ptr2);
			}
		}

		List<Integer> result = new ArrayList<>(k);
		for (int i = 0; i < k; ++i) {
			result.add(changedElements.get(i));
		}
		return result;
	}
}
