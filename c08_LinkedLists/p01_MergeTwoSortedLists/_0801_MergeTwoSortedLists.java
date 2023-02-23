package c08_LinkedLists.p01_MergeTwoSortedLists;

import static java.lang.System.out;

import util.ListNode;

public class _0801_MergeTwoSortedLists {

	public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> LI, ListNode<Integer> L2) {
// Creates a placeholder for the result.
		ListNode<Integer> dummyHead = new ListNode<>(0, null);
		ListNode<Integer> current = dummyHead;
		ListNode<Integer> pi = LI, p2 = L2;

		while (pi != null && p2 != null) {
			if (pi.data <= p2.data) {
				current.next = pi;
				pi = pi.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}

// Appends the remaining nodes of pi or p2.
		current.next = pi != null ? pi : p2;
		return dummyHead.next;
	}

}
