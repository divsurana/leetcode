/**
 * 
 */
package org.leetcode.graph.medium.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class EvaluateDivision {
	public double[] calcEquation_v1(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = buildGraph(equations, values);
		double[] answers = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String source = query.get(0);
			String destination = query.get(1);

			answers[i] = getWeight(source, destination, graph, new HashSet<>());
		}
		return answers;
	}

	private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
		Map<String, Map<String, Double>> graph = new HashMap<>();

		for (int i = 0; i < equations.size(); i++) {
			List<String> equation = equations.get(i);
			String source = equation.get(0);
			String destination = equation.get(1);
			double value = values[i];

			graph.putIfAbsent(source, new HashMap<>());
			graph.get(source).put(destination, value);
			graph.get(source).put(source, 1.0);

			graph.putIfAbsent(destination, new HashMap<>());
			graph.get(destination).put(source, 1.0 / value);
			graph.get(destination).put(destination, 1.0);
		}

		return graph;
	}

	private double getWeight(String source, String destination, Map<String, Map<String, Double>> graph,
			Set<String> visited) {

		if (!graph.containsKey(source) || !graph.containsKey(destination)) {
			return -1.0;
		}
		if (graph.get(source).containsKey(destination)) {
			return graph.get(source).get(destination);
		}

		visited.add(source);

		for (Map.Entry<String, Double> entry : graph.get(source).entrySet()) {
			if (!visited.contains(entry.getKey())) {
				double weight = getWeight(entry.getKey(), destination, graph, visited);
				if (weight != -1.0) {
					return entry.getValue() * weight;
				}
			}
		}

		return -1.0;
	}

	public double[] calcEquation_v2(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = buildGraph(equations, values);
		return calculateQueries(graph, queries);
	}

	private double[] calculateQueries(Map<String, Map<String, Double>> graph, List<List<String>> queries) {
		double[] result = new double[queries.size()];
		int index = 0;
		for (List<String> query : queries) {
			result[index] = calculateQuery(graph, query.get(0), query.get(1), new HashSet<>());
			index++;
		}
		return result;
	}

	private double calculateQuery(Map<String, Map<String, Double>> graph, String source, String destination,
			Set<String> visited) {
		double result = -1;
		if (graph.containsKey(source) && graph.containsKey(destination)) {
			if (graph.get(source).containsKey(destination)) {
				result = graph.get(source).get(destination);
			} else {
				visited.add(source);
				for (String newSource : graph.get(source).keySet()) {
					if (!visited.contains(newSource)) {
						double value = calculateQuery(graph, newSource, destination, visited);
						if (value != -1) {
							result = graph.get(source).get(newSource) * value;
							break;
						}
					}
				}
			}
		}
		return result;
	}
}
