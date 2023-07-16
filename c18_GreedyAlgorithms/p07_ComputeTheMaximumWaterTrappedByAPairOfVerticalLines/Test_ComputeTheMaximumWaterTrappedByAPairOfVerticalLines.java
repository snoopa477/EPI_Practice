package c18_GreedyAlgorithms.p07_ComputeTheMaximumWaterTrappedByAPairOfVerticalLines;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Test_ComputeTheMaximumWaterTrappedByAPairOfVerticalLines {

	public static void main(String[] args) {
		
		List<Integer> heights = new ArrayList<>( Arrays.asList(1, 2,1,3, 4, 4,5,6,2,1,3,1, 3, 2,1,2,4,1) );
		
		out.println( _1807_ComputeTheMaximumWaterTrappedByAPairOfVerticalLines.getMaxTrappedWater(heights) );
		out.println( ComputeTheMaximumWaterTrappedByAPairOfVerticalLines.getMaxTrappedWater(heights) );
		out.println("end");
	}

}


