package c06_Arrays.p17_ComputeTheSpiralOrderingOfA02dArray;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
public class ComputeTheSpiralOrderingOfA02dArray_02_Obstacle {
	
	private static Integer VISITED = 0;
	
	private static class Coordinate{
		
		public int row = 0;
		public int col = 0;
		
		public Coordinate(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		
		
		public void nextStep( Direction dir ) {
			this.row = this.row + dir.getRow();
			this.col = this.col + dir.getCol();
		}
	}
	
	
	static Coordinate coordinateRight = new Coordinate(0, 1);
	static Coordinate coordinateDown = new Coordinate(1, 0);
	static Coordinate coordinateLeft = new Coordinate(0, -1);
	static Coordinate coordinateUp = new Coordinate(-1, 0);
	
	
	private enum Direction{
		
		RIGHT( coordinateRight ), DOWN(coordinateDown), LEFT(coordinateLeft), UP(coordinateUp);
		
		Coordinate coordinate;
		
		private Direction(Coordinate coordinate) {
			this.coordinate = coordinate;
		}
		
		static Direction nextDirection( Direction direction ) {
			int totalNumberOfDirections = Direction.values().length;
			Direction nextDirection = Direction.values() [ (direction.ordinal() + 1 ) % totalNumberOfDirections];
			return nextDirection;
		}
		
		public int getRow() {
			return coordinate.row;
		}
		
		public int getCol() {
			return coordinate.col;
		}
	};
	
	
	
	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
	
		Coordinate coord = new Coordinate(0, 0);
		Direction dir = Direction.RIGHT;
		
		List<Integer> spiralOrder = new ArrayList<>();
		
		while( true ) {
			
			spiralOrder.add( squareMatrix.get(coord.row).get(coord.col) );
			setMatrixVisited( coord, squareMatrix );
			
			if( hasWayToGo(coord, squareMatrix ) == false) {
				break;
			}
			
			if( isNextStepValid(coord, dir, squareMatrix) == false ) {
				dir = Direction.nextDirection( dir );
			}
			
			coord.nextStep(dir);
		}
		
		
		return spiralOrder;
	}



	private static boolean isNextStepValid( Coordinate coord, Direction currentDir, List<List<Integer>> squareMatrix ) {
		
		int nextRow = coord.row + currentDir.getRow();
		int nextCol= coord.col + currentDir.getCol();
		
		int leftBound = 0;
		int rightBound = squareMatrix.size() -1;
		
		int upBound = 0;
		int downBound = squareMatrix.size() -1;
		
		return nextRow >= upBound && nextRow <= downBound 
			&& nextCol >= leftBound && nextCol <= rightBound
			&& squareMatrix.get(nextRow).get(nextCol) != VISITED;
	}
	
	
	
	private static boolean hasWayToGo( Coordinate coord, List<List<Integer>> squareMatrix ) {
		
		return isNextStepValid(coord, Direction.RIGHT, squareMatrix) || 
			isNextStepValid(coord, Direction.DOWN, squareMatrix) ||
			isNextStepValid(coord, Direction.LEFT, squareMatrix) ||
			isNextStepValid(coord, Direction.UP, squareMatrix);
	}
	
	
	
	private static void setMatrixVisited(Coordinate coord, List<List<Integer>> squareMatrix) {
		squareMatrix.get( coord.row ).set( coord.col, VISITED );
	}
	
	
}


