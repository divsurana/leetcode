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
public class _692_1 {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequency = new HashMap<>();

		for (String word : words) {
			frequency.put(word, frequency.getOrDefault(word, 0) + 1);
		}

		List<String> list = new LinkedList<>(frequency.keySet());
		// Sort on frequency and subsort alphabetically
		Collections.sort(list, (s1, s2) -> {
			int i = frequency.get(s2).compareTo(frequency.get(s1));
			return i == 0 ? s1.compareTo(s2) : i;
		});

		return list.subList(0, k);
	}
}
