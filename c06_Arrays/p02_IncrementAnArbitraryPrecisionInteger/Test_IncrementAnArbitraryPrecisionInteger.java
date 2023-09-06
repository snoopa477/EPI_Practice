package c06_Arrays.p02_IncrementAnArbitraryPrecisionInteger;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_IncrementAnArbitraryPrecisionInteger {

	public static void main(String[] args) {
		
		List<List<Integer>> numbers = new ArrayList<>();

		//WRONG: when add() is called, UnsupportedOperationException - if the add operationis not supported by this list
		//at java.base/java.util.AbstractList.add(AbstractList.java:153)
//		numbers.add( Arrays.asList(1,2,9) );
//		numbers.add( Arrays.asList(2,3,8) );
//		numbers.add( Arrays.asList(9,9,9) );
//		numbers.add( Arrays.asList(9,9,9,9,9,9,9,9,9,9,9,9) );
		
		//Correction
		numbers.add( new ArrayList<>( Arrays.asList(1,2,9) ) );
		numbers.add( new ArrayList<>( Arrays.asList(2,3,8) ) );
		numbers.add( new ArrayList<>( Arrays.asList(9,9,9) ) );
		numbers.add( new ArrayList<>( Arrays.asList(9,9,9,9,9,9,9,9,9,9,9,9) ) );
		
		
		for( List<Integer> number : numbers ) {
			
			
			out.println( "\n" + number );
			List<Integer> addedNumber =  IncrementAnArbitraryPrecisionInteger.plusOne( number );
			out.println( addedNumber );
			
		}
		
	}

}


