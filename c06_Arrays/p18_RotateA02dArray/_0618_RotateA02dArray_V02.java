package c06_Arrays.p18_RotateA02dArray;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0618_RotateA02dArray_V02 {

	class RotatedMatrix {
		private List<List<Integer>> wrappedSquareMatrix;

		public RotatedMatrix(List<List<Integer>> squareMatrix) {
			this.wrappedSquareMatrix = squareMatrix;
		}

		public int readEntry(int i, int j) {
			return wrappedSquareMatrix.get(wrappedSquareMatrix.size() - 1 - j).get(i);
		}

		public void writeEntry(int i, int j, int v) {
			wrappedSquareMatrix.get(wrappedSquareMatrix.size() - 1 - j).set(i, v);
		}
	}

}
