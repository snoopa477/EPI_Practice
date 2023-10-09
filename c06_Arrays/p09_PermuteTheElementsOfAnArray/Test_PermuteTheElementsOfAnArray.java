package c06_Arrays.p09_PermuteTheElementsOfAnArray;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Test_PermuteTheElementsOfAnArray {

	public static void main(String[] args) {
		
		
		List<Integer> perm = new ArrayList<> ( Arrays.asList(2,0,1,3) );
		
		
		List<Integer> A = new ArrayList<> ( Arrays.asList(1,2,3,4) );
		
		out.println("PermuteTheElementsOfAnArray_01_mutablePerm");
		PermuteTheElementsOfAnArray_01_mutablePerm.IS_DEBUG = true;
		PermuteTheElementsOfAnArray_01_mutablePerm.applyPermutation(perm, A);
		out.println(A);
		
		out.println("PermuteTheElementsOfAnArray_02_ImmutablePerm");
		A = new ArrayList<> ( Arrays.asList(1,2,3,4) );
		PermuteTheElementsOfAnArray_02_ImmutablePerm.applyPermutation(perm, A);
		out.println(A.size());
		out.println(A);
		out.println("end");
		
	}

}


