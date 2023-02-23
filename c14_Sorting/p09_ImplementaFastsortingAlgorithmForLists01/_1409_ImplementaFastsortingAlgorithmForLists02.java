package c14_Sorting.p09_ImplementaFastsortingAlgorithmForLists01;

import static java.lang.System.out;

import util.ListNode;

public class _1409_ImplementaFastsortingAlgorithmForLists02 {

	public static ListNode<Integer> stableSortList(ListNode<Integer> L) {
// Base cases: L is empty or a single node, nothing to do.
		if (L == null || L.next == null) {
			return L;
		}

// Find the midpoint of L using a slow and a fast pointer.
		ListNode<Integer> preSlow = null, slow = L, fast = L;
		while (fast != null && fast.next != null) {
			preSlow = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		preSlow.next = null; // Splits the list into two equal-sized lists.
		return MergeSortedLists.mergeTwoSortedLists(stableSortList(L), stableSortList(slow));

	}

}
