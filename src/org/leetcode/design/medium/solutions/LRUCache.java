/**
 * 
 */
package org.leetcode.design.medium.solutions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4243386866680446175L;
	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return getOrDefault(key, -1);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}

class LRUCache_v1 {
	Map<Integer, Integer> cache;
	LinkedList<Integer> keys;
	int capacity;

	public LRUCache_v1(int capacity) {
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
