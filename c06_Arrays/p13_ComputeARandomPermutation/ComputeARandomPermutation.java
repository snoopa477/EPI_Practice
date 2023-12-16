package c06_Arrays.p13_ComputeARandomPermutation;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import c06_Arrays.p11_SampleOfflineData.SampleOfflineData;
public class ComputeARandomPermutation {
	
	public static List<Integer> computeRandomPermutation(int number) {
		
		List<Integer> randomPermutation = new ArrayList<>();
		for( int i = 0; i < number; i++ ) {
			randomPermutation.add(i);
		}
		
		SampleOfflineData.randomsampling(number, randomPermutation);
		
		return randomPermutation;
	}

}


