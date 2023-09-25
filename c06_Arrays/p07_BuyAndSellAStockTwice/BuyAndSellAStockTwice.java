package c06_Arrays.p07_BuyAndSellAStockTwice;
import static java.lang.System.out;

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
		 *  
		 */
		
		double[] maxProfit_FirstTrade = new double[prices.size() + 1];
		
		
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		
	}

}


