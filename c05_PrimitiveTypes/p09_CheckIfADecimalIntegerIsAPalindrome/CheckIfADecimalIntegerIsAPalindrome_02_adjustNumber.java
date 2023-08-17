package c05_PrimitiveTypes.p09_CheckIfADecimalIntegerIsAPalindrome;
import static java.lang.System.out;
public class CheckIfADecimalIntegerIsAPalindrome_02_adjustNumber {
	
	
	public static boolean IS_DEBUG = false;
	
	public static boolean isPalindromeNumber(int x) {
		if (x < 0) {
			return false;
		}
		
		int numberOfDigits = getNumberOfDigits( x );
		
		while( x != 0 ) {
			
			//REASONING: under the premise that there is no left part in the view point of MS mask. 
			//to support such premise we have to tailer at the end of the loop
			
			int mostSignificantMask = (int) Math.pow( 10, numberOfDigits -1 );
			//get the left part
			int mostSignificantDigit = x / mostSignificantMask;
			
			int leastSignificantDigit = x % 10;
			
			if( IS_DEBUG ) {
				out.println( "mostSignificantDigit " + mostSignificantDigit );
				out.println( "leastSignificantDigit " + leastSignificantDigit );
				out.println();
			}
			
			if( mostSignificantDigit != leastSignificantDigit ) {
				return false;
			}
			
			
			//tailer at the end of the loop: shrinking the head and tail by deleting both LSD and MSD
			
			//keep the right part, discarding left part
			x %= mostSignificantMask;
			//deleting LSD by moving right
			x /= 10;
			
			//WRONG: forget this
			numberOfDigits -=2;
			
		}
		
		
		return true;
	}
	
	
	
	
	
	private static int getNumberOfDigits( int number ) {
		//discard the power of most significant digit value, replaced with 1 instead 
		return (int)Math.floor( Math.log10(number) ) + 1;
	}

}


