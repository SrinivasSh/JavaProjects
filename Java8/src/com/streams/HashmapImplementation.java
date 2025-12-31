package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class HashmapImplementation {

	public static void main(String[] args) {

		HashMap<Integer, String> names = new HashMap<Integer, String>();
		names.put(1, "Surya");
		names.put(2, "Vinay");
		names.put(3, "Mitta");
		names.put(4, "Jeevan");

		System.out.println(names);

		names.entrySet().stream().forEach(n -> System.out.println(n.getKey() + "-" + n.getValue()));
		List<Integer> key = names.keySet().stream().toList();
		System.out.println("Key List:" + key);
		List<String> val = names.values().stream().toList();
		System.out.println("Value List:" + val);

		// print a list of keys which are > =2 from a hash map

		List<Integer> keys = names.keySet().stream().filter(n -> n > 2).toList();
		System.out.println("List of keys greater than 2:" + keys);

		// Collectors.tomap

		Map<Integer, String> keyValues = names.entrySet().stream().filter(n -> n.getKey() > 2)
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		System.out.println("Using tomap function greater than 2:" + keyValues);

		// Find the courses having course 1 using hashmap
		Map<String, String> courses = new HashMap<String, String>();
		courses.put("Java", "Course1");
		courses.put("Python", "Course2");
		courses.put("Spring Boot", "Course1");
		courses.put("ALML", "Course1");
		courses.put("Data Science", "Course3");

		List<String> findCourses = courses.entrySet().stream().filter(n -> n.getValue().equals("Course1"))
				.map(entry -> entry.getKey()).toList();

		System.out.println("Find all courses having Course1:" + findCourses);

		// Count the even numbers in a list
		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(45, 70, 98, 30, 7, 5, 503));
		long evenCount = nums.stream().filter(n -> n % 2 == 0).count();
		System.out.println("Even count in a list:" + evenCount);
		
		//Sum of numbers in a list
		int sumOfNumbers=nums.stream().mapToInt(n->n).sum();
		System.out.println("Sum of numbers in a list:"+sumOfNumbers);
		
		// Sum of even numbers in a list
		int sumOfEvenNumbers = nums.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
		System.out.println("Sum of even numbers in a list:" + sumOfEvenNumbers);
		
		// Sum of odd numbers in a list
		int sumOfOddNumbers = nums.stream().filter(n -> n % 2 != 0).mapToInt(n -> n).sum();
		System.out.println("Sum of odd numbers in a list:" + sumOfOddNumbers);
		
		//Five Multiples in a lust
		List<Integer> fiveMultiples=nums.stream().filter(n->n%5==0).toList();
		System.out.println("Five multiples of a list:"+fiveMultiples);
		
		
		///Average of a list
		double averageList=nums.stream().mapToInt(n->n).average().getAsDouble();
		System.out.println("Average of list:"+averageList);
		
		
		//Max of a list
		int maxValue=nums.stream().mapToInt(n->n).max().getAsInt();
		System.out.println("Max value of a list:"+maxValue);
		
		//Min of a list
		int minValue=nums.stream().mapToInt(n->n).min().getAsInt();
		System.out.println("Min value of a list:"+minValue);
		
		
		
		//Product of all numbers in a list
		int multipleAllNumbers = nums.stream().reduce(1, (a,b)->a*b);
		System.out.println("Product of all numbers in a list:" + multipleAllNumbers);
		
		

	}

}
