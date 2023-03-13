package c10_BinaryTrees.p10_ComputeTheSuccessor;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithParent;

public class ComputeTheSuccessor {
	
	
	public static<T> MyBinaryTreeNodeWithParent<T> findSuccessor( MyBinaryTreeNodeWithParent<T> node ){
		
		if( node == null ) {
			return null;
		}
		
		/*REASONING: in BST, successor is the node that is the smallest among larger group
		 * and that falls into two categories:
		 * 1. if current node has right subtree, then successor lies in the leftmost( smallest)
		 * 	THINK_FURTHER: in that case, grandpa node, which is the first node that has left descendant, is NOT the smallest among the larger group, since
		 *  it is larger than the rightmost of the right subtree

		 * 2. if current node dosen't have right subtree, then successor lies in grandpa node, which is the first node that has left descendant
		 */
		
		
		
		//CASE 1: it has right subtree
		if( node.right != null ) {
			
			//go to the root of right subtree: any node in right subtree is larger than current node
			MyBinaryTreeNodeWithParent<T> successor = node.right;
			
			//go to the leftmost of the right subtree
			while( successor.left != null ) {
				successor = successor.left;
			}
			
			return successor;
		}
		
		
		//CASE 2:  it doesn't have right subtree, try find one by going upward
		MyBinaryTreeNodeWithParent<T> successor = node.parent;
		MyBinaryTreeNodeWithParent<T> previous = node;
		
		/*DETAIL: there might be a case where the node is the rightmost of the tree. In such case, it doesn't have successor
		 * , which in turn make the successor null when going upward 
		 */
		//PURPOSE: stop when successor.left == follower
		while( successor != null &&  successor.left != previous ) {
			previous = successor;
			successor = successor.parent;
		}
		
		
		//Reaching here means either successor is null, which means no such existence,  or successor.left == previous, which is actually exist and found 
		
		if( successor != null ) {
			return successor;
		}
		else {
			return null;
		}
			
		
	}
	

}


