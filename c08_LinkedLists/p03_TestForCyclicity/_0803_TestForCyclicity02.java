package c08_LinkedLists.p03_TestForCyclicity;

import static java.lang.System.out;
import util.ListNode;

public class _0803_TestForCyclicity02 {

	public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
		ListNode<Integer> fast = head, slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // There is a cycle.
				// Tries to find the start of the cycle.
				slow = head;
				// Both pointers advance at the same time.
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow; // slow is the start of cycle.
			}
		}
		return null; // No cycle.
	}

}
