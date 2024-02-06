package c07_String.p04_ReplaceAndRemove;
import static java.lang.System.out;
public class Test_ReplaceAndRemove {

	public static void main(String[] args) {
		
		
		test( new char[] { 'a', 'c', 'd', 'b', 'b', 'c', 'a', 0, 0, 0}, 7 );
		test( new char[] { 'b', 'b', 'b', 0, 0, 0, 0, 0, 0, 0}, 3 );
		test( new char[] { 'a', 'a', 'a', 0, 0, 0, 0, 0, 0, 0}, 3 );
		test( new char[] { 'a', 'z', 'a', 'z', 'a', 'z', 0, 0, 0, 0}, 6 );
	}
	
	
	
	private static void test( char[] str, int strSize ) {
		out.println("------------------");
		out.println( str );
		out.println( ReplaceAndRemove.replaceAndRemove(str, strSize) );
	}
	

}


