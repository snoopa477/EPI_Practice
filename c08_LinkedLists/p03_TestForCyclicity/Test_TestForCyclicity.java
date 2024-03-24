package c08_LinkedLists.p03_TestForCyclicity;
import static java.lang.System.out;

import java.util.HashSet;

import javax.management.StringValueExp;

import util.ListNode;
public class Test_TestForCyclicity {

	public static void main(String[] args) {
		
		{
			ListNode<Integer> circle = makeCircle( 4 , 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
			printList( circle );
			ListNode<Integer> startOfCircle = TestForCyclicity01.hasCycle(circle);
			out.println( startOfCircle == null? "none" : String.valueOf(startOfCircle.data) );
		}
		
		
		{
			ListNode<Integer> circle = makeCircle( 4 , 0, 1, 2, 3, 4, 5, 6 );
			printList( circle );
			ListNode<Integer> startOfCircle = TestForCyclicity01.hasCycle(circle);
			out.println( startOfCircle == null? "none" : String.valueOf(startOfCircle.data) );
		}
		
		
		{
			ListNode<Integer> list = makeList( 0, 1, 2, 3, 4, 5, 6 );
			printList( list );
			ListNode<Integer> startOfCircle = TestForCyclicity01.hasCycle(list);
			out.println( startOfCircle == null? "none" : String.valueOf(startOfCircle.data) );
		}
		
		
		
		{
			ListNode<Integer> circle = makeCircle( 4 , 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
			printList( circle );
			ListNode<Integer> startOfCircle = TestForCyclicity02.hasCycle(circle);
			out.println( startOfCircle == null? "none" : String.valueOf(startOfCircle.data) );
		}
		
		
		{
			ListNode<Integer> circle = makeCircle( 4 , 0, 1, 2, 3, 4, 5, 6 );
			printList( circle );
			ListNode<Integer> startOfCircle = TestForCyclicity02.hasCycle(circle);
			out.println( startOfCircle == null? "none" : String.valueOf(startOfCircle.data) );
		}
		
		
		{
			ListNode<Integer> list = makeList( 0, 1, 2, 3, 4, 5, 6 );
			printList( list );
			ListNode<Integer> startOfCircle = TestForCyclicity02.hasCycle(list);
			out.println( startOfCircle == null? "none" : String.valueOf(startOfCircle.data) );
		}
		
		
		
		
	}
	
	
	
	private static ListNode<Integer> makeCircle( int indexOfStartOfCircle, int... elements ){
		
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> dummyTail = dummyHead;
		
		//DETAIL: careful, + 1 is required
		int coutDown = indexOfStartOfCircle + 1;
		ListNode<Integer> startOfCircle = null;
		
		for( int element : elements ) {
			
			if( coutDown == 0 ) {
				startOfCircle = dummyTail; 
			}
			
			dummyTail.next = new ListNode<Integer>(element, null);
			dummyTail = dummyTail.next; 
			coutDown--;
		}
		
		dummyTail.next = startOfCircle;
		
		return dummyHead.next;
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
		
		HashSet<ListNode<Integer>> uniqueNodes = new HashSet<>();
		
		while( list != null ) {
			
			//circle, and it is start of a circle
			if( uniqueNodes.contains(list)  ) {
				out.println( list.data + "(start of circle)");
				return;
			}
			
			uniqueNodes.add(list);
			out.print( list.data + " -> ");
			list = list.next;
			
			//out.println( list + " " + list.data );
		}
		
		out.println("x");
		
	}

}


