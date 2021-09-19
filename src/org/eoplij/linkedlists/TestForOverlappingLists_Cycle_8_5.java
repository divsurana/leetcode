/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class TestForOverlappingLists_Cycle_8_5 {

	public static ListNode overlappingLists(ListNode L1, ListNode L2) {
		// Store the start of cycle if any.
		ListNode root1 = TestForCyclicity_8_3.detectCycle_v2(L1);
		ListNode root2 = TestForCyclicity_8_3.detectCycle_v2(L2);
		if (root1 == null && root2 == null) {
			// Both lists don’t have cycles.
			return TestForOverlappingLists_CycleFree_8_4.getIntersectionNode_v2(L1, L2);
		} else if (root1 != null && root2 == null || root1 == null && root2 != null) {
			// One list has cycle, and one list has no cycle.
			return null;
		}
		// Both lists have cycles.
		ListNode temp = root2;
		do {
			temp = temp.next;
		} while (temp != root1 && temp != root2);
		// LI and L2 do not end in the same cycle.
		if (temp != root1) {
			return null; // Cycles are disjoint.
		}
		// LI and L2 end in the same cycle, locate the overlapping node if they
		// first overlap before cycle starts.
		int stemlLength = distance(L1, root1), stem2Length = distance(L2, root2);
		if (stemlLength > stem2Length) {
			L1 = TestForOverlappingLists_CycleFree_8_4.advanceList(L1, stemlLength - stem2Length);
		} else {
			L2 = TestForOverlappingLists_CycleFree_8_4.advanceList(L2, stem2Length - stemlLength);
		}
		while (L1 != L2 && L1 != root1 && L2 != root2) {
			L1 = L1.next;
			L2 = L2.next;
		}
		// If LI == L2 before reaching rootl, it means the overlap first occurs
		// before the cycle starts; otherwise , the first overlapping node is
		// not
		// unique, so we can return any node on the cycle.
		return L1 == L2 ? L1 : root1;
	}

	// Calculates the distance between a and b.
	private static int distance(ListNode a, ListNode b) {
		int dis = 0;
		while (a != b) {
			a = a.next;
			++dis;
		}
		return dis;
	}

}
