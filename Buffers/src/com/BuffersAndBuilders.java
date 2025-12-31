package com;

import java.util.Random;

public class BuffersAndBuilders {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("java");
		sb.append(" Technology");
		sb.insert(4, ",");
		sb.replace(6, 6, "Latest");
		sb.delete(4,5);
		System.out.println(sb.reverse());
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		System.out.println(sb.reverse());
		System.out.println(sb.hashCode());
		System.out.println(sb.charAt(5));
		System.out.println(sb.isEmpty());
		System.out.println(sb.codePointAt(1));
		System.out.println(sb.codePointBefore(1));
		System.out.println(sb.compareTo(sb));
		System.out.println(sb.equals(sb));
		System.out.println(sb.substring(4,9));
		//////////////////////////////
		System.out.println("Math Class:-`````````````````````````");
		System.out.println(Math.abs(-55));
		System.out.println(Math.max(45,-55));
		System.out.println(Math.min(45,-55));
		System.out.println(Math.ceil(45.1));
		System.out.println(Math.floor(45.9));
		System.out.println(Math.round(5.7));
		System.out.println(Math.pow(50,32));
		System.out.println(Math.sqrt(64));
		System.out.println(Math.cbrt(625));
		System.out.println(Math.PI);
		System.out.println(Math.sin(Math.PI/4));
		System.out.println(Math.random());
		
		System.out.println("Integer Class:-`````````````````````````");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.BYTES);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println("Random class:-/////////////////////////");
		Random rm=new Random();
		System.out.println(rm.nextInt());
		System.out.println(rm.nextInt(100));
		System.out.println(rm.nextInt(100,400));
		System.out.println(rm.nextFloat(15));
		System.out.println(rm.nextDouble(100));
		
		
		
		
		
		
		
		
		
		
		
	}

}
