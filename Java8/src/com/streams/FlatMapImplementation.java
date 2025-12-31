package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapImplementation {
	
	public static void main(String[] args) {
		
		List<List<String>> words=new ArrayList<>();
		words.add(Arrays.asList("Hi","Bye"));
		words.add(Arrays.asList("One","Two"));
		
		System.out.println(words);
		
		
		///Using flatmap
		
		List<String> wds=words.stream().flatMap(list->list.stream()).toList();
		System.out.println("Using flat map ->merges multiple collections in a single collections:"+wds);
		
		
		///Parllel Stream ----> un ordered stream
		
		List<Integer> nums=new ArrayList<Integer>(Arrays.asList(45,75,25,954,52,52));
		List<Integer> num=nums.stream().map(n->n+5).toList();
		System.out.println("Using normal streams:"+num);
		
		List<Integer> numParallelStream=nums.parallelStream().map(n->n+5).toList();
		System.out.println("Using parallel streams:"+numParallelStream);
		
		//Limit
		List<Integer> limit=nums.stream().limit(3).toList();
		System.out.println("Using limit of a string:"+limit);
		
		
		//allMatch
		boolean matched=nums.stream().allMatch(n->n%5==0);
		System.out.println("All Matched are not:"+matched);
		
		
		
	}

}
