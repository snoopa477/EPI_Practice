package c05_PrimitiveTypes.p08_ReverseDigits;

import static java.lang.System.out;

public class _0508_ReverseDigits {

	public static long reverse(int x) {
		long result = 0;
		long xRemaining = Math.abs(x);
		while (xRemaining != 0) {
			result = result * 10 + xRemaining % 10;
			xRemaining /= 10;

		}

		return x < 0 ? -result : result;
	}
}
