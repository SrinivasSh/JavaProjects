package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BubbleSort {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr=new ArrayList<Integer>(Arrays.asList(10,7,19,2,20,14));
		
		for(int i=0;i<arr.size()-1;i++) {
			for(int j=0;j<arr.size()-i-1;j++) {
				if(arr.get(j)>arr.get(j+1)) {
					int temp=arr.get(j);
					arr.set(j, arr.get(j+1));
					arr.set(j+1, temp);
					
				}
			}
			
		}
		System.out.println(arr);
		
		
		
		///USING COLLECTIONS CLASS
		Collections.sort(arr);
		System.out.println(arr);
		Collections.sort(arr,Collections.reverseOrder());
		System.out.println(arr);
		
		Collections.max(arr);
		System.out.println(arr);
		Collections.min(arr);
		System.out.println(arr);
		Collections.swap(arr, 0, 1);
		System.out.println(arr);
		Collections.addAll(arr, 9);
		System.out.println(arr);
		
		
	
		
		
		
		
		
		
		
	}

}
