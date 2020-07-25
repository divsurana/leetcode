/**
 * 
 */
package org.leetcode.linkedlist.easy.solutions;

import java.util.Stack;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode node = head;

		while (node != null) {
			stack.push(node);
			node = node.next;
		}

		node = stack.isEmpty() ? null : stack.peek();
		while (!stack.isEmpty()) {
			ListNode next = stack.pop();
			next.next = stack.isEmpty() ? null : stack.peek();
		}

		return node;
	}
}
