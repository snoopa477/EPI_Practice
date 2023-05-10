package c17_DynamicProgramming.p01_CountTheNumberOfScoreCombinations;
import static java.lang.System.out;

import java.util.List;
public class CountTheNumberOfScoreCombinations_01_hasItOrNot {
	
	public static int numCombinationsForFinalScore(int finalScore, List<Integer> individualScores) {
		
		/* 
		 * row i: individualSores[k], k <=i are considered
		 * col j: the score, which is reached by combination of individual scores
		 * 
		 * given numCombToGetScore[i][j] = val
		 * that means
		 * consider individualSores[k], k <='i', there are 'val' number of combination of score ways to reach score 'j'
		 * 
		 * and our goal is 'j' = 'finalScore'.
		 * 
		 * max row index: the last index of individualScores
		 * max col index: the finalScore. 
		 */
		
		int[][] numCombToGetScore = new int[ individualScores.size() ][ finalScore + 1 ];
		
		/**
		 *  REASONING: 
		 *  given numCombToGetScore[i][j] = val
		 *  
		 *  how is it composed from previous results?
		 *  Previous results require ONE more new type of individual score to reach val
		 *  => row is i, since new type is considered, 
		 *  col is j - 'ONE more new type of individual score', so j + 'ONE more new type of individual score' = val
		 *  => numCombToGetScore[i][ j - 'ONE more new type of individual score' ]
		 *  => numCombToGetScore[i][ j - individualScores.get( i ) ]
		 *  
		 *  union 
		 *  previous results that DOESN'T require ONE more new type of individual score to reach val
		 *  => previous result that doesn't consider new type of individual score is already at val
		 *  => row is i -1, since new type is not considered, 
		 *  col is val, because it is already at 'val' without any additional score
		 *  => numCombToGetScore[i - 1][j]
		 *  
		 *  summary:
		 *  given numCombToGetScore[i][j] 
		 *  = numCombToGetScore[i][ j - individualScores.get( i )  ] + numCombToGetScore[i - 1][j]
		 *  
		 *  those two expression is already computed before reaching i,j 
		 */
		
		for( int i = 0; i < individualScores.size(); i++) {
			for( int j = 0; j <= finalScore; j++  ) {
				
				/*PURPOSE: assign numCombToGetScore[i][j]
				 * step 1 :  previous results that DOESN'T require ONE more new type of individual score to reach val
				 * numCombToGetScore[i - 1][j]
				 * 
				 * step 2: Previous results require ONE more new type of individual score to reach val
				 * numCombToGetScore[i][ j - individualScores.get( i ) ]
				 */
				
				//if j == 0, then no score is used to reach 0. That's the only way: 1
				if( j == 0 ) {
					numCombToGetScore[i][j] = 1;
					continue;
				}
				
				//step 1
				int oldScoreType_Idx = i - 1;
				boolean isOldScoreTypeExist  = oldScoreType_Idx > 0 ;
				
				int numComb_without_NewIndivialScore = isOldScoreTypeExist ? 
					numCombToGetScore[ oldScoreType_Idx ][j]
					// i must be 0, i -1 == -1, 0 ways to reach non-existent condition
					: 0;
					
					
				//step 2
				//IMAGINE at 'previousScore' it takes one more newScore to get 'j'
				int preivousScore = j - individualScores.get( i );
				boolean hasSuchPreviousScore = preivousScore >= 0;
				
				int	numComb_with_NewIndivialScore = hasSuchPreviousScore ?
					numCombToGetScore[ i ][ preivousScore ]
					// no such score exists => 0 ways to reach non-existent score
					: 0;
				
				//summary 
				numCombToGetScore[i][j] = numComb_without_NewIndivialScore + numComb_with_NewIndivialScore;
				
			}
		}
		
		
		//only need 
		return numCombToGetScore[ individualScores.size() -1 ][ finalScore ];
	}

}


