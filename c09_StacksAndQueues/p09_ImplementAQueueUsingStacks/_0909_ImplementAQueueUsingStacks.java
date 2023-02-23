package c09_StacksAndQueues.p09_ImplementAQueueUsingStacks;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Deque;
import java.util.LinkedList;

public class _0909_ImplementAQueueUsingStacks {

	public static class Queue {
		private Deque<Integer> enq = new LinkedList<>();
		private Deque<Integer> deq = new LinkedList<>();

		public void enqueue(Integer x) {
			enq.addFirst(x);
		}

		public Integer dequeue() {
			if (deq.isEmpty()) {
// Transfers the elements from enq to deq.
				while (!enq.isEmpty()) {
					deq.addFirst(enq.removeFirst());
				}
			}
			if (!deq.isEmpty()) {
				return deq.removeFirst();
			}
			throw new NoSuchElementException("Cannot pop empty queue");
		}
	}
}
