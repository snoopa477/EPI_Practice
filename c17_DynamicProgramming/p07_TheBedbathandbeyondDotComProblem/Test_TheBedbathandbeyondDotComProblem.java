package c17_DynamicProgramming.p07_TheBedbathandbeyondDotComProblem;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Test_TheBedbathandbeyondDotComProblem {

	public static void main(String[] args) {
		
		Set<String> dictionary = new HashSet<>( Arrays.asList("a", "man", "plan", "canal", "am") );
		
		String str = "amanaplanacanal";
		
		out.println( TheBedbathandbeyondDotComProblem.decomposelntoDictionaryWords( str, dictionary ) );
		
		//see them as independent string. index i that has result doesn't mean i-1 would have result
		/*
		amanaplanacanal [a, man, a, plan, a, canal]
		amanaplanacana []
		amanaplanacan []
		amanaplanaca []
		amanaplanac []
		amanaplana [a, man, a, plan, a]
		amanaplan [a, man, a, plan]
		amanapla []
		amanapl []
		amanap []
		amana [a, man, a]
		aman [a, man]
		ama [am, a]
		am [am]
		a [a]
		 * */
		//WRONG: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 0
		//for( int i = str.length(); i>=0; i-- ) {
		for( int i = str.length(); i > 0; i-- ) {
			String subStr = str.substring(0, i);
			out.println( subStr + " " + TheBedbathandbeyondDotComProblem.decomposelntoDictionaryWords( subStr, dictionary ) );
			
		}
		
		
	}

}


