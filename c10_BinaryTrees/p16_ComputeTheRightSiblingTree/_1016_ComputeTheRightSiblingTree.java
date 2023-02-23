package c10_BinaryTrees.p16_ComputeTheRightSiblingTree;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

import util.ListNode;
import util.BinaryTreeNode;

public class _1016_ComputeTheRightSiblingTree {

	public static void constructRightSibling(BinaryTreeNode<Integer> tree) {
		BinaryTreeNode<Integer> leftStart = tree;
		while (leftStart != null && leftStart.left != null) {
			populateLowerLevelNextField(leftStart);
			leftStart = leftStart.left;
		}
	}

	private static void populateLowerLevelNextField(BinaryTreeNode<Integer> startNode) {
		BinaryTreeNode<Integer> iter = startNode;
		while (iter != null) {
// Populate left child's next field.
			iter.left.next = iter.right;
// Populate right child's next field if iter is not the last node of this
// level .
			if (iter.next != null) {
				iter.right.next = iter.next.left;
			}
			iter = iter.next;
		}
	}
}
