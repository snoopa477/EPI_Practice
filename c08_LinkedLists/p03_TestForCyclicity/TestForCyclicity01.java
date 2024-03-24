package c08_LinkedLists.p03_TestForCyclicity;
import static java.lang.System.out;

import util.ListNode;
public class TestForCyclicity01 {

	/**
	 * a link list that has cycle can be thought of consisting a stick and a circle 
	 * 
	 */
	public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
		
		/**
		 * PURPOSE 
		 * 1: check if there exist circle
		 * 2: calculating the length of circle
		 * 3: get to the tail of stick, which is the start of circle
		 * 	3.1: setting up a iterA that has gone circleLength
		 * 	3.2: let iterA and B goes at the same time and meet
		 */
		
		
		ListNode<Integer> slowIter = head;
		ListNode<Integer> fastIter = head;
		
		while( fastIter!= null && fastIter.next != null && fastIter.next.next != null ) {
			
			/**
			 * in each iteration, fastIter has one more step distance from slowIter in slowIter's viewpoint 
			 */
			
			slowIter = slowIter.next;
			fastIter = fastIter.next.next;
			
			//PURPOSE 1: check if there exist circle
			/**
			 * slowIter == fastIter => there exists circle
			 * if there exist circle, fastIter will eventually catch up slowIter at the circle from behind
			 */
			if( slowIter == fastIter ) {
				
				//PURPOSE 2: calculating the length of circle
				//now both of them in the circle, start calculating the length of circle
				int circleLength = 0;
				/**
				 * in each iteration, fastIter has one more step distance from slowIter in slowIter's viewpoint.
				 * when slowIter == fastIter, that means the step distance = circle length
				 */
				do {
					slowIter = slowIter.next;
					fastIter = fastIter.next.next;
					circleLength++;
				} while( slowIter != fastIter );
				
				
				//PURPOSE 3: get to the tail of stick, which is the start of circle
				/**
				 * REASONING: 
				 *  a linked list that has cycle can be thought of consisting a stick and a circle.
				 *  1. If a iterator have gone circle length steps, then there remains stick length steps to get to start of circle; however,
				 *  I don't know the length of a stick
				 *  
				 *  However, I know the distance from a iterA going from head of stick to tail of stack EQUALS to distance from a iterB that have gone circle length to start of a circle
				 *  If I let these itersA and B go at the same time, they will meet at the start of a circle
				 *  
				 *  So I can get start of a circle without know exact length of a stick
				 */
				
				//PURPOSE 3.1: setting up a iterA that has gone circleLength
				
				ListNode<Integer> iterA = head;
				for( int i = 0; i < circleLength; i++ ) {
					iterA = iterA.next;
				}
				
				//PURPOSE 3.2: let iterA and B goes at the same time and meet
				ListNode<Integer> iterB = head;
				
				while( iterA != iterB ) {
					iterA = iterA.next;
					iterB = iterB.next;
				}
				
				//they meet at the start of a circle
				return iterA;
 				
			}
		}
		//reaching here means no circle, just a line => no exist of start of a circle 
		
		return null;
	}
}


