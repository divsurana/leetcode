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
public class _451_2 {
	public String frequencySort(String s) {
		Map<Character, Integer> frequency = new HashMap<>();

		for (char c : s.toCharArray()) {
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);
		}

		List<Character> list = new LinkedList<>(frequency.keySet());
		// Defined Custom Comparator here
		Collections.sort(list, (c1, c2) -> frequency.get(c2).compareTo(frequency.get(c1)));

		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			for (int i = 0; i < frequency.get(c); i++)
				sb.append(c);
		}

		return sb.toString();
	}
}
