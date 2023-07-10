package c17_DynamicProgramming.p12_FindTheLongestNondecreasingSubsequence;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class Test_FindTheLongestNondecreasingSubsequence {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9);
		
		out.println( _1712_FindTheLongestNondecreasingSubsequence.longestNondecreasingSubsequenceLength( numbers ) );
		out.println( FindTheLongestNondecreasingSubsequence.longestNondecreasingSubsequenceLength( numbers ) );
		
	}

}


