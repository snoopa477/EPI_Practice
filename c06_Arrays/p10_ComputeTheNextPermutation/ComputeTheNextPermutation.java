package c06_Arrays.p10_ComputeTheNextPermutation;
import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
public class ComputeTheNextPermutation {
	
	
	public static List<Integer> nextPermutation(List<Integer> perm){
		
		
		final int lastIndex = perm.size() -1;
		
		/* PURPOSE:
		 * step 1. find first small value from right to left. call it K
		 * 	so, the interval [k-1, size()-1] is in decreasing order if you see it left to right
		 * 
		 * step 2. find first index, that is greater than perm.get(K) from right to left
		 * 
		 * step 3. swap them. now the swapped perm is greater than before
		 * 
		 * step 4. swap the interval [k-1, size()-1] 
		 * 	so it will turn from decreasing to increasing. The swapped interval gets smaller; but the new perm is still larger than the original due to index K
		 * 
		 */
		
		//step 1
		//DETAIL: we will do the neighborhood comparison. So we start with left(size()-2), comparing w/ right(size()-1)
		int first_SmallValueIndex = lastIndex -1;
		//Wrong: right hand side should be + 1
		//while( first_SmallValueIndex >=0 && perm.get(first_SmallValueIndex) >= perm.get(first_SmallValueIndex -1) ) {
		while( first_SmallValueIndex >=0 && perm.get(first_SmallValueIndex) >= perm.get(first_SmallValueIndex +1) ) {
			first_SmallValueIndex--;
		}
		
		//there doesn't exists such index. The whole perm is increasing from right to left; therefore, no way gets any bigger. no such next perm exists
		if( first_SmallValueIndex == -1 ) {
			return null;
		}
		
		
		//step 2
		/*REASONING: in the interval [k-1, size()-1], find the first index that is greater than perm.get(K)
		 * so when these two swapped, the whole new perm gets larger
		 */
		//QUESTION: does such index must exist? Yes. since index exists, the assumption of having greater indeces at right side of index K holds.
		int first_LargeValueIndex = lastIndex;
		while( first_LargeValueIndex >= first_SmallValueIndex -1 && perm.get(first_LargeValueIndex) <= perm.get(first_SmallValueIndex) ) {
			first_LargeValueIndex--;
		}

		//step3
		//now it gets larger
		Collections.swap(perm, first_SmallValueIndex, first_LargeValueIndex);
		
		
		//step4
		//reverse the interval
		Collections.reverse( perm.subList(first_SmallValueIndex + 1, perm.size() ) );
		
		return perm;
	}

}


