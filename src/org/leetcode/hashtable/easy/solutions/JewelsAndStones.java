/**
 * 
 */
package org.leetcode.hashtable.easy.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		int total = 0;
		Set<Character> set = new HashSet<>();
		for (char c : J.toCharArray()) {
			set.add(c);
		}
		for (char c : S.toCharArray()) {
			if (set.contains(c)) {
				total++;
			}
		}
		return total;
	}
}
