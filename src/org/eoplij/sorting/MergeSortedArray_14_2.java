/**
 * 
 */
package org.eoplij.sorting;

/**
 * @author divyeshsurana
 *
 */
public class MergeSortedArray_14_2 {
	// Assuming that nums1 has enough space to store both arrays
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx = m + n - 1, i = m - 1, j = n - 1;

		while (i >= 0 && j >= 0) {
			nums1[idx--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}

		while (idx >= 0 && j >= 0) {
			nums1[idx--] = nums2[j--];
		}
	}
}
