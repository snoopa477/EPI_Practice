package c05_PrimitiveTypes.p08_ReverseDigits;
import static java.lang.System.out;
public class ReverseDigits {

	public static long reverse(int x) {
		
		long result = 0;
		
		boolean isNegative = x < 0;
		
		int remainingAbsoluteX = x < 0 ? -x : x;
		
		//we only deal with positive number, so plus sign is ensured. if not, we need to check and choose either +/- sign.
		//QUESTION: how about modular sign with negative value?
		while( remainingAbsoluteX != 0 ) {
			
			/*THINK_FURTHER: if we deal with binary number, it looks something like: ( binary operation looks more straightforward than decimal)
			 * result = result << 1 + remainingAbsoluteX & 1 ;
			 * remainingAbsoluteX >>>= 10;
			 * 
			 */
			result = result * 10 + remainingAbsoluteX % 10;
			remainingAbsoluteX /= 10;
		}
		
		
		return isNegative? -result : result;
	}
	
	
	
	public static void main( String[] args) {
		
		out.println( reverse(-1245678) );
		out.println( reverse(1245678) );
		
	}
	
}


