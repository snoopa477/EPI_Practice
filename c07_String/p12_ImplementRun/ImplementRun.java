package c07_String.p12_ImplementRun;
import static java.lang.System.out;
public class ImplementRun {
	
	
	public static String encoding(String s) {
		
		
		StringBuilder sb = new StringBuilder();
		
		/**
		 * c1 c1 c1 c1 c2 c2 c2 c2 c3 c3 c3 
		 */
		
		/**
		 * CAREFULE: since we detect each token by comparing current and previous,
		 * there's no index which previous is last element of string
		 * 
		 * ----
		 * 
		 * What if? we start with index 0? since we gotta compare with previous one, it would not make sense when index = 0; then we have to
		 * set up and edge check if index is 0, which is redundant cuz it's definitive. 
		 */
		
		
		//DETAIL: count for index 0, which is definitive
		int countOfCurrentChar = 1;
		
		//I prefer i < s.length() over i <= s.length(), because very often I overlook <= as <
		for( int i = 0 + 1; i < s.length(); i++ ) {
			
			if( isSameAsPrevious( s, i ) ) {
				countOfCurrentChar++;
			}
			//append to result, prepare for next round
			/**
			 * c1 c1 c1 c1 c2 c2 c2 c2 c3 c3 c3
			 *             ^
			 */
			else {
				sb.append( countOfCurrentChar );
				sb.append( s.charAt( i - 1 ) );
				
				//this is for index i
				countOfCurrentChar = 1;
			}
		}
		
		//Imagine: Reaching here means i == length() if i still exist, and null is not equal to last element.
		sb.append( countOfCurrentChar );
		sb.append( s.charAt( s.length() - 1 ) );
		
		return sb.toString();
	}
	
	
	
	public static String decoding(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		/**
		 * d3 d2 d1 d0 ch d3 d2 d1 d0 ch  ... d3 d2 d1 d0 ch
		 */
		
		int digitSum = 0;
		for( int i = 0; i < s.length(); i++ ) {
			
			char c = s.charAt( i );
			
			if( Character.isDigit( c ) ) {
				int digit = charToInt( c );
				digitSum = digitSum * 10 + digit;
			}
			/**
			 * c is character
			 * digitSum is converted to result token, hence  digitSum is consumed and becomes 0, preparing for next round
			 */
			else {
				//I prefer for over while
				for( int count = 0; count < digitSum; count++ ) {
					sb.append( c );
				}
				digitSum = 0;
			}
		}
		
		
		return sb.toString();
	}
	
	
	
	//under the premise that c is digit
	private static int charToInt( char c ) {
		return c - '0';
	}
	
	
	
	private static boolean isSameAsPrevious( String s, int i ){
		
		//will crash if this don't check
		if( i == 0 ) {
			return false;
		}
		
		return s.charAt(i) == s.charAt( i - 1);
	}


}


