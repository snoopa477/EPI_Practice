package c06_Arrays.p14_ComputeARandomSubset;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class ComputeARandomSubset {
	
		public static boolean IS_DEBUG = false;
	
		//QUESTION: I don't know why static word has to be used
		private static class KeyValue{
			public Integer key;
			public Integer value;
			
			public KeyValue(Integer key, Integer value) {
				this.key = key;
				this.value = value;
			}
			
		}
	
		
		
		public static List<Integer> randomSubset(int totalNumberOfElements, int numberOfPickedElements) {
			
			
			/* Assumption: 
			 * given totalNumberOfElements = 9, numberOfPickedElements = 4
			 * 
			 * we start with this, each index equals to elementNo.
			 * index:     0  1  2  3  4  5  6  7  8
			 * elementNo: 0  1  2  3  4  5  6  7  8
			 * 
			 * and we don't need to use additional variable to record it
			 * 
			 * ------------------------------
			 * however, when index is not equals to elementNo., use map to record such change
			 * 
			 * index:     0  1 [2][3] 4  5  6 [7][8]
			 * elementNo: 0  1  7  8  4  5  6  3  2
			 * 
			 * map from index to elementNo: 2->7, 3->8, 7->3, 8->2 
			 * 
			 * ------------------------------
			 * if numberOfPickedElements is 4
			 * we will get: 0, 1, 7, 8
			 */
			
			
			//DETAIL: only changed element No would be recorded here
			Map<Integer, Integer> indexToChangedElementNo = new HashMap<>();
			Random randomGenerator = new Random();
			
			
			/*PURPOSE: 
			 * 1. for each iteration, collectorIndex would points to a random element No.
			 * 2. complete indexToChangedElementNo
			 */
			for( int collectorIndex = 0; collectorIndex < numberOfPickedElements; collectorIndex++ ) {
				

				//WRONG: logically wrong. this would cause random number only comes from [0, numberOfPickedElements) 
				//int randomIndex = randomGenerator.nextInt( numberOfPickedElements - collectorIndex ) + collectorIndex;
				
				//since index range [0, collectorIndex) already picked, our random range would be [collectorIndex, totalNumberOfElements)
				int randomIndex = randomGenerator.nextInt( totalNumberOfElements - collectorIndex ) + collectorIndex;
				
				int elementNoPointedBy_CollectorIndex = getValueFromIndexToChangedElementNo( indexToChangedElementNo, collectorIndex );
				KeyValue keyValueOf_CollectorIndex = new KeyValue(collectorIndex, elementNoPointedBy_CollectorIndex );
					
				
				int elementNoPointedBy_RandomIndex = getValueFromIndexToChangedElementNo( indexToChangedElementNo, randomIndex );
				KeyValue keyValueOf_RandomIndex = new KeyValue(randomIndex, elementNoPointedBy_RandomIndex );
				
				
				swap( indexToChangedElementNo, keyValueOf_CollectorIndex, keyValueOf_RandomIndex );
			}
			
			//REASONING: completion of indexToChangedElementNo
			
			List<Integer> randomSubset = new ArrayList<>();
			for( int i = 0; i < numberOfPickedElements; i++ ) {
				randomSubset.add( getValueFromIndexToChangedElementNo( indexToChangedElementNo, i ) );
			}
			
			return randomSubset;
		}
		
		

		private static void swap(Map<Integer, Integer> indexToChangedElementNo, KeyValue A, KeyValue B) {
			
			indexToChangedElementNo.put( A.key, B.value );
			indexToChangedElementNo.put( B.key, A.value );
		
		}
		
		
		
		private static Integer getValueFromIndexToChangedElementNo( Map<Integer, Integer> map, Integer key ) {
			return map.containsKey(key) ? 
					/* REASONING:
					 * Under the assumption: if the element No pointed by index is not touched, then it is not recorded in map object; 
					 * if that's the case, index == element No
					 * therefore, mapObject.get(index) == null means such case
					 */
					map.get( key ) : key;
		}

}


