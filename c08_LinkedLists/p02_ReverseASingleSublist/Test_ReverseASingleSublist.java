package c08_LinkedLists.p02_ReverseASingleSublist;
import static java.lang.System.out;

import util.ListNode;
public class Test_ReverseASingleSublist {

	public static void main(String[] args) {
		
		{
			ListNode<Integer> l1 = makeList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );
			
			printList( ReverseASingleSublist.reverseSublist(l1, 3, 6) );
		}
		
		
		{
			ListNode<Integer> l1 = makeList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );
			
			printList( ReverseASingleSublist.reverseSublist(l1, 3, 10) );
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


