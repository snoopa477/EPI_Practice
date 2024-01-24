package c06_Arrays.p19_ComputeRowsInPascalTriangle;
import static java.lang.System.out;

import java.util.List;
public class Test_ComputeRowsInPascalTriangle {

	
	public static void main(String[] args) {
		
		{
			ComputeRowsInPascalTriangle_01.IS_DEBUG = true;
			List<List<Integer>> pascalTriangle = ComputeRowsInPascalTriangle_01.generatePascalTriangle(4);
			printSquareTriangle( pascalTriangle );
			out.println();
		}
		
		
		{
			List<List<Integer>> pascalTriangle = ComputeRowsInPascalTriangle_02.generatePascalTriangle(4);
			printSquareTriangle( pascalTriangle );
			out.println();
		}
	}
	
	
	
	private static void printSquareTriangle( List<List<Integer>> triangle ) {
		
		for( int i = 0; i < triangle.size(); i++ ) {
			for( int j = 0; j < triangle.get(i).size(); j++ ) {
				out.printf("%3d", triangle.get(i).get(j));
			}
			out.println();
		}
		
	}
}


