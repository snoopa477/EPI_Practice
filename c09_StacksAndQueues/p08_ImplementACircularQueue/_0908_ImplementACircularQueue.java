package c09_StacksAndQueues.p08_ImplementACircularQueue;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class _0908_ImplementACircularQueue {

	public static class Queue {
		private int head = 0, tail = 0, numQueueElements = 6;
		private static final int SCALE_FACTOR = 2;
		private Integer[] entries;

		public Queue(int capacity) {
			entries = new Integer[capacity];
		}

		public void enqueue(Integer x) {
			if (numQueueElements == entries.length) {// Need to resize.
// Makes the queue elements appear consecutively.
				Collections.rotate(Arrays.asList(entries), -head);
// Resets head and tail.
				head = 0;
				tail = numQueueElements;
				entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR);
			}
			entries[tail] = x;
			tail = (tail + 1) % entries.length;
			++numQueueElements;
		}

		public Integer dequeue() {
			if (numQueueElements != 0) {
				--numQueueElements;
				Integer ret = entries[head];
				head = (head + 1) % entries.length;
				return ret;
			}
			throw new NoSuchElementException("Dequeue called on an empty queue.");
		}

		public int size() {
			return numQueueElements;
		}
	}
}
