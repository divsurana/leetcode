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
public class _451_1 {
	public String frequencySort(String s) {
		Map<Character, Integer> frequency = new HashMap<>();

		for (char c : s.toCharArray()) {
			int count = frequency.containsKey(c) ? frequency.get(c) : 0;
			frequency.put(c, count + 1);
		}

		List<Character> list = new LinkedList<>(frequency.keySet());
		// Defined Custom Comparator here
		Collections.sort(list, (o1, o2) -> -frequency.get(o1).compareTo(frequency.get(o2)));

		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			for (int i = 0; i < frequency.get(c); i++)
				sb.append(c);
		}

		return sb.toString();
	}
}
