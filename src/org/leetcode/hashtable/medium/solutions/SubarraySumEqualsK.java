/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class SubarraySumEqualsK {
	public int subarraySum_v1(int[] nums, int k) {
		int counter = 0;
		int dp[] = new int[nums.length];
		dp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i] + dp[i - 1];
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == k) {
				counter++;
			}
			for (int j = i + 1; j < dp.length; j++) {
				if (dp[j] - dp[i] == k) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int subarraySum_v2(int[] nums, int k) {
		int counter = 0;
		int sum = 0;
		Map<Integer, Integer> sums = new HashMap<>();
		// To catch sum that are equal to k
		sums.put(0, 1);

		for (int num : nums) {
			sum += num;
			counter += sums.getOrDefault(sum - k, 0);
			sums.put(sum, sums.getOrDefault(sum, 0) + 1);
		}

		return counter;
	}
}
