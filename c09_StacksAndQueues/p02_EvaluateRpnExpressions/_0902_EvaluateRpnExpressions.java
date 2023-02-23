package c09_StacksAndQueues.p02_EvaluateRpnExpressions;

import static java.lang.System.out;
import java.util.Deque;
import java.util.LinkedList;

public class _0902_EvaluateRpnExpressions {

	public static int eval(String RPNExpression) {
		Deque<Integer> intermediateResults = new LinkedList<>();
		String delimiter = ",";
		String[] symbols = RPNExpression.split(delimiter);
		for (String token : symbols) {
			if (token.length() == 1 && "+-*/".contains(token)) {
				final int y = intermediateResults.removeFirst();
				final int x = intermediateResults.removeFirst();
				switch (token.charAt(0)) {
				case '+':
					intermediateResults.addFirst(x + y);
					break;
				case '-':
					intermediateResults.addFirst(x - y);
					break;
				case '*':
					intermediateResults.addFirst(x * y);
					break;
				case '/':
					intermediateResults.addFirst(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at :" + token);
				}
			} else {// token is a number.
				intermediateResults.addFirst(Integer.parseInt(token));
			}
		}
		return intermediateResults.removeFirst();
	}

}
