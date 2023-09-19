package c06_Arrays.p04_AdvancingThroughAnArray;
import static java.lang.System.out;

import java.util.List;
public class AdvancingThroughAnArray_02_recursive {
	
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		//start with 0
		return canReachEndHelper(maxAdvanceSteps, 0);
	}
	
	
	
	private static boolean canReachEndHelper( List<Integer> maxAdvanceSteps, int currPosition ) {
		
		int lastPosition = maxAdvanceSteps.size() -1;
		
		if( currPosition >= lastPosition) {
			return true;
		}
		
		
		int currentMaxStep = maxAdvanceSteps.get(currPosition);
		//at least one, so we can make progress
		for( int step = 1; step <= currentMaxStep; step++ ) {
			//if there exist any subtask can reach end, return true
			if( canReachEndHelper(maxAdvanceSteps, currPosition + step) ) {
				return true;
			}
		}
		
		//meaning all sub tasks fail to reach end, return false;
		return false;
	}
	

}


