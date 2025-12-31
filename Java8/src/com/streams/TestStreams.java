package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(String[] args) {

		List<IPL> ipl = new ArrayList<IPL>();
		ipl.add(new IPL(7, "Dhoni", "CSK", 5));
		ipl.add(new IPL(18, "Virat", "RCB", 1));
		ipl.add(new IPL(45, "Rohit", "MI", 5));
		ipl.add(new IPL(33, "Pandya", "GT", 1));
		ipl.add(new IPL(96, "Iyer", "KKR", 3));
		ipl.add(new IPL(20, "Axar", "Delhi Capitals", 0));
		ipl.add(new IPL(45, "Klassen", "SRH", 2));
		ipl.add(new IPL(17, "Pant", "LSG", 0));
		ipl.add(new IPL(23, "Jaiswal", "RR", 1));
		ipl.add(new IPL(32, "Maxwell", "Punjab", 0));
		
		// SORT A IPL LIST

		List<IPL> sortedList = ipl.stream().sorted((ipl1, ipl2) -> Integer.compare(ipl1.getNo(), ipl2.getNo()))
				.toList();

		System.out.println("Sorted List:" + sortedList);

		// SORT A IPL LIST in reverse order

		List<IPL> reverseSortedList = ipl.stream().sorted((ipl1, ipl2) -> Integer.compare(ipl2.getNo(), ipl1.getNo()))
				.toList();

		System.out.println("Reverse Sorted list:" + reverseSortedList);

		// Print only even numbers using streams

		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(65, 84, 94, 35, 7, 82, 1, 7, 94, 65, 35, 7, 1));

		List<Integer> evenNums = nums.stream().filter(n -> n % 2 == 0).toList();
		System.out.println("Print Only even numbers in a list:" + evenNums);

		/// Sort the Numbers List
		List<Integer> sortedNums = nums.stream().sorted().toList();
		System.out.println("Print Sort numbers in a list:" + sortedNums);

		/// Sort the Numbers List in reverse order
		List<Integer> reverseSortedNums = nums.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println("Print Sort numbers in reverse order in a list:" + reverseSortedNums);

		// Find the team whose won more than 2
		List<IPL> iplcups = ipl.stream().filter((iplCups) -> iplCups.getCups() > 2).toList();
		System.out.println("Filter IPL teams whose won the sup more than 2:" + iplcups);

		// Increase the teams cups by 3
		Set<IPL> increasedCups = ipl.stream().map(team -> {
			team.setCups(team.getCups() + 3);
			return team;
		}).collect(Collectors.toSet());
		System.out.println("Every Team cups increased by 3:" + increasedCups);

		// Remove duplicates from a list
		List<Integer> removeDuplicates = nums.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Remove Duplicates from a list:" + removeDuplicates);

		/// Find the highest value from a list
		Integer highestValue = nums.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println("Highest Value from a list:" + highestValue);

		/// Find the Second Highest value from list which have duplicates
		Integer secondHighest = nums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("Second Highest in a list:" + secondHighest);

	}

}
