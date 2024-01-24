package c06_Arrays.p19_ComputeRowsInPascalTriangle;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ComputeRowsInPascalTriangle_02 {

	
	public static List<List<Integer>> generatePascalTriangle(int numRows) {
			
		List<List<Integer>> pascalTriangle = new ArrayList<>();
		
		//Init
		pascalTriangle.add( new ArrayList<>( Arrays.asList(1) ) );
		
		//second row and so on
		for( int row = 1; row < numRows; row++ ) {
			
			List<Integer> currentRow = new ArrayList<>();
			pascalTriangle.add( currentRow );
			
			//completion of a row
			for( int col = 0; col <= row; col++ ) {
				int leftValue = isAboveExist(row, col)? valueFromAbove( row, col, pascalTriangle ) : 0;
				int aboveValue = isAboveLeftExist(row, col)? valueFromAboveLeft( row, col, pascalTriangle ) : 0;
				
				int currValue = leftValue + aboveValue;
				currentRow.add( currValue );
			}
			
		}
		return pascalTriangle;
	}
	
	
	/* 
	 * given the fact that col is never larger than row, so that it forms a triangle; 
	 * however, when col == row, that means above that grid there's no above, because the current row's length is larger than previous one by one
	 * 
	 */
	private static boolean isAboveExist( int row, int col ) {
		//WRONG if rightmost element trying to access it's above, which is not existent
		//return row > 0;
		return col < row ;
	}
	
	
	
	
	private static boolean isAboveLeftExist( int row, int col ) {
		return col > 0 && row > 0;
	}
	
	
	
	private static int valueFromAboveLeft( int row, int col, List<List<Integer>> pascalTriangle ) {
		return pascalTriangle.get( row - 1 ).get( col - 1 );
	}
	
	
	
	private static int valueFromAbove( int row, int col, List<List<Integer>> pascalTriangle ) {
		return pascalTriangle.get( row - 1).get( col );
	}
	
	
}


