package c17_DynamicProgramming.p09_PickUpCoinsForMaximumGain;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class PickUpCoinsForMaximumGain {
	
	private static int UNVISITED = -1;
	
	public static int pickUpCoins(List<Integer> coins) {
		
		int coinSize = coins.size();
		int[][] maximumRevenueForRange = new int[coinSize][coinSize];
		for( int i = 0; i < maximumRevenueForRange.length; i ++ ) {
			Arrays.fill( maximumRevenueForRange[i], UNVISITED );
		}
		
		return computeMaximumRevenueForRange( coins, maximumRevenueForRange, 0, coinSize -1 ) ;
	}

	
	
	private static int computeMaximumRevenueForRange( List<Integer> coins, int[][] maximumRevenueForRange, int left, int right ) {
		
		/* IMAGINATION: it's easier for me to think of a state just before base case 
		   f(a,b): [index a... index b] 
		   playerA: <>
		   playerB: ()
		   
		   [10  50]:
		   
		   case 1.1: A picks left, B picks left
		   
			   playerA
			   <10>[50]
			   
			   playerB
			   <10>(50)][
		   
		   case 1.2: A picks left, B picks right
		   
		       playerA
			   <10>[50]
			   
			   playerB
			   <10>][(50)
		 */
		if( left > right ) {
			return 0;
		}

		
		if( maximumRevenueForRange[left][right] == UNVISITED ) {
			
			//player A picks left
			int pickedValue01 = coins.get(left);
			int aLeft_bRight = pickedValue01 + computeMaximumRevenueForRange( coins, maximumRevenueForRange, left + 1/*A*/, right -1/*B*/  );
			int aLeft_bLeft  = pickedValue01 + computeMaximumRevenueForRange( coins, maximumRevenueForRange, left + 1/*A*/ + 1/*B*/, right );
			//player B max his own scores, meaning minimizing player A's score
			int bChoose_aMin01 = Math.min( aLeft_bRight , aLeft_bLeft );
			
			
			//player A picks right
			int pickedValue02 = coins.get(right);
			int aRight_bLeft   = pickedValue02 + computeMaximumRevenueForRange( coins, maximumRevenueForRange, left + 1/*B*/, right -1/*A*/  );
			int aRight_bRight  = pickedValue02 + computeMaximumRevenueForRange( coins, maximumRevenueForRange, left, right - 1/*A*/ - 1/*B*/ );
			
			int bChoose_aMin02 = Math.min( aRight_bLeft , aRight_bRight );
			
			
			int aChooseMax = Math.max( bChoose_aMin01 , bChoose_aMin02 );
			maximumRevenueForRange[left][right] = aChooseMax;
			
		}
		
		return maximumRevenueForRange[left][right];
	}
	
	

}


