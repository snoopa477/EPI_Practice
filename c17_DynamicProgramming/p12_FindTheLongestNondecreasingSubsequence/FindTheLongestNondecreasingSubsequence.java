package c17_DynamicProgramming.p12_FindTheLongestNondecreasingSubsequence;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class FindTheLongestNondecreasingSubsequence {

	
	public static int longestNondecreasingSubsequenceLength( List<Integer> A ) {
		
		//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
		//WRONG: init value is only init capacity
		//List<Integer> maxLength = new ArrayList<>( A.size() );
		List<Integer> maxLength = new ArrayList<>( Arrays.asList( new Integer[A.size()] ) );
		
		//Initial value: before consider others. each element can reach itself, which is 1 way
		Collections.fill(maxLength, 1);
		
		
		/*REASONING: we start from i = 0 since our ultimate goal is i = A.size() -1, 
		 * which requires to consider EVERY i ranging from 0 to A.size() at the beginning, which we don't have. 
		 * So compute them first
		 * by the time we compute i = A.size() -1, we already have i = 0 ~ A.size() -1 at hand 
		 * */ 
		//DETAIL: i = 0 depends on no one. so we don't compute
		//PURPOSE: assign maxLength from 0 to A.size() -1 
		for( int i = 1; i < A.size(); i++ ) {
			longestNondecreasingSubsequenceLength( A, i, maxLength );
		}
		
		//WRONG: last index doesn't guarantee it has greatest value
		//return maxLength.get( A.size() -1 );
		
		//the max for each i among all maxes
		return Collections.max( maxLength );
	}
	
	
	
	//assign value to A.get(i)
	private static void longestNondecreasingSubsequenceLength( List<Integer> A, int i, List<Integer> maxLength ) {
		
		/* PURPOSE:
		 * given element i
		 * considering all elements that is left from it, which is j, ranging from 0 to i -1
		 * each element j, may or may not smaller than element i
		 * if element j is smaller than element i, see if the maxLength( j )+ 1 is max for current situation
		 */
		//THINK_FURTHER: we don't think of right side of i, since they're irrelevant
		for( int j = 0; j < i; j++ ) {
			
			if( isNonDereasing( A.get(j), A.get( i )) ) {
				
				//DETAIL: comparing value and setting value are different array
				// from index j( which is smaller than i ) takes 1 step to index i
				int currentMax = Math.max( maxLength.get(j) + 1 
						, maxLength.get(i) );
				maxLength.set( i , currentMax);
			}
		}
		
	}
	
	
	
	private static boolean isNonDereasing( int a, int b ) {
		return a <= b;
	}
	
}



