/**
 * 
 */
package org.eoplij.heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author divyeshsurana
 *
 */
public class ComputeKClosestStars_11_4 {
	class Star implements Comparable<Star> {
		double x;
		double y;
		double z;

		public Star(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Star o) {
			return Double.compare(this.x * this.x + this.y * this.y + this.z * this.z,
					o.x * o.x + o.y * o.y + o.z * o.z);
		}
	}

	public Star[] getKClosest(Star[] stars, int k) {
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		Star[] closest = new Star[k];
		int i = 0;
		while (i < k) {
			maxHeap.offer(stars[i]);
		}

		while (i < stars.length) {
			// if star closer than the farthest star in the heap
			if (stars[i].compareTo(maxHeap.peek()) < 0) {
				maxHeap.poll();
				maxHeap.offer(stars[i]);
			}
			i++;
		}

		i = 0;
		while (!maxHeap.isEmpty()) {
			closest[i++] = maxHeap.poll();
		}
		return closest;
	}

	public int[][] kClosest(int[][] points, int k) {
		Comparator<int[]> comparator = (i1, i2) -> Integer.compare(i1[0] * i1[0] + i1[1] * i1[1],
				i2[0] * i2[0] + i2[1] * i2[1]);
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, comparator.reversed());
		int[][] closest = new int[k][2];

		int i = 0;
		while (i < k) {
			maxHeap.offer(points[i++]);
		}

		while (i < points.length) {
			if (comparator.compare(points[i], maxHeap.peek()) < 0) {
				maxHeap.poll();
				maxHeap.offer(points[i]);
			}
			i++;
		}

		i = 0;
		while (!maxHeap.isEmpty()) {
			closest[i++] = maxHeap.poll();
		}
		return closest;
	}
}
