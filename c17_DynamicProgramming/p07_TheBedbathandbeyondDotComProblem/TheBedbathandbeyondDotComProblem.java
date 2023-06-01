package c17_DynamicProgramming.p07_TheBedbathandbeyondDotComProblem;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
public class TheBedbathandbeyondDotComProblem {
	
	public static int EXCLUSIVE_OFFSET = 1;
	public static int NEXT_OFFSET = 1;
	public static int TO_SIZE_OFFSET = 1;
	public static int NONVISITED = -1;
	
	public static List<String> decomposelntoDictionaryWords(String domain, Set<String> dictionary) {
		
		/**
		 * PURPOSE: 
		 * To solve domain at index domain.length-1
		 * we need to solve domain at index 0 first
		 * and then 1, 2, 3, .... domain.length -2
		 * 
		 * since we gonna use these sub results to construct our goal: index at domain.length-1
		 */
		
		
		/**
		 * substrLastWordLength[i] = value
		 * last word length 'value' at substring( 'domain', 0, 'i' + EXCLUSIVE_OFFSET ); 
		 * in other words, the word ends at index 'i'
		 *
		 * REASONING: 
		 * if substrLastWordLength[i] > 0 and value is not i + 1 ( the whole substring )
		 * then there exist j, ( j < i ) that is the left neighbor of current word
		 * and there exist k ( k < i)  that is the left neighbor of  word of j ... on and on till index is 0
		 *
		  *THINK_FURTHER: wat we don't record is the word, but length, since we can infer the word 
		  *by referencing 'domain' using substring and 'length' 
		  */
		int[] substrLastWordLength = new int[ domain.length() ];
		Arrays.fill( substrLastWordLength , NONVISITED);
		
		
		/*
		 * To solve domain at index domain.length-1
		 * we need to solve domain at index 0 first
		 * and then 1, 2, 3, .... domain.length -2
		 */
		for( int i = 0; i < domain.length(); i++ ) {
			
			/**
			 * PURPOSE: 
			 * 	step 1: try whole string, without help from previous result
			 * 	step 2: try sub string, with help from previous result 
			 */
			
			//step 1: try whole string, without help from previous result
			if(  dictionary.contains( domain.substring(0, i + EXCLUSIVE_OFFSET) ) ) {
				//found, record the length; in other words, value > 0 means we found the matching
				substrLastWordLength[ i ] = i + TO_SIZE_OFFSET;
			}
			//step 2: try sub string, with help from previous result 
			else {
				
				//DETAIL: name suggests its behavior, not j, which doesn't match its behavior
				//REASONING: try match the longest word, so we start with the shortest previous result: 0
				for( int subI = 0; subI < i; subI++ ) {
					
						//previous result exists
					if( substrLastWordLength[ subI ] != NONVISITED 
						//current word that is right after the previous result
						&& dictionary.contains( domain.substring(subI + NEXT_OFFSET, i + EXCLUSIVE_OFFSET) ) ) {
						
						// i - ( subI + NEXT_OFFSET ) + TO_SIZE_OFFSET = i - subI
						substrLastWordLength[ i ] = i - subI;
						//stop further trying. we find the longest match
						break;
					}
				}
				
			}
		}
		
		
		//PURPOSE: to get result, use substrLastWordLength to back trace
		//reaching here meaning has result: all words makes up a whole sentence
		List<String> result = new ArrayList<>();
		if( substrLastWordLength[ domain.length() -1 ] == NONVISITED ) {
			return result;
		}
		
		//DETAIL: the word ends at index 'i' + EXCLUSIVE_OFFSET , so the start of word start with 'i' + EXCLUSIVE_OFFSET - A['i']
		int lastWordLengthIndex = domain.length() -1;
		while( lastWordLengthIndex >= 0 ) {
			int substr_LastIndex = lastWordLengthIndex + EXCLUSIVE_OFFSET;
			int substr_StartIndex = substr_LastIndex - substrLastWordLength[ lastWordLengthIndex ];
			result.add( domain.substring(substr_StartIndex, substr_LastIndex ) );
			
			//since words are neighbors, the start index with current word is the last index (exclusive) of previous word
			lastWordLengthIndex -= substrLastWordLength[ lastWordLengthIndex ]; 
		}
		
		Collections.reverse( result );
		
		
		return result;
	}

}


