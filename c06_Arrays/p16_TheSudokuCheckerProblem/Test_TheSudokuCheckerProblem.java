package c06_Arrays.p16_TheSudokuCheckerProblem;
import static java.lang.System.out;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Test_TheSudokuCheckerProblem {

	public static void main(String[] args) {
		
		out.println( TheSudokuCheckerProblem.isValidSudoku(getValidBoard01()) );
		out.println( TheSudokuCheckerProblem.isValidSudoku(getInValidBoard_Row7_Col5_violateSquare() ) );
		out.println( TheSudokuCheckerProblem.isValidSudoku(getInValidBoard_Row5_Col0_violateColumn() ) );
		out.println( TheSudokuCheckerProblem.isValidSudoku(getInValidBoard_Row2_Col7_violateRow() ) );
	}
	
	
	//valid
	//public static List<List<Integer>> getBoard01(){
	public static List<List<Integer>> getValidBoard01(){
		
		//Type mismatch: cannot convert from ArrayList<ArrayList<Integer>> to List<List<Integer>>
		//List<List<Integer>> board = new ArrayList<ArrayList<Integer>>();
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		
		//                       0  1  2  3  4  5  6  7  8
		board.add( Arrays.asList(5, 4, 0, 0, 7, 0, 0, 0, 0) ); //row 0
		board.add( Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0) ); //row 1
		board.add( Arrays.asList(0, 1, 8, 0, 0, 0, 0, 6, 0) ); //row 2
		board.add( Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3) ); //row 3
		board.add( Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1) ); //row 4
		board.add( Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6) ); //row 5
		board.add( Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0) ); //row 6
		board.add( Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5) ); //row 7
		board.add( Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9) ); //row 8
		
		return board;
	}
	
	
	
	//invalid in small square, at (7,5)
	//public static List<List<Integer>> getBoard02(){
	public static List<List<Integer>> getInValidBoard_Row7_Col5_violateSquare(){
		
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		
		//                       0  1  2  3  4  5  6  7  8
		board.add( Arrays.asList(5, 4, 0, 0, 7, 0, 0, 0, 0) ); //row 0
		board.add( Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0) ); //row 1
		board.add( Arrays.asList(0, 1, 8, 0, 0, 0, 0, 6, 0) ); //row 2
		board.add( Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3) ); //row 3
		board.add( Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1) ); //row 4
		board.add( Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6) ); //row 5
		board.add( Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0) ); //row 6
		board.add( Arrays.asList(0, 0, 0, 4, 1, 8, 0, 0, 5) ); //row 7
		board.add( Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9) ); //row 8
		
		return board;
	}
	
	
	
	//invalid in column, at (5,0)
	public static List<List<Integer>> getInValidBoard_Row5_Col0_violateColumn(){
		
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		
		//                       0  1  2  3  4  5  6  7  8
		board.add( Arrays.asList(5, 4, 0, 0, 7, 0, 0, 0, 0) ); //row 0
		board.add( Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0) ); //row 1
		board.add( Arrays.asList(0, 1, 8, 0, 0, 0, 0, 6, 0) ); //row 2
		board.add( Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3) ); //row 3
		board.add( Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1) ); //row 4
		board.add( Arrays.asList(6, 0, 0, 0, 2, 0, 0, 0, 6) ); //row 5
		board.add( Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0) ); //row 6
		board.add( Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5) ); //row 7
		board.add( Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9) ); //row 8
		
		return board;
	}
	
	
	
	public static List<List<Integer>> getInValidBoard_Row2_Col7_violateRow(){
		
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		
		//                       0  1  2  3  4  5  6  7  8
		board.add( Arrays.asList(5, 4, 0, 0, 7, 0, 0, 0, 0) ); //row 0
		board.add( Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0) ); //row 1
		board.add( Arrays.asList(0, 1, 8, 0, 0, 0, 0, 8, 0) ); //row 2
		board.add( Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3) ); //row 3
		board.add( Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1) ); //row 4
		board.add( Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6) ); //row 5
		board.add( Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0) ); //row 6
		board.add( Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5) ); //row 7
		board.add( Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9) ); //row 8
		
		return board;
	}

}


