package c20_ParallelComputing.p05_Deadlock;
import static java.lang.System.out;
public class _2005_Deadlock02 {
	Account lockl = (id < to.id) ? this : to;
	Account lock2 = (id < to.id) ? to : this;
	synchronized (lockl) {
	// Does not matter if lockl equals lock2: since Java locks are
	// reentrant, we will re-acquire lock2.
	synchronized (lock2) {
}


