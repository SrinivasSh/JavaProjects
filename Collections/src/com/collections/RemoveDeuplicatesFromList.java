package com.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDeuplicatesFromList {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(14, 52, 7, 759, 14, 70, 7, 79, 52));
		System.out.println(arr);

		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (Integer listArray : arr) {
			if (!arrList.contains(listArray)) {
				arrList.add(listArray);
			}
		}
		System.out.println(arrList);

	}
}
