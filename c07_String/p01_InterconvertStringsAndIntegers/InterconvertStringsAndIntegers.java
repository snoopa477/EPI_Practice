package c07_String.p01_InterconvertStringsAndIntegers;
import static java.lang.System.out;

import java.util.Collections;
public class InterconvertStringsAndIntegers {
	
	
	public static String intToString_LeftToRight(int x) {
		
		StringBuilder sb = new StringBuilder();
		
		if( x < 0 ) {
			sb.append("-");
			//wrong if miss this, would cause every digit as negative
			x = Math.abs( x );
		}
		
		
		int length = getLength(x);
		int separator = (int) Math.pow(10, length - 1 );
		
		
		while( x != 0 ) {
			int numToAppend = x / separator;
			
			//still work, it is another overloaded method
			//sb.append( numToAppend );
			sb.append( digitToChar(numToAppend) );
			
			//prepare for next round
			//Concept: move right
			x %= separator;
			separator /= 10;
		}
		
		
		return sb.toString();
	}
	
	
	
	public static String intToString_RightToLeft(int x) {
		
		/* PURPOSE: 
		 * step 1. build string reversely
		 * step 2. reverse the reversed string
		 */
		
		final int separator = 10;
		
		//PURPOSE: step 1: build string reversely 
		
		//DETAIL: since we gonna build reversely, save the sign for last step
		boolean isNegatvie = false;
		if( x < 0 ) {
			isNegatvie = true;
			x = Math.abs( x );
		}

		
		StringBuilder sb = new StringBuilder();
		while( x != 0 ) {
			
			char charToAppend  = digitToChar( x % separator );
			sb.append( charToAppend );
			
			//prepare for next round
			//Concept: move left, in the view point of fixed position of separator
			x /= separator;
		}
		
		
		if( isNegatvie ) {
			sb.append( "-" );
		}
		
		
		//step 2: reverse the reversed string 
		sb.reverse();
		
		return sb.toString();
	}
	
	
	
	public static int stringToInt(String s) {
		
		boolean isNegative = s.charAt(0) == '-' ? true : false;
		int startIdx = isNegative? 1 : 0;
		
		int result = 0;
		
		for( int i = startIdx; i < s.length(); i++ ) {
			int num =  charToDigit( s.charAt(i) );
			
			//move left and add new element
			result = result * 10 + num;
		}
		
		//WRONG if missing this
		if( isNegative ) {
			result *= -1;
		}
		
		return result;
	}
	
	
	
	private static int getLength(int x) {
		
		int length = 0;
		
		//This don't work if we process negative number
		//while( x > 0 )
		while( x != 0 ) {
			x /= 10;
			length++;
		}
		
		return length;
	}
	
	
	
	private static char digitToChar( int num ) {
		return (char) ( '0' + num );
	}
	
	
	
	private static int charToDigit( char c ) {
		return (int)( c - '0' );
	}
}



