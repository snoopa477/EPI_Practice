package c06_Arrays.p18_RotateA02dArray;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class Test_RotateA02dArray {

	public static void main(String[] args) {
			List<List<Integer>> squareMatrix02 = getSquareMatrix(2);
			List<List<Integer>> squareMatrix03 = getSquareMatrix(3);
			List<List<Integer>> squareMatrix04 = getSquareMatrix(4);
			List<List<Integer>> squareMatrix05 = getSquareMatrix(5);
			
			printSquareMatrix( squareMatrix02 );
			out.println();
			RotateA02dArray_01.rotateMatrix(squareMatrix02);
			printSquareMatrix( squareMatrix02 );
			out.println();
			
			printSquareMatrix( squareMatrix03 );
			out.println();
			RotateA02dArray_01.rotateMatrix(squareMatrix03);
			printSquareMatrix( squareMatrix03 );
			out.println();
			
			printSquareMatrix( squareMatrix04 );
			out.println();
			RotateA02dArray_01.rotateMatrix(squareMatrix04);
			printSquareMatrix( squareMatrix04 );
			out.println();
			
			printSquareMatrix( squareMatrix05 );
			out.println();
			RotateA02dArray_01.rotateMatrix(squareMatrix05);
			printSquareMatrix( squareMatrix05 );
			out.println();
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
	
	
	
	private static void printSquareMatrix( List<List<Integer>> squareMatrix ) {
		
		for( int i = 0; i < squareMatrix.size(); i++ ) {
			for( int j = 0; j < squareMatrix.get(0).size(); j++ ) {
				out.printf("%3d", squareMatrix.get(i).get(j));
			}
			out.println();
		}
		
	}
	
}


