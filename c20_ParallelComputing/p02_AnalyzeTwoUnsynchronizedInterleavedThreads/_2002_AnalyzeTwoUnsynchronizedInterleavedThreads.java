package c20_ParallelComputing.p02_AnalyzeTwoUnsynchronizedInterleavedThreads;

import static java.lang.System.out;

public class _2002_AnalyzeTwoUnsynchronizedInterleavedThreads {

	public static class IncrementThread implements Runnable {
		public void run() {
			for (int i = 0; i < TwoThreadlncrementDriver.N; i++) {
				TwoThreadlncrementDriver.counter++;
			}
		}
	}

	public static class TwoThreadlncrementDriver {
		public static int counter;
		public static int N;

		public static void main(String[] args) throws Exception {
			N = (args.length > 0) ? new Integer(args[0]) : 100;
			Thread t1 = new Thread(new IncrementThread());
			Thread t2 = new Thread(new IncrementThread());
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			System.out.println(counter);
		}
	}
}
