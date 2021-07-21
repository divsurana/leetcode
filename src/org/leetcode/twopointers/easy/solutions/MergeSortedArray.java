/**
 * 
 */
package org.leetcode.twopointers.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class MergeSortedArray {
	public void merge_v1(int[] nums1, int m, int[] nums2, int n) {
		int counter = m + n - 1;
		int i = m - 1, j = n - 1;
		for (; i >= 0 && j >= 0; counter--) {
			if (nums1[i] > nums2[j]) {
				nums1[counter] = nums1[i];
				i--;
			} else {
				nums1[counter] = nums2[j];
				j--;
			}
		}

		for (; j >= 0; j--, counter--) {
			nums1[counter] = nums2[j];
		}
	}

	public void merge_v2(int[] nums1, int m, int[] nums2, int n) {
		int idx = nums1.length - 1, i = m - 1, j = n - 1;

		while (i >= 0 && j >= 0) {
			nums1[idx--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}

		while (idx >= 0 && j >= 0) {
			nums1[idx--] = nums2[j--];
		}
	}
}
