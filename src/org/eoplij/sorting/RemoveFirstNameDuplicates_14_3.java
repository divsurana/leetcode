/**
 * 
 */
package org.eoplij.sorting;

import java.util.Collections;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class RemoveFirstNameDuplicates_14_3 {
	public void removeDuplicates_v1(List<List<String>> names) {
		Collections.sort(names, (a, b) -> a.get(0).compareTo(b.get(0)));
		for (int i = 1; i < names.size(); i++) {
			if (names.get(i).get(0).equals(names.get(i - 1).get(0))) {
				names.remove(i);
			}
		}
	}

	// Avoid remove which is an O(n - i) operation for an ArrayList. We assume
	// this is an ArrayList since we work with the indices here.
	public void removeDuplicates_v2(List<List<String>> names) {
		Collections.sort(names, (a, b) -> a.get(0).compareTo(b.get(0)));
		int idx = 0;
		for (int i = 1; i < names.size(); i++) {
			if (!names.get(i).get(0).equals(names.get(idx).get(0))) {
				names.set(++idx, names.get(i));
			}
		}
		names.subList(++idx, names.size()).clear();
	}
}
