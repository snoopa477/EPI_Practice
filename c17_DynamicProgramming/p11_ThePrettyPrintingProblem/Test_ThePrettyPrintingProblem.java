package c17_DynamicProgramming.p11_ThePrettyPrintingProblem;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class Test_ThePrettyPrintingProblem {

	public static void main(String[] args) {
		
		List<String> words01 = Arrays.asList("a", "b", "c", "d");
		List<String> words02 = Arrays.asList("aaa", "bbb", "c", "d", "ee", "ff", "ggggggg");
		
		
		//ThePrettyPrintingProblem.IS_DEBUG = true;
		
		out.println( _1711_ThePrettyPrintingProblem.minimumMessiness(words01, 5) );
		out.println( ThePrettyPrintingProblem.minimumMessiness(words01, 5) );
		
		out.println( _1711_ThePrettyPrintingProblem.minimumMessiness(words02, 11) );
		out.println( ThePrettyPrintingProblem.minimumMessiness(words02, 11) );
		
		
	}

}


