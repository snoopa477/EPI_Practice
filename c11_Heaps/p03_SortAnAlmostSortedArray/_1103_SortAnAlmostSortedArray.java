package c11_Heaps.p03_SortAnAlmostSortedArray;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class _1103_SortAnAlmostSortedArray {

	public static void sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
// Adds the first k elements into minHeap. Stop if there are fewer than k
// elements .
		for (int i = 0; i < k && sequence.hasNext(); ++i) {
			minHeap.add(sequence.next());

		}

// For every new element, add it to minHeap and extract the smallest.
		while (sequence.hasNext()) {
			minHeap.add(sequence.next());
			Integer smallest = minHeap.remove();
			System.out.println(smallest);
		}

// sequence is exhausted, iteratively extracts the remaining elements.
		while (!minHeap.isEmpty()) {
			Integer smallest = minHeap.remove();
			System.out.println(smallest);
		}

	}
}
