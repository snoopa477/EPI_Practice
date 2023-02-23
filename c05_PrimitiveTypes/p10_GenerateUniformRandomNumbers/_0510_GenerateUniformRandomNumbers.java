package c05_PrimitiveTypes.p10_GenerateUniformRandomNumbers;

import static java.lang.System.out;

public class _0510_GenerateUniformRandomNumbers {

	public static int uniformRandom(int lowerBound, int upperBound) {
		int numberOfOutcomes = upperBound - lowerBound + 1, result;
		do {
			result = 0;
			for (int i = 0; (1 << i) < numberOfOutcomes; ++i) {
// zeroOneRandom() is the provided random number generator.
				result = (result << 1) | zeroOneRandom();
			}
		} while (result >= numberOfOutcomes);
		return result + lowerBound;
	}
}
