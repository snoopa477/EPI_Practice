package c05_PrimitiveTypes.p04_FindAClosestIntegerWithTheSameWeight;
import static java.lang.System.out;
public class Test_FindAClosestIntegerWithTheSameWeight {

	public static void main(String[] args) {
		
		long[] numbers = { 0b10, 0b111, 0b1011, 0b1010010, 0b1010011 };
		
		
		out.println("\n\n--------------------------_0504_FindAClosestIntegerWithTheSameWeight");
		for( long number : numbers ) {
			out.println( number );
			out.println( _0504_FindAClosestIntegerWithTheSameWeight.closestlntSameBitCount(number) );
			out.println();
		}
		
		
		out.println("\n\n--------------------------FindAClosestIntegerWithTheSameWeight");
		for( long number : numbers ) {
			out.println( number );
			out.println( FindAClosestIntegerWithTheSameWeight.closestlntSameBitCount(number) );
			out.println();
		}
		

	}

}


