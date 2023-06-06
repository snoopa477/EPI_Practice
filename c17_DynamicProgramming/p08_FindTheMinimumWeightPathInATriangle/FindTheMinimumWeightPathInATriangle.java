package c17_DynamicProgramming.p08_FindTheMinimumWeightPathInATriangle;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FindTheMinimumWeightPathInATriangle {

	public static int minimumPathTotal(List<List<Integer>> triangle) {
		
		//WRONG: it set initCapcity; however, the length is still 0. 
		//will get IndexOutOfBoundsException: Index 0 out of bounds for length 0 when calling 'set' method 
//		List<Integer> prevMinimumPaths = new ArrayList<>( 1 ) ;
		
		//DETAIL: return List<Integer> a collection. including size and values
		List<Integer> prevMinimumPaths = new ArrayList<>( triangle.get(0) ) ;
		
		//i = 0, there's no prevMinPaths to reference; and now prevMinmumPaths is prepared for next round: i = 1
		//REASONING: node need, value is already set when calling constructor
		//prevMinimumPaths.set( 0, triangle.get( 0 ).get( 0 ) );
		
		//i for row, j for col
		for( int i = 1; i < triangle.size(); i++ ) {
			
			//PURPOSE: fill the 'currentMinimumPaths' based on 'prevMinimumPaths'
			
			int rowSize = triangle.get(i).size();
			List<Integer> currentRow = triangle.get(i);
			//WRONG: it set initCapcity; however, the length is still 0
			//List<Integer> currentMinimumPaths = new ArrayList<>( rowSize );
			List<Integer> currentMinimumPaths = new ArrayList<>( currentRow );
			
			
			//PURPOSE step 1: first col, there could only one path, which is from right hand. No Math.Min is needed
			currentMinimumPaths.set( 0 ,  
				prevMinimumPaths.get( right( 0 ) ) + currentRow.get( 0 ) );
			//  this works fine too
			//	prevMinimumPaths.get( right( 0 ) ) + currentMinimumPaths.get( 0 ) );
			
			
			//PURPOSE step 2: neither first or last col
			for( int j = 1; j < rowSize -1; j++ ) {
				//meat: this is wat makes each entry of minPath
				int minPathFromAbove = Math.min( prevMinimumPaths.get( left( j ) ), prevMinimumPaths.get( right( j ) ) );
				currentMinimumPaths.set( j, 
					minPathFromAbove + currentRow.get( j ));
			}
			
			
			//PURPOSE step 3: last col, there could only one path, which is from left hand. No Math.Min is needed
			int lastCol = rowSize -1;
			currentMinimumPaths.set( lastCol ,  
					prevMinimumPaths.get( left( lastCol ) ) + currentRow.get( lastCol ) );
			
			//reaching here meaning the curretRow is already filled
			
			//prepare for the next round
			prevMinimumPaths = currentMinimumPaths;
		}
		
		
		return Collections.min(prevMinimumPaths);
	}
	
	
	
	private static int right( int i ) {
		return i;
	}
	
	
	
	private static int left( int i ) {
		return i -1;
	}
}


