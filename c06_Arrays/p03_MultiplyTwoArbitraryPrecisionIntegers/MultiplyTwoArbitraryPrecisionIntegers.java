package c06_Arrays.p03_MultiplyTwoArbitraryPrecisionIntegers;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MultiplyTwoArbitraryPrecisionIntegers {
	
	//DETAIL: we won't modify n1, n2
	public static List<Integer> multiply(List<Integer> n1, List<Integer> n2) {
		
		/** PURPOSE:
		 * 1. get sign, make number positive
		 * 2. multiply
		 * 3. remove leading 0
		 * 4. add sign back
		 */

		//will use this later
		int sign = getSign( n1, n2 );
		
		//PURPOSE: to make things simple, we only process positive numbers
		List<Integer> posN1 = getPositiveList( n1 );
		List<Integer> posN2 = getPositiveList( n2 );
		
		
		//PURPOSE: calculate multiplication by sum of one digit of posN1 multiplication with one digit of posN2
		
		//PURPOSE: init
		//DETAIL: simply instance of nCopis is immutable list; that is, cannot be modified nor addition. Conversion to ArrayList is needed
		List<Integer> posMultiplication = new ArrayList<>( Collections.nCopies( posN1.size() + posN2.size() , 0) );
		
		//!! WRONG, and it's TRICKY
		//for( int i = 0; i < posN1.size(); i++ ) {
			//for( int j = 0; j < posN2.size(); j++) {
		for( int i = posN1.size() - 1 ; i >= 0; i-- ) {
			for( int j = posN1.size() - 1; j >= 0; j--) {
				//DETAIL: ranges from 1 to 81, at most two digits. left digit is at leftIdx, right digit is at rightIdx
				int oneDigitMultiplicatoin = posN1.get(i) * posN2.get(j);
				
				//PURPOSE: locate and add sub result to result
				int leftIdx = i + j;
				int rightIdx = leftIdx + 1;
				
				
				//add sub-result(oneDigitMultiplicatoin) to result
				posMultiplication.set( rightIdx, posMultiplication.get(rightIdx) + oneDigitMultiplicatoin );
				//WRONG Assumption!
				/*REASONING: under the premise that each digit is between 0 and 9, now added with a number, it might overflow( over 10). 
				 * Adjust it so it come back to normal
				 */
				int tempVal = posMultiplication.get(rightIdx);
				posMultiplication.set( rightIdx, tempVal % 10 );
				//WRONG
				//posMultiplication.set( leftIdx, tempVal / 10 );
				posMultiplication.set( leftIdx, posMultiplication.get(leftIdx) + tempVal / 10 );
			}
		}
		
		
		//REASONING: for simplicity, so far we assume oneDigitMultiplicatoin will have 2 digits; However, this might not the case
		posMultiplication = removeLeadingZero( posMultiplication );
		
		//turn back
		List<Integer> result;
		if(sign < 0) {
			posMultiplication.set( 0, posMultiplication.get(0) * -1 );
		}
		result = posMultiplication;
		return result;
	}
	
	
	
	private static int getSign( List<Integer> n1, List<Integer> n2 ) {
		/** DETAIL:
		 * -1, -1 =>  1
		 * -1,  1 => -1
		 *  1, -1 => -1
		 *  1,  1 =>  1
		 *  
		 *  isNeg, isNeg => isPositive
		 *  T, T => F
		 */
		return ( (n1.get(0) < 0 ) ^ (n2.get(0) < 0 ) )?  -1 : 1 ;
	}
	
	
	
	private static List<Integer> getPositiveList( List<Integer> n ){
		int mostSigDigit = n.get(0);
		
		if( mostSigDigit < 0 ) {
			List<Integer> list = new ArrayList<Integer>( n );
			list.set(0 , Math.abs( mostSigDigit ));
			return list;
		}
		
		return n;
	}
	
	
	
	private static List<Integer> removeLeadingZero( List<Integer> n ) {
		
		//PURPOSE: to do so, use subList(). First we need fine the idx that has no zero
		
		//start with left
		int firstNone0Idx = 0;
		//DETAIL: always check before acting
		//DETAIL: stop until ...
		while( firstNone0Idx < n.size() && n.get(firstNone0Idx) == 0 ) {
			firstNone0Idx++;
		}
		
		return n.subList(firstNone0Idx, n.size());
	}

}


