package c10_BinaryTrees.p07_ImplementAnInorderTraversalWithoutRecursion;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
import java.util.ArrayList;
import java.util.Stack;

public class ImplementAnInorderTraversalWithoutRecursion {

	public static<T> ArrayList<MyBinaryTreeNode<T>> inorderWithoutRecursion( MyBinaryTreeNode<T> root ){
		
		/*
		 REASONING: 
		 	difference between recursion stack and while stack:
		 	
		 	recursion stack:
		  	exit right null node
		  	go to recursion stack.top(), see its program counter: if f(L), print, f(R) all done, stack.top().pop()
		  	keep doing so, until program counter has not done all things yet( f(L), print, f(R))
		  	in the stack, print, and then call f(R)
		  	
		  	
		  	while stack:
		  	exist null node ( either left or right )
		  	go to while stack.top()
		  	go to stack.top().right
		  	print/ store stack.top()
		  	stack.top().pop()
		  	
		  	GUESS: 
		  	recursion stack keep records of f(R), so later on it has to clean those stacks which has f(L), print, f(R), until
		  	it meets a stack which just called f(L)
		  	
		  	while stack doesn't record f(R), so later on it can directly go to stack that just called f(L), without the need to wade 
		  	through stacks which has f(L), print, f(R)
		  
		 */
		
		MyBinaryTreeNode<T> currentNode = root;
		
		//Stack<MyBinaryTreeNode<T>> quasiRecursionStack = new Stack<>();
		//PURPOSE: since it doesn't record whether print nor func right, have to use up the stack immediately
		Stack<MyBinaryTreeNode<T>> stackOfFuncLeft = new Stack<>();
		ArrayList<MyBinaryTreeNode<T>> inorderResult = new ArrayList<>();
		
		stackOfFuncLeft.push(root);
		//DETAIL: we don't know if left is null or not
		currentNode = root.left;
		
		//PURPOSE: as long as there exist elements in stack, keep doing
		//PARTIALLY RIGHT: nuance: it gets wrong when left subtree of root completes -> no stack elements yet currentNode == root.right. We need to take this into consideration
		//while( stackOfFuncLeft.empty() == false ) {
		while( stackOfFuncLeft.empty() == false || currentNode != null) {
			
			//CASE1: non null node
			if( currentNode != null ) {
				stackOfFuncLeft.push( currentNode );
				
				//next stage
				currentNode = currentNode.left;
			}
			//CASE2: null node
			else {
				
				//THINK_FURTHER: compared to recursion stack, it skips the stacks that completes f(L), print, f(R); simply go to stack that completes f(L)
				currentNode = stackOfFuncLeft.pop();
				//PURPOSE: use up so we don't keep record of print nor f(R)
				//equivalent to print
				inorderResult.add( currentNode );
				
				currentNode = currentNode.right;
			}
		}
		
		
		return inorderResult;
	}
	
	
	
}


