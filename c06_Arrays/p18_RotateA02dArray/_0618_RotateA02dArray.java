package c06_Arrays.p18_RotateA02dArray;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0618_RotateA02dArray {

	public static void rotateMatrix(List<List<Integer>> squareMatrix) {
		final int matrixSize = squareMatrix.size() - 1;
		for (int i = 0; i < (squareMatrix.size() / 2); ++i) {
			for (int j = i; j < matrixSize - i; ++j) {
// Perform a 4-way exchange.
				int tempi = squareMatrix.get(matrixSize - j).get(i);
				int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
				int temp3 = squareMatrix.get(j).get(matrixSize - i);
				int temp4 = squareMatrix.get(i).get(j);
				squareMatrix.get(i).set(j, tempi);
				squareMatrix.get(matrixSize - j).set(i, temp2);
				squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
				squareMatrix.get(j).set(matrixSize - i, temp4);
			}
		}
	}
}
