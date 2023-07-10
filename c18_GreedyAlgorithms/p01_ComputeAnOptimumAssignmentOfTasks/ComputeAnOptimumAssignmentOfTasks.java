package c18_GreedyAlgorithms.p01_ComputeAnOptimumAssignmentOfTasks;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ComputeAnOptimumAssignmentOfTasks {
	
	
	private static class PairedTasks{
		public int task01;
		public int task02;
		
		
		public PairedTasks(int task01, int task02) {
			super();
			this.task01 = task01;
			this.task02 = task02;
		}


		@Override
		public String toString() {
			return "(" + task01 + ", " + task02 + ")";
		}
		
		
		
	}
	

	
	public static List<PairedTasks> optimumAssignmentOfTasks( List<Integer> taskDurarions ){
		
		/**
		 * REASONING:
		 * if we sort, we gain the power of accessing how big the value of element by adjusting index right or left
		 * (if we don't sort, we don't know the next element will be larger or not? so is previous element) 
		 */
		/**
		 * REASONING: 
		 * the optimum assignment is measured by worst pair of tasks, instead of best pair of tasks 
		 * the better the best case, the worser for the worst case
		 * if the best case is not so best, then the worst case won't be too bad => optimum assignment
		 */
		
		Collections.sort( taskDurarions );
		
		List<PairedTasks> optimumAssignmentOfTasks = new ArrayList<>();
		
		//DETAIL: since sorted, left means min, right means max
		int left = 0, right = taskDurarions.size() -1;
		while( left <= right ) {
			
			//make the pair mediocre, so the worst case is mediocre too, which minimize the bottleneck 
			optimumAssignmentOfTasks.add( new PairedTasks( taskDurarions.get(left) , taskDurarions.get(right)) );
			
			left++;
			right--;
		}
		
		return optimumAssignmentOfTasks;
	}
	
	
	
	public static void main(String[] args) {
		
		out.println( optimumAssignmentOfTasks( Arrays.asList( 5,2,1,6,4,4) ) );

	}
}


