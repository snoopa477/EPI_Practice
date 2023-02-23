package c16_Recursion.p08_GenerateBinaryTrees;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import util.BinaryTreeNode;

public class _1608_GenerateBinaryTrees {

	public static List<BinaryTreeNode<Integer>> generateAUBinaryTrees(int numNodes) {
		List<BinaryTreeNode<Integer>> result = new ArrayList<>();
		if (numNodes == 0) { // Empty tree, add as an null.
			result.add(null);
		}
		for (int numLeftTreeNodes = 0; numLeftTreeNodes < numNodes; ++numLeftTreeNodes) {
			int numRightTreeNodes = numNodes - 1 - numLeftTreeNodes;
			List<BinaryTreeNode<Integer>> leftSubtrees = generateAUBinaryTrees(numLeftTreeNodes);
			List<BinaryTreeNode<Integer>> rightSubtrees = generateAUBinaryTrees(numNodes - 1 - numLeftTreeNodes);
// Generates all combinations of leftSubtrees and rightSubtrees.
			for (BinaryTreeNode<Integer> left : leftSubtrees) {
				for (BinaryTreeNode<Integer> right : rightSubtrees) {
					result.add(new BinaryTreeNode<>(0, left, right));
				}
			}
		}
		return result;
	}
}
