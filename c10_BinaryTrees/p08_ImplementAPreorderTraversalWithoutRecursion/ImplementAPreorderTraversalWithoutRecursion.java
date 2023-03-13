package c10_BinaryTrees.p08_ImplementAPreorderTraversalWithoutRecursion;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.MyBinaryTreeNode;

public class ImplementAPreorderTraversalWithoutRecursion {
	
	public static<T> List<MyBinaryTreeNode<T>> preorder( MyBinaryTreeNode<T> root ){
		
		List<MyBinaryTreeNode<T>> preorderList = new ArrayList<>();
		
		/**
		 * IMAGINATION: manually set up DFS recursion stack? 
		 * 
		 * Since preorder will keep go down ( find descendant) if possible 
		 * every popped() element will try to introduce its descendant, and the first element we want to refer is the latest descendant,
		 * so the data structure, stack, meets our need
		 */
		Stack<MyBinaryTreeNode<T>> stack = new Stack<>();
		
		
		stack.push( root );
		
		while( stack.empty() == false ) {
			
			/* THINK_FURTHER
			 * get the latest/ last introduced element. 
			 * there's high chance is the descendant if last pop() element is non-leaf; however, if the last pop() element is leaf, no descendant is introduced
			 * the popped element serves as recursion stack ends, return to node of lower depth. 
			 * 
			 */
			MyBinaryTreeNode<T> currentNode = stack.pop();
			preorderList.add( currentNode );
			
			//DETAIL: right first then left. the last element, left will be popped first, meeting the requirement of preorder
			
			//WRONG: without check if null. the popped element might be null node, and when accessing null.right would throw null pointer exception
			
			if( currentNode.right != null ) {
				stack.add( currentNode.right );
			}
			
			if( currentNode.left != null ) {
				stack.add( currentNode.left );
			}
		}
		
		
		
		return preorderList;
	}

}


