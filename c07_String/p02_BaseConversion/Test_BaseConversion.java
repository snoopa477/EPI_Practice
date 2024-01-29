package c07_String.p02_BaseConversion;
import static java.lang.System.out;
public class Test_BaseConversion {

	public static void main(String[] args) {
		
		BaseConversion.IS_DEBUG = true;
		
		out.println( BaseConversion.convertBase("615", 7, 13) );
		out.println( BaseConversion.convertBase("-615", 7, 13) );
	}

}


