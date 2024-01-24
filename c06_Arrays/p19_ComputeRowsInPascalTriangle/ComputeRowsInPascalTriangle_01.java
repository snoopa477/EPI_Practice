package c06_Arrays.p19_ComputeRowsInPascalTriangle;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
public class ComputeRowsInPascalTriangle_01 {
	
	private static final int BOUNDARY_VALUE = 1;
	
	public static boolean IS_DEBUG = false;
	
	public static List<List<Integer>> generatePascalTriangle(int numRows) {
		
		List<List<Integer>> pascalTriangle = new ArrayList<>();
		
		for( int row = 0; row < numRows; row++ ) {
			
			//pascalTriangle.add( new ArrayList<>() );
			//this would be better, cuz when we try to access this list, we don't have to specify the last one
			List<Integer> currentRow = new ArrayList<>();
			
			
			/* IMAGINATION
			 *  given currValue = valueFromAbove(  row, col, pascalTriangle) + valueFromLeft(  row, col, pascalTriangle); 
			 *  this line should be put here
			 * */
			//pascalTriangle.add( currentRow );
			
			//col is never larger than row index, so it forms a triangle
			//PURPOSE: completion of a width of a certain row
			for( int col = 0; col <= row; col++ ) {
				
				int currValue = 0;
				
				//tricky part: must exist before access and compute it. can only think of indexes now, since element not exist yet
				//THINK_FURTHER: the node on the boundary, doesn't have either above or left to add up
				if( isBoundary(row, col) ) {
					currValue = BOUNDARY_VALUE;
				}
				else {
					//stupid mistake
					//currValue = valueFromAbove( col, row, pascalTriangle) + valueFromLeft( col, row, pascalTriangle);
					//currValue = valueFromAbove(  row, col, pascalTriangle) + valueFromLeft(  row, col, pascalTriangle);
					currValue = valueFromAbove(  row, col, pascalTriangle) + valueFromLeftAbove(  row, col, pascalTriangle);
				}
				
				currentRow.add(currValue);
				
			}
			
			/*WRONG IMAGINATION
			 * given currValue = valueFromAbove(  row, col, pascalTriangle) + valueFromLeft(  row, col, pascalTriangle); 
			 * if I put here. cannot add current row to pascalTriangle when entire iteration finished, because in that case how can I access left side by indexing pascalTriangle?
			 I need to access currentRow in pascalTriangle.
			 */
			pascalTriangle.add( currentRow );
			
		}
		
		return pascalTriangle;
	}
	
	
	
	private static boolean isBoundary( int row, int col ) {
		
		boolean isLeftBoundary = col == 0;
		boolean isRightBoundary = row == col;
		
		return isLeftBoundary || isRightBoundary;
	}
	
	
	
	private static int valueFromAbove( int row, int col, List<List<Integer>> pascalTriangle ) {
		return pascalTriangle.get( row - 1 ).get( col );
	}
	
	
	
	private static int valueFromLeftAbove( int row, int col, List<List<Integer>> pascalTriangle ) {
		return pascalTriangle.get( row - 1 ).get( col - 1 );
	}

}


