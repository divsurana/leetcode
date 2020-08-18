/**
 * 
 */
package org.leetcode.twopointers.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
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
}
