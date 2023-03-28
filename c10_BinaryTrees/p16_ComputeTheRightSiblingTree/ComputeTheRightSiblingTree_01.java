package c10_BinaryTrees.p16_ComputeTheRightSiblingTree;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithNext;


public class ComputeTheRightSiblingTree_01 {
	
	public static<T> void constructRightSibling( MyBinaryTreeNodeWithNext<T> root ) {
		
		if( root == null ) {
			return;
		}
		
		
		MyBinaryTreeNodeWithNext<T> currentNode = root;
		while( currentNode != null && currentNode.left != null ) {
			
			constructChildrenRightSibling_wholeLevel( currentNode );
			//reaching here meaning each node in the current node level are all connected to next sibling
			//prepare for the next level
			currentNode = currentNode.left;
		}
		
	}
	
	
	/**
	 * EXAMPLE:
	 * 
	 * round0
	 *               *
	 *       *               *    
	 *   *       *       *       *  
	 * *   *   *   *   *   *   *   *
	 * 
	 * ----------------------------------------        
	 *              [*]
	 *      (*)             (*)   
	 *   *       *       *       *  
	 * *   *   *   *   *   *   *   *
	 * 
	 * ----------------------------------------     
	 *              [*]
	 *      (*) ----------->(*)   
	 *   *       *       *       *  
	 * *   *   *   *   *   *   *   *
	 * 
	 * ----------------------------------------
	 *  round1
	 *  step1: left child
	 *  
	 *               *
	 *      [*] -----------> *    
	 *  (*)     (*)      *       *  
	 * *   *   *   *   *   *   *   * 
	 * 
	 * ----------------------------------------
	 *  step2: right child     
	 *               *
	 *      [*] ----------->[*]   
	 *   * ---> (*) --> (*)      *  
	 * *   *   *   *   *   *   *   * 
	 * 
	 */
	private static <T> void constructChildrenRightSibling_wholeLevel( MyBinaryTreeNodeWithNext<T> root ) {
		
		MyBinaryTreeNodeWithNext<T> currentNode = root;
		
		//currentNode: root, and its following right siblings
		while( currentNode != null ) {
			
			MyBinaryTreeNodeWithNext<T> leftNode = currentNode.left;
			MyBinaryTreeNodeWithNext<T> rightNode = currentNode.right;
			
			//step 1: left child. connects its left child to right child
			leftNode.next = rightNode;
			
			
			/*step 2: right child. make an attempt to make right child connected to its siblings left child 
			 * 
			 *  if root has right sibling--under the premise that it's complete binary tree--
			 * 1. the root.next must have pointed to sibling because of previous operation
			 * 2. the right sibling must have left child due to complete binary tree
			 * let the root's right child next points to root's sibling's left child
			 */
			//THINK_FURTHER: when does root doens't have its right sibling? when it is at the rightmost.
			
			MyBinaryTreeNodeWithNext<T> sibling = currentNode.next;
			if( sibling != null ) {
				rightNode.next = sibling.left;
			}
			
			/* REASONING: reaching here, current nodes left child already connected to right
			 * , and if there exist sibling, right child already connect to sib's left
			 * => all children of current nodes next are assigned 
			 */
			//PURPOSE: now it's siblings turn to process its children. if right sibling doesn't exist -> end 
			
			currentNode = currentNode.next;
			
		}
		
	}

}





