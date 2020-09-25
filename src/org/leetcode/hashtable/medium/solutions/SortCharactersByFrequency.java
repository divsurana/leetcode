/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.AbstractMap;
import java.util.ArrayList;
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
public class SortCharactersByFrequency {
	public String frequencySort_v1(String s) {
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
			for (int i = 0; i < frequency.get(c); i++) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public String frequencySort_v2(String s) {
		Map<Character, Integer> frequency = new HashMap<>();

		for (char c : s.toCharArray()) {
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);
		}

		List<Character> list = new LinkedList<>(frequency.keySet());
		// Defined Custom Comparator here
		Collections.sort(list, (c1, c2) -> frequency.get(c2).compareTo(frequency.get(c1)));

		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			for (int i = 0; i < frequency.get(c); i++) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public String frequencySort_v3(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
		StringBuffer buffer = new StringBuffer();

		for (Map.Entry<Character, Integer> entry : list) {
			for (int i = entry.getValue(); i > 0; i--) {
				buffer.append(entry.getKey());
			}
		}

		return buffer.toString();
	}

	public String frequencySort_v4(String s) {
		if (s == null || s.length() < 3) {
			return s;
		}
		int[] freq = new int[123];
		for (char c : s.toCharArray()) {
			freq[c]++;
		}

		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(s.length(),
				(e1, e2) -> -e1.getValue().compareTo(e2.getValue()));

		for (int i = 0; i < 123; i++) {
			int f = freq[i];
			if (f > 0) {
				// queue.offer(Map.entry((char) i, f)); For Java 9
				queue.offer(new AbstractMap.SimpleEntry<>((char) i, f));
			}
		}

		StringBuffer buffer = new StringBuffer();
		while (!queue.isEmpty()) {
			Map.Entry<Character, Integer> entry = queue.poll();
			for (int i = entry.getValue(); i > 0; i--) {
				buffer.append(entry.getKey());
			}
		}

		return buffer.toString();
	}
}
