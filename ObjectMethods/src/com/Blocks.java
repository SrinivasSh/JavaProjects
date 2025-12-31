package com;

public class Blocks {
	
	static int a;
	int b;
	
	
	private Blocks(){
		System.out.println("This is from Constructor Block");
	}
	
	
	static{
		System.out.println("This is from Static Block");
		a=10;
		System.out.println(a);
	}
	public static void main(String[] args) {
		System.out.println("This is from main block");
		
		
		Blocks block=new Blocks();
		
	}
	
	static {
		System.out.println("This is from Second Static Block");
	}
	
	{
		System.out.println("This is from Instance Block");
		
		a=45;b=95;
		System.out.println(a+b);
		System.out.println(b);
	}

}
