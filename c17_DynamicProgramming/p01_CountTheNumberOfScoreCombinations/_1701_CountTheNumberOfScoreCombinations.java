package c17_DynamicProgramming.p01_CountTheNumberOfScoreCombinations;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1701_CountTheNumberOfScoreCombinations {

	public static int numCombinationsForFinalScore(int finalScore, List<Integer> individualPlayScores) {
		int[][] numCombinationsForScore = new int[individualPlayScores.size()][finalScore + 1];
		for (int i = 0; i < individualPlayScores.size(); ++i) {
			numCombinationsForScore[i][0] = 1; // One way to reach (9.
			for (int j = 1; j <= finalScore; ++j) {
				int withoutThisPlay = i - 1 >= 0 ? numCombinationsForScore[i - 1][j] : 0;
				int withThisPlay = j >= individualPlayScores.get(i)
						? numCombinationsForScore[i][j - individualPlayScores.get(i)]
						: 0;
				numCombinationsForScore[i][j] = withoutThisPlay + withThisPlay;
			}
		}
		return numCombinationsForScore[individualPlayScores.size() - 1][finalScore];
	}
}
