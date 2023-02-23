package c17_DynamicProgramming.p10_CountTheNumberOfMovesToClimbStairs;

import static java.lang.System.out;

public class _1710_CountTheNumberOfMovesToClimbStairs {

	public static int numberOfWaysToTop(int top, int maximumStep) {
		return computeNumberOfWaysToH(top, maximumStep, new int[top + 1]);
	}

	private static int computeNumberOfWaysToH(int n, int maximumStep, int[] numberOfWaysToH) {
		if (n <= 1) {
			return 1;
		}
		if (numberOfWaysToH[n] == 0) {
			for (int i = 1; i <= maximumStep && n - i >= 0; ++i) {
				numberOfWaysToH[n] += computeNumberOfWaysToH(n - i, maximumStep, numberOfWaysToH);
			}
		}
		return numberOfWaysToH[n];
	}
}
