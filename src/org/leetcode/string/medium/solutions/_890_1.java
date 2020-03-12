/**
 * 
 */
package org.leetcode.string.medium.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author divyesh_surana
 *
 */
public class _890_1 {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> matches = new ArrayList<>();
		Map<Character, Character> mapping = new HashMap<>();

		for (String word : words) {
			mapping.clear();
			boolean match = true;

			for (int i = 0; i < Math.min(word.length(), pattern.length()); i++) {
				char p = pattern.charAt(i);
				char c = word.charAt(i);
				if (mapping.containsKey(p)) {
					if (mapping.get(p) != c) {
						match = false;
						break;
					}
				} else {
					if (mapping.containsValue(c)) {
						match = false;
						break;
					}
					mapping.put(p, c);
				}
			}

			if (match)
				matches.add(word);
		}

		return matches;
	}
}
