package c18_GreedyAlgorithms.p08_ComputeTheLargestRectangleUnderTheSkyline;
import static java.lang.System.out;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Test_ComputeTheLargestRectangleUnderTheSkyline {

	public static void main(String[] args) {
		
		List<Integer> heights = new ArrayList<>( Arrays.asList( 1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3 ) );
		
		_1808_ComputeTheLargestRectangleUnderTheSkyline.IS_DEBUG = true;
		ComputeTheLargestRectangleUnderTheSkyline.IS_DEBUG = true;
		
		out.println( _1808_ComputeTheLargestRectangleUnderTheSkyline.calculateLargestRectangle(heights) );
		out.println( ComputeTheLargestRectangleUnderTheSkyline.calculateLargestRectangle(heights) );
		
	}

}


