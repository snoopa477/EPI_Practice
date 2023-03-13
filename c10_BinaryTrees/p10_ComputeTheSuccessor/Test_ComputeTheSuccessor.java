package c10_BinaryTrees.p10_ComputeTheSuccessor;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithParent;

public class Test_ComputeTheSuccessor {

	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithParent<Integer> tree_10_01 = MyBinaryTreeNodeWithParent.makeFigure10_01Tree();
		
		
		//CASE 1
		MyBinaryTreeNodeWithParent<Integer> nodeB = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'B');
		out.println( nodeB + " successor is " + ComputeTheSuccessor.findSuccessor(nodeB ) );
		
		MyBinaryTreeNodeWithParent<Integer> nodeI = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'I');
		out.println( nodeI + " successor is " + ComputeTheSuccessor.findSuccessor(nodeI ) );
		
		MyBinaryTreeNodeWithParent<Integer> nodeK = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'K');
		out.println( nodeK + " successor is " + ComputeTheSuccessor.findSuccessor(nodeK ) );
		
		//CASE 2
		MyBinaryTreeNodeWithParent<Integer> nodeE = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'E');
		out.println( nodeE + " successor is " + ComputeTheSuccessor.findSuccessor(nodeE ) );
		
		MyBinaryTreeNodeWithParent<Integer> nodeH = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'H');
		out.println( nodeH + " successor is " + ComputeTheSuccessor.findSuccessor(nodeH ) );
		MyBinaryTreeNodeWithParent<Integer> nodeG = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'G');
		out.println( nodeG + " successor is " + ComputeTheSuccessor.findSuccessor(nodeG ) );
		MyBinaryTreeNodeWithParent<Integer> nodeN = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'N');
		out.println( nodeN + " successor is " + ComputeTheSuccessor.findSuccessor(nodeN ) );
		
		//No successor
		MyBinaryTreeNodeWithParent<Integer> nodeP = MyBinaryTreeNodeWithParent.findByTag(tree_10_01, 'P');
		out.println( nodeP + " successor is " + ComputeTheSuccessor.findSuccessor(nodeP ) );
	}

}


