package c06_Arrays.p02_IncrementAnArbitraryPrecisionInteger;
import static java.lang.System.out;

import java.util.List;
public class IncrementAnArbitraryPrecisionInteger {
	
	
	public static List<Integer> plusOne(List<Integer> A) {
		
		//PURPOSE: go to least significant digit, and add 1 to it
		int leastSigDig_idx = A.size() -1;
		plusOne( A, leastSigDig_idx );
		processCarries(A);
		
		return A;
	}
	
	
	
	private static void processCarries(List<Integer> A) {
		
		int curretIdx = A.size() -1;
		
		//DETAIL, must check index before access its value
		//PURPOSE: 10 means there's carry to process
		while( curretIdx >= 0 && A.get(curretIdx) == 10 ) {
			
			//check currentIdx specifically, since if carry happens here, we need to allocate additional memory
			if( curretIdx == 0 ) {
				A.set( curretIdx, 0 );
				//now the carry hangs in the air
				//allocate new memory, and insert in front of list. now index = 0 points to this new memory
				
				//Test program, some list don't support add operation
				A.add( 0 , 0);
				plusOne( A, 0 );
				
			}
			//currentIdx > 0
			else {
				//move left
				int greaterSigDigitIdx = curretIdx - 1;
				//now the carry hangs in the air
				A.set( curretIdx, 0 );
				plusOne( A, greaterSigDigitIdx );
			}
			
			curretIdx--;
		}
		
	}
	
	
	
	private static void plusOne( List<Integer> A, int i ) {
		A.set( i, A.get( i ) + 1 );
	}

}


