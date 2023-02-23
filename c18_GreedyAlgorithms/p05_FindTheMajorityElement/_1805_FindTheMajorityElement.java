package c18_GreedyAlgorithms.p05_FindTheMajorityElement;

import static java.lang.System.out;

import java.util.Iterator;

public class _1805_FindTheMajorityElement {

	public static String majoritySearch(Iterator<String> sequence) {
		String candidate = "";
		String iter;
		int candidateCount = 0;
		while (sequence.hasNext()) {
			iter = sequence.next();
			if (candidateCount == 0) {
				candidate = iter;
				candidateCount = 1;
			} else if (candidate.equals(iter)) {
				++candidateCount;
			} else {
				--candidateCount;
			}
		}
		return candidate;
	}
}
