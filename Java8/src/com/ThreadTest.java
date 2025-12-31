package com;

public class ThreadTest {

	public static void main(String[] args) {

		MyThread mt = new MyThread();
		mt.start();

		Runnable rt = new Thread3(); /// Using Implements Runnable Interface
		Thread t3 = new Thread(rt);
		t3.start();

		//// using Anounuymous inner class
		Runnable t1 = new MyThread() {

			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("Thread 2 using anonymous Inner class");
			};
		};

		Thread t2 = new Thread(t1);
		t2.start();

		//// Using Functional Interfaces

		Runnable fi = () -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Thread using Functional Interface");
		};
		Thread t4 = new Thread(fi);
		t4.start();

	}

}
