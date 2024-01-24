package c06_Arrays.p18_RotateA02dArray;
import static java.lang.System.out;

import java.util.List;
public class RotateA02dArray_02_LazyAndFew {
	
	private List<List<Integer>> originalMatrix;
	private int lastElement;

	public RotateA02dArray_02_LazyAndFew(List<List<Integer>> originalMatrix) {
		this.originalMatrix = originalMatrix;
		this.lastElement = originalMatrix.size() -1;
	}
	
	
	
	//PURPOSE: do the rotate only when setting or getting that element
	public int get(int row, int col) {
		return originalMatrix.get( lastElement - col ).get( row );
	}
	
	
	
	public int set(int row, int col, int key) {
		return originalMatrix.get( lastElement - col ).set( row, key );
	}

}


