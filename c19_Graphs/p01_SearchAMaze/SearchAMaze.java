package c19_Graphs.p01_SearchAMaze;
import static java.lang.System.out;

import util.MyColor;
import util.MyCoordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchAMaze {
	
	public static boolean IS_DEBUG = false;
	
	enum Direction{
		
		UP(-1, 0),
		DOWN(1, 0),
		RIGHT(0, 1),
		LEFT(0, -1);
		
		public int rowOffset;
		public int colOffset;
		
		
		private Direction(int rowOffset, int colOffset) {
			this.rowOffset = rowOffset;
			this.colOffset = colOffset;
		}
		
		
	}
	
	
	
	public static List<MyCoordinate> searchMaze( List<List<MyColor>> maze, MyCoordinate start, MyCoordinate end ){
		
		
		//WRONG: typo
		//if( isValid(maze, start) == false || isValid(maze, end)) {
		if( isValid(maze, start) == false || isValid(maze, end) == false ) {
			if(IS_DEBUG) out.println(" start or end is invalid ");
			return null;
		}
		
		List<Direction> directions = getDirections( start, end );
		
		List<MyCoordinate> path = new ArrayList<>();
		
		
		path.add( start );
		searchMazeHelper( maze, directions, path, start, end);
		
		return path;
	}
	
	
	
	/**
	 * 
	 * DO: if there exist a path(which means its subcalls) from this `current` to `end` -> return true
	 * else return false
	 * 
	 * @param maze
	 * @param directions
	 * @param path
	 * @param current
	 * @param start
	 * @param end
	 * @return
	 */
	//NOTE: invalid position would never call this method, will be filtered first
	private static boolean searchMazeHelper( List<List<MyColor>> maze, List<Direction> directions, List<MyCoordinate> path, MyCoordinate current, MyCoordinate end ) {
		
		
		if( current.equals( end ) ) {
			//WRONG: this won't need; Otherwise its duplicate,  because the caller already add the next step beforehand; in this case, the next step is end 
//			path.add( current );
			return true;
		}
		
		
		//check all four directions; filter out those invalid: obstacle or visited. 
		//go try the remaining valid points
		for( Direction direction : directions ) {
			
			//if is valid, assume this is a point which can lead to destination
			MyCoordinate nextStep = new MyCoordinate(current.row + direction.rowOffset, current.col + direction.colOffset);
			if( isValid(maze, nextStep) ) {
				
				//take next step
				path.add( nextStep );
				
//				MyColor nextStepColor = maze.get( nextStep.row ).get( nextStep.col ); 
//				nextStepColor =  MyColor.VISITED ;
				//THINK_FURTHER: this point is taken, which might affect other point's potential option among 4: from valid to invalid.
				maze.get( nextStep.row ).set( nextStep.col, MyColor.VISITED ); 
				
				
				boolean result = searchMazeHelper( maze, directions, path, nextStep, end );
				//cut off if we find a path to destination. remaining possible paths are ignored
				if( result == true ) {
					return true;
				}
				//else, prepare for the next direction in next round
				
				//since we don't find any path to destination, which counter the assumption that this point can lead to destination => remove this point
				path.remove( path.size() -1 );
			}
			
			
		}
		
		//reaching here meaning all 4 options are failed -> this point doesn't have path to end
		return false;
	}
	
	
	
	private static boolean isValid( List<List<MyColor>> maze, MyCoordinate current ) {
		
		int row = current.row;
		int col  = current.col;
		
		//WRONG: out of boundary exceptoin
		//if( row < 0 || row > maze.size() || col < 0 || col > maze.get(0).size() ) {
		if( row < 0 || row > maze.size() -1  || col < 0 || col > maze.get(0).size() -1 ) {
			return false;
		}
		
		
		//if( maze.get( row ).get( col ) != MyColor.WHITE && maze.get( row ).get( col ) != MyColor.START  && maze.get( row ).get( col ) != MyColor.END) {
		MyColor coordColor = maze.get( row ).get( col );
		if( coordColor != MyColor.WHITE && coordColor != MyColor.START  && coordColor != MyColor.END) {
			return false;
		}
		
		return true;
	}
	
	
	
	//PURPOSE: slight optimization
	private static List<Direction> getDirections( MyCoordinate start, MyCoordinate end ){
		
		//4 directions
		List<Direction> directions ;
		Direction[] arr_directions = new Direction[4];
		
		
		//Don't use list to speicify position, use array instead
		
		//go down first
		if( end.row - start.row > 0) {
			arr_directions[0] = Direction.DOWN;
			arr_directions[2] = Direction.UP;
//			directions.add(0, Direction.DOWN );
//			directions.add(2, Direction.UP );
		}
		//go up first
		else {
			arr_directions[0] = Direction.UP;
			arr_directions[2] = Direction.DOWN;
//			directions.add(0, Direction.UP );
			//IndexOutOfBoundsException
//			directions.add(2, Direction.DOWN );
//			directions.add(2, Direction.DOWN );
		}
		
		
		
		if( end.col- start.col > 0) {
			arr_directions[1] = Direction.RIGHT;
			arr_directions[3] = Direction.LEFT;
		}
		//go up first
		else {
			arr_directions[1] = Direction.LEFT;
			arr_directions[3] = Direction.RIGHT;
		}
		
		directions = Arrays.asList( arr_directions );
				
		return directions;
	}
	
}















