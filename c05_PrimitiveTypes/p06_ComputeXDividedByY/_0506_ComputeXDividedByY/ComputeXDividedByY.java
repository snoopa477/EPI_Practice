package c05_PrimitiveTypes.p06_ComputeXDividedByY._0506_ComputeXDividedByY;
import static java.lang.System.out;
public class ComputeXDividedByY {
	
	private static int INTEGER_BIT_SIZE = 32; 
	
	/**
	 * PURPOSE: 
	 * we do long division version:
	 */
	
	/**
	 * suppose 1 1 1 / 1 0
	 *                   1 1 1                  
	 * 1 0 0 0 0 0 0 0 0 0 0 0
	 * 
	 * ...shrink divisorXQuotient
	 *                   1 1 1                  
	 *                   1 0 0
	 * -------------------------
	 *                   0 1 1
	 *                   
	 *                   0 1 1
	 *                   1 0 0                             
	 * ...shrink divisorXQuotient
	 * 
	 *                   0 1 1
	 *                     1 0
	 * -------------------------
	 *                       1
	 *  smaller than divisor, ends
	 */
	
	public static long divide( long dividend, long divisor ) {
		
		int quotientPower = INTEGER_BIT_SIZE;
		
		long quotient = 0;
		
		//cannot use multiplication
		//DETAIL: this is equivalent to divisor * quotient, which is 2^quotientPower 
		long divisorXQuotient = divisor << quotientPower;
		
		/*PURPOSE each iteration means subtracting divisorXQuotient from dividend, gaining part of quotient
		 * , as both divisorXQuotient and dividend get smaller
		 * dividend is divisible only if it is larger than divisorXQuotient
		 */
		while( dividend >= divisor ) {
			
			//find the largest divisor * quotient, which is smaller than divisor, by getting smaller 
			while( divisorXQuotient > dividend ) {
				//cannot use multiplication, working with `divisorXQuotient >>>= 1`
				quotientPower--;
				//get smaller, working with `while( divisorXQuotient > dividend )`
				divisorXQuotient >>>= 1;
			}
			/*REASONING: reaching here, divisorXQuotient <= dividend, and divisorXQuotient is the largest
			 * after subtraction, the result must smaller than divisorXQuotient, 
			 * so next round we have to re do the process: find the divisorXQuotient which is smaller than dividend yet the largest
			 */
			
			//new dividend
			dividend -= divisorXQuotient;
			
			//This also works, since set bits won't overlap: gaining set bits from left to right
			//quotient |= 1L << quotientPower;
			quotient += 1L << quotientPower;
		}
		
		return quotient;
	}

}


