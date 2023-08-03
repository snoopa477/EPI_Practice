package c05_PrimitiveTypes.p03_ReverseBits;
import static java.lang.System.out;

import util.BitPrinter;
public class ReverseBits {

	private static int BYTE_BIT_SIZE = 8;
	private static int LONG_BIT_SIZE = 64;
	
	//DETAIL: static is better than local variable
	private static long[] indexToReverseBits = getIndexToReverseBits();
	
	public static boolean IS_DEBUG_01 = false;
	public static boolean IS_DEBUG_02 = false;
	
	public static long reverseBits(long x) {
		
		//WRONG: would be better to make it as static, can be created once and reused many times
		//long[] indexToReverseBits = getIndexToReverseBits();
		
		/**
		 * PURPOSE:
		 * to reverse the bits
		 * 1. reverse in blocks: ith block will be moved to ( size -1 -i )th block
		 * 2. reverse in bitt is block is done via pre computed array, which is index to index's reverse value
		 */
		
		long result = 0;
		//given a block size is BYTE_BIT_SIZE
		int bitsInBlock = BYTE_BIT_SIZE;
		int numberOfBlocks = LONG_BIT_SIZE/BYTE_BIT_SIZE;
		//int maskOneByte = 1 << BYTE_BIT_SIZE -1;
		int maskOneByte = (1 << BYTE_BIT_SIZE) -1;
		
		if( IS_DEBUG_01 ) {
			
			for( int i = 0; i < indexToReverseBits.length; i++ ) {
				out.println("\n---------------");
				out.println(i);
				out.println( BitPrinter.toBitStringWithHeader( i ) );
				out.println( BitPrinter.toBitStringWithHeader( indexToReverseBits[i] ) );
			}
			
			out.println( 22 );
			out.println( BitPrinter.toBitStringWithHeader( 22 ) );
			out.println( BitPrinter.toBitStringWithHeader( indexToReverseBits[ 22 ] ) );
			
		}
		
				
		for( int blockIdx = 0; blockIdx < numberOfBlocks; blockIdx++ ) {
			//WRONG
			//long bitsAlignedTo0 = ( x >>> ( i * bitsInBlock ) ) & maskOneByte;
			int bitsAlignedTo0 = (int) ( x >>> ( blockIdx * bitsInBlock ) ) & maskOneByte;
			long reversedBitsAligendTo0 = indexToReverseBits[ bitsAlignedTo0 ];
			
			//WRONG
			//long reversedBits = reversedBitsAligendTo0 << (  numberOfBlocks -1 - blockIdx  ) * bitsInBlock;
			long reversedBits = reversedBitsAligendTo0 << ( (  numberOfBlocks -1 - blockIdx  ) * bitsInBlock );
			
			if( IS_DEBUG_02 ) {
				out.println("\n---------------IS_DEBUG_02");
				out.println( BitPrinter.toBitStringWithHeader( bitsAlignedTo0 ) );
				out.println( BitPrinter.toBitStringWithHeader( reversedBitsAligendTo0 ) );
			}
			
			//addition of 1s
			result |= reversedBits;
		}
		
		
		return result;
	}
	
	
	
	private static long[] getIndexToReverseBits( ) {
		
		/* 0000 0000 -> 0000 0000
		 * 0000 0001 -> 1000 0000
		 * ...
		 * 0010 0111 -> 1110 0100
		 * ...
		 * 1111 1111 -> 1111 1111
		 * 
		 * 256 kinds
		 */
		//DETAIL: 2 ^ (BYTE_SIZE)
		int allValues = 1 << BYTE_BIT_SIZE;
		long[] indexToReverseBits = new long[ allValues ];
		
		for( int i = 0; i < allValues; i++ ) {
			indexToReverseBits[ i ] = getReverseBit( i );
		}
		
		return indexToReverseBits;
	}
	
	
	
	private static long getReverseBit( long x ) {
		
		int oneBitMask = 1;
		long result = 0;
		
		
		//ok
//		for( int i = 0; i < BYTE_BIT_SIZE; i++ ) {
//			
//			result <<= 1;
//			
//			//addition of 1
//			result = result | ( x & oneBitMask );
//			x >>>= 1;
//			
//			//WRONG? yeah
//			//result <<= 1;
//		}
//		
		
		//WRONG if without counter.  if 00011000 the process ends in the middle, where index is 5 
		int counter = BYTE_BIT_SIZE;
		while( x != 0 ) {
			
			result <<= 1;
			
			//addition of 1
			result = result | ( x & oneBitMask );
			
			//eventual ?
			//prepare for next step
			x >>>= 1;
			counter--;
		}
		//if if 00011000 the process ends in the middle, where index is 5, then push the remaing 3 bits by left
		result <<= counter;
		
		
		return result;
	}
	
	
	
}


