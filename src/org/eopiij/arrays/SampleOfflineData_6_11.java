/**
 * 
 */
package org.eopiij.arrays;

import java.util.Arrays;
import java.util.Random;

import org.leetcode.common.Utils;

/**
 * @author divyeshsurana
 *
 */
public class SampleOfflineData_6_11 {
	public int[] randomSampling_v1(int[] nums, int size) {
		for (int i = 0; i < size; i++) {
			int random = (int) (Math.random() * nums.length);
			Utils.swap(nums, i, random);
		}
		return Arrays.copyOf(nums, size);
	}

	public static void randomSampling_v2(int[] nums, int k) {
		Random gen = new Random();
		for (int i = 0; i < k; ++i) {
			// Generate a random int in [i, A.size() - 1].
			Utils.swap(nums, i, i + gen.nextInt(nums.length - i));
		}
	}
}
