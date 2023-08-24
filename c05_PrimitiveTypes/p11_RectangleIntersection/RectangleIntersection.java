package c05_PrimitiveTypes.p11_RectangleIntersection;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class RectangleIntersection {
	
	
	public static class Rectangle{
		
		public int x;
		public int y;
		public int width;
		public int height;
		
		public String symbol;
		
		public Rectangle(String symbol, int x, int y, int width, int height) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
			this.symbol = symbol;
		}
		
		
		public Rectangle(int x, int y, int width, int height) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
		}

		@Override
		public String toString() {
			return "Rectangle [symbol=" + symbol + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
		}
	}
	
	
	
	public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
		
		//WRONG
		//if( isIntersect(r1, r2) ) {
		if( isIntersect(r1, r2) == false ) {
			return new Rectangle(0, 0, -1, -1);//something not existent
		}
		
		/**
		 * x---->
		 *   x-----> 
		 */
		int newLeft = Math.max(r1.x, r2.x);
		/*
		 *  <-----x
		 *    <------x 
		 */
		//WRONG
		//int newRight = Math.min(r1.x, r2.x);
		int newRight = Math.min( r1.x + r1.width, r2.x + r2.width );
		
		int newX = newLeft;
		int newWidth = newRight - newLeft;
		
		
		int newDown = Math.max(r1.y, r2.y);
		//int newUp = Math.min(r1.y, r2.y);
		int newUp = Math.min( r1.y + r1.height, r2.y + r2.height );
		
		int newY = newDown;
		int newHeight = newUp - newDown;
		
		
		return new Rectangle(newX, newY, newWidth, newHeight);
	}
	
	
	
	public static boolean isIntersect( Rectangle r1, Rectangle r2 ) {
		
		int r1_left = r1.x;
		int r1_right = r1.x + r1.width;
		
		int r2_left = r2.x;
		int r2_right = r2.x + r2.width;
		
		int r1_down = r1.y;
		int r1_up = r1.y + r1.height;
		
		int r2_down = r2.y;
		int r2_up = r2.y + r2.height;
		
		/**
		 * IMAGINATION: 
		 * 
		 * to intersect: r1_right >= r2_left
		 * r1 points to left
		 * r2 points to right
		 * then r1's rightmost(r1_right) must be right side of r2's leftmost(r2_left)
		 * 
		 * r1:           <------x
		 * r2 x----->
		 * 
		 * then to intersect
		 * r1's leftmost is smaller than r2's rightmost
		 * 
		 * r1:           <------x
		 * r2 x------------>
		 *  
		 */
		boolean isIntersect_leftRight = r1_right >= r2_left && r1_left <= r2_right;
		
		//symmetric
		boolean isIntersect_upDown = r1_up >= r2_down && r1_down <= r2_up;
		
		return isIntersect_leftRight && isIntersect_upDown;
	}
	
	
	public static void main( String[] args) {
		
		int[][] rectArgs = { {0,0,3,3}, {3,3,10,3}, {8,2,1,10}, {20,0,5,10}, {25,0,5,5}, {24,8,10,4}, {28,10,1,1}, {30,6,10,10}, {40,6,10,10}, {43,3,3,10}};
		
		List<Rectangle> rectangles = new ArrayList<>();
		
		for( int i = 0; i < rectArgs.length; i++ ) {
			rectangles.add( new Rectangle(String.valueOf(  (char)('A' + i)), rectArgs[i][0], rectArgs[i][1], rectArgs[i][2], rectArgs[i][3]) );
		}
		
		rectangles.forEach( o-> out.println(o) );
		
		for( int i = 0; i < rectangles.size(); i++ ) {
			for( int j = i + 1; j < rectangles.size(); j++ ) {
				
				Rectangle intersection = intersectRectangle( rectangles.get(i) , rectangles.get(j));
				
				if( intersection.width != -1 ) {
					out.println();
					out.println( rectangles.get(i).symbol + " " +rectangles.get(j).symbol );
					out.println( intersection );
				}
				
			}
		}
		
	}

}








