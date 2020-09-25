/**
 * 
 */
package org.leetcode.greedy.medium.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author divyesh_surana
 *
 */
public class GroupThePeople {
	// This one is faster
	public List<List<Integer>> groupThePeople_v1(int[] groupSizes) {
		List<List<Integer>> output = new ArrayList<>();
		Map<Integer, List<Integer>> mapping = new HashMap<>();

		for (int i = 0; i < groupSizes.length; i++) {
			int groupSize = groupSizes[i];

			List<Integer> ids = mapping.getOrDefault(groupSize, new ArrayList<>());
			if (ids.size() == groupSize) {
				output.add(ids);
				ids = new ArrayList<>();
			}
			ids.add(i);
			mapping.put(groupSize, ids);
		}

		for (int groupSize : mapping.keySet()) {
			output.add(mapping.get(groupSize));
		}

		return output;
	}

	public List<List<Integer>> groupThePeople_v2(int[] groupSizes) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < groupSizes.length; i++) {
			map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int size : map.keySet()) {
			for (int i = 0; i < map.get(size).size(); i += size) {
				result.add(map.get(size).subList(i, i + size));
			}
		}

		return result;
	}

	// Approaches to do it in O(n) and not iterate again through the map

	public List<List<Integer>> groupThePeople_v3(int[] groupSizes) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> group = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
			group.add(i);
			if (group.size() == groupSizes[i]) {
				result.add(group);
				map.put(groupSizes[i], new ArrayList<Integer>());
			}
		}

		return result;
	}

	public List<List<Integer>> groupThePeople_v4(int[] groupSizes) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> group = map.getOrDefault(groupSizes[i], new ArrayList<>());
			group.add(i);
			if (group.size() == groupSizes[i]) {
				result.add(group);
				map.put(groupSizes[i], new ArrayList<Integer>());
			} else {
				map.put(groupSizes[i], group);
			}
		}

		return result;
	}
}
