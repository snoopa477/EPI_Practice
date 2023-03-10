package c20_ParallelComputing.p09_TestTheCollatzConjectureInParallel;

import static java.lang.System.out;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _2009_TestTheCollatzConjectureInParallel {

	// Performs basic unit of work, i.e., checking CH for an interval

	public static class MyRunnable implements Runnable {
		public int lower;
		public int upper;

		MyRunnable(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}

		@Override
		public void run() {
			for (int i = lower; i <= upper; ++i) {
				Collatz.CollatzCheck(i, new HashSet<BigInteger>());
			}
		}
	}

	// Checks an individual number
	public static boolean CollatzCheck(BigInteger aNum, Set<BigInteger> visited) {
		if (aNum.equals(BigInteger.ONE)) {
			return true;
		} else if (visited.contains(aNum)) {
			return false;
		}
		visited.add(aNum);
		if (aNum.getLowestSetBit() == 1) {// Odd number.
			return CollatzCheck(new BigInteger("3").multiply(aNum).add(BigInteger.ONE), visited);
		} else {// Even number.
			return CollatzCheck(aNum.shiftRight(1), visited); // Divide by 2.
		}
	}

	public static boolean CollatzCheck(int aNum, Set<BigInteger> visited) {
		BigInteger b = new BigInteger(new Integer(aNum).toString());
		return CollatzCheck(b, visited);
	}

	public static ExecutorService execute() {
		// Uses the Executor framework for task assignment and load balancing
		List<Thread> threads = new ArrayList<Thread>();
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		for (int i = 0; i < (N / RANGESIZE); ++i) {
			Runnable worker = new MyRunnable(i * RANGESIZE + 1, (i + 1) * RANGESIZE);
			executor.execute(worker);
		}
		executor.shutdown();
		return executor;
	}
}
