package c08_LinkedLists.p13_AddList;

import static java.lang.System.out;
import util.ListNode;

public class _0813_AddList {

	public static ListNode<Integer> addTwoNumbers(ListNode<Integer> LI, ListNode<Integer> L2) {
		ListNode<Integer> dummyHead = new ListNode<>(0, null);
		ListNode<Integer> placelter = dummyHead;
		int carry = 0;
		while (LI != null || L2 != null) {
			int sum = carry;
			if (LI != null) {
				sum += LI.data;
				LI = LI.next;
			}
			if (L2 != null) {
				sum += L2.data;
				L2 = L2.next;
			}
			placelter.next = new ListNode<>(sum % 10, null);
			carry = sum / 10;
			placelter = placelter.next;
		}
// carry cannot exceed 1, so we never need to add more than one node.
		if (carry > 0) {
			placelter.next = new ListNode<>(carry, null);
		}
		return dummyHead.next;
	}
}
