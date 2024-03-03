package c07_String.p13_FindTheFirstOccurrenceOfASubstring;
import static java.lang.System.out;
public class Test_FindTheFirstOccurrenceOfASubstring {

	public static void main(String[] args) {
		
		FindTheFirstOccurrenceOfASubstring.IS_DEBUG = false;
		
		out.println ( FindTheFirstOccurrenceOfASubstring.rabinKarp("GACGCCA", "CGC") );
		out.println ( FindTheFirstOccurrenceOfASubstring.rabinKarp("GACGACCGC", "CGC") );
	}

}


