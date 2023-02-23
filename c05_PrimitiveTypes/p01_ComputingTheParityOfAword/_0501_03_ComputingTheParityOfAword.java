package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;

import static java.lang.System.out;

public class _0501_03_ComputingTheParityOfAword {

	public static short parity(long x) {
		final int W0RD_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		return (short) (precomputedParity[(int) ((x >>> (3 * W0RD_SIZE)) & BIT_MASK)]
				^ precomputedParity[(int) ((x >>> (2 * W0RD_SIZE)) & BIT_MASK)]
				^ precomputedParity[(int) ((x >>> W0RD_SIZE) & BIT_MASK)] ^ precomputedParity[(int) (x & BIT_MASK)]);
	}

}
