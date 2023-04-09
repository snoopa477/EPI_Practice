package util;
public enum MyDirection {

	UP(-1, 0)
	, DOWN( 1, 0 )
	, LEFT( 0, -1 )
	, RIGHT( 0, 1);
	
	
	private MyDirection(int rowOffset, int colOffSet) {
		this.rowOffset = rowOffset;
		this.colOffSet = colOffSet;
	}
	
	public int rowOffset;
	public int colOffSet;
}


