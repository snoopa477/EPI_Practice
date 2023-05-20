package c17_DynamicProgramming.p03_CountTheNumberOfWaysToTraverseA02dArray;
import static java.lang.System.out;

import java.util.Arrays;
public class CountTheNumberOfWaysToTraverseA02dArray_02_Recursion {
	
	private static int LEFT = -1;
	private static int UP = -1;
	
	
	/* THINK_FURTHER: 
	 * For loop method goes from bottom to up
	 * 
	 * while recursion method directly request the goal, finding out missing subgoal result, 
	 * and then alternatively seek the subgoal goal... way down to the base case 
	 * 
	 */
	public static int numberOfWays(int n, int m) {
		
		int[][] numberOfWays = new int[ n ][ m ];
		
		/*initialization: since value ranges >= 1, 0 is out of range, meaning it is not visited(computed) yet. 
		 * And the default value is already 0 => do nothing
		 */
		
		
		return numberOfWays( numberOfWays,  n -1, m -1 );
	}
	
	
	//return the value: numberOfWays. in the meantime, assign the value if necessary
	private static int numberOfWays( int[][] numberOfWays, int i, int j ) {
		
		//BASE CASE: 
		//DETAIL: we don't bother to store the result in cache, since it requires no computation, at the expense of consistency.
		if( i == 0 || j == 0 ) {
			return 1;
		}
		
		//REASONING: since value ranges >= 1, 0 is out of range, meaning it is not visited(computed) yet. If so, compute first
		//PURPOSE: if unvisited then compute it first.
		if( numberOfWays[i][j] == 0 ) {
			//numberOfWays[i][j] = numberOfWays[i + UP][j] + numberOfWays[i][j + LEFT];
			numberOfWays[i][j] = numberOfWays( numberOfWays, i + UP, j ) + numberOfWays( numberOfWays, i, j + LEFT );
		}
		
		
		return numberOfWays[i][j];
	}

}


