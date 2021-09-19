/**
 * 
 */
package org.eoplij.searching;

/**
 * @author divyeshsurana
 *
 */
public class SearchSortedArrayForFirstAndLastOccurrence_12_1 {

	public int searchFirst(int[] nums, int target) {
		return findFirst(nums, target, 0, nums.length - 1);
	}

	// Variant
	public int searchNext(int[] nums, int target) {
		return findLast(nums, target, 0, nums.length - 1) + 1;
	}

	// Variant to find the range
	public int[] searchRange_v1(int[] nums, int target) {
		int l = findFirst(nums, target, 0, nums.length - 1);
		int h = l == -1 ? -1 : findLast(nums, target, l, nums.length - 1);

		return new int[] { l, h };
	}

	private int findFirst(int[] nums, int target, int l, int h) {
		int idx = -1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] >= target) {
				h = m - 1;
			} else {
				l = m + 1;
			}
			if (nums[m] == target) {
				idx = m;
			}
		}
		return idx;
	}

	private int findLast(int[] nums, int target, int l, int h) {
		int idx = -1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] <= target) {
				l = m + 1;
			} else {
				h = m - 1;
			}
			if (nums[m] == target) {
				idx = m;
			}
		}
		return idx;
	}

	public int[] searchRange_v2(int[] nums, int target) {
		int l = 0, h = nums.length - 1, m = -1;

		while (l <= h) {
			m = l + (h - l) / 2;
			if (nums[m] < target) {
				l = m + 1;
			} else if (nums[m] > target) {
				h = m - 1;
			} else {
				l = m;
				h = m;
				while (l - 1 >= 0 && nums[l - 1] == target) {
					l--;
				}
				while (h + 1 < nums.length && nums[h + 1] == target) {
					h++;
				}
				break;
			}
		}

		if (l > h) {
			l = -1;
			h = -1;
		}

		return new int[] { l, h };
	}

	// Variant to find either local minima or maxima
	public int findPeakElement_v1(int[] nums) {
		int l = 0, h = nums.length - 1, m = 0;
		while (l <= h) {
			m = l + (h - l) / 2;
			boolean left = m <= 0 || nums[m - 1] < nums[m];
			boolean right = m >= nums.length - 1 || nums[m + 1] < nums[m];
			if (left && right) {
				break;
			}
			if (left) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return m;
	}

	public int findPeakElement_v2(int[] nums) {
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int m = l + (h - l) / 2;
			if (nums[m] < nums[m + 1]) {
				l = m + 1;
			} else {
				h = m;
			}
		}
		return l;
	}

	// Variant
	public int findStringPrefix(String[] strings, String prefix) {

		int l = 0, h = strings.length - 1;

		while (l <= h) {
			int m = l + (h - l) / 2;
			if (strings[m].startsWith(prefix)) {
				return m;
			}
			if (strings[m].compareTo(prefix) > 0) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}

		return -1;
	}

}
