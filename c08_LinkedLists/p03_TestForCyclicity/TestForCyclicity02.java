package c08_LinkedLists.p03_TestForCyclicity;
import static java.lang.System.out;

import util.ListNode;
public class TestForCyclicity02 {

	
	
	public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
		
		/** REASONING:
		 * facts that is not used in way01:
		 * 
		 * in each iteration, fastIter has one more step distance from slowIter in slowIter's viewpoint 
		 * => so in circle length * n steps, both fastIter and slowIter's will meet, 
		 *  where circle length * ( n - 1 ) < stick length (meaning slowIter not on circle yet) 
		 * 	and circle length * n  >= stick length
		 *  
		 * when they meet, from start of circle's viewpoint, slowIter have gone circle length - stick length steps.
		 * Therefore, when slowIter goes more stick Lenght steps, it will reach to start of circle, 
		 * which is THE SAME steps as a iter goes from start of stick to tail of stick
		 * 
		 * so we let both iter goes, they will meet at start of circle
		 *  
		 * interestingly, we only need to know the fact some distance are equal without knowing exact length of circle and stick
		 *  
		 */
		
		ListNode<Integer> slowIter = head;
		ListNode<Integer> fastIter = head;
		
		while( fastIter!= null && fastIter.next != null && fastIter.next.next != null ) {
			
			slowIter = slowIter.next;
			fastIter = fastIter.next.next;
			
			//REASONING: reaching here means slow iter have gone  circle length - stick length steps from start of circle's viewpoint 
			if( slowIter == fastIter ) {
				
				ListNode<Integer> iterFromSlowFastMeet = slowIter;
				ListNode<Integer> iterFromStart = head;
				
				//stick length more steps(which is unknown) they will meet at start of circle
				do {
					iterFromSlowFastMeet = iterFromSlowFastMeet.next;
					iterFromStart = iterFromStart.next;
				} while( iterFromSlowFastMeet != iterFromStart );
				
				return iterFromSlowFastMeet;
			}
		}
		
		
		return null;
	}
	
}


