/**
 * 
 */
package org.leetcode.linkedlist.medium.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class _1019_1 {
	List<Integer> list = new LinkedList<>();

	public int[] nextLargerNodes(ListNode head) {
		helper(head);
		int[] result = new int[list.size()];
		int i = 0;
		for (int val : list)
			result[i++] = val;
		return result;
	}

	private void helper(ListNode head) {
		ListNode node = head;
		while (node != null && node.val <= head.val) {
			node = node.next;
		}
		if (node != null)
			list.add(node.val);
		else
			list.add(0);
		if (head.next != null)
			helper(head.next);
	}
}
