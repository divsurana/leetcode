/**
 * 
 */
package org.leetcode.math.medium.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class DetectSquares {
	class DetectSquares_v1 {
		Map<Integer, Set<Point>> xAxisPointMatch;
		Map<Integer, Set<Point>> yAxisPointMatch;
		Map<Point, Integer> points;
		Map<Point, Integer> result;

		class Point {
			int x;
			int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public boolean equals(Object o) {
				Point other = (Point) o;
				return this.x == other.x && this.y == other.y;
			}

			@Override
			public int hashCode() {
				return this.x * 31 + this.y;
			}
		}

		public DetectSquares_v1() {
			xAxisPointMatch = new HashMap<>();
			yAxisPointMatch = new HashMap<>();
			points = new HashMap<>();
			result = new HashMap<>();
		}

		public void add(int[] point) {
			int x = point[0], y = point[1];
			Point pointObj = new Point(x, y);
			xAxisPointMatch.putIfAbsent(x, new HashSet<>());
			xAxisPointMatch.get(x).add(pointObj);
			yAxisPointMatch.putIfAbsent(y, new HashSet<>());
			yAxisPointMatch.get(y).add(pointObj);
			points.put(pointObj, points.getOrDefault(pointObj, 0) + 1);
			// Clear results since this point could change the result for any
			// number
			// of points
			result.clear();
		}

		public int count_v1(int[] point) {
			int x = point[0], y = point[1], count = 0;
			Point p = new Point(x, y);
			// Check if we have already calculated for this point
			if (result.containsKey(p)) {
				return result.get(p);
			}

			if (xAxisPointMatch.containsKey(x) && yAxisPointMatch.containsKey(y)) {
				Set<Point> xMatch = xAxisPointMatch.get(x);
				Set<Point> yMatch = yAxisPointMatch.get(y);

				for (Point xPoint : xMatch) {
					// Make sure its not the same point
					if (xPoint.y != y) {
						int yDist = Math.abs(y - xPoint.y);
						for (Point yPoint : yMatch) {
							int xDist = Math.abs(x - yPoint.x);
							// Make sure both points are equidistant from the
							// given
							// point
							if (xDist == yDist) {
								// The only possible point to make the square
								Point fourthPoint = new Point(yPoint.x, xPoint.y);
								if (points.containsKey(fourthPoint)) {
									count += points.get(xPoint) * points.get(yPoint) * points.get(fourthPoint);
								}
							}
						}
					}
				}
			}
			result.put(p, count);
			return count;
		}
	}

	// Slower but cleaner and less space intensive
	class DetectSquares_v2 {
		// Since the limit on point is 1000
		int[][] map = new int[1001][1001];
		int[][] directions = new int[][] { { 1, -1 }, { -1, 1 }, { 1, 1 }, { -1, -1 } };
		// This caching makes all the difference
		Map<String, Integer> result;

		public DetectSquares_v2() {
			result = new HashMap<>();
		}

		public void add(int[] point) {
			map[point[0]][point[1]]++;
			result.clear();
		}

		public int count(int[] point) {
			int count = 0;
			String p = point[0] + "," + point[1];
			if (result.containsKey(p)) {
				return result.get(p);
			}

			for (int[] d : directions) {
				int x = point[0], y = point[1];
				// Going through the length of the square from 1 to 1000
				for (int i = 1; i <= 1000; i++) {
					x += d[0];
					y += d[1];
					if (!isValid(x, y)) {
						break;
					}
					count += map[x - i * d[0]][y] * map[x][y - i * d[1]] * map[x][y];
				}
			}
			result.put(p, count);
			return count;
		}

		private boolean isValid(int x, int y) {
			return x >= 0 && x <= 1000 && y >= 0 && y <= 1000;
		}
	}

	// Cleaner but nothing is as fast as the first one
	class DetectSquares_v3 {
		Map<String, Integer> map;
		// This caching makes all the difference
		Map<String, Integer> result;

		public DetectSquares_v3() {
			map = new HashMap<>();
			result = new HashMap<>();
		}

		public void add(int[] point) {
			String p = point[0] + "," + point[1];
			map.put(p, map.getOrDefault(p, 0) + 1);
			result.clear();
		}

		public int count(int[] point) {
			int x = point[0], y = point[1], count = 0;
			String po = x + "," + y;
			if (result.containsKey(po)) {
				return result.get(po);
			}

			for (String p : map.keySet()) {
				int nx = Integer.valueOf(p.split(",")[0]), ny = Integer.valueOf(p.split(",")[1]);
				// Checking if this point can be an opposite point
				if (nx != x && ny != y && Math.abs(nx - x) == Math.abs(ny - y)) {
					count += map.getOrDefault(nx + "," + y, 0) * map.getOrDefault(x + "," + ny, 0) * map.get(p);
				}
			}

			result.put(po, count);
			return count;
		}
	}

}
