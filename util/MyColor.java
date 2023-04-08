package util;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public enum MyColor {
	
	WHITE("[ ]")
	, BLACK("[X]")
	, VISITED("[.]")
	, START("[S]")
	, END("[E]");
	

	public String symbol;

	private MyColor(String symbol) {
		this.symbol = symbol;
	}
	
	
	public static List<List<MyColor>> makeMap_19_05(){
		
		List<List<MyColor>> map = new ArrayList<>();
		map.add( new ArrayList<>(  makeRow( 1, 0, 0, 0, 0, 0, 1, 1, 0 ,0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 0, 1, 0, 0, 0, 0, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 1, 0, 0, 1, 1, 0, 1, 1)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 0, 0, 1, 1, 1, 0, 0, 1, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 1, 1, 0, 0, 0, 0, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 1, 1, 0, 0, 1, 0, 1, 1, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 1, 0, 1, 0, 1, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 1, 1, 0, 0, 0, 1, 1, 1)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 0, 0, 0, 0, 0, 0, 1, 1, 0)  )  );
		
		return map;
	}
	
	
	
	public static List<List<MyColor>> makeMap_quasai_19_05(){
		
		List<List<MyColor>> map = new ArrayList<>();
		map.add( new ArrayList<>(  makeRow( 1, 0, 0, 0, 0, 0, 1, 1, 0 ,0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 0, 1, 0, 0, 0, 1, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 1, 0, 0, 1, 1, 0, 1, 1)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 0, 0, 1, 1, 1, 0, 0, 1, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 1, 1, 0, 1, 1, 0, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 1, 1, 0, 0, 1, 1, 1, 1, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 0, 0, 1, 0, 1, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 1, 0, 1, 0, 1, 0, 0, 0)  )  );
		map.add( new ArrayList<>(  makeRow( 1, 0, 1, 1, 0, 0, 0, 1, 1, 1)  )  );
		map.add( new ArrayList<>(  makeRow( 0, 1, 0, 0, 0, 0, 0, 1, 1, 0)  )  );
		
		return map;
	}
	
	
	
	private static List<MyColor> makeRow( MyColor... myColors ){
		return Arrays.asList( myColors );
	}

	
	
	private static List<MyColor> makeRow( int... symbolOrdinals ){
		
		List<MyColor> row = new ArrayList<>();
		
		for( int ordinal : symbolOrdinals ) {
			
			if( ordinal == 0 ) {
				row.add( MyColor.WHITE );
			}
			else {
				row.add( MyColor.BLACK );
			}
			
		}
		
		return row;
	}
	
	
	
	public static void printMap( List<List<MyColor>> map ) {
		
		//WRONG; forget to add: nullPointerExceptoin
		if( map == null ) {
			return ;
		}
		
		for( List<MyColor> row : map ) {
			StringJoiner sj = new StringJoiner("");
			for( MyColor elt: row ) {
				sj.add( elt.symbol );
			}
			out.println(sj.toString());
			//out.println();
		}
		
	}
	
	
	
	public static void main( String[] args ) {
		
		List<List<MyColor>> map_19_05 = makeMap_19_05();
		printMap( map_19_05 );
		
		
	}


	void set(MyColor newColor) {
		
	}
	
}


