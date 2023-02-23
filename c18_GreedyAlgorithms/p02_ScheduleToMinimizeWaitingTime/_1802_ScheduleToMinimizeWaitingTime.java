package c18_GreedyAlgorithms.p02_ScheduleToMinimizeWaitingTime;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;

public class _1802_ScheduleToMinimizeWaitingTime {

	public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
// Sort the service times in increasing order.
		Collections.sort(serviceTimes);
		int totalWaitingTime = 0;
		for (int i = 0; i < serviceTimes.size(); ++i) {
			int numRemainingQueries = serviceTimes.size() - (i + 1);
			totalWaitingTime += serviceTimes.get(i) * numRemainingQueries;
		}
		return totalWaitingTime;
	}
}
