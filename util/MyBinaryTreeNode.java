package util;
import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;


public class MyBinaryTreeNode<T> {
	
	public T data;
	public MyBinaryTreeNode<T> left, right;
	//additional
	//default value
	public char tag = 'x';
	
	
	public MyBinaryTreeNode(T data) {
		this.data = data;
	}
	
	
	
	public MyBinaryTreeNode(T data, char tag) {
		this.data = data;
		this.tag = tag;
	}

	
	
	public MyBinaryTreeNode(T data, MyBinaryTreeNode<T> left, MyBinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
	
	public MyBinaryTreeNode(T data, char tag, MyBinaryTreeNode<T> left, MyBinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.tag = tag;
	}
	
	
	//ERROR: Cannot make a static reference to the non-static type T
//	public static void printInLevel( MyBinaryTreeNode<T> root ) {
	public static <T> void printInLevel( MyBinaryTreeNode<T> root ) {
		
		if( root == null ) {
			out.println("null");
		}
		
		
		Deque<MyBinaryTreeNode<T>> parentLevel = new LinkedList<>();
		Deque<MyBinaryTreeNode<T>> childLevel = new LinkedList<>();
		
		parentLevel.add(root);
		
		int level = 0;
		
		while( parentLevel.size() > 0 ) {
			out.println("------------------------------------ " + level++ );
			//PURPOSE: consume parent level
			while( parentLevel.size() > 0 ) {
				
				MyBinaryTreeNode<T> currentNode = parentLevel.pollFirst();
				
				
				MyBinaryTreeNode<T> leftNode = Optional.ofNullable(currentNode.left).orElse(null);
				MyBinaryTreeNode<T> rightNode = Optional.ofNullable(currentNode.right).orElse(null);
//				
//				String str = String.format("(Value, L, R)=%4s, %4s, %4s\n", 
//						strNode(currentNode)
//						, strNode( leftNode )
//						, strNode( rightNode));
				
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
	
	
	
	public static <T> MyBinaryTreeNode<T> findByTag( MyBinaryTreeNode<T> root, char tag ){
		return findByTagHelper( root, tag, new Sequence() );
	}
	
	
	private static class Sequence{
		public int value;
	}
	
	
	
	private static <T> MyBinaryTreeNode<T> findByTagHelper( MyBinaryTreeNode<T> currentNode, char tag, Sequence sequence ){
		
		if( currentNode == null ) {
			return null;
		}
		
		sequence.value++;
		
		if( ( tag - ( 'A' -1 ) ) == sequence.value ) {
			return currentNode;
		}
		
		MyBinaryTreeNode<T> leftResult = findByTagHelper( currentNode.left, tag, sequence );
		if( leftResult != null ) {
			return leftResult;
		}
		
		MyBinaryTreeNode<T> rightResult = findByTagHelper( currentNode.right, tag, sequence );
		if( rightResult != null ) {
			return rightResult;
		}
		
		
		return null;
	}
	
	
	
	public static <T> String strNode( MyBinaryTreeNode<T> node ) {
		
		if( node == null ) {
			return "(NULL)";
		}
		//DETAIL: if tag is not specified, it is 0, 
		//return String.valueOf( node.data ) + "\\" + node.tag;
		return String.valueOf( node.data ) + "|" + node.tag;
	}
	
	
	@Override
	public String toString() {
		
		MyBinaryTreeNode<T> leftNode = Optional.ofNullable(this.left).orElse(null);
		MyBinaryTreeNode<T> rightNode = Optional.ofNullable(this.right).orElse(null);
		
		String str = String.format("(Value, L, R)=%4s, %4s, %4s\n", 
				strNode(this)
				, strNode( leftNode )
				, strNode( rightNode));
		
		return str;
		
	}
	
	
	
	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> nodeA = makeFigure10_01Tree();
		printInLevel( nodeA );
		
		
		out.println("--------------------------------");
		out.println( strNode( findByTag(nodeA, 'B')) );
		out.println( strNode( findByTag(nodeA, 'J')) );
		out.println( strNode( findByTag(nodeA, 'L')) );
		out.println( strNode( findByTag(nodeA, 'P')) );
		
		
	}
	
	
	
	public static MyBinaryTreeNode<Integer> makeFigure10_01Tree(){
		
		
		MyBinaryTreeNode<Integer> nodeM = new MyBinaryTreeNode<>(641, 'M');
		
		MyBinaryTreeNode<Integer> nodeH = new MyBinaryTreeNode<>(17, 'H');
		MyBinaryTreeNode<Integer> nodeL = new MyBinaryTreeNode<>(401, 'L', null, nodeM);
		MyBinaryTreeNode<Integer> nodeN = new MyBinaryTreeNode<>(257, 'N');
		
		MyBinaryTreeNode<Integer> nodeD = new MyBinaryTreeNode<>(28, 'D');
		MyBinaryTreeNode<Integer> nodeE = new MyBinaryTreeNode<>(0, 'E');
		MyBinaryTreeNode<Integer> nodeG = new MyBinaryTreeNode<>(3, 'G', nodeH, null);
		MyBinaryTreeNode<Integer> nodeK = new MyBinaryTreeNode<>(1, 'K', nodeL, nodeN);
		MyBinaryTreeNode<Integer> nodeP = new MyBinaryTreeNode<>(28, 'P');
		
		MyBinaryTreeNode<Integer> nodeC = new MyBinaryTreeNode<>(271, 'C', nodeD, nodeE);
		MyBinaryTreeNode<Integer> nodeF = new MyBinaryTreeNode<>(561, 'F', null, nodeG);
		MyBinaryTreeNode<Integer> nodeJ = new MyBinaryTreeNode<>(2, 'J', null, nodeK);
		MyBinaryTreeNode<Integer> nodeO = new MyBinaryTreeNode<>(271, 'O', null, nodeP);
		
		MyBinaryTreeNode<Integer> nodeB = new MyBinaryTreeNode<>(6, 'B', nodeC, nodeF);
		MyBinaryTreeNode<Integer> nodeI = new MyBinaryTreeNode<>(6, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNode<Integer> nodeA = new MyBinaryTreeNode<>(314, 'A', nodeB, nodeI);
		
		return nodeA;
	}
	
	
	
	public static MyBinaryTreeNode<Integer> makeFigure10_04Tree(){
		
		
		MyBinaryTreeNode<Integer> nodeM = new MyBinaryTreeNode<>(1, 'M');
		
		MyBinaryTreeNode<Integer> nodeH = new MyBinaryTreeNode<>(0, 'H');
		MyBinaryTreeNode<Integer> nodeL = new MyBinaryTreeNode<>(1, 'L', null, nodeM);
		MyBinaryTreeNode<Integer> nodeN = new MyBinaryTreeNode<>(0, 'N');
		
		MyBinaryTreeNode<Integer> nodeD = new MyBinaryTreeNode<>(0, 'D');
		MyBinaryTreeNode<Integer> nodeE = new MyBinaryTreeNode<>(1, 'E');
		MyBinaryTreeNode<Integer> nodeG = new MyBinaryTreeNode<>(1, 'G', nodeH, null);
		MyBinaryTreeNode<Integer> nodeK = new MyBinaryTreeNode<>(0, 'K', nodeL, nodeN);
		MyBinaryTreeNode<Integer> nodeP = new MyBinaryTreeNode<>(0, 'P');
		
		MyBinaryTreeNode<Integer> nodeC = new MyBinaryTreeNode<>(0, 'C', nodeD, nodeE);
		MyBinaryTreeNode<Integer> nodeF = new MyBinaryTreeNode<>(1, 'F', null, nodeG);
		MyBinaryTreeNode<Integer> nodeJ = new MyBinaryTreeNode<>(0, 'J', null, nodeK);
		MyBinaryTreeNode<Integer> nodeO = new MyBinaryTreeNode<>(0, 'O', null, nodeP);
		
		MyBinaryTreeNode<Integer> nodeB = new MyBinaryTreeNode<>(0, 'B', nodeC, nodeF);
		MyBinaryTreeNode<Integer> nodeI = new MyBinaryTreeNode<>(1, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNode<Integer> nodeA = new MyBinaryTreeNode<>(1, 'A', nodeB, nodeI);
		
		return nodeA;
	}

}









