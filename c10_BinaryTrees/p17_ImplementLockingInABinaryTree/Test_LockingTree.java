package c10_BinaryTrees.p17_ImplementLockingInABinaryTree;
import static java.lang.System.out;
public class Test_LockingTree {

	public static void main(String[] args) {
		
		LockingTree<Integer> tree_1001 =  LockingTree.makeFigure10_01Tree();
		
		LockingTree<Integer> nodeB = LockingTree.findByTag(tree_1001, 'B');
		LockingTree<Integer> nodeJ = LockingTree.findByTag(tree_1001, 'J');
		LockingTree<Integer> nodeL = LockingTree.findByTag(tree_1001, 'L');
		LockingTree<Integer> nodeA = LockingTree.findByTag(tree_1001, 'A');
		
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++ 00: ");
		LockingTree.printInLevel( tree_1001 );
		
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++ 01: nodeB.lock()");
		nodeB.lock();
		LockingTree.printInLevel( tree_1001 );
		
		
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++ 02: nodeJ.lock();");
		nodeJ.lock();
		LockingTree.printInLevel( tree_1001 );
		
		
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++ 03: nodeL.lock();");
		nodeL.lock();
		LockingTree.printInLevel( tree_1001 );
		
		
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++ 04: nodeJ.unlock();");
		nodeJ.unlock();
		LockingTree.printInLevel( tree_1001 );
		
		
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++ 05: nodeL.lock();");
		nodeL.lock();
		LockingTree.printInLevel( tree_1001 );
		
	}

}


