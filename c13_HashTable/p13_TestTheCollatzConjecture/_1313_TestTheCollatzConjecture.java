package c13_HashTable.p13_TestTheCollatzConjecture;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1313_TestTheCollatzConjecture {

	public static boolean testCollatzConjecture(int n) {
// Stores odd numbers already tested to converge to 1.
		Set<Long> verifiedNumbers = new HashSet<>();
// Starts from 3, since hypothesis holds trivially for 1 and 2.
		for (int i = 3; i <= n; i += 2) {
			Set<Long> sequence = new HashSet<>();
			long testl = i;
			while (testl >= i) {
				if (!sequence.add(testl)) {
// We previously encountered testl, so the Collatz sequence
// has fallen into a loop. This disproves the hypothesis, so
// we short-circuit, returning false.
					return false;
				}
				if ((testl % 2) != 0) {// Odd number
					if (!verifiedNumbers.add(testl)) {
						break; // testl has already been verified to converge to 1.
					}
					long nextTestl = 3 * testl + 1; // Multiply by 3 and add 1.
					if (nextTestl <= testl) {
						throw new ArithmeticException("Collatz sequence overflow for " + i);
					}
					testl = nextTestl;
				} else {
					testl /= 2; // Even number, halve it.
				}
			}
		}
		return true;
	}
}
