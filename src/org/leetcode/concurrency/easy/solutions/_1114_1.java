/**
 * 
 */
package org.leetcode.concurrency.easy.solutions;

import java.util.concurrent.Semaphore;

/**
 * @author divyesh_surana
 *
 */
public class _1114_1 {

	Semaphore run2, run3;

	public _1114_1() {
		run2 = new Semaphore(0);
		run3 = new Semaphore(0);
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		run2.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		run2.acquire();
		printSecond.run();
		run3.release();
	}

	public void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		run3.acquire();
		printThird.run();
	}
}