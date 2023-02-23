package c16_Recursion.p06_GenerateStringsOfMatchedParens;

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

public class _1606_GenerateStringsOfMatchedParens {

	public static List<String> generateBalancedParentheses(int numPairs) {
		List<String> result = new ArrayList<>();
		directedGenerateBalancedParentheses(numPairs, numPairs, "", result);
		return result;
	}

	private static void directedGenerateBalancedParentheses(int numLeftParensNeeded, int numRightParensNeeded,
			String validPrefix, List<String> result) {
		if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
			result.add(validPrefix);
			return;
		}
		if (numLeftParensNeeded > 0) { // Able to insert '('
			directedGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded, validPrefix + "(",
					result);
		}
		if (numLeftParensNeeded < numRightParensNeeded) { // Able to insert ')'.
			directedGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1, validPrefix + ")",
					result);
		}
	}
}
