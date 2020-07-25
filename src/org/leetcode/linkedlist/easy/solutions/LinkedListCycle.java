/**
 * 
 */
package org.leetcode.linkedlist.easy.solutions;

import java.util.HashSet;
import java.util.Set;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();

		while (head != null) {
			if (set.contains(head)) {
				return true;
			}
			set.add(head);
			head = head.next;
		}

		return false;
	}
}
