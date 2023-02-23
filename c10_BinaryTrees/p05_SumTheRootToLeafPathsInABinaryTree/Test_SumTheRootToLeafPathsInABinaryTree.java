package c10_BinaryTrees.p05_SumTheRootToLeafPathsInABinaryTree;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class Test_SumTheRootToLeafPathsInABinaryTree {

	
	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> root = MyBinaryTreeNode.makeFigure10_04Tree();
		SumTheRootToLeafPathsInABinaryTree.IS_DEBUG = true;
		out.println( SumTheRootToLeafPathsInABinaryTree.sumRootToLeaf(root) );
		
		
	}
	
}


