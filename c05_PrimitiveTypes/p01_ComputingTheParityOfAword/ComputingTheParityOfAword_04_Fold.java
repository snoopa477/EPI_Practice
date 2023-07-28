package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;
public class ComputingTheParityOfAword_04_Fold {

	
	
	
	
	public static short parity( long x ) {
		
		//PURPOSE: condense the XOR result from 32 bits, 16, 8, 4, 2 to 1 bit
		
		// has 64 bits to process
		/*PURPOSE: align the left half to right half, 
		 * and XOR each other; 
		 * after that, the result(from both sides) stores in right half, and the left half can be forgotten
		 */
		long leftHalf = x >>> 32;
		x = x/*rightHalf*/ ^ leftHalf;
		
		
		//REASONING: reaching here, meaning only 32 bits to process
		/*PURPOSE: align the left half to right half, 
		 * and XOR each other; 
		 * after that, the result(from both sides) stores in right half, and the left half can be forgotten
		 */
		leftHalf = x >>> 16;
		x = x/*rightHalf*/ ^ leftHalf;
		
		
		//16 bits to process
		leftHalf = x >>> 8;
		//3rd fold
		x = x ^ leftHalf;
		
		
		//8 bits to process
		leftHalf = x >>> 4;
		//4th fold
		x = x ^ leftHalf;		
		
		
		//4 bits to process
		leftHalf = x >>> 2;
		//5th fold
		x = x ^ leftHalf;		
		
		
		//2 bits to process
		leftHalf = x >>> 1;
		//6th fold
		x = x ^ leftHalf;		
		
		//only 1 bit
		//now ignore the forgotten part using mask
		x = x & 1;
		
		return (short)x;
	}
	
}


