package c06_Arrays.p12_SampleOnlineData;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SampleOnlineData {
	
	public static boolean IS_DEBUG = false;
	
	public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int sampleSize) {
		
		List<Integer> samples = new ArrayList<>();
		
		int i = 0;
		while( sequence.hasNext() && i < sampleSize ) {
			samples.add( sequence.next() );
			//wrong if miss this line
			i++;
		}
		
		
		//REASONING: if sequence size is over sample size, it will enter while loop
		
		//DETAIL: this is for even distribution
		Random randomGenerator = new Random();
		int numberOfVisitedElements = sampleSize;
		while( sequence.hasNext() ) {
			
			//PURPOSE: make even distributed
			/* REASONING: 
			 * consider a6
			 * 
			 * [a1 a2 a3 a4]a5 a6| ... upcoming elements
			 * the probability of a6 being picked (into sample set)should be 4/6
			 * 
			 * - - - - -
			 * [a1 a2 a3 a4]a5 a6 a7| ... upcoming elements
			 * the probability of a6 staying in sample set should be (4/6) * (6/7) = 4/7
			 * 	4/6: probability of a6 being picked into sample set
			 * 
			 * 	now that a6 stays in sample set
			 * 	6/7: probability of a7 replacing any position instead of a6; in other words, probability of a6 keeping stayed in sample set
			 * 
			 * - - - - -
			 * [a1 a2 a3 a4]a5 a6 a7 a8| ... upcoming elements
			 * the probability of a6 staying in sample set should be (4/6) * (6/7) * (7/8)= 4/8
			 * 	4/6: probability of a6 being picked into sample set
			 * 	
			 * 	now that a6 stays in sample set. status: 7 elements
			 * 	6/7: probability of a7 replacing any position instead of a6
			 * 
			 * 	now that a6 stays in sample set. status: 8 elements
			 * 	7/8: probability of a8 replacing any position instead of a6
			 */
			
			//current value sequence.next() is at position numberOfVisitedElements -1
			int currentValue = sequence.next();
			//correction
			numberOfVisitedElements++;
			
			//DETAIL: index [0, numberOfVisitedElements), mapping to first index from last index of visited elements
			int randomPickedIndex = randomGenerator.nextInt(numberOfVisitedElements);
			

			
			//REASONING: probability of doing so: sampleSize / numberOfVisitedElements
			//get picked into sample set, replacing the old ones( we don't care about old one so don't bothing swapping out for later use)
			if( randomPickedIndex < sampleSize ) {
				samples.set(randomPickedIndex, currentValue);

			}
			//else, replace the position w/ that element; however it's meaningless in our context, so we don't do it
			
			//WRONG: wrong logically
			//numberOfVisitedElements++;
		}
		
		
		return samples;
	}
	

}


