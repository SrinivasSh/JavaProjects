package com;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread1 is from My Thread class using extends Thread");
	}

}


class Thread3 implements Runnable{

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread3 is from My Thread class using implements Runnable");
		
		
	}
	
}

