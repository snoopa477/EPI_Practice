package c07_String.p08_TheLookAndSayProblem;
import static java.lang.System.out;
public class TheLookAndSayProblem {
	
	
	public static String lookAndSay(int n) {
		
		String s = "1";
		
		for( int i = 1; i < n; i++ ) {
			s = nextNumber(s);
		}
		
		return s;
	}

	
	
	private static String nextNumber(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for( int i = 0; i < s.length(); i ++ ) {
			
			//REASONING: reaching here means either at the beginning of string, or at the beginning of consecutive substring of same chars
			int iCount = 1;
			
			//PURPOSE: count how many pivotCount by checking if pivot is same as previous index: i 
			int pivotIndex = i + 1;
			int pivotCount = 0;
			
			while( pivotIndex < s.length() && s.charAt(pivotIndex) == s.charAt( i )  ) {
				//pivot is same as i, count pivot in
				pivotCount++;
				
				//prepare for next round
				i++;
				pivotIndex = i + 1;
			}
			
			
			/*Reaching here means either pivotIndex >= s.length() or s.charAt(pivotIndex) != s.charAt( i )
			 * in either way, consecutive substrings ends here
			 * and we summarize the consecutive count = iCount + pivotCount
			 */
			sb.append( (iCount + pivotCount) );
			//DETAIL: let the last element of consecutive substring stands for the whole string character
			/*REASONING:
			 *       i pivot
			 * X X X X Y
			 * right now, i points to last index of consecutive substring; while pivot(i + 1) points to beginning of another consecutive substring
			 */
			
			//WRONG
			//sb.append( i );
			sb.append( s.charAt(i) );
		}
	
		return sb.toString();
	}

}


