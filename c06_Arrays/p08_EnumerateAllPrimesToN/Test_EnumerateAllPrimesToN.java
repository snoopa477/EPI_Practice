package c06_Arrays.p08_EnumerateAllPrimesToN;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_EnumerateAllPrimesToN {

	public static void main(String[] args) {
		
		int number = 150;
		
		{
			List<Integer> primes = EnumerateAllPrimesToN.generatePrimes(number);
			out.println(primes);
		}
		
		{
//			EnumerateAllPrimesToN_02_heuristics.IS_DEBUG = true;
			List<Integer> primes = EnumerateAllPrimesToN_02_heuristics.generatePrimes(number);
			out.println(primes);
		}
	}

}


