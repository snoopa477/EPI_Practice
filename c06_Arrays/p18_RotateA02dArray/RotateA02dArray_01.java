package c06_Arrays.p18_RotateA02dArray;
import static java.lang.System.out;

import java.util.List;
public class RotateA02dArray_01 {
	
	public static void rotateMatrix(List<List<Integer>> squareMatrix) {
		
		int matrixLastIndex = squareMatrix.size() -1 ;
		for( int startingPoint_offset = 0; startingPoint_offset <= matrixLastIndex / 2; startingPoint_offset++ ) {
			
			//every iteration, both left bound and right bound shrink by 1, so vector length -2
			for( int vector_offset = 0; vector_offset < matrixLastIndex - 2 * startingPoint_offset; vector_offset++  ) {
				
				int tempLeftValue = getUpLeftValue( squareMatrix, startingPoint_offset, vector_offset );
				
				setUpLeftValue(squareMatrix, startingPoint_offset, vector_offset, 
					getDownLeftValue(squareMatrix, startingPoint_offset, vector_offset));
				
				setDownLeftValue(squareMatrix, startingPoint_offset, vector_offset, 
					getDownRightValue(squareMatrix, startingPoint_offset, vector_offset));
				
				setDownRightValue(squareMatrix, startingPoint_offset, vector_offset,
					getUpRightValue(squareMatrix, startingPoint_offset, vector_offset));
				
				setUpRightValue(squareMatrix, startingPoint_offset, vector_offset, 
					tempLeftValue);
			}
		}
		
		
	}
	
	
	/**
	 * IMAGINATION
	 * 0(left bound) + startingPoint_offset(go right)
	 * lastIndex(right bound) - startingPoint_offset(go left)
	 */
	private static int getUpLeftValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset ) {
		return squareMatrix
			.get( 0 + startingPoint_offset )
			.get( 0 + startingPoint_offset + vector_offset );
	}
	
	
	
	private static int getUpRightValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset  ) {
		int lastIndex = squareMatrix.size() -1 ; 
		return squareMatrix
			.get( 0 + startingPoint_offset + vector_offset )
			.get( lastIndex - startingPoint_offset );
	}
	
	
	
	private static int getDownLeftValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset  ) {
		int lastIndex = squareMatrix.size() -1 ; 
		return squareMatrix
			.get( lastIndex - startingPoint_offset - vector_offset )
			.get( 0 + startingPoint_offset );
	}
	
	
	
	private static int getDownRightValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset  ) {
		int lastIndex = squareMatrix.size() -1 ; 
		return squareMatrix
			.get( lastIndex - startingPoint_offset )
			.get( lastIndex - startingPoint_offset - vector_offset );
	}
	
	
	
	private static void setUpLeftValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset, int value  ) {
		squareMatrix
		.get( 0 + startingPoint_offset )
		.set( 0 + startingPoint_offset + vector_offset, value );
	}
	
	
	
	private static void setUpRightValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset, int value  ) {
		int lastIndex = squareMatrix.size() -1 ; 
		squareMatrix
			.get( 0 + startingPoint_offset + vector_offset )
			.set( lastIndex - startingPoint_offset, value );
	}
	
	
	
	private static void setDownLeftValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset, int value  ) {
		int lastIndex = squareMatrix.size() -1 ; 
		squareMatrix
			.get( lastIndex - startingPoint_offset - vector_offset )
			.set( 0 + startingPoint_offset, value );
	}
	
	
	
	private static void setDownRightValue( List<List<Integer>> squareMatrix, int startingPoint_offset, int vector_offset, int value ) {
		int lastIndex = squareMatrix.size() -1 ; 
		squareMatrix
			.get( lastIndex - startingPoint_offset )
			.set( lastIndex - startingPoint_offset - vector_offset, value );
	}
}


