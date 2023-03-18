package c10_BinaryTrees.p12_ReconstructABinaryTreeFromTraversalData;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.List;

import util.MyBinaryTreeNode;

public class ReconstructABinaryTreeFromTraversalData {
	
	public static boolean IS_DEBUG = false;
	
	public static <T> MyBinaryTreeNode<T> construct( List<T> preorderList, List<T> inorderList ){
		
		HashMap<T, Integer> inorder_valueToIndex = new HashMap<>();
		for( int i = 0; i < inorderList.size(); i++ ) {
			inorder_valueToIndex.put( inorderList.get(i), i );
		}
		
		
		return construct( preorderList, inorder_valueToIndex, 
					0, 
					preorderList.size(), 
					0, 
					inorderList.size() );
	}
	
	
	
	/**
	 *	pre_start: preorder end start
	 *	pre_end: preorder list end 
	 *	in_start: inorder end start
	 *	in_end: inorder list end 
	 */
	private static <T> MyBinaryTreeNode<T> construct( 
			List<T> preorderList
			, HashMap<T, Integer> inorder_valueToIndex
			, int pre_start
			, int pre_end
			, int in_start
			, int in_end ){
		
		/**
		 * REASONING: the first element in preorder list is the root the tree, call it node R
		 * find the node R in inorder list, the left hand side of it is left subtree of node R, right hand side is right subtree of node R
		 * 
		 * in preorder list, we find that root, followed by left subtree nodes, followed by right subtree nodes
		 * and we find that we can get the last left subtree node by using size of left subtree
		 * , which is derived from inorder list 
		 * 
		 * we find that the remaining of preorder/ inorder list serves the similar but smaller constructing probelm => use recurison
		 * 
		 * DETAIL: in each iteration, we consume the node R, decreasing the preorder/inorder list size by 1
		 *  
		 * EXAMPLE: 
		 * 
		 *  preorder
		 *  A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P
		 *  
		 *  inorder
		 *  D  C  E  B  F  H  G  A  J  L  M  K  N  I  O  P
		 *  
		 *  --------------------------------------------------------
		 *  
		 *  st stands for start
		 *  ed stands for end
		 *  
		 *  preorder
		 * [A] B  C  D  E  F  G  H  I  J  K  L  M  N  O  P
		 * sub left pre
		 *     st                   ed
		 * sub right pre
		 *                          st                   ed 
		 *  inorder
		 *  D  C  E  B  F  H  G [A] J  L  M  K  N  I  O  P
		 *  sub left in
		 *  st                   ed
		 *  sub right in
		 *                          st                   ed
		 */
		
		//Base case
		//REASONING: when left and right overlap, there exists no elements( e.g. String substr, merge sort
		//THINK_FURTHER: in each iteration, left and right get closer and closer
		if( ( pre_start < pre_end && in_start < in_end ) == false ) {
			return null;
		}
		
		//REASONING: reaching here means there exists root
		
		//WRONG: 0 is just one of the case, should have state first element, and the first element's index depends
		//T rootValue = preorderList.get(0);
		T rootValue = preorderList.get( pre_start );
		int rootIndexInInorder = inorder_valueToIndex.get(rootValue);
		int leftSubtreeSize = rootIndexInInorder - in_start;
		
		//DETAIL: have to be very careful, better to right down the example before writing code. avoid mind juggling
		int left_pre_start = pre_start + 1;
		int left_pre_end = left_pre_start + leftSubtreeSize;
		
		int right_pre_start = left_pre_end;
		int right_pre_end = pre_end ; 
		
		int left_in_start = in_start;
		int left_in_end = rootIndexInInorder;
		
		int right_in_start = left_in_end + 1;
		int right_in_end = in_end ;
		
		if(  IS_DEBUG ) {
			out.println( "\nrootIndexInInorder: " + rootIndexInInorder + "\npre_start: " + pre_start + "\npre_end: " + pre_end + "\nin_start: " + in_start + "\nin_end: " + in_end + "\nrootValue: " + rootValue  + "\nleftSubtreeSize: " + leftSubtreeSize 
					+ "\nleft_pre_start: " + left_pre_start + "\nleft_pre_end: " + left_pre_end  + "\nleft_in_start: " + left_in_start + "\nleft_in_end: " + left_in_end   + "\nright_pre_start: " + right_pre_start + "\nright_pre_end: " + right_pre_end  + "\nright_in_start: " + right_in_start + "\nright_in_end: " + right_in_end
					);
		}
		
		MyBinaryTreeNode<T> leftSubTree = construct( preorderList, inorder_valueToIndex
				, left_pre_start
				, left_pre_end
				, left_in_start
				, left_in_end);
		
		MyBinaryTreeNode<T> rightSubTree = construct( preorderList, inorder_valueToIndex
				, right_pre_start
				, right_pre_end
				, right_in_start
				, right_in_end);
		
		//DETAIL: if char is not specified, its default value is 0. if the presentation is \ + char, then it would end up like this \0, the end of string, causing the following string unable to be copied
		MyBinaryTreeNode<T> rootNode = new MyBinaryTreeNode<T>(rootValue, leftSubTree, rightSubTree);
		
		
		return rootNode;
	}

}




