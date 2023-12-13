package c06_Arrays.p11_SampleOfflineData;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_SampleOfflineData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		List<Integer> testee = new ArrayList<>( Arrays.asList(0,1,2,3,4,5,6,7,8,9) );
		
		Map<Integer, Integer> statsForEachElement =  getStatsForEachElement(testee, 1000, 5);
		
		
		for( Integer key : statsForEachElement.keySet() ) {
			out.println( key + ": " + statsForEachElement.get(key) );
		}
		
	}
	
	
	
	private static Map<Integer, Integer> getStatsForEachElement(List<Integer> list, int numberOfTrials, int sampleSize){
		
		
		Map<Integer, Integer> valueToCountInSample = new HashMap<Integer, Integer>();
		
		for(  int i = 0; i < numberOfTrials; i++) {
			List<Integer> testee = new ArrayList<>(list);
			SampleOfflineData.randomsampling(sampleSize, testee);
			
			for( int j = 0; j < sampleSize; j++ ) {
				int value = testee.get(j);
				
				if( valueToCountInSample.containsKey(value) == false ) {
					valueToCountInSample.put(value, 1);
				}
				else {
					valueToCountInSample.put(value, valueToCountInSample.get(value) + 1 );
				}
				
			}
		}
		
		return valueToCountInSample;
	}

}


