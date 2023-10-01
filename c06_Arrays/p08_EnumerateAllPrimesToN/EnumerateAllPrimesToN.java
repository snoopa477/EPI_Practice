package c06_Arrays.p08_EnumerateAllPrimesToN;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class EnumerateAllPrimesToN {
	
	
	public static List<Integer> generatePrimes(int n) {
		
		//DETAIL: number to isPrimes
		boolean[] num_to_isPrime = new boolean[ n + 1 ];
		initPrimes( num_to_isPrime );
		
		
		//PURPOSE: add prime to list based on num_to_isPrime, as we updating num_to_isPrime
		
		List<Integer> primes = new ArrayList<>();
		//WRONG if I miss
		primes.add(2);
		
		//DETAIL: number 0,1,2 don't need prior knowledge to check prime. So we start with 3
		for( int candidateOfPrime = 3; candidateOfPrime < num_to_isPrime.length; candidateOfPrime++ ) {
			
			if( num_to_isPrime[ candidateOfPrime ] ) {
				
				primes.add(candidateOfPrime);
				
				//PURPOSE: eliminate candidates of primes in the future iteration
				ruleOutNonPrimes( num_to_isPrime, candidateOfPrime );
			}
			
		}
		
		
		return primes;
	}
	
	

	//PURPOSE: we can initialize them without any prior knowledge 
	private static void initPrimes( boolean[] num_to_isPrime ) {
		
		//let us assume all numbers are primes before checking
		Arrays.fill(num_to_isPrime, true);
		
		num_to_isPrime[0] = false;
		num_to_isPrime[1] = false;
		//WRONG:
		//num_to_isPrime[2] = false;
		num_to_isPrime[2] = true;
		
		//WRONG if I miss this line
		ruleOutNonPrimes( num_to_isPrime, 2 );
	}
	
	
	
	private static void ruleOutNonPrimes(boolean[] num_to_isPrime, int prime) {
		
		//start with 2, not 1 ( the smallest yet not itself)
		int factor = 2;
		int primeMultiplyByFactor = prime * factor;
		
		//REASONING: thinking backward. if a number equals to primeMultiplyByFactor, that means it is divisible 
		for( ; primeMultiplyByFactor < num_to_isPrime.length; factor++ ) {
			primeMultiplyByFactor = prime * factor;
			
			//WRONG if I miss this
			if( primeMultiplyByFactor < num_to_isPrime.length ) {
				num_to_isPrime[primeMultiplyByFactor] = false;
			}
		}
		
	}
	
	
	
}


