package c06_Arrays.p03_MultiplyTwoArbitraryPrecisionIntegers;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Test_ListMethods {

	
	public static void main(String[] args) {
		
		
		{
			out.println( "true ^ false" );
			out.println( true ^ false );
			
			out.println( "true ^ true" );
			out.println( true ^ true );
			
			out.println( "false ^ true" );
			out.println( false ^ true );
			
			out.println( "false ^ false" );
			out.println( false ^ false );
			
			
		}
		
		
		{
			out.println(" - - - - - test list.subList() - - - - -  ");
			List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7);
			out.println( list );
			//[3, 4, 5, 6]
			out.println( list.subList(3, 7) );
			//[3, 4, 5, 6, 7]
			out.println( list.subList(3, 8) );
		}
		
		
		
		try
		{
			out.println(" - - - - - test Collections.nCopies() - - - - -  ");
			
			//an immutable list consisting of n copies of thespecified object.
			List<Integer> list = Collections.nCopies(6, 9);
			out.println( list.getClass() );
			out.println( list );
			
			//to use add operations, use ArrayList instead
			List<Integer> arrList = new ArrayList<>( list );
			arrList.add(5);
			out.println("arrList.add(5)");
			
			
			//java.lang.UnsupportedOperationException
			out.println("list.add(5)");
			list.add(5);
			out.println(list);
			
		}
		catch( Exception e ) {
			//java.lang.UnsupportedOperationException
			out.println( e );
		}
		
		
		
	}
	
	
}


