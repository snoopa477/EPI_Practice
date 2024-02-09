package c07_String.p06_ReverseAllTheWordsInASentence;
import static java.lang.System.out;
public class Test_ReverseAllTheWordsInASentence {

	public static void main(String[] args) {
		
		{
			out.println("---------------");
			char[] input = "Alice likes Bob".toCharArray();
			out.println( input );
			ReverseAllTheWordsInASentence.reverseAllWords( input );
			out.println( input );
		}
		
		
		{
			out.println("---------------");
			char[] input = " ABC DEF GHIJ ".toCharArray();
			out.println( input );
			ReverseAllTheWordsInASentence.reverseAllWords( input );
			out.println( input );
		}
		
		
		out.println("---------------Reverser_01_textbook");
		{
			char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
			Reversable reverser = new Reverser_01_textbook();
			reverser.reverse(chars, 0, 3);
			out.println( chars );
			reverser.reverse(chars, 3, 7);
			out.println( chars );
			reverser.reverse(chars, 7, 7);
			out.println( chars );
		}

		
		out.println("---------------Reverser_02_vector");
		{
			char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
			Reversable reverser = new Reverser_02_vector();
			reverser.reverse(chars, 0, 3);
			out.println( chars );
			reverser.reverse(chars, 3, 7);
			out.println( chars );
			reverser.reverse(chars, 7, 7);
			out.println( chars );
		}
		
		
		out.println("---------------Reverser_03_cross");
		{
			char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
			Reversable reverser = new Reverser_03_cross();
			reverser.reverse(chars, 0, 3);
			out.println( chars );
			reverser.reverse(chars, 3, 7);
			out.println( chars );
			reverser.reverse(chars, 7, 7);
			out.println( chars );
		}
		
		
		out.println( -1 / 2 );
		
	}
	
	
	

}


