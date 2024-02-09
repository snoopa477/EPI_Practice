package c07_String.p06_ReverseAllTheWordsInASentence;
import static java.lang.System.out;
public class Reverser_03_cross implements Reversable{

	@Override
	//endIndex: exclusive
	public void reverse(char[] input, int startIndex, int endIndex) {
		
		int lastIndex = endIndex - 1;
		//we only need to traverse left half, finding another right half, making them swap to each other
		
		int left = startIndex;
		int right = lastIndex;
		
		while( left <= right ) {
			swap( input, left, right );
			left++;
			right--;
		}
	}
	
	
	
	private void swap( char[] input, int indexA, int indexB ) {
		char temp = input[ indexA ];
		input[ indexA ] = input[ indexB ];
		input[ indexB ] = temp;
	}
	
}


