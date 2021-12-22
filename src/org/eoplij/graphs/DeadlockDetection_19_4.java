/**
 * 
 */
package org.eoplij.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class DeadlockDetection_19_4 {

	// Using topoogical sort
	public boolean canFinish_tp(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] indegree = new int[numCourses];

		for (int[] prerequisite : prerequisites) {
			int ready = prerequisite[0];
			int pre = prerequisite[1];
			if (matrix[pre][ready] == 0) {
				indegree[ready]++; // duplicate case
			}
			matrix[pre][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		return count == numCourses;
	}

	// Leetcode problem using 2 sets
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = generateGraph(prerequisites);
		Set<Integer> visited = new HashSet<>();
		Set<Integer> curr = new HashSet<>();

		for (int src : adjList.keySet()) {
			if (!visited.contains(src)) {
				if (hasCycle(src, adjList, visited, curr)) {
					return false;
				}
			}
		}

		return true;

	}

	/**
	 * @param prerequisites
	 * @return
	 */
	private Map<Integer, List<Integer>> generateGraph(int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int[] prereq : prerequisites) {
			int src = prereq[0];
			adjList.put(src, adjList.getOrDefault(src, new ArrayList<>()));
			adjList.get(src).add(prereq[1]);
		}
		return adjList;
	}

	private boolean hasCycle(int src, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Set<Integer> curr) {
		if (!visited.contains(src) && adjList.containsKey(src)) {
			visited.add(src);
			curr.add(src);
			for (int dest : adjList.get(src)) {
				if (curr.contains(dest)) {
					return true; // Cycle detected
				}
				if (hasCycle(dest, adjList, visited, curr)) {
					return true;
				}
			}
			curr.remove(src);
		}
		return false;
	}

	// Object Oriented way of solving it, inspired by the solution from the book
	public static class GraphVertex {
		public static enum Color {
			WHITE, GRAY, BLACK
		}

		public int course;
		public List<GraphVertex> edges;
		public Color color;

		GraphVertex(int course) {
			this.course = course;
			this.edges = new ArrayList<>();
			this.color = Color.WHITE;
		}
	}

	public boolean isDeadlocked(int numCourses, int[][] prerequisites) {
		Map<Integer, GraphVertex> map = new HashMap<>();

		for (int[] prereq : prerequisites) {
			int src = prereq[0];
			int dest = prereq[1];
			GraphVertex vertex = map.getOrDefault(src, new GraphVertex(src));
			map.put(src, vertex);
			GraphVertex toVertex = map.getOrDefault(dest, new GraphVertex(dest));
			map.put(dest, toVertex);
			vertex.edges.add(toVertex);

		}

		for (GraphVertex vertex : map.values()) {
			if (vertex.color == GraphVertex.Color.WHITE && hasCycle(vertex)) {
				return false;
			}
		}

		return true;
	}

	private static boolean hasCycle(GraphVertex cur) {
		// Visiting a gray vertex means a cycle.
		if (cur.color == GraphVertex.Color.GRAY) {
			return true;
		}
		cur.color = GraphVertex.Color.GRAY; // Marks current vertex as a gray
											// one.
		// Traverse the neighbor vertices.
		for (GraphVertex next : cur.edges) {
			if (next.color != GraphVertex.Color.BLACK) {
				if (hasCycle(next)) {
					return true;
				}
			}
		}
		cur.color = GraphVertex.Color.BLACK; // Marks current vertex as black.
		return false;
	}

}
