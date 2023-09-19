package c06_Arrays.p05_DeleteDuplicatesFromASortedArray;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class Test_DeleteDuplicatesFromASortedArray {

	public static void main(String[] args) {
		
		List<Integer> list01 = Arrays.asList(2,3,5,5,7,11,11,11,13);
		int size = DeleteDuplicatesFromASortedArray.deleteDuplicates(list01);
		
		String str = "";
		for( int i = 0; i < size; i++ ) {
			str += list01.get(i) + " ";
		}
		
		out.println(str);
		
	}

}


