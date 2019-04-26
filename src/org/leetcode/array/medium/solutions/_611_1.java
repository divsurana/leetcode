package org.leetcode.array.medium.solutions;

import java.util.Arrays;

public class _611_1 {
	public int triangleNumber(int[] nums) {
		int noOfTriangles = 0;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int one = nums[i];
			for (int j = i + 1; j < nums.length - 1; j++) {
				int two = nums[j];
				for (int k = j + 1; k < nums.length; k++) {
					int three = nums[k];
					if (one + two > three) {
						noOfTriangles++;
					} else {
						break;
					}
				}

			}

		}

		return noOfTriangles;
	}
}
