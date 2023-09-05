package c06_Arrays.p01_TheDutchNationalFlagProblem;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

public class Test_TheDutchNationalFlagProblem {

	public static void main(String[] args) {
	
		{
			out.println("- - - - - TheDutchNationalFlagProblem_01_Reset - - - - -");
			
			List<Color> list01 = getList01();
			List<Color> list02 = getList02();
			List<Color> list03 = getList03();
			
			out.println(" - - - - - list01 - - - - -");
			list01.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_01_Reset.dutchFlagPartition(3, list01);
			list01.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			
			
			out.println(" - - - - - list02 - - - - -");
			list02.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_01_Reset.dutchFlagPartition(0, list02);
			list02.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			
			
			out.println(" - - - - - list03 - - - - -");
			list03.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_01_Reset.dutchFlagPartition(0, list03);
			list03.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
		
		}
		
		
		{
			out.println("- - - - - TheDutchNationalFlagProblem_02_SeekAllTheWay - - - - -");
			
			List<Color> list01 = getList01();
			List<Color> list02 = getList02();
			List<Color> list03 = getList03();
			
			out.println(" - - - - - list01 - - - - -");
			list01.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_02_SeekAllTheWay.dutchFlagPartition(3, list01);
			list01.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			
			
			out.println(" - - - - - list02 - - - - -");
			list02.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_02_SeekAllTheWay.dutchFlagPartition(0, list02);
			list02.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			
			
			out.println(" - - - - - list03 - - - - -");
			list03.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_02_SeekAllTheWay.dutchFlagPartition(0, list03);
			list03.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
		
		}
		
		
		{
			out.println("- - - - - TheDutchNationalFlagProblem_03_LeftAndRight - - - - -");
			
			List<Color> list01 = getList01();
			List<Color> list02 = getList02();
			List<Color> list03 = getList03();
			
//			TheDutchNationalFlagProblem_03_LeftAndRight.IS_DEBUG = true;
			
			out.println(" - - - - - list01 - - - - -");
			list01.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_03_LeftAndRight.dutchFlagPartition(3, list01);
			list01.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			
			
			out.println(" - - - - - list02 - - - - -");
			list02.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_03_LeftAndRight.dutchFlagPartition(0, list02);
			list02.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			
			
			out.println(" - - - - - list03 - - - - -");
			list03.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
			TheDutchNationalFlagProblem_03_LeftAndRight.dutchFlagPartition(0, list03);
			list03.forEach( o -> out.printf("%s ", o.toString()));
			out.println();
		
		}
		
	}

	

	private static List<Color> getList01() {
		return Arrays.asList( Color.BLUE, Color.BLUE, Color.RED, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.WHITE );
	}
	
	
	
	private static List<Color> getList02() {
		return Arrays.asList( Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.RED );
	}
	

	
	private static List<Color> getList03() {
		return Arrays.asList( Color.WHITE, Color.RED, Color.RED, Color.WHITE, Color.RED, Color.WHITE, Color.RED, Color.WHITE );
	}
}


