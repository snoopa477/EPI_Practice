package c17_DynamicProgramming.p08_FindTheMinimumWeightPathInATriangle;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Test_FindTheMinimumWeightPathInATriangle {

	public static void main(String[] args) {
		
		out.println( FindTheMinimumWeightPathInATriangle.minimumPathTotal( getTriangle17_10() ) );
		
	}
	
	
	
	private static List<List<Integer>> getTriangle17_10(){
		
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add( Stream.of( 2 ).collect( Collectors.toList() ) );
		triangle.add( Stream.of( 4, 4 ).collect( Collectors.toList() ) );
		triangle.add( Stream.of( 8, 5, 6 ).collect( Collectors.toList() ) );
		triangle.add( Stream.of( 4, 2, 6, 2 ).collect( Collectors.toList() ) );
		triangle.add( Stream.of( 1, 5, 2, 3, 4 ).collect( Collectors.toList() ) );
		
		return triangle;
	}

}


