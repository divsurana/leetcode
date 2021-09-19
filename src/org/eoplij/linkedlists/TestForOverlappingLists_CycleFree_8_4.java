/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class TestForOverlappingLists_CycleFree_8_4 {

	public ListNode getIntersectionNode_v1(ListNode headA, ListNode headB) {
		int len1 = getLength(headA);
		int len2 = getLength(headB);

		if (len1 > len2) {
			headA = advanceList(headA, len1 - len2);
		} else {
			headB = advanceList(headB, len2 - len1);
		}

		while (headA != null && headB != null && headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	static ListNode advanceList(ListNode head, int steps) {
		while (steps-- > 0) {
			head = head.next;
		}
		return head;
	}

	private int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

	// Better solution without calculating the length diff
	public static ListNode getIntersectionNode_v2(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;

		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (a != b) {
			// for the end of first iteration, we just reset the pointer to the
			// head of another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}

		return a;
	}

}
