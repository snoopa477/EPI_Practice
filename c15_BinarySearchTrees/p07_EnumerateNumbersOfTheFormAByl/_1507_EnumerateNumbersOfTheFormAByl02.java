package c15_BinarySearchTrees.p07_EnumerateNumbersOfTheFormAByl;

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
import java.util.SortedSet;
import java.util.TreeSet;

import c15_BinarySearchTrees.p07_EnumerateNumbersOfTheFormAByl._1507_EnumerateNumbersOfTheFormAByl01.ABSqrt2;

public class _1507_EnumerateNumbersOfTheFormAByl02 {

	public static List<ABSqrt2> generateFirstKABSqrt2(int k) {
		// Will store the first k numbers of the form a + b sqrt(2).
		List<ABSqrt2> result = new ArrayList<>();
		result.add(new ABSqrt2(0, 0));
		int i = 0, j = 0;
		for (int n = 1; n < k; ++n) {
			ABSqrt2 resultPlusl = new ABSqrt2(result.get(i).a + 1, result.get(i).b);
			ABSqrt2 resultPlusSqrt2 = new ABSqrt2(result.get(j).a, result.get(j).b + 1);
			result.add(resultPlusl.val < resultPlusSqrt2.val ? resultPlusl : resultPlusSqrt2);
			if (resultPlusl.compareTo(result.get(result.size() - 1)) == 0) {
				++i;
			}
			if (resultPlusSqrt2.compareTo(result.get(result.size() - 1)) == 0) {
				++j;
			}
		}
		return result;
	}
}
