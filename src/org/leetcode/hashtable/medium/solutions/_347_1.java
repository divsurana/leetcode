/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author divyesh_surana
 *
 */
public class _347_1 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();

		for (int i : nums) {
			frequency.put(i, frequency.getOrDefault(i, 0) + 1);
		}

		List<Integer> list = new LinkedList<>(frequency.keySet());
		Collections.sort(list, (i1, i2) -> frequency.get(i2).compareTo(frequency.get(i1)));

		return list.subList(0, k);
	}
}
