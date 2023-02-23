package c16_Recursion.p07_GeneratePalindromicDecompositions;

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

public class _1607_GeneratePalindromicDecompositions {

	public static List<List<String>> palindromePartitioning(String input) {
		List<List<String>> result = new ArrayList<>();
		directedPalindromePartitioning(input, 0, new ArrayList<String>(), result);
		return result;
	}

	private static void directedPalindromePartitioning(String input, int offset, List<String> partialPartition,
			List<List<String>> result) {
		if (offset == input.length()) {
			result.add(new ArrayList<>(partialPartition));
			return;
		}
		for (int i = offset + 1; i <= input.length(); ++i) {
			String prefix = input.substring(offset, i);
			if (isPalindrome(prefix)) {
				partialPartition.add(prefix);
				directedPalindromePartitioning(input, i, partialPartition, result);
				partialPartition.remove(partialPartition.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String prefix) {
		for (int i = 0, j = prefix.length() - 1; i < j; ++i, --j) {
			if (prefix.charAt(i) != prefix.charAt(j)) {
				return false;
			}

		}
		return true;
	}
}
