package c18_GreedyAlgorithms.p03_TheIntervalCoveringProblem;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheIntervalCoveringProblem_02_leftDescending {

	private static class Interval{
		public int left;
		public int right;
		
		
		public Interval(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
	
	
	
	public static List<Integer> findMinimumVisits(List<Interval> intervals) {
		
		
		
		List<Integer> visitTimes = new ArrayList<>();
		
		Collections.sort( intervals, 
		//(o1, o2) -> o1.right - o2.right );
		//PURPOSE in contrast to way01, sort by left end descendingly
		(o1, o2) -> o2.left - o1.left );
		
		
		//PURPOSE
		int currentVisitTime = intervals.get( 0 ).left;
		visitTimes.add( currentVisitTime );
		
		for( int i = 1; i < intervals.size(); i++ ) {
			
			//PURPOSE
			int otherVisitStartTime = intervals.get( i ).right;
			
			//PURPOSE
			//if( currentVisitTime < otherVisitStartTime ) {
			if( currentVisitTime > otherVisitStartTime ) {
				
				//PURPOSE
				int otherVisitEndTime = intervals.get( i ).left;
				visitTimes.add( otherVisitEndTime );
				currentVisitTime = otherVisitEndTime;
			}
		}
		
		
		return visitTimes;
	}
	
	
	
	public static void main(String[] args) {
		
		out.println( findMinimumVisits( getIntervals01() ) );
		out.println( findMinimumVisits( getIntervals02() ) );
		
	}
	
	
	
	private static List<Interval> getIntervals01(){
		
		List<Interval> list_intervals = new ArrayList<>();
		
		Integer[][] intervals = { {0,3}, {2,6}, {3,4}, {6,9} };
		for( int i = 0; i < intervals.length; i++ ) {
			list_intervals.add( new Interval( intervals[i][0] , intervals[i][1] ) );
		}
		
		return list_intervals;
	}
	
	
	
	private static List<Interval> getIntervals02(){
		
		List<Interval> list_intervals = new ArrayList<>();
		
		Integer[][] intervals = { {3,4}, {1,2}, {2,3}, {3,4}, {4,5}, {2,3} };
		for( int i = 0; i < intervals.length; i++ ) {
			list_intervals.add( new Interval( intervals[i][0] , intervals[i][1] ) );
		}
		
		return list_intervals;
	}
}


