package c06_Arrays.p17_ComputeTheSpiralOrderingOfA02dArray;
import static java.lang.System.out;

import java.util.List;
public class ComputeTheSpiralOrderingOfA02dArray {

	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
		
		return null;
	}
	
	
	
	private static void circleOrder(List<List<Integer>> squareMatrix, int offset, List<Integer> sprialOrder) {
		
		
		
	}
	
	
	
	private static void rightOrder(List<List<Integer>> squareMatrix, int offset, List<Integer> sprialOrder) {
		
		//go right(+) by offset units
		int left= 0 + offset;
		//go left(-) by offset units
		int right = squareMatrix.size() -1 - offset;
		int row = 0 + offset;
		
		for( int col = left; col < right; col++ ) {
			sprialOrder.add( squareMatrix.get(row).get(col) );
		}
	}
	
	
	
	private static void downOrder(List<List<Integer>> squareMatrix, int offset, List<Integer> sprialOrder) {
		
		int up = 0 + offset;
		int bottom = squareMatrix.size() -1 - offset;
		//from rightmost to left by offset units
		int col = squareMatrix.size() -1 - offset;
		
		for( int row = up; row < bottom; row++ ) {
			sprialOrder.add( squareMatrix.get(row).get(col) );
		}
	}
	
	
	
	//the opposite of rightOrder
	private static void leftOrder(List<List<Integer>> squareMatrix, int offset, List<Integer> sprialOrder) {
		
		//go right(+) by offset units
		int left= 0 + offset;
		//go left(-) by offset units
		int right = squareMatrix.size() -1 - offset;
		int row = squareMatrix.size() -1 - offset;
		
		for( int col = right; col > left; col-- ) {
			sprialOrder.add( squareMatrix.get(row).get(col) );
		}
	}
	
	
	
	private static void upOrder(List<List<Integer>> squareMatrix, int offset, List<Integer> sprialOrder) {
		
		int up = 0 + offset;
		int bottom = squareMatrix.size() -1 - offset;
		//from rightmost to left by offset units
		int col = 0 + offset;
		
		for( int row = bottom; row > up; row-- ) {
			sprialOrder.add( squareMatrix.get(row).get(col) );
		}
	}
	
}


