package c07_String.p04_ReplaceAndRemove;

import static java.lang.System.out;

public class _0704_ReplaceAndRemove {

	public static int replaceAndRemove(int size, char[] s) {
// Forward iteration: remove "b"s and count the number of "a"s.
		int writeldx = 0, aCount = 0;
		for (int i = 0; i < size; ++i) {
			if (s[i] != 'b') {
				s[writeldx++] = s[i];

			}

			if (s[i] == 'a') {
				++aCount;
			}

		}

// Backward iteration: replace "a"s with "dd"s starting from the end.
		int curldx = writeldx - 1;
		writeldx = writeldx + aCount - 1;

		final int finalSize = writeldx + 1;
		while (curldx >= 0) {
			if (s[curldx] == 'a') {
				s[writeldx--] = 'd';
				s[writeldx--] = 'd';
			} else {
				s[writeldx--] = s[curldx];
			}
			--curldx;
		}
		return finalSize;
	}
}
