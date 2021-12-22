/**
 * 
 */
package org.leetcode.linkedlist.medium.solutions;

/**
 * Definition for singly-linked list.
 * 
 * @author divyesh_surana
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int x, ListNode child) {
		val = x;
		next = child;
	}
}
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */