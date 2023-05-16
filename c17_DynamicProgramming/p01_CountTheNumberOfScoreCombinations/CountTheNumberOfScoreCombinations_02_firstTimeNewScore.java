package c17_DynamicProgramming.p01_CountTheNumberOfScoreCombinations;
import static java.lang.System.out;

import java.util.List;
public class CountTheNumberOfScoreCombinations_02_firstTimeNewScore {
	
public static int numCombinationsForFinalScore(int finalScore, List<Integer> individualScores) {
		
		//REASONING compared to way01, that is not good as way01, since it requires 3 loop
		
		int[][] numCombToGetScore = new int[ individualScores.size() ][ finalScore + 1 ];
		
		
		for( int i = 0; i < individualScores.size(); i++) {
			for( int j = 0; j <= finalScore; j++  ) {
				
				//since only one type of score, no matter what perm looks like they can only one way, if divisible. 1 
				if( i == 0 ) {
					int firstScore = individualScores.get( 0 );
					if( j % firstScore == 0 ) {
						numCombToGetScore[i][j] = 1;
					}
				}
				// i>= 1
				else {
					/*
					 * given  numCombToGetScore[ i ][ j ] = val, which adopt new score index i
					 * prevScoreIdx = i -1
					 * newScore = individualScores.get( i );
					 * 
					 * it is equal to accumulation of  numCombToGetScore[ i -1 ][ ? ], which first take new score index i into consideration
					 * that is, it's equal to 
					 * numCombToGetScore[ prevScoreIdx ][ j - newScore ] // at ( val- newScore ) so it takes one newScore to get 'val'
					 * + numCombToGetScore[ prevScoreIdx ][ j - newScore * 2 ] // at ( val- newScore * 2 ) so it takes two newScores to get 'val'
					 * + numCombToGetScore[ prevScoreIdx ][ j - newScore * 3 ] // at ( val- newScore * 3 ) so it takes three newScores to get 'val'
					 * ...
					 * + numCombToGetScore[ prevScoreIdx ][ j - newScore * k ] // at ( val- newScore * k ) so it takes k newScores to get 'val'
					 * , where k+ 1 makes ( j - newScore * (k+1))  FIRST time < 0; that is  ( val- newScore * k ) is the closest to 0
					 * 
					 */
					int prevScoreIdx = i -1;
					
					int newScore = individualScores.get( i );
					//IMAGINE: it's easier for me to understand by seeing the whole picture, instead of reading for loop
					for( int k = j ; k >= 0; k-= newScore) {
						numCombToGetScore[i][j] += numCombToGetScore[ prevScoreIdx ][ k ];
					}
				}
			}
		}
		
		//only need 
		return numCombToGetScore[ individualScores.size() -1 ][ finalScore ];
	}

}


