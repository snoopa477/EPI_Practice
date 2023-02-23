package c18_GreedyAlgorithms.p01_ComputeAnOptimumAssignmentOfTasks;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1801_ComputeAnOptimumAssignmentOfTasks {

	private static class PairedTasks {
		public Integer taskl;
		public Integer task2;

		public PairedTasks(Integer taskl, Integer task2) {
			this.taskl = taskl;
			this.task2 = task2;

		}

	}

	public static List<PairedTasks> optimumTaskAssignment(List<Integer> taskDurations) {
		Collections.sort(taskDurations);
		List<PairedTasks> optimumAssignments = new ArrayList<>();
		for (int i = 0, j = taskDurations.size() - 1; i < j; ++i, --j) {
			optimumAssignments.add(new PairedTasks(taskDurations.get(i), taskDurations.get(j)));

		}
		return optimumAssignments;

	}

}
