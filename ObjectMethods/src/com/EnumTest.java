package com;

public class EnumTest {
	
	public static void main(String[] args) {
		Day day=Day.MONDAY;
		System.out.println(day);
		
		StatusCode badRequest=StatusCode.BADREQUEST;
		System.out.println(badRequest.getCode());
	}
	
	

}
