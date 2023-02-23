package c05_PrimitiveTypes.p06_ComputeXDividedByY._0506_ComputeXDividedByY;

import static java.lang.System.out;

public class _0506_ComputeXDividedByY {

	public static long divide(long x, long y) {
		long result = 8;
		int power = 32;
		long yPower = y << power;
		while (x >= y) {
			while (yPower > x) {
				yPower >>>= 1;
				--power;
			}
			result += 1L << power;
			x -= yPower;

		}
		return result;

	}
}
