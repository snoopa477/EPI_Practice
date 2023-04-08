package c19_Graphs.p02_PaintABooleanMatrix;
import static java.lang.System.out;

import java.util.List;

import util.MyColor;
import util.MyCoordinate;
public class PaintABooleanMatrix_03_DFS {
	
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
		
		//the first point user specified decides what color to flip
		int row = coord.row;
		int col = coord.col;
		MyColor originalColor = map.get( row ).get( col );
		MyColor flipColor = originalColor == MyColor.BLACK? MyColor.WHITE : MyColor.BLACK;
		
		flipHelper( map, coord, originalColor, flipColor );
		
	}
	
	
	
	//only valid point get involved in this method 
	private static void flipHelper( List<List<MyColor>> map, MyCoordinate coord, MyColor originalColor, MyColor flipColor ) {
		
		if( IS_DEBUG ) out.println("coord is " + coord );
		
		setColor( map, coord, flipColor );
		
		int row = coord.row;
		int col = coord. col;
		
		for( Direction direction : Direction.values() ) {
			
			//IMAGINATION: it's like binary tree descendant: root, root.left, root.right
			MyCoordinate nextCoord = new MyCoordinate(row + direction.rowOffset, col + direction.colOffSet );
			
			//WRONG: typo, or, the naming is confusion so I pick the wrong var. the cause one layer call and ends, since first coord already colored -> not valid
			//if( isValid(map, coord, originalColor) ) {
			if( isValid(map, nextCoord, originalColor) ) {
				//PURPOSE: DFS
				flipHelper( map, nextCoord, originalColor, flipColor );
			}
		}
		
		//THINK_FURTHER reaching here meaning either it has no options, or it already explored all the options. Time to return, let the previous node consider next option.
		
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


