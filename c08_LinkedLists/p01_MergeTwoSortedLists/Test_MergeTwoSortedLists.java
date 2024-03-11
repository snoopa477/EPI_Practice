package c08_LinkedLists.p01_MergeTwoSortedLists;
import static java.lang.System.out;

import util.ListNode;
public class Test_MergeTwoSortedLists {

	public static void main(String[] args) {
		
		{
			ListNode<Integer> l1 = makeList( 2, 5, 7);
			ListNode<Integer> l2 = makeList( 3, 11);
			
			printList( MergeTwoSortedLists.mergeTwoSortedLists(l1, l2) );
			
		}
		
		
		{
			ListNode<Integer> l1 = makeList( 2);
			ListNode<Integer> l2 = makeList( 3, 5, 7, 11);
			
			printList( MergeTwoSortedLists.mergeTwoSortedLists(l1, l2) );
			
		}
		
		
	}
	
	
	
	private static ListNode<Integer> makeList( int... elements ){
		
		//this make code simpler
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> dummyTail = dummyHead;
		
		for( int element : elements ) {
			dummyTail.next = new ListNode<Integer>(element, null);
			dummyTail = dummyTail.next; 
		}
		
		return dummyHead.next;
	}
	
	
	
	private static void printList( ListNode<Integer> list ) {
		
		while( list != null ) {
			out.print( list.data + " -> ");
			list = list.next;
		}
		
		out.println("x");
		
	}

}


