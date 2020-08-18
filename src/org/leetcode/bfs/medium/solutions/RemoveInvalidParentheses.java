/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		boolean found = false;

		visited.add(s);
		queue.offer(s);

		while (!queue.isEmpty()) {
			String pattern = queue.poll();

			if (isValid(pattern)) {
				result.add(pattern);
				found = true;
			}

			// if a valid pattern has been found, don't create any more shorter
			// patterns and just validate the same length patterns already
			// present in the queue
			if (found) {
				continue;
			}

			for (int i = 0; i < pattern.length(); i++) {
				char c = pattern.charAt(i);
				if ((c == '(' || c == ')') && (i == 0 || c != s.charAt(i - 1))) {
					String newPattern = pattern.substring(0, i) + pattern.substring(i + 1, pattern.length());
					if (!visited.contains(newPattern)) {
						visited.add(newPattern);
						queue.offer(newPattern);
					}
				}
			}
		}

		return result;
	}

	private boolean isValid(String s) {
		int counter = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				counter++;
			} else if (c == ')') {
				if (counter == 0) {
					return false;
				}
				counter--;
			}
		}
		return counter == 0;
	}
}
