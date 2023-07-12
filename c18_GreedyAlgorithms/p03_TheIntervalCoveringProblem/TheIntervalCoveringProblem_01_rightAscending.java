package c18_GreedyAlgorithms.p03_TheIntervalCoveringProblem;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TheIntervalCoveringProblem_01_rightAscending {

	
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
		
		/* REASONING 1:
		 * sort is bettern than not sorted
		 * because we can only consider the intervals that are larger than the current interval
		 * and ignore those intervals which are smaller
		 * 
		 * REASONING 2:
		 * if we gonna sort by right end
		 * then we have to sort ascendingly 
		 * this way,
		 * given current interval c, and the other interval o
		 * if o intersects with c, then o.left < c.right
		 * if o doesn't intersect with c, then o.left > c.right
		 * 
		 * therefore, we can tell intersection or not by checking o.left and c.right
		 * 
		 * THINK_FURTHER:
		 * why does sort by right end descendingly not working? 
		 * when o intersects with c, then o.left < c.right
		 * when o doesn't intersect with c, then o.left < c.right
		 * 
		 * we CANNOT tell intersection or not by checking o.left and c.right
		 */
		
		List<Integer> visitTimes = new ArrayList<>();
		
		Collections.sort( intervals, 
		(o1, o2) -> o1.right - o2.right );
		
		
		int currentVisitTime = intervals.get( 0 ).right;
		visitTimes.add( currentVisitTime );
		
		//DETAIL: ignore the first element, since we already added to result list
		for( int i = 1; i < intervals.size(); i++ ) {
			
			//DETAIL: we consider left end, since all right end of candidates are larger than current interval
			int otherVisitStartTime = intervals.get( i ).left;
			
			//PURPOSE: current visit time cannot intersects with this interval => add this interval.right to our result list
			if( currentVisitTime < otherVisitStartTime ) {
				
				int otherVisitEndTime = intervals.get( i ).right;
				visitTimes.add( otherVisitEndTime );
				//update 
				currentVisitTime = otherVisitEndTime;
				
			}
			/*THINK_FURTHER 
			 * else, those intervals such that currentVisitTime >= otherVisitStartTime, 
			 * intersects with currentVisitTime, so we don't add additional time to visit those intervals 
			 * cuz current interval.right overlaps with them*/
			
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


