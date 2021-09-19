/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class FindOriginalArrayFromDoubledArray {
	// Used array as map for faster performance, but a good solution would be
	// using a map
	public int[] findOriginalArray_v1(int[] changed) {
		if (changed.length % 2 != 0) {
			return new int[] {};
		}
		Arrays.sort(changed);
		int[] map = new int[100001];
		int i = 0, j = 0, n = changed.length;
		int[] original = new int[n / 2];

		for (int num : changed) {
			map[num]++;
		}

		while (i < n && j < n / 2) {
			if (changed[i] == 0) {
				if (map[changed[i]] > 0 && map[changed[i]] % 2 == 0) {
					original[j++] = changed[i];
					map[changed[i]] -= 2;
				}
			} else if (changed[i] <= map.length / 2 && map[changed[i]] > 0 && map[changed[i] * 2] > 0) {
				original[j++] = changed[i];
				map[changed[i]]--;
				map[changed[i] * 2]--;
			}
			i++;
		}

		return j == n / 2 ? original : new int[] {};
	}

	// Cleaner solution using a map
	public int[] findOriginalArray_v2(int[] changed) {
		if (changed.length % 2 != 0) {
			return new int[] {};
		}
		Arrays.sort(changed);
		Map<Integer, Integer> freq = new HashMap<>();
		int i = 0;
		int[] original = new int[changed.length / 2];

		for (int num : changed) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}

		for (int num : changed) {
			if (freq.containsKey(num)) {
				// decrement v, and remove if it is 0 since 0 corresponds to
				freq.compute(num, (k, v) -> --v == 0 ? null : v);
				original[i++] = num;
				if (!freq.containsKey(num * 2)) {
					return new int[] {};
				}
				freq.compute(num * 2, (k, v) -> --v == 0 ? null : v);
			}
		}

		return original;
	}

	// Fastest solution using the hashmap approach but an integer array instead
	// of map
	public int[] findOriginalArray_v3(int[] changed) {
		if (changed.length % 2 != 0) {
			return new int[] {};
		}
		Arrays.sort(changed);
		int[] map = new int[100001], original = new int[changed.length / 2];
		int i = 0;

		for (int num : changed) {
			map[num]++;
		}

		for (int num : changed) {
			if (map[num] > 0) {
				map[num]--;
				original[i++] = num;
				if (num > 50000 || map[num + num] == 0) {
					return new int[] {};
				}
				map[num + num]--;
			}
		}

		return original;
	}
}
