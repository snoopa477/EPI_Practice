package c05_PrimitiveTypes.p02_SwapBits;
import static java.lang.System.out;

import util.BitPrinter;
public class Test_SwapBits {

	public static void main(String[] args) {
		
		long[] numbers = { 0, -1, 59674L, 759L, 64L, 73L};
		
		for( long number : numbers ) {
			
			out.println("\n\n---------------------");
			out.println( number );
			out.println( BitPrinter.toBitStringWithHeader( number ) );
			
			long result = _0502_SwapBits.swapBits( number, 3, 7 );
			out.println( result );
			out.println( BitPrinter.toBitStringWithHeader( result ) );
			
			result = SwapBits.swapBits( number, 3, 7 );
			out.println( result );
			out.println( BitPrinter.toBitStringWithHeader( result ) );
		}
		
		
	}

}


