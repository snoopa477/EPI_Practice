package c09_StacksAndQueues.p05_SearchAPostingsList;

import static java.lang.System.out;
import java.util.Deque;
import java.util.LinkedList;

public class _0905_SearchAPostingsList02 {

	public static void setJumpOrder(PostingListNode L) {
		Deque<PostingListNode> s = new LinkedList<>();
		int order = 0;
		s.addFirst(L);
		while (!s.isEmpty()) {
			PostingListNode curr = s.removeFirst();
			if (curr != null && curr.order == -1) {
				curr.order = order++;
// Stack is last-in, first-out, and we want to process
// the jump node first, so push next, then push jump.
				s.addFirst(curr.next);
				s.addFirst(curr.jump);
			}
		}
	}
}
