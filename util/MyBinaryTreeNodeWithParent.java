package util;
import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class MyBinaryTreeNodeWithParent<T> {

	public T data;
	public MyBinaryTreeNodeWithParent<T> left, right, parent;
	//additional
	public char tag;
	
	
	public MyBinaryTreeNodeWithParent(T data) {
		this.data = data;
	}
	
	
	
	public MyBinaryTreeNodeWithParent(T data, char tag) {
		this.data = data;
		this.tag = tag;
	}

	
	
	public MyBinaryTreeNodeWithParent(T data, MyBinaryTreeNodeWithParent<T> left, MyBinaryTreeNodeWithParent<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		
		
		if( right != null ) {
			right.parent = this;
		}
		
		if( left != null) {
			left.parent = this;
		}
	}
	
	
	
	public MyBinaryTreeNodeWithParent(T data, char tag, MyBinaryTreeNodeWithParent<T> left, MyBinaryTreeNodeWithParent<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.tag = tag;
		
		
		//WRONG if forget to check
		if( right != null ) {
			right.parent = this;
		}
		
		if( left != null) {
			left.parent = this;
		}
	}
	
	
	
	public MyBinaryTreeNodeWithParent(T data, char tag, MyBinaryTreeNodeWithParent<T> left, MyBinaryTreeNodeWithParent<T> right, MyBinaryTreeNodeWithParent<T> parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.tag = tag;
	}
	
	
	//ERROR: Cannot make a static reference to the non-static type T
//	public static void printInLevel( MyBinaryTreeNode<T> root ) {
	public static <T> void printInLevel( MyBinaryTreeNodeWithParent<T> root ) {
		
		if( root == null ) {
			out.println("null");
		}
		
		
		Deque<MyBinaryTreeNodeWithParent<T>> parentLevel = new LinkedList<>();
		Deque<MyBinaryTreeNodeWithParent<T>> childLevel = new LinkedList<>();
		
		parentLevel.add(root);
		
		int level = 0;
		
		while( parentLevel.size() > 0 ) {
			out.println("------------------------------------ " + level++ );
			//PURPOSE: consume parent level
			while( parentLevel.size() > 0 ) {
				
				MyBinaryTreeNodeWithParent<T> currentNode = parentLevel.pollFirst();
				
				
				MyBinaryTreeNodeWithParent<T> leftNode = Optional.ofNullable(currentNode.left).orElse(null);
				MyBinaryTreeNodeWithParent<T> rightNode = Optional.ofNullable(currentNode.right).orElse(null);
//				

				
				out.println( currentNode );
				
				if( leftNode != null ) {
					childLevel.add( leftNode );
				}
				
				if( rightNode != null ) {
					childLevel.add( rightNode );
				}
				
			}
			//PURPOSE: prepare for the next level
			parentLevel = childLevel;
			childLevel = new LinkedList<>();
			
		}
		
	}
	
	
	
	public static <T> MyBinaryTreeNodeWithParent<T> findByTag( MyBinaryTreeNodeWithParent<T> root, char tag ){
		return findByTagHelper( root, tag, new Sequence() );
	}
	
	
	private static class Sequence{
		public int value;
	}
	
	
	
	private static <T> MyBinaryTreeNodeWithParent<T> findByTagHelper( MyBinaryTreeNodeWithParent<T> currentNode, char tag, Sequence sequence ){
		
		if( currentNode == null ) {
			return null;
		}
		
		sequence.value++;
		
		if( ( tag - ( 'A' -1 ) ) == sequence.value ) {
			return currentNode;
		}
		
		MyBinaryTreeNodeWithParent<T> leftResult = findByTagHelper( currentNode.left, tag, sequence );
		if( leftResult != null ) {
			return leftResult;
		}
		
		MyBinaryTreeNodeWithParent<T> rightResult = findByTagHelper( currentNode.right, tag, sequence );
		if( rightResult != null ) {
			return rightResult;
		}
		
		
		return null;
	}
	
	
	
	public static <T> String strNode( MyBinaryTreeNodeWithParent<T> node ) {
		
		if( node == null ) {
			return "(NULL)";
		}
		return String.valueOf( node.data ) + "\\" + node.tag;
	}
	
	
	@Override
	public String toString() {
		
		MyBinaryTreeNodeWithParent<T> leftNode = Optional.ofNullable(this.left).orElse(null);
		MyBinaryTreeNodeWithParent<T> rightNode = Optional.ofNullable(this.right).orElse(null);
		MyBinaryTreeNodeWithParent<T> parentNode = Optional.ofNullable(this.parent).orElse(null);
		
		String str = String.format("(Value, L, R, P)=%4s, %4s, %4s, %4s\n", 
				strNode(this)
				, strNode( leftNode )
				, strNode( rightNode)
				, strNode( parentNode));
		
		return str;
		
	}
	
	
	
	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithParent<Integer> nodeA = makeFigure10_01Tree();
		printInLevel( nodeA );
		
		
		out.println("--------------------------------");
		out.println( findByTag(nodeA, 'B') );
		out.println( findByTag(nodeA, 'J') );
		out.println( findByTag(nodeA, 'L') );
		out.println( findByTag(nodeA, 'P') );
		out.println( findByTag(nodeA, 'A') );
		out.println( findByTag(nodeA, 'Z') );
		
		
	}
	
	
	
	public static MyBinaryTreeNodeWithParent<Integer> makeFigure10_01Tree(){
		
		
		MyBinaryTreeNodeWithParent<Integer> nodeM = new MyBinaryTreeNodeWithParent<>(641, 'M');
		
		MyBinaryTreeNodeWithParent<Integer> nodeH = new MyBinaryTreeNodeWithParent<>(17, 'H');
		MyBinaryTreeNodeWithParent<Integer> nodeL = new MyBinaryTreeNodeWithParent<>(401, 'L', null, nodeM);
		MyBinaryTreeNodeWithParent<Integer> nodeN = new MyBinaryTreeNodeWithParent<>(257, 'N');
		
		MyBinaryTreeNodeWithParent<Integer> nodeD = new MyBinaryTreeNodeWithParent<>(28, 'D');
		MyBinaryTreeNodeWithParent<Integer> nodeE = new MyBinaryTreeNodeWithParent<>(0, 'E');
		MyBinaryTreeNodeWithParent<Integer> nodeG = new MyBinaryTreeNodeWithParent<>(3, 'G', nodeH, null);
		MyBinaryTreeNodeWithParent<Integer> nodeK = new MyBinaryTreeNodeWithParent<>(1, 'K', nodeL, nodeN);
		MyBinaryTreeNodeWithParent<Integer> nodeP = new MyBinaryTreeNodeWithParent<>(28, 'P');
		
		MyBinaryTreeNodeWithParent<Integer> nodeC = new MyBinaryTreeNodeWithParent<>(271, 'C', nodeD, nodeE);
		MyBinaryTreeNodeWithParent<Integer> nodeF = new MyBinaryTreeNodeWithParent<>(561, 'F', null, nodeG);
		MyBinaryTreeNodeWithParent<Integer> nodeJ = new MyBinaryTreeNodeWithParent<>(2, 'J', null, nodeK);
		MyBinaryTreeNodeWithParent<Integer> nodeO = new MyBinaryTreeNodeWithParent<>(271, 'O', null, nodeP);
		
		MyBinaryTreeNodeWithParent<Integer> nodeB = new MyBinaryTreeNodeWithParent<>(6, 'B', nodeC, nodeF);
		MyBinaryTreeNodeWithParent<Integer> nodeI = new MyBinaryTreeNodeWithParent<>(6, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNodeWithParent<Integer> nodeA = new MyBinaryTreeNodeWithParent<>(314, 'A', nodeB, nodeI);
		
		//DETAIL: would be better if constructor is implemented well
		//set parents
//		nodeM.parent = nodeL;
//		nodeH.parent = nodeG;
//		nodeL.parent = nodeK;
//		nodeN.parent = nodeK;
//		nodeD.parent = nodeC;
//		nodeE.parent = nodeC;
//		nodeG.parent = nodeF;
//		nodeK.parent = nodeJ;
//		nodeP.parent = nodeO;
//		nodeC.parent = nodeB;
//		nodeF.parent = nodeB;
//		nodeJ.parent = nodeI;
//		nodeO.parent = nodeI;
//		nodeB.parent = nodeA;
//		nodeI.parent = nodeA;
		
		return nodeA;
	}
}


