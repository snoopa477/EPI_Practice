package c06_Arrays.p10_ComputeTheNextPermutation;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Test_nextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list01 = new ArrayList<>( Arrays.asList(0,1,2,3,4,5,6,7) );
		out.println( list01.subList(3, 6) );
		Collections.reverse( list01.subList(3, 6) );
		out.println(list01);
		
		printNextPerm( 0,1,2 );
		printNextPerm( 0,2,1 );
		printNextPerm( 1,0,2 );
		printNextPerm( 1,2,0 );
		printNextPerm( 2,0,1 );
		printNextPerm( 2,1,0 );
		
		printNextPerm( 6,2,1,5,4,3,0 );
		
		

	}
	
	
	private static void printNextPerm( Integer... nums ) {
		out.println("-------------");
		List<Integer> list = new ArrayList<>( Arrays.asList(nums) );
		out.println( "before " + list );
		out.println( "after " + ComputeTheNextPermutation.nextPermutation(list));
	}
	
}


