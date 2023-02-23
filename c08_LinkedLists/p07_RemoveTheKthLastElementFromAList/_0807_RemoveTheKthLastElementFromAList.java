package c08_LinkedLists.p07_RemoveTheKthLastElementFromAList;

import static java.lang.System.out;
import util.ListNode;

public class _0807_RemoveTheKthLastElementFromAList {

	// Assumes L has at least k nodes, deletes the k-th last node in L.
	public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
		ListNode<Integer> dummyHead = new ListNode(0, L);
		ListNode<Integer> first = dummyHead.next;
		while (k-- > 0) {
			first = first.next;
		}
		ListNode<Integer> second = dummyHead;
		while (first != null) {

			second = second.next;
			first = first.next;

		}
		// second points to the (k + l)-th last node, deletes its successor.
		second.next = second.next.next;
		return dummyHead.next;
	}

}
