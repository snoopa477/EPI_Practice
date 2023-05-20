package c17_DynamicProgramming.p04_ComputeTheBinomialCoefficients;
import static java.lang.System.out;
public class ComputeTheBinomialCoefficients {

	
	//The code is not hard but the reasoning itself
	public static int computeBinomialCoefficient(int n, int k) {
		
		/**
		 * row i is total number
		 * col j is the number we'd like to pick
		 * value is the combination of pick j among i
		 */
		//the value is >=1 ( since at least one way). 0 means unvisited, and default value for int is 0 => don't do anything
		
		int[][] amongYPickX = new int[ n +1 ][ k  +1 ];
		
		return computeAmongYPickX( amongYPickX, n, k );
	}

	
	
	private static int computeAmongYPickX(int[][] amongYPickX, int y, int x) {
		
		//PURPOSE: to avoid stack overflow, can't do sequence of multiplication in one time
		/**
		 * REASONING
		 * split x choose among y into two steps:
		 * 
		 * step 1: consider only one node. the maximum way to choose is 2 : picked(black) or un-picked(white)
		 * 
		 * step 2:
		 * 	 consider the remaining x -1 nodes
		 *   based on step 1, 
		 *     if step 1 node is the picked(black), the the remaining combination is pick(y-1) among (x-1)
		 *     	, because when we get the picked in step 1, in step2, we subtract one from allPickes, subtracting one(picked) from all
		 *     => total comb: 1(picked) * pick(y-1) among (x-1)
		 *      
		 *     if step 1 node is the un-picked(white), the the remaining combination is pick(y) among (x-1)
		 *     , because when we get the un-picked in step1; in step 2, we don't affect allPicks, subtracting one(un-picked) from all
		 *     => total comb: 1(un-picked) * pick(y) among (x-1)
		 *     
		 *   summ up all cases: picked combination and un-picked combination:
		 *   	1(picked) * pick(y-1) among (x-1) + 1(un-picked) * pick(y) among (x-1)
		 */
		
		//BASE CASE
		//when pick 0 among y, or pick all among y. There cound only one combination
		//if( x == 0 || x == y ) {
		if( x == 0 || y == 0 || x == y ) {
			return 1;
		}
		
		
		if( amongYPickX[y][x] == 0 ) {
			amongYPickX[y][x] = 1/*picked*/ * computeAmongYPickX( amongYPickX, y -1, x -1 ) + 1/*un-picked*/ *  computeAmongYPickX( amongYPickX, y -1, x );
		}
		
		
		return amongYPickX[y][x];
	}
	
}


