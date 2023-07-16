package c18_GreedyAlgorithms.p06_TheGasupProblem;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class TheGasupProblem {

	private static boolean IS_DEBUG = false;
	private static int GALLON_PER_MILE = 20;
	
	private static class CityAndGasoline{
		public int cityIndex;
		//how much gasoline remains in this city
		public int gasolineRemains;
		
		
		public CityAndGasoline(int cityIndex, int gasolineRemains) {
			super();
			this.cityIndex = cityIndex;
			this.gasolineRemains = gasolineRemains;
		}
	}
	
	
	
	/* gallons:
	 * 	gallons[i] v. amount of refill v from city i
	 * 
	 * distances
	 * 	distance[i] v. the distance v, between city i and next city i+1 
	 * 
	 * return: the index of cities
	 * 
	 */
	public static int findAmpleCity(List<Integer> gallons, List<Integer> distances) {
		
		/**
		 * REASONING:
		 * the relative gasoline remains in car in each city is `independent from` whichever city a car start with.
		 * 
		 * PURPOSE:
		 * for simplicity, we start with the city[0] to gain the relative gasoline remains in car in all cities
		 * and only record the city with minimum relative gasoline remains.
		 * 
		 * the city we start with, its gasoline remains will be set as zero.
		 * if we pick the city to start, which has the minimum gasolines remains, 
		 * we can infer that all the other cities having more than zero gasoline remains, and 
		 * we can therefore say that the car can travel all the city without running out of gasolines
		 */
		
		/*DETAIL: we don't record the how gasoline changes among the process from one city to another, we only record gasoline when we arrive at a city
		 */
		
		//to start with, the car has no gasolines
		CityAndGasoline cityWithLeastGasoline = new  CityAndGasoline( 0, 0 );
		int gallonRemainsAtNextCity = 0;
		
		for( int i = 0; i < gallons.size(); i++ ) {
			
			int gallonRefillAtStartCity = gallons.get( i );
			int gallonConsumed = distances.get( i ) / GALLON_PER_MILE;
			
			if( IS_DEBUG ) {
				out.println( "city index: " + (i + 1) + ", gallonInThisCity: " + gallonRemainsAtNextCity );
			}
			
			gallonRemainsAtNextCity = gallonRemainsAtNextCity + gallonRefillAtStartCity - gallonConsumed;
			
			//find the min
			if( gallonRemainsAtNextCity < cityWithLeastGasoline.gasolineRemains  ) {
				cityWithLeastGasoline = new CityAndGasoline( i + 1, gallonRemainsAtNextCity );
			}
			
		}
		
		//there must exist a city that has least gasoline remains
		return cityWithLeastGasoline.cityIndex;
	}
	
	
	
	public static void main(String[] args) {
		
		//IS_DEBUG = true;
		out.println( findAmpleCity( 
				Arrays.asList(50, 20, 5, 30, 25, 10, 10)
				, Arrays.asList(900, 600, 200, 400, 600, 200, 100) ) );
		
	}

}

