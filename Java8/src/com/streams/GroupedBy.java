package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupedBy {
	
	public static void main(String[] args) {
		
		List<String> fruits=new ArrayList<String>(Arrays.asList("Apple","Banana","Mango","Apple","Guava","Grapes"));
		System.out.println(fruits);
		
		
		//Count of fruits with starts with specific characterss
		long countOfFruits=fruits.stream().filter(n->n.startsWith("A")).count();
		System.out.println("Find the fruits starts with A:"+countOfFruits);
		
		///Find the String Frequency by grouping by
		Map<String,Long> stringFrequency=fruits.stream().collect((Collectors.groupingBy(Function.identity(),Collectors.counting())));
		System.out.println("String Frequency:"+stringFrequency);
		
		///FIND THE CHARACTERS FREQUENCY 
		String fruit="Apple";
		Map<Character, Long> charFrequency=fruit.chars().mapToObj(n->(char)n).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("CHARACTER FREQUENCY IN A STRING:"+charFrequency);
		
		
		
		///Convert arrays to stream
		int [] arr= {1,2,3,4,5,6,7};
		Arrays.stream(arr).filter(n->n%2==0).forEach(n->System.out.println("Find even numbers using arrays:"+n));
		
		
		//reduce()  concatenate of string
		String fruitsConCat=fruits.stream().reduce("",(a,b)->a+" "+b);
		System.out.println("Concatenate of string in a list using reduce method:"+fruitsConCat);
		
		
	}

}
