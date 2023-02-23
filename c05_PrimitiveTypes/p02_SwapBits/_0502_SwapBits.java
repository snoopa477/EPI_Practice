package c05_PrimitiveTypes.p02_SwapBits;

import static java.lang.System.out;

public class _0502_SwapBits {
	public static long swapBits(long x, int i, int j) {
		// Extract the i-th and j-th bits, and see if they differ.
		if (((x >>> i) & 1) != ((x >>> j) & 1)) {
			// i-th and j-th bits differ. We will swap them by flipping their values.
			// Select the bits to flip with bitMask. Since xAl = <9 when x = 1 and 1
			// when x = (9, we can perform the flip XOR .
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		return x;
	}
}
