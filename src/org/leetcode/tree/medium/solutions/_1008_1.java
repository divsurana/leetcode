/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.Arrays;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1008_1 {
	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder.length == 0)
			return null;
		TreeNode root = new TreeNode(preorder[0]);
		if (preorder.length == 1)
			return root;
		int i = 1;
		while (i < preorder.length && preorder[i] < preorder[0]) {
			i++;
		}
		root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i));
		root.right = bstFromPreorder(Arrays.copyOfRange(preorder, i, preorder.length));
		return root;
	}
}
