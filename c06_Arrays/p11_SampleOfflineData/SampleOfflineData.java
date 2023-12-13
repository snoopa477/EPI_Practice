package c06_Arrays.p11_SampleOfflineData;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
import java.util.Random;
public class SampleOfflineData {
	
	//first k elements would be sampled
	public static void randomsampling(int k, List<Integer> A) {
		
		/**
		 *
		 *  0 1 2 3 4 5 6 7 8 9
		 * [       ]p
		 *
		 * given collector index is at 4
		 * the index that would search among random candidates range would be [4, 9];
		 * in other words, it's [0, size() -1 - index of p] + (index of p); equivalently, [0, size() - index of p) + (index of p) 
		 * 
		 * 
		 */
		Random rand = new Random();
		
		for( int randomCollectorIndex = 0; randomCollectorIndex < k;  randomCollectorIndex++ ) {
			
			//PURPOSE: should be right side of randomCollectorIndex
			int randomIndex = rand.nextInt( A.size() - randomCollectorIndex ) + randomCollectorIndex;
			
			//PURPOSE: get that randomValue to collector index, so it is 'collected'
			Collections.swap(A, randomCollectorIndex, randomIndex);
			
		}
		
	}

}


