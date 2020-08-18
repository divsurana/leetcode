/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class RandomizedSet {
	Map<Integer, Integer> values;
	List<Integer> keys;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		this.values = new HashMap<>();
		this.keys = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		boolean isAdd = this.values.putIfAbsent(val, keys.size()) == null ? true : false;
		if (isAdd) {
			this.keys.add(val);
		}
		return isAdd;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		Integer idx = this.values.remove(val);
		if (idx != null) {
			// Get last element in the list, remove it from the list. Replace
			// the index of the removed element from the set with the last
			// element.
			Integer last = this.keys.remove(keys.size() - 1);
			if (idx < this.keys.size()) {
				this.keys.set(idx, last);
				this.values.put(last, idx);
			}
		}
		return idx != null;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int randIdx = (int) (Math.random() * this.keys.size());
		return this.keys.get(randIdx);
	}
}
