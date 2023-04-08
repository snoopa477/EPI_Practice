package c19_Graphs.p02_PaintABooleanMatrix;
import static java.lang.System.out;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.MyColor;
import util.MyCoordinate;
public class PaintABooleanMatrix_02_BFS_colorAndAdd {
	
	public static boolean IS_DEBUG = false;
	
	enum Direction{
		
		UP(-1, 0)
		, DOWN( 1, 0 )
		, LEFT( 0, -1 )
		, RIGHT( 0, 1);
		
		
		private Direction(int rowOffset, int colOffSet) {
			this.rowOffset = rowOffset;
			this.colOffSet = colOffSet;
		}
		
		public int rowOffset;
		public int colOffSet;
		
	}
	
	
	
	public static void flip( List<List<MyColor>> map, MyCoordinate coord ) {
		
		int row = coord.row;
		int col = coord.col;
		MyColor originalColor = map.get( row ).get( col );
		MyColor flipColor = originalColor == MyColor.BLACK? MyColor.WHITE : MyColor.BLACK;
		
		/**
		 * PURPOSE:
		 * compared to 01 method
		 * the queue collects the elements that already flip colored. In this way
		 * given a node N that has multi neighbors A and B. when A first explore N, it colors N and add it to queue
		 * , and then when node A explores N, it finds N already has flip color, it won't add N to queue again -> eliminating duplication 
		 */
		Queue<MyCoordinate> bfsQueueOfFlippedColor = new LinkedList<>();
		
		setColor( map, coord, flipColor );
		bfsQueueOfFlippedColor.add( coord );
		
		while( bfsQueueOfFlippedColor.size() > 0 ) {
			
			MyCoordinate currentCoord = bfsQueueOfFlippedColor.poll();
			row = currentCoord.row;
			col= currentCoord.col;
			
			if( IS_DEBUG ) out.println( "currentCoord " + currentCoord + " ; Color " + map.get(row).get(col) );
			

			for( Direction direction : Direction.values() ) {
				MyCoordinate neighborCoord = new MyCoordinate(row + direction.rowOffset, col + direction.colOffSet );
				
				if( isValid(map, neighborCoord, originalColor) ) {
					
					if( IS_DEBUG ) out.println( "valid  neighborCoord" + neighborCoord + " ; Color " + map.get(neighborCoord.row).get(neighborCoord.col) );
					
					//PURPOSE
					//WRONG typo: should be `neighborCoord` instead of `coord`, this would cause infinite loop, since same input 
					//setColor( map, coord, flipColor );
					setColor( map, neighborCoord, flipColor );
					bfsQueueOfFlippedColor.add( neighborCoord );
				}
			}
		}
		
	}
	
	
	
	private static boolean isValid( List<List<MyColor>> map, MyCoordinate coord, MyColor originalColor ) {
		
		int row = coord.row;
		int col = coord.col;
		
		
		if( row < 0 || row > map.size() -1 || col < 0 || col > map.get(0).size() -1 ) {
			return false;
		}
		
		
		MyColor targetColor = map.get( row ).get( col );
		if( targetColor != originalColor ) {
			return false;
		}
		
		
		return true;
	}
	
	
	
	private static void setColor( List<List<MyColor>> map, MyCoordinate coord, MyColor targetColor ) {
		map.get( coord.row ).set( coord.col, targetColor );
	}
	
	

}


