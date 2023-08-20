package c05_PrimitiveTypes.p10_GenerateUniformRandomNumbers;
import static java.lang.System.out;

import java.util.Random;
public class GenerateUniformRandomNumbers {
	
	public static boolean IS_DEBUG = false;
	
	//would be better? since we gonna uses a lot 
	private static Random rand = new Random();
	
	public static int uniformRandom(int lowerBound, int upperBound) {
		
		//IMAGINATION: vector. the origin is lowerBound, the length is upperBound - lowerBound
		
		//given lowerBound is 0
		int target_MaxRandomValue = upperBound - lowerBound;
		
		//int randomMaxInclusive;
		//DETAIL: rename, to compare, make the name similar
		int current_MaxRandomValue;
		//lowerBound is 0, upperBound is target_MaxRandomValue
		int randomValue;
		
		
		do {
			
			//int i = 1;
			int bitIndex = 1;
			randomValue = 0;

			
			do{
				current_MaxRandomValue = (1 << bitIndex) -1;
				//DETAIL: also ok for init state
				//WRONG
				//randomValue = (randomValue << 1) & get0or1Randomly();
				randomValue = (randomValue << 1) | get0or1Randomly();
				bitIndex++;
			}
			
			//PURPOSE: not until current_MaxRandomValue >= target_MaxRandomValue, meaning random value scope covers over target_MaxRandomValue
			while( current_MaxRandomValue < target_MaxRandomValue );
			
		}
		//PURPOSE: redo if the actual randomValue is greater than maxRandomValue, because there's no mapping 
		while( randomValue > target_MaxRandomValue );
		
		
		return lowerBound + randomValue;
	}
	
	
	
	private static int get0or1Randomly() {
		int val = rand.nextInt(2);
		if( IS_DEBUG ) {
			out.println( val );
		}
		return val;
	}
	

}


