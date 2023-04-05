package c19_Graphs.p01_SearchAMaze;
import static java.lang.System.out;

import util.MyColor;
import util.MyCoordinate;

import java.util.ArrayList;
import java.util.List;

public class Test_SearchAMaze {

	public static void main(String[] args) {
		
		SearchAMaze.IS_DEBUG = true;
		
		List<List<MyColor>> map_19_05 = MyColor.makeMap_19_05();
		
		{
			MyCoordinate start = new MyCoordinate(9, 0);
			MyCoordinate end = new MyCoordinate(0, 9);
			
			
			test(map_19_05, start, end);
		}
		
		
		{
			MyCoordinate start = new MyCoordinate(1, 1);
			MyCoordinate end = new MyCoordinate(7, 7);
			
			test(map_19_05, start, end);
		}
		
		
		{
			MyCoordinate start = new MyCoordinate(3, 2);
			MyCoordinate end = new MyCoordinate(4, 3);
			
			test(map_19_05, start, end);
		}
		
		
		{
			MyCoordinate start = new MyCoordinate(1, 1);
			MyCoordinate end = new MyCoordinate(9, 9);
			
			test(map_19_05, start, end);
		}
		
		
		out.println("the end");
	}
	
	
	
	private static void test(List<List<MyColor>> map, MyCoordinate start, MyCoordinate end ) {
		
		
		
		out.println("-------------------------------------------");
		
		out.println("Begin");
		drawMapWithPath(map, null, start, end);
		MyColor.printMap(map);
		
		out.println("try");
		List<MyCoordinate> path = SearchAMaze.searchMaze(map, start, end);
		MyColor.printMap(map);
		
		out.println("result");
		clearedMap(map);
		drawMapWithPath(map, path, start, end);
		MyColor.printMap(map);
		
		clearedMap(map);
		
		if( path != null ) {
			out.println( path );
		}
		
	}
	
	
	private static void clearedMap( List<List<MyColor>> map ) {
		
		for( List<MyColor> row: map ) {
			
			//WRONG: modification is not on individual level, but on collection
//			for( MyColor elt : row ) {
//			}
			
			for( int i = 0; i < row.size(); i++ ) {
				//WRONG: logic wrong
				//if( row.get(i) != MyColor.WHITE || row.get(i) != MyColor.BLACK ) {
				if( row.get(i) != MyColor.WHITE && row.get(i) != MyColor.BLACK ) {
					row.set( i, MyColor.WHITE );
				}
			}
			
		}
		
	}
	
	
	
	private static void drawMapWithPath( List<List<MyColor>> map, List<MyCoordinate> path, MyCoordinate start, MyCoordinate end ) {
		
		
		if( path != null ) {
			for( MyCoordinate coord: path ) {
				map.get( coord.row ).set( coord.col, MyColor.VISITED );
			}
		}
		
		
		map.get( start.row ).set( start.col, MyColor.START );
		map.get( end.row ).set( end.col, MyColor.END );
	}
	
}


