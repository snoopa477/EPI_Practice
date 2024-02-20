package c07_String.p09_ConvertFromRomanToDecimal;
import static java.lang.System.out;
public class Test_ConvertFromRomanToDecimal {

	public static void main(String[] args) {
		
		out.println( ConvertFromRomanToDecimal.romanToInteger( "XXXXXIIIIIIIII" ) );
		out.println( ConvertFromRomanToDecimal.romanToInteger( "LVIIII" ) );
		out.println( ConvertFromRomanToDecimal.romanToInteger( "LIX" ) );
		out.println( ConvertFromRomanToDecimal.romanToInteger( "MCMLXXXIV" ) );
	}

}


