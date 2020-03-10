/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class _797_1 {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		return dfs(graph, 0, graph.length - 1);
	}

	private List<List<Integer>> dfs(int[][] graph, int start, int end) {
		List<List<Integer>> paths = new ArrayList<>();
		if (end == -1) {
			return null;
		}
		if (start == end) {
			paths.add(new ArrayList<Integer>(Arrays.asList(end)));
			return paths;
		}
		for (int i = 0; i < graph[start].length; i++) {
			List<List<Integer>> intPaths = dfs(graph, graph[start][i], end);
			for (List<Integer> intPath : intPaths) {
				intPath.add(0, start);
				paths.add(intPath);
			}

		}
		return paths;
	}
}
