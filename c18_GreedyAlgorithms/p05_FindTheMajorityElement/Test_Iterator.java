package c18_GreedyAlgorithms.p05_FindTheMajorityElement;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Test_Iterator {

	public static void main(String[] args) {
		
		//Collection<E> extends Iterable<E>
		//so many other types can also extends/ implements Iterable<E>
		
		Iterator<String> iter =  Arrays.asList("apple", "banana", "cat", "dog").iterator();
		
		while( iter.hasNext() ) {
			out.println( iter.next() );
		}
		
		
		
		out.println();
		Set<String> set = new HashSet<String>( Arrays.asList("apple", "banana", "cat", "dog") ); 
		iter = set.iterator();
		
		while( iter.hasNext() ) {
			out.println( iter.next() );
		}
		
	}

}


