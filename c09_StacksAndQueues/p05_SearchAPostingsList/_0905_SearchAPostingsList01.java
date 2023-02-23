package c09_StacksAndQueues.p05_SearchAPostingsList;

import static java.lang.System.out;

public class _0905_SearchAPostingsList01 {

	public static void setJumpOrder(PostingListNode L) {
		setJumpOrderHelper(L, 0);
	}

	private static int setJumpOrderHelper(PostingListNode L, int order) {
		if (L != null && L.order == -1) {
			L.order = order++;
			order = setJumpOrderHelper(L.jump, order);
			order = setJumpOrderHelper(L.next, order);
		}
		return order;
	}
}
