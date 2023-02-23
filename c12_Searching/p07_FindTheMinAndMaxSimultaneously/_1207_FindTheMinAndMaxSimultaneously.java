package c12_Searching.p07_FindTheMinAndMaxSimultaneously;

import static java.lang.System.out;
import java.util.List;

public class _1207_FindTheMinAndMaxSimultaneously {

	private static class MinMax {
		public Integer min;
		public Integer max;

		public MinMax(Integer min, Integer max) {
			this.min = min;
			this.max = max;
		}

		private static MinMax minMax(Integer a, Integer b) {
			return Integer.compare(b, a) < 0 ? new MinMax(b, a) : new MinMax(a, b);
		}
	}

	public static MinMax findMinMax(List<Integer> A) {
		if (A.size() <= 1) {
			return new MinMax(A.get(0), A.get(0));
		}
		MinMax globalMinMax = MinMax.minMax(A.get(0), A.get(1));
// Process two elements at a time.
		for (int i = 2; i + 1 < A.size(); i += 2) {
			MinMax localMinMax = MinMax.minMax(A.get(i), A.get(i + 1));
			globalMinMax = new MinMax(Math.min(globalMinMax.min, localMinMax.min),
					Math.max(globalMinMax.max, localMinMax.max));
		}
// If there is odd number of elements in the array, we still
// need to compare the last element with the existing answer.
		if ((A.size() % 2) != 0) {
			globalMinMax = new MinMax(Math.min(globalMinMax.min, A.get(A.size() - 1)),
					Math.max(globalMinMax.max, A.get(A.size() - 1)));
		}
		return globalMinMax;
	}
}
