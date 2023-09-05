package c06_Arrays.p01_TheDutchNationalFlagProblem;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;


public class TheDutchNationalFlagProblem_01_Reset {

	public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
		
		//WRONG if use A.get(pivotIndex) instead, because it is fluctuating due to swapping
		Color pivotColor = A.get(pivotIndex);
		
		//PURPOSE: each iteration, find the target, which is smaller than pivot 
		for( int collect_idx = 0; collect_idx < A.size(); collect_idx++ ) {
			for( int seek_index = collect_idx; seek_index < A.size(); seek_index++ ) {
				if( A.get(seek_index).ordinal() < pivotColor.ordinal() ) {
					Collections.swap(A, collect_idx, seek_index);
					continue;
				}
			}
		}
		
		
		//PURPOSE: do it in the reverse direction
		//each iteration, find the target, which is greater than pivot 
		for( int collect_idx = A.size() -1 ; collect_idx >= 0; collect_idx-- ) {
			for( int seek_index = collect_idx; seek_index >= 0; seek_index-- ) {
				if( A.get(seek_index).ordinal() > pivotColor.ordinal() ) {
					Collections.swap(A, collect_idx, seek_index);
					continue;
				}
			}
		}
		
		//REASONING: reaching here, elements that are equal to pivot kept in the middle 
	}
	
}


