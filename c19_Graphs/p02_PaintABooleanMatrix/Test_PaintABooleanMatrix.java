package c19_Graphs.p02_PaintABooleanMatrix;
import static java.lang.System.out;

import java.util.List;
import util.MyColor;
import util.MyCoordinate;


public class Test_PaintABooleanMatrix {

	public static void main(String[] args) {
		
		{
			out.println("\n\n----------test PaintABooleanMatrix_01_BFS_popAndColor");
			List<List<MyColor>> map_quasi_19_05 = MyColor.makeMap_quasai_19_05();
			
			out.println("\n---original map");
			MyColor.printMap(map_quasi_19_05);
			
			MyCoordinate coord = new MyCoordinate(1, 4);
			
			out.println("\n---flip at " + coord);
			PaintABooleanMatrix_01_BFS_popAndColor.flip(map_quasi_19_05, coord);
			MyColor.printMap(map_quasi_19_05);
			
			
			out.println("\n---flip at " + coord);
			PaintABooleanMatrix_01_BFS_popAndColor.flip(map_quasi_19_05, coord);
			MyColor.printMap(map_quasi_19_05);
			
		}
		
		
		{
			out.println("\n\n----------test PaintABooleanMatrix_02_BFS_colorAndAdd");
			List<List<MyColor>> map_quasi_19_05 = MyColor.makeMap_quasai_19_05();
			
			PaintABooleanMatrix_02_BFS_colorAndAdd.IS_DEBUG = false;
			
			out.println("\n---original map");
			MyColor.printMap(map_quasi_19_05);
			
			MyCoordinate coord = new MyCoordinate(1, 4);
			
			out.println("\n---flip at " + coord);
			PaintABooleanMatrix_02_BFS_colorAndAdd.flip(map_quasi_19_05, coord);
			MyColor.printMap(map_quasi_19_05);
			
			
			out.println("\n---flip at " + coord);
			PaintABooleanMatrix_02_BFS_colorAndAdd.flip(map_quasi_19_05, coord);
			MyColor.printMap(map_quasi_19_05);
			
		}
		
		
		{
			out.println("\n\n----------test PaintABooleanMatrix_03_DFS");
			List<List<MyColor>> map_quasi_19_05 = MyColor.makeMap_quasai_19_05();
			
			PaintABooleanMatrix_03_DFS.IS_DEBUG = false;
			
			out.println("\n---original map");
			MyColor.printMap(map_quasi_19_05);
			
			MyCoordinate coord = new MyCoordinate(1, 4);
			
			out.println("\n---flip at " + coord);
			PaintABooleanMatrix_03_DFS.flip(map_quasi_19_05, coord);
			MyColor.printMap(map_quasi_19_05);
			
			
			out.println("\n---flip at " + coord);
			PaintABooleanMatrix_03_DFS.flip(map_quasi_19_05, coord);
			MyColor.printMap(map_quasi_19_05);
			
		}
		
	}

}


