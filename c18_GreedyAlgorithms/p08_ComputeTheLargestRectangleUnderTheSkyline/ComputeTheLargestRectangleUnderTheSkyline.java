package c18_GreedyAlgorithms.p08_ComputeTheLargestRectangleUnderTheSkyline;
import static java.lang.System.out;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class ComputeTheLargestRectangleUnderTheSkyline {

	private static int NON_EXISTENT = -1;
	
	public static int calculateLargestRectangle(List<Integer> heights) {
		
		Stack<Integer> sortedIdxs = new Stack<Integer>();
		
		int maxArea = 0;
		
		/**
		 * to calculate area, two conditions must be satisfied
		 * right_height is shorter than pivot_Height
		 * left_height is shorter than pivot_Height; however, this one always holds true 
		 * 
		 * WHY?
		 * 
		 */
		
		
		for( int right = 0; right < heights.size() + 1; right++ ) {
		
			int pivot_Height = getPivotHeight( sortedIdxs, heights );
			int right_Height = heights.get( right );

			
			//?
			if( pivot_Height != NON_EXISTENT && pivot_Height == right_Height  ) {
				sortedIdxs.pop();
				sortedIdxs.add( right );
				pivot_Height = getPivotHeight( sortedIdxs, heights );
			}
			
			
			/**
			 * 
			 * if true, that means right_height is shorter than pivot_Height
			 * we can now calculate area
			 * 
			 * REASONING: do this until
			 * pivot_Height <= right_Height && right != heights.size() + 1
			 * which means right_Height is NOT shorter than pivot_Height
			 * right_Height can no longer to satisfy the prerequisite to calculate  
			 * 
			 * DETAIL: when right index at heights.size() + 1, which is out of boundary, imagine it as lowest pillar
			 * 
			 */
			while( sortedIdxs.size() > 0 &&  
				( pivot_Height > right_Height || right == heights.size() + 1 ) ) {
				
				//now turn to the left pillar, which must be shorter than pivot pillar
				sortedIdxs.pop();
				int left = sortedIdxs.size() > 0 ? sortedIdxs.peek(): -1;
				int width = right - left -1;
				
				int currentArea = pivot_Height * width;
				maxArea = Math.max(maxArea, currentArea );
				
				pivot_Height = getPivotHeight( sortedIdxs, heights );
			}
			
			//since right_Height is NOT shorter than pivot_Height, it now becomes the new largest pivot height -> sort ascendingly
			sortedIdxs.add( right );
			
		}
		
		
		return maxArea;
	}
	
	
	
	private static int getPivotHeight( Stack<Integer> sortedIdxs, List<Integer> heights ) {
		return sortedIdxs.size() > 0 ? heights.get( sortedIdxs.peek() ) : NON_EXISTENT;
	}
	
	
}


