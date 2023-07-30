package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;
public class ComputingTheParityOfAword_01_OneByOne {

	
	/*
	Reference: https://www.w3schools.com/java/java_data_types.asp
	
 	Data Type	Size	Description
	byte	1 byte	Stores whole numbers from -128 to 127
		approximate max integer: 2^8 /2 = 2^7
		
	short	2 bytes	Stores whole numbers from -32,768 to 32,767
		approximate max integer: 2^16 /2 2^15 = 32 * 1,000 (Thousand 1)
		
	int	4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
		approximate max integer: 2^32 /2 = 2^31 = 2 * 1,000,000,000 (Billion 3)
	
	long	8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		approximate max integer: 2^64 / 2 = 2^63 = 8 * 1,000,000,000,000,000,000 (Million 2 + Trillion 4 = 6) 
	 */

	//DETAIL: data type long, it has 64 bits
	public static short parity( long x ) {
		
		//DETAIL: 0 as integer(4byte) is cast as short(2byte)
		//QUESTION: it's ok to cast from integer to short automaticlaly, but not for long to short
		short result = 0;
		
		/**
		 *PURPOSE:
		 * we only process the least significant bit at a time, 
		 * when done processing, shift bit by right, causing number smaller
		 * therefore, the number keeps smaller by halved, until it becomes 0
		 * 0 means no more potential 1 to process
		 */
		//while( x > 0 ) {
		while( x != 0 ) {
			
			//process
			//DETAIL: use mask, a bunch of ones cooperating with AND operation, to get desired bit
			//DETAIL: the result of bit operation is LONG type, so have to cast back to short
			short leastSigBit = (short)(x & 1);
			
			
			/**
			 * REASONING: 
			 * given x is 0 or 1
			 * x ^ 1 = 1-x => flip
			 * x ^ 0 = x => remains
			 * 
			 * So it's ok that leastSigBit might be 0, won't affect the result
			 */
			//DETAIL: the result of bit operation is integer type, so have to cast back to short
			result = (short) ( result ^ leastSigBit);
			
			
			x >>>= 1;
			
		}
		
		
		return result;
	}
	
}


