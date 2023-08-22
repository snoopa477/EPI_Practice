package c05_PrimitiveTypes.p11_RectangleIntersection;
import static java.lang.System.out;
public class RectangleIntersection {
	
	
	public static class Rectangle{
		
		public int x;
		public int y;
		public int width;
		public int height;
		
		public Rectangle(int x, int y, int width, int height) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}
	
	
	
	public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
		
		if( isIntersect(r1, r2) ) {
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
		int newRight = Math.min(r1.x, r2.x);
		
		int newX = newLeft;
		int newWidth = newRight - newLeft;
		
		
		int newDown = Math.max(r1.y, r2.y);
		int newUp = Math.min(r1.y, r2.y);
		
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
	

}








