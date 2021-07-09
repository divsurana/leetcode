/**
 * 
 */
package org.eopiij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 55. Jump Game -
// https://leetcode.com/problems/jump-game
public class AdvancingThroughAnArray_6_4 {

	// Calculate the max index reached from each index. After that back
	// propagate through the array and see if the next index we have in store
	// can be reached by any of the indices before it. If yes, then we can reach
	// the end of the array, if not, then we cannot.
	public boolean canJump_v1(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			nums[i] += i;
		}

		int next = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] >= next) {
				next = i;
			}
		}

		return next == 0;
	}

	// As long as we can reach a max index that is lower than the index we
	// are at, we keep pushing forward. The moment the index we are at is
	// greater than the max possible index we can reach, we stop and realize
	// that we cannot reach the end.
	public boolean canJump_v2(int[] nums) {
		int max = 0;
		for (int i = 0; i <= max && max < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]);
		}

		return max >= nums.length - 1;
	}

	// Let's say the range of the current jump is [i, end], max is the farthest
	// point that all points in [i,end] can reach. Once i reaches end, then
	// trigger another jump, and set the new end with max, then repeat.
	public int jump_v1(int[] nums) {
		int end = 0, max = 0, jumps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]);
			if (i == end) {
				end = max;
				jumps++;
			}
		}
		return jumps;
	}
}
