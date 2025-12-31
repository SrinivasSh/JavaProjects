package com.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeSet;

public class TreeSetAndLinkedHashSet {

	public static void main(String[] args) {

		TreeSet<Integer> ts = new TreeSet<Integer>(); /// Sorted in Ascending

		ts.add(10);
		ts.add(520);
		ts.add(70);
		ts.add(60);
		ts.add(50);
		ts.add(600);

		System.out.println(ts);

		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>(); /// Insertion Order
		lhs.add(10);
		lhs.add(520);
		lhs.add(70);
		lhs.add(60);
		lhs.add(50);
		lhs.add(1);

		System.out.println(lhs);

		HashSet<Student> hs = new HashSet<Student>();

		Student st1 = new Student(1, "SHIVA");
		Student st2 = new Student(2, "Jeevan");
		Student st3 = new Student(2, "Jeevan");

		System.out.println(st1.hashCode());
		System.out.println(st2.hashCode());
		System.out.println(st3.hashCode()); // Here Hash codes are different so it accepts duplicates to avoid this we
											// need to override hashcode

		hs.add(st1);
		hs.add(st2);
		hs.add(st3);

		Iterator<Student> itr = hs.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		//// Using Null Values
		HashSet<Integer> hs1 = new HashSet<Integer>();
		hs1.add(null);
		hs1.add(null);
		hs1.add(null);

		System.out.println("Using HashSet" + hs1); //// Accepts Single Null Values does not allow duplicates

		LinkedHashSet<Integer> lhs1 = new LinkedHashSet<Integer>();
		lhs1.add(null);
		lhs1.add(null);
		lhs1.add(null);

		System.out.println("Using Linked Hash set" + lhs1); //// Accepts Single Null Values does not allow duplicates

		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(null);
		arr1.add(null);
		arr1.add(1);
		arr1.add(null);

		System.out.println("Using Array List" + arr1); /// Allow duplicates and accepts infinite null values

//		TreeSet<Integer> ts1=new TreeSet<Integer>();   ///Does now allow  null values it compares null values so it throws NullPointerException
//		ts1.add(null);
//		
//		System.out.println("Using Tree set"+ts1);

	}

}

class Student {

	int id;
	String name;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {    
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + "]";
	}

}
