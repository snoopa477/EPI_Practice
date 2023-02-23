package c08_LinkedLists.p12_ImplementListPivoting;

import static java.lang.System.out;
import util.ListNode;

public class _0812_ImplementListPivoting {

	public static ListNode<Integer> listPivoting(ListNode<Integer> L, int x) {
		ListNode<Integer> lessHead = new ListNode<>(0, null);
		ListNode<Integer> equalHead = new ListNode<>(0, null);
		ListNode<Integer> greaterHead = new ListNode<>(0, null);
		ListNode<Integer> lesslter = lessHead;
		ListNode<Integer> equallter = equalHead;
		ListNode<Integer> greaterlter = greaterHead;
// Populates the three lists.
		ListNode<Integer> iter = L;
		while (iter != null) {
			if (iter.data < x) {
				lesslter.next = iter;
				lesslter = iter;
			} else if (iter.data == x) {
				equallter.next = iter;
				equallter = iter;
			} else {// iter.data > x.
				greaterlter.next = iter;
				greaterlter = iter;
			}
			iter = iter.next;
		}
// Combines the three lists.
		greaterlter.next = null;
		equallter.next = greaterHead.next;
		lesslter.next = equalHead.next;
		return lessHead.next;
	}
}
