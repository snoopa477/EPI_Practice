package c06_Arrays.p14_ComputeARandomSubset;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_ComputeARandomSubset {

	public static void main(String[] args) {
		
		
		//ComputeARandomSubset.IS_DEBUG = true;
		
		Map<Integer, Integer> statsForEachElement = getStatsForEachElement(1000, 10, 5);
		
		
		for( Integer key : statsForEachElement.keySet() ) {
			out.println( key + ": " + statsForEachElement.get(key) );
		}
		
		
	}
	
	
	
	private static Map<Integer, Integer> getStatsForEachElement(int numberOfTrials, int totalNumberOfElements, int numberOfPickedElements){
		
		
		Map<Integer, Integer> valueToCount = new HashMap<Integer, Integer>();
		
		for(  int i = 0; i < numberOfTrials; i++) {
			
			List<Integer> randomSubset = ComputeARandomSubset.randomSubset(totalNumberOfElements, numberOfPickedElements);
			
			for( int j = 0; j < randomSubset.size(); j++ ) {
				int value = randomSubset.get(j);
				
				if( valueToCount.containsKey(value) == false ) {
					valueToCount.put(value, 1);
				}
				else {
					valueToCount.put(value, valueToCount.get(value) + 1 );
				}
				
			}
		}
		
		return valueToCount;
	}

}


