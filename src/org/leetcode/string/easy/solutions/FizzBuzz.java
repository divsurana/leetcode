/**
 * 
 */
package org.leetcode.string.easy.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class FizzBuzz {
	public List<String> fizzBuzz_v1(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			String num = i % 3 == 0 ? i % 5 == 0 ? "FizzBuzz" : "Fizz" : i % 5 == 0 ? "Buzz" : Integer.toString(i);
			result.add(num);
		}
		return result;
	}

	public List<String> fizzBuzz_v2(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			StringBuffer buffer = new StringBuffer();
			if (i % 3 == 0) {
				buffer.append("Fizz");
			}
			if (i % 5 == 0) {
				buffer.append("Buzz");
			}
			if (buffer.length() == 0) {
				buffer.append(i);
			}
			result.add(buffer.toString());
		}
		return result;
	}
}
