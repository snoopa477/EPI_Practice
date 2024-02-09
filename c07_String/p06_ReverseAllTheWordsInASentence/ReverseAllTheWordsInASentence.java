package c07_String.p06_ReverseAllTheWordsInASentence;
import static java.lang.System.out;
public class ReverseAllTheWordsInASentence {

	private static final int NOT_FOUND = -1;
	private static final char WHITESPACE = ' ';
	
	public static void reverseAllWords( char[] input ) {
		
		/**
		 * step 1. reverse whole sentence
		 * at this point, only white space match both position and char;
		 * in the viewpoint of tokens each word is correct at token position
		 * e.g. 
		 * "abc def ghi"
		 * 
		 * desired: 
		 * "ghi def abc"
		 * 
		 * reverse result:
		 * "ihg fed cba"
		 * 
		 * "igh" is at first token position: correct
		 * "fed" is at 2nd token position: correct
		 * "cba" is at 3rd token position: correct
		 * 
		 * 
		 * step 2. reverse each token, so each character match both position and char
		 * 
		 */
		
		
		//step 1. reverse whole sentence
		reverse( input, 0, input.length );
	
		
		//step 2. reverse each token
		/** 
		 * EXAMPLE
		 * given we have such string:
		 * "ghi def abc"
		 * our process unit of each iteration is each token, appended with a whitespace, except for the last token, which is not appended with any whitespace
		 * "ghi "
		 * "def "
		 * "abc"
		 */
		
		//step 2.1 process iteration is each token, appended with a whitespace, except for the last token
		int startIndexOfAWord = 0;
		int indexOfWhitespace;
		
		//DETAIL: to understand how iterations proceeds, see the last line in while loop
		//if true, we got whitespaceIndex. combined with startIndexOfAWord, we can process a token, appended with a white space
		//if false, that means we meet the last token, not appended with a whitespace
		while( ( indexOfWhitespace = findChar( input, startIndexOfAWord, WHITESPACE )) != NOT_FOUND ) {
			
			reverse(input, startIndexOfAWord, indexOfWhitespace);
			//now that every char in this token is correct at each position
			
			//prepare for the next iterations
			//REASONING what follows a whitespace is next startIndex of a word, this is definitive; however, next whitespace position is not definitive, which requires searching method
			
			startIndexOfAWord = indexOfWhitespace + 1;
		}
		
		
		//step 2.2 process the last token, which is not appended with any whitespace
		reverse(input, startIndexOfAWord, input.length);
		
	}
	
	
	
	private static void reverse( char[] input, int start_index, int end_index ) {
	
		
		//without this line, when method(input, x, x ) is called, the result is wrong
		if( start_index >= end_index ) {
			return;
		}
		
		int last_index = end_index - 1 ;
		
		int left_index = start_index;
		int mid_index = start_index + ( end_index - start_index ) / 2;
		
		while( left_index <= mid_index ) {
			int offsetFromStart = left_index - start_index;
			int right_index = last_index - offsetFromStart;
			
			swap( input, left_index, right_index );
			left_index++;
		}
		
	}
	
	
	
	private static void swap( char[] input, int indexA, int indexB ) {
		char temp = input[ indexA ];
		input[ indexA ] = input[ indexB ];
		input[ indexB ] = temp;
	}
	
	
	
	private static int findChar( char[] input, int startIndex, char targetChar) {
		
		for( int i = startIndex; i < input.length; i++ ) {
			if( input[i] == targetChar ) {
				return i;
			}
		}
		
		return NOT_FOUND;
	}
	
}


