package c10_BinaryTrees.p05_SumTheRootToLeafPathsInABinaryTree;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class SumTheRootToLeafPathsInABinaryTree {
	
	public static boolean IS_DEBUG = false;
	
	public static int sumRootToLeaf( MyBinaryTreeNode<Integer> root ) {
		return sumRootToLeafHelper( root, 0 );
	}
	
	
	
	private static int sumRootToLeafHelper( MyBinaryTreeNode<Integer> currentNode, int partialSum ) {
		
		//corner case
		//REASONING: in the view point of its parent, it contributes nothing to the sum. So this null node should return 0
		if( currentNode == null ) {
			return 0;
		}
		
		//DETAIL: use current node data
		//WRONG: +-*/ have higher precedence over << >>, so that equivalent is  partialSum << ( 1 + currentNode.data ). The initial value is 0, 0 << x is always 0
		//int currentPartialSum =  partialSum << 1 + currentNode.data;
		int currentPartialSum =  (partialSum << 1) + currentNode.data;
		
		if( IS_DEBUG ) {
			out.println( currentNode + " ; currentPartialSum = " + currentPartialSum);
		}
		
		//Leaf case
		//THINK_FURTHER: even if the leaf keep passing down, the result is still the same; however, it will call subFunc to null nodes, which takes additional steps.
		if( currentNode.left == null && currentNode.right == null ) {
			int completeSum = currentPartialSum;
			return completeSum;
		}
		
		//Non-leaf case, which is the most common one,  it simply serves as a conductor, passing the argument down. this node's value doesn't get involved in sum
		int leftResult = sumRootToLeafHelper(currentNode.left, currentPartialSum);
		int rightResult = sumRootToLeafHelper(currentNode.right, currentPartialSum);
		
		return leftResult + rightResult;
	}

}





