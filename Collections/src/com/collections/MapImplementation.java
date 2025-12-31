package com.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapImplementation {
	
	public static void main(String[] args) {
		HashMap<String,Integer> hsm=new HashMap<String,Integer>();
		hsm.put("Engish",45);
		hsm.put("Social", 64);
		hsm.put("Telugu", 92);
		hsm.put("Biology", 97);
		hsm.put("Engish", 75);
		hsm.put("Social", 49);
		hsm.put("Maths", 99);
		hsm.put("Hindi", null);
		hsm.put("Physics", 85);
		hsm.put(null, null);
		hsm.put(null, null);
		hsm.put(null, 45);
		
		
		System.out.println("Using Hash map:"+hsm);
		
		
		
		TreeMap<String,Integer> tm=new TreeMap<String,Integer>();
		tm.put("Engish",45);
		tm.put("Social", 64);
		tm.put("Telugu", 92);
		tm.put("Biology", 97);
		tm.put("Engish", 75);
		tm.put("Social", 49);
		tm.put("Maths", 99);
		tm.put("Hindi", 60);
		tm.put("Physics", 85);
	
		System.out.println("Using Tree map:"+tm);
		
		
		LinkedHashMap<String,Integer> lm=new LinkedHashMap<String,Integer>();
		lm.put("Engish",45);
		lm.put("Social", 64);
		lm.put("Telugu", 92);
		lm.put("Biology", 97);
		lm.put("Engish", 75);
		lm.put("Social", 49);
		lm.put("Maths", 99);
		lm.put("Hindi", 60);
		lm.put("Physics", 85);
		lm.put(null, null);
		lm.put(null, null);
		lm.put(null, 45);
		System.out.println("Using Linked Hash map:"+lm);
		
		
		System.out.println(hsm.hashCode());
		System.out.println(hsm.containsKey("Social"));
		System.out.println(hsm.isEmpty());
		System.out.println(hsm.size());
		System.out.println(hsm.containsValue(65));
		System.out.println(hsm.remove("Social", 45));
		System.out.println(hsm.replace("Biology", 97, 84));
		System.out.println(hsm.toString());
		System.out.println(hsm.entrySet());
		System.out.println(hsm.values());
		System.out.println(hsm.get("Physics"));
		System.out.println(hsm.entrySet());
		
		
		System.out.println("===================================");
		
		System.out.println(lm.entrySet());
		System.out.println(tm.entrySet());
		
		
		
		///Map Iteration
		for(Map.Entry<String,Integer> entries:lm.entrySet()) {
			System.out.println(entries.getKey()+":"+entries.getValue() );
			
		}
		
		
		System.out.println("===================================");
		
		for(String K:lm.keySet()) {
			System.out.println(K+":"+lm.get(K));
		}
		
		
		
		

		
		
		
	}
	
		
	
	

}
