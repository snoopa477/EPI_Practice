package c18_GreedyAlgorithms.p07_ComputeTheMaximumWaterTrappedByAPairOfVerticalLines;
import static java.lang.System.out;

import java.util.List;
public class ComputeTheMaximumWaterTrappedByAPairOfVerticalLines {
	
	
	public static int getMaxTrappedWater(List<Integer> heights) {
		
		/**
		 * REASONING:
		 * the water level is determined by the lower side.
		 * given heights[left] < heights[right]
		 * 
		 * we decrease the width by one by either moving 'left' right by one unit or 'right' left one unit
		 * 
		 * at right side moving left
		 * no matter what height a right side is
		 * the updated new water level is <= than the old one 
		 * Therefore we can say the new water volume ( width * height ) can't be larger. this move is not worth trying
		 * 
		 * at left side moving right
		 * if the new right is higher than the old one
		 * then water level increases, hence new water volume gets larger
		 * else, the water volume decreases ( since width gets smaller, and water level never gets higher)
		 * 
		 * Therefore, this move worth trying.
		 */
		
		//DETAIL: start with leftmost and rightmost, making sure each move can decrease width
		int left = 0;
		int right = heights.size() -1;
		
		int leftHeight = heights.get( left );
		int rightHeight = heights.get( right );
		
		int waterHeight = Math.min(leftHeight, rightHeight);
		int width = right - left;
		
		int maxWaterVolume = waterHeight * width;
		
		//while( left <= right ) {
		//DETAIL: when left = right, width = 0. no need to try
		while( left < right ) {
			
			width = right - left;
			leftHeight = heights.get( left );
			rightHeight = heights.get( right );
			waterHeight = Math.min(leftHeight, rightHeight);
			
			maxWaterVolume = Math.max( maxWaterVolume, waterHeight * width );

			
			if( leftHeight < rightHeight ) {
				//might increase waterHeight
				//WRONG, this would cause infinite loop
				//leftHeight++;
				left++;
			}
			else {
				//might increase waterHeight
				//WRONG, this would cause infinite loop
				//rightHeight--;
				right--;
			}
			
			
			//WRONG: inconsistent state with waterHeight
			//waterHeight = Math.min(leftHeight, rightHeight);
			//width = right - left;
			//maxWaterVolume = Math.max( maxWaterVolume, waterHeight * width );
		}
		
		
		return maxWaterVolume;
	}
	

}


