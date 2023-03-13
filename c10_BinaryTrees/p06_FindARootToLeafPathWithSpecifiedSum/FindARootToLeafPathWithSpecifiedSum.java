package c10_BinaryTrees.p06_FindARootToLeafPathWithSpecifiedSum;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class FindARootToLeafPathWithSpecifiedSum {

	
	public static boolean hasRootToLeafPathWithSpecifiedSum( MyBinaryTreeNode<Integer> root, int targetPathSum ) {
		return hasRootToLeafPathWithSpecifiedSumHelper( root, 0, targetPathSum );
	}
	
	
	
	private static boolean hasRootToLeafPathWithSpecifiedSumHelper( MyBinaryTreeNode<Integer> currentNode, int pathSumOnTheWay, int targetPathSum  ) {
		
		//CASE: null node
		//DETAIL: has nothing to compare with targetPathSum => false
		if( currentNode == null ) {
			return false;
		}
		
		
		int currentPathSumOnTheWay = pathSumOnTheWay + currentNode.data;
		
		//DETAIL: the difference between leaf node and non-leaf node: at leaf node true of false must be decided; while non-leaf node just pass the result up, if possible 
		//CASE: leaf node
		if( currentNode.left == null && currentNode.right == null ) {
			if( currentPathSumOnTheWay == targetPathSum ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		//REASONING: reaching here meaning non-leaf node
		boolean leftResult = hasRootToLeafPathWithSpecifiedSumHelper(currentNode.left, currentPathSumOnTheWay, targetPathSum);
		//DETAIL: cut-off if there's answer
		if( leftResult == true ) {
			return true;
		}
		boolean rightResult = hasRootToLeafPathWithSpecifiedSumHelper(currentNode.right, currentPathSumOnTheWay, targetPathSum);
		//DETAIL: it could be either true or false
		return rightResult;
	}
	
}


