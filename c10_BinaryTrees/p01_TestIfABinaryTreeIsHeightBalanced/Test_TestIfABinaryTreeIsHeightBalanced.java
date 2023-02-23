package c10_BinaryTrees.p01_TestIfABinaryTreeIsHeightBalanced;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class Test_TestIfABinaryTreeIsHeightBalanced {

	public static void main(String[] args) {
		
		MyBinaryTreeNode<String> balancedTree = makeBalancedTree();
		MyBinaryTreeNode<String> unbalancedTree = makeUnbalancedTree();
		
		out.println( TestIfABinaryTreeIsHeightBalanced.checkIfBalanced(balancedTree) );
		out.println( TestIfABinaryTreeIsHeightBalanced.checkIfBalanced(unbalancedTree) );
		
	}
	
	
	
	public static MyBinaryTreeNode<String> makeBalancedTree() {
		
		MyBinaryTreeNode<String> nodeE = new MyBinaryTreeNode<String>("E");
		MyBinaryTreeNode<String> nodeF = new MyBinaryTreeNode<String>("F");
		
		MyBinaryTreeNode<String> nodeD = new MyBinaryTreeNode<String>("D", nodeE, nodeF);
		MyBinaryTreeNode<String> nodeG = new MyBinaryTreeNode<String>("G");
		MyBinaryTreeNode<String> nodeI = new MyBinaryTreeNode<String>("I");
		MyBinaryTreeNode<String> nodeJ = new MyBinaryTreeNode<String>("J");
		MyBinaryTreeNode<String> nodeM = new MyBinaryTreeNode<String>("M");
		MyBinaryTreeNode<String> nodeN = new MyBinaryTreeNode<String>("N");
		
		MyBinaryTreeNode<String> nodeC = new MyBinaryTreeNode<String>("C", nodeD, nodeG);
		MyBinaryTreeNode<String> nodeH = new MyBinaryTreeNode<String>("H", nodeI, nodeJ);
		MyBinaryTreeNode<String> nodeL = new MyBinaryTreeNode<String>("L", nodeM, nodeN);
		MyBinaryTreeNode<String> nodeO = new MyBinaryTreeNode<String>("O");
		
		MyBinaryTreeNode<String> nodeB = new MyBinaryTreeNode<String>("B", nodeC, nodeH);
		MyBinaryTreeNode<String> nodeK = new MyBinaryTreeNode<String>("K", nodeL, nodeO);
		
		MyBinaryTreeNode<String> nodeA = new MyBinaryTreeNode<String>("A", nodeB, nodeK);
		
		return nodeA;
	}
	
	
	
	public static MyBinaryTreeNode<String> makeUnbalancedTree() {
		
		MyBinaryTreeNode<String> nodeE = new MyBinaryTreeNode<String>("E");
		MyBinaryTreeNode<String> nodeF = new MyBinaryTreeNode<String>("F");
		
		MyBinaryTreeNode<String> nodeD = new MyBinaryTreeNode<String>("D", nodeE, nodeF);
		MyBinaryTreeNode<String> nodeG = new MyBinaryTreeNode<String>("G");
		MyBinaryTreeNode<String> nodeI = null;
		MyBinaryTreeNode<String> nodeJ = null;
		MyBinaryTreeNode<String> nodeM = new MyBinaryTreeNode<String>("M");
		MyBinaryTreeNode<String> nodeN = new MyBinaryTreeNode<String>("N");
		
		MyBinaryTreeNode<String> nodeC = new MyBinaryTreeNode<String>("C", nodeD, nodeG);
		MyBinaryTreeNode<String> nodeH = new MyBinaryTreeNode<String>("H", nodeI, nodeJ);
		MyBinaryTreeNode<String> nodeL = new MyBinaryTreeNode<String>("L", nodeM, nodeN);
		MyBinaryTreeNode<String> nodeO = new MyBinaryTreeNode<String>("O");
		
		MyBinaryTreeNode<String> nodeB = new MyBinaryTreeNode<String>("B", nodeC, nodeH);
		MyBinaryTreeNode<String> nodeK = new MyBinaryTreeNode<String>("K", nodeL, nodeO);
		
		MyBinaryTreeNode<String> nodeA = new MyBinaryTreeNode<String>("A", nodeB, nodeK);
		
		return nodeA;
	}

}


