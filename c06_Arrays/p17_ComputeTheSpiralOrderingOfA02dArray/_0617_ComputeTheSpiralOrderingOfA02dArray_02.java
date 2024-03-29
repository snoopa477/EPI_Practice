package c06_Arrays.p17_ComputeTheSpiralOrderingOfA02dArray;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class _0617_ComputeTheSpiralOrderingOfA02dArray_02 {

	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
		
		final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		
		int dir = 0, x = 0, y = 0;
		List<Integer> spiralOrdering = new ArrayList<>();
		
		for (int i = 0; i < squareMatrix.size() * squareMatrix.size(); ++i) {
			
			spiralOrdering.add(squareMatrix.get(x).get(y));
			squareMatrix.get(x).set(y, 0);
			
			int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
			
			if (nextX < 0 || nextX >= squareMatrix.size() || nextY < 0 || nextY >= squareMatrix.size()
					|| squareMatrix.get(nextX).get(nextY) == 0) {
				
				dir = (dir + 1) % 4;
				nextX = x + SHIFT[dir][0];
				nextY = y + SHIFT[dir][1];
			}
			
			x = nextX;
			y = nextY;
		}
		return spiralOrdering;
	}

}
