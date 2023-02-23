package c06_Arrays.p15_GenerateNonuniformRandomNumbers;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class _0615_GenerateNonuniformRandomNumbers {

	public static int nonuniformRandomNumberGenerationC(List<Integer> values, List<Double> probabilities) {
		List<Double> prefixSumOfProbabilities = new ArrayList<>();
		prefixSumOfProbabilities.add(0.0);
// Creating the endpoints for the intervals corresponding to the
// probabilities.
		for (double p : probabilities) {
			prefixSumOfProbabilities.add(prefixSumOfProbabilities.get(prefixSumOfProbabilities.size() - 1) + p);
		}
		Random r = new Random();
// Get a random number in [SI .SI , 1 .SI) .
		final double uniform01 = r.nextDouble();
// Find the index of the interval that uniformSIl lies in.
		int it = Collections.binarySearch(prefixSumOfProbabilities, uniform01);
		if (it < 0) {
// We want the index of the first element in the array which is
// greater than the key.
//
// When a key is not present in the array, Collect ions .binarySearch()
// returns the negative of 1 plus the smallest index whose entry
// is greater than the key.
//

// Therefore , if the return value is negative , by taking its absolute
// value and adding 1 to it , we get the desired index.
			final int intervalldx = (Math.abs(it) - 1) - 1;
			return values.get(intervalldx);
		} else {
// We have it >= (0, i.e., uniformQl equals an entry
// in prefixSumOf Probabilities .
//
// Because we uniformQl is a random double, the probability of it
// equalling an endpoint in prefixSumOf Probabilities is exceedingly low.
// However, it is not (P, so to be robust we must consider this case.
			return values.get(it);
		}

	}
}
