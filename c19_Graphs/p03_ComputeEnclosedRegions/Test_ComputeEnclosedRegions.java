package c19_Graphs.p03_ComputeEnclosedRegions;
import static java.lang.System.out;

import util.MyColor;
import java.util.List;

public class Test_ComputeEnclosedRegions {

	public static void main(String[] args) {
		
		List<List<MyColor>> map = MyColor.makeMap_quasai_19_05_02();
		
		MyColor.printMap(map);
		
		out.println("--------");
		
//		ComputeEnclosedRegions.IS_DEBUG = true;
		
		ComputeEnclosedRegions.fillSurroundingRegion(map);
		
		MyColor.printMap(map);
		
	}

}


