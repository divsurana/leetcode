/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class BinaryTreeRightSideView {
	private Map<Integer, Integer> values = new HashMap<>();

	public List<Integer> rightSideView_v1(TreeNode root) {
		getView(root, 0);
		List<Integer> view = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) {
			view.add(values.get(i));
		}
		return view;
	}

	private void getView(TreeNode cur, int depth) {
		if (cur == null) {
			return;
		}

		getView(cur.left, depth + 1);
		values.put(depth, cur.val);
		getView(cur.right, depth + 1);
	}

	public List<Integer> rightSideView_v2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

	// fastest dfs approach
	public List<Integer> rightSideView_v5(TreeNode root) {
		return helper(new ArrayList<Integer>(), root, 0);
	}

	private List<Integer> helper(List<Integer> view, TreeNode node, int depth) {
		if (node == null) {
			return view;
		}
		if (view.size() == depth) {
			view.add(node.val);
		}
		helper(view, node.right, depth + 1);
		helper(view, node.left, depth + 1);
		return view;
	}
}
