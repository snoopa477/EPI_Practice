package c09_StacksAndQueues.p10_ImplementAQueueWithMaxApi;

import static java.lang.System.out;

import java.util.NoSuchElementException;

public class _0910_ImplementAQueueWithMaxApi02 {

	public class QueueWithMax {
		private StackWithMax.Stack enqueue = new StackWithMax.Stack();
		private StackWithMax.Stack dequeue = new StackWithMax.Stack();

		public void enqueue(Integer x) {
			enqueue.push(x);
		}

		public Integer dequeue() {
			if (dequeue.empty()) {
				while (!enqueue.empty()) {
					dequeue.push(enqueue.pop());
				}
			}
			if (!dequeue.empty()) {
				return dequeue.pop();
			}
			throw new NoSuchElementException("Cannot get dequeue() on empty queue.");
		}

		public Integer max() {
			if (!enqueue.empty()) {
				return dequeue.empty() ? enqueue.max() : Math.max(enqueue.max(), dequeue.max());
			}
			if (!dequeue.empty()) {
				return dequeue.max();
			}
			throw new NoSuchElementException("Cannot get max() on empty queue.");
		}

	}
}
