package c10_BinaryTrees.p16_ComputeTheRightSiblingTree;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyBinaryTreeNodeWithNext;

public class ComputeTheRightSiblingTree_02_myTraversalAndAssign {
	
	//it can be used to non-complete binary tree
	public static<T> void constructRightSibling( MyBinaryTreeNodeWithNext<T> root ) {
		
		HashMap<Integer, MyBinaryTreeNodeWithNext<T>> levelToToBeAssigned = new HashMap<>();
		travelAndAssignSibling( root, 0, levelToToBeAssigned );
		
	}
	
	
	//REFERENCE: 10.14 leaves of a binary tree
	private static<T> void travelAndAssignSibling( MyBinaryTreeNodeWithNext<T> root, int currentLevel, HashMap<Integer, MyBinaryTreeNodeWithNext<T>> levelToToBeAssigned ) {
		
		if( root == null ) {
			return ;
		}
		
		//level 0 must have no sibling to connect
		if( currentLevel != 0 ) {
		
			//first node in this level
			//WRONG, it would make level==0 go to else statement
			//if( currentLevel != 0 && levelToToBeAssigned.containsKey( currentLevel ) == false ) {
			if( currentLevel != 0 && levelToToBeAssigned.containsKey( currentLevel ) == false ) {
				levelToToBeAssigned.put( currentLevel, root );
			}
			/* non-first node in this level
			 * take out the last node
			 * let the last node points to current node
			 * Since current node haven't points to anyone, let it be the new last node
			 */
			else {
				MyBinaryTreeNodeWithNext<T> nodeToBeAssigned = levelToToBeAssigned.get( currentLevel );
				//the actual operation: assign sibling
				nodeToBeAssigned.next = root;
				levelToToBeAssigned.put( currentLevel, root );
			}
			
		}
			
		travelAndAssignSibling( root.left, currentLevel + 1, levelToToBeAssigned );
		travelAndAssignSibling( root.right, currentLevel + 1, levelToToBeAssigned );
		
	}
	
}


