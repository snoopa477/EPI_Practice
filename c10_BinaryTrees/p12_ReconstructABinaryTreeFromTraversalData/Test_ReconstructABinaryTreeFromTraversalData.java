package c10_BinaryTrees.p12_ReconstructABinaryTreeFromTraversalData;
import static java.lang.System.out;

import util.MyBinaryTreeNode;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class Test_ReconstructABinaryTreeFromTraversalData {

	public static void main(String[] args) {
		
		
		List<String> preorderList = Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P").collect(Collectors.toList());
		List<String> inorderList =  Stream.of("D", "C", "E", "B", "F", "H", "G", "A", "J", "L", "M", "K", "N", "I", "O", "P").collect(Collectors.toList());
		
		//ReconstructABinaryTreeFromTraversalData.IS_DEBUG = true;
		
		MyBinaryTreeNode<String> tree = ReconstructABinaryTreeFromTraversalData.construct(preorderList, inorderList);
		
		MyBinaryTreeNode.printInLevel(tree);
		
	}

}


