package com.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrrayListImpl {
	
	public static void main(String[] args) {
		
		
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("Srinu");
		arrayList.add("Ballu");
		arrayList.add("Venu");
		arrayList.add("Pranathi");
		arrayList.add("Suresh");
		arrayList.add("Ballu");
		arrayList.add("Venu");
		System.out.println(arrayList.contains("Suresh"));
		//System.out.println(arrayList.containsAll(null));
		System.out.println(arrayList.hashCode());
		System.out.println(arrayList.indexOf("Ballu"));
		System.out.println(arrayList.isEmpty());
		System.out.println(arrayList.lastIndexOf("venu"));
		System.out.println(arrayList.remove("Ballu"));
		System.out.println(arrayList.remove(1));
		System.out.println(arrayList.set(1, "VIZAY"));
		System.out.println(arrayList.toString());
		System.out.println(arrayList.lastIndexOf("venu"));
		System.out.println(arrayList.size());
		System.out.println(arrayList.get(3));
		System.out.println(arrayList);
		arrayList.clear();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Employee emp1=new Employee(10,"Hari","Java");
		Employee emp2=new Employee(20,"Harsha","Machine Learning");
		Employee emp3=new Employee(30,"Harini","Python");
		Employee emp4=new Employee(40,"Hemanth","Service Now");
		
		
		
		ArrayList<Employee> emp=new ArrayList<Employee>();
		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);
		emp.add(emp4);
		
		
		System.out.println(emp.get(0));
		
		System.out.println("  USING NORMAL FOR LOOP");
		for(int i=0;i<emp.size();i++)
		{
			System.out.println(emp.get(i));
		}
		System.out.println("  ----USING  FOR EACH LOOP-----");
		for(Employee employee:emp)
		{
			System.out.println(employee);
		}
		
		System.out.println("~~~~~~~~~~~~USING ITERATOR~~~~~~~~~~~~~");
		Iterator<Employee> itr=emp.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
		
	}
	
}	
class Employee{
	
	int id;
	String name;
	String skills;
	
	public Employee() {
		super();
		
	}

	public Employee(int id, String name, String skills) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}
	
	
	
	
}


