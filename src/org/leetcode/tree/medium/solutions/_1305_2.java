/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.ArrayList;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1305_2 {
	// Sorting by comparing elements and incrementing counter of each list as they
	// are already sorted.
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> inorder1 = new ArrayList<Integer>();
		if (root1 != null)
			inorder(root1, inorder1);
		List<Integer> inorder2 = new ArrayList<Integer>();
		if (root2 != null)
			inorder(root2, inorder2);

		int i = 0, j = 0;
		List<Integer> inorder = new ArrayList<>();

		while (i < inorder1.size() && j < inorder2.size()) {
			if (inorder1.get(i) < inorder2.get(j)) {
				inorder.add(inorder1.get(i));
				i++;
			} else {
				inorder.add(inorder2.get(j));
				j++;
			}
		}
		inorder.addAll(inorder1.subList(i, inorder1.size()));
		inorder.addAll(inorder2.subList(j, inorder2.size()));
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
