/**
 * 
 */
package org.leetcode.string.easy.solutions;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author divyeshsurana
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix_v1(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		StringBuffer buffer = new StringBuffer();
		Stack<Character> chars = new Stack<>();
		String fStr = strs[0];
		for (char c : fStr.toCharArray()) {
			chars.push(c);
		}

		for (int i = 1; !chars.isEmpty() && i < strs.length; i++) {
			String str = strs[i];
			if (str.length() > chars.size()) {
				str = str.substring(0, chars.size());
			} else {
				while (chars.size() > str.length()) {
					chars.pop();
				}
			}
			Stack<Character> anotherStack = new Stack<>();
			int pos = chars.size() - 1;
			while (!chars.isEmpty()) {
				if (chars.peek() == str.charAt(pos)) {
					anotherStack.push(chars.pop());
				} else {
					chars.pop();
					while (!anotherStack.isEmpty()) {
						anotherStack.pop();
					}
				}
				pos--;
			}
			while (!anotherStack.isEmpty()) {
				chars.push(anotherStack.pop());
			}
		}

		Iterator<Character> itr = chars.iterator();
		while (itr.hasNext()) {
			buffer.append(itr.next());
		}

		return buffer.toString();
	}
}
