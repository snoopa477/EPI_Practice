package c08_LinkedLists.p08_RemoveDuplicatesFromASortedList;

import static java.lang.System.out;
import util.ListNode;

public class _0808_RemoveDuplicatesFromASortedList {

	public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
		ListNode<Integer> iter = L;
		while (iter != null) {
// Uses nextDistinct to find the next distinct value.
			ListNode<Integer> nextDistinct = iter.next;
			while (nextDistinct != null && nextDistinct.data == iter.data) {
				nextDistinct = nextDistinct.next;
			}

			iter.next = nextDistinct;
			iter = nextDistinct;

		}

		return L;
	}
}
