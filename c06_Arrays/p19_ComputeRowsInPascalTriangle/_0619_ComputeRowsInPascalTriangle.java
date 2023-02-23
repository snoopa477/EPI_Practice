package c06_Arrays.p19_ComputeRowsInPascalTriangle;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0619_ComputeRowsInPascalTriangle {

	public static List<List<Integer>> generatePascalTriangle(int numRows) {
		List<List<Integer>> pascalTriangle = new ArrayList<>();
		for (int i = 0; i < numRows; ++i) {
			List<Integer> currRow = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
// Set this entry to the sum of the two above adjacent entries if they
// exist.
				currRow.add(
						(0 < j && j < i) ? pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j) : 1);
			}
			pascalTriangle.add(currRow);
		}

		return pascalTriangle;

	}
}
