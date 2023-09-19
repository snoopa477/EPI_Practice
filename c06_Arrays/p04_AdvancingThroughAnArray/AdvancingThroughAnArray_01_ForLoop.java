package c06_Arrays.p04_AdvancingThroughAnArray;
import static java.lang.System.out;

import java.util.List;
public class AdvancingThroughAnArray_01_ForLoop {
	
	
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		
		//This is shared by all indeces
		int maxReach = 0;
		int lastPosition = maxAdvanceSteps.size() - 1;
		
		//0, we start from the start
		//for( int i = 0; i < maxAdvanceSteps.size(); i++ ) {
		//WRONG: every step need to be within current maxReach, not just final step
		//for( int position = 0; position < maxAdvanceSteps.size(); position++ ) {
		for( int position = 0; position < maxAdvanceSteps.size() && position <= maxReach; position++ ) {
			maxReach = Math.max(maxReach, position + maxAdvanceSteps.get(position));
			
			//once fine then break
			if( maxReach >= lastPosition) {
				return true;
			}
		}
		
		//reaching here meaning all of iterations fail to find reaching end => none reach end
		
		return false;
	}

}


