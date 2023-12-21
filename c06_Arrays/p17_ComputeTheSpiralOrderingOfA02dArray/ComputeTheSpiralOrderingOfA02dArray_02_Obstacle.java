package c06_Arrays.p17_ComputeTheSpiralOrderingOfA02dArray;
import static java.lang.System.out;

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
	}
	
	static Coordinate coordinateRight = new Coordinate(1, 0);
	static Coordinate coordinateDown = new Coordinate(0, 1);
	static Coordinate coordinateLeft = new Coordinate(-1, 0);
	static Coordinate coordinateUp = new Coordinate(0, -1);
	
	private enum Direction{
		RIGHT( coordinateRight ), DOWN(coordinateDown), LEFT(coordinateLeft), UP(coordinateUp);
		
		Coordinate coordinate;
		
		private Direction(Coordinate coordinate) {
			this.coordinate = coordinate;
		}
		
		Direction nextDirection( Direction direction ) {
			int totalNumberOfDirections = Direction.values().length;
			Direction nextDirection = Direction.values() [ (direction.ordinal() + 1 ) % totalNumberOfDirections];
			return nextDirection;
		}
	};
	
	
	
	
	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
	
		int row = 0;
		int col = 0;
		
		
		
		
		return null;
	}
}


