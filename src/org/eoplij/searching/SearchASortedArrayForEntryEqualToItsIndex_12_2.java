package org.eoplij.searching;

public class SearchASortedArrayForEntryEqualToItsIndex_12_2 {
	public int searchEntryEqualToIndex(int[] nums) {
		int l = 0, h = nums.length - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] < m) {
				l = m + 1;
			} else if (nums[m] > m) {
				h = m - 1;
			} else {
				return m;
			}
		}
		return -1;
	}
}
