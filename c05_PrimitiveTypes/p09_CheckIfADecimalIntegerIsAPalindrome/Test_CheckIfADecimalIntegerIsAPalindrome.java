package c05_PrimitiveTypes.p09_CheckIfADecimalIntegerIsAPalindrome;
import static java.lang.System.out;
public class Test_CheckIfADecimalIntegerIsAPalindrome {

	public static void main(String[] args) {
		
		int[] numbers = { 123454321, 1234521, 121, -121, 999, 9969};
		
		
		
		out.println("------------------CheckIfADecimalIntegerIsAPalindrome");
//		CheckIfADecimalIntegerIsAPalindrome.IS_DEBUG = true;
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( "i " + numbers[i] + " , is palindrome? " + CheckIfADecimalIntegerIsAPalindrome.isPalindromeNumber(numbers[i]));
		}
		
		
//		CheckIfADecimalIntegerIsAPalindrome_02_adjustNumber.IS_DEBUG = true;
		out.println("\n------------------CheckIfADecimalIntegerIsAPalindrome_02_adjustNumber");
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( "i " + numbers[i] + " , is palindrome? " + CheckIfADecimalIntegerIsAPalindrome_02_adjustNumber.isPalindromeNumber(numbers[i]));
		}
	}

}


