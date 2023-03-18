package c10_BinaryTrees.p12_ReconstructABinaryTreeFromTraversalData;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import util.ListNode;
import util.BinaryTreeNode;

public class _1012_ReconstructABinaryTreeFromTraversalData {

	public static BinaryTreeNode<Integer> binaryTreeFromPreorderlnorder(List<Integer> preorder, List<Integer> inorder) {
		Map<Integer, Integer> nodeToInorderIdx = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.size(); ++i) {

			nodeToInorderIdx.put(inorder.get(i), i);

		}
		return binaryTreeFromPreorderInorderHelper(preorder, 0, preorder.size(), 0, inorder.size(), nodeToInorderIdx);

	}

// Builds the subtree with preorder . subList(preorderStart , preorderEnd) and
// inorder.subList(inorderStart, inorderEnd).
	private static BinaryTreeNode<Integer> binaryTreeFromPreorderInorderHelper(
			List<Integer> preorder,
			int preorderStart, 
			int preorderEnd, 
			int inorderStart, 
			int inorderEnd,
			Map<Integer, Integer> nodeToInorderldx) {
		if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
			return null;
		}
		int rootlnorderldx = nodeToInorderldx.get(preorder.get(preorderStart));
		int leftSubtreeSize = rootlnorderldx - inorderStart;
		return new BinaryTreeNode<Integer>(preorder.get(preorderStart),
				// Recursively builds the left subtree.
				binaryTreeFromPreorderInorderHelper(
						preorder, 
						preorderStart + 1, 
						preorderStart + 1 + leftSubtreeSize,
						inorderStart, 
						rootlnorderldx, 
						nodeToInorderldx),
// Recursively builds the right subtree.
				binaryTreeFromPreorderInorderHelper(
						preorder, 
						preorderStart + 1 + leftSubtreeSize, 
						preorderEnd,
						rootlnorderldx + 1, 
						inorderEnd, 
						nodeToInorderldx));

	}
}
