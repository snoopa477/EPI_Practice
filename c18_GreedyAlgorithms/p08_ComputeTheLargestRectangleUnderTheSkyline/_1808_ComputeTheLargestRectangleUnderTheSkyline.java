package c18_GreedyAlgorithms.p08_ComputeTheLargestRectangleUnderTheSkyline;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1808_ComputeTheLargestRectangleUnderTheSkyline {

	public static int calculateLargestRectangle(List<Integer> heights) {
		Deque<Integer> pillarIndices = new LinkedList<>();
		int maxRectangleArea = 0;
		for (int i = 0; i <= heights.size(); ++i) {
			if (!pillarIndices.isEmpty() && i < heights.size()
					&& heights.get(i).equals(heights.get(pillarIndices.peekFirst()))) {
// Replace earlier building with same height by current building. This
// ensures the later buildings have the correct left endpoint.
				pillarIndices.removeFirst();
				pillarIndices.addFirst(i);
			}
// By iterating to heights.size() instead of heights.size() - 1, we can
// uniformly handle the computation for rectangle area here.
			while (!pillarIndices.isEmpty() && isNewPillarOrReachEnd(heights, i, pillarIndices.peekFirst())) {
				int height = heights.get(pillarIndices.removeFirst());
				int width = pillarIndices.isEmpty() ? i : i - pillarIndices.peekFirst() - 1;
				maxRectangleArea = Math.max(maxRectangleArea, height * width);
			}
			pillarIndices.addFirst(i);
		}
		return maxRectangleArea;
	}

	private static boolean isNewPillarOrReachEnd(List<Integer> heights, int currldx, int lastPillarldx) {
		return currldx < heights.size() ? heights.get(currldx) < heights.get(lastPillarldx) : true;

	}
}
