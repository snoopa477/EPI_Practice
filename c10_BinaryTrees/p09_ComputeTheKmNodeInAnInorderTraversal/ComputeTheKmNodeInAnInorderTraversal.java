package c10_BinaryTrees.p09_ComputeTheKmNodeInAnInorderTraversal;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithSize;

public class ComputeTheKmNodeInAnInorderTraversal {
	
	
	public static <T> MyBinaryTreeNodeWithSize<T> getKthNodeInorderTraversal( MyBinaryTreeNodeWithSize<T> root, int k ){
		
		/*DETAIL: the variable k: under the current root, kth position counting from the leftmost nodes in inorderTraversal. 
		 * Note that every move current root is changing, k would change along with the current root
		 */
		
		/**
		 REASONING:
		 we identify the position by checking current root's left.size()
		 so k = current root.size() + 1 //root itself
		 */
		
		MyBinaryTreeNodeWithSize<T> currentRoot = root;
		int currentK = k;
		
		//walk down to the leaf and beyond
		while( currentRoot != null ) {
			
			int position = ( currentRoot.left != null? 
					currentRoot.left.size
					: 0)
					+ 1; //the currentRoot itself; 
				
			//find it!
			if( position == currentK ) {
				return currentRoot;
			}
			//at the right hand side
			else if( position < currentK ) {
				
				currentRoot = currentRoot.right;
				/*REASONING: currentK is inclusive of leftSubtree size, root, 
				 * new root, which is at right tree, meaning its corresponding k will not include left tree and root, so we have to subtract those from original k
				 */
				currentK = currentK - position;
			}
			//at the left hand side
			//position > currentK
			else {
				currentRoot = currentRoot.left;
				
				/*REASONING: currentK is inclusive of leftSubtree size, root, 
				 * new root, which is at left tree, meaning its corresponding k STILL includes left tree and root, so we do nothing
				 * keep in mind the new k corresponds to new currentRoot
				 */
				//do nothing
				//currentK = currentK;
			}
			
			
		}
		
		//Reaching here meaning find nothing
		return null;
	}
	

}


