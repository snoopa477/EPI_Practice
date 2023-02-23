package c06_Arrays.p10_ComputeTheNextPermutation;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;

public class _0610_ComputeTheNextPermutation {
	public static List<Integer> nextPermutation(List<Integer> perm) {
		int k = perm.size() - 2;
		while (k >= 0 && perm.get(k) >= perm.get(k + 1)) {
			--k;
		}
		if (k == -1) {
			return Collections.emptyList(); // perm is the last permutation.
		}
		// Swap the smallest entry after index k that is greater than perm[k] . We
		// exploit the fact that perm .subList (k + 1, perm.size()) is decreasing so
		// if we search in reverse order, the first entry that is greater than
		// perm[k ] is the smallest such entry.
		for (int i = perm.size() - 1; i > k; --i) {
			if (perm.get(i) > perm.get(k)) {
				Collections.swap(perm, k, i);
				break;
			}
		}
		// Since perm.subList[k + 1, perm.size()) is in decreasing order, we can
		// build the smallest dictionary ordering of this subarray by reversing it.
		Collections.reverse(perm.subList(k + 1, perm.size()));
		return perm;
	}
}
