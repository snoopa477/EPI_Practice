package c14_Sorting.p03_RemoveFirstNameDuplicates;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;

public class _1403_RemoveFirstNameDuplicates {

	public static class Name implements Comparable<Name> {
		String firstName;
		String lastName;

		public int compareTo(Name name) {
			int cmpFirst = firstName.compareTo(name.firstName);
			if (cmpFirst != 0) {
				return cmpFirst;

			}
			return lastName.compareTo(name.lastName);

		}

	}

	public static void eliminateDuplicate(List<Name> A) {
		Collections.sort(A); // Makes identical elements become neighbors.
		int result = 0;
		for (int first = 1; first < A.size(); first++) {
			if (!A.get(first).firstName.equals(A.get(result).firstName)) {
				A.set(++result, A.get(first));
			}
		}
// Shrinks array size.
		A.subList(++result, A.size()).clear();

	}
}
