package com;

public class Calculator {
	
	public static void main(String[] args) {
		Calculator cal=new Calculator();
		cal.sum();
		cal.sum(19,890);
		cal.sum(10,90,190);
		cal.sum(10,90,890,68);
		cal.sum(19,290,7808,8679);
		cal.sum(19,290);
		
	}

	
	public void sum(int... var) {    ///Variable Args
		int sum=0;
		for(int arr:var) {
			sum+=arr;
		}
		System.out.println(sum);
		
	}
}
