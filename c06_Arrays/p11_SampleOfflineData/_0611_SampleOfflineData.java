package c06_Arrays.p11_SampleOfflineData;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class _0611_SampleOfflineData {
	public static void randomsampling(int k, List<Integer> A) {
		Random gen = new Random();
		for (int i = 0; i < k; ++i) {
			// Generate a random int in [i, A.size() - 1].
			Collections.swap(A, i, i + gen.nextInt(A.size() - i));
		}
	}
}
