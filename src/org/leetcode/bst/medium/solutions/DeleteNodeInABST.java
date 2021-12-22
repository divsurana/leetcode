/**
 * 
 */
package org.leetcode.bst.medium.solutions;

import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class DeleteNodeInABST {

	// Recursive solution
	public TreeNode deleteNode_v1(TreeNode root, int key) {
		if (root != null) {
			if (root.val > key) {
				root.left = deleteNode_v1(root.left, key);
			} else if (root.val < key) {
				root.right = deleteNode_v1(root.right, key);
			} else {
				TreeNode child = root.right, parent = null;
				if (child != null) {
					while (child.left != null) {
						parent = child;
						child = child.left;
					}
					if (parent != null) {
						parent.left = child.right;
						child.right = root.right;
					}
					child.left = root.left;
					root = child;
				} else {
					root = root.left;
				}
			}
		}
		return root;
	}

	// Iterative solution but didn't use the binary search property
	public TreeNode deleteNode_v2(TreeNode root, int key) {
		if (root != null) {

			if (root.val == key) {
				if (root.left != null) {
					TreeNode nodeLeft = root.left;
					TreeNode nodeRight = root.right;
					root = root.left;
					while (nodeLeft.right != null) {
						nodeLeft = nodeLeft.right;
					}
					nodeLeft.right = nodeRight;
				} else {
					root = root.right;
				}
			} else {
				Stack<TreeNode> stack = new Stack<>();
				stack.add(root);
				while (!stack.isEmpty()) {
					TreeNode node = stack.pop();
					TreeNode left = node.left;
					TreeNode right = node.right;

					if (left != null && left.val == key) {
						if (left.left != null) {
							node.left = left.left;
							node = node.left;
							if (node.right != null) {
								TreeNode rightChild = node.right;
								while (rightChild.right != null) {
									rightChild = rightChild.right;
								}
								rightChild.right = left.right;
							} else {
								node.right = left.right;
							}
						} else {
							node.left = left.right;
						}
						stack.clear();
					} else if (right != null && right.val == key) {
						if (right.left != null) {
							node.right = right.left;
							node = node.right;
							if (node.right != null) {
								TreeNode rightChild = node.right;
								while (rightChild.right != null) {
									rightChild = rightChild.right;
								}
								rightChild.right = right.right;
							} else {
								node.right = right.right;
							}
						} else {
							node.right = right.right;
						}
						stack.clear();
					} else if (node != null) {

						if (node.left != null) {
							stack.push(left);
						}
						if (node.right != null) {
							stack.push(right);
						}

					}

				}
			}

		}

		return root;
	}
}
