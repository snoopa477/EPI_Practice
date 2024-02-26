package c07_String.p11_WriteAStringSinusoidally;
import static java.lang.System.out;
public class WriteAStringSinusoidally {
	
	private static final int WAVE_LENGTH = 4;
	
	public static String snakeString(String s) {
	
		/** 0  1  2  3  4  5  6  7  8
		 *     x           x             
		 *  x     x     x     x     x     
		 *           x           x       
		 */          
		
		final int startIndexOfSnake = 0;
		final int firstPeakIndex = 1;
		final int firstBottomIndex = 3;
		
		StringBuilder sb = new StringBuilder();
		
		addByWaveCycle( s, sb, firstPeakIndex, WAVE_LENGTH );
		addByWaveCycle( s, sb, startIndexOfSnake, WAVE_LENGTH/2 );
		addByWaveCycle( s, sb, firstBottomIndex, WAVE_LENGTH );
		
		return sb.toString();
	}
	
	
	
	private static void addByWaveCycle( String s, StringBuilder sb, int startIndex, int cycleLength ) {
		
		
		//WRONG: typo
		//for( int i = startIndex; i < sb.length(); i+= cycleLength ) {
		for( int i = startIndex; i < s.length(); i+= cycleLength ) {
			sb.append( s.charAt(i) );
		}
		
	}
	
	
}


