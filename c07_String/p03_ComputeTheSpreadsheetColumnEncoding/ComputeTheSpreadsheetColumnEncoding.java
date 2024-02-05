package c07_String.p03_ComputeTheSpreadsheetColumnEncoding;
import static java.lang.System.out;
public class ComputeTheSpreadsheetColumnEncoding {
	
	private static final int BASE26 = 26;
	
	public static int decodeColIdToNum( final String colId ) {
		
		/**
		 * QUESTION:
		 * in this problem no start with with 0
		 * that is:
		 * a -> 1
		 * b -> 2
		 * ...
		 * z -> 26
		 * 
		 * and the base is also 26, which is weird to me.
		 * 
		 * usually, when base is n, the value ranges from 0 to n-1
		 */
		
		//Essentially this is base 26 covert to base 10 problem
		
		int result = 0;
		
		//start whit MSB
		for( int i = 0; i < colId.length(); i++ ) {
			//shift left, getting larger
			result = result * BASE26 + convertBase26toBase10( colId.charAt( i ) );
		}
		
		return result;
		
	}
	
	
	
	private static int convertBase26toBase10( char c ) {
		
		//no such case
		//if( '0' <= c && c <= '9' ) {
		//	return c - '0';
		//}
		
		// a -> 1, b -> 2 ...
		//start with 1
		if( 'a' <= c && c <= 'z' ) {
			return c - 'a' + 1;
		}
		else if( 'A' <= c && c <= 'Z' ) {
			return c - 'A' + 1;
		}
		
		return 0 ;
	}

}


