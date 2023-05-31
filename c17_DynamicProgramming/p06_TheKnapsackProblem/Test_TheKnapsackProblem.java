package c17_DynamicProgramming.p06_TheKnapsackProblem;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import c17_DynamicProgramming.p06_TheKnapsackProblem.TheKnapsackProblem.ValuableItem;

public class Test_TheKnapsackProblem {

	public static void main(String[] args) {
		
		List<ValuableItem> valueableItems = new ArrayList<>();
		
		valueableItems.add( new ValuableItem(5, 60)  );
		valueableItems.add( new ValuableItem(3, 50)  );
		valueableItems.add( new ValuableItem(4, 70)  );
		valueableItems.add( new ValuableItem(2, 30)  );
		
		out.println( TheKnapsackProblem.maximumValueOfPicking( valueableItems, 5 ) );
		out.println( TheKnapsackProblem.maximumValueOfPicking( valueableItems, 4 ) );
		out.println( TheKnapsackProblem.maximumValueOfPicking( valueableItems, 3 ) );
		out.println( TheKnapsackProblem.maximumValueOfPicking( valueableItems, 2 ) );
		
		
	}

}


