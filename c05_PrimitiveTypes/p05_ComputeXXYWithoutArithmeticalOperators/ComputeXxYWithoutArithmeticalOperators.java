package c05_PrimitiveTypes.p05_ComputeXXYWithoutArithmeticalOperators;
import static java.lang.System.out;
public class ComputeXxYWithoutArithmeticalOperators {

	
	public static long multiply(long multiplicand, long multiplier) {
		
		/**
		 * GUESS: 
		 * if we're going to just examine kth bit is set or not, 
		 * using >>> and one bit mask is suffice.
		 * 
		 * However, if we're going to use the exact value at kth bit: 
		 * then number & ( 1 <<< k ) can't not be skipped
		 * 
		 */
		
		long sum = 0;
		
		//PURPOSE: examine one bit at a time
		/**
		 * e.g. 
		 *      1 0 0 1
		 *      1 0 1[1]
		 * ------------
		 *      1 0 1 1
		 * 
		 *      1 0 0 1
		 *      1 0[1]1
		 * ------------
		 *    1 0 1 1 0
		 *    
		 *      1 0 0 1
		 *      1[0]1 1
		 * ------------
		 *  do nothing
		 * 
		 *      1 0 0 1
		 *     [1]0 1 1
		 * ------------
		 *1 0 0 1 0 0 0
		 * 
		 */
		/* REASONING:
		 * `implicit` kth index = 0
		 * `under the premise that` after k iterations
		 * 
		 * we will examine multiplier at kth bit
		 * and if kth bit is set, we will add up multiplicand  << k
		 * 
		 * and the loop only shows 1 shiftment at a time
		 */
		while( multiplier != 0 ) {
			
			//under the premise of k iterations, examine kth bit of multiplier, in a succinct way
			if( (multiplier & 1) != 0 ) {
				
				//under the premise of k iterations, add up multiplicand << k
				sum = add( sum, multiplicand );
			}
			
			multiplicand <<=1;
			//DETAIL: works with `while( multiplier != 0 ) {`
			multiplier >>>= 1;
		}
		
		return sum;
	}

	
	
	private static long add( long a, long b ) {
		
		//DETAIL:sum has all bits from index 0 to I, which is MSB
		long sum = 0;
		
		int kthBitMask = 1;
		long aTemp = a;
		long bTemp = b;
		//DETAIL: this comes from previous index; however, at index 0, default value is 0
		long carry_InAtKthBit = 0;
		long carry_OutAtKthBit = 0;
		
		//PURPOSE: in kth iteration, we only deal with kth bit
		//it only stops when implicit index points to the max( MSB_a, MSB_b ) + 1, where both of them are 0
		//while( aTemp != 0 || bTemp != 0 ) {
		//DETAIL: since actually 3 operands involved in addition
		while( aTemp != 0 || bTemp != 0 || carry_InAtKthBit != 0) {
			
			long a_AtKthBit = a & kthBitMask;
			long b_AtKthBit = b & kthBitMask;
			
			//REASONING: at k-1th bit, now include new kth bit
			sum |= ( carry_InAtKthBit ^ a_AtKthBit ^ b_AtKthBit );
			//at least one pair has both set bit, carryout is 1 among 3 piars 
			carry_OutAtKthBit = ( carry_InAtKthBit & a_AtKthBit ) | ( a_AtKthBit & b_AtKthBit ) | ( b_AtKthBit & carry_InAtKthBit );
			
			//PURPOSE: prepare for the next iteration
			carry_InAtKthBit = carry_OutAtKthBit << 1;
			//DETAIL: works with `while( aTemp != 0 || bTemp != 0 )`
			aTemp >>>= 1;
			bTemp >>>= 1;
			
			kthBitMask <<= 1;
		}
		
		
		
		return sum;
	}
	
	
}


