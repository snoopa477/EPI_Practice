package c10_BinaryTrees.p14_FormALinkedListFromTheLeavesOfABinaryTree;
import static java.lang.System.out;

import java.util.List;

import util.MyBinaryTreeNode;

public class Test_FormALinkedListFromTheLeavesOfABinaryTree {

	
	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> root_10_01 =  MyBinaryTreeNode.makeFigure10_01Tree();
		
		List<MyBinaryTreeNode<Integer>> leaves01 = FormALinkedListFromTheLeavesOfABinaryTree_01_preorder.getLeaves(root_10_01);
		
		List<MyBinaryTreeNode<Integer>> leaves02 = FormALinkedListFromTheLeavesOfABinaryTree_02_inorder.getLeaves(root_10_01);
		
		List<MyBinaryTreeNode<Integer>> leaves03 = FormALinkedListFromTheLeavesOfABinaryTree_03_postorder.getLeaves(root_10_01);
		
		List<MyBinaryTreeNode<Integer>> leaves04 = FormALinkedListFromTheLeavesOfABinaryTree_04_better.getLeaves(root_10_01);
		
		
		out.println( "FormALinkedListFromTheLeavesOfABinaryTree_01_preorder" );
		out.println( leaves01 );
		
		out.println( "\nFormALinkedListFromTheLeavesOfABinaryTree_02_inorder" );
		out.println( leaves02 );
		
		out.println( "\nFormALinkedListFromTheLeavesOfABinaryTree_03_postorder" );
		out.println( leaves03 );
		
		out.println( "\nFormALinkedListFromTheLeavesOfABinaryTree_04_better" );
		out.println( leaves04 );
		
	}

}


