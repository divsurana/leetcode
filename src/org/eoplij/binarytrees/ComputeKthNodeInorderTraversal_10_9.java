/**
 * 
 */
package org.eoplij.binarytrees;

/**
 * @author divyeshsurana
 *
 */
public class ComputeKthNodeInorderTraversal_10_9 {
	public static class TreeNode {
		int val;
		int numDescendants;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, int numDescendants) {
			this.val = val;
			this.numDescendants = numDescendants;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// iterative
	public TreeNode getKthNode_v1(TreeNode root, int k) {
		TreeNode node = root;

		while (node != null) {
			// Get the position of the node in the inorder traversal
			int pos = 1 + (node.left == null ? 0 : node.left.numDescendants + 1);
			// Node is kth element
			if (pos == k) {
				break;
			}
			// If node pos is greater than k, then the kth node should be in the
			// left subtree
			// else deduct pos from and k and search for the node in the right
			// subtree
			if (pos > k) {
				node = node.left;
			} else {
				k -= pos;
				node = node.right;
			}
		}

		return node;
	}

	// recursive
	public TreeNode getKthNode_v2(TreeNode root, int k) {
		if (root == null) {
			return root;
		}
		// Get the position of the node in the inorder traversal
		int pos = 1 + (root.left == null ? 0 : root.left.numDescendants + 1);

		// If node pos is greater than k, then the kth node should be in the
		// left subtree
		if (pos > k) {
			return getKthNode_v2(root.left, k);
		}
		// If pos is less than k, deduct pos from and k and search for the node
		// in the right subtree
		if (pos < k) {
			return getKthNode_v2(root.right, k - pos);
		}
		// Node is kth element
		return root;
	}

	public static void main(String[] args) {
		ComputeKthNodeInorderTraversal_10_9 traversal = new ComputeKthNodeInorderTraversal_10_9();
		TreeNode root = new TreeNode(0, 5);
		root.left = new TreeNode(1, 3);
		root.right = new TreeNode(2, 0);
		root.left.left = new TreeNode(3, 0);
		root.left.right = new TreeNode(4, 1);
		root.left.right.right = new TreeNode(5, 0);

		TreeNode node = traversal.getKthNode_v1(root, 4);
		if (node.equals(root.left.right.right)) {
			System.out.println("Test passed");
			System.out.println("Expected: " + root.left.right.right.val + ", Actual: " + node.val);
		} else {
			System.out.println("Test failed");
			System.out.println("Expected: " + root.left.right.right.val + ", Actual: " + node.val);
		}

		node = traversal.getKthNode_v1(root, 5);
		if (node.equals(root)) {
			System.out.println("Test passed");
			System.out.println("Expected: " + root.val + ", Actual: " + node.val);
		} else {
			System.out.println("Test failed");
			System.out.println("Expected: " + root.val + ", Actual: " + node.val);
		}

		node = traversal.getKthNode_v1(root, 1);
		if (node.equals(root.left.left)) {
			System.out.println("Test passed");
			System.out.println("Expected: " + root.left.left.val + ", Actual: " + node.val);
		} else {
			System.out.println("Test failed");
			System.out.println("Expected: " + root.left.left.val + ", Actual: " + node.val);
		}

		node = traversal.getKthNode_v1(root, 6);
		if (node.equals(root.right)) {
			System.out.println("Test passed");
			System.out.println("Expected: " + root.right.val + ", Actual: " + node.val);
		} else {
			System.out.println("Test failed");
			System.out.println("Expected: " + root.right.val + ", Actual: " + node.val);
		}
	}
}
