package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;
public class Test_ComputingTheParityOfAword {

	
	public static void main(String[] args) {
		
		/**
		 * 0	0000	0
		 * 1	0001	1
		 * 2	0010	1
		 * 3	0011	0
		 * 4	0100	1
		 * 5	0101	0
		 * 6	0110	0
		 * 7	0111	1
		 * 8	1000	1
		 * 9	1001	0
		 * A	1010	0
		 * B	1011	1
		 * C	1100	0
		 * D	1101	1
		 * E	1110	0
		 * F	1111	0
		 */
		
		//8byte = 16hex
		//WRONG: (long)0x123456789 The literal 0x123456789 of type int is out of range 
		long[] numbers = { 0xFF, 0xAA, 0x55, 0x33, 0, 5, 16 };
		numbers[4] = (0x01234567 << 32) + 0x9ABCDEF0;
		
		out.println("\n\n-----------------------------_0501_01_ComputingTheParityOfAword");
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( numbers[i] + " " + _0501_01_ComputingTheParityOfAword.parity( numbers[i] ) );
		}
		
		out.println("\n\n-----------------------------ComputingTheParityOfAword_01_OneByOne");
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( numbers[i] + " " + ComputingTheParityOfAword_01_OneByOne.parity( numbers[i] ) );
		}
		
		out.println("\n\n-----------------------------ComputingTheParityOfAword_02_DroppingTailOne");
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( numbers[i] + " " + ComputingTheParityOfAword_02_DroppingTailOne.parity( numbers[i] ) );
		}
		
		out.println("\n\n-----------------------------ComputingTheParityOfAword_03_Precompute");
		ComputingTheParityOfAword_03_Precompute.IS_DEBUG = true;
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( numbers[i] + " " + ComputingTheParityOfAword_03_Precompute.parity( numbers[i] ) );
		}
		
		out.println("\n\n-----------------------------ComputingTheParityOfAword_04_Fold");
		for( int i = 0; i < numbers.length; i++ ) {
			out.println( numbers[i] + " " + ComputingTheParityOfAword_04_Fold.parity( numbers[i] ) );
		}
		
		
		
	}

}


