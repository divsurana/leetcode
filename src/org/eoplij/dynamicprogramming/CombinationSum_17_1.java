/**
 * 
 */
package org.eoplij.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class CombinationSum_17_1 {
	public static int combinationSum(int[] candidates, int target) {
		int[] dp = new int[target + 1];

		for (int i = 1; i <= target; i++) {
			Set<Integer> passed = new HashSet<>();
			for (int candidate : candidates) {
				dp[i] += i == candidate ? 1 : i > candidate && !passed.contains(candidate) ? dp[i - candidate] : 0;
				// dp[i] += i == candidate ? 1
				// : i > candidate && !passed.contains(candidate) ?
				// dp[candidate] * dp[i - candidate] : 0;
				if (i > candidate) {
					passed.add(i - candidate);
				}
			}
			System.out.println(dp[i]);
		}

		return dp[target];

	}
	
	public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        
        for (int num: nums) {
            if (num < target + 1) dp[num] = 1;
        }
        
        for (int i = 1; i <= target; i++) {
            Set<Integer> covered = new HashSet<>();
            for (int num: nums) {
                if (!covered.contains(num)) dp[i] += num < i ? dp[i - num] * dp[num] : 0;
                covered.add(i - num);
            }
        }
        
        return dp[target];
    }

	public static void main(String[] args) {
		System.out.println(CombinationSum_17_1.combinationSum4(new int[] { 2, 3, 5 }, 8));
	}

}
