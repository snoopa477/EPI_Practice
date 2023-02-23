package c08_LinkedLists.p03_TestForCyclicity;

import static java.lang.System.out;
import util.ListNode;

public class _0803_TestForCyclicity {

	public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
		ListNode<Integer> fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
// There is a cycle, so now let's calculate the cycle length.
				int cycleLen = 0;
				do {
					++cycleLen;
					fast = fast.next;
				} while (slow != fast);
// Finds the start of the cycle.
				ListNode<Integer> cycleLenAdvancedlter = head;
// cycleLenAdvancedlter pointer advances cycleLen first.
				while (cycleLen-- > 0) {
					cycleLenAdvancedlter = cycleLenAdvancedlter.next;
				}
				ListNode<Integer> iter = head;
// Both iterators advance in tandem.
				while (iter != cycleLenAdvancedlter) {
					iter = iter.next;
					cycleLenAdvancedlter = cycleLenAdvancedlter.next;
				}
				return iter; // iter is the start of cycle.
			}

		}

		return null; // no cycle.
	}
}
