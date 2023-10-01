package c06_Arrays.p08_EnumerateAllPrimesToN;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class EnumerateAllPrimesToN_02_heuristics {
	
	public static boolean IS_DEBUG = false;
	
	
	public static List<Integer> generatePrimes(int n) {
		
		//boolean[] num_to_isPrime = getIsPrimes( n );
		boolean[] convertedNum_to_isPrime = getIsPrimes( n );
		List<Integer> primes = new ArrayList<>();
		primes.add( 2 );
		
		
		//for( int candidateOfPrime = 3; candidateOfPrime < convertIndexToNum ( convertedNum_to_isPrime.length ); candidateOfPrime++ ) {
		//for( int candidateOfPrime = 3; candidateOfPrime < n; candidateOfPrime++ ) {
		for( int candidateOfPrime = 3; candidateOfPrime < n; candidateOfPrime+=2 ) {
			
			int index = convertNumToIndex( candidateOfPrime );
			if( convertedNum_to_isPrime[ index ] ) {
				primes.add(candidateOfPrime);
				//PURPOSE: eliminate candidates of primes in the future iteration
				ruleOutNonPrimes( convertedNum_to_isPrime, candidateOfPrime );
			}
			
		}
		
		
		return primes;
	}
	
	
	
	/* REASONING: two adjustment here:
	 * 1. we don't need to record 0, 1, 2. since we already know the answer => exclude them by -3 
	 * 2. even number don't even have to be recorded => exclude them by /2
	 */
	/**
	 * Example
	 * e.g. 
	 * number 0  1  2  3  4  5  6  7  8  9  10 11 12 13
	 * index  x  x  x  0  x  1  x  2  x  3   x  4  x  5
	 * 
	 */
	private static int convertNumToIndex( int num ) {
		int index = ( num - 3 ) / 2;
		return index;
	}
	
	
	
	//DETAIL: do the reverse operation
	private static int convertIndexToNum( int index ) {
		int num = index * 2 + 3;
		return num;
	}
	
	
	
	private static boolean[] getIsPrimes( int num ) {
		
		//size = largest index + 1
		int size = convertNumToIndex( num ) + 1;
		boolean[] convertedNum_to_isPrime = new boolean[ size ];
		Arrays.fill(convertedNum_to_isPrime, true);
		return convertedNum_to_isPrime;
	}
		
		
	
	//So confusing for me
	private static void ruleOutNonPrimes(boolean[] convertedNum_to_isPrime, int prime) {
		
		if( IS_DEBUG ) {
			out.println( "prime is " + prime );
		}
		
		int squareOfPrime = prime * prime;
		int index_squareOfPrime = convertNumToIndex( squareOfPrime );
		int currentVal = squareOfPrime;
		
		for( int i = index_squareOfPrime; i < convertedNum_to_isPrime.length; ) {
			
			convertedNum_to_isPrime[ i ] = false;
			
			
			
			//currentVal += prime;
			
			do {
				currentVal += prime;
				if( IS_DEBUG ) out.println("hi " + currentVal +"; prime " + prime);
			} while( currentVal %2 ==0 );
			
			
			int index = convertNumToIndex( currentVal );
			
			if( IS_DEBUG ) {
				out.print(  "(" + currentVal + "," +  index + ") " );
			}
			
			i = index;
		}
		if( IS_DEBUG ) { out.println(); }
		
		
//		for( int i = 0; i < convertedNum_to_isPrime.length; i++ ) {
//			
//			int num = convertIndexToNum( i );
//			int numSquare = num * num;
//			int index_numSquare = convertNumToIndex( numSquare );
//			
//		}
//		
		
	}

}


