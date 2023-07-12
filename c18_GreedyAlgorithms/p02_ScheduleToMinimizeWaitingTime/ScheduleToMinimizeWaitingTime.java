package c18_GreedyAlgorithms.p02_ScheduleToMinimizeWaitingTime;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class ScheduleToMinimizeWaitingTime {

	
	public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
		
		Collections.sort( serviceTimes );
		int minimumTotalWaitingTime = 0;
		int size = serviceTimes.size();
		
		for( int i = 0; i < size; i++ ) {
			minimumTotalWaitingTime += serviceTimes.get( i ) * ( size -i -1 );
		}
		
		return minimumTotalWaitingTime;
	}
	
	
	
	public static void main(String[] args) {
		
		out.println( minimumTotalWaitingTime( Arrays.asList(2, 5, 3, 1)) );

	}

}


