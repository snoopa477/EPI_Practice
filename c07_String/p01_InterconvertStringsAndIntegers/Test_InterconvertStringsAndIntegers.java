package c07_String.p01_InterconvertStringsAndIntegers;
import static java.lang.System.out;
public class Test_InterconvertStringsAndIntegers {

	public static void main(String[] args) {
		
		
		out.println( InterconvertStringsAndIntegers.intToString_LeftToRight( -12345678 ) );
		out.println( InterconvertStringsAndIntegers.intToString_LeftToRight( 12345678 ) );
		
		out.println( InterconvertStringsAndIntegers.intToString_RightToLeft( -12345678 ) );
		out.println( InterconvertStringsAndIntegers.intToString_RightToLeft( 12345678 ) );
		
		out.println( InterconvertStringsAndIntegers.stringToInt( "-12345678" ) );
		out.println( InterconvertStringsAndIntegers.stringToInt( "12345678" ) );
		
		
	}

}


