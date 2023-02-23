package c08_LinkedLists.p06_DeleteANodeFromASinglyLinkedList;

import static java.lang.System.out;
import util.ListNode;

public class _0806_DeleteANodeFromASinglyLinkedList {

	// Assumes nodeToDelete is not tail.
	public static void deletionFromList(ListNode<Integer> nodeToDelete) {
		nodeToDelete.data = nodeToDelete.next.data;
		nodeToDelete.next = nodeToDelete.next.next;
	}
}
