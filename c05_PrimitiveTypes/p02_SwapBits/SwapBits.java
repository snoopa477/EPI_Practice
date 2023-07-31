package c05_PrimitiveTypes.p02_SwapBits;
import static java.lang.System.out;
public class SwapBits {
	
	
	
	//WARNING: always check the container before doing assignment/ operator
	public static long swapBits(long x, int i, int j) {
		
		long bitAt_i = getBit(x, i);
		long bitAt_j = getBit(x, j);
		
		
		if( bitAt_i != bitAt_j ) {
			
			/**
			 * REVIEW of XOR: 
			 * given x = 1 or 1
			 * x ^ 1 = 1 - x => flip
			 * x ^ 0 = x => keep
			 */
			
			//REASONING: flip those two bits by XOR operator,  equivalently to swapping bit
			//DETAIL !!: if 1 <<< i; there might be chance go wrong when i > 32, because 1 is integer 
			long maskForFlip_i_j = ( 1L << i );
			// DETAIL: | is addition of 1
			maskForFlip_i_j = maskForFlip_i_j |  ( 1L << j );
			
			// bit i flips itself, bit j flips itself
			// e.g. if (bitI, bitJ) = (1,0); then it would become (0,1).
			x = x ^ maskForFlip_i_j;
			
			return x;
		}
		//bitAt_i == bitAt_j, doing nothing equivalently to swapping bit   
		else {
			return x;
		}
	}
	
	
	
	//public static int getBit( long x, int i ) {
	private static long getBit( long x, int i ) {
		
		int oneBitMask = 1;
		//DETAIL: x is type long, ( x >>> i ) => long, ( x >>> i ) & oneBitMask => still long
		//it is either 0 or 1
		return ( x >>> i ) & oneBitMask;
	}
	
	
	
}


