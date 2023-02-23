package c18_GreedyAlgorithms.p07_ComputeTheMaximumWaterTrappedByAPairOfVerticalLines;

import static java.lang.System.out;

import java.util.List;

public class _1807_ComputeTheMaximumWaterTrappedByAPairOfVerticalLines {

	public static int getMaxTrappedWater(List<Integer> heights) {
		int i = 0, j = heights.size() - 1, maxWater = 0;
		while (i < j) {
			int width = j - i;
			maxWater = Math.max(maxWater, width * Math.min(heights.get(i), heights.get(j)));
			if (heights.get(i) > heights.get(j)) {
				--j;
			} else if (heights.get(i) < heights.get(j)) {
				++i;
			} else {// heights.get(i) == heights.get(j).
				++i;
				--j;
			}
		}
		return maxWater;
	}
}
