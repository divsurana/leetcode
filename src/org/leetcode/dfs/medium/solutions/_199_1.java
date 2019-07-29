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
public class _199_1 {
	private Map<Integer, Integer> values = new HashMap<Integer, Integer>();

	public List<Integer> rightSideView(TreeNode root) {
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
}
