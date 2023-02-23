package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;
public class _0501_04_ComputingTheParityOfAword {
	
	public static short parity(long x){
		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		
		return (short) (x & 0x1);
	}

}


