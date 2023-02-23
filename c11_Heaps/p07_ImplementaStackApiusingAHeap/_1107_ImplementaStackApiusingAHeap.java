package c11_Heaps.p07_ImplementaStackApiusingAHeap;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class _1107_ImplementaStackApiusingAHeap {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private static class ValueWithRank {
		public Integer value;
		public Integer rank;

		public ValueWithRank(Integer value, Integer rank) {
			this.value = value;
			this.rank = rank;
		}
	}

	private static class Compare implements Comparator<ValueWithRank> {
		@Override
		public int compare(ValueWithRank ol, ValueWithRank o2) {
			return Integer.compare(o2.rank, ol.rank);
		}

		public static final Compare COMPARE_VALUEWITHRANK = new Compare();
	}

	public static class Stack {
		private int timestamp = 0;
		private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY,
				Compare.COMPARE_VALUEWITHRANK);

		public void push(Integer x) {
			maxHeap.add(new ValueWithRank(x, timestamp++));
		}

		public Integer pop() throws NoSuchElementException {
			return maxHeap.remove().value;
		}

		public Integer peek() {
			return maxHeap.peek().value;
		}

	}
}
