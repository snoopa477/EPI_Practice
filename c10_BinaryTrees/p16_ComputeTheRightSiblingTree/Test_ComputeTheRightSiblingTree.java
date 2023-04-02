package c10_BinaryTrees.p16_ComputeTheRightSiblingTree;
import static java.lang.System.out;

import util.MyBinaryTreeNodeWithNext;

public class Test_ComputeTheRightSiblingTree {

	public static void main(String[] args) {
		
		
		out.println("---------- ComputeTheRightSiblingTree_01" );
		{
			//MyBinaryTreeNodeWithNext<T>
			MyBinaryTreeNodeWithNext<Integer> root_10_06 = MyBinaryTreeNodeWithNext.makeFigure10_06Tree();
			ComputeTheRightSiblingTree_01.constructRightSibling(root_10_06);
			
			out.println("---root_10_06");
			showLevels( root_10_06 );
			
		}
		
		
		out.println("---------- ComputeTheRightSiblingTree_02_myTraversalAndAssign" );
		{
			MyBinaryTreeNodeWithNext<Integer> root_10_01 = MyBinaryTreeNodeWithNext.makeFigure10_01Tree();
			ComputeTheRightSiblingTree_02_myTraversalAndAssign.constructRightSibling(root_10_01);
			
			MyBinaryTreeNodeWithNext<Integer> root_10_06 = MyBinaryTreeNodeWithNext.makeFigure10_06Tree();
			ComputeTheRightSiblingTree_01.constructRightSibling(root_10_06);
			
			out.println("---root_10_01");
			showLevels( root_10_01 );
			out.println("---root_10_06");
			showLevels( root_10_06 );
			
		}
	}
	
	
	
	public static<T> void showLevels( MyBinaryTreeNodeWithNext<T> root ) {
		
		int level = 0;
		
		MyBinaryTreeNodeWithNext<T> currentNode = root;
		
		while( currentNode != null ) {
			
			out.println("- - - level - - -  " + level++ );
			MyBinaryTreeNodeWithNext<T> sibling = currentNode;
			while( sibling != null ) {
				out.println( sibling );
				sibling = sibling.next;
			}
			
			currentNode = currentNode.left;
		}
		
		
		
		
	}

}


