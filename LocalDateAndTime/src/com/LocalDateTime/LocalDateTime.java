package com.LocalDateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTime {
	
	public static void main(String[] args) {
		
		
		LocalDate date=LocalDate.now();
		System.out.println(date);
		
		LocalDate date1=LocalDate.of(2000,05,04);
		System.out.println(date1);
		
		
		LocalDate date2=LocalDate.parse("2025-06-04");
		System.out.println(date2);
		
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfYear());
		System.out.println(date.getMonthValue());
		System.out.println(date.getChronology());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getEra());
		System.out.println(date.plusDays(2));
		System.out.println(date.minusDays(4));
		System.out.println(date.isAfter(date1));
		System.out.println(date.isBefore(date2));
		System.out.println(date.isEqual(date2));
		System.out.println(date.isLeapYear());
		System.out.println(date.MAX);
		System.out.println(date.MIN);
		System.out.println(date.compareTo(date2));
		System.out.println(date.EPOCH);
		System.out.println(date.hashCode());
		System.out.println(date.toString());
		
		
		
		
		
		
		
	}
	

}
