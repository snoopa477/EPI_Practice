package c06_Arrays.p01_TheDutchNationalFlagProblem;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
public class TheDutchNationalFlagProblem_02_SeekAllTheWay {

	public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
		
		//WRONG if use A.get(pivotIndex) instead, because it is fluctuating due to swapping
		Color pivotColor = A.get(pivotIndex);
		
		for( int collect_idx = 0, seek_idx = 0; seek_idx < A.size(); seek_idx++ ) {
			if( A.get(seek_idx).ordinal() < pivotColor.ordinal() ) {
				Collections.swap(A, collect_idx, seek_idx);
				collect_idx++;
			}
		}
		
		
		for( int collect_idx = A.size() - 1, seek_idx = A.size() - 1; seek_idx >= 0; seek_idx-- ) {
			if( A.get(seek_idx).ordinal() > pivotColor.ordinal() ) {
				Collections.swap(A, collect_idx, seek_idx);
				collect_idx--;
			}
		}
		
	}
	
}


