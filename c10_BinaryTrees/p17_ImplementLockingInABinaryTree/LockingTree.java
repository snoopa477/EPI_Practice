package c10_BinaryTrees.p17_ImplementLockingInABinaryTree;
import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;



public class LockingTree<T> {

	public T data;
	public char tag;
	public LockingTree<T> left, right, parent;
	
	/*THINK_FURTHER: this variable is updated(write) by some other nodes O when O locks itself; however,
	 * this variable is used(read) when current lock try to lock itself   
	 */
	public int countLockOfDescendants = 0;
	
	public boolean isLocked = false;
	
	
	/**
	 * 1. if locks itself successfully:
	 * 2. update all ancestor's counter of locks
	 * @return
	 */
	public boolean lock() {
		
		/**
		 * REASONING:
		 * since look up its own  `countLockOfDescendants` is faster than 
		 * checking ancestors by iterating up till root
		 * so checking priority is
		 * 
		 * 1. countLockOfDescendants
		 * if no lock
		 * 2. check ancestors
		 */
		
		if( isLocked ) {
			return false;
		}
		
		
		//step 1: 
		if( countLockOfDescendants > 0 ) {
			return false;
		}
		
		
		if( isAnyAncestorsHavingLock() ) {
			return false;
		}
		
		/* can actually merge the above into this: 
		 * if(  countLockOfDescendants > 0 || isAnyAncestorsHavingLock() ) return false;
		 */
		
		//Reaching here meaning no locks above and down, it can use lock
		isLocked = true;
		
		/* THINK_FURTHER:
		 * this node N is locked now, what does it have to do with other nodes?
		 * for node D in descendants, since N is ancestor => have nothing to do with D `countLockOfDescendants`
		 * for node A in ancestors, since N is descendant => have to UPDATE each A's  `countLockOfDescendants`
		 */
		updateAncestorsCounterOfLock( true );
		
		
		
		return true;
	}
	
	
	
	//unlock doesn't require anyone's permission
	public boolean unlock() {
		
		if( isLocked == false) {
			return false;
		}
		
		//WRONG: forget to add this line
		isLocked = false;
		
		updateAncestorsCounterOfLock( false );
		
		return true;
	}
	
	
	
	private boolean isAnyAncestorsHavingLock() {
		
		LockingTree<T> ancestor = this.parent;
		
		//null means it reaches beyond root, meaning all ancestor has been visited
		while( ancestor != null ) {
			
			if( ancestor.isLocked ) {
				return true;
			}
			
			ancestor = ancestor.parent;
		}
		
		return false;
	}
	
	
	
	private void updateAncestorsCounterOfLock( boolean isIncremented ) {
		
		LockingTree<T> ancestor = this.parent;
		
		while( ancestor != null ) {
			
			if( isIncremented ) {
				ancestor.countLockOfDescendants++;
			}
			else {
				//THINK_FURTHER: it can never be negative, under the premise that each -- must correspond to a ++
				ancestor.countLockOfDescendants--;
			}
			
			ancestor = ancestor.parent;
		}
	}
	
	
	//------------------------------------------------------------------------------
	public LockingTree(T data) {
		this.data = data;
	}
	
	
	
	public LockingTree(T data, char tag) {
		this.data = data;
		this.tag = tag;
	}

	
	
	public LockingTree(T data, LockingTree<T> left, LockingTree<T> right) {
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
	
	
	
	public LockingTree(T data, char tag, LockingTree<T> left, LockingTree<T> right) {
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
	
	
	
	public LockingTree(T data, char tag, LockingTree<T> left, LockingTree<T> right, LockingTree<T> parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.tag = tag;
	}
	
	
	
	
	
	//ERROR: Cannot make a static reference to the non-static type T
//	public static void printInLevel( MyBinaryTreeNode<T> root ) {
	public static <T> void printInLevel( LockingTree<T> root ) {
		
		if( root == null ) {
			out.println("null");
		}
		
		
		Deque<LockingTree<T>> parentLevel = new LinkedList<>();
		Deque<LockingTree<T>> childLevel = new LinkedList<>();
		
		parentLevel.add(root);
		
		int level = 0;
		
		while( parentLevel.size() > 0 ) {
			out.println("------------------------------------ " + level++ );
			//PURPOSE: consume parent level
			while( parentLevel.size() > 0 ) {
				
				LockingTree<T> currentNode = parentLevel.pollFirst();
				
				
				LockingTree<T> leftNode = Optional.ofNullable(currentNode.left).orElse(null);
				LockingTree<T> rightNode = Optional.ofNullable(currentNode.right).orElse(null);
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
	
	
	
	public static <T> LockingTree<T> findByTag( LockingTree<T> root, char tag ){
		return findByTagHelper( root, tag, new Sequence() );
	}
	
	
	private static class Sequence{
		public int value;
	}
	
	
	
	private static <T> LockingTree<T> findByTagHelper( LockingTree<T> currentNode, char tag, Sequence sequence ){
		
		if( currentNode == null ) {
			return null;
		}
		
		sequence.value++;
		
		if( ( tag - ( 'A' -1 ) ) == sequence.value ) {
			return currentNode;
		}
		
		LockingTree<T> leftResult = findByTagHelper( currentNode.left, tag, sequence );
		if( leftResult != null ) {
			return leftResult;
		}
		
		LockingTree<T> rightResult = findByTagHelper( currentNode.right, tag, sequence );
		if( rightResult != null ) {
			return rightResult;
		}
		
		
		return null;
	}
	
	
	
	public static <T> String strNode( LockingTree<T> node ) {
		
		if( node == null ) {
			return "(NULL)";
		}
		return String.valueOf( node.data ) + "\\" + node.tag + "\\" + ( node.isLocked? "[X]" : "[ ]" ) + "\\" + node.countLockOfDescendants  ;
	}
	
	
	@Override
	public String toString() {
		
		LockingTree<T> leftNode = Optional.ofNullable(this.left).orElse(null);
		LockingTree<T> rightNode = Optional.ofNullable(this.right).orElse(null);
		LockingTree<T> parentNode = Optional.ofNullable(this.parent).orElse(null);
		
//		String str = String.format("(Value, L, R, P)=%4s, %4s, %4s, %4s\n", 
//				strNode(this)
//				, strNode( leftNode )
//				, strNode( rightNode)
//				, strNode( parentNode));
//		
//		return str;
		
		return strNode(this);
		
	}
	
	
	
	public static void main(String[] args) {
		
		LockingTree<Integer> nodeA = makeFigure10_01Tree();
		printInLevel( nodeA );
		
		
		out.println("--------------------------------");
		out.println( findByTag(nodeA, 'B') );
		out.println( findByTag(nodeA, 'J') );
		out.println( findByTag(nodeA, 'L') );
		out.println( findByTag(nodeA, 'P') );
		out.println( findByTag(nodeA, 'A') );
		out.println( findByTag(nodeA, 'Z') );
		
		
	}
	
	
	
	public static LockingTree<Integer> makeFigure10_01Tree(){
		
		
		LockingTree<Integer> nodeM = new LockingTree<>(641, 'M');
		
		LockingTree<Integer> nodeH = new LockingTree<>(17, 'H');
		LockingTree<Integer> nodeL = new LockingTree<>(401, 'L', null, nodeM);
		LockingTree<Integer> nodeN = new LockingTree<>(257, 'N');
		
		LockingTree<Integer> nodeD = new LockingTree<>(28, 'D');
		LockingTree<Integer> nodeE = new LockingTree<>(0, 'E');
		LockingTree<Integer> nodeG = new LockingTree<>(3, 'G', nodeH, null);
		LockingTree<Integer> nodeK = new LockingTree<>(1, 'K', nodeL, nodeN);
		LockingTree<Integer> nodeP = new LockingTree<>(28, 'P');
		
		LockingTree<Integer> nodeC = new LockingTree<>(271, 'C', nodeD, nodeE);
		LockingTree<Integer> nodeF = new LockingTree<>(561, 'F', null, nodeG);
		LockingTree<Integer> nodeJ = new LockingTree<>(2, 'J', null, nodeK);
		LockingTree<Integer> nodeO = new LockingTree<>(271, 'O', null, nodeP);
		
		LockingTree<Integer> nodeB = new LockingTree<>(6, 'B', nodeC, nodeF);
		LockingTree<Integer> nodeI = new LockingTree<>(6, 'I', nodeJ, nodeO);
		
		LockingTree<Integer> nodeA = new LockingTree<>(314, 'A', nodeB, nodeI);
		
		
		return nodeA;
	}
	
}


