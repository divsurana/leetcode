/**
 * 
 */
package org.leetcode.common;

/**
 * Definition for a binary tree node.
 * 
 * @author divyeshsurana
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return String.valueOf(this.val);
	}
}
