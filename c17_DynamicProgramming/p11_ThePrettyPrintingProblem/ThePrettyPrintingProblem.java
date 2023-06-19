package c17_DynamicProgramming.p11_ThePrettyPrintingProblem;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class ThePrettyPrintingProblem {
	
	public static boolean IS_DEBUG = false;
	
	private static int SPACE_SIZE = 1;
	
	public static int minimumMessiness(List<String> words, int lineLength) {
		
		/*
		 * minimumMessiness[ i ] = k
		 * means minimum messiness k, from words.get( 0 ) to words.get( i )
		 */
		int[] minimumMessiness = new int[ words.size() ];
		//DETAIL: since we are going to prepare for min, dummy value is infinity.
		Arrays.fill(minimumMessiness, Integer.MAX_VALUE );
		
		
		for( int i = 0; i < words.size(); i++ ) {
			minimumMessiness( words, lineLength, minimumMessiness, i );
		}
		
		return minimumMessiness[ words.size() -1 ];
	}
	
	
	
	private static void minimumMessiness( List<String> words, int lineLength, int[] minimumMessiness, int i ) {
		
		
		//Base case: since there exists no previous text. There's only one possible form. Nothing to compare, the only one is the minimum
		if( i == 0 ) {
			
			int wordSize = words.get(i).length();
			int spaceLeft = lineLength - wordSize;
			minimumMessiness[ i ] = getMessiness( spaceLeft ) ;
			
			if( IS_DEBUG ) out.println(" i " + i + " value " + minimumMessiness[ i ] );
			
		}
		else {
			
			int currentWordSize = words.get( i ).length();
			/*PURPOSE: allocate a new line, with current word at beginning state. this value decreases as we introduce words i-1, i-2 to this line. 
			 * Under the premise that the space > 0
			 */
			
			int newLineRightSpace = lineLength - currentWordSize;
			
			//int previousIndex = i - 1;
			int oldLinesMessinessI = i - 1;
			//REASONING: therefore, append currentMessiness with new line to previousMessiness with previous lines( words from 0 to i -1 ) 
			//DETAIL: store value to minimumMessiness[ i ] temporarily, since we don't know if it is really min until all candidates are considered 
			minimumMessiness[ i ] = minimumMessiness[ oldLinesMessinessI ] + getMessiness( newLineRightSpace );
			
			
			//DETAIL: introduce words.get(previousI) to currentnewLine, use cahced result minimumMessiness[ beforePreviousI ]
			//PURPOSE: gradually introduce words to new line. from words i-1, i-2, i-3... under the premise that the space > 0
			//for( int smallerI = i -1; smallerI >= 0; smallerI-- ) {
			//for( int previousI = i - 1; previousI >= 0; previousI-- ) {
			for( int introducedI = i - 1; introducedI >= 0; introducedI-- ) {
				
				//introduce words[ previousI ] to currentLine
				int introducedWordSize = words.get( introducedI ).length();
				//WRONG: forget to consider space size
				//newLineRightSpace -= ( introducedWordSize );
				newLineRightSpace -= ( SPACE_SIZE + introducedWordSize );
				
				//introducing new word leads to overflow, meaning further introducing other words leads to same result. quit processing.
				if( newLineRightSpace < 0 ) {
					break;
				}
				
				//int beforePreviousI = introducedI -1 ;
				oldLinesMessinessI = introducedI -1 ;
				//REASONING: minimumMessiness[ -1 ] doens't exist, return 0. Also, this means no such line exists
				int oldLinesMessiness = oldLinesMessinessI  < 0?  0 : minimumMessiness[ oldLinesMessinessI ];
				int currentMin = oldLinesMessiness + getMessiness( newLineRightSpace );
				
				minimumMessiness[ i ] = Math.min( currentMin, minimumMessiness[ i ]);
				
				if( IS_DEBUG ) out.println(" i " + i + " value " + minimumMessiness[ i ] );
				//REASONING: only if finishing all iterating, minimumMessiness[ i ]  has its final value, which is min
			}
		}
		
	}
	
	
	
	private static int getMessiness( int a ) {
		return a * a;
	}

}


