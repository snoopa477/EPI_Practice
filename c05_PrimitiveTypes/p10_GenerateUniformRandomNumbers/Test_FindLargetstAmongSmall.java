package c05_PrimitiveTypes.p10_GenerateUniformRandomNumbers;
import static java.lang.System.out;
public class Test_FindLargetstAmongSmall {

	
	public static void main (String[] args) {
		
		int[] numbers = { 45, 86, 174, 596, 170};
		
		for( int i = 0; i < numbers.length; i++) {
			
			out.println("\n-----------------  ");
			out.println( findLargetAmongSmall_01(numbers[i]) + "/" + findLargetAmongSmall_02(numbers[i]) + " < " + numbers[i] + " < " + findMinAmongLarger(numbers[i]));
			
		}
		
		
		
	}
	
	
	
	private static int findLargetAmongSmall_01( int number ) {
		
		
		int i = 0;
		int result = 0;
		
		while( result < number) {
			result = (1 << i);
			i++;
		} 
		
		
		result >>>=1;
		return result;
	}
	
	
	
	private static int findMinAmongLarger( int number ) {
		//offset
		return findLargetAmongSmall_01( number ) << 1;
	}
	
	
	
	//WRONG: cannot work
	private static int findLargetAmongSmall_02( int number ) {
		
		int i = 0;
		int result = 0;
		int test = 0;
		
		while( test < number) {
			test = (1 << i);
			result = test;
			i++;
		} 
		
		return result;
		
	}
	
	
}


