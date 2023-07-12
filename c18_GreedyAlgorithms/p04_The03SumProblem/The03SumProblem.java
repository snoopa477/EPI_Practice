package c18_GreedyAlgorithms.p04_The03SumProblem;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class The03SumProblem {


	public static List<Integer> hasThreeSum(List<Integer> numbers, int sum) {
		
		Collections.sort( numbers );
		
		for( int i = 0; i < numbers.size(); i++ ) {
			int thirdVal = numbers.get(i);
			List<Integer> twoNumbers = hasTwoSum( numbers, sum - thirdVal );
			
			if( twoNumbers != null ) {
				twoNumbers.add( thirdVal );
				List<Integer> threeNumbers = twoNumbers;
				return threeNumbers;
			}
		}
		
		return null;
	}
	
	
	private static List<Integer> hasTwoSum(List<Integer> numbers, int sum){
		
		
		int left = 0;
		int right = numbers.size() -1;
		
		while( left <= right ) {
			
			int leftVal = numbers.get( left );
			int rightVal = numbers.get( right );
			int currentSum = leftVal + rightVal;
			
			if( currentSum < sum ) {
				left++;
			}
			else if( currentSum > sum ) {
				right--;
			}
			//found it!
			else {
				List<Integer> twoNumbers = new ArrayList<>();
				twoNumbers.add( leftVal );
				twoNumbers.add( rightVal );
				return twoNumbers;
			}
			
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		
		out.println(  hasThreeSum( Arrays.asList(11, 2, 5, 7, 3), 21 )  );
		out.println(  hasThreeSum( Arrays.asList(11, 2, 5, 7, 3), 100 )  );
		out.println(  hasThreeSum( Arrays.asList(2, 5, 4, 5, 2, 2, 6, 7), 16 )  );

	}

}


