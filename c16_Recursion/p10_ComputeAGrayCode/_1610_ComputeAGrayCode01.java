package c16_Recursion.p10_ComputeAGrayCode;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1610_ComputeAGrayCode01 {

	public static List<Integer> grayCode(int numBits) {
		List<Integer> result = new ArrayList<>(Arrays.asList(0));
		directedGrayCode(numBits, new HashSet<Integer>(Arrays.asList(0)), result);

		return result;

	}

	private static boolean directedGrayCode(int numBits, Set<Integer> history, List<Integer> result) {
		if (result.size() == (1 << numBits)) {
			return differsByOneBit(result.get(0), result.get(result.size() - 1));
		}
		for (int i = 0; i < numBits; ++i) {
			int previousCode = result.get(result.size() - 1);
			int candidateNextCode = previousCode ^ (1 << i);
			if (!history.contains(candidateNextCode)) {
				history.add(candidateNextCode);
				result.add(candidateNextCode);
				if (directedGrayCode(numBits, history, result)) {
					return true;
				}
				history.remove(candidateNextCode);
				result.remove(result.size() - 1);
			}
		}
		return false;
	}

	private static boolean differsByOneBit(int x, int y) {
		int bitDifference = x ^ y;
		return bitDifference != 0 && (bitDifference & (bitDifference - 1)) == 0;
	}
}
