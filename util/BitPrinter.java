package util;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
public class BitPrinter {


	private static final int INTEGER_LENGTH = 32;
	private static final int TOKEN_LENGTH = 4;
	private static final int ONE = 1;
	private static final int ZERO = 0;
	
	public static String bitString(int number, boolean isReadHelper) {
		
		//Integer.toBinaryString(number);
		/**
		 * x3  x2  x1  x0  -X
		 * 
		 * to get x3:
		 * (X >> 3) %2
		 * 
		 * to get x2:
		 * (X >> 2) %2
		 * 
		 * to get x0:
		 * (x >>  0) %2
		 */
		
		/**
		 *  1  1  1  1 = X = -1
		 *  1  1  1  1 = X >>3 = -1
		 * 
		 *  
		 */
		
		StringJoiner sj = new StringJoiner(" ");
		for( int i = INTEGER_LENGTH -1; i >= 0; i-- ) {
			
			//WRONG if there's leading one, see above example
			//WRONG example result : -1 =>  -1 -1 -1 -1
			//sj.add( String.valueOf( (number >> i)% 2 ) );
			
			//WRONG example result : -1 =>  0 1 1 1
			//sj.add( String.valueOf(  ( number & (1 << i) ) > 0? 1 : 0 )   );
			
			sj.add( String.valueOf(  ( number & (1 << i) ) != 0? 1 : 0 )   );
			
			//31 30 29 28 _ 27 26 25 24 _
			if( i % TOKEN_LENGTH == 0 ) {
				if( isReadHelper == false) {
					sj.add(" ");
				}
				else {
					sj.add(" (" + String.valueOf(i) + ")" );
				}
			}
			
		}
		
		return sj.toString();
	}
	
	
	
	//It's only applicable when number > 0 
	public static <T extends Number> Deque<Integer> toBits_cuttingBoard( T number ) {
		Deque<Integer> bits = new LinkedList<>();
		
		T tempNumber = number;
		int tempNumverVal = tempNumber.intValue();
		//The operator > is undefined for the argument type(s) T, int
		//while( tempNumber > 0 ) {
		
		int counter = ZERO;
		/* DETAIL: using this method cannot convert negative number to bits
		 */
		while( tempNumverVal > 0 ) {
			
			if( ( tempNumverVal & ONE ) == ONE ) {
				bits.addFirst(ONE);
			}
			else {
				bits.addFirst(ZERO);
			}
			
			tempNumverVal >>= ONE;
			counter++;
		}
		
		int maxCounter = getDatatypeLength( number );
		
		while( counter < maxCounter ) {
			bits.addFirst( ZERO);
			counter++;
		}
		
		return bits;
	}
	
	
	
	public static <T extends Number> Deque<Integer> toBits( T number ) {
		Deque<Integer> bits = new LinkedList<>();
		
		T tempNumber = number;
		int tempNumverVal = tempNumber.intValue();
		
		int datatypeLength = getDatatypeLength( number );
		
		
		for( int i = 0 ; i < datatypeLength; i++ ) {
			
			//WRONG if > ZERO when inspecting leading bit, which stands for negativity or not
			if( (tempNumverVal & ( ONE << i ) ) != ZERO ){
				bits.addFirst(ONE);
			}
			else {
				bits.addFirst(ZERO);
			}
		}
		
		
		return bits;
	}
	
	
	
	public static <T extends Number> String toBitStringWithHeader( T number ) {
		
		int datatypeLength = getDatatypeLength( number );
		
		StringBuilder sb = new StringBuilder();
		
		for( int i = datatypeLength - ONE; i >= ZERO ; i-- ) {
			sb.append( String.format("%3d", i) );
		}
		sb.append( String.format("\n") );
		
		
		Deque<Integer> bits = toBits(number);
		while( bits.size() > 0 ) {
			sb.append( String.format("%3d", bits.removeFirst()) );
		}
		
		
		return sb.toString();
	}
	
	
	
	//WRONG: The method toBitStringWithHeader(T[], int) in the type BitPrinter is not applicable for the arguments (byte[], int)
	//https://www.youtube.com/watch?v=K1iu1kXkVoA
	//public static <T extends Number> String toBitStringWithHeader( T[] numbers, int width ) {
	
	//WRONG: The method getDatatypeLength(T) in the type BitPrinter is not applicable for the arguments  (capture#1-of ?)
	//public static String toBitStringWithHeader( List<?> numbers, int width ) {
	public static String toBitStringWithHeader( List<? extends Number> numbers, int width ) {
		
		int datatypeLength = getDatatypeLength( numbers.get(0) );
		
		int numbersOfElementsInARow = width /datatypeLength;
		
		//out.println("numbersOfElementsInARow " + numbersOfElementsInARow);
		
		StringJoiner sj = null;
		StringBuilder sb = new StringBuilder();
		
		//header
		sb.append( String.format("%2d", ZERO) );
		for( int i = ONE; i < width; i++  ) {
			sb.append( String.format("%3d", i) );
		}
		sb.append("\n");
		
		
		for( int i = 0; i < numbers.size(); i++ ) {
			
			sj = new StringJoiner("  ", "[", "]");
			
			Deque<Integer> bits = toBits( numbers.get(i) );
			while( bits.size() > 0 ) {
				//sj.add( String.valueOf( bits.removeFirst() ) );
				sj.add( String.valueOf( bits.removeLast() ) );
			}
			
			sb.append( sj.toString() );
			
			//if( (i + 1) / numbersOfElementsInARow == ZERO ) {
			if( (i + 1) % numbersOfElementsInARow == ZERO ) {
				sb.append("\n");
			}
		}
		
		
		
		return sb.toString();
	}
	
	
	
	public static String toBitStringWithHeader( Byte[] numbers, int width ) {
		return toBitStringWithHeader( Arrays.asList( numbers ), width );
	}
	
	
	
	private static <T extends Number> int getDatatypeLength( T number ) {
		
		if( number instanceof Byte ) {
			return 8;
		}
		else if( number instanceof Integer ) {
			return 32;
		}
		else if( number instanceof Long ) {
			return 64;
		}
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		
		Integer[] numbers = { 1, 3, 5, 7, 16, 127, 0b111000111, -1};
		
		//WRONG: The method toBitStringWithHeader(List<? extends Number>, int) in the type BitPrinter is not applicable for the arguments (List<byte[]>, int)
		//byte[] bytes = { (byte)0xFF, (byte)0xAA, (byte)0x55 };
		Byte[] bytes = { (byte)0xFF, (byte)0xAA, (byte)0x55, (byte)0x33 };
		
		for( int number : numbers ) {
			out.println( "number: " + number + ": " + bitString( number, true ) );
		}
		
		
		for( int i = 31; i>=0 ; i-- ) {
			out.printf("%3d", i);
		}
		out.println();
		
		for( int i = 31; i>=0 ; i-- ) {
			out.printf("%3d", i % 2 == 0? 1: 0);
		}
		out.println();
		
		
		out.println("- - - - - - - - - - - - - - - - - - toBits_cuttingBoard");
		
		for( int number : numbers ) {
			Deque<Integer> bits = toBits_cuttingBoard(number);
			out.println( "number: " + number);
			while( bits.size() > 0 ) {
				out.print( bits.removeFirst() + " ");
			}
			out.println();
		}
		
		
		
		
		for( byte number : bytes ) {
			Deque<Integer> bits = toBits_cuttingBoard(number);
			out.println( "number: " + number);
			while( bits.size() > 0 ) {
				out.print( bits.removeFirst() + " ");
			}
			out.println();
		}
		
		
		out.println("- - - - - - - - - - - - - - - - - - toBits");
		
		for( int number : numbers ) {
			Deque<Integer> bits = toBits(number);
			out.println( "number: " + number);
			while( bits.size() > 0 ) {
				out.print( bits.removeFirst() + " ");
			}
			out.println();
		}
		
		
		for( byte number : bytes ) {
			Deque<Integer> bits = toBits(number);
			out.println( "number: " + number);
			while( bits.size() > 0 ) {
				out.print( bits.removeFirst() + " ");
			}
			out.println();
		}
		
		
		out.println("- - - - - - - - - - - - - - - - - - toBitStringWithHeader");
		
		for( int number : numbers ) {
			out.println( "number: " + number);
			out.println( toBitStringWithHeader( number ) );
			out.println();
		}
		
		
		for( byte number : bytes ) {
			out.println( "number: " + number);
			out.println( toBitStringWithHeader( number ) );
			out.println();
		}
		
		
		
		out.println("- - - - - - - - - - - - - - - - - - toBitStringWithHeader");
		/*
			 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
			[1  1  1  1  1  1  1  1][0  1  0  1  0  1  0  1]
			[1  0  1  0  1  0  1  0][1  1  0  0  1  1  0  0]
		 * */
		out.println( toBitStringWithHeader( Arrays.asList( bytes ), 16 ) );
		
	}	
	
	
}


