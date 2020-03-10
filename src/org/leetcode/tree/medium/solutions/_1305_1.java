/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1305_1 {
	// Using Collections.sort
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> inorder = new ArrayList<Integer>();
		if (root1 != null)
			inorder(root1, inorder);
		if (root2 != null)
			inorder(root2, inorder);
		Collections.sort(inorder);
		return inorder;
	}

	private List<Integer> inorder(TreeNode root, List<Integer> inorder) {
		if (root.left != null)
			inorder(root.left, inorder);
		inorder.add(root.val);
		if (root.right != null)
			inorder(root.right, inorder);
		return inorder;
	}
}
