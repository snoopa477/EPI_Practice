package c19_Graphs.p02_PaintABooleanMatrix;
import static java.lang.System.out;

import util.MyCoordinate;
import util.MyColor;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class PaintABooleanMatrix_01_BFS_popAndColor {
	
	
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
		
		
		//BFS: 
		//every elements should be considered before end -> try until queue is empty; in other words, Empty means all elements already considered
		//when a element is considered and processed, it introduce its neighbor( if any ) to the queue 
		
		//note: all elements are required to be valid before getting into queue. Except for the first one, which sets the rule
		Queue<MyCoordinate> bfsQueue = new LinkedList<>();
		
		//the point user specified 
		bfsQueue.add( coord );
		
		while( bfsQueue.size() > 0 ) {
			
			//process the oldest node
			MyCoordinate currentCoord = bfsQueue.poll();
			
			//WRONG Duplication of operation if I miss this check: since a node N could be more than one node's neighbor
			/*THINK_FURTHER: 
			 * difference between my method and textbook:
			 * 
			 * mine: enter queue before color the node
			 * textbook: color the node before enter the queue
			 * 
			 * compared to textbook answer, it colors the node before inserting it to queue. For a node N which has multi neighbors, since the first
			 * neighbor already colored the node N then inserted it, the second neighbor would see node N as invliad due to wrong color ( chaanged by previous neighbor
			 * => reducing duplication of node N in the queue 
			 */
			if( getColor( map, currentCoord ) == originalColor ) {
				setColor( map, currentCoord, flipColor );
				
				row = currentCoord.row;
				col= currentCoord.col;
	
				//introduce neighbors
				for( Direction direction : Direction.values() ) {
					MyCoordinate neighborCoord = new MyCoordinate(row + direction.rowOffset, col + direction.colOffSet );
					
					/*THINK_FURTHER: given a node N, it might be both node X and Y's neighbor. Suppose X first explore N, and then Y. node Node is added twice to the queue 
					/* However, the first time N is get processed might changed its color already, resulting second time no need to process 
					 */
					if( isValid(map, neighborCoord, originalColor) ) {
						bfsQueue.add( neighborCoord );
					}
				}
			}
		}
		
	}
	
	
	
	private static boolean isValid( List<List<MyColor>> map, MyCoordinate coord, MyColor originalColor ) {
		
		int row = coord.row;
		int col = coord.col;
		
		//WRONG if I put this line of code here. row and col are not inspected whether they're in the boundary
		//MyColor targetColor = map.get( row ).get( col );
		
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
	
	
	
	private static MyColor getColor( List<List<MyColor>> map, MyCoordinate coord ) {
		return map.get( coord.row ).get( coord.col );
	}

}


