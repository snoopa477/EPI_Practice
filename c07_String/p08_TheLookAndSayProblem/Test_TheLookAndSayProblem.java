package c07_String.p08_TheLookAndSayProblem;
import static java.lang.System.out;
public class Test_TheLookAndSayProblem {

	public static void main(String[] args) {
		
		for( int i = 1; i <= 8; i++ ) {
			out.println( i + " " + TheLookAndSayProblem.lookAndSay(i) );
		}
		
		
		
	}

}


