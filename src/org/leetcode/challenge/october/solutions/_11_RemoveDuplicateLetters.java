/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author divyeshsurana
 *
 */
public class _11_RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		int[] lastPos = new int[26];
		boolean[] added = new boolean[26];

		for (int i = 0; i < s.length(); i++) {
			lastPos[s.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!added[c - 'a']) {
				while (!deque.isEmpty() && deque.peek() > c && lastPos[deque.peek() - 'a'] > i) {
					added[deque.pop() - 'a'] = false;
				}
				deque.push(c);
				added[c - 'a'] = true;
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!deque.isEmpty()) {
			builder.append(deque.removeLast());
		}

		return builder.toString();
	}
}
