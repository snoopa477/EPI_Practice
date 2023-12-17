package c06_Arrays.p15_GenerateNonuniformRandomNumbers;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_GenerateNonuniformRandomNumbers {

	
	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(0,1,2,3);
		List<Double> probabilities = Arrays.asList(9.0/18, 6.0/18, 2.0/18, 1.0/18);
		
		
		GenerateNonuniformRandomNumbers.IS_DEBUG = false;
		Map<Integer, Integer> statsForEachElement = getStatsForEachElement(1000, values, probabilities);
		
		for( Integer key : statsForEachElement.keySet() ) {
			out.println( key + ": " + statsForEachElement.get(key) );
		}
		
	}
	
	
	
	private static Map<Integer, Integer> getStatsForEachElement(int numberOfTrials, List<Integer> values, List<Double> probabilities){
		
		
		Map<Integer, Integer> valueToCount = new HashMap<Integer, Integer>();
		
		for(  int i = 0; i < numberOfTrials; i++) {
			
				//int nonuniformRandomNumber = GenerateNonuniformRandomNumbers.nonuniformRandomNumberGeneration( values, probabilities);
				int number_fromNonUniformRandomness = GenerateNonuniformRandomNumbers.nonuniformRandomNumberGeneration( values, probabilities);
				
				if( valueToCount.containsKey(number_fromNonUniformRandomness) == false ) {
					valueToCount.put(number_fromNonUniformRandomness, 1);
				}
				else {
					valueToCount.put(number_fromNonUniformRandomness, valueToCount.get(number_fromNonUniformRandomness) + 1 );
				}
		}
		
		return valueToCount;
	}
	
}


