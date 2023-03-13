package c10_BinaryTrees.p11_ImplementAnInorderTraversalWith00_01Space;
import static java.lang.System.out;

import java.util.ArrayList;

import util.MyBinaryTreeNodeWithParent;

public class ImplementAnInorderTraversalWith00_01Space {

	public static <T> ArrayList<MyBinaryTreeNodeWithParent<T>> inorderTraversal( MyBinaryTreeNodeWithParent<T> root ){
		
		ArrayList<MyBinaryTreeNodeWithParent<T>> result = new ArrayList<>();
		
		/*
		 THINK_FURTHER: there car be only three direction: up, left, and right
		 Observation of last move:
			 up: prev == current.parent
			 	go left
			 left: prev == current.left
			 	( right subtree ends)
			 	go right
			 right: prev == current.right
			 	( left tree ends after right tree ends => all subtree ends )
			 	go up

		THINK_FURTHER:
		don't ever actually traverse null node, which is under leaf node
	  	since go to null node's result and process is deterministic and predictable, only the result is specified by code
	  	, the process( since they're all the same) which involves the null node is not recorded in code
		  	 
	  	THINK_FURTHER:
	  	going to either left or right MIGHT encounter with null node. 	
		 */
		
		MyBinaryTreeNodeWithParent<T> prev = null;
		MyBinaryTreeNodeWithParent<T> current = root;
		//DETAIL: since we won't really traverse the node under leaf node, so the null node case happens ONLY when it goes up beyond the root
		//PURPOSE: keep traverse until current goes beyond the root
		while( current != null ) {
			
			MyBinaryTreeNodeWithParent<T> next = null;
			
			//case 1/3
			if( prev == current.parent ) {
				
				//go left
				if( current.left != null ) {
					next = current.left;
				}
				/**
				 * left node is null: 
				 * 
				 * (go left to null node)
				 * (go up to this node)
				 * collect this node
				 * 
				 * if right is not null
				 *  go right ( and start a new round
				 * else 
				 *	(go right to null node)
				 *	(go up to this node)
				 *	go up the parent ( and start a new round
				 * 
				 */
				else {
					result.add( current );
					
//					if( current.right != null ) {
//						...
//					}
					//DETAIL: succinct way
					next = current.right != null ? 
							current.right :
							//IMAGINATION: go right null node, go up to this node, and then finally go up
							current.parent;
					
				}
				
			}
			//case 2/3
			else if( prev == current.left ){
				//left subtree ends
				result.add( current );
				//go right, 
				next = current.right != null ? 
						current.right : 
						//IMAGINATION: go right null node, go up to this node, and then finally go up
						current.parent;
			}
			//case 3/3: 
			// prev == current.right
			else {
				//right subtree ends after left tree ends => all tree ends
				next = current.parent;
			}
			
			//prepare for next round
			prev = current;
			current = next;
		}
		
		
		
		return result;
	}
	
	
}


