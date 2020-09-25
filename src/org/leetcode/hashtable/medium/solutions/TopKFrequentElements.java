/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author divyesh_surana
 *
 */
public class TopKFrequentElements {
	// Used map and list
	public List<Integer> topKFrequent_v1(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();

		for (int i : nums) {
			frequency.put(i, frequency.getOrDefault(i, 0) + 1);
		}

		List<Integer> list = new LinkedList<>(frequency.keySet());
		Collections.sort(list, (i1, i2) -> frequency.get(i2).compareTo(frequency.get(i1)));

		return list.subList(0, k);
	}

	// Used map and priorityqueue
	public int[] topKFrequent_v2(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int num : nums) {
			frequency.put(num, frequency.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(frequency.size(),
				(e1, e2) -> -e1.getValue().compareTo(e2.getValue()));
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			queue.offer(entry);
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll().getKey();
		}

		return result;
	}

	// Used map.compute and priorityqueue to make the solution faster
	public int[] topKFrequent_v3(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int num : nums) {
			frequency.compute(num, (key, value) -> value == null ? 1 : value + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(frequency.size(),
				(e1, e2) -> -e1.getValue().compareTo(e2.getValue()));
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			queue.offer(entry);
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll().getKey();
		}

		return result;
	}

	// Use minHeap instead and eject lowest element whenever heap reaches
	// capacity to make the algo run in O(NlogK) instead of O(NlogN)
	public int[] topKFrequent_v4(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int num : nums) {
			frequency.compute(num, (key, value) -> value == null ? 1 : value + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k,
				(e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			if (queue.size() == k) {
				if (entry.getValue() > queue.peek().getValue()) {
					queue.poll();
					queue.offer(entry);
				}
			} else {
				queue.offer(entry);
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll().getKey();
		}

		return result;
	}
}
