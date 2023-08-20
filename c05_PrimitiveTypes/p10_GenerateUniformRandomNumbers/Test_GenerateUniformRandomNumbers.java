package c05_PrimitiveTypes.p10_GenerateUniformRandomNumbers;
import static java.lang.System.out;

import java.util.Map;
import java.util.TreeMap;
public class Test_GenerateUniformRandomNumbers {

	private static int TRY_COUNT = 1000;
	
	public static void main(String[] args) {
		
//		GenerateUniformRandomNumbers.IS_DEBUG = true;
		
		{
			Map<Integer, Integer>  valToCounter = new TreeMap<Integer, Integer>();
			
			int lowerBound = 37;
			int upperBound = 49;
			
			for( int i = 0; i < TRY_COUNT; i++) {
				int val = GenerateUniformRandomNumbers.uniformRandom(lowerBound, upperBound);
				
				if ( valToCounter.containsKey(val) ) {
					valToCounter.put(val, valToCounter.get(val) + 1 );
					
				}
				else {
					valToCounter.put(val, 1 );
				}
			}
			
			for( int key : valToCounter.keySet() ) {
				out.println( key + " " + valToCounter.get(key));
			}
			
		
		}
		
	}

}


