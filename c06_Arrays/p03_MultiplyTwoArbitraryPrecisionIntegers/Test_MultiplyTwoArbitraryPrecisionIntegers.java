package c06_Arrays.p03_MultiplyTwoArbitraryPrecisionIntegers;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

public class Test_MultiplyTwoArbitraryPrecisionIntegers {

	public static void main(String[] args) {
		
		{
			List<Integer> n1 = Arrays.asList(-2, 5, 4, 5);
			List<Integer> n2 = Arrays.asList(9, 7, 6, 5, 4);
			//x: [-1, 14, 7, 14, 12, 9, 4, 3, 0]
			//o: [2 4 8 5 2 9 4 3 0]
			
			//WRONG, it cahgnes n1, n2
			out.println( MultiplyTwoArbitraryPrecisionIntegers.multiply(n1, n2) );
			out.println( _0603_MultiplyTwoArbitraryPrecisionIntegers.multiply(n1, n2) );
		}
		
		
		{
			List<Integer> n1 = Arrays.asList(-2, 5, 4, 5);
			List<Integer> n2 = Arrays.asList(-9, 7, 6, 5, 4);
			out.println( MultiplyTwoArbitraryPrecisionIntegers.multiply(n1, n2) );
			out.println( _0603_MultiplyTwoArbitraryPrecisionIntegers.multiply(n1, n2) );
		}
		
	}

}


