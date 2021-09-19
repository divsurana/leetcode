/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class InorderTraversalWithParent_10_11 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<>();
		TreeNode prev = null, curr = root;
		while (curr != null) {
			TreeNode next;
			if (curr.parent == prev) {
				// prev is a parent of curr, meaning curr is a new node.
				if (curr.left != null) {
					next = curr.left;
				} else {
					traversal.add(curr.val);
					// Done with left, so go up if right is empty else go right.
					next = curr.right == null ? curr.parent : curr.right;
				}
			} else if (curr.left == prev) {
				// prev is the left child of current, meaning done with left
				// subtree.
				traversal.add(curr.val);
				// Done with left, so go up if right is empty else go right.
				next = curr.right == null ? curr.parent : curr.right;
			} else {
				// prev is the right child of current, meaning we are done with
				// both the subtrees, so go up.
				next = curr.parent;
			}
			prev = curr;
			curr = next;

		}
		return traversal;

	}

	// reusing computeSuccessor from Problem 10.10
	public List<Integer> inorderTraversal_reuse(TreeNode root) {
		List<Integer> traversal = new ArrayList<>();
		TreeNode node = root;
		while (node != null && node.left != null) {
			node = node.left;
		}

		do {
			traversal.add(node.val);
			node = computeSuccessor(node);
		} while (node != null);

		return traversal;

	}

	private static TreeNode computeSuccessor(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode successor = null;
		if (node.right == null) {
			// successor one of the ancestors
			successor = node;
			while (successor.parent != null && successor.parent.right == successor) {
				successor = successor.parent;
			}
			successor = successor.parent;
		} else {
			// successor is in the right subtree
			successor = node.right;
			while (successor.left != null) {
				successor = successor.left;
			}
		}
		return successor;
	}

	public static void main(String[] args) {
		InorderTraversalWithParent_10_11 traversal = new InorderTraversalWithParent_10_11();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.parent = root;
		root.right = new TreeNode(2);
		root.right.parent = root;
		root.left.left = new TreeNode(3);
		root.left.left.parent = root.left;
		root.left.right = new TreeNode(4);
		root.left.right.parent = root.left;
		root.left.right.right = new TreeNode(5);
		root.left.right.right.parent = root.left.right;

		List<Integer> output = traversal.inorderTraversal(root);
		System.out.println(Arrays.toString(output.toArray()));
		if (output.equals(Arrays.asList(new Integer[] { 3, 1, 4, 5, 0, 2 }))) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}

		output = traversal.inorderTraversal_reuse(root);
		System.out.println(Arrays.toString(output.toArray()));
		if (output.equals(Arrays.asList(new Integer[] { 3, 1, 4, 5, 0, 2 }))) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}

		root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.parent = root;
		root.left.left = new TreeNode(3);
		root.left.left.parent = root.left;
		output = traversal.inorderTraversal(root);
		System.out.println(Arrays.toString(output.toArray()));
		if (output.equals(Arrays.asList(new Integer[] { 3, 1, 0 }))) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}

		output = traversal.inorderTraversal_reuse(root);
		System.out.println(Arrays.toString(output.toArray()));
		if (output.equals(Arrays.asList(new Integer[] { 3, 1, 0 }))) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}
	}

}
