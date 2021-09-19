/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.Arrays;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class ConstructBinaryTreeFromPreorderWithMarkers_10_13 {
	static int i = 0;

	public static TreeNode buildTree(Integer[] traversal) {
		return build(traversal);
	}

	private static TreeNode build(Integer[] traversal) {
		Integer val = traversal[i++];
		if (val == null) {
			return null;
		}

		TreeNode node = new TreeNode(val);
		node.left = build(traversal);
		node.right = build(traversal);

		return node;
	}

	public static TreeNode generateTree() {
		Integer[] traversal = new Integer[] { 1, 2, 3, null, null, 4, 5, null, null, null, 6, null, 7, null, 8, 9, null,
				null, null };
		return buildTree(traversal);
	}

	public static void main(String[] args) {
		Integer[] traversal = new Integer[] { 1, 2, 3, null, null, 4, 5, null, null, null, 6, null, 7, null, 8, 9, null,
				null, null };
		InorderTraversal_10_7 inorder = new InorderTraversal_10_7();
		String output = Arrays.toString(inorder.inorderTraversal(buildTree(traversal)).toArray());
		System.out.println(output);
		if (output.equals("[3, 2, 5, 4, 1, 6, 7, 9, 8]")) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}
	}
}
