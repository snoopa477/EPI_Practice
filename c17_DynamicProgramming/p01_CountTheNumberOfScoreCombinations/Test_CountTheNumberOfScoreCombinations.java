package c17_DynamicProgramming.p01_CountTheNumberOfScoreCombinations;
import static java.lang.System.out;

import java.util.Arrays;

public class Test_CountTheNumberOfScoreCombinations {

	
	public static void main(String[] args) {
		
		out.println( _1701_CountTheNumberOfScoreCombinations.numCombinationsForFinalScore(12, Arrays.asList(2, 3, 7) ) );
		
		
		
		CountTheNumberOfScoreCombinations_01_hasItOrNot.IS_DEBUG = false;
		
		out.println( CountTheNumberOfScoreCombinations_01_hasItOrNot.numCombinationsForFinalScore(12, Arrays.asList(2, 3, 7) ) );
		out.println( CountTheNumberOfScoreCombinations_02_firstTimeNewScore.numCombinationsForFinalScore(12, Arrays.asList(2, 3, 7) ) );
		
		out.println( _1701_CountTheNumberOfScoreCombinations.numCombinationsForFinalScore(100, Arrays.asList(2, 3, 7) ) );
		out.println( CountTheNumberOfScoreCombinations_01_hasItOrNot.numCombinationsForFinalScore(100, Arrays.asList(2, 3, 7) ) );
		out.println( CountTheNumberOfScoreCombinations_02_firstTimeNewScore.numCombinationsForFinalScore(100, Arrays.asList(2, 3, 7) ) );
		
	}

}


