package c10_BinaryTrees.p13_ReconstructABinaryTreeFromAPreorderTraversalWithMarkers;
import static java.lang.System.out;

import java.util.List;

import util.MyBinaryTreeNode;

public class ReconstructABinaryTreeFromAPreorderTraversalWithMarkers {
	
	/**
	 * PURPOSE: 
	 * it is incremented by one every time the construct Helper is called
	 * this is not so obvious, since codes are separated 
	 */
	private static int UNIVERSAL_PREORDER_INDEX = 0;
	
	public static<T> MyBinaryTreeNode<T> construct( List<T> preorderList ){
		
		//reset every time construct is called
		//WRONG: it would cause only the left subtree is generated, because callee INDEX would start with 1, which is the root of left subtree
		//UNIVERSAL_PREORDER_INDEX = 0;
		UNIVERSAL_PREORDER_INDEX = -1;
		
		return constructHelper( preorderList );
	}
	
	
	
	//return : the node, along with the tree that grows underneath it
	private static<T> MyBinaryTreeNode<T> constructHelper( List<T> preorderList ){
		
		UNIVERSAL_PREORDER_INDEX++;
		
		T nodeValue = preorderList.get(UNIVERSAL_PREORDER_INDEX);
		
		//BASE CASE: if this is null value, return null node. The caller node, node.left = null or node.right = null  
		if( nodeValue == null ) {
			return null;
		}
		
		//Reaching here meaning nodeValue is not null
		MyBinaryTreeNode<T> currentNode = new MyBinaryTreeNode<T>(nodeValue);
		
		//REASONING: for this callee, its UNIVERSAL_PREORDER_INDEX is greater than caller by ONE
		/*REASONING: when this function really ends, it also calls so many sub-functions; more precisely, the whole nodes of tree under this node is called
		 * ; therefore, given UNIVERSAL_PREORDER_INDEX is N, N = the index of last node of the left subtree ( which is located at the right down corner)
		 * 
		 *  When this function ends, returning back to here, and call the next sub-func( rightTree = constructHelper( preorderList ) ), 
		 *  the right callee UNIVERSAL_PREORDER_INDEX is N+1, which is the index of the root of right subtree
		 */
		MyBinaryTreeNode<T> leftTree = constructHelper( preorderList );
		 
		//DETAIL: now inside the callee UNIVERSAL_PREORDER_INDEX is the index of the root of right subtree
		MyBinaryTreeNode<T> rightTree = constructHelper( preorderList );
		
		currentNode.left = leftTree;
		currentNode.right = rightTree;
		return currentNode;
	}

}





