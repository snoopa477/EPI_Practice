package c10_BinaryTrees.p13_ReconstructABinaryTreeFromAPreorderTraversalWithMarkers;
import static java.lang.System.out;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.MyBinaryTreeNode;
public class Test_ReconstructABinaryTreeFromAPreorderTraversalWithMarkers {

	public static void main(String[] args) {
		
		String v = null;
		
		List<String> preorderList = Stream
			.of("A", "B", "C", "D", null, null, "E", null, null, "F", null, "G", "H", null, null, null, "I"
				, "J", null, "k", "L", null, "M", null, null, "N", null, null, "O", null, "P", null, null)
			.collect(Collectors.toList());
		
		MyBinaryTreeNode<String> tree = ReconstructABinaryTreeFromAPreorderTraversalWithMarkers.construct(preorderList);
		
		MyBinaryTreeNode.printInLevel( tree );
		
		
	}

}


