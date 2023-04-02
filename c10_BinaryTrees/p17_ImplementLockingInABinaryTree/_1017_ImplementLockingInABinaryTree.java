package c10_BinaryTrees.p17_ImplementLockingInABinaryTree;

import static java.lang.System.out;

public class _1017_ImplementLockingInABinaryTree {

	public static class BinaryTree {
		private BinaryTree left, right, parent;
		private boolean locked = false;
		private int numLockedDescendants = 0;

		public boolean isLocked() {
			return locked;
		}

		
		
		public boolean lock() {
			// file cannot lock if any of this node's descendants are locked.
			if (numLockedDescendants > 0 || locked) {

				return false;

			}
			// We cannot lock if any of this node's ancestors are locked.
			for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
				if (iter.locked) {
					return false;
				}
			}
			// Lock this node and increments all its ancestors's descendant lock
			// counts.
			locked = true;
			for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
				++iter.numLockedDescendants;
			}
			return true;

		}
		
		
		
		public void unlock() {
			if (locked) {
				// Unlocks itself and decrements its ancestors's descendant lock counts.
				locked = false;
				for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
					--iter.numLockedDescendants;
				}
			}
		}

	}
}
