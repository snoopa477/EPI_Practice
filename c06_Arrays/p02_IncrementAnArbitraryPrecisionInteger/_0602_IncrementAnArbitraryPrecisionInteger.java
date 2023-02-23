package c06_Arrays.p02_IncrementAnArbitraryPrecisionInteger;

import static java.lang.System.out;

import java.util.List;

public class _0602_IncrementAnArbitraryPrecisionInteger {

	public static List<Integer> plusOne(List<Integer> A) {
		int n = A.size() - 1;
		A.set(n, A.get(n) + 1);
		for (int i = n; i > 0 && A.get(i) == 10; --i) {
			A.set(i, 0);
			A.set(i - 1, A.get(i - 1) + 1);

		}

		if (A.get(0) == 10) {
// Need additional digit as the most significant digit ( i.e A. get (0))
// has a carry-out .
			A.set(0, 0);
			A.add(0, 1);

		}
		return A;

	}

}
