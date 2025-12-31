package com;

public class TestCalculator {

	public static void main(String[] args) {

		Calculator cal = (int a, int b) -> {
			System.out.println (a + b);
		};
		cal.add(45,45);
	}

}
