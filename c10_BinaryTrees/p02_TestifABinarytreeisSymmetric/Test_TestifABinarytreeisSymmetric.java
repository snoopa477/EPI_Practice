package c10_BinaryTrees.p02_TestifABinarytreeisSymmetric;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class Test_TestifABinarytreeisSymmetric {

	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> symmetricTree = makeSymmetricBinaryTree();
		MyBinaryTreeNode<Integer> asymmetricTree01 = makeAsymmetricBinaryTree01();
		MyBinaryTreeNode<Integer> asymmetricTree02 = makeAsymmetricBinaryTree02();
		
		out.println( TestifABinarytreeisSymmetric.checkIfSymmetric(symmetricTree) );
		out.println( TestifABinarytreeisSymmetric.checkIfSymmetric(asymmetricTree01) );
		out.println( TestifABinarytreeisSymmetric.checkIfSymmetric(asymmetricTree02) );
		
	}
	
	
	
	public static MyBinaryTreeNode<Integer> makeSymmetricBinaryTree() {
		
		MyBinaryTreeNode<Integer> nodeD = new MyBinaryTreeNode<Integer>(3);
		MyBinaryTreeNode<Integer> nodeG = new MyBinaryTreeNode<Integer>(3);
		
		MyBinaryTreeNode<Integer> nodeC = new MyBinaryTreeNode<Integer>(2, null, nodeD);
		MyBinaryTreeNode<Integer> nodeF = new MyBinaryTreeNode<Integer>(2, nodeG, null);
		
		MyBinaryTreeNode<Integer> nodeB = new MyBinaryTreeNode<Integer>(6, null, nodeC);
		MyBinaryTreeNode<Integer> nodeE = new MyBinaryTreeNode<Integer>(6, nodeF, null);
		
		MyBinaryTreeNode<Integer> nodeA = new MyBinaryTreeNode<Integer>(314, nodeB, nodeE);
		
		return nodeA;
	}
	
	
	public static MyBinaryTreeNode<Integer> makeAsymmetricBinaryTree01() {
		
		MyBinaryTreeNode<Integer> nodeD = new MyBinaryTreeNode<Integer>(3);
		MyBinaryTreeNode<Integer> nodeG = new MyBinaryTreeNode<Integer>(3);
		
		MyBinaryTreeNode<Integer> nodeC = new MyBinaryTreeNode<Integer>(561, null, nodeD);
		MyBinaryTreeNode<Integer> nodeF = new MyBinaryTreeNode<Integer>(2, nodeG, null);
		
		MyBinaryTreeNode<Integer> nodeB = new MyBinaryTreeNode<Integer>(6, null, nodeC);
		MyBinaryTreeNode<Integer> nodeE = new MyBinaryTreeNode<Integer>(6, nodeF, null);
		
		MyBinaryTreeNode<Integer> nodeA = new MyBinaryTreeNode<Integer>(314, nodeB, nodeE);
		
		return nodeA;
	}
	
	
	
	public static MyBinaryTreeNode<Integer> makeAsymmetricBinaryTree02() {
		
		MyBinaryTreeNode<Integer> nodeD = null;
		MyBinaryTreeNode<Integer> nodeG = null;
		
		MyBinaryTreeNode<Integer> nodeC = new MyBinaryTreeNode<Integer>(561, null, nodeD);
		MyBinaryTreeNode<Integer> nodeF = new MyBinaryTreeNode<Integer>(561, nodeG, null);
		
		MyBinaryTreeNode<Integer> nodeB = new MyBinaryTreeNode<Integer>(6, null, nodeC);
		MyBinaryTreeNode<Integer> nodeE = new MyBinaryTreeNode<Integer>(6, nodeF, null);
		
		MyBinaryTreeNode<Integer> nodeA = new MyBinaryTreeNode<Integer>(314, nodeB, nodeE);
		
		return nodeA;
	}

}


