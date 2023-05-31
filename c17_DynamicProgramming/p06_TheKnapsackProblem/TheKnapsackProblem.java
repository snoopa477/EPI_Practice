package c17_DynamicProgramming.p06_TheKnapsackProblem;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class TheKnapsackProblem {
	
	private static int NONVISITED = -1;
	
	public static boolean IS_DEBUG = false;
	
	static class ValuableItem{
		
		public int weight;
		public int price;
		
		
		public ValuableItem(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}
		
	}
	
	
	
	public static int maximumValueOfPicking( List<ValuableItem> valuableItems, int thiefCapacity ) {
		
		/*
		 * row i: the ith item to consider 
		 * 	(therefore, 0 th i-1 th items are already considered)
		 * col j: the j unit of weight on the thief now
		 * values[i][j]: the thief maximum value pick, considering 0th to i th items, with the ability to load j weight
		 * 
		 */
		//Cache
		int[][] maxValuePick = new int[ valuableItems.size() ][ thiefCapacity + 1 ];
		
		for( int i = 0; i < maxValuePick.length; i++ ) {
			Arrays.fill( maxValuePick[i], NONVISITED);
		}
		
		
		return maximumValueOfPicking( maxValuePick, thiefCapacity, valuableItems, valuableItems.size() -1 );
		
	}
	
	
	
	private static int maximumValueOfPicking( int[][] maxValuePick, int currentWeight, List<ValuableItem> valuableItems, int indexOfItem ) {
		
		
		
		//no such item, then the maxValuePick is 0
		//item weight > 0
		if( indexOfItem < 0 || currentWeight == 0 ) {
			return 0;
		}
		
		/**
		 * PURPOSE
		 * step 1: fill the maxValuePick, if not yet visited
		 * step 2: return the maxValuePick 
		 */
		
		if( maxValuePick[ indexOfItem ][ currentWeight ] == NONVISITED ) {
			
			/**
			 * REASONING: there are two states ( if they all existent ) that can reach maxValuePick[ indexOfItem ][ currentWeight ]
			 * 1. considering items, excluding the item of current index, with same weight ( since we don't consider current item)
			 * 2. considering items, including the item of current index, with weight - currentItemWeight( since we will pick this item, adding load )
			 */
			int maxValuePick_without_CurrentItem = maximumValueOfPicking( maxValuePick, currentWeight, valuableItems, indexOfItem -1 );
			
			ValuableItem currentItem = valuableItems.get( indexOfItem );
			//DETAIL: state 2 weight
			int weightBeforePickingCurrentItem = currentWeight - currentItem.weight;
			int maxValuePick_with_CurrentItem = weightBeforePickingCurrentItem >= 0 ?
				/*pick the item, so the state 2 weight go to current weight */
				maximumValueOfPicking( maxValuePick, currentWeight - currentItem.weight, valuableItems, indexOfItem ) + currentItem.price 
				// non existent situation: weightBeforePickingCurrentItem < 0 => value 0
				: 0;
				
			//call it max because we pick only the greatest
			maxValuePick[ indexOfItem ][ currentWeight ] = Math.max(
				maxValuePick_without_CurrentItem
				, maxValuePick_with_CurrentItem );
		}
		//reaching here meaning the value is filled
		
		if( IS_DEBUG ) {
			out.println( "currentWeight: " + currentWeight + "; indexOfItem: " + indexOfItem + "; value is " + maxValuePick[ indexOfItem ][ currentWeight ] );
		}
		
		return maxValuePick[ indexOfItem ][ currentWeight ];
	}

}


