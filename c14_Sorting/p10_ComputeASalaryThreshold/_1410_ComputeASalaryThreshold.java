package c14_Sorting.p10_ComputeASalaryThreshold;

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

public class _1410_ComputeASalaryThreshold {

	public static double findSalaryCap(double targetPayroll, List<Double> currentSalaries) {
		Collections.sort(currentSalaries);
		double unadjustedSalarySum = 0;
		for (int i = 0; i < currentSalaries.size(); ++i) {
			final double adjustedSalarySum = currentSalaries.get(i) * (currentSalaries.size() - i);
			if (unadjustedSalarySum + adjustedSalarySum >= targetPayroll) {

				return (targetPayroll - unadjustedSalarySum) / (currentSalaries.size() - i);

			}
			unadjustedSalarySum += currentSalaries.get(i);

		}
// No solution, since targetPayroll > existing payroll.
		return -1.0;

	}
}
