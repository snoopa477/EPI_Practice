package c14_Sorting.p09_ImplementaFastsortingAlgorithmForLists01;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import util.ListNode;

public class _1409_ImplementaFastsortingAlgorithmForLists01 {

	public static ListNode<Integer> insertionSort(final ListNode<Integer> L) {
		ListNode<Integer> dummyHead = new ListNode<>(0, L);
		ListNode<Integer> iter = L;
// The sublist consisting of nodes up to and including iter is sorted in
// increasing order. We need to ensure that after we move to iter.next
// this property continues to hold. We do this by swapping iter.next
// with its predecessors in the list till it's in the right place.

		while (iter != null && iter.next != null) {
			if (iter.data > iter.next.data) {
				ListNode<Integer> target = iter.next, pre = dummyHead;
				while (pre.next.data < target.data) {
					pre = pre.next;
				}
				ListNode<Integer> temp = pre.next;
				pre.next = target;
				iter.next = target.next;
				target.next = temp;
			} else {
				iter = iter.next;
			}
		}
		return dummyHead.next;

	}
}
