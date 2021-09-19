/**
 * 
 */
package org.eoplij.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author divyeshsurana
 *
 */
public class SampleOnlineData_6_12 {
	// Assumption: there are at least k elements in the stream.
	public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k) {
		List<Integer> runningSample = new ArrayList<>(k);
		// Stores the first k elements.
		for (int i = 0; sequence.hasNext() && i < k; ++i) {
			runningSample.add(sequence.next());
		}
		// Have read the first k elements.
		int numSeenSoFar = k;
		Random randldxGen = new Random();
		while (sequence.hasNext()) {
			Integer x = sequence.next();
			++numSeenSoFar;
			// Generate a random number in [0, numSeenSoFar], and if this number
			// is in
			// [0, k - 1], we replace that element from the sample with x.
			final int idxToReplace = randldxGen.nextInt(numSeenSoFar);
			if (idxToReplace < k) {
				runningSample.set(idxToReplace, x);
			}
		}
		return runningSample;
	}
}
