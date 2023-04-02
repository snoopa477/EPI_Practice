package util;
import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class MyBinaryTreeNodeWithNext<T> {
	
	public T data;
	public MyBinaryTreeNodeWithNext<T> left, right, next;
	//additional
	//default value
	public char tag = 'x';
	
	
	public MyBinaryTreeNodeWithNext(T data) {
		this.data = data;
	}
	
	
	
	public MyBinaryTreeNodeWithNext(T data, char tag) {
		this.data = data;
		this.tag = tag;
	}

	
	
	public MyBinaryTreeNodeWithNext(T data, MyBinaryTreeNodeWithNext<T> left, MyBinaryTreeNodeWithNext<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
	
	public MyBinaryTreeNodeWithNext(T data, char tag, MyBinaryTreeNodeWithNext<T> left, MyBinaryTreeNodeWithNext<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.tag = tag;
	}
	
	
	//ERROR: Cannot make a static reference to the non-static type T
//	public static void printInLevel( MyBinaryTreeNodeWithNext<T> root ) {
	public static <T> void printInLevel( MyBinaryTreeNodeWithNext<T> root ) {
		
		if( root == null ) {
			out.println("null");
		}
		
		
		Deque<MyBinaryTreeNodeWithNext<T>> parentLevel = new LinkedList<>();
		Deque<MyBinaryTreeNodeWithNext<T>> childLevel = new LinkedList<>();
		
		parentLevel.add(root);
		
		int level = 0;
		
		while( parentLevel.size() > 0 ) {
			out.println("------------------------------------ " + level++ );
			//PURPOSE: consume parent level
			while( parentLevel.size() > 0 ) {
				
				MyBinaryTreeNodeWithNext<T> currentNode = parentLevel.pollFirst();
				
				
				MyBinaryTreeNodeWithNext<T> leftNode = Optional.ofNullable(currentNode.left).orElse(null);
				MyBinaryTreeNodeWithNext<T> rightNode = Optional.ofNullable(currentNode.right).orElse(null);
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
	
	
	
	public static <T> MyBinaryTreeNodeWithNext<T> findByTag( MyBinaryTreeNodeWithNext<T> root, char tag ){
		return findByTagHelper( root, tag, new Sequence() );
	}
	
	
	private static class Sequence{
		public int value;
	}
	
	
	
	private static <T> MyBinaryTreeNodeWithNext<T> findByTagHelper( MyBinaryTreeNodeWithNext<T> currentNode, char tag, Sequence sequence ){
		
		if( currentNode == null ) {
			return null;
		}
		
		sequence.value++;
		
		if( ( tag - ( 'A' -1 ) ) == sequence.value ) {
			return currentNode;
		}
		
		MyBinaryTreeNodeWithNext<T> leftResult = findByTagHelper( currentNode.left, tag, sequence );
		if( leftResult != null ) {
			return leftResult;
		}
		
		MyBinaryTreeNodeWithNext<T> rightResult = findByTagHelper( currentNode.right, tag, sequence );
		if( rightResult != null ) {
			return rightResult;
		}
		
		
		return null;
	}
	
	
	
	public static <T> String strNode( MyBinaryTreeNodeWithNext<T> node ) {
		
		if( node == null ) {
			return "(NULL)";
		}
		//DETAIL: if tag is not specified, it is 0, 
		//return String.valueOf( node.data ) + "\\" + node.tag;
		return String.valueOf( node.data ) + "|" + node.tag;
	}
	
	
	@Override
	public String toString() {
		
		MyBinaryTreeNodeWithNext<T> leftNode = Optional.ofNullable(this.left).orElse(null);
		MyBinaryTreeNodeWithNext<T> rightNode = Optional.ofNullable(this.right).orElse(null);
		
		String str = String.format("(Value, L, R)=%4s, %4s, %4s\n", 
				strNode(this)
				, strNode( leftNode )
				, strNode( rightNode));
		
		return str;
		
	}
	
	
	
	public static void main(String[] args) {
		
		MyBinaryTreeNodeWithNext<Integer> nodeA = makeFigure10_01Tree();
		printInLevel( nodeA );
		
		
		out.println("--------------------------------");
		out.println( strNode( findByTag(nodeA, 'B')) );
		out.println( strNode( findByTag(nodeA, 'J')) );
		out.println( strNode( findByTag(nodeA, 'L')) );
		out.println( strNode( findByTag(nodeA, 'P')) );
		
		
	}
	
	
	
	public static MyBinaryTreeNodeWithNext<Integer> makeFigure10_01Tree(){
		
		
		MyBinaryTreeNodeWithNext<Integer> nodeM = new MyBinaryTreeNodeWithNext<>(641, 'M');
		
		MyBinaryTreeNodeWithNext<Integer> nodeH = new MyBinaryTreeNodeWithNext<>(17, 'H');
		MyBinaryTreeNodeWithNext<Integer> nodeL = new MyBinaryTreeNodeWithNext<>(401, 'L', null, nodeM);
		MyBinaryTreeNodeWithNext<Integer> nodeN = new MyBinaryTreeNodeWithNext<>(257, 'N');
		
		MyBinaryTreeNodeWithNext<Integer> nodeD = new MyBinaryTreeNodeWithNext<>(28, 'D');
		MyBinaryTreeNodeWithNext<Integer> nodeE = new MyBinaryTreeNodeWithNext<>(0, 'E');
		MyBinaryTreeNodeWithNext<Integer> nodeG = new MyBinaryTreeNodeWithNext<>(3, 'G', nodeH, null);
		MyBinaryTreeNodeWithNext<Integer> nodeK = new MyBinaryTreeNodeWithNext<>(1, 'K', nodeL, nodeN);
		MyBinaryTreeNodeWithNext<Integer> nodeP = new MyBinaryTreeNodeWithNext<>(28, 'P');
		
		MyBinaryTreeNodeWithNext<Integer> nodeC = new MyBinaryTreeNodeWithNext<>(271, 'C', nodeD, nodeE);
		MyBinaryTreeNodeWithNext<Integer> nodeF = new MyBinaryTreeNodeWithNext<>(561, 'F', null, nodeG);
		MyBinaryTreeNodeWithNext<Integer> nodeJ = new MyBinaryTreeNodeWithNext<>(2, 'J', null, nodeK);
		MyBinaryTreeNodeWithNext<Integer> nodeO = new MyBinaryTreeNodeWithNext<>(271, 'O', null, nodeP);
		
		MyBinaryTreeNodeWithNext<Integer> nodeB = new MyBinaryTreeNodeWithNext<>(6, 'B', nodeC, nodeF);
		MyBinaryTreeNodeWithNext<Integer> nodeI = new MyBinaryTreeNodeWithNext<>(6, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNodeWithNext<Integer> nodeA = new MyBinaryTreeNodeWithNext<>(314, 'A', nodeB, nodeI);
		
		return nodeA;
	}
	
	
	
	public static MyBinaryTreeNodeWithNext<Integer> makeFigure10_04Tree(){
		
		
		MyBinaryTreeNodeWithNext<Integer> nodeM = new MyBinaryTreeNodeWithNext<>(1, 'M');
		
		MyBinaryTreeNodeWithNext<Integer> nodeH = new MyBinaryTreeNodeWithNext<>(0, 'H');
		MyBinaryTreeNodeWithNext<Integer> nodeL = new MyBinaryTreeNodeWithNext<>(1, 'L', null, nodeM);
		MyBinaryTreeNodeWithNext<Integer> nodeN = new MyBinaryTreeNodeWithNext<>(0, 'N');
		
		MyBinaryTreeNodeWithNext<Integer> nodeD = new MyBinaryTreeNodeWithNext<>(0, 'D');
		MyBinaryTreeNodeWithNext<Integer> nodeE = new MyBinaryTreeNodeWithNext<>(1, 'E');
		MyBinaryTreeNodeWithNext<Integer> nodeG = new MyBinaryTreeNodeWithNext<>(1, 'G', nodeH, null);
		MyBinaryTreeNodeWithNext<Integer> nodeK = new MyBinaryTreeNodeWithNext<>(0, 'K', nodeL, nodeN);
		MyBinaryTreeNodeWithNext<Integer> nodeP = new MyBinaryTreeNodeWithNext<>(0, 'P');
		
		MyBinaryTreeNodeWithNext<Integer> nodeC = new MyBinaryTreeNodeWithNext<>(0, 'C', nodeD, nodeE);
		MyBinaryTreeNodeWithNext<Integer> nodeF = new MyBinaryTreeNodeWithNext<>(1, 'F', null, nodeG);
		MyBinaryTreeNodeWithNext<Integer> nodeJ = new MyBinaryTreeNodeWithNext<>(0, 'J', null, nodeK);
		MyBinaryTreeNodeWithNext<Integer> nodeO = new MyBinaryTreeNodeWithNext<>(0, 'O', null, nodeP);
		
		MyBinaryTreeNodeWithNext<Integer> nodeB = new MyBinaryTreeNodeWithNext<>(0, 'B', nodeC, nodeF);
		MyBinaryTreeNodeWithNext<Integer> nodeI = new MyBinaryTreeNodeWithNext<>(1, 'I', nodeJ, nodeO);
		
		MyBinaryTreeNodeWithNext<Integer> nodeA = new MyBinaryTreeNodeWithNext<>(1, 'A', nodeB, nodeI);
		
		return nodeA;
	}
	
	
	/**
	 * 
	 * @return complete binary tree
	 */
	public static MyBinaryTreeNodeWithNext<Integer> makeFigure10_06Tree(){
		
		
		MyBinaryTreeNodeWithNext<Integer> nodeD = new MyBinaryTreeNodeWithNext<>(1, 'D');
		MyBinaryTreeNodeWithNext<Integer> nodeE = new MyBinaryTreeNodeWithNext<>(1, 'E');
		MyBinaryTreeNodeWithNext<Integer> nodeG = new MyBinaryTreeNodeWithNext<>(1, 'G');
		MyBinaryTreeNodeWithNext<Integer> nodeH = new MyBinaryTreeNodeWithNext<>(1, 'H');
		MyBinaryTreeNodeWithNext<Integer> nodeK = new MyBinaryTreeNodeWithNext<>(1, 'K');
		MyBinaryTreeNodeWithNext<Integer> nodeL = new MyBinaryTreeNodeWithNext<>(1, 'L');
		MyBinaryTreeNodeWithNext<Integer> nodeN = new MyBinaryTreeNodeWithNext<>(1, 'N');
		MyBinaryTreeNodeWithNext<Integer> nodeO = new MyBinaryTreeNodeWithNext<>(1, 'O');
		
		
		MyBinaryTreeNodeWithNext<Integer> nodeC = new MyBinaryTreeNodeWithNext<>(1, 'C', nodeD, nodeE);
		MyBinaryTreeNodeWithNext<Integer> nodeF = new MyBinaryTreeNodeWithNext<>(1, 'F', nodeG, nodeH);
		MyBinaryTreeNodeWithNext<Integer> nodeJ = new MyBinaryTreeNodeWithNext<>(1, 'J', nodeK, nodeL);
		MyBinaryTreeNodeWithNext<Integer> nodeM = new MyBinaryTreeNodeWithNext<>(1, 'M', nodeN, nodeO);
		
		MyBinaryTreeNodeWithNext<Integer> nodeB = new MyBinaryTreeNodeWithNext<>(1, 'B', nodeC, nodeF);
		MyBinaryTreeNodeWithNext<Integer> nodeI = new MyBinaryTreeNodeWithNext<>(1, 'I', nodeJ, nodeM);
		
		MyBinaryTreeNodeWithNext<Integer> nodeA = new MyBinaryTreeNodeWithNext<>(1, 'A', nodeB, nodeI);
		
		
		return nodeA;
	}
}


