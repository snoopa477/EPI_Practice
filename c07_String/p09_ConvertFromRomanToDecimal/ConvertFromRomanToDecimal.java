package c07_String.p09_ConvertFromRomanToDecimal;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;
public class ConvertFromRomanToDecimal {
	
	static private Map<Character, Integer> romanToInteger = new HashMap<>();
	
	static {
		romanToInteger.put('I', 1);
		romanToInteger.put('V', 5);
		romanToInteger.put('X', 10);
		romanToInteger.put('L', 50);
		romanToInteger.put('C', 100);
		romanToInteger.put('D', 500);
		romanToInteger.put('M', 1000);
	}
	
	
	//ASSUMPTOIN: input is valid
	public static int romanToInteger(String romanString) {
		
		
		
		//every character needs to compare to its follower, except for the last one
		//the former compares with later. If the result is smaller  => former one multiply with -1, if larger or equal, former one multiply with 1
		/* EXAMPLE
		 * IV = 1 * -1 + 5(last)
		 * VI = 5 * 1 + 1(last)
		 */
		
		int sum = 0;
		
		for( int i = 0; i < romanString.length() -1; i++ ) {
			int laterIdx = i + 1;
			
			int formerValue = romanToInteger.get( romanString.charAt(i) );
			int laterValue = romanToInteger.get( romanString.charAt( laterIdx ) );
			
			if( formerValue < laterValue ) {
				sum -= formerValue;
			}
			else {
				sum += formerValue;
			}
			
		}
		
		
		//for the last one
		sum += romanToInteger.get( romanString.charAt( romanString.length() -1 ) );
		
		return sum;
	}
	
	
	
	
}


