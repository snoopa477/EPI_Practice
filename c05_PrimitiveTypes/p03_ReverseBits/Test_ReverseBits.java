package c05_PrimitiveTypes.p03_ReverseBits;
import static java.lang.System.out;

import util.BitPrinter;
public class Test_ReverseBits {

	public static void main(String[] args) {
		
		long numbers[] = { 48967395L, -1, 0, 64, 10000, 1024 };
		
//		ReverseBits.IS_DEBUG_01 = true;
		//ReverseBits.IS_DEBUG_02 = true;
		
		for( long number : numbers ) {
			
			out.println("\n\n----------------");
			out.println( number );
			out.println( BitPrinter.toBitStringWithHeader(number) );
			out.println( BitPrinter.toBitStringWithHeader( ReverseBits.reverseBits(number) ) );
			
		}
		
	}

}


