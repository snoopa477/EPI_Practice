package c15_BinarySearchTrees.p01_TestIfABinaryTreeSatisfiesTheBstProperty;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import util.BinaryTreeNode;

public class _1501_TestIfABinaryTreeSatisfiesTheBstProperty02 {

	public static class QueueEntry {
		public BinaryTreeNode<Integer> treeNode;
		public Integer lowerBound, upperBound;

		public QueueEntry(BinaryTreeNode<Integer> treeNode, Integer lowerBound, Integer upperBound) {
			this.treeNode = treeNode;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}

	public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
		Queue<QueueEntry> BFSQueue = new LinkedList<>();
		BFSQueue.add(new QueueEntry(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
		QueueEntry headEntry;
		while ((headEntry = BFSQueue.poll()) != null) {
			if (headEntry.treeNode != null) {
				if (headEntry.treeNode.data < headEntry.lowerBound || headEntry.treeNode.data > headEntry.upperBound) {
					return false;
				}

				BFSQueue.add(new QueueEntry(headEntry.treeNode.left, headEntry.lowerBound, headEntry.treeNode.data));
				BFSQueue.add(new QueueEntry(headEntry.treeNode.right, headEntry.treeNode.data,

						headEntry.upperBound));

			}

		}
		return true;

	}
}
