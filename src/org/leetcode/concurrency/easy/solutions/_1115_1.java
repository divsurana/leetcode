/**
 * 
 */
package org.leetcode.concurrency.easy.solutions;

import java.util.concurrent.Semaphore;

/**
 * @author divyesh_surana
 *
 */
public class _1115_1 {

	private int n;
	private Semaphore isFoo;
	private Semaphore isBar;

	public _1115_1(int n) {
		this.n = n;
		this.isFoo = new Semaphore(1);
		this.isBar = new Semaphore(0);
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			// printFoo.run() outputs "foo". Do not change or remove this line.
			isFoo.acquire();
			printFoo.run();
			isBar.release();

		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			// printBar.run() outputs "bar". Do not change or remove this line.
			isBar.acquire();
			printBar.run();
			isFoo.release();

		}
	}
}