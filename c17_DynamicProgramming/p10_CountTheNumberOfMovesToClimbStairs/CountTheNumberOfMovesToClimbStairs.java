package c17_DynamicProgramming.p10_CountTheNumberOfMovesToClimbStairs;
import static java.lang.System.out;

import java.util.Arrays;
public class CountTheNumberOfMovesToClimbStairs {
	
	//WRONG: it's tricky. since the answer is the accumulation from 0. So don't set unvisit as -1
	//private static int UNVISITED = -1;
	private static int UNVISITED = 0;
	
	public static int numberOfWaysToTop(int topPosition, int maximumStep) {
		
		/**
		 *  numberOfWaysToPosition[ i ] = k 
		 *  means there are k ways to reach position i
		 */
		int[] numberOfWaysToPosition = new int[ topPosition + 1 ];
		//Arrays.fill( numberOfWaysToPosition, UNVISITED );
		
		return numberOfWaysToPosition( topPosition, maximumStep, numberOfWaysToPosition );
	}

	
	
	private static int numberOfWaysToPosition(int current_Position, int maximumStep, int[] numberOfWaysToPosition) {
		
		/* 
		 * corner case, no dependence to sub call 
		 * we define position 0 has 1 way to reach.
		 * so position 1 'value only comes from position 0's value, which is also 1
		 * 
		 * 0  1
		 */
		if( current_Position <= 1 ) {
			return 1;
		}
		
		
		//assign numberOfWaysToPosition[ currentPosition ] when first visit
		if( numberOfWaysToPosition[ current_Position ] == UNVISITED ) {
			
			for( int step = 1; step <= maximumStep; step++ ) {
				
				int previous_Position = current_Position - step;
				
				
				//WRONG: think of position 2, it can either come from position 0 or positoin 1
				//if( previous_Position > 0 ) {
				if( previous_Position >= 0 ) {
					numberOfWaysToPosition[ current_Position ] += numberOfWaysToPosition( previous_Position,  maximumStep, numberOfWaysToPosition);
				}
				
			}
		}
		
		
		return numberOfWaysToPosition[ current_Position ];
	}
	

}


