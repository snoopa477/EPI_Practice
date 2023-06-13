package c17_DynamicProgramming.p09_PickUpCoinsForMaximumGain;

import static java.lang.System.out;

import java.util.List;

public class _1709_PickUpCoinsForMaximumGain {

	public static int pickUpCoins(List<Integer> coins) {
		return computeMaximumRevenueForRange(coins, 0, coins.size() - 1, new int[coins.size()][coins.size()]);
	}

	
	
	private static int computeMaximumRevenueForRange(List<Integer> coins, int a, int b, int[][] maximumRevenueForRange) {
		
		if (a > b) {
			// No coins left.
			return 0;
		}

		
		if (maximumRevenueForRange[a][b] == 0) {
			int maximumRevenueA = coins.get(a) + 
					Math.min(computeMaximumRevenueForRange(coins, a + 2, b, maximumRevenueForRange),
					computeMaximumRevenueForRange(coins, a + 1, b - 1, maximumRevenueForRange));

			
			int maximumRevenueB = coins.get(b)
					+ Math.min(computeMaximumRevenueForRange(coins, a + 1, b - 1, maximumRevenueForRange),
					computeMaximumRevenueForRange(coins, a, b - 2, maximumRevenueForRange));
			
			
			maximumRevenueForRange[a][b] = Math.max(maximumRevenueA, maximumRevenueB);

		}
		
		
		return maximumRevenueForRange[a][b];

	}
}
