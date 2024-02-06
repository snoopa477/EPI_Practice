package c07_String.p05_TestPalindromicity;
import static java.lang.System.out;
public class TestPalindromicity {
	

	public static boolean isPalindrome( String str ) {
		
		//IMAGINATION: this is kinda merge sort
		//as if non digit nor letter never exists
		
		int left = 0;
		int right = str.length() - 1;
		
		//DETAIL: left == right must be palindrome, so we can skip it
		while( left < right ) {
			
			//WRONG: when left index updated, leftChar is not updated 
			//char leftChar = str.charAt(left);
			//char rightChar = str.charAt(right);
			
			//PURPOSE: deal with left. Since we only compare digit or letter, we only stop on digit or letter
			while( !Character.isLetterOrDigit( str.charAt(left) ) && left < right ) {
				left++;
			}
			
			//PURPOSE: deal with right. Since we only compare digit or letter, we only stop on digit or letter
			while( !Character.isLetterOrDigit( str.charAt(right) ) && left < right ) {
				right--;
			}
			
			//REASONING: now that both left and right are on letter or digit, we can do compare
			//as if there is no captial 
			if( Character.toLowerCase( str.charAt(left) ) == Character.toLowerCase( str.charAt(right) ) ) {
				//OK pass, prepare for the next round
				left++;
				right--;
			}
			else {
				return false;
			}
			
		}
		//reaching here meaning there is no false
		
		return true;
	}
	
	
}


