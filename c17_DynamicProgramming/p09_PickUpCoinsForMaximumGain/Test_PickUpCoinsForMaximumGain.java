package c17_DynamicProgramming.p09_PickUpCoinsForMaximumGain;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

public class Test_PickUpCoinsForMaximumGain {

	public static void main(String[] args) {
		
		List<Integer> coins01 = Arrays.asList( 5, 25, 10, 1 );
		List<Integer> coins02 = Arrays.asList( 25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10 );
		
		
		out.println( _1709_PickUpCoinsForMaximumGain.pickUpCoins( coins01 ) ); 
		out.println( PickUpCoinsForMaximumGain.pickUpCoins( coins01 ) );
		
		
		out.println( _1709_PickUpCoinsForMaximumGain.pickUpCoins( coins02 ) ); 
		out.println( PickUpCoinsForMaximumGain.pickUpCoins( coins02 ) );
		
		
	}

}


