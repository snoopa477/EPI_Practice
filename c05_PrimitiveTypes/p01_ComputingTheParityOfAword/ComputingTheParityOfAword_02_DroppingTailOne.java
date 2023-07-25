package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;
public class ComputingTheParityOfAword_02_DroppingTailOne {

	
public static short parity( long x ) {
		
		short result = 0;
		
		/**
		 * PURPOSE: 
		 * the number of 1s = the number of times we can drop tailing ones before the number is reduced to 0
		 * 
		 * the result is independent how 1s are spread, but the number of times a number can flip
		 */
		
		/** 
		 * REASONING: how to drop tailing 1
		 * e.g. 
		 * 1 1 1 0 0 1 0 0 0 0 0 - x 
		 * 1 1 1 0 0 0 1 1 1 1 0 - x-1
		 * ----------------------- AND
		 * 1 1 1 0 0 0 0 0 0 0 0
		 * 
		 * read this way:
		 * given x is 0 or 1
		 * x AND x remains the same
		 * x AND y becomes 0, given x != y
		 * =>
		 * when two are the same, result remains
		 * when two are different, result 0
		 * 
		 * and x - 1 only affect the tailing 1 becoming 0 (different), and the right side of it becoming 1(different)
		 * the different part becomes 0 when x AND (x -1) 
		 * 	however, since the right side of tail 1 is already 0, it makes no difference when it turns out to be 0
		 * 
		 */
		
		
		//DETAIL: keep drop until x = 0, 0 means no 1 to consider
		while( x > 0 ) {
			
			//flip
			result = (short)(result ^ 1);
			
			//PURPOSE: drop tailing 1, meaning we already process this tailing set bit.
			//also, the number becomes smaller
			x =  x & ( x - 1 ) ;

		}
		
		
		return result;
	}
	
	
}


