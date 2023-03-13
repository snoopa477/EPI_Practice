package util;
import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class MyBinaryTreeNodeWithSize<T> {

	public T data;
	public MyBinaryTreeNodeWithSize<T> left, right;
	//additional
	public char tag;
	public int size;
	
	
	public MyBinaryTreeNodeWithSize(T data) {
		this.data = data;
		this.size = 1;
	}
	
	
	
	public MyBinaryTreeNodeWithSize(T data, char tag) {
		this.data = data;
		this.tag = tag;
		this.size = 1;
	}

	
	
	public MyBinaryTreeNodeWithSize(T data, MyBinaryTreeNodeWithSize<T> left, MyBinaryTreeNodeWithSize<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		//this.size = 1 + Optional.ofNullable(left.size).orElse(0);
		this.size = 1 + ( left != null? left.size: 0) + ( right != null? right.size: 0);
	}
	
	
	
	public MyBinaryTreeNodeWithSize(T data, char tag, MyBinaryTreeNodeWithSize<T> left, MyBinaryTreeNodeWithSize<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.tag = tag;
		this.size = 1 + ( left != null? left.size: 0) + ( right != null? right.size: 0);
	}
	
	
	//ERROR: Cannot make a static reference to the non-static type T
//	public static void printInLevel( MyBinaryTreeNodeWithSize<T> root ) {
	public static <T> void printInLevel( MyBinaryTreeNodeWithSize<T> root ) {
		
		if( root == null ) {
			out.println("null");
		}
		
		
		Deque<MyBinaryTreeNodeWithSize<T>> parentLevel = new LinkedList<>();
		Deque<MyBinaryTreeNodeWithSize<T>> childLevel = new LinkedList<>();
		
		parentLevel.add(root);
		
		int level = 0;
		
		while( parentLevel.size() > 0 ) {
			out.println("------------------------------------ " + level++ );
			//PURPOSE: consume parent level
			while( parentLevel.size() > 0 ) {
				
				MyBinaryTreeNodeWithSize<T> currentNode = parentLevel.pollFirst();
				
				
				MyBinaryTreeNodeWithSize<T> leftNode = Optional.ofNullable(currentNode.left).orElse(null);
				MyBinaryTreeNodeWithSize<T> rightNode = Optional.ofNullable(currentNode.right).orElse(null);
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
	
	
	
	public static <T> MyBinaryTreeNodeWithSize<T> findByTag( MyBinaryTreeNodeWithSize<T> root, char tag ){
		return findByTagHelper( root, tag, new Sequence() );
	}
	
	
	private static class Sequence{
		public int value;
	}
	
	
	
	private static <T> MyBinaryTreeNodeWithSize<T> findByTagHelper( MyBinaryTreeNodeWithSize<T> currentNode, char tag, Sequence sequence ){
		
		if( currentNode == null ) {
			return null;
		}
		
		sequence.value++;
		
		if( ( tag - ( 'A' -1 ) ) == sequence.value ) {
			return currentNode;
		}
		
		MyBinaryTreeNodeWithSize<T> leftResult = findByTagHelper( currentNode.left, tag, sequence );
		if( leftResult != null ) {
			return leftResult;
		}
		
		MyBinaryTreeNodeWithSize<T> rightResult = findByTagHelper( currentNode.right, tag, sequence );
		if( rightResult != null ) {
			return rightResult;
		}
		
		
		return null;
	}
	
	
	
	public static <T> String strNode( MyBinaryTreeNodeWithSize<T> node ) {
		
		if( node == null ) {
			return "(NULL)";
		}
		return "( value: " + String.valueOf( node.data ) + ", size: " + node.size  +", tag: " + node.tag  + " )";
	}
	
	
	@Override
	public String toString() {
		
		MyBinaryTreeNodeWithSize<T> leftNode = Optional.ofNullable(this.left).orElse(null);
		MyBinaryTreeNodeWithSize<T> rightNode = Optional.ofNullable(this.right).orElse(null);
		
		String str = String.format("(Value, L, R)=%4s, %4s, %4s\n", 
				strNode(this)
				, strNode( leftNode )
				, strNode( rightNode));
		
		return str;
		
	}
	
	
	
	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithSize<Integer> nodeA = makeFigure10_01Tree();
		printInLevel( nodeA );
		
		
		out.println("--------------------------------");
		out.println( strNode( findByTag(nodeA, 'B')) );
		out.println( strNode( findByTag(nodeA, 'J')) );
		out.println( strNode( findByTag(nodeA, 'L')) );
		out.println( strNode( findByTag(nodeA, 'P')) );
		
		
	}
	
	
	
	public static MyBinaryTreeNodeWithSize<Integer> makeFigure10_01Tree(){
		
		
		MyBinaryTreeNodeWithSize<Integer> nodeM = new MyBinaryTreeNodeWithSize<>(641, 'M');
		
		MyBinaryTreeNodeWithSize<Integer> nodeH = new MyBinaryTreeNodeWithSize<>(17, 'H');
		MyBinaryTreeNodeWithSize<Integer> nodeL = new MyBinaryTreeNodeWithSize<>(401, 'L', null, nodeM);
		MyBinaryTreeNodeWithSize<Integer> nodeN = new MyBinaryTreeNodeWithSize<>(257, 'N');
		
		MyBinaryTreeNodeWithSize<Integer> nodeD = new MyBinaryTreeNodeWithSize<>(28, 'D');
		MyBinaryTreeNodeWithSize<Integer> nodeE = new MyBinaryTreeNodeWithSize<>(0, 'E');
		MyBinaryTreeNodeWithSize<Integer> nodeG = new MyBinaryTreeNodeWithSize<>(3, 'G', nodeH, null);
		MyBinaryTreeNodeWithSize<Integer> nodeK = new MyBinaryTreeNodeWithSize<>(1, 'K', nodeL, nodeN);
		MyBinaryTreeNodeWithSize<Integer> nodeP = new MyBinaryTreeNodeWithSize<>(28, 'P');
		
		MyBinaryTreeNodeWithSize<Integer> nodeC = new MyBinaryTreeNodeWithSize<>(271, 'C', nodeD, nodeE);
		MyBinaryTreeNodeWithSize<Integer> nodeF = new MyBinaryTreeNodeWithSize<>(561, 'F', null, nodeG);
		MyBinaryTreeNodeWithSize<Integer> nodeJ = new MyBinaryTreeNodeWithSize<>(2, 'J', null, nodeK);
		MyBinaryTreeNodeWithSize<Integer> nodeO = new MyBinaryTreeNodeWithSize<>(271, 'O', null, nodeP);
		
		MyBinaryTreeNodeWithSize<Integer> nodeB = new MyBinaryTreeNodeWithSize<>(6, 'B', nodeC, nodeF);
		MyBinaryTreeNodeWithSize<Integer> nodeI = new MyBinaryTreeNodeWithSize<>(6, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNodeWithSize<Integer> nodeA = new MyBinaryTreeNodeWithSize<>(314, 'A', nodeB, nodeI);
		
		return nodeA;
	}
	
	
	
	public static MyBinaryTreeNodeWithSize<Integer> makeFigure10_04Tree(){
		
		
		MyBinaryTreeNodeWithSize<Integer> nodeM = new MyBinaryTreeNodeWithSize<>(1, 'M');
		
		MyBinaryTreeNodeWithSize<Integer> nodeH = new MyBinaryTreeNodeWithSize<>(0, 'H');
		MyBinaryTreeNodeWithSize<Integer> nodeL = new MyBinaryTreeNodeWithSize<>(1, 'L', null, nodeM);
		MyBinaryTreeNodeWithSize<Integer> nodeN = new MyBinaryTreeNodeWithSize<>(0, 'N');
		
		MyBinaryTreeNodeWithSize<Integer> nodeD = new MyBinaryTreeNodeWithSize<>(0, 'D');
		MyBinaryTreeNodeWithSize<Integer> nodeE = new MyBinaryTreeNodeWithSize<>(1, 'E');
		MyBinaryTreeNodeWithSize<Integer> nodeG = new MyBinaryTreeNodeWithSize<>(1, 'G', nodeH, null);
		MyBinaryTreeNodeWithSize<Integer> nodeK = new MyBinaryTreeNodeWithSize<>(0, 'K', nodeL, nodeN);
		MyBinaryTreeNodeWithSize<Integer> nodeP = new MyBinaryTreeNodeWithSize<>(0, 'P');
		
		MyBinaryTreeNodeWithSize<Integer> nodeC = new MyBinaryTreeNodeWithSize<>(0, 'C', nodeD, nodeE);
		MyBinaryTreeNodeWithSize<Integer> nodeF = new MyBinaryTreeNodeWithSize<>(1, 'F', null, nodeG);
		MyBinaryTreeNodeWithSize<Integer> nodeJ = new MyBinaryTreeNodeWithSize<>(0, 'J', null, nodeK);
		MyBinaryTreeNodeWithSize<Integer> nodeO = new MyBinaryTreeNodeWithSize<>(0, 'O', null, nodeP);
		
		MyBinaryTreeNodeWithSize<Integer> nodeB = new MyBinaryTreeNodeWithSize<>(0, 'B', nodeC, nodeF);
		MyBinaryTreeNodeWithSize<Integer> nodeI = new MyBinaryTreeNodeWithSize<>(1, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNodeWithSize<Integer> nodeA = new MyBinaryTreeNodeWithSize<>(1, 'A', nodeB, nodeI);
		
		return nodeA;
	}
}


