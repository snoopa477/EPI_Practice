package c19_Graphs.p08_TeamPhotoday_02;
import static java.lang.System.out;

import java.util.HashMap;
import util.MyGraphVertexWithValue;

import util.MyGraphVertex;
public class Test_TeamPhotoday_02 {

	public static void main(String[] args) {
		
		HashMap<String, MyGraphVertex> graph_problem19_08 = MyGraphVertexWithValue.getGraph_problem19_08();
		MyGraphVertexWithValue.setValueBFS( graph_problem19_08, 1 );
		
		out.println( TeamPhotoday_02.findLargestTeams( MyGraphVertexWithValue.convertToList2 (graph_problem19_08) ) );
		
		
		
	}

}


