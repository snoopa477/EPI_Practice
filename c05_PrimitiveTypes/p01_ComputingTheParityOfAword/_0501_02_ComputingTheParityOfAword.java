package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;

import static java.lang.System.out;

public class _0501_02_ComputingTheParityOfAword {

	public static short parity(long x) {
		short result = 0;
		while (x != 0) {
			result ^= 1;
			x &= (x - 1); // Drops the lowest set bit of x.

		}

		return result;
	}
}
