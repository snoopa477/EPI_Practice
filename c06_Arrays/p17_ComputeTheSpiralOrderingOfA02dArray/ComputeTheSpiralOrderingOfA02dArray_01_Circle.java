package c06_Arrays.p17_ComputeTheSpiralOrderingOfA02dArray;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
public class ComputeTheSpiralOrderingOfA02dArray_01_Circle {

	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
		
		List<Integer> spiralOrder = new ArrayList<>();
		
		int width = squareMatrix.size();
		boolean isWidthOdd = width % 2 != 0;
		
		if( isWidthOdd ) {
			int centerIndex = ( width -1 ) / 2;
			//spiral part
			for( int offset = 0; offset < centerIndex; offset++) {
				circleOrder(squareMatrix, offset, spiralOrder);
			}
			//center part
			addCenter(squareMatrix, centerIndex, spiralOrder);
		}
		//even
		else {
			int endIndex = width / 2;
			//spiral part
			for( int offset = 0; offset < endIndex; offset++) {
				circleOrder(squareMatrix, offset, spiralOrder);
			}
			//no center part
		}
		
		return spiralOrder;
	}
	
	
	
	private static void addCenter(List<List<Integer>> squareMatrix, int centerIndex, List<Integer> sprialOrder) {
		sprialOrder.add( squareMatrix.get(centerIndex).get(centerIndex) );
	}
	
	
	
	private static void circleOrder(List<List<Integer>> squareMatrix, int offset, List<Integer> sprialOrder) {
		
		rightOrder(squareMatrix, offset, sprialOrder);
		downOrder(squareMatrix, offset, sprialOrder);
		leftOrder(squareMatrix, offset, sprialOrder);
		upOrder(squareMatrix, offset, sprialOrder);
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


