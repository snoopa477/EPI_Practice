package c06_Arrays.p06_BuyandsellAStockOnce;

import static java.lang.System.out;

import java.util.List;

public class _0606_BuyandsellAStockOnce {

	public static double computeMaxProfit(List<Double> prices) {
		double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
		for (Double price : prices) {
			maxProfit = Math.max(maxProfit, price - minPrice);
			minPrice = Math.min(minPrice, price);
		}
		return maxProfit;
	}
}
