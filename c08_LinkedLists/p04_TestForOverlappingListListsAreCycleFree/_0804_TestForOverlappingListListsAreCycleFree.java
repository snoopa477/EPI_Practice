package c08_LinkedLists.p04_TestForOverlappingListListsAreCycleFree;

import static java.lang.System.out;
import util.ListNode;

public class _0804_TestForOverlappingListListsAreCycleFree {

	public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> LI, ListNode<Integer> L2) {
		int LILength = length(LI), L2Length = length(L2);
// Advances the longer list to get equal length lists.
		if (LILength > L2Length) {
			LI = advanceListByK(LILength - L2Length, LI);
		} else {
			L2 = advanceListByK(L2Length - LILength, L2);
		}
		while (LI != null && L2 != null && LI != L2) {
			LI = LI.next;
			L2 = L2.next;
		}
		return LI; // nullptr implies there is no overlap between LI and L2.
	}

	public static ListNode<Integer> advanceListByK(int k, ListNode<Integer> L) {
		while (k-- > 0) {
			L = L.next;
		}
		return L;
	}

	private static int length(ListNode<Integer> L) {
		int len = 0;
		while (L != null) {
			++len;
			L = L.next;
		}
		return len;
	}
}
