/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class FormLinkedListFromLeaves_10_14 {
	public static List<Integer> leavesList(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		traverse(root, list);
		return list;
	}

	private static void traverse(TreeNode root, List<Integer> list) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				list.add(root.val);
			} else {
				traverse(root.left, list);
				traverse(root.right, list);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = ConstructBinaryTreeFromPreorderWithMarkers_10_13.generateTree();
		String output = Arrays.toString(leavesList(root).toArray());
		System.out.println(output);
		if (output.equals("[3, 5, 9]")) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}
	}
}
