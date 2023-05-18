package c17_DynamicProgramming.p02_ComputeTheLevenshteinDistance;
import static java.lang.System.out;

import java.util.Arrays;
public class ComputeTheLevenshteinDistance {
	
	public static boolean IS_DEBUG = false;
	
	private static int NONVISITED = -1;
	
	public static int levenshteinDistance(String A, String B) {
		
		/* notation:
		 * str[ startIndx, endIndx Inclusive ]
		 * 
		 * given
		 * L( A[0, a-1], B[0, b-1]) = x
		 * then we denote 
		 * levenshteinDistance[ A.length() -1 ][ B.length() -1 ] = x
		 * 
		 * L( A[0, i], B[0, j]) = x
		 * levenshteinDistance[ i ][ j ] = x
		 * 
		 * row i is A's index, which is A.substring(0, row + 1)
		 * row j is B's index, which is B.substring(0, col + 1)
		 * value is levenshteinDistance
		 */
		
		int LDistance[][] = new int[A.length()][B.length()];
		
		/* DETAIL:
		 * since levenshteinDistance >= 0
		 * we initialize it as -1 to denote the values has not yet computed( visited)
		 */
		for( int row[] : LDistance ) {
			Arrays.fill(row, NONVISITED);
		}
	
		
		return getLevenshteinDistance( LDistance, A, A.length() -1, B, B.length() -1  );
	}

	
	
	private static int getLevenshteinDistance(int[][] LDistance, String A, int A_lastInclusiveIdx, String B, int B_lastInclusiveIdx ) {
		
		
		/**
		 * BASE CASE : determine the value without calling other function
		 */
		
		/*which is -1, a empty string
		 * 
		 *            --A 
		 * b b b b y  --B
		 * 
		 * A requires B_lastInclusiveIdx + 1 inserts
		 */
		if( A_lastInclusiveIdx < 0 ) {
			//convert index to count
			return B_lastInclusiveIdx + 1;
		}
		/*which is -1, a empty string
		 * 
		 * a a a a x  --A 
		 *            --B
		 * 
		 * A requires A_lastInclusiveIdx + 1 deletes
		 */
		else if( B_lastInclusiveIdx < 0 ) {
			return A_lastInclusiveIdx + 1;
		}
		
		//if non visited, then compute, storing to cache; otherwise get the cache
		//if( LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx ] != NONVISITED ) {
		if( LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx ] == NONVISITED ) {
			
			if( isLastCharTheSame( A, A_lastInclusiveIdx, B, B_lastInclusiveIdx ) ) {
				
				/**
				 * example: 
				 * a a a a x  --A 
				 * b b b b x  --B
				 * 
				 * -----------------
				 * a a a a)x  --A[0, A_lastInclusiveIdx -1] + x
				 * b b b b)x  --B[0, B_lastInclusiveIdx -1] + x
				 * 
				 * last character x to x requires 0 operations
				 */
				//LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx ] = LDistance[ A_lastInclusiveIdx -1 ][ B_lastInclusiveIdx -1 ] + 0 /*x to x: NONE*/;
				LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx ] = getLevenshteinDistance( LDistance, A, A_lastInclusiveIdx -1, B, B_lastInclusiveIdx -1 ) + 0 /*x to x: NONE*/;
				
			}
			//answer lies within three of them\
			/**
			 * THINK_FURTHER:
			 * three states all can reach to current state by one operation: 
			 * A[0, A_lastInclusiveIdx], B[0, B_lastInclusiveIdx]; however, we only pick the minimum one among them
			 */
			else {
				
				/**
				 * example: 
				 * a a a a x  --A 
				 * b b b b y  --B
				 * 
				 * -----------------
				 * a a a a x)NULL  --A + NULL
				 * b b b b)y       --B[0, B_lastInclusiveIdx -1 ] + y
				 * 
				 * last character NULL to y require one insertion
				 */
				//int insertToLast = LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx -1 ] + 1 /*NULL to y: insert*/;
				int insertToLast = getLevenshteinDistance( LDistance, A, A_lastInclusiveIdx, B, B_lastInclusiveIdx -1 ) + 1 /*NULL to y: insert*/;
				
				/**
				 * example: 
				 * a a a a x  --A 
				 * b b b b y  --B
				 * 
				 * -----------------
				 * a a a a)x          --A[0, A_lastInclusiveIdx -1 ] + x
				 * b b b b y)NULL     --B + NULL
				 * 
				 * last character x to NULL require one deletion
				 */
				//int deleteToLast = LDistance[ A_lastInclusiveIdx -1 ][ B_lastInclusiveIdx ] + 1 /*x to NULL: deletion*/;
				int deleteToLast = getLevenshteinDistance( LDistance, A, A_lastInclusiveIdx -1 , B, B_lastInclusiveIdx ) + 1 /*x to NULL: deletion*/;
				
				/**
				 * example: 
				 * a a a a x  --A 
				 * b b b b y  --B
				 * 
				 * -----------------
				 * a a a a)x          --A[0, A_lastInclusiveIdx -1 ] + x
				 * b b b b)y          --B[0, B_lastInclusiveIdx -1 ] + y
				 * 
				 * last character x to y needs one replace
				 */
				//int replaceLast = LDistance[ A_lastInclusiveIdx -1 ][ B_lastInclusiveIdx -1 ] + 1 /*x to y: replace*/;
				int replaceLast = getLevenshteinDistance( LDistance, A, A_lastInclusiveIdx -1 , B, B_lastInclusiveIdx - 1 ) + 1 /*x to y: replace*/;
				
				int minValue = Math.min(insertToLast, Math.min( deleteToLast, replaceLast ));
				LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx ] = minValue;
			}
			
		}
		
		
		
		//reaching here meaning the value is either computed or just get from previous result
		return LDistance[ A_lastInclusiveIdx ][ B_lastInclusiveIdx ];
	}
	
	
	
	private static boolean isLastCharTheSame( String A, int A_lastInclusiveIdx, String B, int B_lastInclusiveIdx ) {
		return A.charAt(A_lastInclusiveIdx) == B.charAt(B_lastInclusiveIdx);
	}
	
}


