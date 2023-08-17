package c05_PrimitiveTypes.p09_CheckIfADecimalIntegerIsAPalindrome;
import static java.lang.System.out;
public class CheckIfADecimalIntegerIsAPalindrome {
	
	
	public static boolean IS_DEBUG = false;
	
	public static boolean isPalindromeNumber(int x) {
		if (x < 0) {
			return false;
		}
		
		int numberOfDigits = getNumberOfDigits( x );
		
		int left = numberOfDigits -1;
		int right = 0;
		
		//while( left >= right ) {
		while( left > right ) {
			
			int left_digit = getDigit(x, left);
			int right_digit= getDigit(x, right);
			
			if( IS_DEBUG ) {
				
				out.println( "left_digit " + left_digit );
				out.println( "right_digit " + right_digit );
				out.println();
				
			}
			
			if( left_digit != right_digit ) {
				return false;
			}
			
			left--;
			right++;
		}
		
		
		return true;
	}
	
	
	
	private static int getDigit( int number, int index ) {

		int moveRight = (int) (Math.pow(10, index));
		
		//move right so ith digit is aligned with least significant bit
		return ( number / moveRight ) % 10;
	}
	
	
	
	private static int getNumberOfDigits( int number ) {
		//discard the power of most significant digit value, replaced with 1 instead 
		return (int)Math.floor( Math.log10(number) ) + 1;
	}
	

}


