package c06_Arrays.p03_MultiplyTwoArbitraryPrecisionIntegers;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0603_MultiplyTwoArbitraryPrecisionIntegers {

	public static List<Integer> multiply(List<Integer> numl, List<Integer> num2) {
		final int sign = numl.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		numl.set(0, Math.abs(numl.get(0)));
		num2.set(0, Math.abs(num2.get(0)));
		List<Integer> result = new ArrayList<>(Collections.nCopies(numl.size() + num2.size(), 0));
		for (int i = numl.size() - 1; i >= 0; --i) {
			for (int j = num2.size() - 1; j >= 0; --j) {
				result.set(i + j + 1, result.get(i + j + 1) + numl.get(i) * num2.get(j));
				result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
				result.set(i + j + 1, result.get(i + j + 1) % 10);
			}
		}

// Remove the leading zeroes.
		int first_not_zero = 0;
		while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
			++first_not_zero;
		}
		result = result.subList(first_not_zero, result.size());
		if (result.isEmpty()) {
			return Arrays.asList(0);
		}
		result.set(0, result.get(0) * sign);
		return result;
	}

}
