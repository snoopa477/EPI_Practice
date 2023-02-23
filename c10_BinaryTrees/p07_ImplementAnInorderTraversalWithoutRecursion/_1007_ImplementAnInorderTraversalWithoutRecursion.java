package c10_BinaryTrees.p07_ImplementAnInorderTraversalWithoutRecursion;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class _1007_ImplementAnInorderTraversalWithoutRecursion {

	public static List<Integer> BSTInSortedOrder(BSTNode<Integer> tree) {
		Deque<BSTNode<Integer>> s = new LinkedList<>();
		BSTNode<Integer> curr = tree;

		List<Integer> result = new ArrayList<>();
		while (!s.isEmpty() || curr != null) {
			if (curr != null) {
				s.addFirst(curr);
// Going left.
				curr = curr.left;
			} else {
// Going up .
				curr = s.removeFirst();
				result.add(curr.data);
// Going right.
				curr = curr.right;
			}
		}
		return result;
	}
}
