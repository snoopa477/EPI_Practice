package c08_LinkedLists.p02_ReverseASingleSublist;
import static java.lang.System.out;

import util.ListNode;
public class ReverseASingleSublist {
	
	
	public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
		
		if( start == finish ) {
			return L;
		}
		
		ListNode<Integer> beforeHead = getBeforeHead(L, start );
		ListNode<Integer> tail = beforeHead.next;
		
		
		int numberOfExecution = finish - start;
		for( int i = 0; i < numberOfExecution; i++ ) {
			moveAfterTailToBeforeHead(L, beforeHead, tail);
		}
		
		return L;
	}
	
	
	
	private static ListNode<Integer> getBeforeHead( ListNode<Integer> L, int start ){
		
		ListNode<Integer> dummy = new ListNode<Integer>(0, L);
		ListNode<Integer> beforeHead = dummy;
		
		//if i = 0, will get to start; i = 1, will get to node before start
		for( int i = 0 + 1; i < start; i++ ) {
			beforeHead = beforeHead.next;
		}
		
		return beforeHead;
	}
	
	
	
	private static void moveAfterTailToBeforeHead( ListNode<Integer> L, ListNode<Integer> beforeHead, ListNode<Integer> tail ) {
		
		//PURPOSE: after tail is our target to move
		
		/*        head/tail
		 *        |
		 *  1  2 [3] 4  5  6  7  8  9
		 *     |     |
		 *     bHead aTail
		 * 
		 * ------------------------------
		 *        head     tail
		 *        |        |
		 *  1  2 [6  5  4  3] 7  8  9
		 *     |              |
		 *     beforeHead     afterTail
		 *  
		 *  ------------------------------
		 *        head        tail
		 *        |           |
		 *  1  2 [7  6  5  4  3]  8  9
		 *     |                  |
		 *     beforeHead         afterTail  
		 *  
		 */
		
		ListNode<Integer> head = beforeHead.next;
		ListNode<Integer> afterTail = tail.next;
		
		tail.next = afterTail.next;
		beforeHead.next = afterTail;
		afterTail.next = head;
		
	}
	

}


