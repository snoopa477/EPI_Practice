package c08_LinkedLists.p01_MergeTwoSortedLists;
import static java.lang.System.out;

import util.ListNode;
public class MergeTwoSortedLists {
	
	
	public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1, ListNode<Integer> L2) {
		
		ListNode<Integer> head1 = L1;
		ListNode<Integer> head2 = L2;
		
		ListNode<Integer> mergedHead = null;
		ListNode<Integer> mergedTail = null;
		
		//PURPOSE: pick the smallest among the two, under the premise that both list exist
		//REASONING: as long as head is not null, we can infer that the length of list at least one. To know the exact length, we need more info
		while( head1 != null && head2 != null ) {
			
			if( head1.data < head2.data ) {
				
				if( mergedHead == null ) {
					mergedHead = head1;
					mergedTail = head1;
					head1 = head1.next;
				}
				//PURPOSE: append the smallest element to mergedList tail
				//IMAGINE: greedy snake
				else {
					mergedTail.next = head1;
					//greedy snake consumes the smallest element
					mergedTail = head1;
					//the remaining list shrink size by one... eventually it may disappear before another list
					head1 = head1.next;
				}
				
			}
			//head1.data >= head2.data
			else {
				if( mergedHead == null ) {
					mergedHead = head2;
					mergedTail = head2;
					head2 = head2.next;
				}
				else {
					mergedTail.next = head2;
					mergedTail = head2;
					head2 = head2.next;
				}
			}
		}
		
		
		//it somehow is similar to merge sort
		//now that there exist only one list(or even none); in either way, can get smallest element without comparing
		if( head1 == null ) {
			//take over the remaining
			mergedTail.next = head2;
		}
		else {
			mergedTail.next = head1;
		}
		
		
		return mergedHead;
	}

}


