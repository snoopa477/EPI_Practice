package c10_BinaryTrees.p14_FormALinkedListFromTheLeavesOfABinaryTree;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

import util.ListNode;
import util.BinaryTreeNode;

public class _1014_FormALinkedListFromTheLeavesOfABinaryTree {

	public static List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> tree) {
		List<BinaryTreeNode<Integer>> leaves = new LinkedList<>();
		addLeavesLeftToRight(tree, leaves);
		return leaves;
	}

	private static void addLeavesLeftToRight(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> leaves) {
		if (tree != null) {
			if (tree.left == null && tree.right == null) {
				leaves.add(tree);
			} else {
				addLeavesLeftToRight(tree.left, leaves);
				addLeavesLeftToRight(tree.right, leaves);
			}
		}

	}
}
