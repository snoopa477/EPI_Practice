package c17_DynamicProgramming.p05_SearchForASequenceInA02dArray;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Test_SearchForASequenceInA02dArray {

	public static void main(String[] args) {
		
		List<List<Integer>> patterns = new ArrayList<>();
		patterns.add( Arrays.asList( 7, 4, 5, 3, 5, 9, 6) );
		patterns.add( Arrays.asList( 7, 4, 5, 3, 5, 9, 7) );
		patterns.add( Arrays.asList( 7, 8, 6) );
		
		List<List<Integer>> grid = getGrid();
		
		
		for( int i = 0; i < patterns.size(); i++ ) {
			out.println( patterns.get(i) );
			out.println( SearchForASequenceInA02dArray.isPatternContainedInGrid(grid, patterns.get(i)) );
			out.println();
		}
		
	}
	
	
	
	public static List<List<Integer>> getGrid(){
		
		List<List<Integer>> grid = new ArrayList<>();
		//https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java
		//alternative
		//grid.add( Arrays.asList( 1, 5, 3, 7, 3)  );
		grid.add( Arrays.stream( new int[] { 1, 5, 3, 7, 3 }).boxed().collect(Collectors.toList()) );
		grid.add( Arrays.stream( new int[] { 7, 4, 5, 8, 6 }).boxed().collect(Collectors.toList()) );
		grid.add( Arrays.stream( new int[] { 4, 5, 3, 5, 9 }).boxed().collect(Collectors.toList()) );
		
		return grid;
	}
	

}


