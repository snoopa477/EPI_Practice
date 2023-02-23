package c15_BinarySearchTrees.p11_TestIfThreeBstNodesAreTotallyOrdered;

import static java.lang.System.out;

public class _1511_TestIfThreeBstNodesAreTotallyOrdered {

	public static boolean pairlncludesAncestorAndDescendantOfM(BSTNode<Integer> possibleAncOrDesc0,
			BSTNode<Integer> possibleAncOrDescl, BSTNode<Integer> middle) {
		BSTNode<Integer> search0 = possibleAncOrDesc0, searchl = possibleAncOrDescl;
// Perform interleaved searching from possibleAncOrDesc0 and
// possibleAncOrDescl for middle.
		while (search0 != possibleAncOrDescl && search0 != middle && searchl != possibleAncOrDesc0 && searchl != middle
				&& (search0 != null || searchl != null)) {
			if (search0 != null) {
				search0 = search0.data > middle.data ? search0.left : search0.right;
			}
			if (searchl != null) {

				searchl = searchl.data > middle.data ? searchl.left : searchl.right;

			}

		}
// If both searches were unsuccessful , or we got from possibleAncOrDescl
// to possibleAncOrDescl without seeing middle, or from possibleAncOrDescl
// to possibleAncOrDesc0 without seeing middle, middle cannot lie between
// possibleAncOrDesc0 and possibleAncOrDescl .
		if (search0 == possibleAncOrDescl || searchl == possibleAncOrDesc0
				|| (search0 != middle && searchl != middle)) {
			return false;
		}

// If we get here, we already know one of possibleAncOrDesc0 or
// possibleAncOrDescl has a path to middle. Check if middle has a path to
// possibleAncOrDescl or to possibleAncOrDesc0 .
		return search0 == middle ? searchTarget(middle, possibleAncOrDescl) : searchTarget(middle, possibleAncOrDesc0);

	}

	private static boolean searchTarget(BSTNode<Integer> from, BSTNode<Integer> target) {
		while (from != null && from != target) {
			from = from.data > target.data ? from.left : from.right;
		}
		return from == target;
	}

}
