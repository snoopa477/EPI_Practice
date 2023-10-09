package c06_Arrays.p09_PermuteTheElementsOfAnArray;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
public class PermuteTheElementsOfAnArray_01_mutablePerm {
	
	public static boolean IS_DEBUG = false;
	
	public static void applyPermutation(List<Integer> perm, List<Integer> A) {
		
		/**
		 * PURPOSE:
		 * step 1: apply perm to A, with performing cycle swaps
		 * step 2: restore perms after using  
		 */
		
		
		//step 1
		//iterate through, making sure all perm indexes are all set
		for( int idx_perm = 0; idx_perm < perm.size(); idx_perm++ ) {
			
			if( isUsed(perm, idx_perm) == false ) {
				performCycleSwaps( perm, idx_perm, A );
			}
		}
		
		//setp 2
		//A is done, now restore perms, which all elements are modifed as set
		restoreUnused(perm);
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
			//REASONING: the reason to mark as set, cuz we need to avoid same cycle with different index entry. that's repetitive job 
			//now source to dest is done, mark as already set
			setUsed( source_to_dest, idx_source );
			
			if( IS_DEBUG ) {
				out.println("idx_origin " + idx_origin + "; perm " + source_to_dest.toString());
			}
			
			//however, dest to source is wrong, which is tuck at position origin
			
			//prepare for next round
			idx_source = idx_dest;
			idx_dest = source_to_dest.get( idx_source );
			
		}
		
		
		
		Collections.swap(A, idx_origin, idx_dest);
		setUsed( source_to_dest, idx_source );
		
		if( IS_DEBUG ) {
			out.println("idx_origin " + idx_origin + "; perm " + source_to_dest.toString());
		}
		
	}
	
	
	
	private static boolean isUsed( List<Integer> perm, int i  ) {
		return perm.get(i) < 0;
	}
	
	
	
	//Don't have to worry how set is done
	private static void setUsed( List<Integer> perm, int i ) {
		int value = perm.get(i);
		perm.set(i, value - perm.size());
	}
	
	
	
	//PRECONDITION: all perm indexes are used by calling setUsed
	private static void restoreUnused( List<Integer> perm ) {
		
		for( int i = 0; i < perm.size(); i++) {
			int value = perm.get(i);
			perm.set(i, value + perm.size());
		}
		
	}

}


