package c17_DynamicProgramming.p03_CountTheNumberOfWaysToTraverseA02dArray;
import static java.lang.System.out;

import java.util.Arrays;
public class CountTheNumberOfWaysToTraverseA02dArray_01_ForLoop {
	
	private static int LEFT = -1;
	private static int UP = -1;
	
	public static int numberOfWays(int n, int m) {
		
		int[][] numberOfWays = new int[ n + 1 ][ m + 1 ];
		
		/* 
		 * we go assigning from smallest to largest. 
		 * F[i][j] = F[ i -1 ][ j ] + F[ i ][ j - 1 ] 
		 * the smaller  F[ i -1 ][ j ] and F[ i ][ j - 1 ]  has already assigned value
		 * so we don't need to check whether the smaller has already assigned or not
		 */
		
		
		//BASE CASE: can decide value itself without consider other case
		//the first column only consists of one direction: down, hence there's only ONE way to reach
		for( int i = 0; i < numberOfWays.length; i++ ) {
			numberOfWays[ i ][ 0 ] = 1;
		}
		
		//BASE CASE
		//the first row only consists of one direction: right, hence there's only ONE way to reach
		Arrays.fill( numberOfWays[0], 1 );
		
		
		//PURPOSE: assign the remaining, until numberOfWays[n][m]
		for( int i = 1 /*aside from first row, to which we already assign*/; i < numberOfWays.length; i++  ) {
			for( int j = 1 /*aside from first column*/ ; j < numberOfWays[0].length; j++ ) {
				numberOfWays[i][j] = numberOfWays[i + UP][j] + numberOfWays[i][ j + LEFT ]; 
			}
		}
		
		
		return numberOfWays[n][m];
	}
	

}


