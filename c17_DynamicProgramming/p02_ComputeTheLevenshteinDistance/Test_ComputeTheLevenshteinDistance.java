package c17_DynamicProgramming.p02_ComputeTheLevenshteinDistance;
import static java.lang.System.out;
public class Test_ComputeTheLevenshteinDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		out.println( _1702_ComputeTheLevenshteinDistance.levenshteinDistance("Apple", "Banana") );
		out.println( _1702_ComputeTheLevenshteinDistance.levenshteinDistance("Cat", "Dog") );
		
		ComputeTheLevenshteinDistance.IS_DEBUG = true;
		
		out.println( ComputeTheLevenshteinDistance.levenshteinDistance("Apple", "Banana") );
		out.println( ComputeTheLevenshteinDistance.levenshteinDistance("Cat", "Dog") );

	}

}


