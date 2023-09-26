package c06_Arrays.p07_BuyAndSellAStockTwice;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class BuyAndSellAStockTwice {

	
	public static double buyAndSellStockTwice(List<Double> prices) {
		
		
		/**
		 * REASONING
		 * In 06.06, we only need the final state of maxProfit; however, in contrast 
		 * we need to keep record every moment of maxProfit so far; 
		 * 
		 * since every moment of maxProfit(1st buy-sell) will have to combine another maxProfit(2nd buy-sell), with time after that moment,
		 * forming a sum of maxProfit(1st buy-sell) at moment i, and maxProfit(2nd buy-sell) after moment i
		 * It is definitely larger than sum of maxProfit(1st buy-sell) at moment i, and random 2nd buy-sell
		 * However, it still needs to compare with other, with moment j, where i != j, to figure out which is larger
		 * 
		 */
		
		/**
		 * PURPOSE:
		 * STEP 1: keep records of every moment i ( from 0 to i )(left to i) of maxProfit of first buy-sell
		 * STEP 2: keep records of every moment i ( from size() -1 to i )(right to i) of maxProfit of first buy-sell
		 * STEP 3: combine the two
		 */
		
		//double[] maxProfit_FirstTrade = new double[prices.size() + 1];
		
		//STEP1
		//DETAIL: maxProfit_FirstTrade[i] returns v:  considering time at 0 to i, the maxProfit is v
		double[] maxProfit_FirstTrade = getMaxProfit_FirstTrade(prices);
		
		
		//STEP2
		//DETAIL: maxProfit_SecondTrade[i] returns v:  considering time at size() -1 to i, the maxProfit is v
		double[] maxProfit_SecondTrade = getMaxProfit_SecondTrade(prices);
		
		
		
		//STEP3: combine the two and find the maxProft from those 2
		/* REASONING 
		 * Given 5 days, since second happens after the fist => second buy index > first buy idnex
		 * FirstBuy  x 0 1 2 3 4
		 * Second    0 1 2 3 4 x
		 * -----------------------
		 * combined  0 1 2 3 4 5
		 * 
		 * However since index 0 and last are only buy once, they are the same
		 * so we discard the last index 5
		 */
		//Wait, I don't even need array
//		double[] maxProfit_TwoTrades = new double[prices.size()];
//		for( int i = 0; i < maxProfit_TwoTrades.length; i++ ) {
//			int previous_i = i - 1;
//			maxProfit_TwoTrades[i] = previous_i > 0? 
//				maxProfit_FirstTrade[ previous_i ] + maxProfit_SecondTrade[i]: 
//				0 + maxProfit_SecondTrade[i];
//		}
		
		double maxProfit_TwoTrades = Double.MIN_VALUE;
		for( int i = 0; i < maxProfit_SecondTrade.length; i++ ) {
			int previous_i = i - 1;
			double currentProfit_TwoTrades = previous_i > 0? 
				maxProfit_FirstTrade[ previous_i ] + maxProfit_SecondTrade[i]: 
				0 + maxProfit_SecondTrade[i];
				
				maxProfit_TwoTrades = Math.max(maxProfit_TwoTrades, currentProfit_TwoTrades);
		}
		
		
		return maxProfit_TwoTrades;
	}
	
	
	
	private static double[] getMaxProfit_FirstTrade(List<Double> prices) {
		
		//DETAIL: maxProfit_FirstTrade[i] returns v:  considering time at 0 to i, the maxProfit is v
		double[] maxProfit_FirstTrade = new double[prices.size()];
		
		double minPriceSoFar = Double.MAX_VALUE;
		double maxProfitSoFar = Double.MIN_VALUE;
		for( int i = 0; i < prices.size(); i++ ) {
			
			double currentPrice = prices.get(i);
			double currentMaxPriceGap = i == 0?
				currentPrice - currentPrice:
				currentPrice - minPriceSoFar;
			
			currentMaxPriceGap = currentMaxPriceGap > 0? currentMaxPriceGap : 0;
			
			maxProfitSoFar = Math.max(maxProfitSoFar, currentMaxPriceGap);
			//record this moment
			maxProfit_FirstTrade[i] = maxProfitSoFar;
			
			//prepare for next round
			minPriceSoFar = Math.min(minPriceSoFar, currentPrice);
			
		}		
		
		return maxProfit_FirstTrade;
	}
	
	
	
	private static double[] getMaxProfit_SecondTrade(List<Double> prices) {
		//DETAIL: maxProfit_SecondTrade[i] returns v:  considering time at size() -1 to i, the maxProfit is v
		double[] maxProfit_SecondTrade = new double[prices.size()];
		
		double maxPriceSoFar = Double.MIN_VALUE;
		double maxProfitSoFar = Double.MIN_VALUE;
		//DETAIL: since considering range start with right, doing backward
		for( int i = prices.size() -1 ; i >= 0; i-- ) {
			
			double currentPrice = prices.get(i);
			//double currentMaxPriceGap = i == 0?
			double currentMaxPriceGap = i == prices.size() -1 ?
				currentPrice - currentPrice:
				maxPriceSoFar - currentPrice;
			
			currentMaxPriceGap = currentMaxPriceGap > 0? currentMaxPriceGap : 0;
			
			maxProfitSoFar = Math.max(maxProfitSoFar, currentMaxPriceGap);
			//record this moment
			maxProfit_SecondTrade[i] = maxProfitSoFar;
			
			//prepare for next round
			maxPriceSoFar = Math.max(maxPriceSoFar, currentPrice);
		}
		return maxProfit_SecondTrade;
	}
	
	
	
	public static void main(String[] args) {
		List<Double> stockPrices =  Arrays.asList(12d, 11d, 13d, 9d, 12d, 8d, 14d, 13d ,15d);
		out.println( buyAndSellStockTwice(stockPrices) );	
		
	}

}


