package c06_Arrays.p05_DeleteDuplicatesFromASortedArray;
import static java.lang.System.out;

import java.util.List;
public class DeleteDuplicatesFromASortedArray {
	
	
	public static int deleteDuplicates(List<Integer> A) {
		
		/*REASONING: don't require additional space to allocate another list, since deleteDpulicate list must smaller than original one
		 * 
		 */
		
		//IMAGINATION: two virtual list shares one physical. the delteDuplicate list is growing by collecting elements, which are fed by seek pointer
		
		//DETAIL: when there's one, it must be unique
		int lastUniqueElement_Idx = 0;
		
		//exclusive, ready to collect. Right next to lastUniqueElement_Idx
		int endOfUniqueList_Idx = lastUniqueElement_Idx + 1;
		
		//no need to seek 0, since 0 must be index of unique element 
		for( int seekIdx = 1; seekIdx < A.size(); seekIdx++ ) {
			
			//find the unique one, add to unique list
			int currValue = A.get(seekIdx);
			if( currValue != A.get(lastUniqueElement_Idx) ) {
				
				A.set( endOfUniqueList_Idx, currValue );
				lastUniqueElement_Idx++;
				endOfUniqueList_Idx++;
				
			}
			//else, A.get(seekIdx) == A.get(lastUniqueElement_Idx) => duplicate not unique, do nothing and pass
			
		}
		
		return lastUniqueElement_Idx + 1;
	}

}


