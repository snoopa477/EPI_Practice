package util;
import static java.lang.System.out;

import java.util.Objects;
public class MyCoordinate {
	
	public int row, col;

	
	
	public MyCoordinate(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	
	
	@Override
	public boolean equals( Object o ) {
		
		
		if( o == null ) {
			return false;
		}
		
		
		//same reference.
		if( this == o ) {
			return true;
		}
		
		
		//Check class before checing fields value; 
		//REASONING: if we don't endure both object have same class, we cannot compare fields 
		if( getClass() != o.getClass() ) {
			return false;
		}
		
		
		//REASONING: we can do casting because we know its the type
		MyCoordinate otherMyCoordinate = ( MyCoordinate ) o;
		
		//If we don't cast, we can't access field
		if( row == otherMyCoordinate.row && col == otherMyCoordinate.col ) {
			return true;
		}
		
		
		return false;
	}
	
	
	
	@Override
	//GUESS: for hasmap, hasSet ?
	public int hashCode() {
		return Objects.hash( row, col );
	}
	
	
	
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
	

}


