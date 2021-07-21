/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
public class ReplaceAndRemove_7_4 {
	public static int replaceAndRemove(int size, char[] s) {
		// Forward iteration: remove "b"s and count the number of "a"s.
		int writeldx = 0, aCount = 0;
		for (int i = 0; i < size; ++i) {
			if (s[i] != 'b') {
				s[writeldx++] = s[i];
			}
			if (s[i] == 'a') {
				++aCount;
			}
		}
		// Backward iteration: replace "a"s with "dd"s starting from the end.
		int curldx = writeldx - 1;
		writeldx = writeldx + aCount - 1;
		final int finalSize = writeldx + 1;
		while (curldx >= 0) {
			if (s[curldx] == 'a') {
				s[writeldx--] = 'd';
				s[writeldx--] = 'd';
			} else {
				s[writeldx--] = s[curldx];
			}
			--curldx;
		}
		return finalSize;
	}

	// Variant - Merge two sorted arrays (this one has the first array having
	// enough space for both the arrays)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx = nums1.length - 1, i = m - 1, j = n - 1;

		while (i >= 0 && j >= 0) {
			nums1[idx--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}

		while (idx >= 0 && j >= 0) {
			nums1[idx--] = nums2[j--];
		}
	}
}
