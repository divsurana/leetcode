/**
 * 
 */
package org.leetcode.design.medium.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class LRUCache {
	Map<Integer, Integer> cache;
	LinkedList<Integer> keys;
	int capacity;

	public LRUCache(int capacity) {
		this.cache = new HashMap<>();
		this.keys = new LinkedList<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		int value = -1;
		if (keys.contains(key)) {
			keys.remove(new Integer(key));
			keys.add(key);
			value = cache.get(key);
		}
		return value;
	}

	public void put(int key, int value) {
		if (keys.contains(key)) {
			keys.remove(new Integer(key));
		} else if (keys.size() == capacity) {
			keys.pop();
		}
		keys.add(key);
		cache.put(key, value);
	}

	/**
	 * Your LRUCache object will be instantiated and called as such: LRUCache
	 * obj = new LRUCache(capacity); int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}
