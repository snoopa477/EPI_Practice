package c17_DynamicProgramming.p05_SearchForASequenceInA02dArray;
import static java.lang.System.out;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
public class SearchForASequenceInA02dArray {
	
	private static int UP = -1;
	private static int DOWN = 1;
	
	private static int LEFT = -1;
	private static int RIGHT = 1;
	
	/**
	 * PURPOSE:
	 * if all the subcalls from 'patternIndex' fail, we will record this 'patternIndex' in this instance of the class
	 * meaning the following index, which is greater than 'patternIndex' doesn't work out
	 * so next time we see this, we can skip this part, because we've already tried
	 */
	static class FailedCase{
		
		public int row;
		public int col;
		//the sub call with the index, which is > patternInex are all failed
		public int patternIndex;
		
		
		public FailedCase(int row, int col, int patternIndex) {
			super();
			this.row = row;
			this.col = col;
			this.patternIndex = patternIndex;
		}


		/**
		 * PURPOSE:
		 * to use HashSet, implement equal and hashCode 
		 */
		@Override
		public boolean equals( Object o ) {
			return false;
		}
		
		
		@Override
		public int hashCode() {
			return Objects.hash( row, col, patternIndex );
		}
		
	}
	
	
	
	public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {
		
		Set<FailedCase> failedCases = new HashSet<>();
		
		
		//try every entry as a starting point
		int height = grid.size();
		int width = grid.get(0).size();
		
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++) {
				
				boolean result = match( failedCases, grid, i, j, pattern, 0 );
				if( result == true ) {
					return true;
				}
			}
		}
		
		//non of the entries work
		return false;
	}
	
	
	
	private static boolean match( Set<FailedCase> failedCases, List<List<Integer>> grid, int row, int col, List<Integer> pattern, int patternIndex ) {
		
		//REASONING: the means all indices match, before it can reach here
		if( patternIndex == pattern.size() ) {
			return true;
		}
		
		/*We call it success when: 
		 * 1. the current value match with grid
		 * 2. the sub call returns true, which means currentIndex and the following are all successful
		 */
		//THINK_FURTHER: reaching to currentIndex, meaning the index before it are all successful
		
		//if( isWithinBoundary(grid, row, col) ) {
		
		if( isWithinBoundary(grid, row, col) == false) {
			return false;
		}
		
		//THINK_FURTHER why don't we put it to set right after boundary? We could have, but not necessary, cuz these computations are cheap.
		
		
		//if we already tried and failed, return false
		//THINK_FURTHER: if we tried and success, we directly return true and ends program. no bother to store it in set
		//DETAIL: use equal and hashCode to determine if two objects are equal, instead of its reference.
		if( failedCases.contains( new FailedCase(row, col, patternIndex) ) ) {
			return false;
		}
		
		
		//PURPOSE step 1
		int gridValue = grid.get(row).get(col);
		int patternValue = pattern.get(patternIndex);
		
		//current operation
		//don't want nesting
		//if( gridValue == patternValue ) {
		if( gridValue != patternValue ) {
			return false;
		}
		
		
		//PURPOSE step 2
		if(    match( failedCases, grid, row + UP  , col        , pattern, patternIndex + 1 )
			|| match( failedCases, grid, row + DOWN, col        , pattern, patternIndex + 1 )
			|| match( failedCases, grid, row       , col + LEFT , pattern, patternIndex + 1 )
			|| match( failedCases, grid, row       , col + RIGHT, pattern, patternIndex + 1 ) ) {
			return true;
		}
			
		
		/*REASONING
		 * reaching here meaning none of the above true, so ...
		 * we've tried all options still not work 
		 * => mark this step as failed
		 * 
		 *  in the future, don't bother re-compute this step again, saving some computation
		 */
		failedCases.add( new FailedCase(row, col, patternIndex) );
		
		
		return false;
	}
	
	
	
	private static boolean isWithinBoundary( List<List<Integer>> grid, int row, int col ) {
		
		int height = grid.size();
		int width = grid.get(0).size();
		return row >= 0 && row < height 
				&& col >= 0 && col < width;
	}
	
}




