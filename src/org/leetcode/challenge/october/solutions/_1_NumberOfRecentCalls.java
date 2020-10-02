/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author divyesh_surana
 *
 */
public class _1_NumberOfRecentCalls {
	class RecentCounter_v1 {
		List<Integer> counters;

		public RecentCounter_v1() {
			this.counters = new ArrayList<>();
		}

		public int ping(int t) {
			this.counters.add(t);
			int i = 0;
			for (; i < this.counters.size(); i++) {
				if (this.counters.get(i) >= t - 3000)
					break;
			}
			return this.counters.size() - i;
		}
	}

	class RecentCounter_v2 {
		Queue<Integer> counters;

		public RecentCounter_v2() {
			this.counters = new LinkedList<>();
		}

		public int ping(int t) {
			this.counters.offer(t);
			// Don't need the previous counters since the pings are guaranteed to be in
			// ascending order
			while (this.counters.peek() < t - 3000)
				this.counters.poll();
			return this.counters.size();
		}
	}

	/**
	 * Your RecentCounter object will be instantiated and called as such:
	 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
	 */
}
