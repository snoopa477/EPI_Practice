package c05_PrimitiveTypes.p04_FindAClosestIntegerWithTheSameWeight;
import static java.lang.System.out;
public class FindAClosestIntegerWithTheSameWeight {
	
	private static int LONG_BIT_SIZE = 64;
	
	public static long closestlntSameBitCount(long x) {
		
		//no different bit to process, ends direclty
		if( x == 0 || x == -1 ) {
			return x;
		}
		
		//search from right to left
		//DETAIL: since we use i + 1, so total range should be siez -1 -1 
		for( int i = 0; i < LONG_BIT_SIZE -1; i++ ) {
			
			if( isTwoConsecutiveBitDifferent(x, i) ){
				x = flipBit( x, i );
				x = flipBit( x, i + 1 );
				break;
				//return x;
			}
		}
		
		return x;
	}
	
	
	
	private static boolean isTwoConsecutiveBitDifferent( long x, int i ) {
		
		int oneBitMask = 1;
		
		//DETAIL: x type is long -> operation result is long
		long bitValue = ( x >>> i ) & oneBitMask;
		long nextBitValue = ( x >>> (i + 1) ) & oneBitMask;
		
		return bitValue != nextBitValue;
	}
	
	
	private static long flipBit( long x, int i ) {
		
		//DETAIL: 1L not 1, 1L -> long data type, so even when > 32 still works normally
		long flipMask = 1L << i;
		//REVIEW:  x XOR 1 = 1-x ( change ); x XOR 0 = x ( keep )
		x = x ^ flipMask;
		
		return x;
	}
	
}


