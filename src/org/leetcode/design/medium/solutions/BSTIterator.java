/**
 * 
 */
package org.leetcode.design.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
class BSTIterator {
	Queue<Integer> queue;

	public BSTIterator(TreeNode root) {
		this.queue = new LinkedList<>();
		this.inOrder(root);
	}

	private void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		this.queue.offer(node.val);
		inOrder(node.right);
	}

	/** @return the next smallest number */
	public int next() {
		return this.queue.poll();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return this.queue.iterator().hasNext();
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */