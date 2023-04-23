package c19_Graphs.p07_TransformOneStringToAnother;
import static java.lang.System.out;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Test_TransformOneStringToAnother {

	public static void main(String[] args) {
		
		
		Set<String> words = new HashSet<>( Arrays.asList( "bat","cot","dog","dag","dot","cat") );
		out.println( TransformOneStringToAnother.transformstring(words, "cat", "dog" ) );
		
		words = new HashSet<>( Arrays.asList( "bat","cot","dog","dag","dot","cat") );
		out.println( TransformOneStringToAnother.transformstring(words, "bat", "dog" ) );
		
		testSubString();
		
	}
	
	
	
	public static void testSubString(  ) {
		
		String str = "0123456";
		
		out.println( "str.substring(0,0)" );
		out.println( str.substring(0,0) );
		
		out.println( "str.substring(str.length())" );
		out.println( str.substring(str.length()) );
		
	}

}


