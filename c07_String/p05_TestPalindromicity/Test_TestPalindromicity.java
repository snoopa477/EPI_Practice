package c07_String.p05_TestPalindromicity;
import static java.lang.System.out;
public class Test_TestPalindromicity {

	public static void main(String[] args) {
		test("A man, a plan, a canal, Panama.");
		test("A man, a pplan, a canal, Panama.");
		test("Able was I, ere I saw \r\n Elba!");
	}
	
	
	private static void test( String str ) {
		
		out.println( str + TestPalindromicity.isPalindrome(str) );
		out.println("----------------");
		
	}

}


