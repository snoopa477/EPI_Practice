package c06_Arrays.p13_ComputeARandomPermutation;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class _0613_ComputeARandomPermutation {
	public static List<Integer> computeRandomPermutation(int n) {
		List<Integer> permutation = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			permutation.add(i);
		}
		OfflineSampling.randomSampling(permutation.size(), permutation);
		return permutation;
	}

}
