package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;

import static java.lang.System.out;

public class _0501_01_ComputingTheParityOfAword {

	public static short parity(long x) {
		short result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x >>>= 1;

		}

		return result;
	}

}
