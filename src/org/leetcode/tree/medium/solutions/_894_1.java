/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.LinkedList;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _894_1 {
	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> fbt = new LinkedList<>();
		TreeNode root = new TreeNode(0);
		if (N == 1)
			fbt.add(root);
		else if (N == 3) {
			root.left = new TreeNode(0);
			root.right = new TreeNode(0);
			fbt.add(root);
		} else {
			for (int i = 1; i <= N - 2; i += 2) {
				List<TreeNode> leftChildren = allPossibleFBT(i);
				List<TreeNode> rightChildren = allPossibleFBT(N - 1 - i);
				for (TreeNode left : leftChildren) {
					for (TreeNode right : rightChildren) {
						root.left = left;
						root.right = right;
						fbt.add(root);
						root = new TreeNode(0);
					}
				}
			}
		}

		return fbt;
	}
}