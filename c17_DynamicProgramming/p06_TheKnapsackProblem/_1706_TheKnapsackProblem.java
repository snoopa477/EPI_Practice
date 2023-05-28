package c17_DynamicProgramming.p06_TheKnapsackProblem;

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

public class _1706_TheKnapsackProblem {

	
	private static class Item {
		
		public Integer weight;
		public Integer value;

		public Item(Integer weight, Integer value) {
			this.weight = weight;
			this.value = value;

		}

	}

	
	
	public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
		// V[i][j] holds the optimum value when we choose from items[0 : i] and have
		// a capacity of j.
		int[][] V = new int[items.size()][capacity + 1];
		for (int[] v : V) {
			Arrays.fill(v, -1);
		}
		
		return optimumSubjectToItemAndCapacity(items, items.size() - 1, capacity, V);
	}

	
	
	// Returns the optimum value when we choose from items[0 : k] and have a
	// capacity of available_capacity.
	private static int optimumSubjectToItemAndCapacity(List<Item> items, int k, int availableCapacity, int[][] V) {
		
		if (k < 0) {
		// No items can be chosen.
			return 0;
		}
		
		
		if (V[k][availableCapacity] == -1) {
			int withoutCurrltem = optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity, V);
			int withCurrltem = availableCapacity < items.get(k).weight ? 0
					: items.get(k).value
							+ optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity - items.get(k).weight, V);
			V[k][availableCapacity] = Math.max(withoutCurrltem, withCurrltem);
		}
		
		return V[k][availableCapacity];
	}
}


