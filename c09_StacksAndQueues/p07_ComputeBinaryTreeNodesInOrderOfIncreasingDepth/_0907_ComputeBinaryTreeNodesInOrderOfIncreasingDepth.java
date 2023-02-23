package c09_StacksAndQueues.p07_ComputeBinaryTreeNodesInOrderOfIncreasingDepth;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class _0907_ComputeBinaryTreeNodesInOrderOfIncreasingDepth {

	public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
		Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<>();
		currDepthNodes.add(tree);
		List<List<Integer>> result = new ArrayList<>();
		while (!currDepthNodes.isEmpty()) {
			Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
			List<Integer> thisLevel = new ArrayList<>();
			while (!currDepthNodes.isEmpty()) {
				BinaryTreeNode<Integer> curr = currDepthNodes.poll();
				if (curr != null) {
					thisLevel.add(curr.data);
// Defer the null checks to the null test above.
					nextDepthNodes.add(curr.left);
					nextDepthNodes.add(curr.right);
				}
			}
			if (!thisLevel.isEmpty()) {
				result.add(thisLevel);
			}
			currDepthNodes = nextDepthNodes;
		}
		return result;
	}
}
