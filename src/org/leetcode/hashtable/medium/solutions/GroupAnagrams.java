/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}
}
