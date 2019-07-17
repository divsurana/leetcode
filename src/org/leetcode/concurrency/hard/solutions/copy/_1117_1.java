/**
 * 
 */
package org.leetcode.concurrency.hard.solutions.copy;

import java.util.concurrent.Semaphore;

/**
 * @author divyesh_surana
 *
 */
public class _1117_1 {

	Semaphore getHydrogen;
	Semaphore getOxygen;

	public _1117_1() {
		this.getHydrogen = new Semaphore(2);
		this.getOxygen = new Semaphore(0);
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		getHydrogen.acquire();
		releaseHydrogen.run();
		if (getHydrogen.availablePermits() == 0) {
			getOxygen.release();
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {

		// releaseOxygen.run() outputs "H". Do not change or remove this line.
		getOxygen.acquire();
		releaseOxygen.run();
		getHydrogen.release(2);

	}
}