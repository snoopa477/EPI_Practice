package c06_Arrays.p13_ComputeARandomPermutation;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_ComputeARandomPermutation {

	public static void main(String[] args) {
		
		Map<Integer, Integer> stats = getStatsForEachElement(1000, 10);
		
		for( Integer key : stats.keySet() ) {
			out.println( key + ": " + stats.get(key) );
		}
		
	}

	
	
	private static Map<Integer, Integer> getStatsForEachElement(int numberOfTrials, int totalNumberOfElements){
		
		
		Map<Integer, Integer> valueToCount = new HashMap<Integer, Integer>();
		
		for(  int i = 0; i < numberOfTrials; i++) {
			
			List<Integer> randomPermutation = ComputeARandomPermutation.computeRandomPermutation(totalNumberOfElements);
			
			for( int j = 0; j < randomPermutation.size()/2; j++ ) {
				int value = randomPermutation.get(j);
				
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


