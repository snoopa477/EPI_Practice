package c06_Arrays.p15_GenerateNonuniformRandomNumbers;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GenerateNonuniformRandomNumbers {
	
	public static int nonuniformRandomNumberGenerationC(List<Integer> values, List<Double> probabilities) {
		
		/* PURPOSE:
		 * given there are probabilities p0, p1, p2, p3
		 * step 1: 
		 * 	build a interval of probabilities [0, p0) [p0, p0+p1) [p0+p1, p0+p1+p2) [p0+p1+p2, 1)
		 * 	index 0: 0
		 * 	index 1: p0
		 * 	index 2: p0+p1
		 * 	index 3: p0+p1+p2
		 * 	index 4: 1 (p0+p1+p2+P3)
		 * 
		 * step 2:
		 * 	find where the random probability lies within the interval
		 * 
		 * step 3:
		 * 	convert from the position in interval to index of probabilities
		 * 
		 * step 4:
		 * 	get the value from the index of values, which is equal to the index of probabilities
		 * 
		 */
		
		//step 1
		List<Double> intervalOfProbs =  buildIntervalOfProbabilities( probabilities );
		
		
		//step 2 & 3
		double randomProbability = new Random().nextDouble();
		int index = findIndexInIntervals(intervalOfProbs, randomProbability);
		
		
		return 0;
	}
	
	
	
	private static List<Double> buildIntervalOfProbabilities( List<Double> probabilities ){
		
		List<Double> intervalOfProbs = new ArrayList<>();
		
		intervalOfProbs.add(0.0);
		double currentSum_Probabilities = 0; 
		
		for( int i = 0; i < probabilities.size(); i++ ) {
			
			currentSum_Probabilities += intervalOfProbs.get(lastIndex( intervalOfProbs )) + probabilities.get(i) ;
			
			intervalOfProbs.add( currentSum_Probabilities );
		}
		
		return intervalOfProbs;
	}
	
	
	
	private static int lastIndex( List<Double> list ) {
		return list.size() -1;
	}
	
	
	
	private static int findIndexInIntervals( List<Double> intervals, double key  ) {
		
		// extended concept of binarySearch
		int left = 0;
		int right = intervals.size() -1;
		
		while( left <= right ) {
			
			//mid works as pivot, comparing with key
			int mid = left + ( right - left ) / 2;
			double value = intervals.get(mid);
			
			if( value  < key ) {
				left = mid + 1;
			}
			else if( key < right ) {
				right = mid - 1;
			}
			else {
				//step 3
				return left; 
			}
			
		}
		
		//reasoning: cannot find it, so now 'right' is at left side of 'left'
		
		return right;
	}
	

}


