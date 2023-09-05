package c06_Arrays.p01_TheDutchNationalFlagProblem;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
public class TheDutchNationalFlagProblem_03_LeftAndRight {

	public static boolean IS_DEBUG = false;
	
	public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
		
		Color pivotColor = A.get(pivotIndex);
		
		int collect_left_idx = 0;
		int collect_right_idx = A.size() -1;
		
		int seek_collect_pivot_idx = 0;
		//WRONG! seek_collect_pivot_idx moves only when element is equal to pivot. cannot move seek_collect_pivot_idx for no specific reason
		//for( int seek_collect_pivot_idx = 0; seek_collect_pivot_idx < A.size(); seek_collect_pivot_idx++  ) {
		
		//while( seek_collect_pivot_idx < A.size()  ) {
		//while( seek_collect_pivot_idx < collect_right_idx  ) {
		while( seek_collect_pivot_idx <= collect_right_idx  ) {
		
			//WRONG! A.get(pivotIndex) is fluctuating, use pivotColor instead
			//if( A.get(seek_collect_pivot_idx).ordinal() < A.get(pivotIndex).ordinal() ) {
			if( A.get(seek_collect_pivot_idx).ordinal() < pivotColor.ordinal() ) {
				Collections.swap(A, seek_collect_pivot_idx, collect_left_idx);
				collect_left_idx++;
				//DETAIL: tricky, don't let seek_collect_pivot_idx fall behind
				//seek_collect_pivot_idx++;
				//if( seek_collect_pivot_idx < collect_left_idx ) {
					seek_collect_pivot_idx++;
				//}
					
				if( IS_DEBUG ) {
					out.println(" < case. " + collect_left_idx + ", " + seek_collect_pivot_idx + ", " + collect_right_idx);
				}
				
			}
			else if( A.get(seek_collect_pivot_idx).ordinal() > pivotColor.ordinal() ) {
				Collections.swap(A, seek_collect_pivot_idx, collect_right_idx);
				collect_right_idx--;
				if( IS_DEBUG ) {
					out.println(" > case. " + collect_left_idx + ", " + seek_collect_pivot_idx + ", " + collect_right_idx);
				}
			}
			//WRONG!
			/*else if( A.get(seek_collect_pivot_idx).ordinal() == A.get(pivotIndex).ordinal() )
			 * do nothing, let seek_collect_pivot_idx++, meaning collecting elements that is equal to pivot
			 */
			else {
				seek_collect_pivot_idx++;
				
				if( IS_DEBUG ) {
					out.println(" = case. " + collect_left_idx + ", " + seek_collect_pivot_idx + ", " + collect_right_idx);
				}
			}
			
		}
		
		
		
	}
	
}


