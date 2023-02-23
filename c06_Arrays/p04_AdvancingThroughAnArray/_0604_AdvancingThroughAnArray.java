package c06_Arrays.p04_AdvancingThroughAnArray;

import static java.lang.System.out;

import java.util.List;

public class _0604_AdvancingThroughAnArray {

	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0, lastlndex = maxAdvanceSteps.size() - 1;
		for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex; ++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
		}
		return furthestReachSoFar >= lastlndex;
	}

}
