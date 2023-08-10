package c05_PrimitiveTypes.p06_ComputeXDividedByY._0506_ComputeXDividedByY;
import static java.lang.System.out;
public class Test_ComputeXDividedByY {

	public static void main(String[] args) {
		
		{
			long dividend = 99;
			long divisor = 2;
			
			out.println("\n\n--------------------dividend is " + dividend + " divisor is " + divisor);
			out.println( _0506_ComputeXDividedByY.divide(dividend, divisor) );
			out.println( ComputeXDividedByY.divide(dividend, divisor) );
		}
		
		
		{
			long dividend = 100;
			long divisor = 2;
			
			out.println("\n\n--------------------dividend is " + dividend + " divisor is " + divisor);
			out.println( _0506_ComputeXDividedByY.divide(dividend, divisor) );
			out.println( ComputeXDividedByY.divide(dividend, divisor) );
		}
		
		
		{
			long dividend = 50;
			long divisor = 266;
			
			out.println("\n\n--------------------dividend is " + dividend + " divisor is " + divisor);
			out.println( _0506_ComputeXDividedByY.divide(dividend, divisor) );
			out.println( ComputeXDividedByY.divide(dividend, divisor) );
		}
		
		
		{
			long dividend = 266;
			long divisor = 50;
			
			out.println("\n\n--------------------dividend is " + dividend + " divisor is " + divisor);
			out.println( _0506_ComputeXDividedByY.divide(dividend, divisor) );
			out.println( ComputeXDividedByY.divide(dividend, divisor) );
		}
		
	}

}


