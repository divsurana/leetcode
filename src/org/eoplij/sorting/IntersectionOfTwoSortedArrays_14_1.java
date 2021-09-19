/**
 * 
 */
package org.eoplij.sorting;

import java.util.Arrays;

/**
 * @author divyeshsurana
 *
 */
public class IntersectionOfTwoSortedArrays_14_1 {
	// Arrays are already sorted. Can use set to make things cleaner as well.
	public int[] intersection(int[] nums1, int[] nums2) {
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				if (k == 0 || nums1[k - 1] != nums1[i]) {
					nums1[k++] = nums1[i];
				}
				i++;
				j++;
			}
		}
		return Arrays.copyOf(nums1, k);
	}
}
