package util;
import static java.lang.System.out;

import java.util.Optional;
public class MyBinaryTreeNodeWithParent2<T> extends MyBinaryTreeNode<T> {
	
	public MyBinaryTreeNodeWithParent2<T> parent;

	public MyBinaryTreeNodeWithParent2(T data) {
		super(data);
	}
	
	
	public MyBinaryTreeNodeWithParent2(T data, char tag) {
		//DETAIL: WRONG if super is not called. here's the message: Implicit super constructor MyBinaryTreeNode<T>() is undefined. Must explicitly invoke another constructor
		super(data, tag);
	}

	
	
	public MyBinaryTreeNodeWithParent2(T data, MyBinaryTreeNodeWithParent2<T> left, MyBinaryTreeNodeWithParent2<T> right) {
		super(data, left, right);
	}
	
	
	
	public MyBinaryTreeNodeWithParent2(T data, char tag, MyBinaryTreeNodeWithParent2<T> left, MyBinaryTreeNodeWithParent2<T> right) {
		super(data, tag, left, right);
	}
	
	public MyBinaryTreeNodeWithParent2(T data, char tag, MyBinaryTreeNodeWithParent2<T> left, MyBinaryTreeNodeWithParent2<T> right, MyBinaryTreeNodeWithParent2<T> parent ) {
		super(data, tag, left, right);
		this.parent = parent;
	}
	
	
	@Override
	public String toString() {
		
		//WHY and HOW?
		MyBinaryTreeNodeWithParent2<T> leftNode = Optional.ofNullable(this.left).orElse(null);
		MyBinaryTreeNodeWithParent2<T> rightNode = Optional.ofNullable(this.right).orElse(null);
		
		String str = String.format("(Value, L, R)=%4s, %4s, %4s\n", 
				strNode(this)
				, strNode( leftNode )
				, strNode( rightNode));
		
		return str;
		
	}

}


