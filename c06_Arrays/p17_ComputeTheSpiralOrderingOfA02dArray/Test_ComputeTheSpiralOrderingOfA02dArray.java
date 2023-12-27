package c06_Arrays.p17_ComputeTheSpiralOrderingOfA02dArray;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
public class Test_ComputeTheSpiralOrderingOfA02dArray {

	public static void main(String[] args) {
		
		out.println("------------------------------------------------------ ComputeTheSpiralOrderingOfA02dArray_01_Circle");
		
		List<List<Integer>> squareMatrix02 = getSquareMatrix(2);
		out.println( ComputeTheSpiralOrderingOfA02dArray_01_Circle.matrixInSpiralOrder(squareMatrix02) );
		
		List<List<Integer>> squareMatrix03 = getSquareMatrix(3);
		out.println( ComputeTheSpiralOrderingOfA02dArray_01_Circle.matrixInSpiralOrder(squareMatrix03) );
		
		List<List<Integer>> squareMatrix04 = getSquareMatrix(4);
		out.println( ComputeTheSpiralOrderingOfA02dArray_01_Circle.matrixInSpiralOrder(squareMatrix04) );
		
		List<List<Integer>> squareMatrix05 = getSquareMatrix(5);
		out.println( ComputeTheSpiralOrderingOfA02dArray_01_Circle.matrixInSpiralOrder(squareMatrix05) );
		
		
		out.println("------------------------------------------------------ ComputeTheSpiralOrderingOfA02dArray_02_Obstacle");
		
		out.println( ComputeTheSpiralOrderingOfA02dArray_02_Obstacle.matrixInSpiralOrder(squareMatrix02) );
		
		out.println( ComputeTheSpiralOrderingOfA02dArray_02_Obstacle.matrixInSpiralOrder(squareMatrix03) );
		
		out.println( ComputeTheSpiralOrderingOfA02dArray_02_Obstacle.matrixInSpiralOrder(squareMatrix04) );
		
		out.println( ComputeTheSpiralOrderingOfA02dArray_02_Obstacle.matrixInSpiralOrder(squareMatrix05) );
	}
	
	
	
	private static List<List<Integer>> getSquareMatrix(int width){
		
		List<List<Integer>> squareMatrix = new ArrayList<>();
		
		int counter = 1;
		for( int i = 0; i < width; i++ ) {
			squareMatrix.add( new ArrayList<>() );
			for( int j = 0; j < width; j++ ) {
				squareMatrix.get(i).add( counter );
				counter++;
			}
		}
		
		return squareMatrix;
	}
	
	
	

}


