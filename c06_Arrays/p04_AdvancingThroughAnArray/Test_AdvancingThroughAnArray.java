package c06_Arrays.p04_AdvancingThroughAnArray;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class Test_AdvancingThroughAnArray {

	public static void main(String[] args) {
		
		List<Integer> list01 = Arrays.asList(3,3,1,0, 2,0,1);
		List<Integer> list02 = Arrays.asList(3, 2,0,0,2,0,1);
		
		out.println("AdvancingThroughAnArray_01_ForLoop");
		out.println( AdvancingThroughAnArray_01_ForLoop.canReachEnd(list01) );
		out.println( AdvancingThroughAnArray_01_ForLoop.canReachEnd(list02) );
		
		
		out.println("AdvancingThroughAnArray_02_recursive");
		out.println( AdvancingThroughAnArray_02_recursive.canReachEnd(list01) );
		out.println( AdvancingThroughAnArray_02_recursive.canReachEnd(list02) );
		
	}

}


