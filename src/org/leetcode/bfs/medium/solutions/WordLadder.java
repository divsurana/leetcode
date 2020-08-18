/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
			return 0;
		}
		int length = 0;
		boolean found = false;
		Set<String> words = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		for (String word : wordList) {
			words.add(word);
		}
		queue.offer(beginWord);
		visited.add(beginWord);

		while (!queue.isEmpty() && !found) {
			int n = queue.size();
			for (; n > 0 && !found; n--) {
				String word = queue.poll();
				for (int i = 0; i < word.length() && !found; i++) {
					char[] arr = word.toCharArray();
					for (int j = 0; j < 26 && !found; j++) {
						arr[i] = (char) ('a' + j);
						String newWord = String.valueOf(arr);
						if (word.equals(endWord)) {
							found = true;
							break;
						} else if (!visited.contains(newWord) && words.contains(newWord)) {
							queue.offer(newWord);
							visited.add(newWord);
						}
					}
				}
			}
			length++;
		}

		return found ? length : 0;
	}
}
