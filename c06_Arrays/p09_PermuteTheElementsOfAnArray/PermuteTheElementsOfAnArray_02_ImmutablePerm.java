package c06_Arrays.p09_PermuteTheElementsOfAnArray;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
public class PermuteTheElementsOfAnArray_02_ImmutablePerm {
	
	
public static void applyPermutation(List<Integer> perm, List<Integer> A) {
		
		/**
		 * PURPOSE:
		 * step 1: apply perm to A, with performing cycle swaps
		 */
		
		
		//step 1
		//iterate through, making sure all perm indexes are all set
		for( int idx_perm = 0; idx_perm < perm.size(); idx_perm++ ) {
			
			//call this to avoid repetition of same cycle, with different index entry. Here only the smallest index is allowed to be entry point
			if( isStartOfCycle(perm, idx_perm) ) {
				performCycleSwaps( perm, idx_perm, A );
			}
		}
		
		
	}
	
	
	
	//DETAIL: meanwhile, it calls setUsed every index it iterate through
	private static void performCycleSwaps( List<Integer> source_to_dest, int idx_origin, List<Integer> A ) {
		
		int idx_source = idx_origin;
		int idx_dest = source_to_dest.get( idx_source );
		
		//tail meets head(origin), meaning completion iteration of a cycle 
		while( idx_origin != idx_dest ) {
			
			/**
			 * REASONING:
			 * at the beginning:
			 * origin = source
			 * 
			 * source is abbreviated as s
			 * destination is abbreviated as d
			 * 
			 * s ... d
			 * Vs...Vd
			 * 
			 * after swap
			 * 
			 * s ... d
			 * Vd...Vs
			 * 
			 * now Vs is at right position
			 * Vd is at wrong position, which is at index s, also at ORIGIN's index
			 * 
			 */
			/*CAUTION: so, the wrong swapped one with original index dest is always at index original
			 * so the next step is to swap this wrong swapped one with index dest to correct position
			 * to do this, rename it as index source, as we do it in a new round, and see its destination
			 * 
			 * in the following swaps, all wrong swapped values are ALWAYS at index original
			 */
			Collections.swap(A, idx_origin, idx_dest);
			
			//however, dest to source is wrong, which is tuck at position origin
			
			//prepare for next round
			idx_source = idx_dest;
			idx_dest = source_to_dest.get( idx_source );
			
		}
		
		Collections.swap(A, idx_origin, idx_dest);
		
	}
	
	
	
	//PURPOSE: we define start of cycle by checking if it is the smallest index among cycle
	//CAUTION: it might liead to infinite loop
	private static boolean isStartOfCycle( List<Integer> source_to_dest, int idx_origin  ) {
		
		//make assumption
		int min = idx_origin;
		
		int idx_source = idx_origin;
		int idx_dest = source_to_dest.get( idx_source );
		
		//iterate through cycle till head meets tail
		while( idx_origin != idx_dest ) {
			
			//violate the assumption => idx_origin is not min, not the start of a cycle
			if( min > idx_dest ) {
				return false;
			}
			
			idx_source = idx_dest;
			idx_dest = source_to_dest.get( idx_source );
		}
		
		return true;
	}
	

}


