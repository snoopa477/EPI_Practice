package c10_BinaryTrees.p01_TestIfABinaryTreeIsHeightBalanced;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class TestIfABinaryTreeIsHeightBalanced {

	
	public static class BalanceStatusWithHeight{
		
		public boolean isBalanced;
		public int height;
		
		public BalanceStatusWithHeight(boolean isBalanced, int height) {
			super();
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	
	
	
	public static <T> boolean checkIfBalanced( MyBinaryTreeNode<T> root ) {
		return checkIfBalancedHelper(root).isBalanced;
	}
	
	
	
	private static <T> BalanceStatusWithHeight checkIfBalancedHelper( MyBinaryTreeNode<T> root ){
		
		if( root == null ) {
			return new BalanceStatusWithHeight(true, -1);
		}
		
		
		BalanceStatusWithHeight leftSubtreeResult = checkIfBalancedHelper( root.left );
		if( leftSubtreeResult.isBalanced == false ) {
			//DETAIL: leftsubtreeReuslt.height is non-relevant to current node
			return leftSubtreeResult;
		}
		
		
		BalanceStatusWithHeight rightSubtreeResult = checkIfBalancedHelper( root.right );
		if( rightSubtreeResult.isBalanced == false ) {
			return rightSubtreeResult;
		}
		
		
		/*REASONING: reaching here meaning both subtree are balanced, 
		 * now check for the current node's balance status
		 */
		
		//PURPOSE: check current node if balanced
		int leftHeight = leftSubtreeResult.height;
		int rightHeight = rightSubtreeResult.height;
		
		boolean isBalanced = Math.abs( leftHeight - rightHeight ) <= 1;
		if( isBalanced == false ) {
			//DETAIL: the height actual value doesn't matter
			return new BalanceStatusWithHeight( false, -1 );
		}
		
		int height = Math.max(leftHeight, rightHeight) + 1 /*itself*/ ;
		return new BalanceStatusWithHeight( true, height );
		
	}
	
	
}


