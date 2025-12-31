package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfCharacters {
	
	
	
	////given  a list as [A,B,C,D,A,E,G,B,Y,C,C,C,G] find the frequency of each character in the given list 
	 public static void main(String[] args) {
		
	
	ArrayList<Character> ar=new ArrayList<Character>(Arrays.asList('A','B','C','D','A','E','G','B','Y','C','C','C','G'));
	HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
	
	
	for(Character ch: ar) {
		
		if(!hs.containsKey(ch)) {
			hs.put(ch,1);
			
		}
		else
		{
			Integer count=hs.get(ch);
			hs.put(ch, count+1);
		}
	}
	System.out.println(hs);
	
	 
	 
	 
	 char[] strArr="Apple".toCharArray();
	 HashMap<String,Integer> freqMap=new HashMap<String,Integer>();
	 for(int i=0;i<strArr.length;i++) {
		 if(freqMap.containsKey(String.valueOf(strArr[i]))) {
			 Integer count=freqMap.get(String.valueOf(strArr[i]));
			 freqMap.put(String.valueOf(strArr[i]), count++);
			 
		 }else
			 freqMap.put(String.valueOf(strArr[i]),1);
	 }
	   System.out.println(freqMap);
	 }
	 
	 
	
	

}
