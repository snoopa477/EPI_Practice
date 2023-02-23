package c06_Arrays.p05_DeleteDuplicatesFromASortedArray;

import static java.lang.System.out;

import java.util.List;

public class _0605_DeleteDuplicatesFromASortedArray {

	// .Returns the number of valid entries after deletion.
	public static int deleteDuplicates(List<Integer> A) {
		if (A.isEmpty()) {
			return 0;
		}
		int writelndex = 1;
		for (int i = 1; i < A.size(); ++i) {
			if (!A.get(writelndex - 1).equals(A.get(i))) {
				A.set(writelndex++, A.get(i));
			}
		}
		return writelndex;
	}
}
