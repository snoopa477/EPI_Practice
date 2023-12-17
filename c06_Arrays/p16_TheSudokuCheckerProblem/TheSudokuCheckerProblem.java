package c06_Arrays.p16_TheSudokuCheckerProblem;
import static java.lang.System.out;

import java.util.List;
public class TheSudokuCheckerProblem {

	
	private static int TOTAL_NUMBER_OF_ELEMENTS = 10;
	private static int BOARD_WIDTH = 9;
	
	private static final int EXISTENT = 1;
	private static final int NON_EXISTENT = 0;
	
	private static final int SMALL_SQUARE_WIDTH = 3;
	
	private static class Rectangle{
		public int start_Row;
		public int start_Column;
		public int end_Row;
		public int end_Column;
		
		
		public Rectangle(int start_Row, int start_Column, int end_Row, int end_Column) {
			super();
			this.start_Row = start_Row;
			this.start_Column = start_Column;
			this.end_Row = end_Row;
			this.end_Column = end_Column;
		}
	}
	
	
	
	public static boolean isValidSudoku(List<List<Integer>> board) {
		
		/**
		 * PURPOSE
		 * step 1: check whole role
		 * step 2: check whole columns
		 * step 3: check all 9 squares 
		 */
		
		//step 1
		//for( int i = 0; i < BOARD_WIDTH; i++ ) {
		//Better naming I think
		for( int start_Row = 0; start_Row < BOARD_WIDTH; start_Row++ ) {
			Rectangle wholeRow = new Rectangle(start_Row, 0, start_Row + 1, BOARD_WIDTH);
			if( isSqureHasDuplicateElements( board, wholeRow ) ) {
				return false;
			}
		}
		
		
		//step 2
		for( int start_Column = 0; start_Column < BOARD_WIDTH; start_Column++ ) {
			Rectangle wholeColumn = new Rectangle(0, start_Column ,BOARD_WIDTH, start_Column + 1);
			if( isSqureHasDuplicateElements( board, wholeColumn ) ) {
				return false;
			}
		}
		
		
		//step 3
		//for( int i = 0; i < BOARD_WIDTH - SMALL_SQUARE_WIDTH; i+= SMALL_SQUARE_WIDTH ) {
		
		//Wrong, in this case the bottom square part would be ignored
		//for( int start_Row = 0; start_Row < BOARD_WIDTH - SMALL_SQUARE_WIDTH; start_Row += SMALL_SQUARE_WIDTH ) {
		for( int start_Row = 0; start_Row <= BOARD_WIDTH - SMALL_SQUARE_WIDTH; start_Row += SMALL_SQUARE_WIDTH ) {
			
			//Wrong, in this case the rightmost square part would be ignored
			//for( int start_Column = 0; start_Column < BOARD_WIDTH - SMALL_SQUARE_WIDTH; start_Column += SMALL_SQUARE_WIDTH ) {
			for( int start_Column = 0; start_Column <= BOARD_WIDTH - SMALL_SQUARE_WIDTH; start_Column += SMALL_SQUARE_WIDTH ) {
				
				Rectangle wholeColumn = new Rectangle(start_Row, start_Column ,start_Row + SMALL_SQUARE_WIDTH, start_Column + SMALL_SQUARE_WIDTH);
				if( isSqureHasDuplicateElements( board, wholeColumn ) ) {
					return false;
				}
				
			}
		}

		
		return true;
	}
	
	
	
	private static boolean isSqureHasDuplicateElements( List<List<Integer>> board, Rectangle rectangle) {
		
		int[] elementValueToExistence = new int[TOTAL_NUMBER_OF_ELEMENTS];
		
		for( int i = rectangle.start_Row; i < rectangle.end_Row; i++ ) {
			for( int j = rectangle.start_Column; j < rectangle.end_Column; j++ ) {
				
				int value = board.get(i).get(j);
				if( value != 0 && elementValueToExistence[ value ] == EXISTENT ) {
					return true;
				}
				else {
					elementValueToExistence[ value ] = EXISTENT;
				}
				
			}
		}
		return false;
	}
}


