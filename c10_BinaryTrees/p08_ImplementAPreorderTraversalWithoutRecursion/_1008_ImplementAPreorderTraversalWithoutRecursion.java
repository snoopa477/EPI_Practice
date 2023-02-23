package c10_BinaryTrees.p08_ImplementAPreorderTraversalWithoutRecursion;

import static java.lang.System.out;
import util.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class _1008_ImplementAPreorderTraversalWithoutRecursion {

	public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
		Deque<BinaryTreeNode<Integer>> path = new LinkedList<>();
		path.addFirst(tree);
		List<Integer> result = new ArrayList<>();
		while (!path.isEmpty()) {
			BinaryTreeNode<Integer> curr = path.removeFirst();
			if (curr != null) {

				result.add(curr.data);
				path.addFirst(curr.right);
				path.addFirst(curr.left);

			}

		}
		return result;
	}
}
