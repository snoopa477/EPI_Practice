package c06_Arrays.p09_PermuteTheElementsOfAnArray;

import static java.lang.System.out;

import java.util.List;

public class _0609_PermuteTheElementsOfAnArray_V02 {

	public static void applyPermutation(List<Integer> perm, List<Integer> A) {
		for (int i = 0; i < A.size(); ++i) {
			// Traverses the cycle to see if i is the minimum element.
			boolean isMin = true;
			int j = perm.get(i);
			while (j != i) {
				if (j < i) {
					isMin = false;
					break;
				}
				j = perm.get(j);

			}

			if (isMin) {
				cyclicPermutation(i, perm, A);
			}

		}

	}

	
	
	private static void cyclicPermutation(int start, List<Integer> perm, List<Integer> A) {
		int i = start;
		int temp = A.get(start);
		do {
			int nextI = perm.get(i);
			int nextTemp = A.get(nextI);
			A.set(nextI, temp);
			i = nextI;
			temp = nextTemp;
		} while (i != start);
	}
}
