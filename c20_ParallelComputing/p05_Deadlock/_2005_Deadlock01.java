package c20_ParallelComputing.p05_Deadlock;

import static java.lang.System.out;

public class _2005_Deadlock01 {

	public static class Account {
		private int balance;
		private int id;
		private static int globalId;

		Account(int balance) {
			this.balance = balance;
			this.id = ++globalId;
		}

		private boolean move(Account to, int amount) {
			synchronized (this) {
				synchronized (to) {
					if (amount > balance) {
						return false;
					}
					to.balance += amount;
					this.balance -= amount;
					System.out.println("returning true");
					return true;
				}
			}
		}

		public static void transfer(final Account from, final Account to, final int amount) {
			Thread transfer = new Thread(new Runnable() {
				public void run() {
					from.move(to, amount);
				}
			});
			transfer.start();

		}

	}

}
