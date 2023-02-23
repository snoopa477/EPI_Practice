package c18_GreedyAlgorithms.p06_TheGasupProblem;

import static java.lang.System.out;

import java.util.List;

public class _1806_TheGasupProblem {

	private static class CityAndRemainingGas {
		public Integer city;
		public Integer remainingGallons;

		public CityAndRemainingGas(Integer city, Integer remainingGallons) {
			this.city = city;
			this.remainingGallons = remainingGallons;
		}
	}

	private static final int MPG = 20;
// gallons[ij is the amount of gas in city i, and distances[i] is the distance

// city i to the next city.
	public static int findAmpleCity(List<Integer> gallons, List<Integer> distances) {
		int remainingGallons = 0;
		CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
		final int numCities = gallons.size();
		for (int i = 1; i < numCities; ++i) {
			remainingGallons += gallons.get(i - 1) - distances.get(i - 1) / MPG;
			if (remainingGallons < min.remainingGallons) {
				min = new CityAndRemainingGas(i, remainingGallons);
			}
		}
		return min.city;

	}
}
