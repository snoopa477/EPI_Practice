package c10_BinaryTrees.p06_FindARootToLeafPathWithSpecifiedSum;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
public class Test_FindARootToLeafPathWithSpecifiedSum {

	public static void main(String[] args) {
		
		MyBinaryTreeNode<Integer> root = MyBinaryTreeNode.makeFigure10_01Tree();
		
		int[] inputs = {619, 591, 901, 1365, 580, 619,
						620, 592, 902, 1366, 579, 618};
		
		
		for( int input: inputs ) {
			out.println("input " + input + " has has sumPath in tree_10.01? " + FindARootToLeafPathWithSpecifiedSum.hasRootToLeafPathWithSpecifiedSum(root, input));
		}
	}
}


