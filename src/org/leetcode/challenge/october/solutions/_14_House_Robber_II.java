/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class _14_House_Robber_II {
	public int rob(int[] nums) {
		int rob = 0;
		if (nums.length == 0)
			rob = 0;
		else if (nums.length == 1)
			rob = nums[0];
		else if (nums.length == 2)
			rob = Math.max(nums[0], nums[1]);
		else
			rob = Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
					helper(Arrays.copyOfRange(nums, 1, nums.length)));
		return rob;
	}

	private int helper(int[] nums) {
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		dp[2] = dp[0] + nums[2];

		for (int i = 3; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 3] + nums[i], dp[i - 2] + nums[i]);
		}

		return Math.max(dp[dp.length - 2], dp[dp.length - 1]);
	}
}
