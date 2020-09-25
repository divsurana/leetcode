/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author divyesh_surana
 *
 */
public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget_v1(int[][] graph) {
		return dfs(graph, 0, graph.length - 1);
	}

	private List<List<Integer>> dfs(int[][] graph, int start, int end) {
		List<List<Integer>> paths = new ArrayList<>();
		if (end == -1) {
			return null;
		}
		if (start == end) {
			paths.add(new ArrayList<>(Arrays.asList(end)));
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

	public List<List<Integer>> allPathsSourceTarget_v2(int[][] graph) {
		return helper(graph, 0);
	}

	private List<List<Integer>> helper(int[][] graph, int node) {
		List<List<Integer>> paths = new ArrayList<>();
		if (node == graph.length - 1) {
			paths.add(Arrays.asList(node));
		} else {
			for (int child : graph[node]) {
				for (List<Integer> childPath : helper(graph, child)) {
					List<Integer> path = new ArrayList<>();
					path.add(node);
					path.addAll(childPath);
					paths.add(path);
				}
			}
		}
		return paths;
	}

	// Using map for memoization to store paths of nodes already visited and
	// make the algorithm faster
	public List<List<Integer>> allPathsSourceTarget_v3(int[][] graph) {
		return helper(graph, 0, new HashMap<Integer, List<List<Integer>>>());
	}

	private List<List<Integer>> helper(int[][] graph, int node, Map<Integer, List<List<Integer>>> map) {
		if (!map.containsKey(node)) {
			List<List<Integer>> paths = new ArrayList<>();
			if (node == graph.length - 1) {
				paths.add(Arrays.asList(node));
			} else {
				for (int child : graph[node]) {
					for (List<Integer> childPath : helper(graph, child, map)) {
						List<Integer> path = new ArrayList<>();
						path.add(node);
						path.addAll(childPath);
						paths.add(path);
					}
				}
			}
			map.put(node, paths);
		}
		return map.get(node);
	}

	// fastest backtracking dfs algorithm
	public List<List<Integer>> allPathsSourceTarget_v4(int[][] graph) {
		return helper(graph, 0, new ArrayList<List<Integer>>(), new ArrayList<>(Arrays.asList(0)));
	}

	private List<List<Integer>> helper(int[][] graph, int node, List<List<Integer>> paths, List<Integer> path) {
		if (node == graph.length - 1) {
			paths.add(new ArrayList<>(path));
		} else {
			for (int child : graph[node]) {
				path.add(child);
				helper(graph, child, paths, path);
				path.remove(path.size() - 1);
			}
		}
		return paths;
	}
}
