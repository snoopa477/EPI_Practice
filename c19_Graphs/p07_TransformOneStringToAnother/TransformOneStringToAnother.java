package c19_Graphs.p07_TransformOneStringToAnother;
import static java.lang.System.out;

import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class TransformOneStringToAnother {

	
	private static class VertexWithDistance{
		
		public String word;
		//DETAIL: distance from `startStr`
		public int distance;
		
		
		public VertexWithDistance(String word, int distance) {
			this.word = word;
			this.distance = distance;
		} 
		
	}
	
	
	
	public static int transformstring(Set<String> words, String startStr, String targetStr) {
		
		/* PURPOSE: translate this problem into graph problem; however we don't have graph right now, have to build on our own.
		 * one character difference means distance 1, ... 2 character difference means 2... and so on
		 */
		
		/*REASONING: compared to graph, where each node has its color to inform whether it is visited or not
		 *  we use set instead: elements that is in set means unvisited.
		 *  elements that is not in set means either already visited or non-existent.
		 */
		Set<String> theUnvisited = words;
		Queue<VertexWithDistance> queueBFS = new LinkedList<>();
		
		//distance to itself is 0, starting point
		queueBFS.add( new VertexWithDistance(startStr, 0) );
		theUnvisited.remove(startStr);
		
		
		while( queueBFS.size() > 0 ) {
			
			VertexWithDistance vertextWithDisdance = queueBFS.poll();
			
			//check if we can end the task and cut off
			if( vertextWithDisdance.word.equals( targetStr ) ) {
				return vertextWithDisdance.distance;
			}
			
			
			/** PURPOSE: 
			 * build our own graph by iterating all one-difference words, and see if any elements in set 
			 * actually fits those words.
			 * If fitted, can build the edge by adding fitted vertex to queueBFS, removing it from the unvisited
			 * 
			 * queueBFS.size() might increase
			 * theUnvisited.size() might decreases
			 */
			findNeighbors( queueBFS, theUnvisited, vertextWithDisdance );
			
		}
		
		
		return 0;
	}



	private static void findNeighbors(Queue<VertexWithDistance> queueBFS, Set<String> theUnvisited, VertexWithDistance vertextWithDisdance) {
		
		
		String currentWord = vertextWithDisdance.word;
		int distanceFromStart = vertextWithDisdance.distance;
		
		/*PURPOSE: for each index i in a string, change char at i from 'a' to 'z'. We call that a one-distance new word
		 * 
		 * any element in set that fits one-distance new word is neighbor 
		 */
		for( int i = 0; i < currentWord.length(); i++  ) {
			
			/*PURPOSE: one-distance new word consists of leftPart, changedChar, rightPart
			 */
			String leftPart = currentWord.substring(0, i);
			String rightPart = currentWord.substring( i + 1 );
			
			//DETAIL: there exist a `c` that would cause oneDistanceWord same as  `currentWord`, and strictly saying it's not one-distance
			for( char c = 'a'; c <= 'z'; c++ ) {
				
				String oneDistanceWord = leftPart + c + rightPart;
				
				//check if fit?
				if( theUnvisited.contains(oneDistanceWord)  ) {
					queueBFS.add(  new VertexWithDistance ( oneDistanceWord, distanceFromStart + 1) );
					theUnvisited.remove(oneDistanceWord);
				}
				
			}
		}
		
	}
	
	
}


