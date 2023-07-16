package c18_GreedyAlgorithms.p05_FindTheMajorityElement;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Iterator;
public class FindTheMajorityElement {

	
	
	public static String majoritySearch(Iterator<String> sequence) {
		
		/**
		 * DETAIL:
		 * Collection extends Iterator
		 * 
		 * REASONING: 
		 * this method works under the premise that majority exists
		 * 
		 * advantage: don't have to sort. 
		 * since majority > 1/2n
		 * counts of all the other elements cancel out the counts of majority
		 * the remaining majority is still > 0
		 * 
		 * this holds true no matter how majority spreads among sequence( so sort is not needed)
		 * 
		 */
		
		Iterator<String> iter = sequence;
		
		//initial state
		String candidate = null;
		int candidateCount = 0;
		
		
		while( iter.hasNext() ) {
			
			String currentString = iter.next();
			
			if( currentString.equals( candidate ) ) {
				candidateCount++;
			}
			else if( candidateCount > 0 ) {
				candidateCount--;
			}
			//candidateCount == 0
			else {
				candidate = currentString;
				candidateCount = 1;
			}
		}
		
		
		return candidate;
	}
	
	
	
	public static void main(String[] args) {
		
		out.println( majoritySearch( Arrays.asList( "b","a","c","a","a","b","a","a","c","a" ).iterator() ) );
		
	}

}


