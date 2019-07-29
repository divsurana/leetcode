/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class _950_1 {
	public int[] deckRevealedIncreasing(int[] deck) {
		int[] result = new int[deck.length];
		boolean add = true;
		Arrays.sort(deck);
		int index = 0;

		for (int i = 0; i < deck.length; i++) {
			boolean notAdded = true;

			while (notAdded) {
				if (result[index] == 0) {
					if (add) {
						result[index] = deck[i];
						add = false;
						notAdded = false;
					} else {
						add = true;
					}
				}
				index = (index + 1) % deck.length;
			}

		}

		return result;
	}
}
