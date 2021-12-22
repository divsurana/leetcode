package org.eoplij.graphs;
/**
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author divyeshsurana
 *
 */
public class CloneAGraph_19_5 {
	// Recursive dfs solution solved on leetcode
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		return node == null ? null : clone(node, new HashMap<Integer, Node>());
	}

	private Node clone(Node node, Map<Integer, Node> map) {
		Node clone;
		if (map.containsKey(node.val)) {
			clone = map.get(node.val);
		} else {
			clone = new Node(node.val);
			map.put(clone.val, clone);

			for (Node neighbor : node.neighbors) {
				clone.neighbors.add(clone(neighbor, map));
			}
		}
		return clone;
	}

	// Iterative bfs solution from the book
	public static class GraphVertex {
		public int label;
		public List<GraphVertex> edges;

		public GraphVertex(int label) {
			this.label = label;
			edges = new ArrayList<>();
		}
	}

	public static GraphVertex cloneGraph(GraphVertex g) {
		if (g == null) {
			return null;
		}
		Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
		Queue<GraphVertex> q = new LinkedList<>();
		q.add(g);
		vertexMap.put(g, new GraphVertex(g.label));
		while (!q.isEmpty()) {
			GraphVertex v = q.remove();
			for (GraphVertex e : v.edges) {
				// Try to copy vertex e.
				if (!vertexMap.containsKey(e)) {
					vertexMap.put(e, new GraphVertex(e.label));
					q.add(e);
				}
				// Copy edge .
				vertexMap.get(v).edges.add(vertexMap.get(e));
			}
		}
		return vertexMap.get(g);
	}

}
