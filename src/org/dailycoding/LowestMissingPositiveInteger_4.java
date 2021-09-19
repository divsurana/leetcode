/**
 * 
 */
package org.dailycoding;

/**
 * @author divyeshsurana
 *
 */
public class LowestMissingPositiveInteger_4 {
	public static int getLowest(int[] nums) {
		int lower = 1, upper = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num > 0) {
				if (num == lower) {
					lower++;
				} else if (num < upper) {
					upper = num;
				}
			}
		}

		return lower;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 4, -1, 1, 2 };
		System.out.println(getLowest(nums));
		nums = new int[] { 1, 2, 0 };
		System.out.println(getLowest(nums));
	}
}
