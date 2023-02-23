package util;

import static java.lang.System.out;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	
	

	public ListNode(T data, ListNode<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public static ListNode<Integer> search(ListNode<Integer> L, int key) {
		while (L != null && L.data != key) {
			L = L.next;
		}
		// If key was not present in the list, L will have become null.
		return L;
	}

	// Insert newNode after node.
	public static void insertAfter(ListNode<Integer> node, ListNode<Integer> newNode) {
		newNode.next = node.next;
		node.next = newNode;
	}

	// Delete the node immediately following aNode. Assumes aNode is not a tail.
	public static void deleteList(ListNode<Integer> aNode) {
		aNode.next = aNode.next.next;
	}

}
