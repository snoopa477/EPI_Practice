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

public class _1604_Generatethepowerset02 {

	private static final double L0G_2 = Math.log(2);

	public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
		List<List<Integer>> powerSet = new ArrayList<>();
		for (int intForSubset = 0; intForSubset < (1 << inputSet.size()); ++intForSubset) {
			int bitArray = intForSubset;
			List<Integer> subset = new ArrayList<>();

			while (bitArray != 0) {
				subset.add(inputSet.get((int) (Math.log(bitArray & ~(bitArray - 1)) / L0G_2)));
				bitArray &= bitArray - 1;
			}
			powerSet.add(subset);

		}
		return powerSet;
	}
}
