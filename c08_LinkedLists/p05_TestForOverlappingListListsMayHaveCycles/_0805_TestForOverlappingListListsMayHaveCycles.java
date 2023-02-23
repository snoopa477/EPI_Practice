package c08_LinkedLists.p05_TestForOverlappingListListsMayHaveCycles;

import static java.lang.System.out;

import c08_LinkedLists.p03_TestForCyclicity._0803_TestForCyclicity02;
import c08_LinkedLists.p04_TestForOverlappingListListsAreCycleFree._0804_TestForOverlappingListListsAreCycleFree;
import util.ListNode;

public class _0805_TestForOverlappingListListsMayHaveCycles {

	public static ListNode<Integer> overlappingLists(ListNode<Integer> LI, ListNode<Integer> L2) {
// Store the start of cycle if any.
		ListNode<Integer> rootl = _0803_TestForCyclicity02.hasCycle(LI);
		ListNode<Integer> root2 = _0803_TestForCyclicity02.hasCycle(L2);
		if (rootl == null && root2 == null) {
// Both lists don't have cycles.
			return _0804_TestForOverlappingListListsAreCycleFree.overlappingNoCycleLists(LI, L2);

		} else if ((rootl != null && root2 == null) || (rootl == null && root2 != null)) {
// One list has cycle, and one list has no cycle.
			return null;
		}
// Both lists have cycles.
		ListNode<Integer> temp = root2;
		do {
			temp = temp.next;
		} while (temp != rootl && temp != root2);
// LI and L2 do not end in the same cycle.
		if (temp != rootl) {
			return null; // Cycles are disjoint.
		}
// LI and L2 end in the same cycle, locate the overlapping node if they
// first overlap before cycle starts.
		int stemlLength = distance(LI, rootl), stem2Length = distance(L2, root2);
		int count = Math.abs(stemlLength - stem2Length);
		if (stemlLength > stem2Length) {
			LI = _0804_TestForOverlappingListListsAreCycleFree.advanceListByK(stemlLength - stem2Length, LI);
		} else {
			L2 = _0804_TestForOverlappingListListsAreCycleFree.advanceListByK(stem2Length - stemlLength, L2);
		}
		while (LI != L2 && LI != rootl && L2 != root2) {
			LI = LI.next;
			L2 = L2.next;
		}
// If LI == L2 before reaching rootl, it means the overlap first occurs
// before the cycle starts; otherwise, the first overlapping node is not
// unique, so we can return any node on the cycle.
		return LI == L2 ? LI : rootl;

	}

// Calculates the distance between a and b.
	private static int distance(ListNode<Integer> a, ListNode<Integer> b) {
		int dis = 0;
		while (a != b) {
			a = a.next;
			++dis;
		}
		return dis;
	}
}
