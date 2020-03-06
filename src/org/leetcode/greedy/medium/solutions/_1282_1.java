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
public class _1282_1 {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
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
}
