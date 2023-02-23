package c05_PrimitiveTypes.p05_ComputeXXYWithoutArithmeticalOperators;

import static java.lang.System.out;

public class _0505_ComputeXXYWithoutArithmeticalOperators {

	public static long multiply(long x, long y) {
		long sum = 0;
		while (x != 0) {
// Examines each bit of x.
			if ((x & 1) != 0) {
				sum = add(sum, y);
			}
			x >>>= 1;
			y <<= 1;
		}
		return sum;
	}

	private static long add(long a, long b) {
		long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
		while (tempA != 0 || tempB != 0) {
			long ak = a & k, bk = b & k;
			long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
			sum |= (ak ^ bk ^ carryin);
			carryin = carryout << 1;
			k <<= 1;
			tempA >>>= 1;
			tempB >>>= 1;
		}
		return sum | carryin;
	}
}
