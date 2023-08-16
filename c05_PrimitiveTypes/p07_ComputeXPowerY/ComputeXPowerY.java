package c05_PrimitiveTypes.p07_ComputeXPowerY;
import static java.lang.System.out;
public class ComputeXPowerY {

	
	public static double power(double x, int y) {
		
		
		//PURPOSE: convert y from negative to positive is there exist such case
		/**
		 * REASONING:
		 * we gonna check each bit, and negative number cannot apply
		 * to solve this, convert negative number to positive
		 * 
		 * given x to the power of y
		 * if y < 0, then -y > 0
		 * 
		 * equivalently, (1/x) to the power of -y
		 * 计璽计, 痷计计
		 */
		
		if( y < 0 ) {
			y *= -1;
			x = 1.0 / x;
		}
		
		
		//REASONING: reaching here y must > 0
		double result = 1.0;
		int power = y;
		double xToThePower = x;
		
		//PURPOSE: we check each bit from right to left
		while( power != 0 ) {
			
			//there exist such bit
			if( (power & 1) != 0 ) {
				result *= xToThePower;
			}
			
			/*PURPOSE: move to next bit by shift left; 
			 * equivalently, that means power goes from 1, 2, 4, 8
			 * that also means xToThPower will multiply itself
			 * 
			 * power move one bit: 计ㄢ, 痷计
			 * 
			 */
			
			/* e.g. 
			 * 1 0 1[0]
			 * 
			 * x^1
			 * =
			 * 0 0 0 1
			 *x
			 * ---------- 
			 * 1 0[1]0
			 * 
			 * x^1 * x^1 = x^2
			 * =
			 * 0 0 1 0
			 *x
			 * ----------
			 * 1[0]1 0
			 * 
			 * x^2 * x^2 = x^4
			 * =
			 * 0 1 0 0
			 *x
			 * ----------
			 *[1]0 1 0
			 * 
			 * x^4 * x^4 = x^8
			 * =
			 * 1 0 0 0
			 *x 
			 */
			
			power >>>= 1;
			xToThePower = xToThePower * xToThePower;
		}
		
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		out.println( power( 2, 10 ) );
		out.println( power( 2, -2 ) );
		
		out.println( power( 10, 3 ) );
		//WHY?
		//0.0010000000000000002
		out.println( power( 10, -3 ) );
		
		out.println( power( 3, -2 ) );
	}
	
}


