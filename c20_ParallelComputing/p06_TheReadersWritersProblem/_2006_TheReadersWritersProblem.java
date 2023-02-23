package c20_ParallelComputing.p06_TheReadersWritersProblem;

import static java.lang.System.out;

public class _2006_TheReadersWritersProblem {

	// LR and LW are static members of type Object in the RW class.
	// They serve as read and write locks. The static integer
	// field readCount in RW tracks the number of readers.
	public static class Reader extends Thread {
		public void run() {
			while (true) {
				synchronized (RW.LR) {
					RW.readCount++;
				}
				System.out.println(RW.data);
				synchronized (RW.LR) {
					RW.readCount--;
					RW.LR.notify();
				}
				Task.doSomeThingElse();
			}
		}
	}

	public static class Writer extends Thread {
		public void run() {
			while (true) {
				synchronized (RW.LW) {
					boolean done = false;
					while (!done) {
						synchronized (RW.LR) {
							if (RW.readCount == 0) {
								RW.data = new Date().toString();
								done = true;
							} else {
								// Use wait/notify to avoid busy waiting.
								try {
									// Protect against spurious notify, see
									// stackoverflow.com do-spurious-wakeups-actually-happen.
									while (RW.readCount != 0) {
										RW.LR.wait();
									}
								} catch (InterruptedException e) {
									System.out.println("InterruptedException in Writer wait");
								}
							}
						}
					}
				}
				Task.doSomeThingElse();
			}
		}
	}
}
