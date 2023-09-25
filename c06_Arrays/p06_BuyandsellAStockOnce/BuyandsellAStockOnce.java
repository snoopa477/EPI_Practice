package c06_Arrays.p06_BuyandsellAStockOnce;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class BuyandsellAStockOnce {

	
	public static double computeMaxProfit(List<Double> prices) {
		
		/**
		 * REASONING:
		 * buy at i, sell at j
		 * i < j
		 * 
		 * What is certain is:
		 * j is current index
		 * price[j] - minPriceFrom0toi must >= price[j] - anyPriceFrom0toi
		 * 
		 * However, current max price distance derived from index j
		 * , has no relationship other with other current max price distance derived from index k
		 * , where k < j
		 * So, we need to use Math.max to pick the larger one, keep it up-to-date 
		 * 
		 */
		
		//imagine it frim index -1, must not compete with index 0 when picking min. dummy element to make up a pair
		double minPriceSoFar = Double.MAX_VALUE; 
		double maxProfitSoFar = 0f;
		for( int i = 0; i < prices.size(); i++ ) {
			
			double currentPrice = prices.get(i);
			double currentMaxPriceGap = (i == 0)? 
				//I think this is not beautiful
				currentPrice - currentPrice :
				currentPrice - minPriceSoFar;
			
			maxProfitSoFar = Math.max( maxProfitSoFar, currentMaxPriceGap );
			
			//now consider the current price, see if this is the new min price
			minPriceSoFar = Math.min(minPriceSoFar, currentPrice);
			
		}
		
		//reaching here means all indeces are already considered
		return maxProfitSoFar;
	}
	
	
	
	public static void main(String[] args) {
		
		//Cannot convert List<Integer> to List<Double>
		//List<Double> stockPrices =  Arrays.asList(310,310, 275, 275, 260, 260, 260, 230, 230, 230);
		List<Double> stockPrices =  Arrays.asList(310d,310d, 275d, 275d, 260d, 260d, 260d, 230d, 230d, 230d);
		out.println( computeMaxProfit(stockPrices) );
		
		
		stockPrices =  Arrays.asList(310d ,315d, 275d, 295d, 260d, 270d, 290d, 230d, 255d, 250d);
		out.println( computeMaxProfit(stockPrices) );
		
		
		stockPrices =  Arrays.asList(12d, 11d, 13d, 9d, 12d, 8d, 14d, 13d ,15d);
		out.println( computeMaxProfit(stockPrices) );	
	}

}


