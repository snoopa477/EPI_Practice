package c17_DynamicProgramming.p04_ComputeTheBinomialCoefficients;

import static java.lang.System.out;

public class _1704_ComputeTheBinomialCoefficients {

	public static int computeBinomialCoefficient(int n, int k) {
		return computeXChooseY(n, k, new int[n + 1][k + 1]);
	}

	private static int computeXChooseY(int x, int y, int[][] xChooseY) {
		if (y == 0 || x == y) {
			return 1;
		}
		if (xChooseY[x][y] == 0) {
			int withoutY = computeXChooseY(x - 1, y, xChooseY);
			int withY = computeXChooseY(x - 1, y - 1, xChooseY);
			xChooseY[x][y] = withoutY + withY;
		}
		return xChooseY[x][y];
	}
}
