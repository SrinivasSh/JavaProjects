package com.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
	
	public static void main(String[] args) {
		
		
		ArrayList<Student> stud=new ArrayList<Student>();
		
		stud.add(new Student(41,"Harish","Vizag"));
		stud.add(new Student(75,"Devansh","Bangalore"));
		stud.add(new Student(11,"Srinivas","Srikakulam"));
		stud.add(new Student(52,"Maharashi","Hyderbad"));
		stud.add(new Student(78,"Tarak","Rajamundry"));
		stud.add(new Student(96,"Viayshnavi","Srikakulam"));
		
		
		Collections.sort(stud);
		
		for(Student std:stud) {
		System.out.println(std);
		}
		
		
	}

}
