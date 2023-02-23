package c10_BinaryTrees.p02_TestifABinarytreeisSymmetric;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class TestifABinarytreeisSymmetric {
	
	//QUESTION: public static <T> boolean checkIfSymmetric( MyBinaryTreeNode<T> root ) {
	//How should I compare with T? what if T is String?
	
	//public static <T> boolean checkIfSymmetric( MyBinaryTreeNode<T> root ) {
	public static boolean checkIfSymmetric( MyBinaryTreeNode<Integer> root ) {
		
		if( root == null ) {
			return true;
		}
		
		//DETAIL: root itself has no symmetric node -> no correspondent to compare
		boolean result = checkIfSymmetricHelper( root.left, root.right ) 
				&& checkIfSymmetricHelper( root.right, root.left );
		
		return result;
	}
	
	
	
	private static boolean checkIfSymmetricHelper( MyBinaryTreeNode<Integer> node0, MyBinaryTreeNode<Integer> node1 ) {
	//public static <T> boolean checkIfSymmetricHelper( MyBinaryTreeNode<T> node0, MyBinaryTreeNode<T> node1 ) {
		//WRONG: Syntax error on token "==", invalid AssignmentOperator
		//node0.data == node1.data;
		
		//base case, no need to call futher subfucntion
		if( node0 == null && node1 ==null ) {
			return true;
		}
		
		/**
		 * REASONING: 
		 * compare start with current node, which is preorder
		 * so if current node comparison is not ok, then no need to further call 
		 */
		
		boolean result = 
			node0.data == node1.data
			&& checkIfSymmetricHelper(node0.left, node1.right)
			&& checkIfSymmetricHelper(node0.right, node1.left);
		
		return result;
	}
	
	
}





