/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class TestForCyclicity_8_3 {
	public ListNode detectCycle_v1(ListNode head) {
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				// There is a cycle, so now let’s calculate the cycle length.
				int cycleLen = 0;
				do {
					++cycleLen;
					fast = fast.next;
				} while (slow != fast);

				// Finds the start of the cycle.
				ListNode cycleIter = head;
				// cycleIter pointer advances cycleLen first.
				while (cycleLen-- > 0) {
					cycleIter = cycleIter.next;
				}

				ListNode iter = head;
				// Both iterators advance in tandem.
				while (iter != cycleIter) {
					iter = iter.next;
					cycleIter = cycleIter.next;
				}

				return iter; // iter is the start of cycle.
			}
		}

		return null; // no cycle.
	}

	public static ListNode detectCycle_v2(ListNode head) {
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				// Using Floyd's cycle detection algorithm A+B=kN (A = slow
				// distance, B = fast distance, N = length of loop)
				slow = head;

				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}

				return slow;
			}
		}

		return null; // no cycle.
	}

	// Variant
	public boolean hasCycle(ListNode head) {
		boolean hasCycle = false;
		ListNode fast = head;
		while (fast != null && fast.next != null && !hasCycle) {
			head = head.next;
			fast = fast.next.next;
			hasCycle = head == fast;
		}
		return hasCycle;
	}
}
