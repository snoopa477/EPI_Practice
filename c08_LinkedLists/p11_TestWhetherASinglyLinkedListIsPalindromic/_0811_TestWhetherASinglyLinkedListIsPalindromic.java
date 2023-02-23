package c08_LinkedLists.p11_TestWhetherASinglyLinkedListIsPalindromic;

import static java.lang.System.out;
import util.ListNode;

public class _0811_TestWhetherASinglyLinkedListIsPalindromic {

	public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
		if (L == null) {
			return true;
		}

// Finds the second half of L.
		ListNode<Integer> slow = L, fast = L;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

		}

// Compare the first half and the reversed second half lists.
		ListNode<Integer> firstHalflter = L;
		ListNode<Integer> secondHalfilter = ReverseLinkedListlterative.reverseLinkedList(slow);
		while (secondHalfilter != null && firstHalflter != null) {
			if (secondHalfilter.data != firstHalflter.data) {
				return false;
			}
			secondHalfilter = secondHalfilter.next;
			firstHalflter = firstHalflter.next;
		}
		return true;

	}
}
