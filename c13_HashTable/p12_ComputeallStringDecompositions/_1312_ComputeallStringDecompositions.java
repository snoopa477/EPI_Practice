package c13_HashTable.p12_ComputeallStringDecompositions;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _1312_ComputeallStringDecompositions {

	public static List<Integer> findAHSubstrings(String s, List<String> words) {
		Map<String, Integer> wordToFreq = new HashMap<>();
		for (String word : words) {
			increment(word, wordToFreq);
		}
		int unitSize = words.get(0).length();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i + unitSize * words.size() <= s.length(); ++i) {
			if (matchAHWordsInDict(s, wordToFreq, i, words.size(), unitSize)) {
				result.add(i);
			}
		}
		return result;
	}

	private static boolean matchAHWordsInDict(String s, Map<String, Integer> wordToFreq, int start, int numWords,
			int unitSize) {
		Map<String, Integer> currStringToFreq = new HashMap<>();
		for (int i = 0; i < numWords; ++i) {
			String currWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
			Integer freq = wordToFreq.get(currWord);
			if (freq == null) {
				return false;
			}
			increment(currWord, currStringToFreq);
			if (currStringToFreq.get(currWord) > freq) {
// currWord occurs too many times for a match to be possible.
				return false;
			}
		}
		return true;

	}

	private static void increment(String word, Map<String, Integer> diet) {
		Integer count = diet.get(word);
		if (count == null) {
			count = 0;
		}
		count++;
		diet.put(word, count);
	}
}
