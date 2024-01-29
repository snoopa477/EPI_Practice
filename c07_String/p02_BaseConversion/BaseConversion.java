package c07_String.p02_BaseConversion;
import static java.lang.System.out;
public class BaseConversion {
	
	public static boolean IS_DEBUG = false;

	public static String convertBase(String numAsString, int b1, int b2) {
		
		int numBase10 = convertBaseB1To10( numAsString, b1 );
		String numBaseB2AsString = convertBase10ToB2( numBase10, b2 );
		return numBaseB2AsString;
	}
	
	
	
	private static int convertBaseB1To10( String numAsString, int b1) {
		
		boolean isNegative = numAsString.charAt(0) == '-' ? true : false;
		
		int result = 0;
		
		//start from MSB. so when iterate from left to right, MSB has been multiplied by b1 several times
		for( int i = isNegative? 1: 0; i < numAsString.length(); i++ ) {
			//move left
			result = result * b1 + charToInt( numAsString.charAt(i) );
		}
		
		if( isNegative ) {
			result = - result;
		}
		
		return result;
	}
	
	
	
	private static String convertBase10ToB2( int num, int b2) {
		
		boolean isNegative = num < 0;
		if( isNegative ) {
			num = Math.abs(num);
		}
		
		String result = convertBase10ToB2Helper( num, b2 );
		if( isNegative ) {
			result = "-" + result;
		}
		
		return result;
	}
	
	
	
	//QUESTION: why I can only process positive number?
	//MY OP: it is difficult for me
	/* REASONING:
	 * recursive, in each iteration. after modulus, there is quotient and remainder. remainder is definite.
	 * keep doing it until there left only remainder, quotient = 0
	 */
	private static String convertBase10ToB2Helper( int num, int b2 ) {
		
		int quotient = num / b2;
		int remainder = num % b2;
		String remainderAsString = convertIntToString( remainder );
		
		//Base case
		//WRONG if you miss base case -> infinite loop
		if( quotient == 0 ) {
			return remainderAsString;
		}
		else {
			//DETAIL: String append
			return convertBase10ToB2Helper( quotient, b2 ) + remainderAsString;
		}
	}
	
	

	//ASSUMPTION: 0~9A~F
	private static int charToInt( char c ) {
		
		if( c <= '9' ) {
			return c - '0';
		}
		// 'A' <= c <= 'F'
		else {
			//DETAIL: A maps to 10, B to 11 ...
			return c - 'A' + 10;
		}
	}
	
	
	
	//ASSUMPTION: 0 <= num <= 16
	private static String convertIntToString( int num ) {
		
		if( num < 10 ) {
			//WRONG, it will be 49, given integer value is 1
			//return String.valueOf( num + '0' );
			//overloaded function
			return String.valueOf( (char)(num + '0') );
		}
		// 10 <= num <= 16
		else {
			//return String.valueOf( ( num - 10 ) + 'A' );
			return String.valueOf( (char)( ( num - 10 ) + 'A') );
		}
	}

	
}


