/**
 * 
 */
package org.eoplij.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class MakingWiredConnections_19_6 {
	public static class GraphVertex {
		public int d = -1;
		public List<GraphVertex> edges = new ArrayList<>();
	}

	public static boolean isPossible(GraphVertex graph) {
		boolean isPossible = true;
		Set<GraphVertex>[] pairs = new Set[] { new HashSet<>(), new HashSet<>() };
		Queue<GraphVertex> queue = new LinkedList<>();
		queue.offer(graph);

		for (int distance = 0; isPossible && !queue.isEmpty(); distance++) {
			int idx = distance % 2;
			int opp = (distance + 1) % 2;
			int size = queue.size();
			while (size-- > 0) {
				GraphVertex vertex = queue.poll();
				if (pairs[opp].contains(vertex)) {
					isPossible = false; // Found the vertex on the opposite side
				} else if (!pairs[idx].contains(vertex)) {
					pairs[idx].add(vertex);
					for (GraphVertex neighbor : vertex.edges) {
						queue.offer(neighbor);
					}
				}
			}
		}
		return isPossible;
	}

	// dfs solution from leetcode
	public boolean isBipartite_dfs(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) { // This graph might be a disconnected
										// graph. So check each unvisited node.
			if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
				return false;
			}
		}
		return true;
	}

	public boolean validColor(int[][] graph, int[] colors, int color, int node) {
		if (colors[node] != 0) {
			return colors[node] == color;
		}
		colors[node] = color;
		for (int next : graph[node]) {
			if (!validColor(graph, colors, -color, next)) {
				return false;
			}
		}
		return true;
	}

	// bfs solution from leetcode
	public boolean isBipartite_bfs(int[][] graph) {
		int len = graph.length;
		int[] colors = new int[len];

		for (int i = 0; i < len; i++) {
			if (colors[i] != 0) {
				continue;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			colors[i] = 1; // Blue: 1; Red: -1.

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph[cur]) {
					if (colors[next] == 0) { // If this node hasn't been
												// colored;
						colors[next] = -colors[cur]; // Color it with a
														// different color;
						queue.offer(next);
					} else if (colors[next] != -colors[cur]) { // If it is
																// colored and
																// its color is
																// different,
																// return false;
						return false;
					}
				}
			}
		}

		return true;
	}
}
