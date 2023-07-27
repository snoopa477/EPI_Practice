package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;
public class ComputingTheParityOfAword_03_Precompute {
	
	
	private static int[] POWER_OF_TWO = {1, 2, 4, 8};
	private static int HEX_MASK = 0xFFFF;
	private static int HEX = 16;
	
	
	
	public static short parity( long x ) {
		
		byte[]  bitToParity = precomputeBitToParity(  );
		
		//from left to right
		 short parityOfPart1 = bitToParity[ (int)( x >>> ( HEX * 3 ) ) & HEX_MASK ]; 
		 short parityOfPart2 = bitToParity[ (int)( x >>> ( HEX * 2 ) ) & HEX_MASK ]; 
		 short parityOfPart3 = bitToParity[ (int)( x >>> ( HEX * 1 ) ) & HEX_MASK ];
		 short parityOfPart4 = bitToParity[ (int)( x >>> ( HEX * 0 ) ) & HEX_MASK ];
		
		 return (short) ( parityOfPart1 ^ parityOfPart2 ^ parityOfPart3 ^ parityOfPart4 );
	}
	
	
	
	private static byte[] precomputeBitToParity(  ) {
		
		/**
		 * REASONING:
		 * to calculate parity of current value, find the counterpart, and flip it
		 * 
		 * 0000 0
		 * 0001 1 a[0] ^ 1, cuz 1 =  2 to power of 0
		 * 0010 2 a[0] ^ 1, cuz 2 =  2 to power of 1
		 * 0011 3 a[1] ^ 1
		 * 0100 4 a[0] ^ 1, cuz 4 =  2 to power of 2
		 * 0101 5 a[1] ^ 1
		 * 0110 6 a[2] ^ 1
		 * 0111 7 a[3] ^ 1
		 * 1000 8 a[0] ^ 1, cuz 8 =  2 to power of 3
		 * 1001 9 a[1] ^ 1
		 * 1010 10 a[2] ^ 1
		 * 1011 11 a[3] ^ 1
		 * 1100 12 a[4] ^ 1
 		 * 1101 13 a[5] ^ 1
		 * 1110 14 a[6] ^ 1
		 * 1111 15 a[7] ^ 1
		 * 1 0000 16, cuz 16 =  2 to power of 4
		 */
		
		byte[] bitToPairty = new byte[ HEX ];
		
		//DETAIL: 0000 parity is 0
		bitToPairty[ 0 ] = 0;
		int idxPowerOf2 = 0;
		
		//DETAIL: i = 0 already has value, so skip it
		for( int i = 1, idxCounterpart = 0; i < bitToPairty.length; i++, idxCounterpart++ ) {
			
			//REASONING: when it's power of 2, we can sure that it only one set bit( and it is at most significant place), which counterPart must be 000000
			if( i ==  POWER_OF_TWO[ idxPowerOf2 ] ) {
				idxCounterpart = 0;
				idxPowerOf2++;
			}
			
			//flip
			bitToPairty[ i ] =  (byte)( (int) bitToPairty[ idxCounterpart ] ^ 1) ;
		}
		
		
		return bitToPairty;
	}

}


