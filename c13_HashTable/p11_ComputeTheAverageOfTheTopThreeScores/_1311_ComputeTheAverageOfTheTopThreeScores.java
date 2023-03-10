package c13_HashTable.p11_ComputeTheAverageOfTheTopThreeScores;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class _1311_ComputeTheAverageOfTheTopThreeScores {

	public static String findStudentWithHighestBestOfThreeScores(Iterator<Object> nameScoreData) {
		Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();
		while (nameScoreData.hasNext()) {

			String name = (String) nameScoreData.next();
			Integer score = (Integer) nameScoreData.next();
			PriorityQueue<Integer> scores = studentScores.get(name);
			if (scores == null) {
				scores = new PriorityQueue<>();
				studentScores.put(name, scores);
			}
			scores.add(score);
			if (scores.size() > 3) {
				scores.poll(); // Only keep the top 3 scores.
			}

		}
		String topStudent = "no such student";
		int currentTopThreeScoresSum = 0;
		for (Map.Entry<String, PriorityQueue<Integer>> scores : studentScores.entrySet()) {
			if (scores.getValue().size() == 3) {
				int currentScoresSum = getTopThreeScoresSum(scores.getValue());
				if (currentScoresSum > currentTopThreeScoresSum) {
					currentTopThreeScoresSum = currentScoresSum;
					topStudent = scores.getKey();
				}
			}
		}
		return topStudent;
	}

// Returns the sum of top three scores.
	private static int getTopThreeScoresSum(PriorityQueue<Integer> scores) {
		Iterator<Integer> it = scores.iterator();
		int result = 0;
		while (it.hasNext()) {
			result += it.next();
		}
		return result;
	}
}
