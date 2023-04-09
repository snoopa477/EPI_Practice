package c19_Graphs.p03_ComputeEnclosedRegions;
import static java.lang.System.out;

import util.MyCoordinate;
import util.MyColor;
import util.MyDirection;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.stream.*;

public class ComputeEnclosedRegions {
	
	public static boolean IS_DEBUG = false;

	
	public static void fillSurroundingRegion( List<List<MyColor>> map ) {
		
		/*PURPOSE: 
		 * step 1:
		 * scanning: find out all boundary, and mark their corresponding regions to fill later on
		 * 
		 * step 2:
		 * fill the regions based on the marked regions to fill
		 * 
		 * After this operation, the regions that are left off are those cannot reach to boundary
		 */
		
		
		final int firstRow = 0;
		final int lastRow = map.size() -1;		
		final int firstCol = 0;
		final int lastCol = map.get(0).size() -1;
		
		List<List<Boolean>> mapOfMarkersToFill = getMapOfMarkersToFill( map );
		
		//step 1
		//step 1.1
		//scan vertically, check right and left boundary of map
		for( int row = 0; row <= lastRow; row++ ) {
			
			//left
			
			//MyColor leftColor = map.get( row ).get( firstCol );
			//Boolean isMarked_left = mapOfMarkersToFill.get( row ).get( firstCol );
			
			//MyColor leftColor = mapElementGetter( map, row, firstCol );
			//Boolean isMarked_left = mapElementGetter( mapOfMarkersToFill, row, firstCol );
			
			if( isValidToMark(map, mapOfMarkersToFill, row, firstCol ) ) {
				markRegionsToFill(map, mapOfMarkersToFill, row, firstCol );
			}
			
			//right
			if( isValidToMark(map, mapOfMarkersToFill, row, lastCol ) ) {
				markRegionsToFill(map, mapOfMarkersToFill, row, lastCol );
			}
		}
		
		
		//step1.2
		//scan horizontally, check up and bottom boundary of map
		for( int col = 0; col <= lastCol; col++ ) {
			//up
			if( isValidToMark(map, mapOfMarkersToFill, firstRow, col ) ) {
				markRegionsToFill(map, mapOfMarkersToFill, firstRow, col );
			}
			
			//down
			if( isValidToMark(map, mapOfMarkersToFill, lastRow, col ) ) {
				markRegionsToFill(map, mapOfMarkersToFill, lastRow, col );
			}
		}
		
		
		if( IS_DEBUG ) {
			MyColor.printGenericMap( mapOfMarkersToFill );
		}
		
		
		
		//step 2 fill the regions based on the marked regions to fill
		for( int row = 0; row <= lastRow; row++ ) {
			for( int col = 0; col <= lastCol; col++ ) {
				
				if( mapElementGetter( mapOfMarkersToFill, row, col) == true ) {
					mapElementSetter( map, row, col, MyColor.BLACK );
				}
			}
		}
		
	}
	
	
	
	private static<T> T mapElementGetter( List<List<T>> map, int row, int col) {
		return  map.get( row ).get( col );
	}
	
	
	
	private static<T> void mapElementSetter( List<List<T>> map, int row, int col, T value) {
		map.get( row ).set( col, value );
	}
	
	
	
	//BFS
	private static void markRegionsToFill( List<List<MyColor>> map, List<List<Boolean>> mapOfMarkersToFill, int row, int col ) {
		
		MyCoordinate originalCoord = new MyCoordinate(row, col);
		Queue<MyCoordinate> queueBFS = new LinkedList<>();
		mapElementSetter( mapOfMarkersToFill, row, col, true );
		queueBFS.add( originalCoord );
		
		while( queueBFS.size() > 0 ) {
			
			//--
			MyCoordinate poppedCoord = queueBFS.poll();
			
			for( MyDirection direction : MyDirection.values() ) {
				
				MyCoordinate nextCoord = new MyCoordinate( poppedCoord.row + direction.rowOffset, poppedCoord.col + direction.colOffSet );
				if( isValidToMark(map, mapOfMarkersToFill, nextCoord) ) {
					//++
					mapElementSetter( mapOfMarkersToFill, nextCoord.row, nextCoord.col, true );
					queueBFS.add( nextCoord );
				}
			}
		}
		
		
	}
	
	
	
	private static boolean isValidToMark( List<List<MyColor>> map, List<List<Boolean>> mapOfMarkersToFill, int row, int col ) {
		return isValidToMark( map, mapOfMarkersToFill, new MyCoordinate(row, col) );
	}
	
	
	
	private static boolean isValidToMark( List<List<MyColor>> map, List<List<Boolean>> mapOfMarkersToFill, MyCoordinate coord ) {
		
		int row = coord.row;
		int col = coord.col;
		
		if( row < 0 || row > map.size() -1 
				|| col < 0 || col > map.get(0).size() -1) {
			return false;
		}
		
		//now we can confirm row and col valid, go get the color
		MyColor color = mapElementGetter( map, row, col );
		if( color != MyColor.WHITE ) {
			return false;
		}
		
		//PURPOSE: it's possible that there exist marker to fill by previous exploration; if so, skip so no duplication of work.
		if(  mapElementGetter( mapOfMarkersToFill, row, col ) == true ) {
			return false;
		}
		
		return true;
	}
	
	
	
	private static List<List<Boolean>> getMapOfMarkersToFill( List<List<MyColor>> map ){
		
		List<List<Boolean>> mapOfMarkersToFill = new ArrayList<>( );
		
		//WRONG: Cannot infer type argument(s) for <R> map(Function<? super T,? extends R>)
		//Stream.of(map.get(0))
		for( int row = 0; row < map.size(); row++ ) {
			mapOfMarkersToFill.add(
				map.get( row ).stream()
					//WRONG: we only need default value, which is all false
					//.map( color -> Boolean.valueOf( color == MyColor.WHITE ) )
					.map( color -> false )
					.collect(Collectors.toList())
			);
		}
		
		return mapOfMarkersToFill;
	}
	
	
}


