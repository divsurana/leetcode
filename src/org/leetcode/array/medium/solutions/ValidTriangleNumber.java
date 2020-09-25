package org.leetcode.array.medium.solutions;

import java.util.Arrays;

public class ValidTriangleNumber {
	public int triangleNumber_v1(int[] nums) {
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

	public int triangleNumber_v2(int[] nums) {
		int noOfTriangles = 0;

		Arrays.sort(nums);

		for (int i = nums.length - 1; i > 1; i--) {
			int start = 0;
			int end = i - 1;

			while (start < end) {
				if (nums[start] + nums[end] > nums[i]) {
					noOfTriangles += end - start;
					end--;
				} else {
					start++;
				}
			}
		}

		return noOfTriangles;
	}

	public int triangleNumber_v3(int[] nums) {
		Arrays.sort(nums);
		int result = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] > nums[k]) {
						result++;
					} else {
						break;
					}
				}
			}
		}

		return result;
	}
}
