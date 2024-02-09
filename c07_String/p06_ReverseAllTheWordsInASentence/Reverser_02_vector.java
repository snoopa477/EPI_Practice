package c07_String.p06_ReverseAllTheWordsInASentence;
import static java.lang.System.out;

public class Reverser_02_vector implements Reversable{
	
	@Override
	//endIndex: exclusive
	public void reverse(char[] input, int startIndex, int endIndex) {
		
		
		/*WRONG if you miss this
		 * the following can be executed only when  startIndex <= lastIndex
		 * ; that is startIndex < lastIndex + 1
		 * 
		 * Otherwise, if we call f("01234", 3, 3) and executes successfully
		 * startIndex = 3
		 * lastIndex = 2
		 * 
		 * midIndex = 3
		 * 
		 * since startIndex <= midIndex, will still do swap:
		 * "01324", which is wrong
		 */
		
		if( startIndex >= endIndex ) {
			return ;
		}
		
		int lastIndex = endIndex - 1;
		//we only need to traverse left half, finding another right half, making them swap to each other
		
		//WRONG: typo, or I read it wrong
		//int swapInterval = ( endIndex - lastIndex ) / 2;
		int swapInterval = ( lastIndex - startIndex ) / 2;
		for( int vector = 0; vector <= swapInterval; vector++  ) {
			
			swap( input, startIndex + vector, lastIndex - vector );
		}
		
	}
	
	
	
	private void swap( char[] input, int indexA, int indexB ) {
		char temp = input[ indexA ];
		input[ indexA ] = input[ indexB ];
		input[ indexB ] = temp;
	}
}


